<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${contextPath}/js/ajaxfileupload.js"></script>
<div class="easyui-panel" style="padding: 30px 70px 90px 70px">
<form id="teacherFamilyEditForm" method="post">
	<table cellpadding="7">

		<input id="id" name="id" type="hidden" value="<c:out value='${id}'/>" />
		<input id="teacherIdHide" name="teacherIdHide" type="hidden" value="<c:out value='${teacherId}'/>" />
		
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属教职工:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="teaName" name="teaName" value="<c:out value='${name}'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>家庭成员姓名:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="name" name="name"
						data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>亲属关系:</td>
					<td><select class="easyui-combobox" id="relationType"
						name="relationType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '78px',novalidate:true"
						validtype="selectRequired['relationType']"
						style="width: 78px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${teaRelationTypeList}" var="teaRelationType">
							<option value="${teaRelationType.id}">${teaRelationType.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>家庭成员性别:</td>
					<td><select class="easyui-combobox" id="sexType"
						name="sexType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true"
						validtype="selectRequired['sexType']"
						style="width: 67px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${sexList}" var="sex">
							<option value="${sex.id}">${sex.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>
			


			

			<tr>
				<div style="margin-bottom: 20px">
					<td>家庭成员出生日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="birthday" name="birthday"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
	


			<tr>
				<div style="margin-bottom: 20px">
					<td >家庭成员联系电话:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="phone" name="phone"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td >备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="remark" name="remark"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
		</table>
		
		
</form>
<div style="margin-left:180px; margin-top:20px;padding: 5px">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="editTeacherFamily('#teacherFamilyEditForm')">提交</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
</div>
</div>


</div>

<script type="text/javascript">
	$(function() {
		getTeacherFamily("#teacherFamilyEditForm");
	});
	function cancel(){
		closeTab(getCurrentTab());
	}
	function getTeacherFamily(form) {
		var id = $(form).find("#id").val();
		var teacherId = $(form).find("#teacherIdHide").val();
		$.post('tea/getTeacherFamily.do', {
			"id" : id,
			"teacherId":teacherId
		}, function(data) {
			$(form).find("#name").val(data.tfDto.name);
			$(form).find('#sexType').combobox('select',data.tfDto.sexType);
			$(form).find('#relationType').combobox('select',data.tfDto.relationType);
			$(form).find("#birthday").datebox('setText',data.tfDto.birthdayStr);
			$(form).find("#phone").val(data.tfDto.phone);
			$(form).find("#remark").val(data.tfDto.remark);


		}, "json")
	}
	function editTeacherFamily(form) {
		//在提交数据之前执行表单验证
		$('#teacherFamilyEditForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}
		
		var id = $(form).find("#id").val();
		var teacherId = $(form).find("#teacherIdHide").val();
		var name = $(form).find("#name").val();
		var sexType = $(form).find('#sexType')
		.combobox('getValue');	
		var relationType = $(form).find('#relationType')
		.combobox('getValue');	
		var birthdayStr=$(form).find("#birthday").datebox('getText');
		var phone = $(form).find("#phone").val();
		var remark = $(form).find("#remark").val(); 
		


		$.post('tea/editTeacherFamily.do', {

			"id" : id,
			"name" : name,
			"teacherId" : teacherId,
			"sexType":sexType,
			"relationType" : relationType,
			"birthdayStr" : birthdayStr,
			"phone" : phone,
			"remark" : remark
		}, function(result) {
			closeTab(getCurrentTab());
			$('#teaFamilyList').datagrid('reload');
			$.messager.alert("操作提示", "编辑此教职工家庭信息成功！","info");
			
		}, "json")
	}

	
</script>


<style scoped="scoped">
.textbox {
	height: 20px;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
