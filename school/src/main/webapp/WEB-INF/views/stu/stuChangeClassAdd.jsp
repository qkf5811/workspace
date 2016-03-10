<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="StuChangeClassForm" method="post">
   <table cellpadding="7">
			<tr>
				<div style="margin-left: 10px; margin-bottom: -15px">
					<label style="margin-right: 10px">学生学号: </label> <input
						id="studentId" name="studentId" type="hidden" required="true">
					<input id="code" name="code" class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px">
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>学生姓名:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="name" name="name" readonly="readonly"
						style="width: 120px; height: 33px; padding: 5px"></input></td>
				</div>
			</tr>


			<tr>
				<div style="margin-bottom: 20px">
					<td>转班类型:</td>
					<td><select class="easyui-combobox" id="changeType"
						name="changeType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '100px',novalidate:true"
						validtype="selectRequired['changeType']"
						style="width: 100px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${changeTypeList}" var="changeType">
							<option value="${changeType.id}">${changeType.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>


			<tr>
				<div style="margin-bottom: 20px">
					<td>转出班级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="outClassName" name="outClassName"
						data-options="required:true,editable:false,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px"></input></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>转出日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="outClassDate" name="outClassDate"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>



			<tr>
				<div style="margin-bottom: 20px">
					<td>转入班级:</td>
					<td><input id="intoClassName" name="intoClassName"
						class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px" /></input><em>（若无转入班级，请选择原班级）</em>
					</td>
				</div>
			</tr>





			<tr>
				<div style="margin-bottom: 20px">
					<td>转入日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="intoClassDate" name="intoClassDate"
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
					<td>转班原因:</td>

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
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="stuChangeClassSave('#StuChangeClassForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>
	<%@ include file="/WEB-INF/views/stu/select_student_dialog.jsp"%>
	<%@ include file="/WEB-INF/views/stu/select_intoclass_dialog.jsp"%>
</div>


<script type="text/javascript">
	
	
	$(function() {

		$("#StuChangeClassForm").find("#code").textbox({
			onClickButton : function() {
				openNewSelectStudentDialog();
			}
		})
		$("#StuChangeClassForm").find("#name").textbox({
			onClickButton : function() {
				openNewSelectClassDialog();
			}
		})
		$("#StuChangeClassForm").find("#outClassName").textbox({
			onClickButton : function() {
				openNewSelectClassDialog();
			}
		})
		$("#StuChangeClassForm").find("#intoClassName").textbox({
			onClickButton : function() {
				openNewSelectClassDialog();
			}
		})
	});
	function openNewSelectStudentDialog() {
		$('#select-student-dialog').find('#openForm').val(
				"#StuChangeClassForm");
		$('#select-student-dialog').dialog('open');
	}

	function openNewSelectClassDialog() {
		$('#select-intoclass-dialog').find('#openForm').val(
				"#StuChangeClassForm");
		$('#select-intoclass-dialog').dialog('open');
	}
	function stuChangeClassSave(form) {

		//在提交数据之前执行表单验证
		$('#StuChangeClassForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}

		var studentId = $(form).find("#studentId").val();
		var code = $(form).find("#code").val();
		var changeType = $(form).find('#changeType').combobox('getValue');
		var outClassName = $(form).find("#outClassName").val();
		var outClassDateStr = $(form).find("#outClassDate").datebox('getValue');
		var intoClassName = $(form).find("#intoClassName").val();
		var intoClassDateStr = $(form).find("#intoClassDate").datebox(
				'getValue');
		var operUser = $(form).find("#operUser").val();
		var cause = $(form).find("#cause").val();
		var remark = $(form).find("#remark").val();
		$.post('stu/stuChangeClassSave.do', {

			"code" : code,
			"changeType" : changeType,
			"outClassName" : outClassName,
			"outClassDateStr" : outClassDateStr,
			"intoClassName" : intoClassName,
			"intoClassDateStr" : intoClassDateStr,
			"operUser" : operUser,
			"cause" : cause,
			"remark" : remark
		}, function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加学生转班成功！", "info");
				$('#StuChangeClassList').datagrid('reload');
			} else if (data.result == -1) {
				$.messager.alert("操作提示", "输入的学生转班信息不完整!", "warning");
			}
		}, "json")
	}

	function clearForm() {
		$('#StuChangeClassForm').form('clear');
		$('#StuChangeClassForm').find('#changeType').combobox('select', 0);
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
