<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>



<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newUserForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden" />
			<tr>
				<td>角色名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name"
					data-options="required:true,validType:'length[3,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " />

				</td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="remark"
					name="remark"
					data-options="required:true,validType:'length[3,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " />

				</td>
			</tr>
			
			
			


		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewUser('#newUserForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>



<script type="text/javascript">
	function addNewUser(form) {
		var id = $(form).find("#id").val();
		var account = $(form).find("#account").val();
		var password = $(form).find("#password").val();
		var name = $(form).find("#name").val();
		var sex = $(form).find("#sex").combobox('getValue');
		//var orgId = $(form).find("#orgId").val();
		var mobile = $(form).find("#mobile").val();
		var email = $(form).find("#email").val();
		var address = $(form).find("#address").val();

		$.post('user/addUser.do', {
			"id" : id,
			"account" : account,
			"password" : password,
			"name" : name,
			"sexType" : sex,
			//"orgId" : orgId,
			"mobile" : mobile,
			"email" : email,
			"address" : address
		}, function(result) {
			closeTab(getCurrentTab());
		}, "json")
	}
	
	function clearForm() {
		$('#newUserForm').form('clear');
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