<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<style type="text/css">

.item {
		text-align:right;
		padding-right:10px;
	}

</style>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="teaConEduInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师编号:</td>
                       <td><input id="code" class="easyui-textbox textbox" name="code"
                                    style="width: 212px; height: 32px; padding: 5px" 
                                    data-options="buttonText:'选择',buttonIcon:'icon-search',
                                    editable:false,required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                    </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师姓名:</td>
                       	 <td><input id="name" class="easyui-validatebox textbox" name="name"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    readonly="true"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                </div>
            </tr>
              <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">课程名称:</td>
                       <td><input id="courseName" class="easyui-validatebox textbox" name="courseName"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                </div>
            </tr>
       
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 课程类型:</td>
                       <td><select id="eduCourseType" name="eduCourseType" class="easyui-combobox"
                                  	 validtype="selectRequired['eduCourseType']" style="height:31px;width:100px"
                                     data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
                               <option value="0">请选择</option>  
                        <c:forEach var="c" items="${cList}">
                            <option value="${c.id }">${c.name}</option>
                        </c:forEach>
                    </select>
                    </td>
                </div>
            </tr>
           	<tr>
            	<div style="margin-bottom: 20px">
                    <td class="item"> 	施教机构:</td>
                      <td><input id="teachOrganization" class="easyui-validatebox textbox" name="teachOrganization"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                </div>
       		</tr>
       			<tr>
           	 <div style="margin-bottom: 20px">
                    <td class="item">开始时间:</td>
			          <td><input id="startDateStr" class="easyui-datebox" 
			                        		  name="startDateStr" 
			                                  style="width: 210px; height: 31px; padding: 5px"
			                                  data-options="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                                  <!--  
			           <img onclick="WdatePicker({el:'startDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			                     -->             
			                    </td>
			                </div>
			</tr>
			
           <!--  <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">开始日期:</td>
			            <td><input id="startDateStr" class="easyui-datebox" name="startDateStr"
			                     style="width: 210px; height: 31px; padding: 5px" 
			                     data-option="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                  
			                 
			                  <img onclick="WdatePicker({el:'startDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			                
			                    </td>
			                </div>
		  </tr> -->
		  
		  <tr>
            <div style="margin-bottom: 20px">
                    <td class="item">结束时间:</td>
			               <td><input id="endDateStr" class="easyui-datebox" 
			                        		  name="endDateStr"
			                                  style="width: 210px; height: 31px; padding: 5px"
			                                  data-options="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                                  <!--  
					<img onclick="WdatePicker({el:'endDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			 	   -->
			 	    </td>
	            </div>
			</tr>
		 <!--  <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">结束日期:</td>
			                  <td><input id="endDateStr" class="easyui-datebox" name="endDateStr"
			                     style="width: 210px; height: 31px; padding: 5px"  
			                     data-option="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                     
			                  <img onclick="WdatePicker({el:'endDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			                    
			                    </td>
			                </div>
		  </tr> -->
		   <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">学时:</td>
                       	<td><input id="studyHours" class="easyui-validatebox textbox" name="studyHours"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">备注信息:</td>
			            <td><input id="remark" class="easyui-validatebox textbox" name="remark"
			                     style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
		  </tr>
			<tr>
			   <div style="margin-bottom: 20px">
			   	<td>
                	<input type="hidden" id="teacherId" name="teacherId">
                </td>
                </div>
            </tr>
        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="addTeaConEduInfo('#teaConEduInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>



<!-- 弹出教职工列表窗口 -->
	<div id="conEduWindow" class="easyui-window" title="教职工列表" 
	data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:450px;padding:5px;">
		<div id="conEduToolbar" style="padding: 5px; height: auto">
		<div>
			<td>教师姓名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			
			<td>教师编号:</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchConEduList('#conEduToolbar', '#allTeaConEdu')"
				iconCls="icon-search">查询</button>
		</div> 
	</div>
	<table id="allTeaConEdu" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getAllTeaContinuingEdu.do"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">

	<thead>
		<tr>
			<th field="code" width="150" align="center">教师编号</th>
			<th field="name" width="150" align="center">教师姓名</th>
			<th field="nowPosition" width="150" align="center">职位</th>
		</tr>
	</thead>
</table>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addTeaConEduItem()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#conEduWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
<!-- 弹出窗口结束 -->

<script type="text/javascript">

	$(function(){
		$("#teaConEduInfo").find("#code").textbox({
			onClickButton : function() {
				//alert("xxx");
				$('#conEduWindow').window('open');
			}
		});
	})
    function addTeaConEduInfo(form){
    	//在提交数据之前执行表单验证
		$('#teaConEduInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
    	var teacherId = $(form).find('#teacherId').val();
        var eduCourseType = $(form).find('#eduCourseType').combobox('getValue');
     	var courseName = $(form).find('#courseName').val();
        var startDateStr = $(form).find('#startDateStr').datebox('getValue');
        var endDateStr = $(form).find('#endDateStr').datebox('getValue');
        var teachOrganization = $(form).find('#teachOrganization').val();
        var studyHours = $(form).find('#studyHours').val();
        var remark = $(form).find('#remark').val();
        
        $.post("tea/addTeaConEduItem.do",{
            "teacherId"    : teacherId,
            "courseType" : eduCourseType,
            "courseName" : courseName,
            "startDate" : startDateStr,
            "endDate" : endDateStr,
    		"teachOrganization" : teachOrganization,
            "studyHours" : studyHours,
            "remark"  : remark
        },function(data){
        	if (!(data.result < 0)){
        		closeTab(getCurrentTab());
	            $.messager.alert("操作提示", "添加信息成功！","info");
	            $('#teaConEduList').datagrid('reload');
        	} else{
        		$.messager.alert("操作提示", "添加信息失败！","error");
        	}
        },'json')
    }
	
    function clearForm() {
        $("#teaConEduInfo").form('clear');
        $('#eduCourseType').combobox('select',0);
    }
    
    function searchConEduList(toolbar,datagrid){
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();
		$("#allTeaConEdu").datagrid('load',{
			"name" : name,
			"code" : code
		});
	}
    
    function addTeaConEduItem(){
    	var row = $('#allTeaConEdu').datagrid('getSelected');
    	if (row){
    		$('#teaConEduInfo').find('#code').textbox('setValue',row.code);
    		$('#teaConEduInfo').find('#name').val(row.name);
    		$('#teaConEduInfo').find('#teacherId').val(row.id);
    		$('#conEduWindow').window('close');
    	}
    }
</script>