<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="querySptMeetingItem">
		<span>项目类型: </span> 
		<select class="easyui-combobox"
			id="sptMeetingItemType" name="sptMeetingItemType"
			style="width: 150px; height: 25px"
			data-options="novalidate:true,panelHeight: 'auto'"
			validtype="selectRequired['sptMeetingItemType']" editable="false">
			<option value="0">请选择</option>
			<c:forEach items="${types}" var="type">
				<option value="${type['id']}">${type['name']}</option>
			</c:forEach>
		</select>
			<span>负责人工号:</span>
			<input class="easyui-textbox"
			id="chargePersonCode"
			name="chargePersonCode"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<span>项目名称:</span>
			<input class="easyui-textbox"
			id="name"
			name="name"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			iconCls="icon-search" onclick="queryStpMeetingItemList('#querySptMeetingItem')"
			data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="sptMeetingItemListForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="sptMeetingItemListDatagrid"
				pagination="true" toolbar="#sptMeetingItemListToolbar"
				url="${contextPath}/spt/querySptMeetingItemList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="id" width="120px" align="center" hidden>id</th>
						<th field="sptId" width="120px" align="center" hidden>sptId</th>
						<th field="name" width="180px" align="center">项目名称</th>
						<th field="type" width="120px" align="center" hidden>type</th>
						<th field="typeStr" width="120px" align="center">项目类型</th>
						<th field="account" width="120px" align="center">人数</th>
						<th field="requirement" width="120px" align="center">参与条件</th>
						<th field="chargePersonName" width="120px" align="center">负责人</th>
						<th field="code" width="120px" align="center">负责人工号</th>
						<th field="remark" width="300px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="sptMeetingItemListToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#addSptMeetingItemDialog').dialog('open')">添加</a>
	 			<a class="easyui-linkbutton" iconCls="icon-edit" id="addBuilding"
					data-options="plain:true" onclick="editSptMeetingItemInfo('#editSptMeetingItemDialog', '#editSptMeetingItemForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove" id="delBuilding"
					data-options="plain:true" onclick="deleteSptMeetingItemById()">删除</a>
			</div>
		</div>
	</form>
</div>

<!-- 弹出添加运动会项目信息的对话框 -->
<div id="addSptMeetingItemDialog" class="easyui-dialog" title="添加运动会项目信息"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addSptMeetingItemBtn'"
	style="width: auto; height: auto; padding: 17px;">
	<form id="addSptMeetingItemForm">
		<table cellpadding="7" align="center">
			<tr>
				<td>项目名称:</td>
				<td><input class="easyui-textbox" editable="true"
					id="name" name="name"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>项目类型: </td> 
				<td><select class="easyui-combobox"
				id="sptMeetingItemType" name="sptMeetingItemType"
				style="width: 150px; height: 25px"
				data-options="novalidate:true,panelHeight: 'auto'"
				editable="false">
				<!-- validtype="selectRequired['sptMeetingItemType']"  -->
				<option value="0">请选择</option>
				<c:forEach items="${types}" var="type">
					<option value="${type['id']}">${type['name']}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>参与人数:</td>
				<td><input class="easyui-numberbox" editable="true"
					id="account" name="account"
					data-options=""
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>参与条件:</td>
				<td>
					<input class="easyui-textbox" id="requirement" name="requirement"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px">
				</td>
			</tr>
			<tr hidden>
				<td>教职工id:</td> 
				<td><input class="easyui-textbox"
				id="id" name="id"
				style="width: 150px; height: 25px; padding: 10px; font-size: 15px" /></td>
			</tr>
			<tr>
				<td>负责人工号:</td>
				<td>
					<input class="easyui-textbox" id="code" name="code"
					editable="false" data-options="multiline:false"
					style="width: 280px; height: 25px; font-size: 15px">
					<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#perInfoDialogInStpMeetingItem').dialog('open')">选择人员</a>
				</td>
			</tr>
			<tr>
				<td>负责人姓名:</td>
				<td>
					<input class="easyui-textbox" id="chargePersonName" name="chargePersonName"
					editable="false" data-options="multiline:false"
					style="width: 280px; height: 25px; font-size: 15px">
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

	<div id="addSptMeetingItemBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addSptMeetingItemInfo('#addSptMeetingItemForm')">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-reload"
			onclick="resetSptMeetingItemInfo()">重置</a>
	</div>
</div>
<!-- 弹出编辑运动会项目信息的对话框 -->
<div id="editSptMeetingItemDialog" class="easyui-dialog" title="编辑运动会项目信息"
	data-options="modal:true,iconCls:'icon-edit',closed:true , buttons:'#editSptMeetingItemBtn'"
	style="width: auto; height: auto; padding: 17px;">
	<form id="editSptMeetingItemForm">
		<table cellpadding="7" align="center">
			<tr hidden>
				<td>id:</td>
				<td><input class="easyui-textbox" editable="true"
					id="pkid" name="pkid"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>项目名称:</td>
				<td><input class="easyui-textbox" editable="true"
					id="name" name="name"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>项目类型: </td> 
				<td><select class="easyui-combobox"
				id="sptMeetingItemType" name="sptMeetingItemType"
				style="width: 150px; height: 25px"
				data-options="novalidate:true,panelHeight: 'auto'"
				editable="false">
				<!-- validtype="selectRequired['sptMeetingItemType']"  -->
				<option value="0">请选择</option>
				<c:forEach items="${types}" var="type">
					<option value="${type['id']}">${type['name']}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>参与人数:</td>
				<td><input class="easyui-numberbox" editable="true"
					id="account" name="account"
					data-options=""
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>参与条件:</td>
				<td>
					<input class="easyui-textbox" id="requirement" name="requirement"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px">
				</td>
			</tr>
			<tr >
				<td>教职工id:</td> 
				<td><input class="easyui-textbox"
				id="id" name="id"
				style="width: 150px; height: 25px; padding: 10px; font-size: 15px" /></td>
			</tr>
			<tr>
				<td>负责人工号:</td>
				<td>
					<input class="easyui-textbox" id="code" name="code"
					editable="false" data-options="multiline:false"
					style="width: 280px; height: 25px; font-size: 15px">
					<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#perInfoDialogInStpMeetingItemOfEdit').dialog('open')">选择人员</a>
				</td>
			</tr>
			<tr>
				<td>负责人姓名:</td>
				<td>
					<input class="easyui-textbox" id="chargePersonName" name="chargePersonName"
					editable="false" data-options="multiline:false"
					style="width: 280px; height: 25px; font-size: 15px">
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

	<div id="addSptMeetingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateSptMeetingItemInfo('#editSptMeetingItemForm')">更新</a><!-- <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-reload"
			onclick="resetSptMeetingItemInfo()">重置</a> -->
	</div>
</div>
<!-- 弹出选择负责人(添加) -->
<div class="easyui-dialog" title="选择工作组人员" iconCls="icon-search"
	id="perInfoDialogInStpMeetingItem" style="width: auto; height: auto"
	top="200px" data-options="resizable:true,modal:true, closed:true">
	<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkGroupPersonInfoListConditionInMeetingItem">
		<span>工作组职位:</span> <select class="easyui-combobox"
			id="workGroupPositionInMeetingItem" name="workGroupPositionInMeetingItem"
			style="width: 150px; height: 25px"
			data-options="novalidate:true,panelHeight: 'auto'"
			validtype="selectRequired['campusRefer']" editable="false">
			<option value="0">请选择</option>
			<c:forEach items="${positions}" var="position">
				<option value="${position['id']}">${position['name']}</option>
			</c:forEach>
		</select> <span>教职工名称:</span> <input class="easyui-textbox"
			id="teaNameInWorkGroupInMeetingItem" name="teaNameInWorkGroupInMeetingItem"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search"
			onclick="queryPeWorkGroupPersonInfoListInMeetingItem()" data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkGroupPersonListFormInMeetingItem">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkGroupPersonListInMeetingItem"
				pagination="true" toolbar=""
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
	</form>
	</div>
	<div style="float: right; border: 1px solid gray; margin-top: 10px"
		iconCls="icon-ok" class="easyui-linkbutton"
		onclick="selectPePersonInfoInMeetingItem('#addSptMeetingItemForm', '#peWorkGroupPersonListInMeetingItem', '#perInfoDialogInStpMeetingItem')">选择</div>
</div>

<!-- 弹出选择负责人(编辑) -->
<div class="easyui-dialog" title="选择工作组人员" iconCls="icon-search"
	id="perInfoDialogInStpMeetingItemOfEdit" style="width: auto; height: auto"
	top="200px" data-options="resizable:true,modal:true, closed:true">
	<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkGroupPersonInfoListConditionInMeetingItemOfEdit">
		<span>工作组职位:</span> <select class="easyui-combobox"
			id="workGroupPositionInMeetingItem" name="workGroupPositionInMeetingItem"
			style="width: 150px; height: 25px"
			data-options="novalidate:true,panelHeight: 'auto'"
			validtype="selectRequired['campusRefer']" editable="false">
			<option value="0">请选择</option>
			<c:forEach items="${positions}" var="position">
				<option value="${position['id']}">${position['name']}</option>
			</c:forEach>
		</select> <span>教职工名称:</span> <input class="easyui-textbox"
			id="teaNameInWorkGroupInMeetingItem" name="teaNameInWorkGroupInMeetingItem"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search"
			onclick="queryPeWorkGroupPersonInfoListInMeetingItem()" data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkGroupPersonListFormInMeetingItemOfEdit">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkGroupPersonListInMeetingItemIfEdit"
				pagination="true" toolbar=""
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
	</form>
	</div>
	<div style="float: right; border: 1px solid gray; margin-top: 10px"
		iconCls="icon-ok" class="easyui-linkbutton"
		onclick="selectPePersonInfoInMeetingItem('#editSptMeetingItemForm', '#peWorkGroupPersonListInMeetingItemIfEdit', '#perInfoDialogInStpMeetingItemOfEdit')">选择</div>
</div>
<script type="text/javascript">
	function queryStpMeetingItemList(form) {
	//	console.log($(form).serialize());
		$('#sptMeetingItemListDatagrid').datagrid({
			url : "${contextPath}/spt/querySptMeetingItemList.do",
			queryParams : {
				type : $(form).find("#sptMeetingItemType").combobox("getValue"),
				code : $(form).find("#chargePersonCode").textbox("getValue").trim(),
				name : $(form).find("#name").textbox("getValue").trim()
			}
		});
	}

	function queryPeWorkGroupPersonInfoListInMeetingItem() {
		var position = $("#workGroupPositionInMeetingItem").combobox("getValue");
		var name = $("#teaNameInWorkGroupInMeetingItem").val();
		$("#peWorkGroupPersonListFormInMeetingItem").find("#peWorkGroupPersonListInMeetingItem")
				.datagrid({
					url : "${contextPath}/pe/queryPersonList.do",
					queryParams : {
						workGroupPosition : position,
						teaNameInWorkGroup : name
					}
				});
	}

	function selectPePersonInfoInMeetingItem(form, datagrid, dialog) {
		var row = $(datagrid).datagrid("getSelected");
		if (row) {
//			console.log(row);
			$(form).find("#code").textbox("setValue", row.code);
			$(form).find("#chargePersonName").textbox("setValue", row.name);
			$(form).find("#id").textbox("setValue", row.id);
			$(dialog).dialog('close');
		} else {
			$.messager.alert("操作提示", "请先选择一条记录!", "warning");
		}
	}

	function resetSptMeetingItemInfo() {
		$("#addSptMeetingItemForm").form("clear");
		$("#addSptMeetingItemForm").find("#sptMeetingItemType").combobox("select", 0);
	}

	function addSptMeetingItemInfo(form) {
		//表单验证
		$(form).form('enableValidation').form('validate');
		if (!$(form).form('validate'))
			return false;
		var chargePerson = $(form).find("#id").textbox("getValue");
		var name = $(form).find("#name").textbox("getValue");
		var type = $(form).find("#sptMeetingItemType").combobox("getValue");
		var account = $(form).find("#account").textbox("getValue");
		var requirement = $(form).find("#requirement").textbox("getValue");
		var remark = $(form).find("#remark").textbox("getValue");
		var param = {
			chargePerson : chargePerson,
			name : name,
			type : type,
			account : account,
			requirement : requirement,
			remark : remark
		};
	//	console.log(param);
		$.post("${contextPath}/spt/addSptMeetingItem.do", param, function(data) {
			if (data == 1) {
				$.messager.alert("操作提示", "运动会项目信息录入成功!", "info");
				$("#sptMeetingItemListDatagrid").datagrid('reload');
			} else {
				$.messager.alert("操作提示", "运动会项目信息录入失败，请稍后再尝试!", "error");
			}
			$('#addSptMeetingItemDialog').dialog('close');
			$('#addSptMeetingItemForm').form('clear');
		});
	}

	function deleteSptMeetingItemById() {
		var row = $("#sptMeetingItemListDatagrid").datagrid("getSelected");
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此运动会项目信息吗?", function(data) {
				if (data)
					$.post("${contextPath}/spt/deleteSptMeetingItem.do", {
						id : row.id
					}, function (data) {
						if (data == 1) {
							$.messager.alert("操作提示", "运动会项目信息删除成功!", "info");
							$("#sptMeetingItemListDatagrid").datagrid('reload');
						} else {
							$.messager.alert("操作提示", "运动会项目信息删除失败，请稍后再尝试!", "error");
						}
					});
				else
					;
			});
		} else {
			$.messager.alert("操作提示", "请先选择一条记录!", "warning");
		}
	}

	function editSptMeetingItemInfo(dialog, form) {
		var row = $("#sptMeetingItemListDatagrid").datagrid("getSelected");
		if (row) {
			console.log(row)
			if ($(form).find("#pkid"))
				$(form).find("#pkid").textbox("setValue", row.id);
			$(form).find("#name").textbox("setValue", row.name);
			$(form).find("#sptMeetingItemType").combobox("setValue", row.type);
			$(form).find("#account").textbox("setValue", row.account);
			$(form).find("#requirement").textbox("setValue", row.requirement);
			$(form).find("#id").textbox("setValue", row.chargePerson);
			$(form).find("#code").textbox("setValue", row.code);
			$(form).find("#chargePersonName").textbox("setValue", row.chargePersonName);
			$(form).find("#remark").textbox("setValue", row.remark);
			$(dialog).dialog("open");
		} else {
			$.messager.alert("操作提示", "请先选择一条记录!", "warning");
		}
	}

	function updateSptMeetingItemInfo(form) {
		//表单验证
		$(form).form('enableValidation').form('validate');
		if (!$(form).form('validate'))
			return false;
		var chargePerson = $(form).find("#id").textbox("getValue");
		var name = $(form).find("#name").textbox("getValue");
		var type = $(form).find("#sptMeetingItemType").combobox("getValue");
		var account = $(form).find("#account").textbox("getValue");
		var requirement = $(form).find("#requirement").textbox("getValue");
		var remark = $(form).find("#remark").textbox("getValue");
		var id = $(form).find("#pkid").textbox("getValue");
		var param = {
			id : id,
			chargePerson : chargePerson,
			name : name,
			type : type,
			account : account,
			requirement : requirement,
			remark : remark
		};
	//	console.log(param);
		$.post("${contextPath}/spt/updateSptMeetingItemInfo.do", param, function(data) {
			if (data == 1) {
				$.messager.alert("操作提示", "运动会项目信息更新成功!", "info");
				$("#sptMeetingItemListDatagrid").datagrid('reload');
				$("#editSptMeetingItemDialog").dialog("close");
			} else {
				$.messager.alert("操作提示", "运动会项目信息更新失败，请稍后再尝试!", "error");
			}
		}); 
	}
</script>