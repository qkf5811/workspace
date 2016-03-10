<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="punishmentStuInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	学生学号:<input id="code" class="easyui-textbox textbox" name="code"
                                    style="width: 212px; height: 32px; padding: 5px"
                                    data-options="buttonText:'选择',buttonIcon:'icon-search',
                                    editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
                    		
                    </td>
                    <!--  
                     <td>
                		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#punishmentStuWindow').window('open');">在籍学生列表</a>
               		 </td>
               		-->
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                        学生姓名:<input id="name" class="easyui-validatebox textbox" readonly="true"
			                        name="name" style="width: 200px; height: 18px; padding: 5px"
			                        data-options="editable:false,required:true,missingMessage:'该处未填写',novalidate:true">
			                    </td>
			                </div>
			            </tr>
			          <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	 学生班级:<input id="className" class="easyui-validatebox textbox" name="className"
                                    style="width: 200px; height: 18px; padding: 5px" readonly="true"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    		
                    </td>
                </div>
            </tr>       
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	 惩罚类型:<select id="addPunishmentType" name="addPunishmentType" class="easyui-combobox"
                                    validtype="selectRequired['addPunishmentType']" style="height:30px;width:100px"
                                    data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
                               <option value="0">请选择</option>
                        <c:forEach var="p" items="${punishmentType}">
                            <option value="${p.id }">${p.name}</option>
                        </c:forEach>
                       
                    </select>
                    
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                    	惩罚内容:<textarea id="content" cols="50" rows="5" name="content"
                                       class="easyui-validatebox textbox"
                                       style="padding: 5px"
                                       data-options="required:true,missingMessage:'该处未填写',novalidate:true" ></textarea>
                  
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                        备注信息:<input id="remark" class="easyui-validatebox textbox" 
			                        name="remark" style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			            </tr>
			            
			  <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                    <input type="hidden" id="studentId" name="studentId">
			                    </td>
			                </div>
			            </tr>
			            <!--  
			     <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                    <input type="hidden" id="id" name="id">
			              </td>
			                </div>
			            </tr>
			            -->
        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="addpunishmentStuInfo('#punishmentStuInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>

<!-- 弹出所有学生列表 -->
	<div id="punishmentStuWindow" class="easyui-window" title="在籍学生列表" 
		data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:450px;padding:5px;">
		<div id="punishmentListToolbar" style="padding: 5px; height: auto">
		<div>
		<td>学生学号:</td>
				<td><input class="easyui-validatebox textbox" id="stuCode2"
					name="stuCode2" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<td>学生姓名:</td>
				<td><input class="easyui-validatebox textbox" id="stuName2"
					name="stuName2" 
					style="width: 100px; height: 18px; padding: 5px" />
					
			</td>
			
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchPunishment('#punishmentListToolbar', '#allStuPunishmentList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="allStuPunishmentList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/stu/getAllPunishmentList.do" toolbar="#punishmentListToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="150" align="center">学号</th>
				<th field="name" width="150" align="center">姓名</th>
				<th field="className" width="150" align="center">班级</th>
			</tr>
		</thead>
	</table>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addStudentInfo()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#punishmentStuWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
	

<script type="text/javascript">

	$(function(){
		$("#punishmentStuInfo").find("#code").textbox({
			onClickButton : function() {
				$('#punishmentStuWindow').window('open');
			}
		});
	})

    function addpunishmentStuInfo(form){
    	//在提交数据之前执行表单验证
		$('#punishmentStuInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
        var studentId = $(form).find('#studentId').val();
        //alert(student_id);
        var addPunishmentType = $(form).find('#addPunishmentType').combobox('getValue');
        var content = $(form).find('#content').val();
        var remark = $(form).find('#remark').val();
        $.post("stu/addPunishmentInfo.do",{
            "studentId"  	  : studentId,
            "punishmentType"  : addPunishmentType,
            "content"         : content,
            "remark"          : remark
        },function(data){
        	if (!(data.result < 0)){
        		closeTab(getCurrentTab());
	            $.messager.alert("操作提示", "添加信息成功！","info");   
	            $('#punishmentList').datagrid('reload');
        	} else{
        		$.messager.alert("操作提示", "添加信息失败！","warning");
        	}
        },'json')
    }
    function clearForm() {
        $("#punishmentStuInfo").form('clear');
        $('#addPunishmentType').combobox('select',0);
    }
    
    function searchPunishment(toolbar,datagrid){
		var name = $(toolbar).find("#stuName2").val();
		var code = $(toolbar).find("#stuCode2").val();
		
		$('#allStuPunishmentList').datagrid('load',{
			name : name,
			code : code
		});
	}
    
    function addStudentInfo(){
    	var row = $('#allStuPunishmentList').datagrid('getSelected');
    	if (row){
    		$('#punishmentStuInfo').find('#code').textbox('setValue',row.code);
    		$('#punishmentStuInfo').find('#name').val(row.name);
    		$('#punishmentStuInfo').find('#className').val(row.className);
    		$('#punishmentStuInfo').find('#studentId').val(row.studentId);
    		//$('#punishmentStuInfo').find('#id').val(row.id);
    		$('#punishmentStuWindow').window('close');
    		
    	}
    }
</script>




