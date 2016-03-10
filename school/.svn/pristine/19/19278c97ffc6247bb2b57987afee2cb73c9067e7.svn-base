<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${contextPath}/js/ajaxfileupload.js"></script>

<form id="studentChangeEditForm" method="post">
	<table cellpadding="7">

		<input id="id" name="id" type="hidden" value="<c:out value='${id}'/>" />
		<tr>
			<div style="margin-bottom: 20px">
				<td>学生姓名:</td>
				<td><input class="easyui-validatebox textbox" type="text"
					id="name" name="name" data-options="required:true "
					style="width: 200px; height: 18px; padding: 5px"  disabled="true" /> <em>(只读)</em>

				</td>
			</div>
		</tr>

		<tr>
			<div style="margin-bottom: 20px">
				<td>学生学号:</td>
				<td><input class="easyui-validatebox textbox" type="text"
					id="code" name="code" data-options="required:true "
					style="width: 200px; height: 18px; padding: 5px" disabled="true" 　/> <em>(只读)</em>

				</td>
			</div>
		</tr>


		<tr>
			<div style="margin-bottom: 20px">
				<td>异动类型:</td>
				<td><select class="easyui-combobox" id="changeType"
					name="changeType"
					data-options="editable:false,panelHeight: 'auto',panelWidth: 'auto',novalidate:true"
					validtype="selectRequired['changeType']"
					style="width: 212px; height: 33px; padding: 5px">
						<option value="0">===请选择异动方式===</option>
						<option value="1">普通转班</option>
						<option value="2">特殊转班</option>
						<option value="3">退学（开除）</option>
						<option value="4">休学</option>
						<option value="5">复学</option>
				</select></td>
			</div>
		</tr>

		<tr>
			<div style="margin-bottom: 20px">
				<td>转出班级:</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="outClassId" name="outClassId"
					data-options="required:true,novalidate:true,missingMessage:'该处未填写'"
					style="width: 200px; height: 18px; padding: 5px" ></input></td>
			</div>
		</tr>

		<tr>
			<div style="margin-bottom: 20px">
				<td>转出日期:</td>

				<td><input class="easyui-datetimebox textbox" type="text"
					id="outClassDate" name="outClassDate"
					data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
					style="width: 200px; height: 18px; padding: 5px"></input></td>
			</div>
		</tr>
		<tr>
			<div style="margin-bottom: 20px">
				<td>转入班级:</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="intoClassId" name="intoClassId"
					data-options="required:true,novalidate:true,missingMessage:'该处未填写'"
					style="width: 200px; height: 18px; padding: 5px" placeholder="若无转入班级，请填写原班级"></input></td>
			</div>
		</tr>

		<tr>
			<div style="margin-bottom: 20px">
				<td>转入日期:</td>

				<td><input class="easyui-datetimebox textbox" type="text"
					id="intoClassDate" name="intoClassDate"
					data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
					style="width: 200px; height: 18px; padding: 5px" ></input></td>
			</div>
		</tr>

		<tr>
			<div style="margin-bottom: 20px">
				<td>处理人员:</td>

				<td><input class="easyui-validatebox textbox" type="text"
					id="operUser" name="operUser"
					style="width: 200px; height: 18px; padding: 5px"></input></td>
			</div>
		</tr>
	</table>
	<div style="margin-left: 10px">
		<span>异动原因:</span><br>
		<textArea class="textarea" id="cause" name="cause" rows="10"
			cols="100"></textArea>
	</div>
	<br>
	<div style="margin-left: 10px">
		<span>备注:</span><br>
		<textArea class="textarea" id="remark" name="remark" rows="10"
			cols="100"></textArea>
	</div>
</form>

<div style="text-align: center; padding: 5px">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="editStudentChange('#studentChangeEditForm')">提交</a> 
</div>

</div>

<script type="text/javascript">
	$(function() {
		getStudentChange("#studentChangeEditForm");
	});

	function getStudentChange(form) {
		var id = $(form).find("#id").val();
		$.post('stu/getStudentChange.do', {
			"id" : id
		}, function(data) {
			$(form).find("#name").val(data.scDto.name);
			$(form).find("#code").val(data.scDto.code); 
			$(form).find('#changeType').combobox('select',data.scDto.changeType);
			$(form).find("#outClassId").val(data.scDto.outClassId);
			$(form).find("#outClassDate").datebox('setText',data.scDto.outClassDateStr);
			$(form).find("#intoClassId").val(data.scDto.intoClassId);
			$(form).find("#intoClassDate").datebox('setText',data.scDto.intoClassDateStr);
			$(form).find("#operUser").val(data.scDto.operUser);
			$(form).find("#cause").val(data.scDto.cause);
			$(form).find("#remark").val(data.scDto.remark);


		}, "json")
	}
	function editStudentChange(form) {
		//在提交数据之前执行表单验证
		$('#studentChangeEditForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}
		
		
		var id = $(form).find("#id").val();
		var name = $(form).find("#name").val();
		var code = $(form).find("#code").val(); 
		var changeType = $(form).find('#changeType')
		.combobox('getValue');		
		var outClassId = $(form).find("#outClassId").val();
		var outClassDateStr=$(form).find("#outClassDate").datebox('getText');
		var intoClassId = $(form).find("#intoClassId").val();
		var intoClassDateStr=$(form).find("#intoClassDate").datebox('getText');
		var operUser = $(form).find("#operUser").val();
		var cause =$(form).find("#cause").val();
		var remark = $(form).find("#remark").val(); 
		


		$.post('stu/editStudentChange.do', {

			"id" : id,
			"name" : name,
			"code" : code,
			"changeType":changeType,
			"outClassId" : outClassId,
			"outClassDateStr" : outClassDateStr,
			"intoClassId" : intoClassId,
			"intoClassDateStr" : intoClassDateStr,
			"operUser" : operUser,
			"cause" : cause,
			"remark" : remark
		}, function(result) {
			closeTab(getCurrentTab());
			$('#studentChangeList').datagrid('reload');
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
