<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
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
		width: 80px;
		height: 60px;
	}
	
	.courseTable {
		margin: 2px auto;
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
	
	.courseTable td.drop { 
		text-align: center;
		border: 1px solid #499B33;
		background: #fafafa;
		width: 160px;
		height: 45px;
	}
	
	.courseTable td.rest { 
		text-align: center;
		border: 1px solid #499B33;
		background: #fafafa;
		width: 160px;
		height: 45px;
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
	<div>
		<!-- 	<div style="margin: 10px">
		<span>课程代号:</span>
		<input class="easyui-textbox" id="code" style="width: 120px; height: 30px">&nbsp;&nbsp;
		<span>课程名称:</span>
		<input class="easyui-textbox" id="name" style="width: 120px; height: 30px">&nbsp;&nbsp; -->
	<div style="margin:10px">
	<form id="findTeaCourseCondition" > 
		<span>教师姓名:</span>
		<input class="easyui-textbox" id="teaScheduleName" name="teaScheduleName"
			style="width: 120px; height: 30px">&nbsp;&nbsp;<a
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="plain:true, iconCls:'icon-search'"
			onclick="findTeaCourseSchedule('#findTeaCourseCondition')">查询教师课表</a>	
		<span class="easyui-linkbutton" style="margin-left:5px" id="exportSchedule" 
				onmousedown="exportTeaSchedule()"
				data-options="plain:true,iconCls:'icon-print'">导出教师课程表</span>
	</form>
	</div>
		<h4 style="text-align:center; font-size: 30px;font-family:'宋体'">查询教师课表</h4>
		<!-- 课程表 -->
		<div class="courseTable" onselectstart="javascript:return false;" style="-moz-user-select:none;">
			<table>
				<tr>
					<td class="blank"></td>
					<td class="title">星期一</td>
					<td class="title">星期二</td>
					<td class="title">星期三</td>
					<td class="title">星期四</td>
					<td class="title">星期五</td>
					<td class="title">星期六</td>
					<td class="title">星期日</td>
				</tr>
				<tr class="tabtr">
					<td class="time">第一节</td>
					<td id="fir1" class="drop"></td>
					<td id="sec1" class="drop"></td>
					<td id="thi1" class="drop"></td>
					<td id="for1" class="drop"></td>
					<td id="fif1" class="drop"></td>
					<td class="rest" colspan="2" rowspan="8">休息</td>
				</tr>
				<tr class="tabtr">
					<td class="time">第二节</td>
					<td id="fir2" class="drop"></td>
					<td id="sec2" class="drop"></td>
					<td id="thi2" class="drop"></td>
					<td id="for2" class="drop"></td>
					<td id="fif2" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第三节</td>
					<td id="fir3" class="drop"></td>
					<td id="sec3" class="drop"></td>
					<td id="thi3" class="drop"></td>
					<td id="for1" class="drop"></td>
					<td id="fif3" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第四节</td>
					<td id="fir4" class="drop"></td>
					<td id="sec4" class="drop"></td>
					<td id="thi4" class="drop"></td>
					<td id="for4" class="drop"></td>
					<td id="fif4" class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">午休</td>
				</tr>
				<tr class="tabtr">
					<td class="time">第五节</td>
					<td id="fir5" class="drop"></td>
					<td id="sec5" class="drop"></td>
					<td id="thi5" class="drop"></td>
					<td id="for5" class="drop"></td>
					<td id="fif5" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第六节</td>
					<td id="fir6" class="drop"></td>
					<td id="sec6" class="drop"></td>
					<td id="thi6" class="drop"></td>
					<td id="for6" class="drop"></td>
					<td id="fif6" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第七节</td>
					<td id="fir7" class="drop"></td>
					<td id="sec7" class="drop"></td>
					<td id="thi7" class="drop"></td>
					<td id="for7" class="drop"></td>
					<td id="fif7" class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">放学</td>
				</tr>
			</table>
		</div>	
		<div class="easyui-dialog"  title="导出教师课表" resizable="false" onselectstart="javascript:return false;"
		 	id="exportTeaDialog"  data-options="modal:true,iconCls:'icon-edit',closed:true" top="50px"
		  	style="width:420px;height:250px;padding:10px;-moz-user-select:none;">
		  	<form id="exportTeaForm" style="align:center">
		  		<div style="text-align:center"><strong style="font-family: '宋体';font-size:20px">请填写要导出课表的教师姓名</strong></div><br><br>
				<div style="text-align:center">
				<span style="margin-top:20px">教师姓名:</span>
				<input class="easyui-textbox" id="selectTeacherName" name="selectTeacherName"
					style="width: 120px; height: 30px">
				</div>
				<div style="text-align: center;margin:30px;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="exportTeaCourse('#exportTeaForm')" style="margin-right:20px;"> <span
					style="font-size: 14px;">导出课表</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#exportTeaDialog').dialog('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
		  	</form>
		  </div>
</div>

<script type="text/javascript"> 

	//导出课程表按钮
	function exportTeaSchedule(){
		
		$('#exportTeaDialog').dialog('open');
	}
	
	//导出课程表
	function exportTeaCourse(form){
		//先进行表单校验
		//$('#exportForm').form('enableValidation').form('validate');
		//if(!$(form).form('validate')){
		//	return false;
		//} 
		var teacherName = $(form).find('#selectTeacherName').val();
		//console.log('nianji：'+gradeId+'banji:'+classId+'xingming:'+teacherName);
		if ((teacherName == null || teacherName == '')){
			$.messager.alert('操作提示','请填写教师姓名','warning');
			return false;
		}
		$.post('edu/exportSchedule.do',{
			'gradeId' : null,
			'classId' : null,
			'teacherName' : teacherName
		},function(data){
			if (data == '-1'){
				$.messager.alert('操作提示','该老师暂无课表!(请检查输入是否有错)','info');
				return false;
			}
			else {
				var filename = escape(data);
				console.log(filename);
				console.log(encodeURI(filename));
				window.open("${contextPath}/edu/toDownloadExportSchedule.do?filename="
							+ encodeURI(filename));
			}
		});
	}
	
	//查询课程
	function findTeaCourseSchedule(form){
		$divs = $('div .each');
		$divs.remove();
		var teacherName = $(form).find('#teaScheduleName').val();
		if (teacherName == null || teacherName == ''){
			$.messager.alert("操作提示",'请输入要查询课表的教师姓名!','warning');
			return false;
		}
		
		$.post('edu/findCourseSchedule.do',{
			'gradeId' : null,
			'classId' : null,
			'teacherName' : teacherName
		},function(data){
			var obj = $.parseJSON(data);
			var courses = obj.rows;
			console.log(courses);
			if (courses.length > 0){
			for (var i = 0; i < courses.length; i++){
				//第几节
				var sectionCount = courses[i].sectionType % 10;
				//星期几
				var weekdayCount = courses[i].weekDay % 10;
				console.log("第"+sectionCount+"节"+",星期"+weekdayCount);
				
				/*写了一堆屎。。。。*/
				if (sectionCount == 1 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes + 
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec1').append(div);
				}
				if (sectionCount ==2  && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif7').append(div);
				}
			}
			} else{
				$.messager.alert("操作信息","抱歉!暂无数据,\n或者请检查输入是否正确!",'info');
			}
		});
	}
</script>