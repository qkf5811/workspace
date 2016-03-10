<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkTaskListCondition">
		<span>时间 </span> <span>从:</span> <input class="easyui-datetimebox"
			editable="false" id="startDateTimeOfWorkTask"
			name="startDateTimeOfWorkTask"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" /><a
			class=""> <a class="easyui-linkbutton"
			onclick="$('#startDateTimeOfWorkTask').datetimebox('setValue', '')"
			data-options="plain:true">清空</a> <span>到:</span> <input
			class="easyui-datetimebox" editable="false" id="endDateTimeOfWorkTask"
			name="endDateTimeOfWorkTask"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			onclick="$('#endDateTimeOfWorkTask').datetimebox('setValue', '')"
			data-options="plain:true">清空</a> 
			<span>模糊查找(任务):</span>
			<input class="easyui-textbox"
			id="taskName"
			name="taskName"
			style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
			<a class="easyui-linkbutton"
			iconCls="icon-search" onclick="queryPeWorkTaskList()"
			data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkListForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkTaskListDatagrid"
				pagination="true" toolbar="#peWorkTaskListToolbar"
				url="${contextPath}/pe/queryPeWorkTaskList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="id" width="120px" align="center" hidden>id</th>
						<th field="workInfoId" width="120px" align="center" hidden>工作id</th>
						<th field="personInfoId" width="120px" align="center" hidden>负责人id</th>
						<th field="mission" width="380px" align="left">任务</th>
						<th field="name" width="120px" align="center">负责人</th>
						<th field="startDatetime" width="180px" align="center">开始时间</th>
						<th field="endDatetime" width="180px" align="center">结束时间</th>
						<th field="remark" width="300px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="peWorkTaskListToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#peWorkTaskInfoMainDoalog').dialog('open')">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-remove" id="delBuilding"
					data-options="plain:true" onclick="deletePeWorkTaskById()">删除</a>
			</div>
		</div>
	</form>
</div>

<!-- 弹出添加人员工作任务的对话框 -->
<div id="peWorkTaskInfoMainDoalog" class="easyui-dialog" title="添加工作任务"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addPeWorkTaskBtn'"
	style="width: 580px; height: 540px; padding: 17px;">
	<form id="workTaskInfoMainForm">
		<table cellpadding="7" align="center">
			<tr hidden>
				<td>工作任务id:</td>
				<td><input class="easyui-textbox" editable="false"
					id="missionId" name="missionId"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>工作任务:</td>
				<td><input class="easyui-textbox" id="mission" name="mission"
					data-options="multiline:true, required:true, missingMessage:'该处未填写', novalidate:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
				<td><a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#peWorkListInWorkTaskDialog').dialog('open')">选择任务</a></td>
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
			<tr hidden>
				<td>负责人id:</td>
				<td><input class="easyui-textbox" editable="false"
					id="personIdOfWorkTask" name="personIdOfWorkTask"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>负责人工号:</td>
				<td><input class="easyui-textbox" editable="false"
					id="personCodeOfWorkTask" name="personCodeOfWorkTask"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
					<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="$('#perInfoDialogInWorkTask').dialog('open')">选择人员</a>
				</td>
			</tr>
			<tr>
				<td>负责人姓名:</td>
				<td><input class="easyui-textbox" editable="false"
					id="personNameOfWorkTask" name="personNameOfWorkTask"
					style="width: 180px; height: 25px; padding: 10px; font-size: 15px" />
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="remarkOfWorkTask" name="remarkOfWorkTask"
					data-options="multiline:true"
					style="width: 280px; height: 100px; font-size: 15px"></td>
			</tr>
		</table>
	</form>

	<div id="addPeWorkTaskBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addPeWorkTask()">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-reload"
			onclick="resetWorkTask()">重置</a>
	</div>
</div>
<!-- 弹出选择工作 -->
	<!-- datagrid -->
		<div id="peWorkListInWorkTaskDialog"  class="easyui-dialog" title="选择体育工作" 
		iconCls="icon-search"
		style="width: auto; height: auto"
		top="200px" data-options="resizable:true,modal:true, closed:true, buttons:'#btnOfWorkListInWorkTask'">
			<table class="easyui-datagrid" id="peWorkListDatagrid"
				pagination="true"
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
			<div id="btnOfWorkListInWorkTask">
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="selectWorkInfo()">选择</a>
			</div>
		</div>
		
<!-- 弹出选择工作组人员 -->
<div class="easyui-dialog" title="选择工作组人员" iconCls="icon-search"
	id="perInfoDialogInWorkTask" style="width: auto; height: auto"
	top="200px" data-options="resizable:true,modal:true, closed:true">
	<div>
	<!-- 查询条件 -->
	<form style="margin: 5px" id="queryPeWorkGroupPersonInfoListConditionInWorkTask">
		<span>工作组职位:</span> <select class="easyui-combobox"
			id="workGroupPositionInWorkTask" name="workGroupPositionInWorkTask"
			style="width: 150px; height: 25px"
			data-options="novalidate:true,panelHeight: 'auto'"
			validtype="selectRequired['campusRefer']" editable="false">
			<option value="0">请选择</option>
			<c:forEach items="${positions}" var="position">
				<option value="${position['id']}">${position['name']}</option>
			</c:forEach>
		</select> <span>教职工名称:</span> <input class="easyui-textbox"
			id="teaNameInWorkGroupInWorkTask" name="teaNameInWorkGroupInWorkTask"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search"
			onclick="queryPeWorkGroupPersonInfoListInWorkTask()" data-options="plain:false">查询</a>
	</form>
	<!-- datagrid -->
	<form id="peWorkGroupPersonListFormInWorkTask">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="peWorkGroupPersonListInWorkTask"
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
		onclick="selectPePersonInfo()">选择</div>
</div>
<script type="text/javascript">
	function queryPeWorkTaskList() {
		var start = $("#queryPeWorkTaskListCondition").find("#startDateTimeOfWorkTask").textbox('getValue');
		var end = $("#queryPeWorkTaskListCondition").find("#endDateTimeOfWorkTask").textbox('getValue');
		var mission = $("#queryPeWorkTaskListCondition").find("#taskName").textbox('getValue');
		$("#peWorkTaskListDatagrid").datagrid({
			url : "${contextPath}/pe/queryPeWorkTaskList.do",
			queryParams : {
				startDatetimeStr : start,
				endDatetimeStr : end,
				mission : mission
			}
		});
	}
	
	function selectPePersonInfo() {
		var row = $("#peWorkGroupPersonListFormInWorkTask").find("#peWorkGroupPersonListInWorkTask")
		.datagrid('getSelected');
		if (row) {
			console.log(row);
			$("#workTaskInfoMainForm").find("#personIdOfWorkTask").textbox('setValue', row.id);
			$("#workTaskInfoMainForm").find("#personCodeOfWorkTask").textbox('setValue', row.code);
			$("#workTaskInfoMainForm").find("#personNameOfWorkTask").textbox('setValue', row.name);
			$("#perInfoDialogInWorkTask").dialog("close");
		} else {
			$.messager.alert("操作提示", "请先选择体育工作组人员信息!", "warning");
		}
	}

	function deletePeWorkTaskById() {
		var row = $('#peWorkTaskListDatagrid').datagrid('getSelections');
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择需要删除的体育工作任务信息!", "warning");
			return;
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "不能同时删除多项体育工作任务信息!", "warning");
			return;
		} else {
			$.messager.confirm("请确认...", "您确定要删除此体育工作任务信息吗?", function(data) {
				if (data)
					$.post('${contextPath}/pe/deletePeWorkTaskById.do', {
						id : row[0].id
					}, function(data) {
						if (data == 1) {
							$.messager.alert("操作提示", "体育工作任务信息删除成功!", "info");
							$("#peWorkTaskListDatagrid").datagrid("reload");
						} else {
							$.messager.alert("操作提示", "体育工作任务信息删除失败，请稍后再尝试!", "warning");
						}
					})
				else
					;
			});
		}
	}

	function selectWorkInfo() {
		var row = $("#peWorkListInWorkTaskDialog").find('#peWorkListDatagrid').datagrid('getSelected');
		if (row) {
			console.log(row.id)
			$("#workTaskInfoMainForm").find("#missionId").textbox('setValue', row.id);
			$("#workTaskInfoMainForm").find("#mission").textbox('setValue', row.mission);
			$("#workTaskInfoMainForm").find("#startDatetime").datetimebox('setValue', row.startDatetime);
			$("#workTaskInfoMainForm").find("#endDatetime").datetimebox('setValue', row.endDatetime);
			$("#peWorkListInWorkTaskDialog").dialog("close");
		} else {
			$.messager.alert("操作提示", "请先选择体育工作信息!", "warning");
		}
	}

	function queryPeWorkGroupPersonInfoListInWorkTask() {
		var position = $("#workGroupPositionInWorkTask").combobox("getValue");
		var name = $("#teaNameInWorkGroupInWorkTask").val();
		$("#peWorkGroupPersonListFormInWorkTask").find("#peWorkGroupPersonListInWorkTask")
				.datagrid({
					url : "${contextPath}/pe/queryPersonList.do",
					queryParams : {
						workGroupPosition : position,
						teaNameInWorkGroup : name
					}
				});
	}

	function resetWorkTask() {
		$("#workTaskInfoMainForm").find("#personIdOfWorkTask").textbox('setValue', "");
		$("#workTaskInfoMainForm").find("#personCodeOfWorkTask").textbox('setValue', "");
		$("#workTaskInfoMainForm").find("#personNameOfWorkTask").textbox('setValue', "");
		$("#workTaskInfoMainForm").find("#missionId").textbox('setValue', "");
		
		$("#workTaskInfoMainForm").find("#mission").textbox('setValue', "");
		$("#workTaskInfoMainForm").find("#startDatetime").datetimebox('setValue', "");
		$("#workTaskInfoMainForm").find("#endDatetime").datetimebox('setValue', "");
		$("#remarkOfWorkTask").textbox("setValue", "");
	}

	function addPeWorkTask() {
		var perid = $("#workTaskInfoMainForm").find("#personIdOfWorkTask").textbox("getValue");
		var missionId = $("#workTaskInfoMainForm").find("#missionId").textbox("getValue");
		var remark = $("#remarkOfWorkTask").textbox("getValue");
		if (perid == null || perid.trim() == "") {
			$.messager.alert("操作提示", "未选择体育工作负责人!", "warning");
			return ;
		} 
		if (missionId == null || missionId.trim() == "") {
			$.messager.alert("操作提示", "未选择体育工作任务!", "warning");
			return ;
		}
		$.post("${contextPath}/pe/addPeWorkTask.do", {
			workInfoId : missionId,
			personInfoId : perid,
			remark : remark
		}, function(data) {
			if (data == 1) {
				$("#peWorkTaskInfoMainDoalog").dialog("close");
				$("#peWorkListForm").find("#peWorkTaskListDatagrid").datagrid("reload");
				$.messager.alert("操作提示", "体育工作任务设置成功!", "info");
			} else {
				$("#peWorkTaskInfoMainDoalog").dialog("close");
				$.messager.alert("操作提示", "体育工作任务设置失败，请稍后再尝试!", "warning");
			}
		});
	}
</script>