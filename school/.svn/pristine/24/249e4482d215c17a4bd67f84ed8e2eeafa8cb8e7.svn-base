<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div  style="width: 99%; height: auto">

	<div style="padding:5px" id="approveAppToolbar">

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
				onclick="searchApvApplication('#approveAppToolbar', '#datagridOfApproveApplication')"
				iconCls="icon-search">查询</a>
		</div>
	<!-- datagrid -->
	<!-- 	   url="${contextPath }/apv/findApproveSettingByApplicationType.do?applicationType=0" -->
	<table id="datagridOfApproveApplication" class="easyui-datagrid" pagination="true"
			  rownumbers="true" singleSelect="true" data-options="pageSize:10"
			  toolbar="#approveApplicationToolbar"
			  url="${contextPath}/apv/getApvApplicationListWithApproved.do?userId=${userId}"
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
	
	<div id="approveApplicationToolbar">
	<!-- 	<a href="javascript:void(0)"  class="easyui-linkbutton" plain="true" iconCls="icon-search"
		   onclick="checkNodeInfo()">查看详情</a>
	</div> -->
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
</script>
</div>