<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${contextPath}/js/ajaxfileupload.js"></script>
<div class="easyui-panel" style="padding: 30px 90px 90px 70px">
	<form id="teachCourseEditForm" method="post">
		<table cellpadding="7">

			<input id="teachCourseId" name="teachCourseId" type="hidden"
				value="<c:out value='${teachCourseId}'/>" />


			<tr>
				<div style="margin-bottom: 20px">
					<td>课程名称:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="courseName" name="courseName"
						readonly="true"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属专业:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="major" name="major"
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>专业方向:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="field" name="field"
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属年级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="grade" name="grade"
						readonly="true" style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			<!-- <tr>
				<div style="margin-bottom: 20px">
					<td>课程序号:</td>

					<td><input class="easyui-numberbox textbox" type="text"
						id="courseSeq" name="courseSeq"
						readonly="true"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr> -->
			<tr>
				<div style="margin-bottom: 20px">
					<td>任课老师姓名:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="name" name="name"
						 readonly="true"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>上课班级:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="classes" name="classes"
						readonly="true"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>考试日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="examDateStr" name="examDateStr"
						data-options="editable:false,showSeconds:false"
						style="height: 33px; width: 208px"></input></td>
				</div>
			</tr>
			<tr>   
				<div style="margin-bottom: 20px">
					<td>考试类型:</td>
					
					<td><select class="easyui-combobox" id="scoreType"
						name="scoreType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true"
						validtype="selectRequired['scoreType']"
						style="width: 67px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<option value="35001">百分制</option>
							<option value="35002">等级制</option>
					</select></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>平时成绩所占比例:</td>

					<td><input class="easyui-numberbox textbox" type="text"
						id="usualScoreRatio" name="usualScoreRatio"
						style="height: 31px; width: 208px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>录入时间:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="inputTimeStr" name="inputTimeStr"
						data-options="editable:false"
						style="height: 33px; width: 208px"></input></td>
				</div>
			</tr>

		</table>
		
		
		
	</form>
	<div style="margin-left: 180px; margin-top: 20px; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editTeachCourse('#teachCourseEditForm')">提交</a>
	</div>
</div>
	

</div>

<script type="text/javascript">
		$(function() {
			getTeachCourse("#teachCourseEditForm");
		});
		
		function getTeachCourse(form) {
			var id = $(form).find("#teachCourseId").val();
			$.post('edu/getTeachCourse.do', {
				"id" : id,
			}, function(data) {
				$(form).find('#scoreType').combobox('select',data.tcDto.scoreType);
				$(form).find('#courseName').val(data.tcDto.courseName);
				$(form).find("#field").val(data.tcDto.field);
				$(form).find("#major").val(data.tcDto.major);
				$(form).find("#grade").val(data.tcDto.grade);
				$(form).find("#inputTimeStr").datebox('setText',data.tcDto.inputTimeStr);
				$(form).find("#examDateStr").datebox('setText',data.tcDto.examDateStr);
				$(form).find("#name").val(data.tcDto.name);
				$(form).find("#classes").val(data.tcDto.classes);
				$(form).find("#usualScoreRatio").val(data.tcDto.usualScoreRatio);
				
		
			}, "json")
		}
	

	
	function editTeachCourse(form) {
		//在提交数据之前执行表单验证
		$('#teachCourseEditForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
		var teacherId1 = $(form).find("#teacherId1").val();
		var teacherId2 = $(form).find("#teacherId2").val();
		if(teacherId1==teacherId2) {
			 $.messager.alert('提示','您好，任课教师不可重复，谢谢！');
		}
		
		var id = $(form).find("#teachCourseId").val();
		var studyYearId = $(form).find("#studyYearIdPar").val();
		var termType = $(form).find('#termTypePar').combobox('getValue');
		var courseName = $('#form').find("#courseName").val();
		var major = $('#form').find("#major").val();
		var field = $('#form').find("#field").val();
		var grade = $('#form').find("#grade").val();
		var className = $('#form').find("#className").val();
		var courseSeq = $('#form').find("#courseSeq").val();
		var teacherName1 = $('#form').find("#teacherName1").val();
		var teacherName2 = $('#form').find("#teacherName2").val();
		

		$.post('edu/editTeachCourse.do', {

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
			"teacherName1" : teacherName1
		}, function(result) {
			closeTab(getCurrentTab());
			$('#teachCourseList').datagrid('reload');
		}, "json")
	}
</script>


<style scoped="scoped">
#teacherName2{
margin-left:18px;
}
.textbox {
	height: 20px;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
