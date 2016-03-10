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
	
	.courseScheduleTable {
		margin: 2px auto;
		width: 100%;
	}
	
	.courseScheduleTable table {
		background: #E0ECFF;
		width: 100%;
	}
	
	.courseScheduleTable td {
		background: #fafafa;
		text-align: center;
		padding: 2px;
		width: 50px;
	}
	
	.courseScheduleTable td {
		background: #E0ECFF;
		margin: 0px auto;
	}
	
	.courseScheduleTable td.drop { 
		text-align: center;
		border: 1px solid #499B33;
		background: #fafafa;
		width: 160px;
		height: 45px;
	}
	
	.courseScheduleTable td.rest { 
		text-align: center;
		border: 1px solid #499B33;
		background: #fafafa;
		width: 160px;
		height: 45px;
	}
	
	.courseScheduleTable td.drop .item:hover {
		background: pink;
		cursor: pointer;
		border-radius: 5px;
	}
	
	.courseScheduleTable td.over {
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
	<form id="findCourseCondition" > 
		<span>年级:</span> <select class="easyui-combobox" id="csGrade" name="csGrade" 
							data-options="editable:false,panelHeight: 'auto'" style="heigh:30px;width:100px">
				<option value="请选择">请选择</option>
		<c:forEach items="${gradeList }" var="g" >
			<option value="${g.id }">${g.name }</option>
		</c:forEach>
		</select>
		<span>班级:</span> <select class="easyui-combobox" id="csClass" name="csClass" style="heigh:30px;width:100px"
				data-options="editable:false,panelHeight: '85px' ">
			<option value="0">请选择</option>
		</select>
		<a	href="javascript:void(0)" class="easyui-linkbutton"
			data-options="plain:true, iconCls:'icon-search'"
			onclick="findCourseSchedule('#findCourseCondition')">查询班级课表</a>	
		<span class="easyui-linkbutton" style="margin-left:5px" id="exportSchedule" 
				onmousedown="exportSchedule()"
				data-options="plain:true,iconCls:'icon-print'">导出班级课程表</span>
	</form>
	</div>
		<h4 style="text-align:center; font-size: 30px;font-family:'宋体'">查询班级课表</h4>
		<!-- 课程表 -->
		<div class="courseScheduleTable" onselectstart="javascript:return false;" style="-moz-user-select:none;">
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
					<td id="fir1_" class="drop"></td>
					<td id="sec1_" class="drop"></td>
					<td id="thi1_" class="drop"></td>
					<td id="for1_" class="drop"></td>
					<td id="fif1_" class="drop"></td>
					<td class="rest" colspan="2" rowspan="8">休息</td>
				</tr>
				<tr class="tabtr">
					<td class="time">第二节</td>
					<td id="fir2_" class="drop"></td>
					<td id="sec2_" class="drop"></td>
					<td id="thi2_" class="drop"></td>
					<td id="for2_" class="drop"></td>
					<td id="fif2_" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第三节</td>
					<td id="fir3_" class="drop"></td>
					<td id="sec3_" class="drop"></td>
					<td id="thi3_" class="drop"></td>
					<td id="for1_" class="drop"></td>
					<td id="fif3_" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第四节</td>
					<td id="fir4_" class="drop"></td>
					<td id="sec4_" class="drop"></td>
					<td id="thi4_" class="drop"></td>
					<td id="for4_" class="drop"></td>
					<td id="fif4_" class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">午休</td>
				</tr>
				<tr class="tabtr">
					<td class="time">第五节</td>
					<td id="fir5_" class="drop"></td>
					<td id="sec5_" class="drop"></td>
					<td id="thi5_" class="drop"></td>
					<td id="for5_" class="drop"></td>
					<td id="fif5_" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第六节</td>
					<td id="fir6_" class="drop"></td>
					<td id="sec6_" class="drop"></td>
					<td id="thi6_" class="drop"></td>
					<td id="for6_" class="drop"></td>
					<td id="fif6_" class="drop"></td>
				</tr>
				<tr class="tabtr">
					<td class="time">第七节</td>
					<td id="fir7_" class="drop"></td>
					<td id="sec7_" class="drop"></td>
					<td id="thi7_" class="drop"></td>
					<td id="for7_" class="drop"></td>
					<td id="fif7_" class="drop"></td>
				</tr>
				<tr>
					<td class="time"></td>
					<td class="release" colspan="5">放学</td>
				</tr>
			</table>
		</div>	
		<div class="easyui-dialog"  title="导出班级课表" resizable="false" onselectstart="javascript:return false;"
		 	id="exportDialog"  data-options="modal:true,iconCls:'icon-edit',closed:true" top="50px"
		  	style="width:420px;height:250px;padding:10px;-moz-user-select:none;">
		  	<form id="exportForm" style="align:center">
		  		<div style="text-align:center"><strong style="font-family: '宋体';font-size:20px">请选择要导出课表的班级</strong></div><br><br>
		  		<div style="text-align:center">
		  		<span>年级:</span><select id="selectGrade" class="easyui-combobox" 
		  			style="width:100px;align:center;margin-left:20px" name="selectGrade" 
		  			data-options="editable:false,panelHeight:'auto',
		  				required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="请选择">请选择</option>
					<c:forEach items="${gradeList }" var="g">
						<option value="${g.id }">${g.name }</option>
					</c:forEach>
				</select>
				<span>班级:</span><select id="selectClass" class="easyui-combobox" 
					style="width:100px;align:center;margin-left:20px" name="selectClass" 
					data-options="editable:false,panelHeight:'auto',
						required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
					</select><br><br>
		  		</div>
				<div style="text-align: center;margin:30px;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="exportCourseTable('#exportForm')" style="margin-right:20px;"> <span
					style="font-size: 14px;">导出课表</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#exportDialog').dialog('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
		  	</form>
		  </div>
</div>

<script type="text/javascript"> 

	$(function(){
		//$('#grade').combobox();	
		/*年级和班级的二级联动*/
		$('#csGrade').combobox({
			onSelect : function() {
				
				var gradeId = $('#findCourseCondition').find('#csGrade').combobox('getValue');
				if (gradeId != '请选择' && gradeId != null){
					$('#findCourseCondition').find('#csClass').combobox({
						url : "edu/getClassByGradeId.do?gradeId=" + gradeId,
						valueField : 'id',
						textField : 'name',
						value : '请选择'
					});
				} else{
					$('#findCourseCondition').find('#csClass').combobox('loadData',{});
					$('#findCourseCondition').find('#csClass').combobox('setValue',"请选择");
				}
			}
			
		});
		
	});
	
	//dialog中的二级联动
	$('#selectGrade').combobox({
		onSelect : function(){
			var gradeId = $('#selectGrade').combobox('getValue');
			if (gradeId != '请选择' && gradeId != null){
				$('#selectClass').combobox({
					url : 'edu/getClassByGradeId.do?gradeId=' + gradeId,
					valueField : 'id',
					textField : 'name',
					value : '请选择'
				});
			} else{
				$('#selectClass').combobox('loadData','{}');
				$('#selectClass').combobox('setValue',"请选择");
			}
		}
	});
	//导出课程表按钮
	function exportSchedule(){
		
		$('#exportDialog').dialog('open');
	}
	
	//导出课程表
	function exportCourseTable(form){
		//先进行表单校验
		//$('#exportForm').form('enableValidation').form('validate');
		//if(!$(form).form('validate')){
		//	return false;
		//} 
		var gradeId = $(form).find('#selectGrade').combobox('getValue');
		var classes = $(form).find('#selectClass').combobox('getText');
		//console.log('nianji：'+gradeId+'banji:'+classes+'xingming:'+teacherName);
		if ((classes == '0' || classes == null || classes == '请选择')
				&& (gradeId == '请选择'||gradeId == null)){
			$.messager.alert('操作提示','请选择要导出课表的班级!','warning');
			return false;
		}
		if ((classes == '请选择' || classes == null)
				&& gradeId != null){
			$.messager.alert('操作提示','请选择班级!','warning');
			return false;
		}
		if (classes == 0 || classes == '请选择'){
			classes = null;
		}
		if (gradeId == '请选择' || gradeId == 0){
			gradeId = null;
		}
		$.post('edu/exportSchedule.do',{
			'gradeId' : gradeId,
			'classes' : classes,
			'teacherName' : null
		},function(data){
			if (data == '-1'){
				$.messager.alert('操作提示','该班级暂无课表!(请检查输入是否有错)','info');
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
	function findCourseSchedule(form){
		$divs = $('div .every');
		$divs.remove();
		var gradeId = $(form).find('#csGrade').combobox('getValue');
		//alert(gradeId);
		var classes = $(form).find('#csClass').combobox('getText');
		//console.log(classes);
		if ((classes == '0' || classes == null || classes == '请选择')
				&& (gradeId == '请选择'||gradeId == null)){
			$.messager.alert("操作提示",'请选择查询条件进行查询!','warning');
			return false;
		}
		if (isNaN(gradeId) || gradeId == 0 || gradeId == '请选择'){
			gradeId = null;
		}
		$divs = $('div .every');
		$divs.remove();
		$.post('edu/findCourseSchedule.do',{
			'gradeId' : gradeId,
			'classes' : classes,
			'teacherName' : null
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
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes + 
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir1_').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir2_').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir3_').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir4_').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir5_').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir6_').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 1){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fir7_').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec1_').append(div);
				}
				if (sectionCount ==2  && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec2_').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec3_').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec4_').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec5_').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec6_').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 2){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#sec7_').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi1_').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi2_').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi3_').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi4_').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi5_').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi6_').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 3){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#thi7_').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for1_').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for2_').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for3_').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for4_').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for5_').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for6_').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 4){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#for7_').append(div);
				}
				if (sectionCount == 1 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif1_').append(div);
				}
				if (sectionCount == 2 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif2_').append(div);
				}
				if (sectionCount == 3 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif3_').append(div);
				}
				if (sectionCount == 4 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif4_').append(div);
				}
				if (sectionCount == 5 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif5_').append(div);
				}
				if (sectionCount == 6 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif6_').append(div);
				}
				if (sectionCount == 7 && weekdayCount == 5){
					var div = $("<div class='every'></div>");
					div.html(courses[i].courseName + '&nbsp;授课:'+ courses[i].teacherName + 
								'<br>专业:'+courses[i].majorStr+courses[i].fieldStr+
								'<br>班级：'+courses[i].grade+courses[i].classroom + 
								'<br>学时:'+courses[i].hours+'&nbsp;学分'+courses[i].credit+
								'<br>'+courses[i].classes +
								'<br>周次:'+courses[i].weeks + '&nbsp;'+courses[i].weekIds);
					$('#fif7_').append(div);
				}
			}
			} else{
				$.messager.alert("操作信息","抱歉,暂无数据!",'info');
			}
		});
	}
</script>
