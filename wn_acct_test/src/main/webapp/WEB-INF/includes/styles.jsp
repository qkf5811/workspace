<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="${contextPath}/js/themes/default/easyui.css" />
<link rel="stylesheet" href="${contextPath}/js/themes/icon.css" />
<%-- <link rel="stylesheet" href="${contextPath}/css/demo.css" /> --%>

<script src="${contextPath}/js/jquery.min.js"></script>
<script src="${contextPath}/js/jquery.easyui.min.js"></script>
<script src="${contextPath}/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript"
	src="${contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script src="${contextPath}/js/main.js"></script>
<script src="${contextPath}/js/ajaxfileupload.js"></script>

<script type="text/javascript">
/* 	$(function() {
		$('.ca').each(function() {
			$(this).attr("onselectstart", "return false");
		})
	}); */

	function goTest(form) {
//		alert($(form).serialize());
		var param = $(form).serialize();
		var args = param.split("&");
		param = "";
		for (var i = 0; i < args.length; ++i) {
			var kv = args[i].split("=");
			var k = '"' + kv[0] + '"';
			var v = '"' + kv[1].trim() + '"'; 
			param += k + ':' + v;
			if (args.length -1 != i)
				param += ";"
		}
		param = "{" + param + "}";
		
		//调用远程接口
		$.post("test/action.do", {param:param}, function(data) {
			//alert(data);
			$('#console').val(data);
		});
	}

</script>

<style type="text/css">
	.cbox {
		width: 200px;
		height: 25;
		margin: 2px 20px auto auto ;
		border-radius: 5px;
//		border-color: #95B8E7;
		font-size: 16;
		letter-spacing: 2px;
	//	background: #e3efff;
		padding: 1px 2px 1px 2px;
		border: 0px;
	}
	.cbox:FOCUS {
	//	border-color: #4F7FC9;
		box-shadow: 0px 0px 5px #95B8E7;
	}
	
	.ca {
		-moz-user-select: none;
		display: block;
		width: 60px;
		height: 25px;
		border-radius: 3px;
		background: #4F7FC9;
		border-color: purple;
		color: white;
		margin: 5px auto ;
		text-align: center;
		font-size: 17;
		border: 1px solid purple;
		box-shadow: -3xp -3px 2px white inset;
	}
	.ca:HOVER {
		background: linear-gradient(180deg, #F0FFF0, #4F7FC9);
		color: white;
		cursor: pointer;
		border: 1px solid purple;
	}
	
	.ctable {
		width: 800px;
		margin: 0px auto ;
		border-radius: 2px;
		font-size: 16;
		background:#CDC9A5;
		color: #4F7FC9;
		
	}
	.ctable tr {
		text-align: center;
		font-size: 16;
		border-radius: 5px;
	}
	.ctable tr td{
		text-align: center;
		font-size: 16;
	}
	.ctable tr:hover{
		background: #E0EEE0;
		color: purple;
	}
</style>