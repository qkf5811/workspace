<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style scoped type="text/css">
#studentAccountEditForm #moreTeacher{
	text-decoration: none
}

#studentAccountEditForm #moreTeacher:hover {
	color: red;
}
</style>
<script src="${contextPath}/js/ajaxfileupload.js"></script>
<div class="easyui-panel" style="padding: 30px 90px 90px 70px">
	<form id="studentAccountEditForm" method="post">
		<table cellpadding="7">

			<input id="studentAccountId" name="studentAccountId" type="hidden"
				value="<c:out value='${studentAccountId}'/>" />
			<input id="studentId" name="studentId" type="hidden"
				value="<c:out value='${studentId}'/>" />

			<tr>
				<div style="margin-bottom: 20px">
					<td>年级:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="finGrade" name="finGrade"
						value="<c:out value='${finGrade}'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属专业:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finMajor" name="finMajor" value="<c:out value='${finMajor}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>专业方向:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finField" name="finField" value="<c:out value='${finField}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>班级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finClassName" name="finClassName" value="<c:out value='${finClassName}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>学号:</td>
						
					<td><input class="easyui-validatebox textbox" type="text"
						id="finStuCode" name="finStuCode" value="<c:out value='${finStuCode}'/>"
						readonly="true" style="height: 31px; width: 208px;border-style:none"></input>
					</td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>学生姓名:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="finStuName" name="finStuName" value="<c:out value='${finStuName}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<%-- <tr>
				<div style="margin-bottom: 20px">
					<td>学生姓名:</td>

					<td><input class="easyui-textbox textbox" type="text"
						id="finStuName" name="finStuName"
						value="<c:out value='${finStuName}'/>"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请选择一名学生'"
						style="height: 31px; width: 208px"></input>
					</td>
				</div>
			</tr> --%>
			
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>银行户名:</td>

					<td><input class="easyui-textbox textbox"  type="text" id="name" value="<c:out value='${name}'/>"
						name="name" style="height: 31px; width: 208px"
						data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10' " ></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>银行账号:</td>

					<td><input class="easyui-numberbox" type="text"
						id="account" name="account" value="<c:out value='${account}'/>"
						style="height: 33px; width: 200px" data-options="required:true,missingMessage:'该处未填写',novalidate:true"></input></td>
				</div>
			</tr>
		<%-- 	<tr>
				<div style="margin-bottom: 20px">
					<td>银行账号:</td>

					<td><input class="easyui-numberbox "  id="account" value="<c:out value='${account}'/>"
						name="account" style="height: 31px; width: 208px"
						data-options="required:true,missingMessage:'该处未填写',novalidate:true"></input></td>
				</div>
			</tr> --%>
			

			



		</table>

		

	</form>
	<div style="margin-left: 180px; margin-top: 20px; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editStudentAccount('#studentAccountEditForm')">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
	</div>
</div>
<%@ include
	file="/WEB-INF/views/fin/fin_select_stu_dialog.jsp"%>

</div>

<script type="text/javascript">
	/* $(function() {
		

		$("#studentAccountEditForm").find("#finStuName").textbox({
			onClickButton : function() {
				openNewSelectStuDialog();
			}
		})

		

	});

	function openNewSelectStuDialog() {
		$('#select-finStu-dialog').find('#stuOpenForm').val("#studentAccountEditForm");
		$('#select-finStu-dialog').dialog('open');
	} */

	
	function cancel(){
		closeTab(getCurrentTab());
	}

	

	function editStudentAccount(form) {
		//在提交数据之前执行表单验证
		$('#studentAccountEditForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
	
    	var studentId = $(form).find("#studentId").val();
		var id = $(form).find("#studentAccountId").val();
		var name = $(form).find("#name").val();
		var account = $(form).find("#account").val();
		var reg=/^\d+$/;  // 注意：故意限制了 0321 这种格式，如不需要，直接reg=/^\d+$/;
		if(reg.test(account)==false){
			$.messager.alert("操作提示", "银行账号必须为纯数字！","info");
		}
		var length = account.length;
		var param = {
				"studentId" :studentId,
				"name" :name,
				"id" : id,
				"account" : account
			}
		if(length==19||length==16) {
			$.post('fin/editStudentAccount.do', param, function(result) {
				if(result.data == -1) {
					$.messager.alert("操作提示","已有相同的银行账号存在，请更改账号!","warning");
				}else {
					closeTab(getCurrentTab());
					$('#studentAccountList').datagrid('reload');
					$.messager.alert("操作提示", "编辑学生银行账号记录成功", "info");
				}
				
			}, "json")
		}else {
			$.messager.alert("操作提示", "银行账号长度只能为16位或19位！","warning");
		}
		
		
		
		
			
	

	}
</script>


<style scoped="scoped">
#teacherName2 {
	margin-left: 18px;
}

.textbox {
	height: 20px;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
