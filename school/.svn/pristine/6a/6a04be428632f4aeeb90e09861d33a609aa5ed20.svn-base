<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
#students {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 50%;
	border-collapse: collapse;
	margin-top:5px;
	margin-left: 20px;
}

#students td, #students th {
	font-size: 1em;
	border: 1px solid #98bf21;
	padding: 3px 7px 2px 7px;
}

#students th {
	font-size: 1.1em;
	text-align: center;
	padding-top: 5px;
	padding-bottom: 4px;
	background-color: #A7C942;
	color: #ffffff;
}

#students tr.alt td {
	color: #000000;
	background-color: #EAF2D3;
}
</style>
</head>

<body>
<div align="center">
	<table style="width: 50%; border-collapse: collapse; margin-top: 10px; margin-left: 20px;">
       <tr>
           <td align="center" style="font-size: 18px;">班级学生列表</td>
       </tr>
       <tr>
           <td align="right" style="font-size: 12px">注：选择其中一个学生可查询其所有课程成绩</td>
       </tr>
	</table>

	<table id="students">
		<tr>
			<th align="center" width="50%">学号</th>
			<th align="center">姓名</th>
		</tr>
		<c:forEach items="${studentList}" var="stu" varStatus="vs">
		 <c:if test="${vs.index%2==0 }">
			<tr>
				<td align="center">${stu.code }</td>
				<td align="center">
				    <a href="javascript:void(0)" onclick="openTab('edu/getStuCourseScoreList.do?splitByStudyYear=1&studentCode='+${stu.code },'学生个人成绩列表')">${stu.name }</a>
				</td>
			</tr>
		 </c:if>
		 <c:if test="${vs.index%2==1 }">
			<tr class="alt">
				<td align="center">${stu.code }</td>
				<td align="center">
				    <a href="javascript:void(0)" onclick="openTab('edu/getStuCourseScoreList.do?splitByStudyYear=1&studentCode='+${stu.code },'学生个人成绩列表')">${stu.name }</a>
				</td>
			</tr>
		 </c:if>
		</c:forEach>

	</table>
	
</div>	
</body>
</html>




