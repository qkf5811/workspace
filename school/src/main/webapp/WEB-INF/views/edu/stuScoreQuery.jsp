<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#edu_stuScoreQuery_div div{
    margin-top:20px;
}

#edu_stuScoreQuery_div div a{
   margin:10px;
}
</style>


<div id="edu_stuScoreQuery_div" style="text-align:center;margin-top:80px;">
  <div style="font-size:16px;font-weight:bold;margin-top:50px;">学生个人成绩查询</div>	
  <div>
    <span style="font-size:16px;">学号：</span><input class="easyui-textbox" id="studentCode" name="studentCode"/>
  </div>
  <div>
     <a href="javascript:void(0)" class="easyui-linkbutton" onclick="f_submit(0,'学生成绩列表')">学生成绩列表</a>   
      <a href="javascript:void(0)" class="easyui-linkbutton" onclick="f_submit(1,'按学年、学期汇总')">按学年、学期汇总</a>
  </div>
</div> 

<script>
function f_submit(data,title){
	var myUrl;
	var studentCode;
	
	studentCode=$("#edu_stuScoreQuery_div").find("#studentCode").val();
	
	if(data==0){
		myUrl="edu/getStuCourseScoreList.do?splitByStudyYear=0&studentCode="+studentCode;
	}else if(data==1){
		myUrl="edu/getStuCourseScoreList.do?splitByStudyYear=1&studentCode="+studentCode;
	}
  
	if(studentCode==""){
		$.messager.alert("操作提示", "请先输入学号!", "warning");
		return;
	}
	
	$.post("edu/isExistStudentCode.do?studentCode="+studentCode,function(result){		
		var data;
		data=$.parseJSON(result);
		if(data.msg){
		   $.messager.alert("操作提示",data.msg, "warning")
		}else{
		   openTab(myUrl, title);
		}   
	});

}

</script>