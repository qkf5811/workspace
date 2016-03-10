<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="teaConEduToolbar" style="padding: 5px; height: auto">
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
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeaConEdu('#teaConEduToolbar', '#teaConEduList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="teaConEduList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getTeaContinueEduList.do" toolbar="#teaConEduOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="100" align="center">教师编号</th>
				<th field="name" width="100" align="center">教师姓名</th>
				<th field="courseType" width="100" align="center">课程类型</th>
				<th field="courseName" width="100" align="center">课程名称</th>
				<th field="teachOrganization" width="150" align="center">施教机构</th>
				<th field="startDateStr" width="100" align="center">开始日期</th>
				<th field="endDateStr" width="100" align="center">结束日期</th>
				<th field="studyHours" width="100" align="center">学时</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
	<div id="teaConEduOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toAddPage()">新建</a>
        <a href="javascript:void(0)" id="edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editConEduItem()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTeaConEdu()">删除</a>
    </div>
</div> 

<script type="text/javascript">
	
		function searchTeaConEdu(toolbar, datagrid) {
			var name=$(toolbar).find("#name").val();
			var code = $(toolbar).find("#code").val();
			
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				name:name,
				code: code
			});
		}
		
		function toAddPage(){
			//alert("xxx");
			openTab('tea/toAddTeaContinueEduItem.do','新建继续教育条目');
		}
		
		function editConEduItem(){
			var row = $('#teaConEduList').datagrid('getSelected');
			if (row){
				//closeTab('编辑继续教育条目');

				if ($('#main').tabs('exists', '编辑继续教育条目')) {
	                $('#main').tabs('close', '编辑继续教育条目');
	                 
	            }

				openTab('tea/toEditTeaConEduItem.do?id=' + row.id,'编辑继续教育条目');
				/* $('#edit').tabs('add',{
					options:{
						title:'编辑继续教育条目',
						href:'tea/toEditTeaConEduItem.do?id=' + row.id
					}
				}); */
			} else {
				$.messager.alert('操作提示','请选择一行进行编辑!','warning');
			}
		}
		
        function deleteTeaConEdu(){
        	
            var row = $('#teaConEduList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此条信息吗?',function(r){
                    if (r){
                        $.post('tea/deleteTeaContinueEduItem.do',{id:row.id},function(data){
                            if (data.result > 0){
                            	$.messager.alert('操作提示','删除成功!','info');
                                $('#teaConEduList').datagrid('reload');    
                            } else {
                                $.messager.show({    
                                    title: 'Error',
                                    msg: '撤销教师异动信息失败'
                                });
                            }
                        },'json');
                    }
                });
            } else{
            	$.messager.alert('操作提示','请选择要删除的条目!','warning');
            
            }
        }
       
</script> 