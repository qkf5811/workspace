<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="teacherEduExpToolbar">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" 
			 iconCls="icon-add" onclick="openAddEduExpTab()">添加教育经历</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" 
			 iconCls="icon-remove" onclick="deleteEduExpById()">删除教育经历</a>
</div>
<div id="teacherEduExpForm" style="margin:5px">
	<input id="id" value="${teacherId }" hidden="true">
	<div style="margin: 15px"><strong>${name }</strong> 的教育经历信息:</div>
	<table id="teaEduExpInfoList" class="easyui-datagrid" pagination="true"
		rownumbers="true" singleSelect="true" data-options="pageSize:10"
		toolbar="#teacherEduExpToolbar">
		<thead>
			<tr>
				<th field="educationTypeStr" align="center" width="120">教育类型</th>
				<th field="school" align="center" width="120">毕业学校</th>
				<th field="major" align="center" width="120">所属专业</th>
				<th field="startDateStr" align="center" width="120">开始时间</th>
				<th field="endDateStr" align="center" width="120">结束时间</th>
				<th field="degreeTypeStr" align="center" width="120">学历</th>
				<th field="remark" align="center" width="120">教育经历备注</th>
			</tr>
		</thead>
	</table>
	
	</table>
</div>

<script>
	$(function() {
		var id = $('#teacherEduExpForm').find('#id').val();
		$('#teacherEduExpForm').find('#teaEduExpInfoList').datagrid({
			url : "${contextPath}/tea/getTeacherEduExpInfoList.do?id=" + id
		});
	})
	function openAddEduExpTab() {
		var id = $('#teacherEduExpForm').find('#id').val();
		openTab("tea/openInputTeacherEduExpTab.do?teacherId=" + id, "添加教育经历信息");
	}
	
	function openEduInfoById() {
		var row = $('#teacherEduExpForm').find('#teacherEduExpTable').datagrid('getSelected');
		if (row == null) 
			$.messager.alert("操作提示 ", "请先选择一条教职工教育经历信息!", "warning");
		else {
			$('#eduExpDialog').dialog('open');
			//
			var id = row.idOfTeacher;
			$('#eduExpDialog').find('#teaEduExpInfoList').datagrid({
				url : "${contextPath}/tea/getTeacherEduExpInfoList.do?id=" + id
			});
		}
	}
	
	function closeEduExpDialog() {
		$('#eduExpDialog').dialog('close');
	}
	
	function deleteEduExpById() {
		var row = $('#teacherEduExpForm').find('#teaEduExpInfoList').datagrid('getSelected');
		if (row == null) 
			$.messager.alert("操作提示", "请先选择一条教职工教育经历信息!", "warning");
		else {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function (r) {
				if (r) {
					$.post("${contextPath}/tea/deleteEduExpById.do", {
						id: row.id
					},function (data) {
						var obj = eval('(' + data + ')');
						if (obj.result == 0)
							$.messager.alert("操作提示", "删除失败!请稍后在尝试.", "warning");
						else if (obj.result == 1) {
							$.messager.alert("操作提示", "教育经历信息删除成功!", "info");
							$('#teacherEduExpForm').find('#teaEduExpInfoList').datagrid('reload');
						}
					})
				}
			});
		}
	}
</script>