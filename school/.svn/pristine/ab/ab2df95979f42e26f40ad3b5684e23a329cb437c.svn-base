<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">
	<div id="useApplicationToolbar" style="padding: 5px; height: auto">
		<div>

			<td>申请名称：</td>
			<td><input class="easyui-validatebox textbox" id="zj_use_name"
				name="zj_use_name" style="width: 100px; height: 18px; padding: 5px" />

			</td>

		
			<td>设备名称:</td>
			<td><input class="easyui-validatebox textbox" id="zj_use_equipName"
				name="zj_use_equipName" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			<td>申请状态:</td>
				<td><select class="easyui-combobox" id="zj_use_useApplicationStatus"
						name="zj_use_useApplicationStatus"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['zj_use_useApplicationStatus']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${applicationStatusList}" var="applicationStatus">
							<option value="${applicationStatus.id}">${applicationStatus.name}</option>
							</c:forEach>					
				</select>
			</td> 	
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchUseApplication('#useApplicationToolbar', '#useApplicationList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="useApplicationList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		url="${contextPath}/equ/getUseApplicationList.do?userId=${userId}"
		toolbar="#useApplicationOperToolbar" rownumbers="true"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="apvApplicationName" width="120" align="center">申请名称</th>
				<th field="departName" width="120" align="center">申请部门</th>
				<th field="equipName" width="120" align="center">设备名称</th>
				<th field="model" width="100" align="center">设备型号</th>
				<th field="reason" width="150" align="center">申请原因</th>
				<th field="appTimeStr" width="120" align="center">申请时间</th>
				<th field="amount" width="90" align="center">申请设备数量</th>
				<th field="applicationStatusStr" width="100" align="center">申请状态</th>
				<th field="remark" width="130" align="center">备注</th>
				
			</tr>
		</thead>
	</table>
	<div id="useApplicationOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="openTab('equ/toAddUseApplication.do?userId=${userId}','新增申请表')">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditUseApplication()">编辑草稿</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUseApplication()">删除草稿</a>
	</div>
	

</div>

<script type="text/javascript">
	
	

	function searchUseApplication(toolbar, datagrid) {
		var useName = $(toolbar).find("#zj_use_name").val();
		var equipName = $(toolbar).find("#zj_use_equipName").val();
		var useApplicationStatus = $(toolbar).find("#zj_use_useApplicationStatus").combobox('getValue');
		//!-AJAX请求数据

		$(datagrid).datagrid('load', {
			name : useName,
			equipName : equipName,
			applicationStatus : useApplicationStatus
		});
	}
	
	
	function toEditUseApplication() {

	
		var row = $('#useApplicationList').datagrid('getSelected');
		if(row) {
			if(row.applicationStatus==42001) {
				openTab('equ/toEditUseApplication.do?id=' + row.id
						+ "&applicationId="+ row.applicationId
						+ "&apvApplicationName="+ row.apvApplicationName
						+ "&departName=" + row.departName
						+ "&departId=" + row.departId
						+ "&applicationType=" + row.applicationType
						+ "&userId=" + row.userId
						+ "&applicationStatus=" + row.applicationStatus
						+ "&appTime=" + row.appTime
						+ "&nodeId=" + row.nodeId
						+ "&remark=" + row.remark
						+ "&amount=" + row.amount
						+ "&model=" + row.model+ "&reason=" + row.reason+ "&equipName=" + row.equipName, '申请草稿编辑');
			}else {
				$.messager.alert("操作提示", "此记录已经在申请中，不可编辑！", "warning");
			}
		}else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
		
		
	}
	
	function deleteUseApplication(){
    	
        var row = $('#useApplicationList').datagrid('getSelected');
        if(row) {
			if(row.applicationStatus==42001) {
				 $.messager.confirm('请确认...','您确定要删除此草稿吗?',function(r){
		                if (r){
		                    $.post('equ/deleteUseApplication.do',{id:row.id,applicationId:row.applicationId},function(result){
		                        if (result.success){
		                        	$.messager.alert("操作提示", "删除成功！","info");
		                            $('#useApplicationList').datagrid('reload');    // reload the user data
		                        } else {
		                            $.messager.show({    // show error message
		                                title: 'Error',
		                                msg: '删除此草稿失败'
		                            });
		                        }
		                    },'json');
		                }
		            });
			}else {
				$.messager.alert("操作提示", "此记录已经在申请中，不可删除！", "warning");
			}
		}else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
      

	}  
</script>
