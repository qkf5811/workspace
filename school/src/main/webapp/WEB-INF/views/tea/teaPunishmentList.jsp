<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="teaPunishmentToolbar" style="padding: 5px; height: auto">
		<div>
			<td><span>教师编号:</span></td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				
				<td><span>教师姓名:</span></td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchPunishment('#teaPunishmentToolbar', '#teaPunishmentList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="teaPunishmentList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getTeaPunishmentList.do" toolbar="#teaPunishmentOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="80" align="center">教师编号</th>
				<th field="name" width="100" align="center">教师姓名</th>
				<th field="nowPosition" width="100" align="center">教师职称</th>
				<th field="schoolYear" width="100" align="center">学年</th>
				<th field="schoolTermTypeStr" width="100" align="center">学期</th>
				<th field="title" width="100" align="center">处罚名称</th>
				<th field="punishmentTypeStr" width="120" align="center">处罚类型</th>
				<th field="content" width="200" align="center">处罚内容</th>
				<th field="punishDateStr" width="120" align="center">处罚日期</th>
				<th field="remark" width="120" align="center">备注</th>
			</tr>
		</thead>
	</table>

	 
    <div id="teaPunishmentOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('tea/toAddTeaPunishmentInfo.do','添加教师处罚信息')">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deletePunishment()">删除</a>
  </div> 
</div>

<script	type="text/javascript">
	function searchPunishment(toolbar,datagrid){
		var code = $(toolbar).find("#code").val();
		var name = $(toolbar).find("#name").val();
		
		$(datagrid).datagrid('load',{
			code 		: code,
			name 		: name
		});
			
	}
	
	function deletePunishment(){
		var row = $("#teaPunishmentList").datagrid('getSelected');
		if (row){
			$.messager.confirm('请确认...','您确定要删除此信息吗?',function(r){
				if (r){
					$.post("tea/deleteTeaPunishmentItem.do",{id : row.id},function(result){
						if (result.success){
							$.messager.alert('操作提示','删除成功!','info');
							$("#teaPunishmentList").datagrid('reload');
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