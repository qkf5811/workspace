<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<style type="text/css">
	.item {
		text-align:right;
		padding-right:10px;
	}
</style>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="teaPunishmentInfo">
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
                    <td class="item">学年:</td>
                       <td><select id="pSchoolYearId" class="easyui-combobox" name="pSchoolYearId"
                                    style="height: 30px;width:100px" validtype="selectRequired['pSchoolYearId']"
                                    data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true" >
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
                       	<td><select class="easyui-combobox" id="teacherTermType_" style="height:30px;width:100px"
					name="teacherTermType_" validtype="selectRequired['teacherTermType_']"
					data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
						<c:forEach items="${termList }" var="t">
							<option value="${t.id }">${t.name }</option>
						</c:forEach>
					</select>
                   
                    </td>
                </div>
            </tr>
       
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 处罚类型:</td>
                       	<td><select id="teacherPunishmentType_" name="teacherPunishmentType_" class="easyui-combobox"
                                      validtype="selectRequired['teacherPunishmentType_']" style="height:30px;width:100px"
                                     data-options="panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
                               <option value="0">请选择</option>  
                        <c:forEach var="p" items="${pList}">
                            <option value="${p.id }">${p.name}</option>
                        </c:forEach>
                    </select>
                    
                    </td>
                </div>
            </tr>
           
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">处罚名称:</td>
                       	<td><input id="title" class="easyui-validatebox textbox" name="title"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    		
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">处罚内容:</td>
                    	<td><textarea id="content" cols="50" rows="5" name="content"
                                       class="easyui-validatebox textbox"
                                       style="padding: 5px"
                                       data-options="required:true,missingMessage:'该处未填写',novalidate:true" ></textarea>
                   
                    </td>
                </div>
            </tr>
           
		  <!-- <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 处罚日期:</td>
			          <td><input id="punishDate0" class="easyui-datebox" name="punishDate0"
			                     style="width: 210px; height: 31px; padding: 5px" 
			                     data-option="required:true,missingMessage:'该处未填写',editable:false,novalidate:true">
			                 
			                  <img onclick="WdatePicker({el:'punishDate0'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			               
			                    </td>
			                </div>
		  </tr> -->
		   <tr>
           	 <div style="margin-bottom: 20px">
                    <td class="item">处罚日期:</td>
			          <td><input id="punishDate0" class="easyui-datebox" name="punishDate0" 
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
                    <td class="item"> 备注信息:</td>
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
           onclick="addPunishmentInfo('#teaPunishmentInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>



<!-- 弹出教职工列表窗口 -->
	<div id="punishmentTeaWindow" class="easyui-window" title="教职工列表" 
	data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:450px;padding:5px;">
		<div id="punishmentList0Toolbar" style="padding: 5px; height: auto">
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
				onclick="searchPunishmentList('#punishmentList0Toolbar', '#allTeaPunishmentList')"
				iconCls="icon-search">查询</button>
		</div> 
	</div>
	<table id="allTeaPunishmentList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/findAllTeacherList.do" 
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
					data-options="iconCls:'icon-ok'" onclick="addTeacherPunishmentItem()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#punishmentTeaWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
<!-- 弹出窗口结束 -->

<script type="text/javascript">

	$(function(){
		$("#teaPunishmentInfo").find("#code").textbox({
			onClickButton : function() {
				//alert("xxx");
				$('#punishmentTeaWindow').window('open');
			}
		});
	})
	
    function addPunishmentInfo(form){
    	//在提交数据之前执行表单验证
		$('#teaPunishmentInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		var code = $(form).find('#code').val();
        var teacherPunishmentType_ = $(form).find('#teacherPunishmentType_').combobox('getValue');
        var teacherId = $(form).find('#teacherId').val();
        var schoolYearId = $(form).find('#pSchoolYearId').combobox('getValue');
        var schoolTermType = $(form).find('#teacherTermType_').combobox('getValue');
        var punishDate0 = $(form).find('#punishDate0').datebox('getValue');
        var title = $(form).find('#title').val();
        var content = $(form).find('#content').val();
        var remark = $(form).find('#remark').val();
        
        //console.log();
        $.post('tea/addTeaPunishmentItem.do',{
        	"teacherId"    : teacherId,
            "punishmentType" : teacherPunishmentType_,
            "schoolYearId" : schoolYearId,
            "schoolTermType" : schoolTermType,
            "title" : title,
    		"punishDate": punishDate0,
            "content" : content,
            "remark"  : remark
        },function(data){
        	if (!(data.result < 0)){
        		closeTab(getCurrentTab());
        		$.messager.alert("操作提示","添加信息成功！！","info");
        		$('#teaPunishmentList').datagrid('reload');
        	} else if (data.result < 0){
        		$.messager.alert("操作提示","添加信息失败！！","warning");
        	}
        });
    }
    function clearForm() {
        $("#teaPunishmentInfo").form('clear');
        $('#teacherTermType_').combobox('select',0);
        $('#teacherPunishmentType_').combobox('select',0);
        $('#pSchoolYearId').combobox('select',0);
    }
    
    function searchPunishmentList(toolbar,datagrid){
		var name = $(toolbar).find("#name").val();
		var code = $(toolbar).find("#code").val();
		$("#allTeaPunishmentList").datagrid('load',{
			"name" : name,
			"code" : code
		});
	}
    
    function addTeacherPunishmentItem(){
    	var row = $('#allTeaPunishmentList').datagrid('getSelected');
    	if (row){
    		$('#teaPunishmentInfo').find('#code').textbox('setValue',row.code);
    		$('#teaPunishmentInfo').find('#name').val(row.name);
		//	$('#teaPunishmentInfo').find('#schoolYearId').val(row.schoolYearId);
		//	$('#teaPunishmentInfo').find('#schoolTermType').val(row.schoolTermType); 
    		$('#teaPunishmentInfo').find('#teacherId').val(row.teacherId);
    		$('#punishmentTeaWindow').window('close');
    	}
    }
</script>