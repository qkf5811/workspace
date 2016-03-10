<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto;">

	<div style="margin:5px" id="searchEquOfEquOut">
		
		<td>设备编号：</td>
			<td><input class="easyui-validatebox textbox" id="code"
				name="account" style="width: 100px; height: 18px; padding: 5px" />
			</td>
		<td>设备名称：</td>
		<td><input class="easyui-validatebox textbox" id="equName"
				   name="equName" style="width: 100px; height: 18px; padding: 5px" />
		</td>
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchEquipmentByCodeWithPageOut()"
				iconCls="icon-search">查询</button>
	</div>
	<table id="outEquipmentItemList" class="easyui-datagrid" style="width: auto;"
		pagination="true"
		toolbar="#outEquipOperToolbar" rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="200" align="center">设备编号</th>
				<th field="storageName" width="120" align="center">存放地点</th>
				<th field="useStatusStr" width="120" align="center">使用状态</th>
				<th field="useUserId" width="120" align="center">使用者ID</th>
				<th field="dateOfOutStr" width="200" align="center">使用日期</th>
				<th field="dateOfDealineStr" width="200" align="center">使用期限</th>
			</tr>
		</thead>
	</table>


	<div id="outEquipOperToolbar">
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-filter" plain="true"
				onclick="openTab('equ/toUseEquipmentItem.do','领用设备')">领用设备</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-filter" plain="true"
				onclick="openTab('equ/toBorrowEquipmentItem.do', '借用设备')">借用设备</a>
		</div>
	</div>
</div>
<script>
	//根据设备编号查询
	function searchEquipmentByCodeWithPageOut() {
		var code = $('#searchEquOfEquOut').find('#code').val();
		$('#outEquipmentItemList').datagrid({
			url : "${contextPath }/equ/getEquipmentItemByCode.do",
			fitColumns : true,
			rownumbers : true,
			pagination : true,
			pageSize : 10,
			pagination : true,
			rownumbers : true,
			collapsible : true,
			queryParams : {
				code : code
			}
		});
	}
	$(function() {
		
	})
</script>
