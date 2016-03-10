<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
	.item {
		text-align:right;
		padding-right:10px;
	}
</style>	
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="resumeEditItem">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师编号:</td>
                       	<td><input id="code" class="easyui-validatebox textbox" 
                       	 			name="code" value="${dto.code }" readonly="true"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true">
                    </td>
                </div>
            </tr>
            <tr>
            <div style="margin-bottom: 20px">
                    <td class="item"> 教师姓名:</td>
			            <td><input id="name" class="easyui-validatebox textbox" 
			                        		  name="name" value="${dto.name }" readonly="true"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			         </td>
			</div>
			</tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td class="item">教师职称:</td>
			            <td><input id="position" class="easyui-validatebox textbox" 
			                        		  name="position" value="${dto.position }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			</tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td class="item">单位名称:</td>
			         <td>  <input id="workPlace" class="easyui-validatebox textbox" 
			                        		  name="workPlace" value="${dto.workPlace }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			</tr>
           	<tr>
           	 <div style="margin-bottom: 20px">
                    <td class="item">开始时间:</td>
			        <td> <input id="startDateStr" class="easyui-datebox" 
			                        		  name="startDateStr" value="${dto.startDateStr }"
			                                  style="width: 210px; height: 31px; padding: 5px" 
			                                  data-options="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                      <!--  
			           <img onclick="WdatePicker({el:'startDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			                    -->              
			                    </td>
			                </div>
			</tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td class="item">结束时间:</td>
			         <td><input id="endDateStr" class="easyui-datebox" 
			                        		  name="endDateStr" value="${dto.endDateStr }"
			                                  style="width: 210px; height: 31px; padding: 5px" 
			                                  data-options="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
					<!--  
					<img onclick="WdatePicker({el:'endDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			 	   -->
			 	    </td>
	            </div>
			</tr>
			<tr>
                <div style="margin-bottom: 20px">
                    <td class="item">调动原因:</td>
			           <td><input id="transferCause" class="easyui-validatebox textbox" 
			                        		  name="transferCause" value="${dto.transferCause }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">备注信息:</td>
			            <td><input id="remark" class="easyui-validatebox textbox" 
			                        		  name="remark" value="${dto.remark }"
			                                  style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			            </tr>
			  <tr>
			 	<div style="margin-bottom: 20px;">
			 		<td>
			 			<input type="hidden" id="id" name="id" value="${dto.id }">
			 		</td>
			 	</div>
			 </tr>
			  <tr>
			 	<div style="margin-bottom: 20px;">
			 		<td>
			 			<input type="hidden" id="teacherId" name="teacherId" value="${dto.teacherId }">
			 		</td>
			 	</div>
			 </tr>
        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="updateResumeInfo('#resumeEditItem')">修改</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
 
</div>

<script>
	function updateResumeInfo(form){
		//在提交数据之前执行表单验证
		$('#resumeEditItem').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
    	/*
		var params = {
			
			
		};*/
		//alert((params));
		$.post('tea/updateResumeItem.do',{
			"id" : $(form).find('#id').val(),
			"teacherId" : $(form).find('#teacherId').val(),
			"position" : $(form).find('#position').val(),
			"workPlace" : $(form).find('#workPlace').val(),
			"startDate" : $(form).find('#startDateStr').datebox('getValue'),
			"endDate" : $(form).find('#endDateStr').datebox('getValue'),
			"transferCause" : $(form).find('#transferCause').val(),
			"remark" : $(form).find('#remark').val()
		},function(result){
			if (result.success > 0){
				closeTab(getCurrentTab());
				$.messager.alert('操作提示',"修改成功！",'info');
				$('#resumeList').datagrid('reload');
			}
		},'json');
	}
	
	function clearForm(){
		$('#position').val('');
		$('#workPlace').val('');
		$('#startDateStr').datebox('setValue','');
		$('#endDateStr').datebox('setValue','');
		$('#transferCause').val('');
		$('#remark').val('');
		//$("#resumeEditItem").form('clear');
	}
</script>