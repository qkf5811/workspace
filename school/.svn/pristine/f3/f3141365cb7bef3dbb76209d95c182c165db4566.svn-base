<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style scoped type="text/css">
#searchCourseConditionToolBar #moreBtn {
	text-decoration: none;
}

#searchCourseConditionToolBar #moreBtn:hover {
	color: red;
}
</style>
<div style="width: 99%; height: auto">
	<div id="searchCourseConditionToolBar"
		style="padding: 5px; height: auto">
		<div style="background-color: white">
			<td>学年:</td>
			<td><select class="easyui-combobox" id="studyYearId"
				name="studyYearId"
				data-options="editable:false,panelHeight: 'auto',panelHeight: '85px'"
				style="width: 100px;height:31px">
					<option value="0">请选择</option>
					<c:forEach items="${studyYearList }" var="s">
						<option value="${s.id }">${s.name }</option>
					</c:forEach>
			</select></td>
			<td>学期:</td>
			<td><select class="easyui-combobox" id="termType"
				name="termType" data-options="editable:false,panelHeight: 'auto'"
				style="width: 100px;height:31px">
					<option value="0">请选择</option>
					<option value="32001">第一学期</option>
					<option value="32002">第二学期</option>
			</select></td>
			<td>年级:</td>
			<td><select class="easyui-combobox" id="gradeSearchCourse"
				name="gradeSearchCourse"
				data-options="editable:false,panelHeight:'auto'"
				style="width: 100px;height:31px">
					<option value="请选择">请选择</option>
					<c:forEach items="${gradeList }" var="g">
						<option value="${g.id }">${g.name }</option>
					</c:forEach>
			</select></td>
			<td>班级:</td>
			<td><select class="easyui-combobox" id="classes" name="classes"
				data-options="editable:false,panelHeight:'auto',panelHeight: '85px'"
				style="width: 100px;height:31px">
					<option value="0">请选择</option>
			</select></td>
			<td>教师姓名 :</td>
			<td><input class="easyui-validatebox textbox" id="scTeacherName"
				name="scTeacherName"
				style="width: 100px; height: 18px; padding: 5px"></td>
			<td><a href="javascript:void(0)" onclick="moreConditions()"
				style="vertical-align: middle; padding: 5px 7px; margin-left: 25px; background: #F5F5F5; border-radius: 5px"
				id="moreBtn" data-options="plain:true">更多∨</a>
				<button href="#" class="easyui-linkbutton" plain="true"
					style="width: 100px; height: 25px; margin-right: 120px"
					onclick="searchCourse('#searchCourseList')" iconCls="icon-search">查询开课</button></td>
			<br> <br>
			<div id="moreConditions">
				<td>专业:</td>
				<td><select class="easyui-combobox" id="majorName"
					name="majorName"
					data-options="editable:false,panelHeight: 'auto',panelHeight: '85px'"
					style="width: 100px;height:31px">
						<option value="请选择">请选择</option>
						<c:forEach items="${majorList }" var="m">
							<option value="${m.id }">${m.name }</option>
						</c:forEach>
				</select></td>
				<td>专业方向:</td>
				<td><select class="easyui-combobox" id="majorField"
					name="majorField"
					data-options="editable:false,panelHeight: 'auto',panelHeight: '85px'"
					style="width: 100px;height:31px">
						<option value="0">请选择</option>
				</select></td>&nbsp;&nbsp;&nbsp;&nbsp;
				<td>星期:</td>
				<td><label><input type="radio" value="36001"
						name="weekday" />周一</label> <label><input type="radio"
						value="36002" name="weekday" />周二</label> <label><input
						type="radio" value="36003" name="weekday" />周三</label> <label><input
						type="radio" value="36004" name="weekday" />周四</label> <label><input
						type="radio" value="36005" name="weekday" />周五</label></td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<td>连续周次 :</td>&nbsp;&nbsp;
				<td>起始:</td>
				<td><input class="easyui-numberbox" id="weeks_1"
					name="weeks_1" style="width: 100px; height: 31px; padding: 5px">
					<!-- 
			<select class="easyui-combobox" id="weekId_1" name="weekId_1" style="width:100px"
					data-options="editable:false,panelHeight: 'auto',panelHeight: '85px'">
					<option value="请选择">请选择</option>
						<option value="1">第1周</option>
						<option value="2">第2周</option>
						<option value="3">第3周</option>
						<option value="4">第4周</option>
						<option value="5">第5周</option>
						<option value="6">第6周</option>
						<option value="7">第7周</option>
						<option value="8">第8周</option>
						<option value="9">第9周</option>
						<option value="10">第10周</option>
						<option value="11">第11周</option>
						<option value="12">第12周</option>
						<option value="13">第13周</option>
						<option value="14">第14周</option>
						<option value="15">第15周</option>
						<option value="16">第16周</option>
						<option value="17">第17周</option>
						<option value="18">第18周</option>
						<option value="19">第19周</option>
				</select>
				--></td>
				<td>结束:</td>
				<td><input class="easyui-numberbox" id="weeks_2"
					name="weeks_2" style="width: 100px; height: 31px; padding: 5px">
					<!-- 
			<select class="easyui-combobox" id="weekId_2" name="weekId_2" style="width:100px"
					data-options="editable:false,panelHeight: 'auto',panelHeight: '85px'">
					<option value="请选择">请选择</option>
						<option value="1">第1周</option>
						<option value="2">第2周</option>
						<option value="3">第3周</option>
						<option value="4">第4周</option>
						<option value="5">第5周</option>
						<option value="6">第6周</option>
						<option value="7">第7周</option>
						<option value="8">第8周</option>
						<option value="9">第9周</option>
						<option value="10">第10周</option>
						<option value="11">第11周</option>
						<option value="12">第12周</option>
						<option value="13">第13周</option>
						<option value="14">第14周</option>
						<option value="15">第15周</option>
						<option value="16">第16周</option>
						<option value="17">第17周</option>
						<option value="18">第18周</option>
						<option value="19">第19周</option>
				</select>
				 --></td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <br>
				<br>
				<td>分散周次(可多选)</td>
				<td>全选:<input type="checkbox" id="allSelected"
					name="allSelected" onclick="allSelect()"></td>
				<td><input type="checkbox" value="1" name="checkbox_week">1
					<input type="checkbox" value="2" name="checkbox_week">2 <input
					type="checkbox" value="3" name="checkbox_week">3 <input
					type="checkbox" value="4" name="checkbox_week">4 <input
					type="checkbox" value="5" name="checkbox_week">5 <input
					type="checkbox" value="6" name="checkbox_week">6 <input
					type="checkbox" value="7" name="checkbox_week">7 <input
					type="checkbox" value="8" name="checkbox_week">8 <input
					type="checkbox" value="9" name="checkbox_week">9 <input
					type="checkbox" value="10" name="checkbox_week">10 <input
					type="checkbox" value="11" name="checkbox_week">11 <input
					type="checkbox" value="12" name="checkbox_week">12 <input
					type="checkbox" value="13" name="checkbox_week">13 <input
					type="checkbox" value="14" name="checkbox_week">14 <input
					type="checkbox" value="15" name="checkbox_week">15 <input
					type="checkbox" value="16" name="checkbox_week">16 <input
					type="checkbox" value="17" name="checkbox_week">17 <input
					type="checkbox" value="18" name="checkbox_week">18 <input
					type="checkbox" value="19" name="checkbox_week">19</td>
			</div>
		</div>
	</div>

	<table id="searchCourseList" class="easyui-datagrid"
		singleSelect="true" pagination="true"
		url="${contextPath}/edu/findCourseByCondition.do"
		toolbar="#searchCourseConditionToolBar" rownumbers="true"
		singleSelect="true" style="width: 'auto'" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="80" align="center">课程编号</th>
				<th field="studyYear" width="80" align="center">学年</th>
				<th field="termStr" width="80" align="center">学期</th>
				<th field="major" width="80" align="center">专业</th>
				<th field="majorField" width="100" align="center">专业方向</th>
				<th field="courseName" width="100" align="center">课程名称</th>
				<th field="courseTypeStr" width="80" align="center">课程类型</th>
				<th field="teacherName" width="80" align="center">任课老师</th>
				<th field="credit" width="50" align="center">学分</th>
				<th field="hours" width="50" align="center">学时</th>
				<th field="grade" width="80" align="center">年级</th>
				<th field="classes" width="100" align="center">上课班级</th>
				<th field="lessonPlace" width="100" align="center">上课课室</th>
				<th field="weeks" width="60" align="center">连续周次</th>
				<th field="weekIds" width="80" align="center">分散周次</th>
				<!-- 
				<th feild="weekdayStr" width="80" align="center">星期</th>
				<th feild="sectionTypeStr" width="80" align="center">节次</th>
				 -->
				<th field="examTypeStr" width="80" align="center">考核方式</th>
				<th field="scoreTypeStr" width="80" align="center">成绩类型</th>
				<th field="remark" width="100" align="center">备注</th>
			</tr>
		</thead>
	</table>
</div>

<script type="text/javascript">
	$(function() {
		$('#moreConditions').panel({
			'collapse' : true,
			'collapsed' : true,
			'border' : false
		});

		/*
			年级和班级的二级联动
		 */
		$('#gradeSearchCourse')
				.combobox(
						{
							onSelect : function() {

								var gradeId = $('#searchCourseConditionToolBar')
										.find('#gradeSearchCourse').combobox(
												'getValue');
								if (gradeId != '请选择' && gradeId != null) {
									$('#searchCourseConditionToolBar')
											.find('#classes')
											.combobox(
													{
														url : "edu/getClassByGradeId.do?gradeId="
																+ gradeId,
														valueField : 'name',
														textField : 'name',
														value : '请选择'
													});
								} else {
									$('#classes').combobox('loadData', '{}');
									$('#classes').combobox('setValue', '请选择');
								}
							}
						});

		/*
			专业和方向的二级联动 
		 */
		$('#majorName')
				.combobox(
						{
							onSelect : function() {
								var majorId = $('#searchCourseConditionToolBar')
										.find('#majorName')
										.combobox('getValue');
								if (majorId != '请选择' || majorId != null) {
									$('#majorField')
											.combobox(
													{
														url : 'edu/getFieldByMajorId.do?majorId='
																+ majorId,
														valueField : 'id',
														textField : 'name',
														value : '请选择'
													});
								} else {
									$('#majorField').combobox('loadData', '{}');
									$('#majorField')
											.combobox('setValue', '请选择');
								}
							}
						});
		/*
		//如果选中起始周或结束周则多选框失效
		$('#weekId_1').combobox({
			onSelect : function(){
				$('.checkbox_week').css('disabled','disabled');
			}
		});
		$('#weekId_2').combobox({
			onSelect : function(){
				$('.checkbox_week').css('disabled','disabled');
			}
		});
		
		if ($('.checkbox_week').attr('check','checked')){
			var weekId1 = $('#weekId_1');
			weekId1.style.disabled = false;
			var weekId2 = $('#weekId_2');
			weekId2.style.disabled = false;
		}*/
	});
	//点击更多条件按钮
	function moreConditions() {
		if ($('#moreBtn').text() == '更多∨') { //折叠状态
			$('#moreBtn').text("收起∧");
			//	$('#getMoreBtn').css({padding: '2px 5px'});
			$('#moreConditions').panel('expand', true);
		} else {
			$('#moreBtn').text("更多∨");
			//	$('#getMoreBtn').css({padding: '2px'});
			$('#moreConditions').panel('collapse', true);
		}

	}

	//全选
	function allSelect() {
		var allSelected = document.getElementById('allSelected');
		//console.log(allSelected);
		var checkboxs = document.getElementsByName('checkbox_week');
		//console.log(checkboxs);
		if (allSelected.checked) {
			for (var i = 0; i < checkboxs.length; i++) {
				checkboxs[i].checked = true;
			}
		} else {
			for (var i = 0; i < checkboxs.length; i++) {
				checkboxs[i].checked = false;
			}
		}
	}
	/*
		开课查询
	 */
	function searchCourse(datagrid) {
		var studyYearId = $('#studyYearId').combobox('getValue');
		if (studyYearId == '请选择' || isNaN(studyYearId) || studyYearId == 0) {
			studyYearId = null;
		}
		var termType = $('#termType').combobox('getValue');
		if (termType == '请选择' || isNaN(termType) || termType == 0) {
			termType = null;
		}
		var grade = $('#gradeSearchCourse').combobox('getValue');
		var classes = $('#classes').combobox('getValue');
		var majorName = $('#majorName').combobox('getValue');
		if (majorName == '请选择' || isNaN(majorName) || majorName == 0) {
			majorName = null;
		}
		var majorField = $('#majorField').combobox('getValue');
		var teacherName = $('#scTeacherName').val();
		//var weekId_1 = $('#weekId_1').combobox('getValue');
		//var weekId_2 = $('#weekId_2').combobox('getValue');
		var weeks_1 = $('#weeks_1').val().trim();
		var weeks_2 = $('#weeks_2').val().trim();
		var week;
		weeks = weeks_1 + '-' + weeks_2;
		//连续周次
		if (weeks_1 == '') {
			weeks = null;
		}
		if (weeks_2 == '') {
			weeks = null;
		}
		console.log('weeks:' + weeks);

		//礼拜几
		var weekday = '';
		var weekdays = document.getElementsByName('weekday');
		//console.log(weekdays);
		for (var x = 0; x < weekdays.length; x++) {
			if (weekdays[x].checked) {
				weekday = weekdays[x].value;
				break;
			}
		}
		console.log('weekday:' + weekday);
		//分散周次
		var weekIds = [];
		var weekIdArr = document.getElementsByName('checkbox_week');
		for (var i = 0; i < weekIdArr.length; i++) {
			if (weekIdArr[i].checked) {
				weekIds.push(weekIdArr[i].value);
			}
		}
		weekIds = weekIds.join();
		console.log('weekIds=' + weekIds);

		//如果分散周次全选的话就将其转为连续周次
		if (document.getElementById('allSelected').checked) {
			var checkboxs = document.getElementsByName('checkbox_week');
			weeks = checkboxs[0].value + '-'
					+ checkboxs[checkboxs.length - 1].value;
			console.log('weeks：' + weeks);
			weekIds = null;
		}

		//没有选中年级或班级
		if (grade == '请选择' || grade == 0 || grade == '') {
			grade = null;
		}
		if (classes == '请选择' || classes == 0 || classes == '') {
			classes = null;
		}
		//没有选中专业或方向
		if (majorName == '请选择' || majorName == 0 || majorName == '') {
			majorName = null;
		}
		if (majorField == '请选择' || majorField == 0 || majorField == '') {
			majorField = null;
		}
		//连续周次相同
		if (weeks_1 == weeks_2 && (weeks_1 != '' && weeks_2 != '')) {
			weekIds = weeks_1;
			weeks = null;
			console.log('weekIds:' + weekIds);
		}

		$(datagrid).datagrid('load', {
			'studyYearId' : studyYearId,
			'termType' : termType,
			'gradeId' : grade,
			'classes' : classes,
			'majorId' : majorName,
			'fieldId' : majorField,
			'teacherName' : teacherName,
			'weeks' : weeks,
			'weekIds' : weekIds,
			'weekday' : weekday
		});
	}
</script>