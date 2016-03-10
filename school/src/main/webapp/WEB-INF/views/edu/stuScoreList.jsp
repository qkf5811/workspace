<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${contextPath}/css/edu/stuScoreList.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>

<div id="stuInfoDiv_list">
   <div style="width:650px;height:20px;padding-right:50px;margin-top:10px;"><a href="javascript:void(0)" style="postion:absolute;font-size:14px;float:right;" onclick="$('#edu_stuScore_print_region').jqprint()">打印</a></div>
     <div id="edu_stuScore_print_region">  
     <table id="edu_gridtable_list">
     <tr>
        <td colspan="5" style="font-size:14px;text-align:center;font-weight:bold;padding-bottom:15px;border:0px"">幼师学生成绩表</td>
     </tr>
  <tr align=center >
   <th width="100px">学年</th>
   <th width="80px">学期</th>
   <th width="100px">课程代号</th>
   <th width="180px">课程名称</th>
   <th width="60px">成绩</th>
  </tr>
  <c:forEach items="${scoreList}" var="result">
   <tr align=center>
    <td>${result.studyYear}</td>
    <td>${result.termName}</td>
    <td>${result.courseCode}</td>
    <td>${result.courseName}</td>
    <td>${result.totalScore}</td>  
   </tr>
  </c:forEach>
 </table>
</div>
</div>
 