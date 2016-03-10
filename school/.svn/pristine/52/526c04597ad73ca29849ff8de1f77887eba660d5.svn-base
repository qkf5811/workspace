<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<link rel="stylesheet"
	href="${contextPath}/css/edu/queryScoreByCoursePlan.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>
</head>

<body>
	<%-- c:if test="${courseCount>=1 }">
		<c:set var="studyYear"
			value="${courseToQueryScoByHTList[0].studyYearStr }" />
		<c:set var="termType"
			value="${courseToQueryScoByHTList[0].termTypeStr }" />
	</c:if> --%>


	<div class="center" style="height: 15px; margin-top: 3px;">
		<a href="javascript:void(0)"
			style="postion: absolute; font-size: 15px; float: right;"
			onclick="$('#edu_stuScoreOfCP_print_region').jqprint()">打印</a>
	</div>
	<div class="center" id="edu_stuScoreOfCP_print_region">
		<table id="scoreTableWithCP">
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
				<td   align="center">${dto.studyYearName}</td>
				<th   align="center">学期</th>
				<td   align="center">${dto.termTypeStr}</td>
				<th   align="center">学分</th>
				<td   align="center">${dto.classes }</td>
			</tr>
			
			<tr>
				<th   align="center">选课人数</th>
				<td   align="center">${dto.termType }</td>
				<th   align="center">已录成绩人数</th>
				<td   align="center">${dto.coursePlanId }</td>
				<th   align="center"></th>
				<td   align="center"></td>
			</tr>

		</table>
		
		
	<c:forEach var="obj" items="${map }">
	<table id="scoreTableWithCP">
			<tr>
				<td  width="20%" align="center" rowspan="3">${obj.key }考核成绩统计<br>已录成绩人数(${obj.value.sum })</td>
				<th  width="10%" align="center">分数段</th>
				<th  width="10%" align="center">60<(不及格)</th>
				<th width="10%" align="center">60-69(及格)</th>
				<th width="10%" align="center">70-79(中等)</th>
				<th  width="10%" align="center">80-89(良好)</th>
				<th width="10%" align="center">90-100(优秀)</th>
				<th width="10%" align="center">平均成绩</th>
			</tr>
			
			<tr>
				<th  align="center">人数</th>
				<td  align="center">${obj.value.int0 }</td>
				<td  align="center">${obj.value.int1 }</td>
				<td  align="center">${obj.value.int2 }</td>
				<td  align="center">${obj.value.int3 }</td>
				<td  align="center">${obj.value.int4 }</td>
				<td  align="center"  rowspan="2">${obj.value.avg }</td>
			</tr>
			
			<tr>
				<th align="center">百分比</th>
				<td  align="center">${obj.value.double0 }%</td>
				<td  align="center">${obj.value.double1 }%</td>
				<td  align="center">${obj.value.double2 }%</td>
				<td  align="center">${obj.value.double3 }%</td>
				<td  align="center">${obj.value.double4 }%</td>
			</tr>
	</table>
	</c:forEach>
	</div>

</body>
</html>



