<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="new-select-equipName-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:510px;height:425px;"
        title="选择设备名称及其型号" iconCls="icon-search" modal="true"
        toolbar="#equ_new-select-equipName-toolbar" buttons="#equ_new-select-equipName-buttons">
    <input id="new_equipNameOpenForm" name="new_equipNameOpenForm" type="hidden">
	<table id="new_selectEquipNameList" class="easyui-datagrid" style="width: auto;"
		pagination="true"  url="${contextPath}/apv/getEquipmentList.do" 
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				
				<th field="name" width="150">设备名称</th>
				<th field="model" width="130">设备型号</th>
				<th field="brand" width="130">设备品牌</th>
			</tr>
		</thead>
	</table>
</div>
<div id="equ_new-select-equipName-toolbar">
		<div>
			设备名称:<input id="equipment_name">
			设备型号:<input id="equipment_model">
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchEquipment('#equ_new-select-equipName-toolbar', '#new_selectEquipNameList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="equ_new-select-equipName-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectEquipment()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#new-select-equipName-dialog').dialog('close')">取消</a>
</div>

<script type="text/javascript">

function searchEquipment(toolbar, datagrid) {
	var name = $(toolbar).find("#equipment_name").val();
	var model = $(toolbar).find("#equipment_model").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		name: name,
		model:model
	});
}

function selectEquipment(){
    var form = $('#new-select-equipName-dialog').find('#new_equipNameOpenForm').val();
    var row = $('#new_selectEquipNameList').datagrid('getSelected');
    if (row){
    	$(form).find("#equipNameId").val(row.id);
    	$(form).find("#zj_new_equipNameName").textbox("setValue",row.name);
    }
	$('#new-select-equipName-dialog').dialog('close');
}
</script>
