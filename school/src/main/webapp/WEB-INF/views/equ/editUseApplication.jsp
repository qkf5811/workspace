<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="editUseApplicationForm" method="post">
		<table cellpadding="7">
				
			<tr style="diplay:none">
				<input id="zj_edit_userId" name="zj_edit_userId" type="hidden" value="<c:out value='${userId}'/>" />
			</tr>
			<tr style="diplay:none">
				<input id="zj_edit_useApplicationId" name="zj_edit_useApplicationId" type="hidden" value="<c:out value='${useApplicationId}'/>" />
			</tr>
		
			<tr style="diplay:none">
				<input id="zj_edit_applicationId" name="zj_edit_applicationId" type="hidden" value="<c:out value='${applicationId}'/>" />
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_edit_use_name" name="zj_edit_use_name" value="<c:out value='${apvApplicationName}'/>"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请部门:</td>

					<td><input class="easyui-textbox" type="text"
						id="zj_edit_departmentName" name="zj_edit_departmentName"  value="<c:out value='${departName}'/>"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择您申请的部门'"
						style="height: 31px; width: 208px"></input><input id="zj_edit_departmentId" name="zj_edit_departmentId" value="<c:out value='${departId}'/>" type="hidden"/>
					</td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_edit_equipName" name="zj_edit_equipName" value="<c:out value='${equipName}'/>"
						data-options="required:true,validType:'length[1,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-100' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备型号:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_edit_model" name="zj_edit_model" value="<c:out value='${model}'/>"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请原因:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_edit_reason" name="zj_edit_reason" value="<c:out value='${reason}'/>"
						data-options="required:true,validType:'length[1,500]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-500' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请设备数量:</td>

					<td><input class="easyui-numberbox"
						id="zj_edit_amount" name="zj_edit_amount" value="<c:out value='${amount}'/>"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_edit_remark" name="zj_edit_remark" value="<c:out value='${remark}'/>"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
		
	
		</table>
	
	</form>

	<div style="margin-left:180px; margin-top:20px;padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editWithDraft('#editUseApplicationForm')">继续存为草稿</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addEditUseApplication('#editUseApplicationForm')">提交申请</a>
	</div>
	
	<%@ include file="/WEB-INF/views/equ/equ_edit_select_department_dialog.jsp"%>
	
</div>


<script type="text/javascript">

	$(function() {
	
		$("#editUseApplicationForm").find("#zj_edit_departmentName").textbox({
			onClickButton : function() {
				openEditSelectDepartmentDialog();
			}
		})

	

	});
	
	function openEditSelectDepartmentDialog() {
		$('#edit-select-department-dialog').find('#edit_departmentOpenForm').val("#editUseApplicationForm");
		$('#edit-select-department-dialog').dialog('open');
	}
	
	function editWithDraft(form) {
		var userId = $(form).find("#zj_edit_userId").val();
		var useApplicationId = $(form).find("#zj_edit_useApplicationId").val();
		var apvApplicationName = $(form).find("#zj_edit_use_name").val();
		var departName = $(form).find("#zj_edit_departmentName").val();
		var departmentId = $(form).find("#zj_edit_departmentId").val();
		var equipName = $(form).find("#zj_edit_equipName").val();
		var model = $(form).find("#zj_edit_model").val();
		var reason = $(form).find("#zj_edit_reason").val();
		var amount = $(form).find("#zj_edit_amount").val();
		var remark = $(form).find("#zj_edit_remark").val();
		var applicationId = $(form).find("#zj_edit_applicationId").val();
		
		if(apvApplicationName=="") {
			apvApplicationName="---";
		}
		if(equipName=="") {
			equipName="---";
		}
		if(model=="") {
			model="---";
		}
		if(reason=="") {
			reason="---";
		}
		if(amount=="") {
			amount=0;
		}
		
		if(remark=="") {
			remark="---";
		}
		if(departmentId=="") {
			departmentId=0;
		}
		var today=new Date();
		var appTimeStr = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
	
		//草稿状态
		var applicationStatus = 42001;
		//当前节点默认为0
		var nodeId = 0;
		
		var applicationType=41002;
		$.post('equ/editWithDraft.do', {
			"id":useApplicationId,
			"userId":userId,
			"apvApplicationName" : apvApplicationName,
			"departName" : departName,
			"departId" : departmentId,
			"equipName" : equipName,
			"model" : model,
			"reason" : reason,
			"applicationStatus" : applicationStatus,
			"amount" : amount,
			"appTimeStr" : appTimeStr,
			"nodeId" : nodeId,
			"applicationType" : applicationType,
			"applicationId" : applicationId,
			"remark" : remark
			
		}, function(data) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "草稿保存成功！", "info");
				$('#useApplicationList').datagrid('reload');
		}, "json")
	}
	function addEditUseApplication(form) {
		//在提交数据之前执行表单验证
		 $('#editUseApplicationForm').form('enableValidation').form('validate'); 

		//判断表单验证是否通过
		 if (!$(form).form('validate')) {
			return false;
		} 
		
		var userId = $(form).find("#zj_edit_userId").val();
		var useApplicationId = $(form).find("#zj_edit_useApplicationId").val();
		var apvApplicationName = $(form).find("#zj_edit_use_name").val();
		var departName = $(form).find("#zj_edit_departmentName").val();
		var departmentId = $(form).find("#zj_edit_departmentId").val();
		var equipName = $(form).find("#zj_edit_equipName").val();
		var model = $(form).find("#zj_edit_model").val();
		var reason = $(form).find("#zj_edit_reason").val();
		var amount = $(form).find("#zj_edit_amount").val();
		var remark = $(form).find("#zj_edit_remark").val();
		var applicationId = $(form).find("#zj_edit_applicationId").val();	
		var today=new Date();
		var appTimeStr = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
		//申请中状态
		var applicationStatus = 42002;
		//当前节点默认为0
		var nodeId = 0;
		var applicationType=41002;
		$.post('equ/editUseApplicationToAdd.do', {
			"id":useApplicationId,
			"userId":userId,
			"apvApplicationName" : apvApplicationName,
			"departName" : departName,
			"departId" : departmentId,
			"equipName" : equipName,
			"model" : model,
			"reason" : reason,
			"applicationStatus" : applicationStatus,
			"amount" : amount,
			"appTimeStr" : appTimeStr,
			"nodeId" : nodeId,
			"applicationType" : applicationType,
			"applicationId" : applicationId,
			"remark" : remark
		}, function(data) {
			
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "提交申请成功！", "info");
				$('#useApplicationList').datagrid('reload');
			
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