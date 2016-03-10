<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style scoped type="text/css">
#setTeacherCourseToolbar #getMoreBtn {
	text-decoration: none;
}

#setTeacherCourseToolbar #getMoreBtn:hover {
	color: red;
}
</style>
<div style="width: 99%; height: auto">
	<div id="setTeacherCourseToolbar" style="padding: 5px; height: auto" >
		<div>
			<td >学年:</td>
			<td><select class="easyui-combobox" id="studyYearId"
				data-options="editable:false,panelHeight:'auto'" style="width: 76px; height: 30px;">
				<option value="0">请选择</option>
				<c:forEach items="${studyYearList }" var="item">
				<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select></td>
			<td >学期类型:</td>
			<td><select class="easyui-combobox" id="termType"
				data-options="editable:false,panelHeight:'auto'" style="width: 76px; height: 30px;">
				<option value="0">请选择</option>
				<c:forEach items="${termTypeList }" var="item">
				<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select></td>			
			<td>课程名称：</td>
				<td><input class="easyui-validatebox textbox" id="courseName"
					name="courseName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				<td>教师姓名：</td>
					<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					</td> 
			
						
			
				
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchSetTeacherCourse('#setTeacherCourseToolbar', '#setTeacherCourseList')"
				iconCls="icon-search">查询</button>
			<a href="javascript:void(0)" onclick="getMoreConditions()"
			style="vertical-align: middle; padding: 5px 7px;  margin-left: 25px; background:#F5F5F5; border-radius: 5px"
			id="getMoreBtn" data-options="plain:true">更多∨</a>

		</div>
		<div id="getMoreConditions" style="margin-top:5px;">
			<table style="margin: 1px auto 2px 0px;">
				<tr>
					<td>年级：</td>
					<td><input class="easyui-validatebox textbox" id="grade"
					name="grade" 
					style="width: 100px; height: 18px; padding: 5px" />
					<td>教师编号:</td>
					<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					</td>  
										
				</tr>
			</table>
		</div>
	</div>
	<table id="setTeacherCourseList" class="easyui-datagrid"
		style="width: auto;" pagination="true" 
		toolbar="#setTeacherCourseOperToolbar" rownumbers="true" url="${contextPath}/edu/getTeachCourseList.do"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="studyYearName" width="120" align="center">学年</th>
				<th field="termTypeStr" width="100" align="center">学期类型</th>
				<th field="courseName" width="120" align="center">课程名称</th>
				<th field="grade" width="90" align="center">所属年级</th>
				<th field="name" width="60" align="center">教师姓名</th>
				<th field="classes" width="180" align="center">上课班级</th>
				<th field="examDateStr" width="100" align="center">考试日期</th>
				<th field="scoreTypeStr" width="100" align="center">考试类型</th>				
				<th data-options="field:'usualScoreRatio',width:150,align:'center',formatter:cellFormatter">平时成绩所占比例</th>
				<th field="inputTimeStr" width="100" align="center">录入时间</th>
			</tr>
		</thead>
	</table>
	<div id="setTeacherCourseOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="openTab('edu/toImportSchedulePage.do','导入课程表')">导入课程表</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="openTab('edu/toImportScheduleManual.do','手动排课')">手动排课</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="openTab('edu/manualAdjustCourse.do','手动调课')">手动调课</a>
	</div>
</div>

<script type="text/javascript">


	$(function() {
		//按钮初始化为panel
		$('#getMoreConditions').panel({
			//		title:"更多条件",
			border : false,
			collapse : true,
			collapsed : true
		//		collapsible: true
		});
		//	$('#getMoreConditions').panel('open');
	})
	
	//点击更多条件按钮
	function getMoreConditions() {
		if ($('#getMoreBtn').text() == '更多∨') { //折叠状态
			$('#getMoreBtn').text("收起∧");
			//	$('#getMoreBtn').css({padding: '2px 5px'});
			$('#getMoreConditions').panel('expand', true);
		} else {
			$('#getMoreBtn').text("更多∨");
			//	$('#getMoreBtn').css({padding: '2px'});
			$('#getMoreConditions').panel('collapse', true);
		}
	
	}

	//对平时成绩所占比例字段格式化
	function cellFormatter(value,row,index){
		if(value!=null){
			return value+'%';
		}
		
	}
	

	
	function searchSetTeacherCourse(toolbar, datagrid) {
		var studyYearId = $(toolbar).find('#studyYearId').combobox('getValue');
		var termType = $(toolbar).find('#termType').combobox('getValue');
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();
		var courseName = $(toolbar).find("#courseName").val();
		var major = $(toolbar).find("#major").val();
		var grade = $(toolbar).find("#grade").val();
		var field = $(toolbar).find("#field").val();

		//!-AJAX请求数据

		$(datagrid).datagrid('load', {
			studyYearId : studyYearId,
			termType : termType,
			name : name,
			courseName : courseName,
			major : major,
			grade : grade,
			field : field,
			code : code
		});
	}


	
	/* function toEditSetTeacherCourse() {
		var row = $('#setTeacherCourseList').datagrid('getSelected');

		if (row) {
			openTab('edu/toEditTeachCourse.do?id=' + row.id , '编辑教师授课信息');
		}
	} */
</script>
