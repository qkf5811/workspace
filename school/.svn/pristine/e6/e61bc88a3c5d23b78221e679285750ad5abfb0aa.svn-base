<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="userEditForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${userId}'/>" />
			<tr>
			<div style="margin-bottom: 20px">
				<td>帐号:</td>
				<td><input class="easyui-validatebox textbox" id="account"
					name="account"
					data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>密码:</td>
				<td><input class="easyui-validatebox textbox" type="password" id="password"
					name="password"
					data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>姓名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name"
					data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>性别:</td>
				<td><select class="easyui-combobox" id="sex" name="sex"
					data-options="editable:false,novalidate:true,panelHeight: 'auto',panelWidth: '50px'" validtype="selectRequired['sex']" style="height:30px">
					<option value="">请选择</option>
					<c:forEach items="${sexList}" var="sex">
				<option value="${sex.id}">${sex.name}</option>
			</c:forEach>
						
				</select></td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>所属部门：</td>

				<td><select class="easyui-combobox" id="editUserDepartment" name="editUserDepartment"
					data-options="editable:false,novalidate:true,panelHeight: 'auto',panelWidth: '98px'," validtype="selectRequired['editUserDepartment']" style="height:30px">
					<option value="">请选择</option>
					<c:forEach items="${departments}" var="department">
				<option value="${department.id}">${department.name}</option>
			</c:forEach>
						
				</select></td>
				
			</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>手机:</td>

				<td><input class="easyui-numberbox" type="text" id="mobile"
					name="mobile" style="width: 208px; height: 30px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>邮箱：</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="email" name="email"
					data-options="validType:'email'" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>地址:</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="address" name="address"
					style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>是否冻结：</td>

					<td><select class="easyui-combobox" id="isBlocked" name="isBlocked"
								data-options="editable:false,novalidate:true,panelHeight: 'auto',panelWidth: '50px'" validtype="selectRequired['isBlocked']" style="height:30px">
						<option value="">请选择</option>
						<c:forEach items="${booleanList}" var="isBlocked">
							<option value="${isBlocked.id}">${isBlocked.name}</option>
						</c:forEach>

					</select></td>

				</div>
			</tr>


		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editUser('#userEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="closeForm()">取消</a>
	</div>

</div>



<script type="text/javascript">

	$(function(){
		getUser("#userEditForm");
	});
	
	function getUser(form){
		var id=$(form).find("#id").val();
		$.post('user/getUser.do',{
			"id":id
		},function(data){
			$(form).find("#account").val(data.user.account);
			$(form).find("#password").val(data.user.password);
			$(form).find("#name").val(data.user.name);
			$(form).find("#sex").combobox('select',data.user.sexType);
			$(form).find("#editUserDepartment").combobox('select',data.user.departmentId);
			$(form).find("#mobile").numberbox('setValue',data.user.mobile);
			$(form).find("#email").val(data.user.email);
			$(form).find("#address").val(data.user.address);
			$(form).find("#isBlocked").combobox('select',data.user.isBlocked);
		},"json")
	}
	function editUser(form) {

		//在提交数据之前执行表单验证
		$('#userEditForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}

		var id = $(form).find("#id").val();
		var account = $(form).find("#account").val();
		var password = $(form).find("#password").val();
		var name = $(form).find("#name").val();
		var sex = $(form).find("#sex").combobox('getValue');
		var department = $(form).find("#editUserDepartment").combobox('getValue');
		var mobile = $(form).find("#mobile").val();
		var email = $(form).find("#email").val();
		var address = $(form).find("#address").val();
		var isBlocked=$(form).find("#isBlocked").combobox('getValue');

		$.post('user/editUser.do', {
			"id" : id,
			"account" : account,
			"password" : password,
			"name" : name,
			"sexType" : sex,
			"departmentId" : department,
			"mobile" : mobile,
			"email" : email,
			"address" : address,
			"isBlocked" : isBlocked
		}, function(data) {
			if (data.result==-2) {
				$.messager.alert("操作提示", "用户帐号重复！", "warning");
			} else {
			closeTab(getCurrentTab());
			$.messager.alert("操作提示", "编辑用户成功！", "info");
			$('#userList').datagrid('reload');
			}
		}, "json");
	}

	function closeForm() {
		closeTab(getCurrentTab());
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
