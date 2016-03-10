<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="querySptMeeting">
		<span>启动时间(从): </span> <input class="easyui-datetimebox"
			editable="false" id="launchDatetime"
			name="launchDatetime"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			onclick="$('#launchDatetime').datetimebox('setValue', '')"
			data-options="plain:true">清空</a>
			<span>名称:</span>
			<input class="easyui-textbox"
			id="meetingName"
			name="meetingName"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			iconCls="icon-search" onclick="queryStpMeetingList()"
			data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="sptMeetingListForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="sptMeetingListDatagrid"
				pagination="true" toolbar="#sptMeetingListToolbar"
				url="${contextPath}/spt/querySptMeetingList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="id" width="120px" align="center">id</th>
						<th field="theme" width="180px" align="center">主题</th>
						<th field="launchDatetime" width="180px" align="center">启动时间</th>
						<th field="remark" width="300px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="sptMeetingListToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#addSptMeeting').dialog('open')">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="addBuilding"
					data-options="plain:true" onclick="editSptMeetingInfo('#editSptMeeting', '#editSptMeetingForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove" id="delBuilding"
					data-options="plain:true" onclick="deleteSptMeetingById()">删除</a>
			</div>
		</div>
	</form>
</div>
<!-- 弹出添加运动会信息的对话框 -->
<div id="addSptMeeting" class="easyui-dialog" title="添加运动会信息"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addSptMeetingBtn'"
	style="width: auto; height: auto; padding: 17px;">
	<form id="addSptMeetingForm">
		<table cellpadding="7" align="center">
			<tr>
				<td>主题:</td>
				<td><input class="easyui-textbox" editable="true"
					id="theme" name="theme"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>启动时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="launchDatetime" name="launchDatetime"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
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

	<div id="addSptMeetingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addSptMeetingInfo()">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-reload"
			onclick="resetSptMeetingInto()">重置</a>
	</div>
</div>

<!-- 弹出编辑运动会信息的对话框 -->
<div id="editSptMeeting" class="easyui-dialog" title="编辑运动会信息"
	data-options="modal:true,iconCls:'icon-edit',closed:true , buttons:'#editSptMeetingBtn'"
	style="width: auto; height: auto; padding: 17px;">
	<form id="editSptMeetingForm">
		<table cellpadding="7" align="center">
			<tr>
				<td>id:</td>
				<td><input class="easyui-textbox" editable="false"
					id="id" name="id"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>主题:</td>
				<td><input class="easyui-textbox" editable="true"
					id="theme" name="theme"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
					style="width: 280px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>启动时间:</td>
				<td><input class="easyui-datetimebox" editable="false"
					id="launchDatetime" name="launchDatetime"
					data-options="required:true,missingMessage:'该处未填写',novalidate:true"
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

	<div id="editSptMeetingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updSptMeetingInfo('#editSptMeetingForm')">更新</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-reload"
			onclick="resetSptMeetingInto()">重置</a>
	</div>
</div>

<script type="text/javascript">
	function addSptMeetingInfo() {
		//表单验证
		$("#addSptMeetingForm").form('enableValidation').form('validate');
		if (!$('#addSptMeetingForm').form('validate'))
			return false;
		$.post("${contextPath}/spt/addStpMeeting.do",$("#addSptMeetingForm").serialize(), function(data) {
			if (data == 1) {
				$.messager.alert("操作提示", "运动会信息录入成功!", "info");
				$("#sptMeetingListForm").find("#sptMeetingListDatagrid").datagrid('reload');
			} else {
				$.messager.alert("操作提示", "运动会信息录入失败，请稍后再尝试!", "error");
				
			}
			$('#addSptMeeting').dialog('close');
			$('#addSptMeetingForm').form('clear')
		});
	}

	function resetSptMeetingInto() {
		$("#addSptMeetingForm").form("clear");
		$("#addSptMeetingForm").form('disableValidation').form('validate');
	}

	function editSptMeetingInfo(dialog, form) {
		var row = $("#sptMeetingListDatagrid").datagrid("getSelected");
		if (row) {
			$(dialog).dialog("open");
			$(form).find("#id").textbox("setValue", row.id);
			$(form).find("#theme").textbox("setValue", row.theme);
			$(form).find("#launchDatetime").datetimebox("setValue", row.launchDatetime);
			$(form).find("#remark").textbox("setValue", row.remark);
		} else {
			$.messager.alert("操作提示", "请先选择一行记录!", "warning");
		}
	}

	function updSptMeetingInfo(form) {
		$.post("${contextPath}/spt/updateStpMeeting.do", $(form).serialize(), function(data) {
			if (data == 1) {
				$.messager.alert("操作提示", "运动会信息更新成功!", "info");
				$("#sptMeetingListForm").find("#sptMeetingListDatagrid").datagrid('reload');
			} else {
				$.messager.alert("操作提示", "运动会信息更新失败，请稍后再尝试!", "error");
			}
			$('#editSptMeeting').dialog('close');
			$('#editSptMeetingForm').form('clear');
		});
	}

	function deleteSptMeetingById() {
		var row = $("#sptMeetingListDatagrid").datagrid("getSelected");
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此运动会信息吗?", function(data) {
				if (data)
					$.post("${contextPath}/spt/deleteSptMeeting.do", {
						id : row.id
					}, function (data) {
						if (data == 1) {
							$.messager.alert("操作提示", "运动会信息删除成功!", "info");
							$("#sptMeetingListForm").find("#sptMeetingListDatagrid").datagrid('reload');
						} else {
							$.messager.alert("操作提示", "运动会信息删除失败，请稍后再尝试!", "error");
						}
					});
				else
					;
			});
			
		} else {
			$.messager.alert("操作提示", "请先选择一行记录!", "warning");
		}
	}

	function queryStpMeetingList() {
		$("#sptMeetingListForm").find("#sptMeetingListDatagrid").datagrid({
			url : "${contextPath}/spt/querySptMeetingList.do",
			queryParams : {
				theme : $("#querySptMeeting").find("#meetingName").textbox("getValue"),
				launchDatetimeStr : $("#querySptMeeting").find("#launchDatetime").datetimebox("getValue")
			}
		});
	}
</script>