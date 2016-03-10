<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
<div id="teaCourseToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>课程名称：</td>
				<td><input class="easyui-validatebox textbox" id="courseName"
					name="courseName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeaCourse('#teaCourseToolbar', '#teaCourseList')"
				iconCls="icon-search">查询</button>
		</div>
		</div>
	<table id="teaCourseList" class="easyui-datagrid" style="width: auto;" toolbar="#teaCourseOpenToolbar"
		pagination="true" url="${contextPath}/edu/getTeacherCourseList.do"
		 rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
			<th field="studyYearName" width="10%" align="center">学年</th>
				<th field="termTypeStr" width="10%" align="center">学期</th>
				<th field="name" width="15%" align="center">课程名称</th>
				<th field="code" width="8%" align="center">课程编号</th>
				<th field="classes" width="8%" align="center">班级</th>
				<th field="examDateStr" width="10%" align="center">考试日期</th>
				<th field="inputTimeStr" width="15%" align="center">录入日期</th>
				<th field="scoreTypeStr" width="10%" align="center">录入方式</th>
			</tr>
		</thead>
	</table>

	<div id="teaCourseOpenToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" id="addCourse"
			data-options="plain:true" onclick="openCourseScoreInput()">录入</a> 
<a class="easyui-linkbutton" iconCls="icon-edit" 
			data-options="plain:true" onclick="editCourseScoreList()">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" data-options="plain:true"
			onclick="showCourseScore()">查看</a>
	</div>

</div>

<script type="text/javascript">

	function showCourseScore() {
		var row = $('#teaCourseList').datagrid('getSelected');
		if (row) {
			if ($('#main').tabs('exists', '查看成绩')) {
		        $('#main').tabs('close', '查看成绩')
		    }
			var type = 1
			if(row.scoreTypeStr == '等级制') {
				type= 2
			}
			var name = row.studyYearName+'(' + row.termTypeStr+')课程：' + row.name
			openTab("edu/showCourseScoreList.do?teaCourse="+ row.field + "&name="+ name, "查看成绩");
		}else {
			$.messager.alert("操作提示", "请先选择一条课程信息!", "warning");
			return;
		}
	}

	function searchTeaCourse(toolbar, datagrid) {
		var name = $(toolbar).find("#courseName").val();
		var majorId = $(toolbar).find("#majorSelect").combobox('getValue');
		//!-AJAX请求数据
		$('#teaCourseList').datagrid({
			url : "${contextPath}/edu/getTeacherCourseList.do",
			queryParams : {
				"name" : name,
				"major" : majorId
			}
		});

	}
	
	function editCourseScoreList() {
		var row = $('#teaCourseList').datagrid('getSelected');
		if (row) {
			if ($('#main').tabs('exists', '修改成绩')) {
		        $('#main').tabs('close', '修改成绩')
		    }
			var type = 1
			if(row.scoreTypeStr == '等级制') {
				type= 2
			}
			openTab("edu/toEditCourseScoreList.do?teaCourseId="+ row.field + "&type="+ type, "修改成绩");
		}else {
			$.messager.alert("操作提示", "请先选择一条课程信息!", "warning");
			return;
		}
	}
	
	function openCourseScoreInput() {
		var row = $('#teaCourseList').datagrid('getSelected');
		if (row) {

	        $.post('edu/IsExistScore.do',{
	          "courseId":row.field
	        },function(data){
	        	if(data == 1) {
	        		$.messager.alert("操作提示", "课程班级成绩已经录入，请选择未录入的课程班级", "info");
	        		return;
	        	}else {

	    			if ($('#main').tabs('exists', '录入')) {
	    		        $('#main').tabs('close', '录入')
	    		    }
	    			var name = row.studyYearName+'(' + row.termTypeStr+')课程：' + row.name
	    			openTab("edu/courseScoreInput.do?course="+ row.field + "&courseName=" + name, "录入");
	        	}
	        })
			
			
		}else {
			$.messager.alert("操作提示", "请先选择一条课程信息!", "warning");
			return;
		}
		
	}
	
	//清空数据
	function clearNewCourseForm() {
		$('#newCourseForm').find('#majorSelectByAdd').combobox('setValue','请选择');
		$('#newCourseForm').find('#newCourseName').val("");
		$('#newCourseForm').find('#newCourseCode').val("");
		$('#newCourseForm').find('#newRemark').val("");
	}
	//删除课程
	function deleteCourse() {
		var row = $('#courseList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此课程吗?', function(r) {
				if (r) {
					$.post('edu/deleteCourse.do', {
						courseId : row.id
					}, function(data) {
						var obj = eval('(' + data + ')');
						if (obj.success == 1) {
							$.messager.alert("操作提示", "课程删除成功!", "info");
							$('#courseList').datagrid('reload'); // reload the course data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '删除课程失败'
							});
						}
					});
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的课程!", "warning");
	}
</script>
