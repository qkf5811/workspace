<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newUserForm" method="post">
		<table cellpadding="7">

			
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
				<td><input class="easyui-validatebox textbox" id="uName"
					name="uName"
					data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>性别:</td>
				<td><select class="easyui-combobox" id="uSex" name="uSex"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true" validtype="selectRequired['uSex']" style="height:30px;width:63px">
						<option value="">请选择</option>
						<c:forEach items="${sexList}" var="sex">
				<option value="${sex.id}">${sex.name}</option>
			</c:forEach>
				</select></td>
				</div>
			</tr>
			<!--  
			<tr>
				<td>所属部门：</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="orgId" name="orgId"
					data-options="required:true,novalidate:true"></input></td>

			</tr>-->
			<tr>
			<div style="margin-bottom: 20px">
				<td>所属部门：</td>

				<td><select class="easyui-combobox" id="department" name="department"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['department']" style="height:30px">
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
					id="uAddress" name="uAddress"
					style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
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
		
		//在提交数据之前执行表单验证
		$('#newUserForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		
		
		var account = $(form).find("#account").val();
		var password = $(form).find("#password").val();
		var name = $(form).find("#uName").val();
		var sex = $(form).find("#uSex").combobox('getValue');
		var departmentId = $(form).find("#department").combobox('getValue');
		var mobile = $(form).find("#mobile").val();
		var email = $(form).find("#email").val();
		var address = $(form).find("#uAddress").val();

		
		/* if (account == "") {
			$.messager.alert("操作提示", "帐号不能为空！","warning");
			return;
		}
		if (password == "") {
			$.messager.alert("操作提示", "密码不能为空！","warning");
			return;
		}
		if (name == "") {
			$.messager.alert("操作提示", "姓名不能为空！","warning");
			return;
		} */
		
		$.post('user/addUser.do', {
			
			"account" : account,
			"password" : password,
			"name" : name,
			"sexType" : sex,
			"departmentId" : departmentId,
			"mobile" : mobile,
			"email" : email,
			"address" : address
		}, function(data) {
			if(data.result>0){
			closeTab(getCurrentTab());
			$.messager.alert("操作提示", "添加人员成功！","info");
			$('#userList').datagrid('reload');
			}else if(data.result==0){
				$.messager.alert("操作提示","添加用户失败!","warning");
			}else if(data.result==-1){
				
				$.messager.alert("操作提示","输入的用户信息不完整!","warning");
			}else if(data.result==-2){
				
				$.messager.alert("操作提示","用户已存在!","warning");
			}
		}, "json")
	}
	
	function clearForm() {
		$('#newUserForm').form('clear');
		//设置下拉框的选择为'请选择'
		$('#newUserForm').find("#uSex").combobox('setValue',"");
		$('#newUserForm').find("#department").combobox('setValue',"");
	}
</script>

<!-- <script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
    selectRequired: {
        validator: function (value, param) {
            var selectVal = $("input[name=" + param[0] + "]").val();
            $("#msg").html(selectVal);
            return parseInt(selectVal) > 0;
        },
        message:'该处未选择'
    }
})
</script> -->

<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
