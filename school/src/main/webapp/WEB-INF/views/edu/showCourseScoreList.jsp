<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
<div id="showTeaCourseToolbar" style="padding: 5px; height: auto">
  <div class="panel-header"><div class="panel-title" align="center">${name }</div><div class="panel-tool"></div></div>
<input type="hidden" id="teaCourseId" value="${teaCourseId }">
<input type="hidden" id="classId" value="${classId }">
		<div>
			
			<td>学号：</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				
				
				<td>姓名：</td>
				<td><input class="easyui-validatebox textbox" id="userName"
					name="userName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>
					
					
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchshowTeaCourse('#showTeaCourseToolbar', '#showTeaCourseList')"
				iconCls="icon-search">查询</button>
		</div>
		</div>
	<table id="showTeaCourseList" class="easyui-datagrid" style="width: auto;" toolbar="#showTeaCourseOpenToolbar"
		pagination="true" url="${contextPath}/edu/getEditCourseScoreList.do?teaCourseId=${teaCourseId }&classId=${classId}"
		 rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="15%" align="center">学号</th>
				<th field="name" width="10%" align="center">姓名</th>
				<c:if test="${type == 35001 }">
				<th field="hundredUsualScore" width="10%" align="center">平时</th>
				<th field="hundredExamScore" width="10%" align="center">考试</th>
				<th field="hundredTotalScore" width="10%" align="center">总评</th>
				</c:if>
				
				<c:if test="${type == 35002 }">
				<th field="gradeUsualStr" width="10%" align="center">平时</th>
				<th field="gradeExamStr" width="10%" align="center">考试</th>
				<th field="gradeTotalStr" width="10%" align="center">总评</th>
				</c:if>
				
				<th field="examNatureTypeStr" width="20%" align="center">考试性质</th>
			</tr>
		</thead>
	</table>

</div>

<script type="text/javascript">
	function searchshowTeaCourse(toolbar, datagrid) {
		var code = $(toolbar).find("#code").val();
		var userName = $(toolbar).find("#userName").val();
		var teaCourseId = $("#teaCourseId").val()
		//!-AJAX请求数据
		$('#showTeaCourseList').datagrid({
			url : "${contextPath}/edu/getEditCourseScoreList.do",
			queryParams : {
				"name" : userName,
				"code" : code,
				"teaCourseId":teaCourseId,
				"classId":$("#classId").val()
			}
		});

	}
	
	
	
</script>
