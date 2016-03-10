<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">
	<div id="allApplicationToolbar" style="padding: 5px; height: auto">
		<div>

			<td>申请名称：</td>
			<td><input class="easyui-validatebox textbox" id="allApvName"
				name="allApvName" style="width: 100px; height: 18px; padding: 5px" />

			</td>

			<td>申请类型:</td>
				<td><select class="easyui-combobox" id="allApplicationType"
						name="allApplicationType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['allApplicationType']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${applicationTypeList}" var="applicationType">
							<option value="${applicationType.id}">${applicationType.name}</option>
							</c:forEach>					
				</select>
			</td> 	
			<td>申请人:</td>
			<td><input class="easyui-validatebox textbox" id="allApvUser"
				name="allApvUser" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			<td>申请状态:</td>
				<td><select class="easyui-combobox" id="allApplicationStatus"
						name="allApplicationStatus"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['allApplicationStatus']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${applicationStatusList}" var="applicationStatus">
							<option value="${applicationStatus.id}">${applicationStatus.name}</option>
							</c:forEach>					
				</select>
			</td> 	
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchAllApplication('#allApplicationToolbar', '#allApplicationList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="allApplicationList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		url="${contextPath}/apv/getAllApplicationList.do"
		toolbar="#allApplicationOperToolbar" rownumbers="true"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="90" align="center">申请名称</th>
				<th field="applicationTypeStr" width="120" align="center">申请类型</th>
				<th field="reason" width="90" align="center">申请原因</th>
				<th field="departmentName" width="90" align="center">申请部门</th>
				<th field="userName" width="120" align="center">申请人</th>
				<th field="applicationStatusStr" width="120" align="center">申请状态</th>
				<th field="appTimeStr" width="90" align="center">申请时间</th>
				<th field="remark" width="100" align="center">备注</th>
				
			</tr>
		</thead>
	</table>
	<div id="allApplicationOperToolbar">
	
	
	</div>
	

</div>

<script type="text/javascript">
	

	function searchAllApplication(toolbar, datagrid) {
		var allApvName = $(toolbar).find("#allApvName").val();
		var allApvUser = $(toolbar).find("#allApvUser").val();
		var allApplicationType = $(toolbar).find("#allApplicationType").combobox('getValue');	
		var allApplicationStatus = $(toolbar).find("#allApplicationStatus").combobox('getValue');
		//!-AJAX请求数据

		$(datagrid).datagrid('load', {
			name : allApvName,
			applicationType : allApplicationType,
			user : allApvUser,
			applicationStatus : allApplicationStatus
		});
	}
	
	
	
</script>
