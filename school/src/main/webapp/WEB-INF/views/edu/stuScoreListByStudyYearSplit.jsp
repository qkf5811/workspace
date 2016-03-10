<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${contextPath}/css/edu/stuScoreListByStudyYearSplit.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>

<div id="edu_stuInfoDiv_byYearAndTerm">
<div style="width:530px;height:20px;padding-top:10px;"><a href="javascript:void(0)" style="font-size:14px;float:right;" onclick="$('#edu_stuScoreYearAndTerm_print_region').jqprint()">打印</a></div>

<div id="edu_stuScoreYearAndTerm_print_region">
 
<table id="edu_stuInfoTable">
   <tr>
     <td colspan="3" style="font-size:14px;text-align:center;font-weight:bold;padding-bottom:15px;">幼师学生成绩表</td>   
   </tr>
   <tr>
       <td>学号:${studentInfo.studentCode}</td>
       <td>姓名:${studentInfo.studentName}</td>
       <td>性别:${studentInfo.sexName}</td>
   </tr>

   <tr>
       <td>所在年级:${studentInfo.gradeName}</td>
       <td>班别:${studentInfo.className}</td>
       <td>专业名称:${studentInfo.majorName}</td>
   </tr>
   
   <tr>
       <td colspan="3">专业方向:${studentInfo.majorFieldName}</td>
   </tr>
</table>  
 
  <c:forEach items="${yearAndTermList}" var="yearAndTermResult">
    <table class="edu_gridtable_byYearAndTerm">
    <tr><td colspan="3" style="text-align:center;border:0px">${yearAndTermResult.study_year}&nbsp&nbsp&nbsp${yearAndTermResult.term_name}</td></tr>
    <tr align=center >
      <th width="100px">课程代号</th>
      <th width="200px">课程名称</th>
      <th width="80px">成绩</th>
    </tr>
     
    <c:forEach items="${scoreList}" var="scoreResult">
      <c:if test="${yearAndTermResult.study_year==scoreResult.studyYear}">
        <c:if test="${yearAndTermResult.term_name==scoreResult.termName}">
        <tr align=center>
          <td>${scoreResult.courseCode}</td>
          <td>${scoreResult.courseName}</td>
          <td>${scoreResult.totalScore}</td>  
        </tr>
        </c:if>
      </c:if>  
    </c:forEach>
     </table>
  </c:forEach>  

</div>
</div>