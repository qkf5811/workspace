<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
	.item {
		text-align:right;
		padding-right:10px;
	}
</style>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="conEduItem">
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
                    <td class="item">教师姓名:</td>
			            <td><input id="name" class="easyui-validatebox textbox" 
			                        		  name="name" value="${dto.name }" readonly="true"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			         </td>
			</div>
			</tr>
			<tr>
                <div style="margin-bottom: 20px">
                    <td class="item">课程类型:</td>
                       	 <td><select class="easyui-combobox" 
					name="editCourseType"  id="editCourseType"
					validtype="selectRequired['editCourseType']"
					data-options="editable:false,panelHeight: 'auto',novalidate:true" style="height:30px">
					<option value="0">请选择</option>
					<c:forEach items="${cList }" var="c">
						<option value="${c.id }">${c.name }</option>
					</c:forEach>
					</select>
                    </td>
                </div>
            </tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td class="item">课程名称:</td>
			           <td><input id="courseName" class="easyui-validatebox textbox" 
			                        		  name="courseName" value="${dto.courseName }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			</tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td class="item">施教机构:</td>
			            <td><input id="teachOrganization" class="easyui-validatebox textbox" 
			                        		  name="teachOrganization" value="${dto.teachOrganization }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			</tr>
           	<tr>
           	 <div style="margin-bottom: 20px">
                    <td class="item">开始时间:</td>
			          <td><input id="startDateStr" class="easyui-datebox" 
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
                    <td class="item">学时:</td>
			          <td><input id="studyHours" class="easyui-validatebox textbox" 
			                        		  name="studyHours" value="${dto.studyHours }"
			                                  style="width: 200px; height: 18px; padding: 5px"
			                                  data-options="required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">备注信息:</td>
			           <td> <input id="remark" class="easyui-validatebox textbox" 
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
           onclick="updateConEduInfo('#conEduItem')">修改</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
 
</div>

<script>
	function updateConEduInfo(form){
		//在提交数据之前执行表单验证
		$('#conEduItem').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
  
		$.post('tea/editTeaConEduItem.do',{
			"id" : $(form).find('#id').val(),
			"teacherId" : $(form).find('#teacherId').val(),
			"courseType" : $(form).find('#editCourseType').combobox('getValue'),
			"courseName" : $(form).find('#courseName').val(),
			"teachOrganization": $(form).find('#teachOrganization').val(),
			"startDate" : $(form).find('#startDateStr').datebox('getValue'),
			"endDate" : $(form).find('#endDateStr').datebox('getValue'),
			"studyHours" : $(form).find('#studyHours').val(),
			"remark" : $(form).find('#remark').val()
		},function(data){
			if (data.result > 0){
				closeTab(getCurrentTab());
				$('#teaConEduList').datagrid('reload');
			} else{
				$.messager.alert("操作提示","修改失败","warning");
			}
		},'json');
	}
	
	function clearForm(){
		$('#courseName').val('');
		$('#teachOrganization').val('');
		$('#startDateStr').datebox('setValue','');
		$('#endDateStr').datebox('setValue','');
		$('#studyHours').val('');
		$('#remark').val('');
		$('#editCourseType').combobox('select',0);
	}