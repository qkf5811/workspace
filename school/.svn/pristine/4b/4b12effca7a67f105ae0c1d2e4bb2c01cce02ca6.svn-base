<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="studentChangeToolbar" style="padding: 5px; height: auto">
		<div>

			<td>学生姓名：</td>
			<td><input class="easyui-validatebox textbox" id="name"
				name="name" style="width: 100px; height: 18px; padding: 5px" /></td>

			<td>学生学号:</td>
			<td><input class="easyui-validatebox textbox" id="code"
				name="code" style="width: 100px; height: 18px; padding: 5px" /></td>
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStudentChange('#studentChangeToolbar', '#studentChangeList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="studentChangeList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		url="${contextPath}/stu/getStudentChangeList.do"
		toolbar="#studentChangeOperToolbar" rownumbers="true"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="60" align="center">学生姓名</th>
				<th field="code" width="100" align="center">学生学号</th>
				<th field="changeTypeStr" width="100" align="center">异动类型</th>
				<th field="cause" width="150" align="center">异动原因</th>
				<th field="OutClassMajorName" width="150" align="center">转出班级</th>
				<th field="outClassDateStr" width="90" align="center">转出日期</th>
				<th field="IntoClassMajorName" width="150" align="center">转入班级</th>
				<th field="intoClassDateStr" width="90" align="center">转入日期</th>
				<th field="operUser" width="65" align="center">处理人员</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
	<div id="studentChangeOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="openTab('stu/toAddStudentChange.do','新建学籍异动')">新建</a>
		<!--     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditStudentChange()">编辑</a> -->
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteStudentChange()">撤销记录</a>
	</div>
</div>

<script type="text/javascript">
	

	function searchStudentChange(toolbar, datagrid) {
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();

		//!-AJAX请求数据

		$(datagrid).datagrid('load', {
			name : name,
			code : code
		});
	}

	function toEditStudentChange() {
		var row = $('#studentChangeList').datagrid('getSelected');
		if (row) {
			openTab('stu/toEditStudentChange.do?id=' + row.id, '编辑学籍异动');
		}
	}

	function deleteStudentChange() {

		var row = $('#studentChangeList').datagrid('getSelected');
		
		if (row) {

			$.messager.confirm('请确认...', '您确定要撤销此学籍异动吗?', function(r) {
				if (r) {
					$.post('stu/deleteStudentChange.do', {
						id : row.id,
						code : row.code
					}, function(result) {
						if (result.success) {
							
							$.messager.alert("操作提示", "撤销成功！","info");
							$('#studentChangeList').datagrid('reload'); // reload the user data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '撤销学籍异动失败'
							});
						}
					}, 'json');
				}
			});
		} else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
	}
</script>
