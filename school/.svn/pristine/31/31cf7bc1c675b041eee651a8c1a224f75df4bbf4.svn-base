<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">
	<div id="apvApplicationToolbar" style="padding: 5px; height: auto">
		<div>
			<tr style="diplay:none">
				<input id="userId" name="userId" type="hidden" value="<c:out value='${userId}'/>" />
			</tr>
			
			
			<td>申请名称：</td>
			<td><input class="easyui-validatebox textbox" id="apvName"
				name="apvName" style="width: 100px; height: 18px; padding: 5px" />

			</td>

			<td>申请类型:</td>
				<td><select class="easyui-combobox" id="apvApplicationType"
						name="apvApplicationType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['apvApplicationType']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${applicationTypeList}" var="applicationType">
							<option value="${applicationType.id}">${applicationType.name}</option>
							</c:forEach>					
				</select>
			</td> 	
			<td>申请人:</td>
			<td><input class="easyui-validatebox textbox" id="apvUser"
				name="apvUser" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			<td>申请状态:</td>
				<td><select class="easyui-combobox" id="apvApplicationStatus"
						name="apvApplicationStatus"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['apvApplicationStatus']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${applicationStatusList}" var="applicationStatus">
							<option value="${applicationStatus.id}">${applicationStatus.name}</option>
							</c:forEach>					
				</select>
			</td> 	
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchApvApplication('#apvApplicationToolbar', '#apvApplicationList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="apvApplicationList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		url="${contextPath}/apv/getApvApplicationList.do?userId=${userId}"
		toolbar="#apvApplicationOperToolbar" rownumbers="true"
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
	<!-- 弹出申请类型选择的窗口 -->
	<div id="chooseApplicationTypeDialog" class="easyui-dialog" title="选择申请类型"
		data-options="modal:true,iconCls:'icon-add',closed:true, buttons:'#chooseBtn'"
		style="width: 270px; height: 185px; padding: 5px;">
		<form id="chooseApplicationForm" method="post">
			<table  align="center">
				<tr height="20px">
					<td>申请类型:</td>
					<td><select class="easyui-combobox" id="applicationType"
							name="applicationType"
							data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
							validtype="selectRequired['applicationType']"
							style="width: 105px; height: 33px; padding: 5px">
								<option value="">请选择</option>
								<c:forEach items="${applicationTypeList}" var="applicationType">
								<option value="${applicationType.id}">${applicationType.name}</option>
								</c:forEach>					
					</select>
				</td> 	
			</table>
		</form>
		<div id="#chooseBtn" style="text-align: center; padding: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="chooseApplicationTypeOk();">确定</a>&nbsp;&nbsp;
			&nbsp;&nbsp; <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'" onclick="cancel();">
				取消</a>
		</div>
	</div>
	<div id="apvApplicationOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="chooseApplicationType()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditApvApplication('#chooseApplicationForm')">编辑草稿</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteApplication()">删除草稿</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditApvApplication()">我审批的申请表</a>
	
	</div>
	
	

	

</div>

<script type="text/javascript">
	
	

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
	
	//选择申请类型
	function chooseApplicationType() {
		$('#chooseApplicationTypeDialog').dialog('open');
	}
	
	//选择好申请类型
	function chooseApplicationTypeOk(form) {
		//在提交数据之前执行表单验证
		$('#chooseApplicationForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$('#chooseApplicationForm').form('validate')) {
			return false;
		}
		
		openTab('equ/toAddUseApplication.do?userId=${userId}','新增申请表');
		
		cancel();
		
	}
	
	function cancel() {
		$('#chooseApplicationTypeDialog').dialog('close');
		$('#chooseApplicationTypeDialog').find('#applicationType').combobox('setValue','请选择');
	}
	
	function toEditApvApplication() {

		
		var row = $('#apvApplicationList').datagrid('getSelected');
		if(row) {
			if(row.applicationStatus==42001) {
				openTab('apv/toEditApplication.do?id=' + row.id + "&name=" + row.name+ "&departmentName=" + row.departmentName+ "&reason=" + row.reason+ "&applicationType=" + row.applicationType+ "&userId=" + row.userId
						+ "&applicationStatus=" + row.applicationStatus+ "&appTime=" + row.appTime+ "&nodeId=" 
						+ row.nodeId+ "&remark=" + row.remark+ "&userName=" + row.userName+ "&departId=" + row.departId, '申请草稿编辑');
			}else {
				$.messager.alert("操作提示", "此记录已经在申请中，不可编辑！", "warning");
			}
		}else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
		
		
	}
	
	function deleteApplication(){
    	
        var row = $('#apvApplicationList').datagrid('getSelected');
        if(row) {
			if(row.applicationStatus==42001) {
				 $.messager.confirm('请确认...','您确定要删除此草稿吗?',function(r){
		                if (r){
		                    $.post('apv/deleteApplication.do',{id:row.id},function(result){
		                        if (result.success){
		                        	$.messager.alert("操作提示", "删除成功！","info");
		                            $('#apvApplicationList').datagrid('reload');    // reload the user data
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
