<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${sessionScope.schoolName}学校综合管理平台</title>

<link rel="stylesheet" href="${contextPath}/js/themes/default/easyui.css" />
<link rel="stylesheet" href="${contextPath}/js/themes/icon.css" />
<link rel="stylesheet" href="${contextPath}/css/demo.css" />

<script src="${contextPath}/js/jquery.min.js"></script>
<script src="${contextPath}/js/jquery.easyui.min.js"></script>
<script src="${contextPath}/js/easyui-lang-zh_CN.js"></script>

<script src="${contextPath}/js/main.js"></script>
<script src="${contextPath}/js/ajaxfileupload.js"></script>

<style type="text/css">
body {
	text-align: center;
	margin: 0px;
	background-image:url(images/background.jpg);
	background-size:100% 100%; 
	background-attachment:fixed;
}


#div1 {
	margin: 100px auto;
	border: 0px solid #000;
	width: 400px;
	padding: 100px 70px 20px 70px;
}

</style>
</head>

<body>
	
	<div id="div1">
		<div style="margin: 20px 0;"></div>
		<div id="div" class="easyui-panel" title="${sessionScope.schoolName}学校综合管理平台"
			style="width: 400px; padding: 30px 70px 20px 70px;">
			<form id="loginForm" name="f" action="${contextPath}/j_spring_security_check" method="post" onkeydown="if(event.keyCode==13){login1();return false;}">
				<div style="margin-bottom: 10px">
					<label for="account">部门:</label> <input
															id="departmentByLogin" name="departmentByLogin"
															style="width: 100%; height: 40px; padding: 12px"
															data-options="prompt:'请您选择部门',iconCls:'',iconWidth:38">
				</div>
				<div style="margin-bottom: 10px">
					<label for="account">帐号:</label> <input class="easyui-combobox"
						id="account" name="j_username"
						style="width: 100%; height: 40px; padding: 12px"
						data-options="prompt:'请您输入帐号',iconCls:'',iconWidth:38">
				</div>
				<div style="margin-bottom: 20px">
					<label for="password">密码:</label> <input class="easyui-textbox"
						id="password" name="j_password" type="password"
						style="width: 100%; height: 40px; padding: 12px"
						data-options="prompt:'请您输入密码',iconCls:'icon-lock',iconWidth:38">
				</div>
				<!-- <div style="margin-bottom: 20px">
					<input type="checkbox" checked="checked"> <span>记住用户名</span>
				</div> -->
				<div region="south" border="false"
					style="text-align: center; padding: 5px 0;"></div>

			</form>
			<div style="text-align: center;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="login1()"> <span
					style="font-size: 14px;">登录</span>
				</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="cleardata()"> <span
					style="font-size: 14px;"> 重置</span>
				</a>
			</div>
		</div>
		
		<div id ="tipsDiv" style="display:none;">
		
			<p id="tips" align="left" style="font-size: 12px;color: red;">温馨提示:您当前使用的IE浏览器版本太低，建议使用IE10或更高版本！</p>
			
			
		</div>
		
	</div>
	

	<script type="text/javascript">
		function login() {
			var account = $("#account").val();
			var password = $("#password").val();

			$.post('user/login.do', {
				"account" : account,
				"password" : password
			}, function(data) {
				//var json=eval("("+data+")");

				//alert(json.status);
				if (data.status == "success")
					alert(data.status);
				//window.location=data;
			}, "json");

		}

		function login1() {
			if($("#account").combobox('getValue')==null) {
				$("#account").combobox('setValue', $("#account").combobox('getText'));
			}
			$('#loginForm').submit();
		}
		function cleardata() {
			$('#loginForm').form('clear');
		}

		function login2() {
			var account = $("#account").val();
			var password = $("#password").val();

			$.post('${contextPath}/j_spring_security_check', {
				"j_username" : account,
				"j_password" : password
			}, function(data) {
				//var json=eval("("+data+")");

				//alert(json.status);
				if (data.status == "success")
					alert(data.status);
				//window.location=data;
			}, "json");
		}
	</script>
	
	
	<script type="text/javascript">
    $(function () {
        var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/rv:([\d.]+)\) like gecko/)) ? Sys.ie = s[1] :
        (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
        (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
        if (Sys.ie<10){
        	/* $("#tips").hide(); */
        	$("#tipsDiv").show();
        }
        /* if (Sys.firefox){
        	$("#tipsDiv").show();
        } */
        	/* alert('IE: ' + Sys.ie); */
      /*   if (Sys.firefox) alert('Firefox: ' + Sys.firefox);
        if (Sys.chrome) alert('Chrome: ' + Sys.chrome);
        if (Sys.opera) alert('Opera: ' + Sys.opera);
        if (Sys.safari) alert('Safari: ' + Sys.safari); */
        });
	</script>


	<script type="text/javascript">
		$("#departmentByLogin").combotree({
			lines:true,
			url:"${contextPath}/user/findAllDepartment.do",
			onBeforeExpand:function(data){

				$("#departmentByLogin").combotree("tree").tree("options").url="${contextPath}/user/findAllDepartment.do";
			},onClick:function(data){

				$.post('user/getUserAccountForLogin.do',{
					departmentId:$("#departmentByLogin").combotree("tree").tree('getSelected').id
				},function(data){
					//返回的是string字符串，需要把字符串转成json对象
					var resultJson=JSON.parse(data);
					//添加一个下拉框元素"请选择"
					var firstSelectJson=JSON.parse("{\"account\":\"\",\"name\":\"请选择\"}");
					//使用unshift方法，在resultJson前面加上firstSelectJson
					resultJson.unshift(firstSelectJson);

					$("#account").combobox({
						valueField:'account',
						textField:'name',
						data:resultJson
					});
				});
			}/*,onSelect:function(data){
			 $(this).tree('toggle',data.target);
			 }*/
		});
	</script>
</body>
</html>
