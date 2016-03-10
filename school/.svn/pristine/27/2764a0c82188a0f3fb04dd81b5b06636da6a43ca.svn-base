<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
<div id="StuChangeClassToolbar" style="padding: 5px; height: auto">
		<div>
		<span>学生姓名：</span>
				<span><input class="easyui-validatebox textbox" id="name"
				name="name" style="width: 100px; height: 18px; padding: 5px" />
					
				</span> 
				
				<span>学生学号:</span>
				<span><input class="easyui-validatebox textbox" id="code"
				name="code" style="width: 100px; height: 18px; padding: 5px" />
				</span> 
				
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="stuChangeClassSearch('#StuChangeClassToolbar', '#StuChangeClassList')"
				iconCls="icon-search">查询</button>
		</div>
		</div>
	<table id="StuChangeClassList" class="easyui-datagrid" style="width: auto;" toolbar="#StuChangeClassOpenToolbar"
		pagination="true" url="${contextPath}/stu/getStuChangeClassListData.do"
		 rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="60" align="center">学生姓名</th>
				<th field="code" width="100" align="center">学生学号</th>
				<th field="changeTypeStr" width="100" align="center">异动类型</th>
				<th field="cause" width="150" align="center">异动原因</th>
				<th field="OutClassMajorName" width="150" align="center">转出班级</th>
				<th field="outClassDate" width="90" align="center">转出日期</th>
				<th field="IntoClassMajorName" width="150" align="center">转入班级</th>
				<th field="intoClassDate" width="90" align="center">转入日期</th>
				<th field="operUser" width="65" align="center">处理人员</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>

	<div id="StuChangeClassOpenToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" id="addCourse"
			data-options="plain:true" onclick="openTab('stu/stuChangeClassAdd.do','新增学生转班')">新增</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" data-options="plain:true"
			onclick="stuChangeClassDelete()">撤销记录</a>
	</div>

</div>

<script type="text/javascript">

	function stuChangeClassSearch(toolbar, datagrid) {
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();
		//!-AJAX请求数据
		$(datagrid).datagrid({
			url : "${contextPath}/stu/getStuChangeClassListData.do",
			queryParams : {
				"name" : name,
				"code" : code
			}
		});

	}
	
	function stuChangeClassEdit() {
		var row = $('#StuChangeClassList').datagrid('getSelected');
		if (row) {
			if ($('#main').tabs('exists', '学生转班修改')) {
		        $('#main').tabs('close', '学生转班修改')
		    }
			openTab("stu/stuChangeClassEdit.do?id="+ row.id, "学生转班修改");
		}else {
			$.messager.alert("操作提示", "请先选择一条学生转班信息!", "warning");
			return;
		}
	}
	
	function stuChangeClassDelete() {
		var row = $('#StuChangeClassList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此学生转班信息吗?', function(r) {
				if (r) {
					$.post('stu/stuChangeClassDelete.do', {
						id : row.id,
						code : row.code
					}, function(data) {
						if (data.success) {
							$.messager.alert("操作提示", "学生转班信息删除成功!", "info");
							$('#StuChangeClassList').datagrid('reload'); // reload the course data
						} else {
							$.messager.show({ 
								title : 'Error',
								msg : '删除学生转班信息失败'
							});
						}
					}, 'json');
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的学生转班信息!", "warning");
	}
</script>
