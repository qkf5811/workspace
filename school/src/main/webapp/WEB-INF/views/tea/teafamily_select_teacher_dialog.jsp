<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="select-tea-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:500px;height:425px;"
        title="选择教师编号" iconCls="icon-search" modal="true"
        toolbar="#select-tea-toolbar" buttons="#select-tea-buttons">
    <input id="openForm" name="openForm" type="hidden">
	<table id="selectTeaList" class="easyui-datagrid" style="width: auto;"
		pagination="true" 
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>	   
				<th field="code" width="100">教师编号</th>
				<th field="name" width="100">教师姓名</th>
		  	</tr>
		</thead>    
	</table>
</div>

<div id="select-tea-toolbar">
		<div>
			教师编号:<input id="code">  
			教师姓名:<input id="name">
			<button href="#" class="easyi-linkbutton" plain="true"
				onclick="searchTea('#select-tea-toolbar', '#selectTeaList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="select-tea-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectTea()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#select-tea-dialog').dialog('close')">取消</a>
</div>

<script type="text/javascript">



function searchTea(toolbar, datagrid) {
	var name = $(toolbar).find("#name").val();
	var code = $(toolbar).find("#code").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		name: name,
		code: code
	});
}

function selectTea(){
	
    var form = $('#select-tea-dialog').find('#openForm').val();
    var row = $('#selectTeaList').datagrid('getSelected');
    if (row){
    	$(form).find("#teacherId").val(row.id);
    	$(form).find("#code").textbox('setValue',row.code);
    	$(form).find("#name").textbox('setValue',row.name);
    }
    var name=$('#teaFamilyToolbar').find("#name").val();
	var code = $('#teaFamilyToolbar').find("#code").val();
 	
 	$('#teaFamilyList').datagrid({
	   url: "${contextPath}/tea/getTeaFamilyList.do",
	   queryParams: {
		   name:name,
			code: code
	   }
 	}); 
	$('#select-tea-dialog').dialog('close');
	$('#selectTeaList').datagrid({
	    url: ""
	});
	/* $('#teaFamilyList').datagrid({
		   url: ""
		  
	 	});  */
	
}
</script>
