<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="${contextPath}/css/edu/queryScoreByCoursePlan.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>

<table class="head_scoreByCp">
    <tr>
				<th  width="15%"  align="center">课程名称</th>
				<td  width="15%" align="center">${dto.name }</td>
				<th  width="15%" align="center">课程编号</th>
				<td  width="15%" align="center">${dto.code }</td>
				<th  width="15%" align="center">序号</th>
				<td  width="15%" align="center">${dto.major }</td>
			</tr>
			
			<tr>
				<th   align="center">学年</th>
				<td   align="center"></td>
				<th   align="center">学期</th>
				<td   align="center"></td>
				<th   align="center">学分</th>
				<td   align="center">${dto.classes }</td>
			</tr>
			
			<tr>
				<th   align="center">选课人数</th>
				<td   align="center"></td>
				<th   align="center">已录成绩人数</th>
				<td   align="center"></td>
				<th   align="center"></th>
				<td   align="center"></td>
			</tr>
     
     </table>
<div style="width: 99%; height: auto">
	<table id="allCourseCount" class="easyui-datagrid" style="width: auto;" >
		<thead>
			<tr>
				<th field="studyYearName" width="15%" align="center">课程名称</th>
				<th field="termTypeStr" width="15%" align="center">${dto.name }</th>
				<th field="name" width="15%" align="center">课程编号</th>
				<th field="code" width="15%" align="center">${dto.code }</th>
				<th field="major" width="15%" align="center">序号</th>
				<th field="code" width="15%" align="center">${dto.major }</th>
			</tr>
			
			<tr>
				<th field="studyYearName" width="15%" align="center">学年</th>
				<th field="termTypeStr" width="15%" align="center"></th>
				<th field="termTypeStr" width="15%" align="center">学期</th>
				<th field="code" width="15%" align="center"></th>
				<th field="major" width="15%" align="center">学分</th>
				<th field="major" width="15%" align="center">${dto.classes }</th>
			</tr>
			
			<tr>
				<th field="studyYearName" width="15%" align="center">选课人数</th>
				<th field="termTypeStr" width="15%" align="center"></th>
				<th field="termTypeStr" width="15%" align="center">已录成绩人数</th>
				<th field="code" width="15%" align="center"></th>
				<th field="major" width="15%" align="center"></th>
				<th field="major" width="15%" align="center"></th>
			</tr>
			
		</thead>
	</table>


     

<c:forEach var="obj" items="${map }">
	<table  class="easyui-datagrid" style="width: auto;" 
		>
		<thead>
			
			<tr>
				<th field="10" width="20%" align="center" rowspan="3">${obj.key }考核成绩统计</th>
				<th field="2" width="10%" align="center">分数段</th>
				<th field="3" width="10%" align="center">60<(不及格)</th>
				<th field="4" width="10%" align="center">60-69(及格)</th>
				<th field="5" width="10%" align="center">70-79(中等)</th>
				<th field="6" width="10%" align="center">80-89(良好)</th>
				<th field="7" width="10%" align="center">90-100(优秀)</th>
				<th field="8" width="10%" align="center">平均成绩</th>
			</tr>
			
			<tr>
				<th   field="1" width="10%" align="center">人数</th>
				<th   field="2" width="10%" align="center">${obj.value[0] }</th>
				<th   field="3" width="10%" align="center">${obj.value[1] }</th>
				<th   field="4" width="10%" align="center">${obj.value[2] }</th>
				<th   field="5" width="10%" align="center">${obj.value[3] }</th>
				<th   field="6" width="10%" align="center">${obj.value[4] }</th>
				<th   field="7" width="10%" align="center"  rowspan="2">50</th>
			</tr>
			
			<tr>
				<th  field="1" width="10%" align="center">百分比</th>
				<th  field="2" width="10%" align="center">${obj.value[0] * 100 / obj.value[5] }%</th>
				<th  field="3" width="10%" align="center">${obj.value[1] * 100 / obj.value[5] }%</th>
				<th  field="4" width="10%" align="center">${obj.value[2] * 100 / obj.value[5] }%</th>
				<th  field="5" width="10%" align="center">${obj.value[3] * 100 / obj.value[5] }%</th>
				<th  field="6" width="10%" align="center">${obj.value[4] * 100 / obj.value[5] }%</th>
			</tr>
			
			</thead>
	</table>
	</c:forEach>
</div>

<script type="text/javascript">
</script>
