<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<style type="text/css">
	.item {
		text-align:right;
		padding-right:10px;
	}
</style>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="teaRewardInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师编号:</td>
                    <td>
                       	<input id="code" class="easyui-textbox textbox" name="code"
                                    style="width: 212px; height: 32px; padding: 5px"
                                    data-options="buttonText:'选择',buttonIcon:'icon-search',
                                    editable:false,required:true,missingMessage:'该处未填写',novalidate:true" >
                  
                    </td>
                    </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师姓名:</td><td>
                      <input id="name" class="easyui-validatebox textbox" name="name"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    readonly="true"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    	
                    </td>
                </div>
            </tr>
              <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">学年:</td>
                      <td><select id="rSchoolYearId" class="easyui-combobox" name="rSchoolYearId"
                           style="height: 30px;width:100px" validtype="selectRequired['rSchoolYearId']"
                           data-options="panelHeight:'auto',required:true,missingMessage:'该处未选择',novalidate:true" >
								<option value="0">请选择</option>
								<c:forEach items="${sList }" var="s" >
									<option value="${s.id }">${s.name }</option>
								</c:forEach>                           		
                           </select>
                    	
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 学期:</td>
                       	<td><select class="easyui-combobox" 
					name="rewardSchoolTermType"  id="rewardSchoolTermType"
					 validtype="selectRequired['rewardSchoolTermType']" style="height:30px;width:100px"
					data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${tList }" var="t">
						<option value="${t.id }">${t.name }</option>
					</c:forEach>
					</select>
                    	
                    </td>
                </div>
            </tr>
       
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 奖励类型:</td>
                       	<td><select id="teacherRewardType" name="teacherRewardType" class="easyui-combobox"
                                     validtype="selectRequired['teacherRewardType']" style="height:30px;width:100px"
                                     data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
                               <option value="0">请选择</option>  
                        <c:forEach var="r" items="${rList}">
                            <option value="${r.id }">${r.name}</option>
                        </c:forEach>
                    </select>
               
                    </td>
                </div>
            </tr>
           
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 奖励名称:</td>
                       	<td><input id="title" class="easyui-validatebox textbox" name="title"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    	
                    </td>
                </div>
            </tr>
            <tr>
            	<tr>
            	<div style="margin-bottom: 20px">
                    <td class="item"> 颁奖机构:</td>
                       	<td><input id="award" class="easyui-validatebox textbox" name="award"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    
                    </td>
                </div>
            </tr>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">奖励内容:</td>
                    	<td><textarea id="content" cols="50" rows="5" name="content"
                                       class="easyui-validatebox textbox"
                                       style="padding: 5px"
                                       data-options="required:true,missingMessage:'该处未填写',novalidate:true" ></textarea>
                 
                    </td>
                </div>
            </tr>
           
		  <!--  <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">奖励日期:</td>
			           <td><input id="rewardDateStr" class="easyui-datebox" name="rewardDateStr"
			                     style="width: 210px; height: 31px; padding: 5px" 
			                     data-option="required:true,missingMessage:'该处未填写',editable:false,novalidate:true">
			                  
			                  <img onclick="WdatePicker({el:'rewardDateStr'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			               
			                    </td>
			                </div>
		  </tr> -->
		  <tr>
           	 <div style="margin-bottom: 20px">
                    <td class="item">奖励日期:</td>
			          <td><input id="rewardDateStr" class="easyui-datebox" 
			                        		  name="rewardDateStr" 
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
           onclick="addRewardInfo('#teaRewardInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>



<!-- 弹出教职工列表窗口 -->
	<div id="rewardTeaWindow" class="easyui-window" title="教职工列表" 
		data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:450px;padding:5px;">
		<div id="rewardListToolbar" style="padding: 5px; height: auto">
		<div>
            <td>教师编号:</td>
            <td><input class="easyui-validatebox textbox" id="code"
                       name="code"
                       style="width: 100px; height: 18px; padding: 5px" />

            </td>

			<td>教师姓名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  

			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchRewardList('#rewardListToolbar', '#allRewardList')"
				iconCls="icon-search">查询</button>
		</div> 
	</div>
	<table id="allTeaRewardList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getAllTeacherList.do" toolbar="#rewardListOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">

	<thead>
		<tr>
			<th field="code" width="150" align="center">教师编号</th>
			<th field="name" width="150" align="center">教师姓名</th>
			<th field="nowPosition" width="150" align="center">担任职务</th>
		</tr>
	</thead>
</table>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addTeacherRewardItem()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#rewardTeaWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
<!-- 弹出窗口结束 -->

<script type="text/javascript">

	$(function(){
		$("#teaRewardInfo").find("#code").textbox({
			onClickButton : function() {
				//alert("xxx");
				$('#rewardTeaWindow').window('open');
			}
		});
	})
    function addRewardInfo(form){
    	//在提交数据之前执行表单验证
		$('#teaRewardInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		var code = $(form).find('#code').val();
        var teacherRewardType = $(form).find('#teacherRewardType').combobox('getValue');
        var teacherId = $(form).find('#teacherId').val();
        var schoolYearId = $(form).find('#rSchoolYearId').combobox('getValue');
        var schoolTermType = $(form).find('#rewardSchoolTermType').combobox('getValue');
        var award = $(form).find('#award').val();
        var rewardDateStr = $(form).find('#rewardDateStr').datebox('getValue');
        var title = $(form).find('#title').val();
        var content = $(form).find('#content').val();
        var remark = $(form).find('#remark').val();
        
        $.post("tea/addTeaRewardItem.do",{
            "teacherId"    : teacherId,
            "rewardType" : teacherRewardType,
            "schoolYearId" : schoolYearId,
            "schoolTermType" : schoolTermType,
            "title" : title,
    		"award" : award,
            "content" : content,
            "rewardDate": rewardDateStr,
            "remark"  : remark
        },function(data){
        	if (!(data.result < 0)){
        		closeTab(getCurrentTab());
	            $.messager.alert("操作提示", "添加信息成功！","info");
	            $('#teaRewardList').datagrid('reload');
        	} else{
        		$.messager.alert("操作提示", "添加信息失败！","warning");
        	}
        },'json')
    }
    function clearForm() {
        $("#teaRewardInfo").form('clear');
        $('#rewardSchoolTermType').combobox('select',0);
        $('#teacherRewardType').combobox('select',0);
        $('#rSchoolYearId').combobox('select',0);
    }
    
    function searchRewardList(toolbar,datagrid){
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();
		$("#allTeaRewardList").datagrid('load',{
			"name" : name,
			"code" : code
		});
	}
    
    function addTeacherRewardItem(){
    	var row = $('#allTeaRewardList').datagrid('getSelected');
    	if (row){
    		$('#teaRewardInfo').find('#code').textbox('setValue',row.code);
    		$('#teaRewardInfo').find('#name').val(row.name);
		//	$('#teaRewardInfo').find('#schoolYearId').val(row.schoolYearId);
		//	$('#teaRewardInfo').find('#schoolTermType').val(row.schoolTermType); 
    		$('#teaRewardInfo').find('#teacherId').val(row.teacherId);
    		$('#rewardTeaWindow').window('close');
    	}
    }
</script>