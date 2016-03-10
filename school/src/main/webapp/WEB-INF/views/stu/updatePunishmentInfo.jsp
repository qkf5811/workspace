<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="punishmentInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	 学生学号:<input id="code" class="easyui-numberbox" 
                       	 			name="code" value="${sp.code }" readonly="true"
                                    style="width: 212px; height: 31px; padding: 5px">
                    	
                    </td>
                </div>
            </tr>
            <tr>
            <div style="margin-bottom: 20px">
                    <td>
			                        学生姓名:<input id="name" class="easyui-validatebox textbox" 
			                        		  name="name" value="${sp.name }" readonly="true"
			                                  style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			</tr>
			<tr>
            <div style="margin-bottom: 20px">
                    <td>
			                        学生班级:<input id="punishClassName" class="easyui-validatebox textbox" 
			                  readonly="true" name="punishClassName" value="${sp.className }" 
			                                  style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			</tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
                       	 惩罚类型:<select id="updatePunishmentType" name="updatePunishmentType" class="easyui-combobox"
                                    validtype="selectRequired['updatePunishmentType']"
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
                                       data-options="required:true,missingMessage:'该处未填写',novalidate:true" >${sp.content }</textarea>
                 
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td>
			                        备注信息:<input id="remark" class="easyui-validatebox textbox" 
			                        		  name="remark" value="${sp.remark }"
			                                  style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			            </tr>
			 <tr>
			 	<div style="margin-bottom: 20px;">
			 		<td>
			 			<input type="hidden" id="id" name="id" value="${sp.id }">
			 		</td>
			 	</div>
			 </tr>
        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="updatepunishmentInfo('#punishmentInfo')">修改</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>
</div>

<script>
	function updatepunishmentInfo(form){
		//在提交数据之前执行表单验证
		$('#punishmentInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		var id = $("#id").val();
		var code = $(form).find("#code").val();
		var punishClassName = $(form).find('#punishClassName').val();
		var punishmentType = $(form).find("#updatePunishmentType").combobox('getValue');
		var content = $(form).find("#content").val();
		var remark = $(form).find("#remark").val();
		
		$.post("stu/updatePunishmentInfo.do",{
			id 	 : id,
			code : code,
			className : punishClassName,
			punishmentType : punishmentType,
			content : content,
			remark : remark
		},function(result){
			closeTab(getCurrentTab());
			$.messager.alert('操作提示','修改成功!','info');
			$('#punishmentList').datagrid('reload');
		},'json');
	}
	
	function clearForm(){
		$('#content').val('');
		$('#remark').val('');
		$('#updatePunishmentType').combobox('select',0);
	}
</script>