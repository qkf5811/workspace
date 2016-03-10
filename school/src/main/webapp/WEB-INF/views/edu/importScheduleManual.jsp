<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css" scoped>
.left_1 {
	width: 160px;
	float: left;
}

.left_1 table {
	background: #E0ECFF;
	text-align: center;
}

.left_1 td {
	background: #eee;
	width: 80px;
	height: 20px;
}

.courseTableOfManuelScheduleCourse {
	width: 100%;
}

.courseTableOfManuelScheduleCourse table {
	background: #E0ECFF;
	width: 100%;
}

.courseTableOfManuelScheduleCourse td {
	background: #fafafa;
	text-align: center;
	padding: 2px;
	width: 50px;
}

.courseTableOfManuelScheduleCourse td {
	background: #E0ECFF;
	margin: 0px auto;
}

.courseTableOfManuelScheduleCourse td.drop:hover {
	border: 1px solid orange;
	cursor: pointer;
}

.courseTableOfManuelScheduleCourse td.drop .item_1:hover {
	background: pink;
	cursor: pointer;
	border-radius: 5px;
}

.courseTableOfManuelScheduleCourse td.title {
	font-family: '微软雅黑';
	font-size: 18px;
}

.courseTableOfManuelScheduleCourse td.time {
	font-family: '微软雅黑';
	font-size: 18px;
}

.courseTableOfManuelScheduleCourse td.release {
	font-family: '微软雅黑';
	font-size: 18px;
}

.courseTableOfManuelScheduleCourse td.drop {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 30px;
}

.courseTableOfManuelScheduleCourse td.over {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 80px;
}

.left_1 .item_1 {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 20px;
}

.addAssigned_1 {
	border: 1px solid #BC2A4D;
	text-align: center;
	background: #fafafa;
	width: 173px;
	height: 80px;
}
</style>
<div id="manualScheduleCourse">
	<!-- 	<div style="margin: 10px">
		<span>课程代号:</span>
		<input class="easyui-textbox" id="code" style="width: 120px; height: 30px">&nbsp;&nbsp;
		<span>课程名称:</span>
		<input class="easyui-textbox" id="name" style="width: 120px; height: 30px">&nbsp;&nbsp; -->
	<div style="margin: 10px">
		<form id="scheduleCourseForm">
			<div>
			<!-- <strong style="font-size:15px">上课班级:</strong> <br>  -->
				<span style="font-size:13px">　年级:</span> <select class="easyui-combobox"
					id="gradeOfSchedule" style="width: 150px" name="gradeOfSchedule"
					data-options="editable:false,panelHeight: 'auto'">
					<option value="请选择">请选择</option>
					<c:forEach items="${gradeList }" var="g">
						<option value="${g.id }">${g.name }</option>
					</c:forEach>
				</select> <span style="font-size:13px">　班级:</span> <select class="easyui-combobox" id="classOfManualSchedule"
					style="width: 150px" name="classOfManualSchedule"
					data-options="editable:false,panelHeight: '200px',panelWidth:'150px'">
					<option value="请选择">请选择</option>
				</select> <a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-search" plain="true"
					onclick="findCourseByMajorIdAndFieldId('#manualScheduleCourse')">查询课程</a>
			</div>
		</form>
	</div>
	<div style="text-align: center; margin: 5px;">
		<strong style="font-size: 18px">当前选中班级:</strong> <span
			id="selectedClass" style="font-size: 18px">无</span> <span
			id="classId" style="display: none"></span><!-- style="display: none" -->
	</div>
	<div>
		<div class="left_1" hidden="true">
			<table>
			</table>
		</div>
		<!-- 课程表 -->
		<div class="courseTableOfManuelScheduleCourse"
			id="courseTableOfManuelScheduleCourse"
			onselectstart="javascript:return false;"
			style="-moz-user-select: none; width: 98%; margin: 0px auto">
			<table>
				<tr>
					<td class="blank"></td>
					<td class="title">星期一</td>
					<td class="title">星期二</td>
					<td class="title">星期三</td>
					<td class="title">星期四</td>
					<td class="title">星期五</td>
				</tr>
				<tr>
					<td class="time">第一节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">第二节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">第三节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">第四节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">午休</td>
				</tr>
				<tr>
					<td class="time">第五节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">第六节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">第七节</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">放学</td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 添加课程窗口 -->
	<div id="addScheduleWindow" class="easyui-window"
		data-options="modal:true,closed:true,iconCls:'icon-add'"
		title="添加课程到排课表" style="width: 660px; height: 320px;">
		<table style="vertical-align: middle; margin: 25px auto">
			<tr style="display:none">
				<td>课程计划id:</td>
				<td><input id="teachCourseId" class="easyui-textbox"
					style="width: 210px; height: 30px"></td>
			</tr>
			<tr style="display:none">
				<td>courseScheduleId:</td>
				<td><input id="courseScheduleId" class="easyui-textbox"
					style="width: 210px; height: 30px"></td>
			</tr>
			<tr>
				<td><strong>选择课程:</strong></td>
				<td><input class="easyui-textbox" id="courseName"
					editable="false" style="width: 210px; height: 30px"
					data-options="buttonText:'选择', buttonIcon:'icon-search',prompt:'选择课程'">
				<td>
			</tr>
			<tr style="">
				<td><strong>上课时间:</strong></td>
				<td>
					<div>
						<span>星期:</span> <select id="weekDayOfSchedule"
							name="weekDayOfSchedule" class="easyui-combobox"
							style="width: 180px; height: 30px" editable="false"
							validtype="selectRequired['weekDayOfSchedule']" disabled="true"
							data-options="required: true,panelHeight:'auto',novalidate:true,missingMessage:'该处未选择'">
							<option value="0">请选择</option>
							<c:forEach items="${weekDay }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<span>节次:</span> <select id="sectionsOfSchedule"
							name="sectionsOfSchedule" class="easyui-combobox"
							style="width: 180px; height: 30px" editable="false"
							validtype="selectRequired['sectionsOfSchedule']" disabled="true"
							data-options="required:true,panelHeight:'auto', missingMessage:'该处未选择',novalidate:true">
							<option value="0">请选择</option>
							<c:forEach items="${sections }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div id="weeks" style="margin-right: 75px">
						<span>周次:</span> <span>连续周次:</span> <input
							class="easyui-validatebox textbox"
							style="width: 30px; height: 30px" id="weeks_1" name="weeks_1"
							>
						- <input class="easyui-validatebox textbox"
							style="width: 30px; height: 30px" id="weeks_2" name="weeks_2">&nbsp;&nbsp;&nbsp;
						<span>零散周次:</span> <input class="easyui-textbox"
							id="weekIds" name="weekIds" style="width: 120px; height: 30px"
							data-options="prompt:'请用逗号(,)分隔开'">
					</div>
				</td>
			</tr>
			<tr>
				<td><STRONG>上课地点:</strong></td>
				<td><select class="easyui-combobox"
					style="width: 150px; height: 30px" editable="false" id="campusId1"
					name="campusId1" validtype="selectRequired['campusId1']"
					data-options="required: true,panelHeight:'auto',novalidate:true,missingMessage:'该处未选择'">
						<option value="请选择">请选择</option>
						<c:forEach items="${campusId }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select> <select class="easyui-combobox" style="width: 150px; height: 30px"
					editable="false" id="buildingId1" name="buildingId1"
					validtype="selectRequired['buildingId1']"
					data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
						<option value="请选择">请选择</option>
				</select> <select class="easyui-combobox" style="width: 150px; height: 30px"
					editable="false" id="classId1" name="classId1"
					validtype="selectRequired['classId1']"
					data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
						<option value="0">请选择</option>
				</select></td>
			</tr>
		</table>
		<div style="text-align: center; margin-top: 25px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok"
				onclick="confirmAddCourseSchedule('#addScheduleWindow')">确认添加</a>
		</div>
	</div>
	<!-- 删除课程窗口 -->
	<div id="deleteScheduleWindow" class="easyui-window"
		data-options="modal:true,closed:true,iconCls:'icon-remove'"
		title="从排课表中删除课程" style="width: 420px; height: 190px;">

		<div style="margin: 25px auto; text-align: center">
			<span>选择课程:</span> <select class="easyui-combobox"
				id="courseOfDelete"
				style="height: 35px; width: 180px; font-size: 35px"
				data-options="editable:false,panelHeight:'auto', panelWidth: '180px'">
				<option value="请选择">请选择</option>
			</select>
		</div>
		<div style="margin: 30px auto; text-align: center">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok"
				onclick="confirmDeleteCourseSchedule('#deleteScheduleWindow')">确认删除</a>
		</div>
	</div>

	<!-- 弹出对话框选择课程计划 -->
	<div id="selecctCoursePlainOfManualCourseSchedule"
		class="easyui-dialog" style="width: 610px; height: auto;" top="200px"
		title="选择课程计划" iconCls="icon-search"
		data-options="resizable:false,modal:true, closed:true">

		<table class="easyui-datagrid" width="100%"
			id="coursePlanOfManualCourseSchedule" pagination="true"
			rownumbers="true" singleSelect="true" data-option="pageSize:10">
			<thead>
				<tr>
					<th field="planId" width="100px" hidden>课程计划id</th>
					<th field="majorId" width="100px" hidden>MajorId</th>
					<th field="majorName" width="140px">专业</th>
					<th field="fieldId" width="100px" hidden>FieldId</th>
					<th field="fieldName" width="140px" align="center">专业方向</th>
					<th field="gradeId" width="100px" align="center" hidden>年级id</th>
					<th field="courseId" align="center" width="60px" hidden>CourseId</th>
					<th field="courseName" align="center" width="140px">课程名称</th>
					<th field="code" width="140px" align="center">课程代号</th>
					<th field="teachCourseId" width="100px" align="center" hidden>TeachCourseId</th>
				</tr>
			</thead>
			<div id="coursePlanOfManualCourseScheduleToolbar" style="margin: 2px">
				<span>所属专业:</span> <select class="easyui-combobox"
					id="majorSelectOfCoursePlan" style="width: 120px" disabled="true"
					data-options="editable:false, panelHeight:'auto',panelWidth:'120px'">
					<option value="请选择">请选择</option>
					<c:forEach items="${majorList }" var="m">
						<option value="${m.id }">${m.name }</option>
					</c:forEach>
				</select> <select class="easyui-combobox" id="fieldSelectOfCoursePlan"
					style="width: 120px" disabled="true"
					data-options="editable:false, panelHeight:'auto',panelWidth:'120px'">
					<option value="请选择">请选择</option>
				</select> <span>课程名称:</span> <input class="easyui-textbox" id="courseName">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-search"
					onclick="findCoursePlanOfCourseSchedule('#selecctCoursePlainOfManualCourseSchedule')">查询</a>
			</div>
		</table>
		<div style="text-align: right; margin: 2px; ">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok"
				onclick="clickSelectCoursePlan('#selecctCoursePlainOfManualCourseSchedule')">选择</a>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {

		/* 	//	$('.left .item').draggable('disable');
		 $('.left_1 .item_1').draggable({
		 revert : true,
		 proxy : 'clone'
		 });
		 //	$('.courseTableOfManuelScheduleCourse td.drop').droppable('disable');
		 $('.courseTableOfManuelScheduleCourse td.drop').droppable({
		 onDragEnter : function() {
		 $(this).addClass('over');
		 },
		 onDragLeave : function() {
		
		 $(this).removeClass('over');
		 },
		 onDrop : function(e, source) {
		 $(this).removeClass('over');
		 if ($(source).hasClass('addAssigned_1')) {
		 $(this).append(source);
		 } else {
		 var c = $(source).addClass('addAssigned_1');
		 $(this).append(c);
		 c.draggable({
		 revert : true
		 });
		 }
		 }
		 }); */
		//
		$('#addScheduleWindow').find('#courseName').textbox({
			onClickButton : function() {
				//	alert("选择课程!");
				$('#selecctCoursePlainOfManualCourseSchedule').dialog('open');
				//选中专业和防线然后js点击按钮
				$('#selecctCoursePlainOfManualCourseSchedule').find('#majorSelectOfCoursePlan').combobox('setValue',
						$('#manualScheduleCourse').find('#majorOfManualSchedule').combobox('getValue'));
				
				
				$('#selecctCoursePlainOfManualCourseSchedule').find('#fieldSelectOfCoursePlan').combobox({
					url : "sch/getMajorFieldJsonByMajorId.do?majorId="+ $('#manualScheduleCourse').find('#majorOfManualSchedule').combobox('getValue'),
					valueField : 'id',
					textField : 'name',
					onLoadSuccess: function() {
						$('#selecctCoursePlainOfManualCourseSchedule').find('#fieldSelectOfCoursePlan').combobox('setValue',
								$('#manualScheduleCourse').find('#fieldOfManualSchedule').combobox('getValue'));
						findCoursePlanOfCourseSchedule('#selecctCoursePlainOfManualCourseSchedule');
					}
				});
				
				
				
			}
		});

		var eachCourse = $('#courseTableOfManuelScheduleCourse .drop');
		eachCourse.each(function() {
			/* $(this).bind('click', function() {
				$('#eachCourseDialog').dialog('open');
			}); */
			$(this).bind('dblclick', editScheduleCourse);
		});

		/*专业和方向的二级联动 */
		$('#manualScheduleCourse')
				.find('#majorOfManualSchedule')
				.combobox(
						{
							onSelect : function() {
								$('#manualScheduleCourse').find(
										'#gradeOfSchedule').combobox(
										'setValue', '请选择');
								$('#manualScheduleCourse').find('#classOfManualSchedule')
										.combobox('loadData', {});
								$('#manualScheduleCourse').find('#classOfManualSchedule')
										.combobox('setValue', '请选择');

								var majorId = $('#manualScheduleCourse').find(
										'#majorOfManualSchedule').combobox('getValue');
					//			alert(majorId);
								if (majorId != '请选择' && majorId != null) {
									$('#manualScheduleCourse')
											.find('#fieldOfManualSchedule')
											.combobox(
													{
														url : "${contextPath}/stu/getMajorFieldInfo.do?majorId="
																+ majorId,
														valueField : 'id',
														textField : 'name',
														value : "请选择"
													});
								} else {
									$('#manualScheduleCourse').find('#fieldOfManualSchedule')
											.combobox('loadData', {});
									$('#manualScheduleCourse').find('#fieldOfManualSchedule')
											.combobox('setValue', '请选择');
									$('#manualScheduleCourse').find(
											'#gradeOfSchedule').combobox(
											'setValue', '请选择');
									$('#manualScheduleCourse').find('#classOfManualSchedule')
											.combobox('loadData', {});
									$('#manualScheduleCourse').find('#classOfManualSchedule')
											.combobox('setValue', '请选择');
								}
							}
						});
		/*专业方向和年级的二级联动*/
		$('#manualScheduleCourse').find('#fieldOfManualSchedule').combobox(
				{
					onSelect : function() {

						$('#manualScheduleCourse').find('#gradeOfSchedule')
								.combobox('setValue', '请选择');
					}
				});

		/*年级和班级的二级联动*/
		$('#manualScheduleCourse')
				.find('#gradeOfSchedule')
				.combobox(
						{
							onSelect : function() {
								var gradeId = $('#manualScheduleCourse').find(
										'#gradeOfSchedule')
										.combobox('getValue');
								var fieldId = $('#manualScheduleCourse').find(
										'#fieldOfManualSchedule').combobox('getValue');
								if (gradeId != '请选择' && gradeId != null) {
									$('#manualScheduleCourse')
											.find('#classOfManualSchedule')
											.combobox(
													{
														url : '${contextPath}/edu/getClassByGradeIdAndFieldId.do?gradeId='
																+ gradeId
																+ "&fieldId="
																+ fieldId,
														valueField : 'id',
														textField : 'name',
														editable : false,
														value : "请选择"
													//			onLoadSuccess : function() {
													//				var data = $('#manualScheduleCourse').find('#class').combobox('getData');
													//				console.log(data);
													//			}
													});
								} else {
									$('#manualScheduleCourse').find('#classOfManualSchedule')
											.combobox('loadData', {});
									$('#manualScheduleCourse').find('#classOfManualSchedule')
											.combobox('setValue', '请选择');
								}
							}
						});

	});

	/*
	//设置每一节课
	function setEachCourse(dialog){
		var weeks_1 = $(dialog).find('#weeks_1').val();
		var weeks_2 = $(dialog).find('#weeks_2').val();
		var weekIds = $(dialog).find('#weekIds').val();
		var courseName = $(dialog).find('#courseName').val();
		var teacherName = $(dialog).find('#teacherName').val();
		var major = $(dialog).find('#majorId').combobox('getValue');
		var fieldId = $(dialog).find('#fieldId').combobox('getValue');
		var buildingId = $(dialog).find('#buildingId').combobox('getValue');
		var classId = $(dialog).find('#classId').combobox('getValue');
		var courseType = $(dialog).find('#courseType').combobox('getValue');
		var examineType = $(dialog).find('#examineType').comboobx('getValue');
		var credit = $(dialog).find('#credit').val();
		var hours = $(dialog).find('#hours').val();
		
	}
	 */
	/*手动添加 课表 */
	function addCourseScheduel() {

	}

	//根据majorId和fieldId获取课程信息
	function findCourseByMajorIdAndFieldId(form) {
		if ($(form).find('#classOfManualSchedule').combobox('getValue') == '请选择') {
			$.messager.alert("操作提示", "请先选择需要排课的班级!", "warning");
		//	return 0;
		} else {
		$(form).find('#selectedClass').text(
				$(form).find('#majorOfManualSchedule').combobox('getText') + " "
						+ $(form).find('#fieldOfManualSchedule').combobox('getText') + " "
						+ $(form).find('#gradeOfSchedule').combobox('getText')
						+ " " + $(form).find('#classOfManualSchedule').combobox('getText'));
		//设置班级id
		$(form).find('#classId').text(
				$(form).find('#classOfManualSchedule').combobox('getValue'));
		//
		//	 var majorId = $(form).find('#major').combobox('getValue');
		//	 var fieldId = $(form).find('#field').combobox('getValue');
		var classId = $(form).find('#classOfManualSchedule').combobox('getValue');
		//	 alert(classId);
		if (classId != '请选择') {
			$
					.post(
							'edu/findCourseByClassId.do',
							{
								classId : classId
							},
							function(data) {
								//请求成功的话，先清空left和courseTable
								var drops = $('#manualScheduleCourse td.drop .item_1');
								var courses = $('.left_1 .item_1');
								//		 alert("items: " + drops.length);
								for (var i = 0; i < drops.length; ++i)
									drops[i].remove();

								var obj = eval('(' + data + ')');
								data = eval('(' + data + ')');
						//		console.log(data);
						//		console.log(data.length);
								//将所有课程信息放到left里面
								for (var i = 0; i < data.length; ++i) {

									var div = $("<div></div>").addClass(
											"item_1");
									//排课id
									div
											.append($(
													"<div id='courseScheduleId' style='display:none'>")
													.text(
															data[i].courseScheduleId));
									//课程计划id
									div
											.append($(
													"<div id='coursePlanId' style='display:none'>")
													.text(data[i].coursePlanId));
									//授课id
									div
											.append($(
													"<div id='teachCourseId' style='display:none'>")
													.text(data[i].teachCourseId));

									div.append($("<div id='courseName'></div>")
											.text(data[i].name));
									div
											.append($(
													"<div id='weekDayInTable' style='display:none'></div>")
													.text(data[i].weekDay));
									div
											.append($(
													"<div id='sectionsInTable' style='display:none'></div>")
													.text(data[i].sectionType));
									div
											.append($(
													"<div id='weeksInTable' style='display:none'></div>")
													.text(data[i].weeks));
									div
											.append($(
													"<div id='weekIdsInTable' style='display:none'></div>")
													.text(data[i].weekIds));
									div
											.append($(
													"<div id='classesInTable' style='display:none'></div>")
													.text(data[i].classes));
									div
											.append($(
													"<div id='majorIdInTable' style='display:none'></div>")
													.text(data[i].majorId));
									div
											.append($(
													"<div id='fieldIdInTable' style='display:none'></div>")
													.text(data[i].fieldId));
									div
											.append($(
													"<div id='courseCodeInTable' style='display:none'></div>")
													.text(data[i].courseCode));
									div
											.append($(
													"<div id='teacherId' style='display:none'></div>")
													.text(data[i].teacherId));
									div.append($(
											"<div id='teaNameInTable'></div>")
											.text(data[i].teaName));
									//上课地点
									div
											.append($(
													"<div id='addressOfCourse'></div>")
													.text(
															data[i].building
																	+ ' '
																	+ data[i].classRoom));
									div
											.append($(
													"<div id='campusId' style='display:none'></div>")
													.text(data[i].campusId));
									div
											.append($(
													"<div id='buildingId' style='display:none'></div>")
													.text(data[i].buildingId));
									div
											.append($(
													"<div id='classRoomId' style='display:none'></div>")
													.text(data[i].classRoomId));
									//课程类型、考核方式、学分、学时
									div
											.append($(
													"<div id='courseType' style='display:none'></div>")
													.text(data[i].courseType));
									div
											.append($(
													"<div id='examineType' style='display:none'></div>")
													.text(data[i].examineType));
									div
											.append($(
													"<div id='credit' style='display:none'></div>")
													.text(data[i].credit));
									div
											.append($(
													"<div id='hours' style='display:none'></div>")
													.text(data[i].hours));

									//周次的插入顺序
									var first = data[i].weeks.split('-');
									//	alert(first[0]);
									var second = data[i].weekIds.split(',');
									//	alert(second[0]);
									//	alert('first: ' + first[0] + ", second: " + second[0] + "first < second?:" + (parseInt(first[0]) < parseInt(second[0])));
									if (parseInt(first[0]) < parseInt(second[0])) {
										div.append($("<div></div>").text(
												"上课周: " + data[i].weeks));
										div.append($("<div></div>").text(
												data[i].weekIds));
									} else {
										div.append($("<div></div>").text(
												"上课周: " + data[i].weekIds));
										div.append($("<div></div>").text(
												data[i].weeks));
									}
									//	div.append($("<div></div>").text("上课周: " + obj.rows[i].weeks));
									//	div.append($("<div></div>").text(obj.rows[i].weekIds));

							//		console.log(div.html())
									var td = $('<td></td>');//document.createElement('td');
									td.append(div);
									var tr = $('<tr></tr>')//document.createElement('tr');
									tr.append(td);
									$('#manualScheduleCourse').find(
											'.left_1 table').append(tr);
								}
								drops = $('#courseTableOfManuelScheduleCourse .drop');
								courses = $('.left_1 .item_1');
								courses.each(
										function () {
									$(this).bind('dblclick', function(){
								//		alert(parseInt($(this).find('#courseScheduleId').text()));
										$('#addScheduleWindow').find(
										'#courseScheduleId').textbox(
											'setValue', parseInt($(this).find('#courseScheduleId').text()));
										})
									})
								//	 alert(drops.length);
								//	 alert("课程数量: " + courses.length);
								//,再放到table里
								var sectionCount = 0;
								for (var i = 0; i < courses.length; ++i) {

									sectionCount = data[i].sectionType % 10;
									/* console.log(data[i].name + " 在第 "
											+ sectionCount + " 行, 第 "
											+ data[i].weekDay % 10 + "列."); */
									drops[data[i].weekDay % 10 + 5
											* (sectionCount - 1) - 1]
											.appendChild(courses[i]);
								}
							})
		} else {
			$.messager.alert("操作提示", "请先选择需要排课的班级", "warning");
		}
	}
	}

	//双击课程格子
	function editScheduleCourse() {

		//判断是否选中排课的班级
		if ($("#manualScheduleCourse").find('#classId').text() == '') {
			$.messager.alert("操作提示", "请先选中需要排课的班级!", "warning");
			return 0;
		}
		
		/**
		 *专业和方向的二级联动(课程计划选择dialog)
		 **/
		/*专业和方向的二级联动(课程计划选择dialog) */
		$('#selecctCoursePlainOfManualCourseSchedule')
				.find('#majorSelectOfCoursePlan')
				.combobox(
						{
							onSelect : function() {

								var majorId = $(
										'#selecctCoursePlainOfManualCourseSchedule')
										.find('#majorSelectOfCoursePlan')
										.combobox('getValue');
								if (majorId != '请选择' && majorId != null) {
									$(
											'#selecctCoursePlainOfManualCourseSchedule')
											.find('#fieldSelectOfCoursePlan')
											.combobox(
													{
														url : "${contextPath}/stu/getMajorFieldInfo.do?majorId="
																+ majorId,
														valueField : 'id',
														textField : 'name',
														value : "请选择"
													});
								} else {
									$(
											'#selecctCoursePlainOfManualCourseSchedule')
											.find('#fieldSelectOfCoursePlan')
											.combobox('loadData', {});
									$(
											'#selecctCoursePlainOfManualCourseSchedule')
											.find('#fieldSelectOfCoursePlan')
											.combobox('setValue', '请选择');
								}
							}
						});
		/**
		 *  教室三级联动
		 **/
		//教学楼二级联动
		$('#addScheduleWindow')
				.find('#campusId1')
				.combobox(
						{
							onSelect : function() {
								//	alert('shit');
								var campusId = $('#addScheduleWindow').find(
										'#campusId1').combobox('getValue');
								//	console.log(majorId);
								if (campusId != '请选择' && campusId != null) {
									//	alert('go');
									$('#addScheduleWindow')
											.find('#buildingId1')
											.combobox(
													{
														url : "sch/getBuildingByCampusId.do?id="
																+ campusId,
														valueField : 'id',
														textField : 'name',
														value : "请选择"
													});
								} else {
									$('#addScheduleWindow')
											.find('#buildingId1').combobox(
													'loadData', {});
									$('#addScheduleWindow')
											.find('#buildingId1').combobox(
													'setValue', '请选择');
								}
								$('#addScheduleWindow').find('#classId1')
										.combobox('loadData', {});
								$('#addScheduleWindow').find('#classId1')
										.combobox('setValue', '请选择');
							}
						})

		//	alert($('#courseOfTeacherWindow').find('#campusId').combobox('getValue'));
		/////////////////////////////////
		//教室二级联动
		$('#addScheduleWindow').find('#buildingId1').combobox(
				{
					onSelect : function() {
						//	alert('shit');
						var building = $('#addScheduleWindow').find(
								'#buildingId1').combobox('getValue');
						//	console.log(majorId);
						if (building != '请选择' && building != null) {
							//		alert('go');
							$('#addScheduleWindow').find('#classId1').combobox(
									{
										url : "sch/getClassByBuildingId.do?id="
												+ building,
										valueField : 'id',
										textField : 'name',
										value : "请选择"
									});
						} else {
							$('#addScheduleWindow').find('#classId1').combobox(
									'loadData', {});
							$('#addScheduleWindow').find('#classId1').combobox(
									'setValue', '请选择');
						}
					}
				})
		/**       上面是教室的三级联动            **/
		var th = $(this);
		var drops = $('#courseTableOfManuelScheduleCourse').find('.drop');
		// alert(drops.length);
		var weekDay = 0;
		var section = 0;
		for (var i = 0; i < drops.length; ++i) {

			// console.log($(this)[0]);
			// console.log(drops[0]);
			if ($(this)[0] == drops[i]) {
				//		 alert(i);
				i += 1;
				section = Math.ceil(i / 5);
				if (i % 5 != 0) {
					weekDay = i % 5;
				} else {
					weekDay = 5;
				}
				break;
			}
		}
		//	 alert("星期 " + weekDay + ", 第 " + section + " 节" );
		$.messager.defaults = {
			ok : "添加课程",
			cancel : "删除课程"
		}
		$.messager
				.confirm(
						"操作提示",
						"请选择操作:",
						function(b) {

							if (b) {
								//	 alert("添加课程");
								//选中星期和节次,设置scheduleId
								weekDay = parseInt($('#addScheduleWindow')
										.find('#weekDayOfSchedule').combobox(
												'getData')[1].value)
										- 1 + weekDay;
								section = parseInt($('#addScheduleWindow')
										.find('#sectionsOfSchedule').combobox(
												'getData')[1].value)
										- 1 + section;
								//	 alert('weekDay: ' + weekDay + ", section: " + section);
								$('#addScheduleWindow').find(
										'#weekDayOfSchedule').combobox(
										'setValue', weekDay);
								$('#addScheduleWindow').find(
										'#sectionsOfSchedule').combobox(
										'setValue', section);
								console.log(th.find('.item_1').length);
								$('#addScheduleWindow').window('open');
							} else {
								//初始化删除课程窗口的combobox
								$('#deleteScheduleWindow').find(
										"#courseOfDelete").combobox('loadData',
										{});
								$('#deleteScheduleWindow').find(
										"#courseOfDelete").combobox('setValue',
										"请选择");
								//	 alert("删除课程");
								var item_1s = th.find('.item_1');
								//	 console.log(th);
								jsonArray = [];
								//	 alert(item_1s.length);
								for (var i = 0; i < item_1s.length; ++i) {

									var course = {};
									//		 alert(item_1s[i]);
					//				console.log(item_1s[i].innerHTML);
						//			console.log($('#courseTableOfManuelScheduleCourse').find('.drop')[0]);
								//	alert(item_1s[i].innerHTML.match(/courseScheduleId[^~]*?>([1-9]+?)([\r\n]*?)<\/div>/));
									course.value = item_1s[i].innerHTML
											.match(/courseScheduleId[^~]*?>([0-9]+)<\/div>/)[1];
									
									/* 		 alert("id : " + course.value);
											 alert(item_1s[i].innerHTML
														.match(/courseScheduleId[^~]*?>([0-9]+)<\/div>/)); */
									//	 alert(item_1s[i].textContent)
									course.text = item_1s[i].innerHTML
											.match(/courseName[^~]*?>([\s\S]+?)<\/div>/)[1];
										//	 alert("name : " + course.text);
									jsonArray[i] = course;
								}
								
				//				console.log(jsonArray);
								if (jsonArray.length != 0) {
									$('#deleteScheduleWindow').find(
											"#courseOfDelete").combobox(
											'loadData', jsonArray);
									$('#deleteScheduleWindow').window('open');
								} else {
									$.messager.alert("操作提示", "该时间段无课程，不需要删除!",
											"warning");
								}
							}
						})
		$.messager.defaults = {
			ok : "确定",
			cancel : "取消"
		}
	}

	//确认删除排课表的课程
	function confirmDeleteCourseSchedule(form) {

		var scheduleId = $(form).find('#courseOfDelete').combobox('getValue');
	//	alert("排课表id: " + scheduleId);
		if (scheduleId == '请选择') {
			$.messager.alert("操作提示", "请先选择需要从该课程表中删除的课程!", "warning");
		} else {
			//删除
			$.post('edu/toDeleteCourseScheduleByScheduleIdAndCourseSeq.do', {
				scheduleId : scheduleId
			}, function(data) {
		//		alert(data);
				data = eval('(' + data + ')');
				if (data.result == 1) {
					$.messager.alert("操作提示", "课程删除成功!", "info");
				} else {
					$.messager.alert("操作提示", "课程删除失败!<br>请稍后再尝试.", "info");
				}
				$('#deleteScheduleWindow').window('close');
				findCourseByMajorIdAndFieldId('#manualScheduleCourse');
			});
		}
	}

	//查询课程计划
	function findCoursePlanOfCourseSchedule(form) {

		var majorId = $(form).find('#majorSelectOfCoursePlan').combobox(
				'getValue');
		var fieldId = $(form).find('#fieldSelectOfCoursePlan').combobox(
				'getValue');
		var courseName = $(form).find('#courseName').val();
		var className = $('#scheduleCourseForm').find('#classOfManualSchedule').combobox('getText');
		if (majorId == '请选择')
			majorId = 0;
		if (fieldId == '请选择')
			fieldId = 0;
		var param = {
			majorId : majorId,
			fieldId : fieldId,
			courseName : courseName,
			className : className
		}
	//	console.log(param);
		$(form).find('#coursePlanOfManualCourseSchedule').datagrid({
			url : "${contextPath }/edu/findCoursePlanOfCourseSchedule.do",
			queryParams : param
		});
	}

	//点击选择按钮
	function clickSelectCoursePlan(form) {

		var row = $(form).find('#coursePlanOfManualCourseSchedule').datagrid(
				'getSelected');
		//	 alert(row);
		console.log(row);
		if (row == null) {
			$.messager.alert("操作提示", "请选选择一门课程信息!", "warning");
		} else {

			$('#addScheduleWindow').find('#teachCourseId').textbox('setValue',
					row.teachCourseId);
			$('#addScheduleWindow').find('#courseName').textbox('setValue',
					row.courseName);

			$(form).dialog('close');
			//初始化
			$(form).find('#majorSelectOfCoursePlan')
					.combobox('setValue', '请选择')
			$(form).find('#fieldSelectOfCoursePlan').combobox('loadData', {})
			$(form).find('#fieldSelectOfCoursePlan')
					.combobox('setValue', '请选择')
			$(form).find('#coursePlanOfManualCourseSchedule').datagrid(
					'loadData', {
						total : 0,
						rows : []
					});
		}
	}

	//确定添加排课记录
	function confirmAddCourseSchedule(form) {

		//开启表单验证
		$(form).form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}

		//参数验证
		//课程
		if ($('#addScheduleWindow').find('#teachCourseId').textbox('getValue') == '' && 
				$('#addScheduleWindow').find('#courseName').textbox('getValue') == '') {
			$.messager.alert("操作提示", "课程不能为空!请选择!", "warning");
			return 0;
		} 
		//周次
		if (($('#addScheduleWindow').find('#weeks_1').val() != '' && isNaN(parseInt($('#addScheduleWindow').find('#weeks_1').val())))
				|| 
				($('#addScheduleWindow').find('#weeks_2') 
				.val() != '' && isNaN(parseInt($('#addScheduleWindow').find('#weeks_2') 
						.val()))))
		{
			$.messager.alert("操作提示", "上课周次只能输入整数!", "warning");
		}
		
		else {
			var str = $(form).find('#weekIds').val().split(/[,，]/);
			//		alert(str.length);
			var flag = true;
			for (var i = 0; i < str.length; ++i) {

				if (isNaN(str[i])) {
					$.messager.alert("操作提示", "上课周次只能输入整数!", "warning");
					flag = false;
					return 0;
				}
			}
			//周次（连续和间断）必须填写其中一项
			if ((($('#addScheduleWindow').find('#weeks_1').val() == '' || $('#addScheduleWindow').find('#weeks_2').val() == ''))
					&& $(form).find('#weekIds').val() == '') {
				
				$.messager.alert("操作提示", "上课(连续或间断)周次必须填写一项!", "warning");
				flag = false;
				return 0;
			}
			//参数没错则继续执行 
			var classId = parseInt($("#manualScheduleCourse").find('#classId').text());
	//		alert("班级id:" + classId);
			var weeks = '';
			if ($('#addScheduleWindow').find('#weeks_1').val() == '' || $('#addScheduleWindow').find('#weeks_2').val() == '') {
				;
			} else {
				weeks = $(form).find('#weeks_1').val() + "-" + $(form).find('#weeks_2').val();
			}
			var param = {
				classId : classId,
				/***********************/
				courseScheduleId : $(form).find('#courseScheduleId').textbox('getValue'),
				teachCourseId : $(form).find('#teachCourseId').textbox(
						'getValue'),
				classRoomId : $(form).find('#classId1').combobox('getValue'),
				weeks : weeks,
				weekIds : $(form).find('#weekIds').val(),
				weekDay : $(form).find('#weekDayOfSchedule').combobox(
						'getValue'),
				sectionType : $(form).find('#sectionsOfSchedule').combobox(
						'getValue')
			};

	//		console.log(param);
			$.post('edu/toAddCourseScheduleByManual.do', param, function(data) {

				//各种冲突(1.与本班级的其他课程有冲突, 2.该任课老师在该时间段有课,3.重复课程)
				data = eval('(' + data + ')')
				if (data.result == -10) {
					$.messager.alert("操作提示", "排课记录添加成功!", "info")
				} else if (data.result == -1){
					$.messager.alert("操作提示", "排课记录添加失败!<br>与本班级的课程有冲突!请核对.", "warning");
				} else if (data.result == -2){
					$.messager.alert("操作提示", "排课记录添加失败!<br>该课程已存在,如需更改信息，请到【手动调课】", "warning");
				} else if (data.result >= 1) {
					$.messager.alert("操作提示", "排课记录添加失败!<br>与其他班级的课程有冲突(数量:" + data.result + ")!请核对.", "warning");
				} else if(data.result == -100){
					$.messager.alert("操作提示", "排课记录添加失败!<br>请稍后再尝试!", "warning");
				}
				//初始化window
				$(form).find('#teachCourseId').textbox('setValue', '');
				$(form).find('#classId1').combobox('setValue', "请选择");
				$(form).find('#weeks_1').val("");
				$(form).find('#weeks_2').val("");
				$(form).find('#weekIds').textbox("setValue", "");
				$(form).find('#courseName').textbox('setValue', '');
				//更新页面
				findCourseByMajorIdAndFieldId('#manualScheduleCourse');
				$(form).window('close');
			})
		}
	}
</script>