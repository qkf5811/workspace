<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div class="easyui-panel" style="width: 99%; height: auto">
	<div id="rewardToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td><span>奖励类型：</span></td>
				<td><select class="easyui-combobox" id="rewardType"
					name="rewardType" style="width:100px;height:29px"
					data-options="editable:false,panelHeight: 'auto'" >
					<option value="">请选择</option>
					<option value="12001">三好学生</option>
					<option value="12002">优秀班干</option>
					<option value="12003">奖学金</option>
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
				onclick="searchReward('#rewardToolbar', '#rewardList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="rewardList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/stu/getRewardList.do" toolbar="#rewardOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="100" align="center">学号</th>
				<th field="name" width="100" align="center">姓名</th>
				<th field="className" width="200" align="center">班级</th>
				<th field="rewardTypeStr" width="100" align="center">奖励类型</th>
				<th field="content" width="360" align="center">奖励内容</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>

	 
    <div id="rewardOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('stu/toAddRewardInfo.do','添加学生奖励信息')">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditReward()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteReward()">删除</a>
  </div> 
</div>

<script	type="text/javascript">
	function searchReward(toolbar,datagrid){
		//alert("xxx");
		var rewardType = $(toolbar).find("#rewardType").combobox('getValue');
		//alert(rewardType);
		var code = $(toolbar).find("#code").val();
		var name = $(toolbar).find("#name").val();
		
		$(datagrid).datagrid('load',{
			rewardType  : rewardType,
			code 		: code,
			name 		: name
		});
			
	}
	
	function toEditReward(){
		var row = $("#rewardList").datagrid('getSelected');
		if (row){
			openTab('stu/toUpdateRewardInfo.do?id=' + row.id + '&studentId='+ row.studentId,'编辑信息');
		} else{
			$.messager.alert('操作提示','请先选择一行进行编辑!','warning');
		}
	}
	
	function deleteReward(){
		var row = $("#rewardList").datagrid('getSelected');
		if (row){
			$.messager.confirm('请确认...','您确定要删除此信息吗?',function(r){
				if (r){
					$.post("stu/deleteRewardInfo.do",{id : row.id},function(result){
						if (result.success){
							$.messager.alert('操作提示','删除成功!','info');
							$("#rewardList").datagrid('reload');
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
			$.messager.alert('操作提示','请先选择要删除的条目!','warning');
		}
	}
	
</script>