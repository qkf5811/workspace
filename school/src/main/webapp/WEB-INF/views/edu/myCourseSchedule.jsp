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
	
	.myCourseSchedule {
		margin: 2px auto;
		width: 100%;
	}
	
	.myCourseSchedule table {
		background: #E0ECFF;
		width: 100%;
	}
	
	.myCourseSchedule td {
		background: #fafafa;
		text-align: center;
		padding: 2px;
		width: 50px;
	}
	
	.myCourseSchedule td {
		background: #E0ECFF;
		margin: 0px auto;
	}
	
	.myCourseSchedule td.drop { 
		text-align: center;
		border: 1px solid #499B33;
		background: #fafafa;
		width: 160px;
		height: 45px;
	}
	
	.myCourseSchedule td.drop .item:hover {
		background: pink;
		cursor: pointer;
		border-radius: 5px;
	}
	
	.myCourseSchedule td.over {
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
		<h4 style="text-align:center; font-size: 30px;font-family:'宋体'">我的课程表</h4>
		<div id="showMySchedule" style="visibility: false;text-align:center;">
			<span class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'" 
					 onmousedown="showMyClassSchedule()">查看我的班级课表</span>
		</div>
		<!-- 教师课程表 -->
		<div class="myCourseSchedule" onselectstart="javascript:return false;" style="-moz-user-select:none;">
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
				<tr>
					<td class="time">第一节</td>
					<td id="fir1" class="drop"></td>
					<td id="sec1" class="drop"></td>
					<td id="thi1" class="drop"></td>
					<td id="for1" class="drop"></td>
					<td id="fif1" class="drop"></td>
					<td class="drop" colspan="2" rowspan="8">休息</td>
				</tr>
				<tr>
					<td class="time">第二节</td>
					<td id="fir2" class="drop"></td>
					<td id="sec2" class="drop"></td>
					<td id="thi2" class="drop"></td>
					<td id="for2" class="drop"></td>
					<td id="fif2" class="drop"></td>
				</tr>
				<tr>
					<td class="time">第三节</td>
					<td id="fir3" class="drop"></td>
					<td id="sec3" class="drop"></td>
					<td id="thi3" class="drop"></td>
					<td id="for1" class="drop"></td>
					<td id="fif3" class="drop"></td>
				</tr>
				<tr>
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
				<tr>
					<td class="time">第五节</td>
					<td id="fir5" class="drop"></td>
					<td id="sec5" class="drop"></td>
					<td id="thi5" class="drop"></td>
					<td id="for5" class="drop"></td>
					<td id="fif5" class="drop"></td>
				</tr>
				<tr>
					<td class="time">第六节</td>
					<td id="fir6" class="drop"></td>
					<td id="sec6" class="drop"></td>
					<td id="thi6" class="drop"></td>
					<td id="for6" class="drop"></td>
					<td id="fif6" class="drop"></td>
				</tr>
				<tr>
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
		<div hidden="true">
			<input type="hidden" id="sessionValue" value="${sessionScope.user.id }">
			<input type="hidden" id="gradeId" value="${gradeId }">
			<input type="hidden" id="classId" value="${classId }">
		</div>
	</div>
	
<script type="text/javascript">

	$(function(){
		var userId = $('#sessionValue').val();
		var gradeId = $('#gradeId').val();
		var classId = $('#classId').val();
		var teacherId = $('#teacherId').val();
		if (teacherId != null){			//如果是老师显示按钮
			$('#showMySchedule').css('visibility',true);
		}
		//console.log(userId);
		if (userId != null){
		
			$.post('edu/myCourseSchedule.do',{'userId':userId},function(data){
				if (data.length > 0 || data != '{}'){
				//alert(data);
				console.log(data);
				var obj = $.parseJSON(data);
				//console.log(obj.rows);
				var courses = obj.rows;
				console.log(courses);
				if (courses.length > 0){
				for (var i = 0; i < courses.length; i++){
					//第几节
					var sectionCount = courses[i].sectionType % 10;
					//星期几
					var weekdayCount = courses[i].weekDay % 10;
					console.log("第"+sectionCount+"节"+",星期"+weekdayCount);
				
					/*星期一第一节(以此类推)*/	/*
							节次用阿拉伯数字表示,星期用fir,sec,thi,‘for’,fif表示
							*/
					var div = $("<div class='each' name='mine'></div>");
					div.html(courses[i].courseName + 
								'<br>老师：'+ courses[i].teacherName + 
								'<br>班级：'+courses[i].classes + '<hr>');
					
					if (weekdayCount == 1) {
						$('#fir' + sectionCount).append(div);
					}
					if (weekdayCount == 2) {
						$('#sec' + sectionCount).append(div);
					}
					if (weekdayCount == 3) {
						$('#thi' + sectionCount).append(div);
					}
					if (weekdayCount == 4) {
						$('#for' + sectionCount).append(div);
					}
					if (weekdayCount == 5) {
						$('#fif' + sectionCount).append(div);
					}
					
				}
			}
		}
		});
		}
	});
	
	/*查看老师所在班级的课程表*/
	function showMyClassSchedule(){
		/*清空原先的内容*/
		$divs = $('div .each');
		console.log($divs);
		$divs.remove();
		/*马丹试了这么多次终于成功一次*/
		var gradeId = $('#gradeId').val();
		console.log('年级id:'+gradeId);
		var classId = $('#classId').val();
		console.log('班级id:'+classId);
		if((gradeId == null && classId == null) || (gradeId == '' && classId == '')){
			return ;
		}
		
		//发post请求老师所在班级课表
		$.post('edu/showClassSchedule.do',{
			'gradeId': gradeId,
			'classId': classId
		},function(data){
			var obj = $.parseJSON(data);
			if (obj.rows.length > 0){
			for (var i = 0; i < obj.rows.length; i++){
				var sectionCount = obj.rows[i].sectionType % 10;
				var weekdayCount = obj.rows[i].weekDay % 10;
				console.log("第"+sectionCount+"节"+",星期"+weekdayCount);
				if (sectionCount == 1 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 1){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fir7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec1').append(div);
				}
				if (sectionCount ==2  && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 2){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#sec7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 3){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#thi7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 4){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#for7').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif1').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif2').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif3').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif4').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif5').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif6').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 5){
					var div = $("<div class='each'></div>");
					div.html(obj.rows[i].courseName + '&nbsp;授课:'+ obj.rows[i].teacherName + 
								'<br>专业:'+obj.rows[i].majorStr+obj.rows[i].fieldStr+
								'<br>班级：'+obj.rows[i].grade+obj.rows[i].classroom + 
								'<br>学时:'+obj.rows[i].hours+'&nbsp;学分'+obj.rows[i].credit+
								'<br>周次:'+obj.rows[i].weeks + '&nbsp;'+obj.rows[i].weekIds+'<hr>');
					$('#fif7').append(div);
				}
			}

			}
		});
	}
		
</script>