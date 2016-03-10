<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<link rel="stylesheet"
	href="${contextPath}/css/edu/queryScoreByCoursePlan.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
  $(function(){
	  $.messager.alert("温馨提示","需要打印时，请将纸张打印方向设置为横向打印！","info");
  })
  
 /*  window.onload=function(){
  factory.printing.header=""
  factory.printing.footer=""
  factory.printing.portrait=false //纸的方向 纵向
  factory.printing.leftMargin =0
  factory.printing.topMargin =0
  factory.printing.rightMargin=0
  factory.printing.bottomMargin=0
  } */
</script>
</head>

<body>
	<c:if test="${courseCount>=1 }">
		<c:set var="studyYear"
			value="${courseToQueryScoByHTList[0].studyYearStr }" />
		<c:set var="termType"
			value="${courseToQueryScoByHTList[0].termTypeStr }" />
	</c:if>


	<div class="center" style="height: 15px; margin-top: 3px;">
		<a href="javascript:void(0)"
			style="postion: absolute; font-size: 15px; float: right;"
			onclick="$('#edu_stuScoreOfCP_print_region').jqprint()">打印</a>
	</div>
	<div class="center" id="edu_stuScoreOfCP_print_region">
		<table class="head_scoreByCp">
			<tr>
				<td>${studyYear }&nbsp;${termType }&nbsp;${className }班成绩汇总表</td>
			</tr>
		</table>
		<table id="scoreTableWithCP">
			<tr>
				<th class="width" align="center" rowspan="2"
					style="text-align: center; font-size: 15px;">学号</th>
				<th class="width" align="center" rowspan="2"
					style="text-align: center; font-size: 15px;">姓名</th>
				<c:if test="${courseCount>=1}">
					<c:forEach var="i" begin="0" end="${courseCount-1}">
						<th align="center" width="${80/courseCount }%">${courseToQueryScoByHTList[i].courseCode }</th>
					</c:forEach>
				</c:if>
			</tr>
			<tr>
				<c:if test="${courseCount>=1}">
					<c:forEach var="i" begin="0" end="${courseCount-1}">
						<th align="center" width="${80/courseCount }%">${courseToQueryScoByHTList[i].courseName }</th>
					</c:forEach>
				</c:if>
			</tr>
			<c:forEach items="${studentList}" var="stu" varStatus="vs">
				<tr>
					<td class="width">${stu.code }</td>
					<td class="width">${stu.name }</td>
					<c:if test="${courseCount>=1}">
						<c:forEach var="i" begin="0" end="${courseCount-1}">
							<c:set var="key"
								value="${stu.code }${courseToQueryScoByHTList[i].courseId }" />
							<td align="center" width="${80/courseCount }%"><c:out
									value="${scoreMap.get(key) }" /></td>
						</c:forEach>
					</c:if>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>



