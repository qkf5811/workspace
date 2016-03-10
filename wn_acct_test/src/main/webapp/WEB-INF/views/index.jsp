<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/includes/styles.jsp"%>
<style type="text/css">
#main {
	margin: 80px auto auto 80px;;
	width: 80%;
	display: inline;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户管理-测试</title>
</head>
<body onselectstart="return false">

	<div class="easyui-layout"
		style="margin: 0 auto; width: 100%; height: 535px;">
		<!-- 1230px,600px -->
		<%@ include file="/WEB-INF/includes/menu.jsp"%>
		<div data-options="region:'center'"
			style="padding: 5px; background: #eee;">
			<div id="main" class="easyui-tabs" style="width: 100%; height: 630px">
				<!--1070px,585px-->
				<div title="自定义测试" style="padding: 10px">
					<%@ include file="/WEB-INF/includes/customTest.jsp"%>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/includes/top.jsp"%>
</body>


<script>
	/* 	function goTest() {

	 var param = $("#params").val();
	 param = "actionId:" + $("#actionId").val() + ";" + param;
	 // 		alert(param);
	 $.post("test/action.do", param, function() {

	 });
	 } */
	function clearConsole() {
		$("#console").val("");
	}
</script>
</html>