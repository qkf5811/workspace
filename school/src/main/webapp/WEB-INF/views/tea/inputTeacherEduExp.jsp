<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div style="margin:15px" id="inputTeacherEduExpForm">
	<input type="text" id="id" value="${id }" hidden="true">
<!--  	<div style="margin:15px"><strong>${name }:</strong></div>-->
	<table id="" style="margin:10px auto auto 140px">
		<tr>
			<td><b>姓名:</b></td>
			<td>
				<input class="easyui-textbox" data-options="editable:false" value="${name }"/>
			</td>
		</tr>
		<tr>
			<td><b>教育类型:</b></td> 
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="educationType">
					<option value="0">请选择</option>
					<c:forEach items="${educationType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>所属学校:</b></td>
			<td><input class="easyui-validatebox textbox" id="school"
						style="width: 150px;height:20px"
						data-options="required:true, missingMessage:'该处未填写!',novalidate:true">
			</td>
		</tr>
		<tr>
			<td><b>所属专业:</b></td>
			<td><input class="easyui-validatebox textbox" id="major"
						style="width: 150px;height:20px"
						data-options="required:true, missingMessage:'该处未填写!',novalidate:true"></td>
		</tr>
		<tr>
			<td><b>开始时间:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false,required:true,novalidate:true" id="startDate"></span></td>
		</tr>
		<tr>
			<td><b>结束时间:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false,required:true,novalidate:true" id="endDate"></span></td>
		</tr>
		<tr>
			<td><b>学历:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="degreeType">
					<option value="0">请选择</option>
					<c:forEach items="${degreeType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>备注:</b></td>
			<td><textArea cols="50" rows="3" id="remarkOfTeaEdu"></textArea></td>
		</tr>
	</table>
	
	<div style="text-align:center;margin: 15px">
	<a href="javascript:void(0)" style="margin-right:20px"class="easyui-linkbutton"
		onclick="commitEduExpInfo()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
	    onclick="resetTeacherEduExpInfoTab()">重置</a>
</div>
</div>

<script>
	
	function commitEduExpInfo() {
	
		//在提交数据之前执行表单验证
		$('#inputTeacherEduExpForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$('#inputTeacherEduExpForm').form('validate')){
			return false;
		} 
		
		//得到参数(教师教育经历信息)
		var teacherId = $('#inputTeacherEduExpForm').find('#id').val();
		var educationType = $('#inputTeacherEduExpForm').find('#educationType').combobox('getValue');
		var school = $('#inputTeacherEduExpForm').find('#school').val();
		var major = $('#inputTeacherEduExpForm').find('#major').val();
		var startDate = $('#inputTeacherEduExpForm').find('#startDate').datebox('getValue');
		var endDate = $('#inputTeacherEduExpForm').find('#endDate').datebox('getValue');
		var degreeType = $('#inputTeacherEduExpForm').find('#degreeType').combobox('getValue');
		var remarkOfTeaEdu = $('#inputTeacherEduExpForm').find('#remarkOfTeaEdu').val();
		
		param = {
				//教师教育经历
				teacherId : teacherId,
				educationType: educationType,
				school: school,
				major: major,
				startDate: startDate,
				endDate: endDate,
				degreeType: degreeType,
				remark: remarkOfTeaEdu
		}
		console.log(param);
		
		$.post("${contextPath}/tea/addTeacherEduExpInfo.do", 
				param,
				function (data) {
					var obj = eval('(' + data + ')');
					if (obj.result == 0) {
						$.messager.alert("操作提示", "添加教师教育经历信息失败!\n请稍后再尝试!", "warning");
					} else if (obj.result > 0) {
						$.messager.alert("操作提示", "教师教育经历信息录入成功!", "info");
						closeTab(getCurrentTab());
						$("#teaEduExpInfoList").datagrid('reload');
						resetTeacherEduExpInfoTab();
					}
				}
		);
		
	}
	
	function resetTeacherEduExpInfoTab() {
		
		$('#inputTeacherEduExpForm').find('#educationType').combobox('select', 0);
		$('#inputTeacherEduExpForm').find('#school').val("");
		$('#inputTeacherEduExpForm').find('#major').val("");
		$('#inputTeacherEduExpForm').find('#startDate').datebox('setValue', "");
		$('#inputTeacherEduExpForm').find('#endDate').datebox('setValue', "");
		$('#inputTeacherEduExpForm').find('#remarkOfTeaEdu').val("");
		$('#inputTeacherEduExpForm').find('#degreeType').combobox('setValue', 0);
	}
</script>
