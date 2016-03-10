<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="newUseApplicationForm" method="post">
		<table cellpadding="7">
				
			<tr style="diplay:none">
				<input id="zj_new_userId" name="zj_new_userId" type="hidden" value="<c:out value='${userId}'/>" />
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请类型:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						value="<c:out value='设备领用申请'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_new_use_name" name="zj_new_use_name"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请部门:</td>

					<td><input class="easyui-textbox" type="text"
						id="zj_new_departmentName" name="zj_new_departmentName"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择您申请的部门'"
						style="height: 31px; width: 208px"></input><input id="departmentId" name="departmentId" type="hidden"/>
					</td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备名称:</td>

					<td><input class="easyui-textbox" type="text"
						id="zj_new_equipName" name="zj_new_equipName"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择设备名称及其型号'"
						style="height: 31px; width: 208px"></input><input id="departmentId" name="departmentId" type="hidden"/>
					</td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备型号:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						readonly="true" id="zj_new_model" name="zj_new_model"
						style="width: 200px; height: 18px; padding: 5px;"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请原因:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_new_reason" name="zj_new_reason"
						data-options="required:true,validType:'length[1,500]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-500' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请设备数量:</td>

					<td><input class="easyui-numberbox"
						id="zj_new_amount" name="zj_new_amount"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="zj_new_remark" name="zj_new_remark"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
	
		</table>
	
	</form>

	<div style="margin-left:180px; margin-top:20px;padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addWithDraft('#newUseApplicationForm')">保存为草稿</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewUseApplication('#newUseApplicationForm')">提交申请</a>
	</div>
	
	<%@ include file="/WEB-INF/views/equ/equ_new_select_department_dialog.jsp"%>
	<%@ include file="/WEB-INF/views/equ/equ_new_select_equipName_dialog.jsp"%>
	
</div>


<script type="text/javascript">

	$(function() {
	

		$("#newUseApplicationForm").find("#zj_new_departmentName").textbox({
			onClickButton : function() {
				openNewSelectDepartmentDialog();
			}
		})
		
		$("#newUseApplicationForm").find("#zj_new_equipName").textbox({
			onClickButton : function() {
				openNewSelectEquipNameDialog();
			}
		})

	

	});
	
	function openNewSelectEquipNameDialog() {
		$('#new-select-equipName-dialog').find('#new_equipNameOpenForm').val("#newUseApplicationForm");
		$('#new-select-equipName-dialog').dialog('open');
	}
	
	function openNewSelectDepartmentDialog() {
		$('#new-select-department-dialog').find('#new_departmentOpenForm').val("#newUseApplicationForm");
		$('#new-select-department-dialog').dialog('open');
	}
	
	function addWithDraft(form) {
		var userId = $(form).find("#zj_new_userId").val();
		var apvApplicationName = $(form).find("#zj_new_use_name").val();
		var departName = $(form).find("#zj_new_departmentName").val();
		var departmentId = $(form).find("#departmentId").val();
		var equipName = $(form).find("#zj_new_equipName").val();
		var model = $(form).find("#zj_new_model").val();
		var reason = $(form).find("#zj_new_reason").val();
		var amount = $(form).find("#zj_new_amount").val();
		var remark = $(form).find("#zj_new_remark").val();
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
		$.post('equ/addWithDraft.do', {
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
			"remark" : remark
		}, function(data) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "草稿保存成功！", "info");
				$('#apvApplicationList').datagrid('reload');
		}, "json")
	}
	function addNewUseApplication(form) {
		//在提交数据之前执行表单验证
		 $('#newUseApplicationForm').form('enableValidation').form('validate'); 

		//判断表单验证是否通过
		 if (!$(form).form('validate')) {
			return false;
		} 
		
		
		var userId = $(form).find("#zj_new_userId").val();
		var apvApplicationName = $(form).find("#zj_new_use_name").val();
		var departName = $(form).find("#zj_new_departmentName").val();
		var departmentId = $(form).find("#departmentId").val();
		var equipName = $(form).find("#zj_new_equipName").val();
		var model = $(form).find("#zj_new_model").val();
		var reason = $(form).find("#zj_new_reason").val();
		var amount = $(form).find("#zj_new_amount").val();
		var remark = $(form).find("#zj_new_remark").val();	
		var today=new Date();
		var appTimeStr = today.getFullYear()+"-"+today.getMonth()+"-"+today.getDate();
		//申请中状态
		var applicationStatus = 42002;
		//当前节点默认为0
		var nodeId = 0;
		var applicationType=41002;
		$.post('equ/addNewUseApplication.do', {
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