<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="courseScoreInputToolbar" style="padding: 5px; height: auto">
  <div class="panel-header"><div class="panel-title" align="center"> ${courseName }</div><div class="panel-tool"></div></div>
    <form id="courseScoreInputForm" method="post">
      <input type="hidden" id="courseId" value="${courseId }">
      <div><input name="scoreType" type="radio" class="easyui-validatebox" id="getCheck"
				  checked="checked" required="true" value="35001">按分数输入数字（0-100）（理论课程）平时成绩占
      		<select class="easyui-combobox" id="bl"
				data-options="editable:false,panelHeight:'auto'" style="width: 76px; height: 30px;">
				<option value="0">请选择</option>
				<option value="0.1">10%</option>
				<option value="0.2">20%</option>
				<option value="0.3">30%</option>
				<option value="0.4">40%</option>
				<option value="0.5">50%</option>
			</select>
			
      </div>
      
       <div><input name="scoreType" type="radio" class="easyui-validatebox"
				   required="true" value="35002">按等级输入（优秀，良好，中等，及格，不及格）（实践和实验课程）
      </div>
      
      <div style="margin-top:10px" >
			<span>考试日期：</span>	
			 <input class="easyui-datebox textbox" type="text"
                                   id="examDate" name="examDate"
                                   style="width: 150px; height: 30px; padding: 12px"
                                   data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false">

	      <a href="javascript:void(0)" style="margin-right:20px" 
	      class="easyui-linkbutton l-btn l-btn-small"  id="startInput">
	      <span class="l-btn-left"><span class="l-btn-text">开始录入</span></span></a>
      </div>
      
      </form>
  </div>
 <table id="tt"></table>
 <div style="text-align:center;margin: 15px;display: none" id="submitId">
	<a href="javascript:void(0)" style="margin-right:20px" class="easyui-linkbutton l-btn l-btn-small" onclick="submitCourseScore()" group="" id=""><span class="l-btn-left"><span class="l-btn-text">提交</span></span></a>
	<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-small"  group="" id="resetCourseScore"><span class="l-btn-left"><span class="l-btn-text">重置</span></span></a>
</div> 

</div>


<script type="text/javascript">
$(function(){
	var examNature=${examNatureList};
	var gradeList=${gradeList};

	var mycolumns1 = [[
	            	{field:'id',title:'ID',width:60},
	          		{field:'code',title:'学号',width:80,align:'center'},
	          		{field:'name',title:'姓名',width:100,align:'center'},
	          		{field:'usualScore',title:'平时',width:100,editor:'text'},
	          		{field:'examScore',title:'考试',width:100,editor:'text'},
	          		{field:'totalScore',title:'总评',width:100,editor:{type:'numberbox',options:{precision:1}}},
	          		{field:'examNature',title:'考试性质',width:300,align:'left',
	          			formatter:function(value,row,index){
	          				var text = "";
	          				for(var e in examNature){
	          					if(e == 0) {
	          						text += '<span style="margin-right: 20px;"><input type="radio" name="examNature' + index + '" checked="checked" value="'+examNature[e].id+'"/>' +examNature[e].name + '</span>'
	          					}else {
	          						text += '<span style="margin-right: 20px;"><input type="radio" name="examNature' + index + '" value="'+examNature[e].id+'"/>' +examNature[e].name + '</span>'
	          					}
	          				}
	          				return text;
	          			}
	          		}
	          	]];
	
	var mycolumns2 = [[
           		{field:'id',title:'ID',width:60},
         		{field:'code',title:'学号',width:80,align:'center'},
         		{field:'name',title:'姓名',width:100,align:'center'},
         		{field:'usualScore',title:'平时',width:100,formatter:function(value){
					for(var i=0; i<gradeList.length; i++){
						if (gradeList[i].id == value) return gradeList[i].name;
					}
						return value;
					},
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'name',
							data:gradeList,
							required:true
						}
					}
				},
         		{field:'examScore',title:'考试',width:100,formatter:function(value){
         			for(var i=0; i<gradeList.length; i++){
						if (gradeList[i].id == value) return gradeList[i].name;
					}
						return value;
					},
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'name',
							data:gradeList,
							required:true
						}
					}
				},
				{field:'totalScore',title:'总评',width:100,formatter:function(value){
         			for(var i=0; i<gradeList.length; i++){
						if (gradeList[i].id == value) return gradeList[i].name;
					}
						return value;
					},
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'name',
							data:gradeList,
							required:true
						}
					}
				},
         		{field:'examNature',title:'考试性质',width:300,align:'left',
         			formatter:function(value,row,index){
         				var text = "";
         				for(var e in examNature){
          					if(e == 0) {
          						text += '<span style="margin-right: 20px;" onclick="selectRadio(this)"><input type="radio" name="examNature' + index + '" checked="checked" value="'+examNature[e].id+'"/>' +examNature[e].name + '</span>'
          					}else {
          						text += '<span style="margin-right: 20px;" onclick="selectRadio(this)"><input type="radio" name="examNature' + index + '" value="'+examNature[e].id+'"/>' +examNature[e].name + '</span>'
          					}
          				}
         				return text;
         			}
         		},
				
         	]];
	
	
	$("#resetCourseScore").click(function(){
		$("#getCheck").attr("checked","checked");
		$.messager.confirm('请确认...','您确定要清除所有录入数据吗？',function(r){
			if(r) {
				$("#startInput").click();
			}
			
		})
		
	})
	
	
	$("#startInput").click(function(){
		
		var examDate = $("#examDate").textbox('getValue');
		 var scoreType = $('input[name="scoreType"]:checked').val();
		 var bl = parseFloat($("#bl").combobox('getValue'));
		 
		 $('#courseScoreInputForm').form('enableValidation').form('validate');
			//判断表单验证是否通过
		 if (!$('#courseScoreInputForm').form('validate')){
			 return false;
		 }
				
		 var columns = mycolumns1
		 if(scoreType == 35002) {
			columns = mycolumns2
			bl = 0;
		 }else {
			var bl = parseFloat($("#bl").combobox('getValue'));
			if(bl == 0) {
				 $.messager.alert("操作提示", "请选择要平时成绩比例","warning");
				 return;
			}
		 }
		 var param = {
			 courseId: $("#courseId").val(),
			 examDate: examDate,
		   	 scoreType: scoreType,
		   	 usualScoreRatio:bl
		   }
		 $('#tt').datagrid({
				iconCls:'icon-edit',
				width:'auto',
				height:'auto',
				singleSelect:true,
				idField:'id',
				url:'${contextPath}/edu/courseScoreStartInput.do',
				queryParams:param,
				onClickRow: onClickRow,
				columns:columns
			});
		    $("#submitId").show();
		    $('#teaCourseList').datagrid('reload');
		//    $("#courseScoreInputToolbar").hide()
		 
	})
	
		 
	
})

function selectRadio(obj){
//	var value1 = $('input[name="examNature0"]:checked').val()
//var value1 = $(obj).find("input[type='radio']").val();
//$('input[name="examNature0"]:checked').removeAttr("checked")

  // alert(value1)
//	$(obj).find("input[type='radio'][value=]").attr("checked",true);
//	$("input[name='examNature0']").each(function(i,o){
//		$(o).attr("checked",false)
//	})
	// $('input[name="examNature0"][value="'+value1+'"]').attr("checked",true)
//	$(obj).find('input[name="examNature0"]').attr("checked",true)
}

function onClickRow(index){
	/* for(var e=0;e<4;e++){
		$('#tt').datagrid('beginEdit',e );
	}  */
	 var scoreType = $('input[name="scoreType"]:checked').val();
	 $('#tt').datagrid('beginEdit',index );
	 var editors = $('#tt').datagrid('getEditors', index);   
	 var numberboxs = editors[0];
	 var examScore = editors[1]; 
	 var totalScore = editors[2]; 
	 if(scoreType == 35001) {
		 $(editors[0].target).focus()
		 totalScore.target.next('span').find('input[type="text"]').attr("disabled","disabled")
	 }else {
		 $(editors[2].target).combobox("setValue","40001")
		 $(editors[2].target).combobox("setText","优")
		 $(editors[0].target).combobox("setValue","40001")
		 $(editors[0].target).combobox("setText","优")
		 $(editors[1].target).combobox("setValue","40001")
		 $(editors[1].target).combobox("setText","优") 
	 }
	 
	
	 numberboxs.target.bind("blur",function(){
		/*  if(isNaN(numberboxs.target.val())) {
			 $.messager.alert("操作提示", "请输入数字1","warning");
		 } */
		 calculate(numberboxs,examScore,totalScore)
     }); 
  	
  	examScore.target.bind('blur', function(){
  		/* if(isNaN(examScore.target.val())) {
			 $.messager.alert("操作提示", "请输入数字","warning");
			 $(examScore.target).numberbox('setValue','');  
		} */
        calculate(numberboxs,examScore,totalScore)  
    });   
    
} 

function calculate(val1,val2,val3){
	var bl = parseFloat($("#bl").combobox('getValue'));
	if(!isNaN(val1.target.val()) && !isNaN(val2.target.val())) {
		var cost = val1.target.val() * bl + val2.target.val() * (1-bl);
		if(parseFloat(cost) > 0) {
			  $(val3.target).numberbox('setValue',cost);   
		}
	  
	}else {
		 $.messager.alert("操作提示", "请输入数字","warning");
	}
    
} 

function submitCourseScore() {
	$.post('edu/IsExistScore.do',{
        "courseId":$("#courseId").val()
      },function(data){
      	if(data == 1) {
      		$.messager.alert("操作提示", "课程班级成绩已经录入，请勿重复录入", "info");
      		
      	}else {
      		 var data=$('#tt').datagrid('getData');
      	     var counts = data.total;
      	     var numberboxs = new Array(counts);
      	     var examScores = new Array(counts);
      	     var totalScores = new Array(counts);
      	     var examNatures = new Array(counts);
      	     var studentIds = new Array(counts);
      	     var scoreType = $('input[name="scoreType"]:checked').val();
      	     for(var e=0;e<counts;e++){
      			 var editors = $('#tt').datagrid('getEditors', e);
      			 if(editors != null && editors != "") {
      				 if(scoreType == 35002) {
      					 numberboxs[e] = checkZero($(editors[0].target).combobox("getValue"));
      					 examScores[e] =checkZero($(editors[1].target).combobox("getValue"));
      					 totalScores[e] = checkZero($(editors[2].target).combobox("getValue"));
      					 examNatures[e] = checkZero($('input[name="examNature'+e+'"]:checked').val());
      				 }else {
      					 numberboxs[e] = checkZero(editors[0].target.val());
      					 examScores[e] = checkZero(editors[1].target.val());
      					 totalScores[e] = checkZero(editors[2].target.val());
      					 examNatures[e] = $('input[name="examNature'+e+'"]:checked').val();
      				 }
      				 
      			 }else {
      				 numberboxs[e] = 0
      				 examScores[e] = 0
      				 totalScores[e] = 0
      				 examNatures[e] = 0
      			 }
      			 
      			 studentIds[e]=$('#tt').datagrid('getRows')[e]['id'];
      		}
      		
      		var param = {"numberboxs":numberboxs,"examScore":examScores,"totalScore":totalScores,
      				"examNature":examNatures,"studentId":studentIds,"scoreType":scoreType,"teaCourseId":$("#courseId").val()}
      	 	$.post("${contextPath}/edu/addCourseScores.do", param, function(data) {
      	 		var resultJson=JSON.parse(data);
      	 		if(resultJson.result > 0) {
      	 			 $.messager.alert("操作提示", "提交成功","warning");
      	 			 closeTab(getCurrentTab());
      	 		}else {
      	 			$.messager.alert("操作提示", "提交失败","warning");
      	 		}
      		}); 
      	}
      })
	
	
 	
 	/* var userList = new Array()
	userList.push({id: 1,name: "123"});   
	userList.push({id: 2,name: "332"});   
    alert(typeof JSON.stringify(userList));
    alert(JSON.stringify(userList))
//	userList = eval("(" + userList + ")"); 
	 $.ajax({  
	    type: "POST",  
	    url: "${contextPath}/edu/addCourseScores.do",  
	    data: JSON.stringify(userList),
	    dataType:"json",  
	    contentType : 'application/json;charset=utf-8', //设置请求头信息  
	    success: function(data){  
	    } 
	});  */
}
	function checkZero(val) {
		if(val == "" || val == null || typeof(val) == "undefined") {
			return 0;
		}
		return val;
	}
  //设置专业信息下拉框的选择触发事件
  function selectMajor(){

      var id=$("#majorListForClass").combobox("getValue");
      if(id!=""){

        $.post('stu/getMajorFieldInfo.do',{
          "majorId":id
        },function(data){
          //返回的是string字符串，需要把字符串转成json对象
          var resultJson=JSON.parse(data);
          //添加一个下拉框元素"请选择"
          var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
          //使用unshift方法，在resultJson前面加上firstSelectJson
          resultJson.unshift(firstSelectJson);

          //加载专业方向下拉框数据
          $("#majorFieldListForClass").combobox({
            valueField:'id',
            textField:'name',
            data:resultJson,
            editable:false,
            disabled:false

          });
        });


      }else{
        //设置专业方向下拉框为不可选
        $("#majorFieldListForClass").combobox('disable');
        $("#majorFieldListForClass").combobox('loadData',{});
        $("#majorFieldListForClass").combobox('setValue','');
      }

  }


  

  function toEditClass() {
    var row = $('#classList').datagrid('getSelected');
    if (row) {
      if ($('#main').tabs('exists', '编辑班级信息')) {
        $('#main').tabs('close', '编辑班级信息')
      }
      openTab('stu/toEditClass.do?id=' + row.id, '编辑班级信息');


    }else{
      $.messager.alert("操作提示", "请选择要编辑的班级！","warning");
    }
  }

  function deleteClass(){
    var row = $('#classList').datagrid('getSelected');
    if (row){

      $.messager.confirm('请确认...','您确定要删除此班级吗?',function(r){
        if (r){
          $.messager.confirm('请再次确认...','删除班级可能会导致数据混乱！',function(r){
            if(r){
              $.post('stu/deleteClass.do',{id:row.id},function(result){
                if (result.success){
                  $('#classList').datagrid('reload');    // reload the user data
                } else {
                  $.messager.show({    // show error message
                    title: 'Error',
                    msg: '删除班级失败'
                  });
                }
              },'json');
            }
          });

        }
      });
    }else{
      $.messager.alert("操作提示", "请选择要删除的班级！","warning");
    }
  }

  function cleanSearch(toolbar){
   $(toolbar).find("#classListName").val("");
    $(toolbar).find("#classListGradeName").val("");
    $(toolbar).find("#majorListForClass").combobox('select',"");
    $(toolbar).find("#classListTeacherName").val("");
  }
</script>
