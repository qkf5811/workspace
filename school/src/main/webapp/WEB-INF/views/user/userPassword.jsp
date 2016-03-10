<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="userPasswordView" style="width: 750px; padding: 10px 20px;"
	closed="true" buttons="#userPasswordView-buttons">
	<div style="font-size: 15px;font-weight: bold">修改密码</div>
	<form id="userPasswordForm">

		<table>
			<tr>
				<td>
					<label>旧密码:</label>
				</td>
				<td>
					<input class="easyui-textbox" id="oldpassword"
						   data-options="required:true,novalidate:true,validType:'length[1,16]',missingMessage:'该处未填写',invalidMessage:'字数范围为1-16'" type="password"> <label
						style="width: 280px;">由16位以内的数字或字母组成</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>新密码:</label>
				</td>
				<td>
					<input class="easyui-textbox" id="password1"
						   data-options="required:true,novalidate:true,validType:'length[1,16]',missingMessage:'该处未填写',invalidMessage:'字数范围为1-16'" type="password"> <label
						style="width: 280px;">由16位以内的数字或字母组成</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>确认新密码:</label>
				</td>
				<td>
					<input class="easyui-textbox" id="password2"
						   data-options="required:true,novalidate:true,validType:'length[1,16]',missingMessage:'该处未填写',invalidMessage:'字数范围为1-16'" type="password">
				</td>
			</tr>
		</table>
		
	</form>
	<div id="userPasswordView-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="changePassword('#userPasswordForm')">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="closeTab(getCurrentTab())">取消</a>
	</div>
</div>

<script type="text/javascript">

//修改密码
function changePassword(form){

	//在提交数据之前执行表单验证
	$('#userPasswordForm').form('enableValidation').form('validate');

	//判断表单验证是否通过
	if(!$(form).form('validate')){
		return false;
	}


	var oldpassword = $(form).find("#oldpassword").val();
	var password = $(form).find("#password1").val();
	var password2 = $(form).find("#password2").val();
	
	// 验证密码
	if(isEmpty(oldpassword)){
		alert("旧密码不能为空!");
		return false;
	}
	if(!lengthLegal(oldpassword,1,16) || !regexValidity(oldpassword,"^[A-z,0-9]+$")){
		alert("密码必须由16位以内的数字或字母组成!");
		return false;
	}
	if(isEmpty(password)){
		alert("密码不能为空!");
		return false;
	}
	if(!lengthLegal(password,1,16) || !regexValidity(password,"^[A-z,0-9]+$")){
		alert("密码必须由16位以内的数字或字母组成!");
		return false;
	}
	if(password != password2){
		alert("两次密码不相同!");
		return false;
	}
	
	$.post(
		'user/changePassword.do', {
		"oldpassword" : oldpassword,
		"password" : password
	},
	function(data) {
		if (data.result > 0) {
			$.messager.alert("操作提示", "修改成功！","info");
			closeTab(getCurrentTab());
		} else if (data.result == 0) {
			$.messager.alert("操作提示", "修改失败！","warning");
		} else if (data.result == -1) {
			$.messager.alert("操作提示", "输入的信息不完整！","warning");
		} else if (data.result == -2) {
			$.messager.alert("操作提示", "输入的旧密码不正确！","warning");
		} 
	},"json");
}

//判断字符串是否为空
function isEmpty(str) {
	if (str == null || $.trim(str) == "") {
		return true;
	} else {
		return false;
	}
}

//判断字符串是否为空
function isEmpty(str) {
	if (str == null || $.trim(str) == "") {
		return true;
	} else {
		return false;
	}
}

// 判断字符串是否符合正则表达式要求
function regexValidity(str, rgx) {
	var Regex = new RegExp(rgx,"g");
	return Regex.test(str);
}

//判断字符串的长度是否正确 
function lengthLegal(str, short, long) {
	if (short < 0 || long < short) {
		return false;
	} else if (str.length < short || str.length > long) {
		return false;
	}
	return true;
}
</script>
