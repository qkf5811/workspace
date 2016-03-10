<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<%-- <div id="teacherThesisToolbar" style="padding: 5px; height: auto">
		<div> 
			<td>教师姓名：</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name"  readonly="readonly"
					value="<c:out value='${name}'/>"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>教师编号:</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" readonly="readonly"
					value="<c:out value='${code}'/>"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
		
		
			
			
			
			
			<!-- <button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeacherThesis('#teacherThesisToolbar', '#teacherThesisList')"
				iconCls="icon-search">查询</button> -->
		</div>
	</div> --%>
	<table id="teacherThesisList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getTeacherThesisList.do?userId=${userId}" toolbar="#teacherThesisOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="thesisName" width="250" align="center">论文著作名称</th>
				<th field="thesisTypeStr" width="130" align="center">论文类型</th>
				<th field="publishDateStr" width="120" align="center">论文发表日期</th>
				<th field="authorOrder" width="90" align="center">作者排名</th>	
				<th field="publication" width="150" align="center">所属刊物/出版单位</th>
							
				<th field="remark" width="250" align="center">备注</th>
			</tr>
	
		</thead>
	</table>
	<div id="teacherThesisOperToolbar">
	<%-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('tea/toAddTeacherThesis.do?userId=${userId}','添加我的论文著作')">新建</a> --%>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toAddTeacherThesis()">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditTeacherThesis()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTeacherThesis()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		/* function searchTeacherThesis(toolbar, datagrid) {
			var name=$(toolbar).find("#name").val();
			var code = $(toolbar).find("#code").val();
			var thesisType = $(toolbar).find("#thesisType").combobox('getValue');	
			
		
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				name:name,
				code: code,
				thesisType:thesisType
			});
		} */
		function toAddTeacherThesis(){
			/* var code=$('#teacherThesisToolbar').find('#code').val();	
			if(code) {
				openTab('tea/toAddTeacherThesis.do?userId=${userId}','添加我的论文著作')
			}else {
				 $.messager.alert('提示','您好，教师身份才可以“添加论文”，谢谢！');
			} */
			openTab('tea/toAddTeacherThesis.do?userId=${userId}','添加我的论文著作')
		}
		
		function toEditTeacherThesis(){
            var row = $('#teacherThesisList').datagrid('getSelected');
            if (row){
            	openTab('tea/toEditTeacherThesis.do?id='+row.id+"&code="+row.code,'编辑论文著作');
            } else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}
        }
        
		function deleteTeacherThesis(){
        	
            var row = $('#teacherThesisList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此论文著作信息吗?',function(r){
                    if (r){
                        $.post('tea/deleteTeacherThesis.do',{id:row.id},function(result){
                            if (result.success){
                            	$.messager.alert("操作提示", "删除成功！","info");
                                $('#teacherThesisList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除此论文著作信息失败'
                                });
                            }
                        },'json');
                    }
                });
            }else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}

		}  
       
       
</script> 