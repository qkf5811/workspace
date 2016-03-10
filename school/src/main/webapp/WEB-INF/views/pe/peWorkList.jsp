<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkListCondition">
		<span>时间 </span> <span>从:</span> <input class="easyui-datetimebox"
			editable="false" id="startDateTimeOfPeWork"
			name="startDateTimeOfPeWork"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" /><a
			class=""> <a class="easyui-linkbutton"
			onclick="$('#startDateTimeOfPeWork').datetimebox('setValue', '')"
			data-options="plain:true">清空</a> <span>到:</span> <input
			class="easyui-datetimebox" editable="false" id="endDateTimeOfPeWork"
			name="endDateTimeOfPeWork"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			onclick="$('#endDateTimeOfPeWork').datetimebox('setValue', '')"
			data-options="plain:true">清空</a> <a class="easyui-linkbutton"
			iconCls="icon-search" onclick="queryPeWorkList()"
			data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkListForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkListDatagrid"
				pagination="true" toolbar="#peWorkListToolbar"
				url="${contextPath}/pe/queryPeWorkList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="id" width="120px" align="center">工作id</th>
						<th field="mission" width="380px" align="left">任务</th>
						<th field="startDatetime" width="180px" align="center">开始时间</th>
						<th field="endDatetime" width="180px" align="center">结束时间</th>
						<th field="remark" width="300px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="peWorkListToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true"
					onclick="$('#newPeWorkInfoDoalog').dialog('open')">添加</a> <a
					class="easyui-linkbutton" iconCls="icon-edit" id="editBuilding"
					data-options="plain:true" onclick="openEditPeWorkInifoDialog()">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove" id="delBuilding"
					data-options="plain:true" onclick="deletePeWorkInfoById()">删除</a>
			</div>
		</div>
	</form>
</div>

<!-- 弹出添加人员信息的对话框 -->
<div id="newPeWorkInfoDoalog" class="easyui-dialog" title="添加体育工作信息"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addPeWorkInfoBtn'"
	style="width: 580px; height: 440px; padding: 17px;">
	<form id="newWorkInfoForm">
		<table cellpadding="7" align="center">
			<tr>
				<td>工作任务:</td>
				<td><input class="easyui-textbox" id="mission" name="mission"
					data-options="multiline:true, required:true, missingMessage:'该处未填写', novalidate:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
			<tr>
				<td>工作开始时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="startDatetime" name="startDatetime"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>工作结束时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="endDatetime" name="endDatetime"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="remark" name="remark"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
		</table>
	</form>

	<div id="addPeWorkInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addPeWorkInfo()">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="closePeWorkInfoDialog('#newWorkInfoForm', '#newPeWorkInfoDoalog')">关闭</a>
	</div>
</div>

<!-- 弹出编辑人员信息的对话框 -->
<div id="editPeWorkInfoDoalog" class="easyui-dialog" title="编辑体育工作信息"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editPeWorkInfoBtn'"
	style="width: 580px; height: 440px; padding: 17px;">
	<form id="editWorkInfoForm">
		<table cellpadding="7" align="center">
			<tr hidden="true">
				<td>id:</td>
				<td><input class="easyui-textbox" id="id" name="id"
					style="width: 280px; height: 30px; font-size: 15px"></td>
			</tr>
			<tr>
				<td>工作任务:</td>
				<td><input class="easyui-textbox" id="mission" name="mission"
					data-options="multiline:true, required:true, missingMessage:'该处未填写', novalidate:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
			<tr>
				<td>工作开始时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="startDatetime" name="startDatetime"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
					<a class="easyui-linkbutton"
					onclick="$('#editWorkInfoForm').find('#startDatetime').datetimebox('setValue', '')"
					data-options="plain:true">清空</a></td>
			</tr>
			<tr>
				<td>工作结束时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="endDatetime" name="endDatetime"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
					<a class="easyui-linkbutton"
					onclick="$('#editWorkInfoForm').find('#endDatetime').datetimebox('setValue', '')"
					data-options="plain:true">清空</a>
					</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="remark" name="remark"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
		</table>
	</form>

	<div id="editPeWorkInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="editPeWorkInfo()">更新</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="closePeWorkInfoDialog('#editWorkInfoForm', '#editPeWorkInfoDoalog')">关闭</a>
	</div>
</div>

<script type="text/javascript">
	// 关闭dialog
	// 关闭窗口
	function closePeWorkInfoDialog(form, dialog) {
		$(form).form("clear");
		$(form).find("#position").combobox("select", 0);
		$(form).form('disableValidation').form('validate');
		$(dialog).dialog('close');
	}

	// 添加体育工作信息
	function addPeWorkInfo() {
		$("#newWorkInfoForm").form('enableValidation').form('validate');
		if (!$('#newWorkInfoForm').form('validate'))
			return false;
		$.post("${contextPath}/pe/addPeWorkInfo.do", $("#newWorkInfoForm")
				.serialize(), function(data) {
			if (data == 1) {
				$.messager.alert("操作提示", "体育工作信息录入成功!", "info");
				$("#peWorkListDatagrid").datagrid("reload");
			} else {
				$.messager.alert("操作提示", "体育工作信息录入失败，请稍后再尝试!", "error");
			}
		});
	}

	// 条件查询
	function queryPeWorkList() {
		$("#peWorkListForm").find("#peWorkListDatagrid").datagrid(
				{
					url : "${contextPath}/pe/queryPeWorkList.do",
					queryParams : {
						startDatetimeStr : $("#startDateTimeOfPeWork")
								.datetimebox("getValue"),
						endDatetimeStr : $("#endDateTimeOfPeWork").datetimebox(
								"getValue")
					}
				});
	}

	// 打开编辑窗口
	function openEditPeWorkInifoDialog() {
		var row = $("#peWorkListDatagrid").datagrid("getSelections");
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择需要编辑的体育工作信息!", "warning");
			return;
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "不能同时编辑多项体育工作信息!", "warning");
			return;
		}

		$("#editWorkInfoForm").find("#id").textbox('setValue', row[0].id);
		$("#editWorkInfoForm").find("#mission").textbox('setValue',
				row[0].mission);
		$("#editWorkInfoForm").find("#startDatetime").datetimebox('setValue',
				row[0].startDatetime);
		$("#editWorkInfoForm").find("#endDatetime").datetimebox('setValue',
				row[0].endDatetime);
		$("#editWorkInfoForm").find("#remark").textbox('setValue',
				row[0].remark);
		$("#editPeWorkInfoDoalog").dialog("open");
	}

	function editPeWorkInfo() {
		// 表单验证
		$("#editPersonInfoForm").form('enableValidation').form('validate');
		if (!$('#editPersonInfoForm').form('validate'))
			return false;
		// 更新
		$.post("${contextPath}/pe/editPeWorkInfo.do", {
			id : $('#editWorkInfoForm').find("#id").textbox('getValue'),
			mission : $('#editWorkInfoForm').find("#mission").textbox(
					"getValue"),
			startDatetime : $('#editWorkInfoForm').find("#startDatetime")
					.combobox('getValue'),
			endDatetime : $('#editWorkInfoForm').find("#endDatetime").textbox(
					'getValue'),
			remark : $('#editWorkInfoForm').find("#remark").textbox('getValue')
		}, function(data) {
			if (data == 1) {
				closePeWorkInfoDialog("#editWorkInfoForm",
						"#editPeWorkInfoDoalog");
				$.messager.alert("操作提示", "体育工作信息更新成功!", "info");
				$("#peWorkListDatagrid").datagrid("reload");
			} else {
				$.messager.alert("操作提示", "体育工作信息更新失败，请稍后再尝试!", "warning");
			}
		});
	}

	function deletePeWorkInfoById() {
		var row = $("#peWorkListDatagrid").datagrid("getSelections");
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择需要删除的体育工作信息!", "warning");
			return;
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "不能同时删除多项体育工作信息!", "warning");
			return;
		} else {
			$.messager.confirm("请确认...", "您确定要删除此体育工作信息吗?", function(data) {
				if (data)
					$.post('${contextPath}/pe/deletePeWorkInfoById.do', {
						id : row[0].id
					}, function(data) {
						if (data == 1) {
							$.messager.alert("操作提示", "体育工作信息删除成功!", "info");
							$("#peWorkListDatagrid").datagrid("reload");
						} else {
							$.messager.alert("操作提示", "体育工作信息删除失败，请稍后再尝试!", "warning");
						}
					})
				else
					;
			});
		}
	}
</script>