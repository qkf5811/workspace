<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css" scoped>
.left {
	width: 120px;
	float: left;
}

.left table {
	background: #E0ECFF;
	text-align:center;
}

.left td {
	background: #eee;
	width: 100px;
	height: 80px;
}

.courseTable {
	margin: 20px auto;
	width: 100%;
}

.courseTable table {
	background: #E0ECFF;
	width: 100%;
}

.courseTable td {
	background: #fafafa;
	text-align: center;
	padding: 2px;
	width: 50px;
}

.courseTable td {
	background: #E0ECFF;
	margin: 0px auto;
}

.courseTable td.title {
	font-family:'微软雅黑';
	font-size: 18px;
}

.courseTable td.time {
	font-family:'微软雅黑';
	font-size: 18px;
}

.courseTable td.release {
	font-family:'微软雅黑';
	font-size: 18px;
}

.courseTable td.drop { 
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 30px;
}

.courseTable td.drop .item:hover {
	background: pink;
	cursor: pointer;
	border-radius: 5px;
}

.courseTable td.over {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 80px;
}

.left .item {
	text-align: center;
	border: 1px solid #499B33;
	background: #fafafa;
	width: 160px;
	height: 80px;
}

.addAssigned {
	border: 1px solid #BC2A4D;
	text-align: center;
	background: #fafafa;
	width: 173px;
	height: 80px;
}
</style>
<div id="manualAdjustCourse" style="margin: 10px">
	<!-- 	<div style="margin: 10px">
		<span>课程代号:</span>
		<input class="easyui-textbox" id="code" style="width: 120px; height: 30px">&nbsp;&nbsp;
		<span>课程名称:</span>
		<input class="easyui-textbox" id="name" style="width: 120px; height: 30px">&nbsp;&nbsp; -->
	<div style="margin:10px">
		<span>教师编号:</span> <input class="easyui-textbox" id="teaCode"
			style="width: 120px; height: 30px">&nbsp;&nbsp; 
		<span>任课老师:</span> <input class="easyui-textbox" id="teaName"
			style="width: 120px; height: 30px">&nbsp;&nbsp;<a
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="plain:true, iconCls:'icon-search'"
			onclick="getTeacherCourseTableInTerm('#manualAdjustCourse')">查询课程</a>
	</div>
	<!-- 	</div>
	<table id="courseTable" class="easyui-datagrid" style=""
		 parination="true" rownumbers="true" singleSelect="true"
		 data-option="pageSize:10" url="${contextPath}/edu/findCourseByConditionsOfManualAdjustCourse.do?code=&name=&teaname="
		 toolbar="#manualAdjustToolbar">
		<thead>
			<tr>
				<th field="code" align="center" width="100px">课程代号</th>
				<th field="name" align="center" width="120px">课程名称</th>
				<th field="teaName" align="center" width="120px">任课教师</th>
				<th field="majorIdStr" align="center" width="120px">所属专业</th>
				<th field="fieldIdStr" align="center" width="120px">所属专业方向</th>
				<th field="classes" align="center" width="200px">上课班级</th>
				<th field="courseType" align="center" width="80px">课程类型</th>
				<th field="examineType" align="center" width="80px">考核方式</th>
				<th field="credit" align="center" width="80px">学分</th>
				<th field="remark" align="center" width="200px">课程备注</th>
			</tr>
		</thead>
	</table>
	
	<div id="manualAdjustToolbar">
		<a class="easyui-linkbutton" data-options="plain:true" iconCls="icon-add">测试按钮</a>
		<a class="easyui-linkbutton" data-options="plain:true" iconCls="icon-search">测试按钮</a>
		<a class="easyui-linkbutton" data-options="plain:true" iconCls="icon-remove">测试按钮</a>
	</div>
	 -->
	<div style="margin: 5px">
		<h2 style="text-align:center; font-size: 30px;font-family:'微软雅黑'">江门幼师教师课程表</h2>
		<!-- 教师信息 -->
		<div style="text-align:center;">
			<strong style="font-size: 16px">姓名:</strong>
			<span style="font-size: 16px" id="teacherName"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<strong style="font-size: 16px">教师编号:</strong>
			<span style="font-size: 16px" id="teacherCode"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<strong style="font-size: 16px">所在部门:</strong>
			<span style="font-size: 16px" id="departmentIdStr"></span>
		</div>
		<!-- 所有课程 -->
		<div class="left" style="display:none">
			<table>
		 		
			</table>
		</div>
		<!-- 教师课程表 -->
		<div class="courseTable" id="courseTable" onselectstart="javascript:return false;" style="-moz-user-select:none;">
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
	
<!--  	<div style="margin:25x; text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">重置</a>
	</div>-->
	
	<div class="easyui-dialog" title="选择教师" iconCls="icon-search" id="teaInfoDialog"
		 style="width: 610px;height: auto" top="200px"
		 data-options="resizable:false,modal:true, closed:true">
		<table class="easyui-datagrid" width="auto" id="teaInfoOfManualAdjustCourse"
			   pagination="true" rownumbers="true" singleSelect="true"
			   data-option="pageSize:10">
			<thead>
				<tr>
					<th field="idOfTeacher" hidden="true"></th>
					<th field="code" width="100px" align="center">工号</th>
					<th field="nameOfTeacher" width="100px" align="center">姓名</th>
					<th field="sexTypeStr" align="center" width="60px">性别</th>
					<th field="departmentIdStr" align="center" width="100px">部门</th>
					<th field="majorIdStr" width="100px" align="center">所属专业</th>
					<th field="nowPosition" width="100px" align="center">当前职位</th>
				</tr>
			</thead>
		</table>
		<div style="float:right;border:1px solid gray;margin-top:10px" iconCls="icon-ok" class="easyui-linkbutton"
			 onclick="findCourseByConditionsOfManualAdjustCourse()">选择</div>
	</div>
	
	<div id="courseOfTeacherWindow" class="easyui-dialog"
		  title="编辑课程" resizable="false" onselectstart="javascript:return false;"
		  data-options="modal:true,iconCls:'icon-edit',closed:true" top="50px"
		  style="width:900px;height:540px;padding:5px;-moz-user-select:none;">
		<div style="margin-right: 25px;width: 80px;height: 25px;z-index:200;position:absolute">
			<a id="button" href="javascript:void(0)" style="width:100%;letter-spacing: 5px" iconCls="icon-reload" class="easyui-linkbutton" toggle="true" onclick="editAndUnEdit()">编辑</a>
		</div>
		<div id="zhezhao" style="background: gray;opacity:0.0;-moz-opacity:0.0;filter:alpha(opacity=0);width:889px; height: 504px;top:28px;left:5px;position:absolute;z-index:100">
		
		</div>
		<table style="vertical-align:center;margin: 45px auto">
			<tr style="display:none">
				<td>排课id:</td>
				<td><input class="easyui-validate textbox" id="courseScheduleId"/></td>
				<td>课程计划id:</td>
				<td><input class="easyui-validate textbox" id="coursePlanId"/></td>
				<td>教师授课id:</td>
				<td><input class="easyui-validate textbox" id="teachCourseId"/></td>
			</tr>
			<tr style="">
				<td><strong>上课时间:</strong></td>
				<td>
					<div>
						<span>星期:</span>
						<select id="weekDay" name="weekDay" class="easyui-combobox" style="width: 180px;" editable="false"
							    validtype="selectRequired['weekDay']"
							    data-options="required: true,panelHeight:'auto',novalidate:true,missingMessage:'该处未选择'">
							<option value="0">请选择</option>
							<c:forEach items="${weekDay }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<span>节次:</span>
				<!-- 		<input type="checkbox">1
						<input type="checkbox">2
						<input type="checkbox">3
						<input type="checkbox">4
						<input type="checkbox">5
						<input type="checkbox">6
						<input type="checkbox">7 -->
						<select id="sections" name="sections" class="easyui-combobox" style="width: 180px" editable="false" 
								validtype="selectRequired['sections']"
								data-options="required:true,panelHeight:'auto', missingMessage:'该处未选择',novalidate:true">
							<option value="0">请选择</option>
							<c:forEach items="${sections }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div id="weeks" style="margin-right:75px">
						<span>周次:</span>
						<span>连续周次:</span>
						<input class="easyui-validatebox textbox" style="width: 30px;height: 25px" id="weeks_1"
							   data-options="required:false, missingMessager:'该处未填写!',novalidate:true"> - 
						<input class="easyui-validatebox textbox" style="width: 30px;height: 25px" id="weeks_2"
							   data-options="required:false, missingMessager:'该处未填写!',novalidate:true">&nbsp;&nbsp;&nbsp;
						<span>零散周次:</span>
						<input class="easyui-textbox" id="weekIds"  style="width:120px;height: 25px"
							   data-options="prompt:'请用逗号(,)分隔开'">
					</div>
				</td>
			</tr>
			<tr>
				<td><strong>上课班级:</strong></td>
				<td><input class="easyui-validatebox textbox"  style="width: 240px;height: 25px" id="classes"
						   data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><strong>所属专业:</strong></td>
				<td>
				<select class="easyui-combobox" style="width: 180px" editable="false" id="majorIdOfManualAdjuseCourse" name="majorIdOfManualAdjuseCourse"
						validtype="selectRequired['majorIdOfManualAdjuseCourse']"
						data-options="panelHeight:'auto', required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="请选择">请选择</option>
					<c:forEach items="${majorId }" var="item">
								<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select>
				<select class="easyui-combobox" style="width: 180px" editable="false" id="fieldId" name="fieldId"
						validtype="selectRequired['fieldId']"
						data-options="panelHeight:'auto', required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="0">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><STRONG>上课地点:</strong></td>
				<td>
				<select class="easyui-combobox" style="width: 150px;" editable="false" id="campusId" name="campusId"
						validtype="selectRequired['campusId']"
						data-options="required: true,panelHeight:'auto',novalidate:true,missingMessage:'该处未选择'">
					<option value="请选择">请选择</option>
					<c:forEach items="${campusId }" var="item">
								<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select>
				<select class="easyui-combobox" style="width: 150px" editable="false" id="buildingId" name="buildingId"
						validtype="selectRequired['buildingId']"
						data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="请选择">请选择</option>
				</select>
				<select class="easyui-combobox" style="width: 150px" editable="false" id="classId" name="classId"
						validtype="selectRequired['classId']"
						data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="0">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><strong>课程编号:</strong></td>
				<td><input class='easyui-validatebox textbox' id="code" style="width: 120px;height: 25px;background:rgb(235, 235, 228)"
						   readonly disabled="true"
						   data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr style="display:none">
				<td>授课老师id:</td>
				<td><input class="easyui-textbox"  editable="false" style="width: 180px;height: 25px" id="teacherId"
					 	   ></td>
			</tr>
			<tr style="">
				<td><strong>授课老师:</strong></td>
				<td><input class="easyui-textbox"  editable="false" disabled="true" style="width: 120px;height: 25px;background:rgb(235, 235, 228)"
						   id="teacherName"
					 	   ></td>
					 	   <!-- data-options="buttonText:'选择',buttonIcon:'icon-search',prompt:'请选择教师'" -->
			</tr>
			<tr>
				<td><strong>课程名称:</strong></td>
				<td><input class="easyui-validatebox textbox"  id="courseName" style="width: 120px;height: 25px;background:rgb(235, 235, 228)"
						   readonly disabled="true"
						   data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			
			<tr>
				<td><strong>课程类型:</strong></td>
				<td><select class="easyui-combobox" style="width: 150px" editable="false" id="courseType" name="courseType"
							validtype="selectRequired['courseType']" disabled="true"
							data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${courseType }" var="item">
								<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><strong>考核方式:</strong></td>
				<td><select class="easyui-combobox" style="width: 150px" editable="false" id="examineType"  name="examineType"
							validtype="selectRequired['examineType']" disabled="true"
							data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择', novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${examineType }" var="item">
								<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><strong style="float:right;">学分:</strong></td>
				<td><input class="easyui-validatebox textbox"  id="credit" style="width: 120px;height: 25px;background:rgb(235, 235, 228)"
							readonly disabled="true"
						   data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><strong style="float:right;">学时:</strong></td>
				<td><input class="easyui-validatebox textbox"  id="hours" style="width: 120px;height: 25px;background:rgb(235, 235, 228)"
							readonly disabled="true"
						   data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
		</table>
		<div style="text-align:center;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="updateCourseOfTeacherInTerm('#courseOfTeacherWindow')"
			   id="confirmEdit" style="visibility:hidden">确认修改</a>
		</div>
	</div>
</div>

<script>
	$(function() {
		$('.left .item').draggable('disable');
		$('.left .item').draggable({
			revert : true,
			proxy : 'clone'
		});
		$('.courseTable td.drop').droppable('disable');
		$('.courseTable td.drop').droppable({
			onDragEnter : function() {
				$(this).addClass('over');
			},
			onDragLeave : function() {
				
				$(this).removeClass('over');
			},
			onDrop : function(e, source) {
				$(this).removeClass('over');
		//		if ($(source).hasClass('addAssigned')) {
					$(this).append(source);
		//		} else {
					var c = $(source).addClass('addAssigned');
					$(this).append(c);
					c.draggable({
						revert : true
					});
			//	}
			}
		});
		//为每个课程添加点击事件
		var drops = $('.courseTable .drop');
		var courses = $('.left .item');
		
		var c = courses.addClass('addAssigned');
		courses.append(c);
		
		//选择教师按钮
		$('#courseOfTeacherWindow').find('#teacherName').textbox({
			onClickButton: function() {
				alert('asdf');
			}
		});
		/**
		*  教室三级联动
		**/
		//教学楼二级联动
		$('#courseOfTeacherWindow').find('#campusId')
		.combobox(
				{
					onSelect : function() {
						//	alert('shit');
						var campusId = $('#courseOfTeacherWindow').find('#campusId').combobox('getValue');
					//	console.log(majorId);
						if (campusId != '请选择' && campusId != null) {
						//	alert('go');
							$('#courseOfTeacherWindow').find('#buildingId').combobox(
											{
												url : "sch/getBuildingByCampusId.do?id="
														+ campusId,
												valueField : 'id',
												textField : 'name',
												value : "请选择"
											});
						} else {
							$('#courseOfTeacherWindow').find('#buildingId').combobox('loadData', {});
							$('#courseOfTeacherWindow').find('#buildingId').combobox('setValue','请选择');
						}
						$('#courseOfTeacherWindow').find('#classId').combobox('loadData', {});
						$('#courseOfTeacherWindow').find('#classId').combobox('setValue','请选择');
					}
				})
				
				
			//	alert($('#courseOfTeacherWindow').find('#campusId').combobox('getValue'));
				/////////////////////////////////
				//教室二级联动
				$('#courseOfTeacherWindow').find('#buildingId')
						.combobox(
								{
									onSelect : function() {
										//	alert('shit');
										var building = $('#courseOfTeacherWindow').find('#buildingId').combobox('getValue');
									//	console.log(majorId);
										if (building != '请选择' && building != null) {
									//		alert('go');
											$('#courseOfTeacherWindow').find('#classId').combobox(
															{
																url : "sch/getClassByBuildingId.do?id="
																		+ building,
																valueField : 'id',
																textField : 'name',
																value : "请选择"
															});
										} else {
											$('#courseOfTeacherWindow').find('#classId').combobox('loadData', {});
											$('#courseOfTeacherWindow').find('#classId').combobox('setValue','请选择');
										}
									}
								})
				/**       上面是教室的三级联动            **/
		/**专业方向二级联动**/
						$('#courseOfTeacherWindow').find('#majorIdOfManualAdjuseCourse')
								.combobox(
										{
											onSelect : function() {
												//	alert('shit');
												var majorId = $('#courseOfTeacherWindow').find('#majorIdOfManualAdjuseCourse').combobox('getValue');
										//		console.log(majorId);
												if (majorId != '请选择' && majorId != null) {
											//		alert('go');
													$('#courseOfTeacherWindow').find('#fieldId').combobox(
																	{
																		url : "sch/getMajorFieldJsonByMajorId.do?majorId="
																				+ majorId,
																		valueField : 'id',
																		textField : 'name',
																		value : "请选择"
																	});
												} else {
													$('#courseOfTeacherWindow').find('#fieldId').combobox('loadData', {});
													$('#courseOfTeacherWindow').find('#fieldId').combobox('setValue','请选择');
												}
											}
										})
	})
	/**上面是页面加载完成后**/
	
	//发请求获取该教师的所有课程
	function getTeacherCourseTableInTerm(form) {
		
		var teaName = $(form).find('#teaName').val();
		var teaCode = $(form).find('#teaCode').val();
//		alert(teaName + ", 工号: " + teaCode);
		//搜索教师，得到列表
		$('#teaInfoDialog').dialog('open');
		/* $.post("${contextPath}/tea/searchTeacherInfo.do",
				{code: teaCode,
				 name: teaName},
				function(data) {
					var obj = eval('(' + data + ')');
					$('#teaInfoOfManualAdjustCourse').datagrid('loadData', obj);
		}); */
		$('#teaInfoOfManualAdjustCourse').datagrid({
			url : "${contextPath}/tea/searchTeacherInfo.do",
			queryParams : {
				code: teaCode,
				 name: teaName
			}
		})
		
		var drops = $('.courseTable .drop');
		var courses = $('.left .item');
	//	alert("一天共有: " + drops.length + " 节课.");
	//	alert("当前老师每星期有 " + courses.length + " 节课.");
	//	drops[0].appendChild(courses[0]);
	//	drops[0].appendChild(courses[0]);
	}
	
	//得到课程信息
	function findCourseByConditionsOfManualAdjustCourse(teacherId) {
	//	alert(teacherId)
		var row = {};
		if (teacherId == null) {
			row = $('#teaInfoOfManualAdjustCourse').datagrid('getSelected');
		} else {
			row.idOfTeacher = teacherId;
		//	alert(teacherId)
			row.nameOfTeacher = $('#manualAdjustCourse').find('#teacherName').text();
			row.code = $('#manualAdjustCourse').find('#teacherCode').text();
			row.departmentIdStr = $('#manualAdjustCourse').find('#departmentIdStr').text();
		}
		if (row) {
			var id = row.idOfTeacher;
		//	alert(id)
		//	console.log(row);
			//将教师信息设置课程表上方
			$('#manualAdjustCourse').find('#teacherName').text(row.nameOfTeacher);
			$('#manualAdjustCourse').find('#teacherCode').text(row.code);
			$('#manualAdjustCourse').find('#departmentIdStr').text(row.departmentIdStr);
			
			$.post('${contextPath}/edu/findCourseOfTeacherInTerm.do', {
				id: id
			}, function(data) {
				//请求成功的话，先清空left和courseTable
				var drops = $('.courseTable .drop .item');
				var courses = $('.left .item');
	//			alert("items: " + drops.length);
				for (var i = 0; i < drops.length; ++i) 
					drops[i].remove();
				var obj = eval('(' + data + ')');
			//	obj = eval('(' + obj.rows + ')');
				console.log(obj.rows);
				//将所有课程信息放到left里面
				for (var i = 0; i < obj.rows.length; ++i) {
					
					var div = $("<div></div>").addClass("item");
					//排课id
					div.append($("<div id='courseScheduleId' style='display:none'>").text(obj.rows[i].courseScheduleId));
					//课程计划id
					div.append($("<div id='coursePlanId' style='display:none'>").text(obj.rows[i].coursePlanId));
					//授课id
					div.append($("<div id='teachCourseId' style='display:none'>").text(obj.rows[i].teachCourseId));
					
					div.append($("<div id='courseName'></div>").text(obj.rows[i].name));
					div.append($("<div id='weekDayInTable' style='display:none'></div>").text(obj.rows[i].weekDay));
					div.append($("<div id='sectionsInTable' style='display:none'></div>").text(obj.rows[i].sectionType));
					div.append($("<div id='weeksInTable' style='display:none'></div>").text(obj.rows[i].weeks));
					div.append($("<div id='weekIdsInTable' style='display:none'></div>").text(obj.rows[i].weekIds));
					div.append($("<div id='classesInTable'></div>").text(obj.rows[i].classes));
					div.append($("<div id='majorIdInTable' style='display:none'></div>").text(obj.rows[i].majorId));
					div.append($("<div id='fieldIdInTable' style='display:none'></div>").text(obj.rows[i].fieldId));
					div.append($("<div id='courseCodeInTable' style='display:none'></div>").text(obj.rows[i].courseCode));
					div.append($("<div id='teacherId' style='display:none'></div>").text(obj.rows[i].teacherId));
					div.append($("<div id='teaNameInTable' style='display:none'></div>").text(obj.rows[i].teaName));
					//上课地点
					div.append($("<div id='addressOfCourse'></div>").text(obj.rows[i].building + ' ' + obj.rows[i].classRoom));
					div.append($("<div id='campusId' style='display:none'></div>").text(obj.rows[i].campusId));
					div.append($("<div id='buildingId' style='display:none'></div>").text(obj.rows[i].buildingId));
					div.append($("<div id='classRoomId' style='display:none'></div>").text(obj.rows[i].classRoomId));
					//课程类型、考核方式、学分、学时
					div.append($("<div id='courseType' style='display:none'></div>").text(obj.rows[i].courseType));
					div.append($("<div id='examineType' style='display:none'></div>").text(obj.rows[i].examineType));
					div.append($("<div id='credit' style='display:none'></div>").text(obj.rows[i].credit));
					div.append($("<div id='hours' style='display:none'></div>").text(obj.rows[i].hours));
					
					//周次的插入顺序
					var first = obj.rows[i].weeks.split('-');
			//		alert(first[0]);
					var second = obj.rows[i].weekIds.split(',');
			//		alert(second[0]);
			//		alert('first: ' + first[0] + ", second: " + second[0] + "first < second?:" + (parseInt(first[0]) < parseInt(second[0])));
					if (parseInt(first[0]) < parseInt(second[0])) {
						div.append($("<div></div>").text("上课周: " + obj.rows[i].weeks));
						div.append($("<div></div>").text(obj.rows[i].weekIds));
					} else {
						div.append($("<div></div>").text("上课周: " + obj.rows[i].weekIds));
						div.append($("<div></div>").text(obj.rows[i].weeks));
					}
			//		div.append($("<div></div>").text("上课周: " + obj.rows[i].weeks));
			//		div.append($("<div></div>").text(obj.rows[i].weekIds));
					
					console.log(div.html())
					var td = $('<td></td>');//document.createElement('td');
					td.append(div);
					var tr = $('<tr></tr>')//document.createElement('tr');
					tr.append(td);
					$('#manualAdjustCourse').find('.left table').append(tr);
				}
				drops = $('.courseTable .drop');
				courses = $('.left .item');
		//		alert(courses.length);
				//,再放到table里
				var sectionCount = 0;
				for (var i = 0; i < courses.length; ++i) {
					
					sectionCount = obj.rows[i].sectionType%10;
					console.log(obj.rows[i].name + " 在第 " + sectionCount + " 行, 第 " + obj.rows[i].weekDay%10 + "列." );
					drops[obj.rows[i].weekDay%10 + 5*(sectionCount-1) - 1].appendChild(courses[i]);
				}
				
				//点击鼠标事件,双击打开课程编辑
				courses.each(function () {
					$(this).bind('dblclick', function(){
						//窗口打开之前，判断是否有遮罩层
						var a = $('#courseOfTeacherWindow').find('#button').linkbutton();
				//		alert($('#courseOfTeacherWindow').find('#zhezhao').css('z-index'));
						if ($('#courseOfTeacherWindow').find('#zhezhao').css('z-index') == -100) {
							$('#courseOfTeacherWindow').find('#zhezhao').css('z-index', '100');
							$('#courseOfTeacherWindow').find('#button .l-btn-text').text('编辑');
							$('#courseOfTeacherWindow').find('#confirmEdit').css('visibility','hidden');
							a.removeClass('l-btn-selected')
						}
						
						/***设置到编辑窗口***/
						//排课id
						$('#courseOfTeacherWindow').find('#courseScheduleId').val(parseInt($(this).find('#courseScheduleId').text()));
						//课程计划id
						$('#courseOfTeacherWindow').find('#coursePlanId').val(parseInt($(this).find('#coursePlanId').text()));
						//教师授课id
						$('#courseOfTeacherWindow').find('#teachCourseId').val(parseInt($(this).find('#teachCourseId').text()));
						
						$('#courseOfTeacherWindow').find('#weekDay').combobox('setValue', $(this).find('#weekDayInTable').text());
						$('#courseOfTeacherWindow').find('#sections').combobox('setValue', $(this).find('#sectionsInTable').text());
						//连续周
						$('#courseOfTeacherWindow').find('#weeks_1').val($(this).find('#weeksInTable').text().split('-')[0]);
						$('#courseOfTeacherWindow').find('#weeks_2').val($(this).find('#weeksInTable').text().split('-')[1]);
						$('#courseOfTeacherWindow').find('#weeks_2').val($(this).find('#weeksInTable').text().split('-')[1]);
						$('#courseOfTeacherWindow').find('#weekIds').val($(this).find('#weekIdsInTable').text());
						$('#courseOfTeacherWindow').find('#classes').val($(this).find('#classesInTable').text());
						//专业，方向
						var fieldId = parseInt($(this).find('#fieldIdInTable').text());
						var majorId = parseInt($(this).find('#majorIdInTable').text());
						$('#courseOfTeacherWindow').find('#majorIdOfManualAdjuseCourse').combobox('setValue', $(this).find('#majorIdInTable').text());
							$('#courseOfTeacherWindow').find('#fieldId').combobox(
								{
									url : "sch/getMajorFieldJsonByMajorId.do?majorId="
											+ majorId,
									valueField : 'id',
									textField : 'name',
									onLoadSuccess: function() {
										var data = $('#courseOfTeacherWindow').find('#fieldId').combobox('getData');
										var major = parseInt($('#courseOfTeacherWindow').find('#majorIdOfManualAdjuseCourse').combobox('getValue'));
								//		alert(major + ", " + majorId)
										if (data.length > 0 && major == majorId)
											$('#courseOfTeacherWindow').find('#fieldId').combobox('setValue', fieldId);
										else 
											$('#courseOfTeacherWindow').find('#fieldId').combobox('setValue', '请选择');
									}
									
								});
						$('#courseOfTeacherWindow').find('#code').val($(this).find('#courseCodeInTable').text());
						$('#courseOfTeacherWindow').find('#teacherId').textbox('setValue',$(this).find('#teacherId').text());
						$('#courseOfTeacherWindow').find('#teacherName').textbox('setValue',$(this).find('#teaNameInTable').text());
						$('#courseOfTeacherWindow').find('#courseName').val($(this).find('#courseName').text());
						//上课地点，校区，教学楼，教室
						var campusId = parseInt($(this).find('#campusId').text());
						var buildingId = parseInt($(this).find('#buildingId').text());
						var classRoomId = parseInt($(this).find('#classRoomId').text());
						$('#courseOfTeacherWindow').find('#campusId').combobox('setValue', $(this).find('#campusId').text());
							//根据校区获得教学楼
							$('#courseOfTeacherWindow').find('#buildingId').combobox(
								{
									url : "sch/getBuildingByCampusId.do?id="
											+ campusId,
									valueField : 'id',
									textField : 'name',
									onLoadSuccess: function() {
										var data = $('#courseOfTeacherWindow').find('#buildingId').combobox('getData');
										var campus = $('#courseOfTeacherWindow').find('#campusId').combobox('getValue');
								//		alert(campus + ', ' + campusId);
										if (data.length > 0 && campus == campusId) {
											$('#courseOfTeacherWindow').find('#buildingId').combobox('setValue', buildingId);
											//根据教学楼获得教室
											$('#courseOfTeacherWindow').find('#classId').combobox(
													{
														url : "sch/getClassByBuildingId.do?id="
																+ buildingId,
														valueField : 'id',
														textField : 'name',
														onLoadSuccess: function() {
															var data = $('#courseOfTeacherWindow').find('#classId').combobox('getData');
															var building = $('#courseOfTeacherWindow').find('#buildingId').combobox('getValue');
												//			alert(building + ", " + building);
															if (data.length > 0 && buildingId == building) {
																$('#courseOfTeacherWindow').find('#classId').combobox('setValue', classRoomId);
															}
														}
														
													});
										}
									}
									
								});
						//课程类型、考查形式、学分、学时
						$('#courseOfTeacherWindow').find('#courseType').combobox('setValue', $(this).find('#courseType').text());
						$('#courseOfTeacherWindow').find('#examineType').combobox('setValue', $(this).find('#examineType').text());
						$('#courseOfTeacherWindow').find('#credit').val($(this).find('#credit').text());
						$('#courseOfTeacherWindow').find('#hours').val($(this).find('#hours').text());
						
						$('#courseOfTeacherWindow').dialog('open');
						
					});
			
				});
			});
			$('#teaInfoDialog').dialog('close');
		} else {
			$.messager.alert("操作提示", "请先选择一行.", "warning");
		}
	}
	
	//打开关闭按钮
	function editAndUnEdit() {
		var a = $('#courseOfTeacherWindow').find('#button');
		var btn = $('#courseOfTeacherWindow').find('#confirmEdit');
		if (a.hasClass('l-btn-selected')) {
		//	alert("松开!");
			$('#courseOfTeacherWindow').find('#zhezhao').css('z-index', '100');
			$('#courseOfTeacherWindow').find('#button .l-btn-text').text('编辑'); 
			btn.css('visibility', 'hidden');
		} else {
		//	alert("按下!");
			$('#courseOfTeacherWindow').find('#zhezhao').css('z-index', '-100');
			$('#courseOfTeacherWindow').find('#button .l-btn-text').text('关闭');
			btn.css('visibility', 'visible');
		}
		
	}
	//修改课程信息
	function updateCourseOfTeacherInTerm(form) {
		
		//开启表单验证
		$(form).form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		
		//得到参数
		var courseScheduleId = $('#courseOfTeacherWindow').find('#courseScheduleId').val();
		var coursePlanId = $('#courseOfTeacherWindow').find('#coursePlanId').val();
		var teachCourseId = $('#courseOfTeacherWindow').find('#teachCourseId').val();
		
		var weekDay = $('#courseOfTeacherWindow').find('#weekDay').combobox('getValue');
		var section = $('#courseOfTeacherWindow').find('#sections').combobox('getValue');
		var weeks = parseInt($('#courseOfTeacherWindow').find('#weeks_1').val()) + "-" + parseInt($('#courseOfTeacherWindow').find('#weeks_2').val());
		var weekIds = $('#courseOfTeacherWindow').find('#weekIds').val();
		var classes = $('#courseOfTeacherWindow').find('#classes').val();
		var majorId = $('#courseOfTeacherWindow').find('#majorIdOfManualAdjuseCourse').combobox('getValue');
		var fieldId = $('#courseOfTeacherWindow').find('#fieldId').combobox('getValue');
		var code = $('#courseOfTeacherWindow').find('#code').val();
		//教师
		var teaId = $('#courseOfTeacherWindow').find('#teacherId').val();
		var teaName = $('#courseOfTeacherWindow').find('#teacherName').val();
		var courseName = $('#courseOfTeacherWindow').find('#courseName').val();
		var classRoomId = $('#courseOfTeacherWindow').find('#classId').combobox('getValue');
		var courseType = $('#courseOfTeacherWindow').find('#courseType').combobox('getValue');
		var examineType = $('#courseOfTeacherWindow').find('#examineType').combobox('getValue');
		var credit = $('#courseOfTeacherWindow').find('#credit').val();
		var hours = $('#courseOfTeacherWindow').find('#hours').val();
		
		
		console.log("星期id:" + weekDay + " ,节次id:" + section + ", weeks:" + weeks + ", weekIds:" + weekIds + 
				", classes:" + classes + ", majorId:" + majorId + " ,fieldId:" + fieldId +
				" ,课程编号:" + code + " ,teaId:" + teaId + ", teaName:" + teaName +
				" ,课程名称:" + courseName + " ,教室id:" + classRoomId + " ,课程类型:" + courseType + 
				" ,考查类型:" + examineType + " ,学分:" + credit + " ,学时:" + hours);
		
		var param = {
				courseScheduleId : courseScheduleId,
				coursePlanId : coursePlanId,
				teachCourseId : teachCourseId,
				name : courseName,
				weekDay : weekDay,
				weeks : weeks,
				weekIds : weekIds,
				sectionType : section,
				classes : classes,
				majorId : majorId,
				fieldId : fieldId,
				courseCode : code,
				teacherId : teaId,
				classRoomId : classRoomId,
				courseType : courseType,
				examineType : examineType,
				credit : credit,
				hours : hours
		}
		console.log(param);
		if (isNaN(parseInt($('#courseOfTeacherWindow').find('#weeks_1').val())) ||
			isNaN(parseInt($('#courseOfTeacherWindow').find('#weeks_2').val())) )
			$.messager.alert("操作提示", "上课周次只能输入整数!", "warning");
		else {
			var flag = false;
			if (!isNaN(weekIds))
				flag = true;
			else
			{
				var str = weekIds.split(/[,，]/);
				//		alert(str.length);
						flag = true;
						for (var i = 0; i < str.length; ++i) {
							
							if (isNaN(str[i])) {
								$.messager.alert("操作提示", "上课周次只能输入整数!", "warning");
								flag = false;
								break;
							}
						}
			}
			if (flag) {
				//更新数据库
				$.post('${contextPath}/edu/toUpdateCourseOfTeacher.do',
						param,
						function(data) {
					//更新成功
					var data = eval('(' + data + ')');
					console.log(data.result);
					if (data.result.length > 1) {  
						
						$.messager.alert("操作提示", "课程更新失败!<br>与多门课程有冲突!" , "warning");
					} else if (data.result.length == 1) {
						
						if (data.result[0].teacherId == param.teacherId &&
								data.result[0].courseScheduleId == param.courseScheduleId){  //返回原来的dto
							
							$('#courseOfTeacherWindow').dialog('close');
							$.messager.alert("操作提示", "该课程更新成功!", "info");
							//课表页面重新加载
							findCourseByConditionsOfManualAdjustCourse(parseInt(teaId));
						} else if (data.result[0].teacherId != param.teacherId) {  //返回冲突的一个对象
							
							$('#courseOfTeacherWindow').dialog('close');
							$.messager.alert("操作提示", "该课程更新失败!<br>与 " + data.result[0].teaName + 
									" 的 " + data.result[0].name + "(" + data.result[0].courseCode + ") 有冲突!", "warning");
						} else if (data.result[0].teacherId == param.teacherId
								&&
								data.result[0].courseScheduleId != param.courseScheduleId) {
							
							$('#courseOfTeacherWindow').dialog('close');
							$.messager.alert("操作提示", "该课程更新失败!<br>与您在本学期" + 
									"的 " + data.result[0].name + "(" + data.result[0].courseCode + ") 有冲突!", "warning");
						}
					}
					//各种更新失败（课程冲突）
				})
			}
		}
	}
</script>