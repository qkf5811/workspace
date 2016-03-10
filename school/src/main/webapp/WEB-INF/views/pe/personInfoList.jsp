<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkGroupPersonInfoListCondition">
		<span>工作组职位:</span> <select class="easyui-combobox"
			id="workGroupPosition" name="workGroupPosition"
			style="width: 150px; height: 25px"
			data-options="novalidate:true,panelHeight: 'auto'"
			validtype="selectRequired['campusRefer']" editable="false">
			<option value="0">请选择</option>
			<c:forEach items="${positions}" var="position">
				<option value="${position['id']}">${position['name']}</option>
			</c:forEach>
		</select> <span>教职工名称:</span> <input class="easyui-textbox"
			id="teaNameInWorkGroup" name="teaNameInWorkGroup"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search"
			onclick="queryPeWorkGroupPersonInfoList()" data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkGroupPersonListForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkGroupPersonList"
				pagination="true" toolbar="#peWorkGroupPersonListToolbar"
				url="${contextPath}/pe/queryPersonList.do?workGroupPosition=0&teaNameInWorkGroup="
				rownumbers="true" singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="id" width="120px" align="center" hidden="true">工作组个人信息id</th>
						<th field="teaInfoId" width="120px" align="center" hidden="true">教职工详细信息id</th>
						<th field="code" width="120px" align="center">工号</th>
						<th field="name" width="120px" align="center">姓名</th>
						<th field="sex" width="150px" align="center">性别</th>
						<th field="positionStr" width="150px" align="center">职位</th>
						<th field="duty" width="250px" align="center">职责</th>
						<th field="remark" width="200px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="peWorkGroupPersonListToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#newPePersonInfoDoalog').dialog('open')">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editBuilding"
					data-options="plain:true"
					onclick="openEditPePersonInifoDialog()">编辑</a> <a
					class="easyui-linkbutton" iconCls="icon-remove" id="delBuilding"
					data-options="plain:true" onclick="deletePePersonInfoById()">删除</a>
			</div>
		</div>
	</form>
</div>

<!-- 弹出添加人员信息的对话框 -->
<div id="newPePersonInfoDoalog" class="easyui-dialog" title="添加体育工作组人员"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addPePersonInfoBtn'"
	style="width: 580px; height: 440px; padding: 17px;">
	<form id="newPersonInfoForm">
		<table cellpadding="7" align="center">
			<tr>
				<td>教职工工号:</td>
				<td><input class="easyui-textbox" id="code" name="code"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 150px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>工作组职位:</td>
				<td><select class="easyui-combobox" id="position"
					name="position" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'"
					validtype="selectRequired['position']" editable="false">
						<option value="0">请选择</option>
						<c:forEach items="${positions}" var="position">
							<option value="${position['id']}">${position['name']}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>职责:</td>
				<td><input class="easyui-textbox" id="duty" name="duty"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="remark" name="remark"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
		</table>
	</form>

	<div id="addPePersonInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addPePersonInfo()">确认</a>
		&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="closePePersonInfoDialog('#newPersonInfoForm', '#newPePersonInfoDoalog')">关闭</a>
	</div>
</div>

<!-- 弹出编辑人员信息的对话框 -->
<div id="editPePersonInfoDoalog" class="easyui-dialog" title="编辑体育工作组人员"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editPePersonInfoBtn'"
	style="width: 580px; height: 440px; padding: 17px;">
	<form id="editPersonInfoForm">
		<table cellpadding="7" align="center">
			<tr hidden="true">
				<td>id:</td>
				<td><input class="easyui-textbox" id="id" name="id" editable="false"
					style="width: 150px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input class="easyui-textbox" id="name" name="name" editable="false"
					style="width: 150px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>工作组职位:</td>
				<td><select class="easyui-combobox" id="positionOfEdit"
					name="positionOfEdit" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'"
					validtype="selectRequired['positionOfEdit']" editable="false">
						<option value="0">请选择</option>
						<c:forEach items="${positions}" var="position">
							<option value="${position['id']}">${position['name']}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>职责:</td>
				<td><input class="easyui-textbox" id="duty" name="duty"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="remark" name="remark"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
		</table>
	</form>

	<div id="editPePersonInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="editPePersonInfo()">更新</a>
		&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="closePePersonInfoDialog('#editPersonInfoForm', '#editPePersonInfoDoalog')">关闭</a>
	</div>
</div>

<script type="text/javascript">
	function queryPeWorkGroupPersonInfoList() {
		var position = $("#workGroupPosition").combobox("getValue");
		var name = $("#teaNameInWorkGroup").val();
		$("#peWorkGroupPersonListForm").find("#peWorkGroupPersonList")
				.datagrid({
					url : "${contextPath}/pe/queryPersonList.do",
					queryParams : {
						workGroupPosition : position,
						teaNameInWorkGroup : name
					}
				});
	}

	// 添加体育工作组人员信息
	function addPePersonInfo() {
		$("#newPersonInfoForm").form('enableValidation').form('validate');
		if (!$('#newPersonInfoForm').form('validate'))
			return false;
		$.post("${contextPath}/pe/addPePersonInfo.do", $("#newPersonInfoForm").serialize(), 
				function(data) {
					if (data == 1) {
						$.messager.alert("操作提示", "人员信息录入成功!", "info");
						$("#peWorkGroupPersonListForm").find("#peWorkGroupPersonList").datagrid('reload');
					} else if (data == -1) {
						$.messager.alert("操作提示", "人员信息已经存在，录入失败!", "warning");
					} else {
						$.messager.alert("操作提示", "人员信息录入失败，请稍后再尝试!", "error");
					}
			});
	}

	// 关闭窗口
	function closePePersonInfoDialog(form, dialog) {
		$(form).form("clear");
		$(form).find("#position").combobox("select", 0);
		$(form).form('disableValidation').form('validate');
		$(dialog).dialog('close');
	}

	// 打开编辑窗口
	function openEditPePersonInifoDialog() {
		var row = $("#peWorkGroupPersonList").datagrid("getSelections");
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择需要编辑的人员信息!", "warning");
			return ;
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "不能同时编辑多名人员的信息!", "warning");
			return ;
		}
	//	console.log(row[0]);
	//	console.log(row[0].name)
		$("#editPersonInfoForm").find("#id").textbox("setValue", row[0].id);
		$("#editPersonInfoForm").find("#name").textbox("setValue", row[0].name);
		$("#editPersonInfoForm").find("#positionOfEdit").combobox('select', row[0].position);
		$("#editPersonInfoForm").find("#duty").textbox("setValue", row[0].duty);
		$("#editPersonInfoForm").find("#remark").textbox("setValue", row[0].remark);
		$('#editPePersonInfoDoalog').dialog("open");
	}

	// 编辑人员信息
	function editPePersonInfo() {
		// 表单验证
		$("#editPersonInfoForm").form('enableValidation').form('validate');
		if (!$('#editPersonInfoForm').form('validate'))
			return false;
		// 更新
		$.post("${contextPath}/pe/editPePersonInfo.do", {
				id : $('#editPersonInfoForm').find("#id").textbox("getValue"),
				position : $('#editPersonInfoForm').find("#positionOfEdit").combobox('getValue'),
				duty : $('#editPersonInfoForm').find("#duty").textbox('getValue'),
				remark : $('#editPersonInfoForm').find("#remark").textbox('getValue')
			},
				function(data) {
				//	alert(data);
					if (data == 1) {
						closePePersonInfoDialog("#editPersonInfoForm", "#editPePersonInfoDoalog");
						$.messager.alert("操作提示", "人员信息更新成功!", "info");
						$("#peWorkGroupPersonList").datagrid("reload");
					} else if (data == 0) {
						$.messager.alert("操作提示", "人员信息更新失败，请稍后再尝试!", "warning");
					} else {
						$.messager.alert("操作提示", "未知错误，请稍后再尝试!", "warning");
					}
			});
	}

	function deletePePersonInfoById() {
		var row = $("#peWorkGroupPersonList").datagrid("getSelections");
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择需要删除的人员信息!", "warning");
			return ;
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "不能同时删除多名人员的信息!", "warning");
			return ;
		}
		$.messager.confirm("请确认...", "您确定要删除此人员信息吗?", function(data) {
			if (data)
				$.post('${contextPath}/pe/deletePePersonInfoById.do', {
					id : row[0].id
				}, function(data) {
					if (data == 1) {
						$.messager.alert("操作提示", "工作组人员信息删除成功!", "info");
						$("#peWorkGroupPersonList").datagrid("reload");
					} else {
						$.messager.alert("操作提示", "工作组人员信息删除失败，请稍后再尝试!", "warning");
					}
				})
			else
				;
		});
	}
</script>