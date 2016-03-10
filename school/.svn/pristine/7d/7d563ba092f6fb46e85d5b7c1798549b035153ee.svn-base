<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${contextPath}/css/edu/scoreListByCourse.css" />
<script src="${contextPath}/js/jquery.jqprint-0.3.js"></script>

<div id="stuScoreByCourse_div">
      <div style="width:630px;height:20px;padding-right:50px;margin-top:10px;"><a href="javascript:void(0)" style="postion:absolute;font-size:14px;float:right;" onclick="$('#edu_stuScoreByCourse_print_region').jqprint()">打印</a></div>
      <div id="edu_stuScoreByCourse_print_region"> 
          <div style="font-size:14px;text-align:center;font-weight:bold;padding-bottom:15px;border:0px">
                                    幼师学生成绩表
          </div>
          <div style="text-align:left;padding-bottom:5px;padding-left:50px;">
             <span style="display: inline-block;width:150px;">课程名称：${courseInfoMap.get("courseName")}</span>
             <span style="display: inline-block;width:150px;">课程代号：${courseInfoMap.get("courseCode")}</span>
             <span style="display: inline-block;width:150px;">班别：${courseInfoMap.get("className")}</span>
          </div>
          <div style="text-align:left;padding-bottom:5px;padding-left:50px;">   
             <span style="display: inline-block;width:150px;">学年：${courseInfoMap.get("studyYear")}</span>
             <span style="display: inline-block;width:150px;">学期：${courseInfoMap.get("termName")}</span>
          </div>
       <div>   
       <table class="stuScoreByCourse_list" style="margin-left:5%;border-right-style:none;border-right:0px;border-right-width:0px;">
          <tr align=center>
             <th width="100px">学号&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp姓名</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">平时成绩</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">考核成绩</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">总评成绩</th>
          </tr>
          
          <c:if test="${listHalfSize==null || listHalfSize=='' || listHalfSize==0}">
             <c:set var="listHalfSize" value="0"></c:set>
          </c:if>
          <c:if test="${listHalfSize>0}">
             <c:set var="listHalfSize" value="${listHalfSize-1}"></c:set>
          </c:if>
          <c:forEach items="${scoreList}" var="result" varStatus="status" begin="0" end="${listHalfSize}">
          <tr align=center>
             <td>${result.studentCode}&nbsp&nbsp${result.studentName}</td>
             <td>${result.usualScore}</td>
             <td>${result.examScore}</td>
             <td style="border-left-width: 0px;">${result.totalScore}</td>
          </tr>
          </c:forEach>
       </table>
       
       <table id="stuScoreByCourse_list2" class="stuScoreByCourse_list">
          <tr align=center>
             <th width="100px">学号&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp姓名</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">平时成绩</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">考核成绩</th>
             <th width="26px" style="line-height:1.2;word-wrap:break-word;padding:2px 20px;">总评成绩</th>
          </tr>
       
          <c:forEach items="${scoreList}" var="result" varStatus="status" begin="${listHalfSize+1}">
          <tr align=center>
             <td>${result.studentCode}&nbsp&nbsp${result.studentName}</td>
             <td>${result.usualScore}</td>
             <td>${result.examScore}</td>
             <td>${result.totalScore}</td>
             <!-- 如果总行数的最后一行为奇数，则补一行空白行 -->
             <c:if test="${status.last && status.index%2==0}">
                <tr>
                  <!-- padding:9px 0px;对平左边表格 -->
                  <td style="padding:9px 0px;"></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
             </c:if>
          </tr>
          </c:forEach>
          
       </table>
       </div>
      
       <div style="width:614px;height:100px;padding-top:10px;margin-left:5%;clear:both;">
       <div style="margin:5px;"><span>任课教师签字：__________</span><span>考试日期：__________</span></div>
       <c:if test="${scoreRegionMap.get('score_type')==35001 || scoreRegionMap.get('score_type')!=35002}">
       <table class="scoreRegion_table" >
           <tr>
               <td rowspan="3" style="width:40px;padding:0px 40px;word-wrap:break-word;">总评成绩统计</td>
               <td>90~100</td>
               <td>${scoreRegionMap.get("A")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Apercent")}%</td>
               <td>60~69</td>
               <td>${scoreRegionMap.get("D")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Dpercent")}%</td>
           </tr>
           <tr>
               <td>80~89</td>
               <td>${scoreRegionMap.get("B")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Bpercent")}%</td>
               <td>60分以下</td>
               <td>${scoreRegionMap.get("E")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Epercent")}%</td>
           </tr>
           <tr>
               <td>70~79</td>
               <td>${scoreRegionMap.get("C")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Cpercent")}%</td>
               <td>平均成绩</td>
               <td>${scoreRegionMap.get("averageScore")}</td>
               <td></td>
           </tr>
           <tr>
               <td style="text-align:center">备注</td>
               <td colspan="6" ></td>
           </tr>
       </table>
       </c:if>
      
       <c:if test="${scoreRegionMap.get('score_type')==35002}">
       <table class="scoreRegion_table" >
           <tr>
               <td rowspan="3" style="width:40px;padding:0px 40px;word-wrap:break-word;">总评成绩统计</td>
               <td>优</td>
               <td>${scoreRegionMap.get("A")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Apercent")}%</td>
               <td>及格</td>
               <td>${scoreRegionMap.get("D")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Dpercent")}%</td>
           </tr>
           <tr>
               <td>良</td>
               <td>${scoreRegionMap.get("B")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Bpercent")}%</td>
               <td>不及格</td>
               <td>${scoreRegionMap.get("E")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Epercent")}%</td>
           </tr>
           <tr>
               <td>中</td>
               <td>${scoreRegionMap.get("C")}人</td>
               <td>占&nbsp${scoreRegionMap.get("Cpercent")}%</td>
               <td></td>
               <td></td>
               <td></td>
           </tr>
           <tr>
               <td style="text-align:center">备注</td>
               <td colspan="6" ></td>
           </tr>
       </table>
       </c:if>
    
       </div>
    </div>
</div>


 