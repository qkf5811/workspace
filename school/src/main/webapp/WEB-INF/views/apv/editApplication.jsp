<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="editApplicationForm" method="post">
		<table cellpadding="7">
				
			<tr style="diplay:none">
				<input id="userId" name="userId" type="hidden" value="<c:out value='${userId}'/>" />
			</tr>
			<tr style="diplay:none">
				<input id="applicationId" name="applicationId" type="hidden" value="<c:out value='${applicationId}'/>" />
			</tr>
			<tr style="diplay:none">
				<input id="applicationTypeId" name="applicationTypeId" type="hidden" value=<c:out value='${applicationType}'/> />
			</tr>
			<%-- <tr style="diplay:none">
				<input id="remarkId" name="remarkId" type="hidden" value=<c:out value='${remark}'/> />
			</tr>
			 --%>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="apvName" name="apvName" value="<c:out value='${name}'/>"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请类型:</td>
					<td><select class="easyui-combobox" id="newApplicationType"
						name="newApplicationType" 
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['newApplicationType']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationTypeList}" var="applicationType">
							<option value="${applicationType.id}">${applicationType.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请原因:</td>
			
					<td><input class="easyui-validatebox textbox" type="text"
						id="reason" name="reason" value="<c:out value='${reason}'/>"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请部门:</td>

					<td><input class="easyui-textbox" type="text"
						id="departmentName" name="departmentName" value="<c:out value='${departName}'/>"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择您申请的部门'"
						style="height: 31px; width: 208px"></input><input id="departmentId" name="departmentId" value="<c:out value='${departId}'/>" type="hidden"/>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="remark" name="remark" value="<c:out value='${remark}'/>"
						data-options="required:true,validType:'length[1,300]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-300' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
		
	
		</table>
	<!-- 	<div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="3" cols="60"></textArea>
		</div> -->
	</form>

	<div style="margin-left:180px; margin-top:20px;padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editWithDraft('#editApplicationForm')">继续存为草稿</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addEditApplication('#editApplicationForm')">提交申请</a>
	</div>
	
	<%@ include file="/WEB-INF/views/apv/apv_select_department_dialog.jsp"%>
	
</div>


<script type="text/javascript">

	$(function() {
	
		$("#editApplicationForm").find('#newApplicationType').val($("#editApplicationForm").find("#applicationTypeId").val());
		/* $("#editApplicationForm").find('#remark').val($("#editApplicationForm").find("#remarkId").val()); */
		$("#editApplicationForm").find("#departmentName").textbox({
			onClickButton : function() {
				openNewSelectDepartmentDialog();
			}
		})

	

	});
	
	function openNewSelectDepartmentDialog() {
		$('#select-department-dialog').find('#departmentOpenForm').val("#editApplicationForm");
		$('#select-department-dialog').dialog('open');
	}
	
	function editWithDraft(form) {

		
		
		var id = $(form).find("#applicationId").val();
		var userId = $(form).find("#userId").val();
		var name = $(form).find("#apvName").val();
		var applicationType = $(form).find('#newApplicationType').combobox('getValue');	
		var departmentName = $(form).find("#departmentName").val();
		var departmentId = $(form).find("#departmentId").val();
		var reason = $(form).find("#reason").val();
		var remark = $(form).find("#remark").val();
		if(name=="") {
			name="---";
		}
		if(reason=="") {
			reason="---";
		}
		if(applicationType=="") {
			applicationType=0;
		}
		if(departmentName=="") {
			departmentId=0;
		}
		var today=new Date();
		var appTimeStr = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
	
		//草稿状态
		var applicationStatus = 42001;
		//当前节点默认为0
		var nodeId = 0;
		
		$.post('apv/editWithDraft.do', {
			"id":id,
			"userId":userId,
			"name" : name,
			"applicationType" : applicationType,
			"departId" : departmentId,
			"appTimeStr" : appTimeStr,
			"reason" : reason,
			"applicationStatus" : applicationStatus,
			"nodeId" : nodeId,
			"remark" : remark
		}, function(data) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "草稿保存成功！", "info");
				$('#apvApplicationList').datagrid('reload');
		}, "json")
	}
	function addEditApplication(form) {
		//在提交数据之前执行表单验证
		 $('#editApplicationForm').form('enableValidation').form('validate'); 

		//判断表单验证是否通过
		 if (!$(form).form('validate')) {
			return false;
		} 
		
		 var applicationId = $(form).find("#applicationId").val();
		var userId = $(form).find("#userId").val();
		var name = $(form).find("#apvName").val();
		var applicationType = $(form).find('#newApplicationType').combobox('getValue');	
		var departmentName = $(form).find("#departmentName").val();
		var departmentId = $(form).find("#departmentId").val();
		var reason = $(form).find("#reason").val();
		var remark = $(form).find("#remark").val();
		var today=new Date();
		var appTimeStr = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
		//申请中状态
		var applicationStatus = 42002;
		//当前节点默认为0
		var nodeId = 0;
		$.post('apv/editApplicationToAdd.do', {
			"id":applicationId,
			"userId":userId,
			"name" : name,
			"applicationType" : applicationType,
			"departId" : departmentId,
			"appTimeStr" : appTimeStr,
			"reason" : reason,
			"applicationStatus" : applicationStatus,
			"nodeId" : nodeId,
			"remark" : remark
		}, function(data) {
			
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "提交申请成功！", "info");
				$('#apvApplicationList').datagrid('reload');
			
		}, "json")
	}


</script>

<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>