<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="newTeaChangeForm" method="post">
		<table cellpadding="7">
			<tr>
				<div style="margin-left: 10px;margin-bottom:-15px">
					<label style="margin-right: 18px">教师编号: </label> <input
						id="teacherId" name="teacherId" type="hidden" required="true">
					<input id="code" name="code" class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'该处未填写'" style="width: 200px; height: 33px; padding: 5px">
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>教师姓名：</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="name" name="name" readonly="readonly"
						style="width: 100px; height: 33px; padding: 5px"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>异动类型:</td>
					<td><select class="easyui-combobox" id="changeType"
						name="changeType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true"
						validtype="selectRequired['changeType']"
						style="width: 67px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${teaChangeTypeList}" var="teaChangeType">
							<option value="${teaChangeType.id}">${teaChangeType.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>


			

			<tr>
				<div style="margin-bottom: 20px">
					<td>异动日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="changeDate" name="changeDate"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
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
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>异动原因:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="cause" name="cause"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="remark" name="remark"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
		</table>
		<!-- <div style="margin-left: 10px">
			<span>异动原因:</span><br>
			<textArea class="textarea" id="cause" name="cause" rows="3"
				cols="60"></textArea>
		</div>
		<br>
		<div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="3"
				cols="60"></textArea>
		</div> -->
	</form>

	<div style="margin-left:180px; margin-top:20px;padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewTeaChange('#newTeaChangeForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>
	<%@ include file="/WEB-INF/views/tea/teachange_select_teacher_dialog.jsp"%>
</div>


<script type="text/javascript">
	$(function() {
		
		
		$("#newTeaChangeForm").find("#code").textbox({
			onClickButton : function() {
				openNewSelectTeaDialog();
			}
		})
		
		$("#newTeaChangeForm").find("#name").textbox({
				onClickButton : function() {
					openNewSelectTeaDialog();
			} 
		});
		
		
		
	});
	function openNewSelectTeaDialog() {
		$('#select-tea-dialog').find('#openForm').val("#newTeaChangeForm");
		$('#select-tea-dialog').dialog('open');
	}
	
	
	function addNewTeaChange(form) {

		//在提交数据之前执行表单验证
		$('#newTeaChangeForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
		
		
		var teacherId = $(form).find("#teacherId").val();
		var code = $(form).find("#code").val();
		var changeType = $(form).find('#changeType').combobox('getValue');	
		var changeDateStr = $(form).find("#changeDate").datebox('getValue');
		var operUser = $(form).find("#operUser").val();
		var cause = $(form).find("#cause").val();
		var remark = $(form).find("#remark").val();
		$.post('tea/addTeaChange.do', {
			"teacherId":teacherId,
			"code" : code,
			"changeType" : changeType,
			"changeDateStr" : changeDateStr,
			"operUser" : operUser,
			"cause" : cause,
			"remark" : remark
		}, function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加教师异动成功！", "info");
				$('#teaChangeList').datagrid('reload');
			} else if (data.result == -1) {
				$.messager.alert("操作提示", "输入的教师异动信息不完整!", "warning");
			}
		}, "json")
	}

	function clearForm() {
		$('#newTeaChangeForm').form('clear');
		$('#newTeaChangeForm').find('#changeType').combobox('select',0);
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