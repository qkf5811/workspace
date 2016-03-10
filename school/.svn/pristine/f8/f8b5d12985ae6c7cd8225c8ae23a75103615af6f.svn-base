<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newStudentAccountForm" method="post">
		<table cellpadding="7">
			<tr>
				<div style="margin-bottom: 20px">
					<td>学生姓名:</td>

					<td><input class="easyui-textbox" type="text"
						id="finStuName" name="finStuName"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择一名学生'"
						style="height: 31px; width: 208px"></input>
					</td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>银行户名:</td>

					<td><input class="easyui-textbox textbox"  type="text" id="name" 
						name="name" style="height: 31px; width: 208px"
						data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10' " ></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>银行账号:</td>

					<td><input type="text" class="easyui-numberbox"
					 id="account" name="account" 
					 style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			<!-- <tr>
				<div style="margin-bottom: 20px">
					<td>银行账号:</td>

					<td><input class="easyui-numberbox" id="account"
						name="account" style="height: 31px; width: 208px"
						data-options="required:true,missingMessage:'该处未填写',novalidate:true"></input></td>
				</div>
			</tr> -->
			<tr>
				<div style="margin-bottom: 20px">
					<td>年级:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="finGrade" name="finGrade"
						readonly="true"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属专业:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finMajor" name="finMajor" 
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>专业方向:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finField" name="finField" 
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>班级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finClassName" name="finClassName" 
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>学号:</td>
						
					<td><input class="easyui-validatebox textbox" type="text"
						id="finStuCode" name="finStuCode" 
						readonly="true" style="height: 31px; width: 208px"></input>
					</td>
				</div>
			</tr>
			
	</table>
			

	</form>
	<div style="margin-left: 180px; margin-top: 20px; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewStudentAccount('#newStudentAccountForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>
	<%@ include file="/WEB-INF/views/fin/fin_select_stu_dialog.jsp"%>
	
</div>


<script src='js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript">
$(function() {
	

	$("#newStudentAccountForm").find("#finStuName").textbox({
		onClickButton : function() {
			openNewSelectStuDialog();
		}
	})

	

	});
	
	function openNewSelectStuDialog() {
		$('#select-finStu-dialog').find('#stuOpenForm').val("#newStudentAccountForm");
		$('#select-finStu-dialog').dialog('open');
	}


	function addNewStudentAccount(form) {
		
		//在提交数据之前执行表单验证
		$('#newStudentAccountForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}  
		var finStuCode = $(form).find("#finStuCode").val();
		var name = $(form).find("#name").val();
		var account = $(form).find("#account").val();
		var reg=/^\d+$/;  // 注意：故意限制了 0321 这种格式，如不需要，直接reg=/^\d+$/;
		if(reg.test(account)==false){
			$.messager.alert("操作提示", "银行账号必须为纯数字！","info");
		}
		
		var length = account.length;
		if(length==19||length==16) {
			$.post('fin/addStudentAccount.do', {
				
				"finStuCode" : finStuCode,
				"name" : name,
				"account" : account
			}, function(data) {
				if(data.result>0){
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加学生银行信息成功！","info");
				$('#studentAccountList').datagrid('reload');
				}else if(data.result==0){
					$.messager.alert("操作提示","添加学生银行信息失败!","warning");
				}else if(data.result==-1){
					$.messager.alert("操作提示","输入的学生银行信息不完整!","warning");
				}else if(data.result==-2){
					$.messager.alert("操作提示","此学生银行信息已存在!","warning");
				}else if(data.result==-3){
					$.messager.alert("操作提示","已有相同的银行账号存在，请更改账号!","warning");
				}
			}, "json")
			
		}else{
			$.messager.alert("操作提示", "银行账号长度只能为16位或19位！","warning");
		}
		
	}
	
	function clearForm() {
		$('#newStudentAccountForm').form('clear');
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