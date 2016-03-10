<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="punishmentToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td><span>惩罚类型：</span></td>
				<td><select class="easyui-combobox" id="punishmentType"
					name="punishmentType" style="width:100px;height:29px"
					data-options="editable:false,panelHeight: 'auto'">
					<option value="">请选择</option>
					<option value="13001">留校察看</option>
					<option value="13002">通报评批</option>
					<option value="13003">记过</option>
					</select>
				</td> 
			
			<td><span>学生学号:</span></td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				
				<td><span>学生姓名:</span></td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchPunishment('#punishmentToolbar', '#punishmentList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="punishmentList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/stu/getPunishmentList.do" toolbar="#punishmentOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="100" align="center">学号</th>
				<th field="name" width="100" align="center">姓名</th>
				<th field="className" width="200" align="center">班级</th>
				<th field="punishmentTypeStr" width="100" align="center">惩罚类型</th>
				<th field="content" width="360" align="center">惩罚内容</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
	
	
    <div id="punishmentOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('stu/toAddPunishmentInfo.do','添加学生惩罚信息')">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditpunishment()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deletePunishment()">删除</a>
    </div>
   
</div>  
 
<script	type="text/javascript">
	function searchPunishment(toolbar,datagrid){
		var punishmentType = $(toolbar).find("#punishmentType").combobox('getValue');
		var code = $(toolbar).find("#code").val();
		var name = $(toolbar).find("#name").val();
		$(datagrid).datagrid('load',{
			punishmentType : punishmentType,
			code 		: code,
			name        : name
		});
			
	}
	
	function toEditpunishment(){
		var row = $("#punishmentList").datagrid('getSelected');
		if (row){
			openTab('stu/toUpdatePunishmentInfo.do?id='+ row.id +'&studentId='+ row.studentId,'编辑信息');
		} else{
			$.messager.alert('操作提示','请先选择一行进行编辑!','warning');
		}
	}
	
	function deletePunishment(){
		var row = $("#punishmentList").datagrid('getSelected');
		if(row){
			$.messager.confirm('请确认...','您确定要删除此信息吗?',function(r){
				if (r){
					$.post("stu/deletePunishmentInfo.do",{id : row.id},function(result){
						if (result.success){
							$.messager.alert('操作提示','删除成功!','info');
							$("#punishmentList").datagrid('reload');
						} else{
							//alert("xxxxxx");
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
			$.messager.alert('操作提示','请先选择要删除的条目!','warning');
		}
	}
</script>