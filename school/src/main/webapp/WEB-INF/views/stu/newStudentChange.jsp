<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel"
	style="padding: 30px 70px 20px 70px; height: 100%;">
	<form id="newStudentChangeForm" method="post">
		<table cellpadding="7">
			<tr>
				<div style="margin-left: 10px; margin-bottom: -15px">
					<label style="margin-right: 10px">学生学号: </label> <input
						id="studentId" name="studentId" type="hidden" required="true">
					<!--HIU， required:true，不要easyUI原来的验证，用jquery，因隐藏后的表单 ,easyUI也会进行验证，导致无法提交-->
					<input id="code" name="code" class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,novalidate:true,missingMessage:'该处未填写'"
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
					<td>异动类型:</td>
					<td><select class="easyui-combobox" id="changeType"
						name="changeType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '100px',novalidate:true"
						validtype="selectRequired['changeType']"
						style="width: 100px; height: 33px; padding: 5px">
							<!-- 页面初始化时不加载全部，等选择学号后再加载
							<option value="">请选择</option>
							<c:forEach items="${changeTypeList}" var="changeType">
							<option value="${changeType.id}">${changeType.name}</option>
							</c:forEach>
							 -->
					</select></td>
				</div>
			</tr>

			<tr class="outClass_style">
				<div style="margin-bottom: 20px;">
					<td>转出班级:</td>
					<!--HIU， required:true，不要easyUI原来的验证，用jquery，因隐藏后的表单 ,easyUI也会进行验证，导致无法提交-->
					<td><input class="easyui-validatebox textbox" type="text"
						id="outClassName" name="outClassName"
						data-options="editable:false,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px"></input></td>
				</div>
			</tr>

			<tr class="outClass_style">
				<div style="margin-bottom: 20px;">
					<td>转出日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="outClassDate" name="outClassDate"
						data-options="editable:false,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>

			<tr class="intoClass_style">
				<div style="margin-bottom: 20px;">
					<td>转入班级:</td>
					<td><input id="intoClassName" name="intoClassName"
						class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px" /></input><em>（若无转入班级，请选择原班级）</em>
					</td>
				</div>
			</tr>


			<tr class="intoClass_style">
				<div style="margin-bottom: 20px;">
					<td>转入日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="intoClassDate" name="intoClassDate"
						data-options="editable:false,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
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
			<textArea class="textarea" id="cause" name="cause" rows="3" cols="60"></textArea>
		</div>
		<br>
		<div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="3"
				cols="60"></textArea>
		</div> -->
	</form>

	<div style="margin-left: 180px; margin-top: 20px; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewStudentChange('#newStudentChangeForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>

	</div>
	<%@ include file="/WEB-INF/views/stu/select_student_dialog.jsp"%>
	
	<%@ include file="/WEB-INF/views/stu/select_intoclass_dialog.jsp"%>
</div>


<script type="text/javascript">
	$(function() {

		$("#newStudentChangeForm").find("#code").textbox({
			onClickButton : function() {
				openNewSelectStudentDialog();
			}
		})

		$("#newStudentChangeForm").find("#name").textbox({
			onClickButton : function() {
				openNewSelectClassDialog();
			}
		})
		$("#newStudentChangeForm").find("#outClassName").textbox({
			onClickButton : function() {
				openNewSelectClassDialog();
			}
		})
		$("#newStudentChangeForm").find("#intoClassName").textbox({
			onClickButton : function() {
				
				//hiu add,加载select-intoclass-dialog.jsp的表格数据
				$('#selectIntoclassList').datagrid({   
				    url:'${contextPath}/stu/getClassList.do'
				});
				
				openNewSelectClassDialog();
			}
		})

		//$(".outClass_style").hide();
		$(".intoClass_style").hide();

		$("#changeType").combobox({
			onChange : function() {

				var myValue = $(this).combobox('getValue');

				if (myValue == null || myValue == "" || myValue == -1) {
					$.messager.alert("操作提示", "请先选择学号!", "warning");
					return;
				}

				if (myValue == "14002") {
					showClassDiv(true, false);
				}

				if (myValue == "14003") {
					showClassDiv(true, false);
				}

				if (myValue == "14004") {
					showClassDiv(false, true);
				}

			}
		});

		/*
		$("#newStudentChangeForm").find("#changeType").click(function(){

			console.info("you click");
		    var myValue=$(this).combobox('getValue');
			
			if(myValue==null || myValue=="" || myValue==-1){
				$.messager.alert("操作提示","请先选择学号!","warning");
				return;
			}

		});
		 */
	});

	function showClassDiv(out, into) {

		if (out) {
			$(".outClass_style").show("slow");
			//$("#outClassName").combobox({required:true});
			//	$("#outClassDate").combobox({required:true});
		} else {
			$(".outClass_style").hide("fast");
			//	$("#outClassName").combobox({required:false});
			//	$("#outClassDate").combobox({required:false});
		}
		;

		if (into) {
			$(".intoClass_style").show("slow");
			// $("#intoClassName").combobox({required:true});
			//$("#intoClassDate").combobox({required:true});
		} else {
			$(".intoClass_style").hide("fast");
			//  $("#intoClassName").combobox({required:false});
			// $("#intoClassDate").combobox({required:false});
		}
		;
	}
	
	function openNewSelectStudentDialog() {
		$('#select-student-dialog').find('#openForm').val(
				"#newStudentChangeForm");
		$('#select-student-dialog').dialog('open');
	}

	function openNewSelectClassDialog() {
		$('#select-intoclass-dialog').find('#openForm').val(
				"#newStudentChangeForm");
		$('#select-intoclass-dialog').dialog('open');
	}

	function addNewStudentChange(form) {
		/*HIU，不要easyUI原来的验证，用jquery，因隐藏后的表单 ,easyUI也会进行验证，导致无法提交
		//在提交数据之前执行表单验证
		$('#newStudentChangeForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		
		if (!$(form).form('validate')) {
			return false;
		}
		 */

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

		var studentStatus = changeType;

		//HIU add，验证表单
		if (code == null || code == "") {
			$.messager.alert("操作提示", "请选择学号!", "warning");
			return;
		}

		if ((code != null || cod != "")
				&& (changeType == null || changeType == "" || changeType == "0")) {
			$.messager.alert("操作提示", "请选择异动类型!", "warning");
			return;
		}

		if (changeType == "14002" || changeType == "14003") {

			if (outClassName == null || outClassName == "") {
				$.messager.alert("操作提示", "请选择转出班级!", "warning");
				return;
			}

			if (outClassDateStr == null || outClassDateStr == "") {
				$.messager.alert("操作提示", "请选择转出日期!", "warning");
				return;
			}
		}

		if (changeType == "14004") {
			if (intoClassName == null || intoClassName == "") {
				$.messager.alert("操作提示", "请选择转入班级!", "warning");
				return;
			}

			if (intoClassDateStr == null || intoClassDateStr == "") {
				$.messager.alert("操作提示", "请选择转入日期!", "warning");
				return;
			}
		}

		$.post('stu/addStudentChange.do', {

			"code" : code,
			"changeType" : changeType,
			"outClassName" : outClassName,
			"outClassDateStr" : outClassDateStr,
			"intoClassName" : intoClassName,
			"intoClassDateStr" : intoClassDateStr,
			"operUser" : operUser,
			"cause" : cause,
			"remark" : remark,
			"studentStatus" : studentStatus
		}, function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加学籍异动成功！", "info");
				$('#studentChangeList').datagrid('reload');
			} else if (data.result == -1) {
				$.messager.alert("操作提示", "输入的学籍异动信息不完整!", "warning");
			}
		}, "json")
	}

	function clearForm() {
		$('#newStudentChangeForm').form('clear');
		$('#newStudentChangeForm').find('#changeType').combobox('select', 0);
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