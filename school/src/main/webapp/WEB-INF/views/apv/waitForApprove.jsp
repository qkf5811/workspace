<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">

	<div style="padding:5px" id="waitForApvToolbar">
			<input hidden="true" id="userId" value="${user.id }">
			<input hidden="true" id="userName" value="${user.name }">
			<span>申请名称：</span>
			<input class="easyui-validatebox textbox" id="apvName"
				name="apvName" style="width: 100px; height: 18px; padding: 5px" />


			<span>申请类型:</span>
			<select class="easyui-combobox" id="apvApplicationType"
						name="apvApplicationType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['apvApplicationType']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationTypeList}" var="applicationType">
							<option value="${applicationType.id}">${applicationType.name}</option>
							</c:forEach>					
				</select>
			<span>申请人:</span>
			<input class="easyui-validatebox textbox" id="apvUser"
				name="apvUser" style="width: 100px; height: 18px; padding: 5px" />

			<span>申请状态:</span>
				<select class="easyui-combobox" id="apvApplicationStatus"
						name="apvApplicationStatus"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['apvApplicationStatus']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationStatusList}" var="applicationStatus">
							<option value="${applicationStatus.id}">${applicationStatus.name}</option>
							</c:forEach>					
			</select>
			
			<a href="#" class="easyui-linkbutton" plain="true"
				onclick="searchApvApplication('#waitForApvToolbar', '#datagridOfWaitForApprove')"
				iconCls="icon-search">查询</a>
		</div>
	<!-- datagrid -->
	<!-- 	   url="${contextPath }/apv/findApproveSettingByApplicationType.do?applicationType=0" -->
	<table id="datagridOfWaitForApprove" class="easyui-datagrid" pagination="true"
			  rownumbers="true" singleSelect="true" data-options="pageSize:10"
			  toolbar="#waitForApproveToolbar"
			  url="${contextPath}/apv/getApvApplicationListWithoutPass.do?userId=${userId}"
			  style="padding: 5px;">
			
		<thead>
			<tr>
				<th field="name" width="90" align="center">申请名称</th>
				<th field="applicationTypeStr" width="120" align="center">申请类型</th>
				<th field="reason" width="90" align="center">申请原因</th>
				<th field="departmentName" width="90" align="center">申请部门</th>
				<th field="userName" width="120" align="center">申请人</th>
				<th field="applicationStatusStr" width="120" align="center">申请状态</th>
				<th field="appTimeStr" width="90" align="center">申请时间</th>
				<th field="nodeName" width="90" align="center">当前审批节点</th>
				<th field="remark" width="100" align="center">备注</th>
			</tr>
		</thead>
	</table>
	
	<div id="waitForApproveToolbar">
		<a href="javascript:void(0)"  class="easyui-linkbutton" plain="true" iconCls="icon-edit"
		   onclick="approveNode()">审批</a>
	</div>
	
	<!-- 弹出审批的窗口 -->
	<div id="approvalNodeWindow" class="easyui-window" title="审评申请"
		data-options="modal:true,iconCls:'icon-edit',closed:true"
		style="width: 380px; height: 300px; padding: 5px;">
	
		<table style="margin: 15px auto">
			<tr hidden="true">
				<td>申请id:</td>
				<td><input type="text" id="appId"></td>
			</tr>
			<tr hidden="true">
				<td>审批节点:</td>
				<td><input type="text" id="apvId"></td>
			</tr>
			<tr hidden="true">
				<td>审批角色:</td>
				<td><input type="text" id="apvRole"></td>
			</tr>
			<tr hidden="true">
				<td>审批人id:</td>
				<td><input type="text" id="apvUserId"></td>
			</tr>
			<tr>
				<td>审批人:</td>
				<td><input id="apvUserName" class="easyui-textbox" editable="false"
							disabled="true"
							style="width: 160px;height: 33px"></td>
			</tr>
			<tr>
				<td>审批结果:</td>
				<td><select id="apvResult" class="easyui-combobox" style="width: 160px;height: 33px"
					 data-options="editable:false, panelHeight:'auto',panelWidth:'150px'">
					 <c:forEach items="${apvResult }" var="item">
					 	<option value="${item.id }">${item.name }</option>
					 </c:forEach>
					 </select></td>
			</tr>
			<tr>
				<td>审批意见:</td>
				<td><input id="apvSuggestion" class="easyui-textbox" style="width: 160px;height: 33px"></td>
			</tr>
			<tr>
				<td>审批时间:</td>
				<td><input id="apvTime" class="easyui-datetimebox" editable="false"
					data-options="required:true, novalidate:true"
					style="width: 160px;height: 33px"></td>
			</tr>
		</table>
		
		<div style="margin-top:25px;text-align:center">
			<a href="javascript:void(0)" iconCls="icon-ok" class="easyui-linkbutton"
				onclick="postApprove('#approvalNodeWindow', '#datagridOfWaitForApprove')">提交审批</a>
				<a href="javascript:void(0)" iconCls="icon-cancel" class="easyui-linkbutton"
				onclick="closeApvWindow()">关闭审批</a>
		</div>
	</div>
</div>

<script>
	
	function searchApvApplication(toolbar, datagrid) {
		var apvName = $(toolbar).find("#apvName").val();
		var apvUser = $(toolbar).find("#apvUser").val();
		var apvApplicationType = $(toolbar).find("#apvApplicationType").combobox('getValue');	
		var apvApplicationStatus = $(toolbar).find("#apvApplicationStatus").combobox('getValue');
		//!-AJAX请求数据

		$(datagrid).datagrid('load', {
			name : apvName,
			applicationType : apvApplicationType,
			user : apvUser,
			applicationStatus : apvApplicationStatus
		});
	}
	
	//审批
	function approveNode() {
		
		var row = $("#datagridOfWaitForApprove").datagrid("getSelected");
	//	alert(row.id);
		if (row == null) {
			$.messager.alert("操作提示", "请先选择一个需要审批的节点!", "warning");
		} else {
			//打开审批窗口
			$("#approvalNodeWindow").window("open");
			$("#approvalNodeWindow").find("#appId").val(row.id);
			$("#approvalNodeWindow").find("#apvId").val(row.nodeId);
			$("#approvalNodeWindow").find("#apvUserId").val($("#waitForApvToolbar").find("#userId").val());
			$("#approvalNodeWindow").find("#apvUserName").textbox('setValue',$("#waitForApvToolbar").find("#userName").val());
		}
	}
	
	//关闭审批窗口
	function closeApvWindow() {
		$("#approvalNodeWindow").window("close");
	}
	
	//提交审批
	function postApprove(window, datagrid) {
	//	alert("approval");
	
		//在提交数据之前执行表单验证
		$(window).form("enableValidation").form('validate');
    	//判断表单验证是否通过
		if(!$(window).form('validate')){
			return false;
		} 
		var param = {
				
				applicationId : $(window).find('#appId').val(),
				nodeId : $(window).find('#apvId').val(),
				userId : $(window).find('#apvUserId').val(),
				approvalStatus : $(window).find('#apvResult').combobox("getValue"),
				opinion : $(window).find('#apvSuggestion').textbox('getValue'),
				apvTime : $(window).find('#apvTime').datetimebox('getValue')
		};
	//	console.log(param);
		$.post("${contextPath}/apv/postApprove.do",
			param,
			function (data) {
				data = eval('(' + data + ')');
		//		alert(data.result);
				if (data.result == 1) {
					$.messager.alert("操作提示", "审批信息提交成功!", "info");
					$(datagrid).datagrid('reload');
				} else {
					$.messager.alert("操作提示", "审批信息提交失败!", "info");
				}
		});
		//提交后关闭窗口,刷新datagrid
	//	$(datagrid).datagrid('reload');
		closeApvWindow();
	}
</script>