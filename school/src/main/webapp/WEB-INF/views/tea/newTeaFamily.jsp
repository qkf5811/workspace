<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="newTeaFamilyForm" method="post">
		<table cellpadding="7">
			
			<input id="teaId" name="teaId" type="hidden" value="<c:out value='${teacherId}'/>" required="true">
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属教职工:</td>
					<td><input class=" textbox" type="text"
						id="teaName" name="teaName" value="<c:out value='${name}'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>家庭成员姓名:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="name" name="name"
						data-options="required:true,validType:'length[1,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-20' "
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>亲属关系:</td>
					<td><select class="easyui-combobox" id="relationType"
						name="relationType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '78px',novalidate:true,missingMessage:'该处未填写'"
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
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true,missingMessage:'该处未填写'"
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
					<td>家庭成员联系电话:</td>

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
			onclick="addNewTeaFamily('#newTeaFamilyForm')">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
	</div>
</div>


<script type="text/javascript">
	
	
	function addNewTeaFamily(form) {

		//在提交数据之前执行表单验证
		$('#newTeaFamilyForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
		
		
		
		var teacherId = $(form).find("#teaId").val();
		var name=$(form).find("#name").val();
		var relationType = $(form).find('#relationType').combobox('getValue');	
		var sexType = $(form).find('#sexType').combobox('getValue');	
		var birthdayStr = $(form).find("#birthday").datebox('getValue');
		var phone = $(form).find("#phone").val();
		var remark = $(form).find("#remark").val();
		$.post('tea/addTeaFamily.do', {
			"teacherId" : teacherId,
			"name" : name,
			"relationType" : relationType,
			"sexType" : sexType,
			"birthdayStr" : birthdayStr,
			"phone" : phone,
			"remark" : remark
		}, function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加教师家庭信息成功！", "info");
				$('#teaFamilyList').datagrid('reload');
			} else if (data.result == -1) {
				$.messager.alert("操作提示", "输入的教师家庭信息不完整!", "warning");
			}
		}, "json")
	}
	function cancel(){
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