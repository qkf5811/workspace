<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
#scoreTableWithTC {
	font-family:verdana,arial,sans-serif;
	width: 50%;
	border-collapse: collapse;
	margin-top:10px;
}

#scoreTableWithTC td, #scoreTableWithTC th {
	font-size: 1em;
	border: 1px solid #666666;
	padding: 3px 7px 2px 7px;
}

#scoreTableWithTC th {
	font-size: 1.1em;
	text-align: center;
	padding-top: 5px;
	padding-bottom: 4px;
	background-color: #DDDDDD;
	color: #333333;
}


</style>
</head>

<body>
<div align="center">
	<table style="width: 50%; border-collapse: collapse; margin-top: 10px;">
       <tr>
           <td align="center" style="font-size: 18px;">${courseName }</td>
       </tr>
       <tr>
           <td align="center" style="font-size: 10px">${courseCode }</td>
       </tr>
	</table>
	<table id="scoreTableWithTC">
		<tr>
			<th align="center" width="20%">学号</th>
			<th align="center" width="20%">姓名</th>
			<th align="center" width="20%">成绩</th>
			<th align="center" width="20%">学年</th>
			<th align="center">学期</th>
		</tr>
		<c:forEach items="${studentList}" var="stu" varStatus="vs">
		   <tr>
				<td align="center">${stu.code }</td>
				<td align="center">${stu.name }</td>
				<td align="center">${scoreList[vs.index] }</td>
				<td align="center">${studyYear }</td>
				<td align="center">${termType }</td>
			</tr>
		</c:forEach>

	</table>
	
</div>	
</body>
</html>



