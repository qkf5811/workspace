<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="rewardStuInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	学生学号:<input id="code" class="easyui-textbox textbox" name="code"
                                    style="width: 212px; height: 32px; padding: 5px"
                                    data-options="buttonText:'选择',buttonIcon:'icon-search',
                                    editable:false,required:true,missingMessage:'该处未填写',novalidate:true" >
                    		
                    </td>
                    </div>
                    <!-- 
                     <td>
                		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#rewardStuWindow').window('open');">在籍学生列表</a>
               		 </td>
               		  -->
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	 学生姓名:<input id="name" class="easyui-validatebox textbox" name="name"
                                    style="width: 200px; height: 18px; padding: 5px" readonly="true"
                                    data-options="required:true,editable:false,missingMessage:'该处未填写',novalidate:true" >
                    	
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
                       	 奖励类型:<select id="addRewardType" name="addRewardType" class="easyui-combobox"
                                    validtype="selectRequired['addRewardType']" style="height:30px;width:100px"
                                     data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
                               <option value="">请选择</option>                   
                        <c:forEach var="r" items="${rewardType}">
                            <option value="${r.id }">${r.name}</option>
                        </c:forEach>
                    </select>
                 
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                    	奖励内容:<textarea id="content" cols="50" rows="5" name="content"
                                       class="easyui-validatebox textbox"
                                       style="padding: 5px"
                                       data-options="required:true,missingMessage:'该处未填写',novalidate:true" ></textarea>
                   
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                        备注信息:<input id="remark" class="easyui-validatebox textbox" name="remark"
			                     style="width: 200px; height: 18px; padding: 5px">
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
           onclick="addrewardStuInfo('#rewardStuInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>



<!-- 弹出所有学生列表 -->
	<div id="rewardStuWindow" class="easyui-window" title="在籍学生列表" 
	data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:460px;padding:5px;">
		<div id="rewardListToolbar" style="padding: 5px; height: auto">
		<div>
			
			
			<td>学生学号:</td>
				<td><input class="easyui-validatebox textbox" id="StuCode"
					name="StuCode"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				<td>学生姓名:</td>
				<td><input class="easyui-validatebox textbox" id="stuName"
					name="stuName"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchRewardList('#rewardListToolbar', '#allStuRewardList')"
				iconCls="icon-search">查询</button>
		</div> 
	</div>
	<table id="allStuRewardList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/stu/getAllRewardList.do" toolbar="#rewardListOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">

	<thead>
		<tr>
			<th field="code" width="150" align="center">学号</th>
			<th field="name" width="150" align="center">姓名</th>
			<th field="className" width="150" align="left">班级</th>
		</tr>
	</thead>
</table>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addStudentInfo()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#rewardStuWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
<!-- 弹出窗口结束 -->

<script type="text/javascript">

	$(function(){
		$("#rewardStuInfo").find("#code").textbox({
			onClickButton : function() {
				//alert("xxx");
				$('#rewardStuWindow').window('open');
			}
		});
	});
    function addrewardStuInfo(form){
    	//在提交数据之前执行表单验证
		$('#rewardStuInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		var code = $(form).find('#code').val();
        var studentId = $(form).find('#studentId').val();
        //alert(student_id);
        var addRewardType = $(form).find('#addRewardType').combobox('getValue');
        var content = $(form).find('#content').val();
        var remark = $(form).find('#remark').val();
        $.post("stu/addRewardInfo.do",{
            "studentId"  : studentId,
            "rewardType" : addRewardType,
            "content"    : content,
            "remark"     : remark
        },function(data){
        	if (!(data.result < 0)){
        		closeTab(getCurrentTab());
	            $.messager.alert("操作提示", "添加信息成功！","info");
	            $('#rewardList').datagrid('reload');
        	} else{
        		$.messager.alert("操作提示", "添加信息失败！","warning");
        	}
        },'json')
    }
    function clearForm() {
        $("#rewardStuInfo").form('clear');
        $('#addRewardType').combobox('select',0);
    }
    
    function searchRewardList(toolbar,datagrid){
		var name = $(toolbar).find("#stuName").val();
		var code = $(toolbar).find("#StuCode").val();
		$("#allStuRewardList").datagrid('load',{
			"name" : name,
			"code" : code
		});
    }
    
    function addStudentInfo(){
    	var row = $('#allStuRewardList').datagrid('getSelected');
    	if (row){
    		$('#rewardStuInfo').find('#code').textbox('setValue',row.code);
    		$('#rewardStuInfo').find('#name').val(row.name);
    		$('#rewardStuInfo').find('#className').val(row.className);
    		$('#rewardStuInfo').find('#studentId').val(row.studentId);
    		//$('#rewardStuInfo').find('#id').val(row.id);
    		$('#rewardStuWindow').window('close');
    	}
    }
  
</script>

