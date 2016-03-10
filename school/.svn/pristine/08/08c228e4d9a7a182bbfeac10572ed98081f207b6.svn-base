<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="select-department-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:445px;height:425px;"
        title="选择部门" iconCls="icon-search" modal="true"
        toolbar="#apv_select-department-toolbar" buttons="#apv_select-department-buttons">
    <input id="departmentOpenForm" name="departmentOpenForm" type="hidden">
	<table id="selectDepartmentList" class="easyui-datagrid" style="width: auto;"
		pagination="true"  url="${contextPath}/apv/getDepartmentList.do" 
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				
				<th field="name" width="100">部门名</th>
				<th field="remark" width="120">部门备注</th>
			</tr>
		</thead>
	</table>
</div>
<div id="apv_select-department-toolbar">
		<div>
			部门名:<input id="name">
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchDepart('#apv_select-department-toolbar', '#selectDepartmentList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="apv_select-department-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectDepart()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#select-department-dialog').dialog('close')">取消</a>
</div>

<script type="text/javascript">

function searchDepart(toolbar, datagrid) {
	var name = $(toolbar).find("#name").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		name: name
	});
}

function selectDepart(){
    var form = $('#select-department-dialog').find('#departmentOpenForm').val();
    var row = $('#selectDepartmentList').datagrid('getSelected');
    if (row){
    	$(form).find("#departmentId").val(row.id);
    	$(form).find("#departmentName").textbox("setValue",row.name);
    }
	$('#select-department-dialog').dialog('close');
}
</script>
