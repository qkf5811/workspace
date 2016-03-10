<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div style="width: 99%; height: auto">
	<!-- 
	<div id="teaResumeToolbar" style="padding: 5px; height: auto">
		<div>
			<td><span>教师编号:</span></td>
			<td><input class="easyui-validatebox textbox" 
					name="code"  id="code"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				<td><span>教师姓名:</span></td>
				<td><input class="easyui-validatebox textbox" 
					name="name"  id="name"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeaResume('#teaResumeToolbar', '#resumeList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	-->
	<input id="teacherId" value="${teacherId }" hidden="true">
	<div style="margin: 15px"><strong>${name }</strong> 的简历信息:</div>
	<table id="resumeList" class="easyui-datagrid" style="width: auto;"
		pagination="true" toolbar="#teaResumeOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<!-- 
				<th field="code" width="150" align="center">教师编号</th>
				<th field="name" width="100" align="center">教师姓名</th>
				 -->
				<th field="workPlace" width="150" align="center">所属单位</th>
				<th field="position" width="150" align="center">职位</th>
				<th field="startDateStr" width="150" align="center">开始时间</th>
				<th field="endDateStr" width="150" align="center">结束时间</th>
				<th field="transferCause" width="150" align="center">调动原因</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
	 <div id="teaResumeOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addItem()">增加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteItem()">删除</a>
    </div>

</div>

<script type="text/javascript">
	
	$(function() {
		var id = $('#teacherId').val();
		$('#resumeList').datagrid({
			url : "${contextPath}/tea/getSingleResumeList.do?id=" + id
		});
	});

	function searchTeaResume(toolbar,datagrid){
		var code = $(toolbar).find('#code').val();
		var name = $(toolbar).find('#name').val();
		$(datagrid).datagrid('load',{
			name : name,
			code : code
		});
	}
	
	function addItem(){
		var id = $('#teacherId').val();
		openTab('tea/toAddResumeItem.do?id='+id,'新增履历条目');
	}
	
	function editItem(){
		var row = $('#resumeList').datagrid('getSelected');
		if (row){
			if ($('#main').tabs('exists', '编辑履历条目')) {
                $('#main').tabs('close', '编辑履历条目');
                
            }
			openTab('tea/toUpdateResumeItem.do?id='+ row.id,'编辑履历条目');
		} else{
			$.messager.alert('操作提示','请先选择一行进行编辑!','warning');
		}
	}
	
	function deleteItem(){
		var row = $('#resumeList').datagrid('getSelected');
		if (row){
			$.messager.confirm('请确认...','您确定要删除此信息吗?',function(r){
				if (r){
					$.post("tea/deleteTeaWorkItem.do",{id : row.id},function(result){
						if (result.success){
							$.messager.alert('操作提示','删除成功!','info');
							$("#resumeList").datagrid('reload');
						} else{
							$.messager.show(
							{
								title : 'Error',
								msg   : '删除信息失败 '
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