<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="allThesisToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>教师姓名：</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>教师编号:</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			<td>论文类型:</td>
				<td><select class="easyui-combobox" id="thesisType"
						name="thesisType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['thesisType']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${teacherThesisTypeList}" var="teacherThesisType">
							<option value="${teacherThesisType.id}">${teacherThesisType.name}</option>
							</c:forEach>					
					</select></td> 	
			
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchAllThesis('#allThesisToolbar', '#allThesisList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="allThesisList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getAllThesisList.do" toolbar="#allThesisOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="90" align="center">教师姓名</th>
				<th field="code" width="120" align="center">教师编号</th>
				<th field="thesisName" width="250" align="center">论文著作名称</th>
				<th field="thesisTypeStr" width="130" align="center">论文类型</th>
				<th field="publishDateStr" width="120" align="center">论文发表日期</th>
				<th field="authorOrder" width="90" align="center">作者排名</th>
				<th field="publication" width="150" align="center">所属刊物/出版单位</th>
				
				
				<th field="remark" width="250" align="center">备注</th>
			</tr>
		</thead>
	</table>
	<div id="allThesisOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteThesis()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		function searchAllThesis(toolbar, datagrid) {
			var name=$(toolbar).find("#name").val();
			var code = $(toolbar).find("#code").val();
			var thesisType = $(toolbar).find("#thesisType").combobox('getValue');	
			
		
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				name:name,
				code: code,
				thesisType:thesisType
			});
		}
        
      
		function deleteThesis(){
        	
            var row = $('#allThesisList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此论文著作信息吗?',function(r){
                    if (r){
                        $.post('tea/deleteThesis.do',{id:row.id},function(result){
                            if (result.success){
                            	$.messager.alert("操作提示", "删除成功！","info");
                                $('#allThesisList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除此论文著作信息失败'
                                });
                            }
                        },'json');
                    }
                });
            }
            else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}
        }
        
        
       
       
</script> 