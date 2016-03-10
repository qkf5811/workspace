<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="select-intoclass-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:550px;height:425px;"
        title="选择转入班级" iconCls="icon-search" modal="true"
        toolbar="#select-intoclass-toolbar" buttons="#select-intoclass-buttons">
    <input id="openForm" name="openForm" type="hidden">
    <!-- hiu 去除url属性：url="${contextPath}/stu/getClassList.do",在按了选择按键后才允许加载数据 -->
	<table id="selectIntoclassList" class="easyui-datagrid" style="width: auto;"
		pagination="true" rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>				
				<th field="majorFieldClassName" width="170">班级</th>
				<th field="gradeName" width="100">年级</th>
			</tr>
		</thead>
	</table>
</div>
<div id="select-intoclass-toolbar">
		<div>
			班级:<input id="majorFieldClassName">
			年级:<input id="gradeName">
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchIntoclass('#select-intoclass-toolbar', '#selectIntoclassList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="select-intoclass-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectIntoclass()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#select-intoclass-dialog').dialog('close')">取消</a>
</div>

<script type="text/javascript">

function searchIntoclass(toolbar, datagrid) {
	var majorFieldClassName = $(toolbar).find("#majorFieldClassName").val();
	var gradeName = $(toolbar).find("#gradeName").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		majorFieldClassName: majorFieldClassName,
		gradeName: gradeName
	});
}

function selectIntoclass(){
    var form = $('#select-intoclass-dialog').find('#openForm').val();
    var row = $('#selectIntoclassList').datagrid('getSelected');
    if (row){
     	$(form).find("#intoClassName").textbox('setValue',row.majorFieldClassName); 
    }
	$('#select-intoclass-dialog').dialog('close');
}
</script>
