<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style scoped type="text/css">
#teachTaskEditForm #moreTeacher{
	text-decoration: none
}

#teachTaskEditForm #moreTeacher:hover {
	color: red;
}
</style>
<script src="${contextPath}/js/ajaxfileupload.js"></script>
<div class="easyui-panel" style="padding: 30px 90px 90px 70px">
	<form id="teachTaskEditForm" method="post">
		<table cellpadding="7">

			<input id="teachTaskId" name="teachTaskId" type="hidden"
				value="<c:out value='${teachTaskId}'/>" />
			<input id="studyYearIdPar" name="studyYearIdPar" type="hidden"
				value="<c:out value='${studyYearIdPar}'/>" />
			<input id="termTypePar" name="termTypePar" type="hidden"
				value="<c:out value='${termTypePar}'/>" />
			<input id="courseIdPar" name="courseIdPar" type="hidden"
				value="<c:out value='${courseIdPar}'/>" />
			<input id="coursePlanIdPar" name="coursePlanIdPar" type="hidden"
				value="<c:out value='${coursePlanIdPar}'/>" />
			<input id="classIdPar" name="classIdPar" type="hidden"
				value="<c:out value='${classIdPar}'/>" />
			<input id="oldCourseSeq" name="oldCourseSeq" type="hidden"
				value="<c:out value='${courseSeqPar}'/>" />

			<tr>
				<div style="margin-bottom: 20px">
					<td>课程名称:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="courseName" name="courseName"
						value="<c:out value='${courseNamePar}'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属专业:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="major" name="major" value="<c:out value='${majorPar}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>专业方向:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="field" name="field" value="<c:out value='${fieldPar}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属年级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="grade" name="grade" value="<c:out value='${gradePar}'/>"
						readonly="true" style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>上课班级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="className" name="className"
						value="<c:out value='${classNamePar}'/>" readonly="true"
						style="width: 200px; height: 18px; padding: 5px;border-style:none"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>课程序号:</td>

					<td><input class="easyui-numberbox" id="courseSeq" value="<c:out value='${courseSeqPar}'/>"
						name="courseSeq" style="height: 31px; width: 208px"></input><em>（课程序号相同的班级，表示一起上课）</em></td>
				</div>
			</tr>
			

			<tr>
				<div style="margin-bottom: 20px">
					<td>任课老师姓名1:</td>

					<td><input class="easyui-textbox textbox" type="text"
						id="teacherName1" name="teacherName1"
						value="<c:out value='${teacherName1Par}'/>"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'请先在此处选择一名任课教师'"
						style="height: 31px; width: 208px"></input><input id="teacherId1"
						name="teacherId1" type="hidden"
						value="<c:out value='${teacherId1Par}'/>" required="true">
						<a href="javascript:void(0)" onclick="moreTeacher()"
						style="vertical-align: middle; padding: 5px 7px; margin-left: 25px;background:#F5F5F5; border-radius: 5px"
						id="moreTeacher" data-options="plain:true">更多任课教师∨</a></td>
				</div>
			</tr>



		</table>

		<div id="moreTeacherName"
			style="margin-top: 10px; margin-bottom: 20px; margin-left: 7px;">
			<label style="margin-right: 15px">任课老师姓名2:</label> <input
				class="easyui-textbox " type="text" id="teacherName2"
				name="teacherName2" value="<c:out value='${teacherName2Par}'/>"
				data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false"
				style="height: 31px; width: 208px"></input><input id="teacherId2"
				value="<c:out value='${teacherId2Par}'/>" name="teacherId2"
				type="hidden" required="true">
		</div>

	</form>
	<div style="margin-left: 180px; margin-top: 20px; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editTeachTask('#teachTaskEditForm')">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
	</div>
</div>
<%@ include
	file="/WEB-INF/views/edu/teachTask_select_teacher_dialog1.jsp"%>
<%@ include
	file="/WEB-INF/views/edu/teachTask_select_teacher_dialog2.jsp"%>

</div>

<script type="text/javascript">
	$(function() {
		$('#teachTaskEditForm').find('#moreTeacherName').panel({
			//	title:"更多条件",
			border : false,
			collapse : true,
			collapsed : true
		//	collapsible: true
		});

		$("#teachTaskEditForm").find("#teacherName1").textbox({
			onClickButton : function() {
				openNewSelectTeaDialog1();
			}
		})

		$("#teachTaskEditForm").find("#teacherName2").textbox({
			onClickButton : function() {
				openNewSelectTeaDialog2();
			}
		})

	});

	function openNewSelectTeaDialog1() {
		$('#select-tea-dialog1').find('#openForm1').val("#teachTaskEditForm");
		$('#select-tea-dialog1').dialog('open');
	}

	function openNewSelectTeaDialog2() {
		$('#select-tea-dialog2').find('#openForm2').val("#teachTaskEditForm");
		$('#select-tea-dialog2').dialog('open');
	}

	//点击更多条件按钮
	function moreTeacher() {
		if ($('#teachTaskEditForm').find('#moreTeacher').text() == '更多任课教师∨') { //折叠状态
			$('#teachTaskEditForm').find('#moreTeacher').text("收起∧");
			//	$('#moreBtn').css({padding: '2px 5px'});
			$('#teachTaskEditForm').find('#moreTeacherName').panel('expand',
					true);
		} else {
			$('#teachTaskEditForm').find('#moreTeacher').text("更多任课教师∨");
			//	$('#moreBtn').css({padding: '2px'});
			$('#teachTaskEditForm').find('#moreTeacherName').panel('collapse',
					true);
		}

	}
	
	function cancel(){
		closeTab(getCurrentTab());
	}

	function editTeachTask(form) {
		//在提交数据之前执行表单验证
		$('#teachTaskEditForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}

		var teacherId1 = $(form).find("#teacherId1").val();
		var teacherId2 = $(form).find("#teacherId2").val();
		var id = $(form).find("#teachTaskId").val();
		var studyYearId = $(form).find("#studyYearIdPar").val();
		var termType = $(form).find("#termTypePar").val();
		var courseName = $(form).find("#courseName").val();
		var major = $(form).find("#major").val();
		var field = $(form).find("#field").val();
		var grade = $(form).find("#grade").val();
		var className = $(form).find("#className").val();
		var courseSeq = $(form).find("#courseSeq").val();
		var teacherName1 = $(form).find("#teacherName1").val();
		var teacherName2 = $(form).find("#teacherName2").val();
		var courseId = $(form).find("#courseIdPar").val();
		var coursePlanId = $(form).find("#coursePlanIdPar").val();
		var classId = $(form).find("#classIdPar").val();
		var oldCourseSeq = $(form).find("#oldCourseSeq").val();
		
		var param = {
			"teacherId1" : teacherId1,
			"teacherId2" : teacherId2,
			"id" : id,
			"studyYearId" : studyYearId,
			"termType" : termType,
			"courseName" : courseName,
			"major" : major,
			"field" : field,
			"grade" : grade,
			"className" : className,
			"courseSeq" : courseSeq,
			"teacherName2" : teacherName2,
			"teacherName1" : teacherName1,
			"courseId" : courseId,
			"classId" : classId,
			"oldCourseSeq" : oldCourseSeq,
			"coursePlanId" : coursePlanId
		}
		
		if (teacherId1 == teacherId2) {
			$.messager.alert('提示', '您好，任课教师不可重复，谢谢！');
		} else if(courseSeq<1) {
			$.messager.alert('提示', '您好，课程序号请填 0 以上的数值，谢谢！');
		}else {
			$.post('edu/editTeachTask.do', param, function(result) {
				closeTab(getCurrentTab());
				$('#teachTaskList').datagrid('reload');
				$.messager.alert("操作提示", "编辑教学任务信息成功", "info");
			}, "json")
		}

	}
</script>


<style scoped="scoped">
#teacherName2 {
	margin-left: 18px;
}

.textbox {
	height: 20px;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
