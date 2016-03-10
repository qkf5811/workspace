<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
<!--
#body {
	border: 2px solid groove;
	border-radius: 25px;
	margin: 120px auto 120px auto;
	width: 800px;
	height: 450px;
}

#btn {
	width: 45px;
	height: 25px;
	border: 1px solid orange;
	border-radius: 5px;
	background: purple;
	color: white;
	text-decoration: none;
	float: right;
	font-size: 15px;
	text-align: center;
}

#btn:hover {
	background: orange;
	color: purple;
	box-shadow: 0px 0px 5px black;
	cursor: pointer;
}

#info {
	height: 100%;
	padding: 20px 40px;
	width: 100%;
	background: #C7EDCC;
	color: purple;
	border-redius: 20px;
	text-shadow: 0px 0px 2px orange;
	font-size: 13px;
}
-->
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快递信息查询</title>
</head>
<body style="background: linear-gradient(45deg, gray, white)">
	<div id="body">
		<fieldset style="border-radius: 25px">
			<legend>信息查询</legend>
			<div style="vertical-align: middle;">
				<div>
					<span>快递公司:</span> <select id="queryUrl">
						<optgroup label="以下自动识别">
							<option value="sto/queryExpress.do?code=">申通</option>
							<option value="sto/queryExpress.do?code=">圆通</option>
							<option value="sto/queryExpress.do?code=">中通</option>
							<option value="sto/queryExpress.do?code=">韵达</option>
						</optgroup>
					</select> <span>快递单号:</span> <input type="text" id="code"> <span>查询</span><input
						type="text" id="hours" style="width: 60px"><span>小时.</span>
					<b id="state"></b>
					<div onclick="queryStoBySetHours()" onkeypress="pressStoQuery(e)"
						id="btn">查询</div>
				</div>
			</div>
			<div>
				<textarea rows="12" cols="100" id="info" readonly="readonly"></textarea>
			</div>
		</fieldset>
	</div>
</body>

<script>
	//url
	var stoUrl =  "sto/querySto.do?code=";
	var infoSize = 0;
	var resultJson = "";
	function querySto(url) {
		var code = document.getElementById("code").value;
		var info = document.getElementById("info");
		console.log(code);
		if (code == "") {
			alert("单号不能为空!");
			return;
		}
		document.getElementById("state").innerHTML = "任务进行中...";
		document.getElementById("code").setAttribute("readonly", "readonly");
		document.getElementById("hours").setAttribute("readonly", "readonly");
		var xhr = new XMLHttpRequest();
		xhr.open("GET", url + code, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4)
				if (xhr.status == 200) {
					//alert(xhr.responseText);
					var jsonObject = xhr.responseText;
					//xhr = 1;
					//		console.log(jsonObject);
					resultJson = jsonObject;
					jsonObject = JSON.parse(jsonObject);
					var message = "";
					for (var i = 0; i < jsonObject.length; ++i) {
						message += "日期: " + jsonObject[i].date + "\t\t"
								+ jsonObject[i].send + "\t" + jsonObject[i].to
								+ "\n\n";
					}
					//

					//
					info.value = message;
					if (infoSize != jsonObject.length) {
						if (jsonObject.result != "failure") {
							infoSize = jsonObject.length;
							console.log("快件有新消息!");
							var xhr1 = new XMLHttpRequest();
							xhr1.open("POST", "center/sendMail.do", true);
							xhr1.setRequestHeader("Content-Type",
									"application/x-www-form-urlencoded");
							xhr1.send("json=" + resultJson);
							//				console.log("发送: " + resultJson);
							xhr1.onreadystatechange = function() {
								if (xhr1.readyState == 4)
									if (xhr1.status == 200) {
										var result = JSON
												.parse(xhr1.responseText);
										//			console.log("发送邮件结果: " + result);
										if (result.result == "success")
											console.log("send mail success!");
										else
											console.log("send mail failure!");
									}
							}
							//			alert("^_^快递信息有更新!");
						}
					}
				}
		}
	}

	function queryStoBySetHours() {
		var hours = document.getElementById("hours").value;
		alert("hours:" + hours);
		if (hours == '') {
			alert("持续时间不能为空!");
			return;
		}
		if (isNaN(hours)) {
			alert("非法时间!");
			return;
		}
		//开始的时间，毫秒数
		var now = new Date().getTime();
		//结束的毫秒数
		var end = hours * 60 * 60 * 1000 + now;
		//获取url
		var url = document.getElementById("queryUrl").value;
	//	console.log("url: " + url)
		querySto(url);

		var timer = setInterval("querySto('" + url + "')", 1000 * 60 * 2);
		var timer2 = setInterval(function() {
			var now = new Date().getTime();
			//			console.log("当前时间:" + now + ", endTime:" + end);
			if (now > end) {
				clearInterval(timer);
				//				alert("已完成持续时间任务!");
				document.getElementById("state").innerHTML = "任务结束.";
				document.getElementById("code").removeAttribute("readonly");
				document.getElementById("hours").removeAttribute("readonly");
				clearInterval(timer2);
			}

		}, 1100 * 60 * 2);
	}
</script>
</html>