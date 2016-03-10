<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="select-tea-dialog2" class="easyui-dialog" closed="true" style="padding:5px;width:500px;height:425px;"
        title="选择教师姓名" iconCls="icon-search" modal="true"
        toolbar="#teachTask-select-tea-toolbar2" buttons="#select-tea-buttons2">
    <input id="openForm2" name="openForm2" type="hidden">
	<table id="selectTeaList2" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getTeaList.do"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>	   
				<th field="name" width="100">教师姓名</th>
				<th field="code" width="100">教师编号</th>
				
		  	</tr>
		</thead>    
	</table>
</div>

<div id="teachTask-select-tea-toolbar2" >
		<div>
			
			<td>教师姓名：</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 12px; padding: 5px" />
					
				</td> 
			<td>教师编号:</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 12px; padding: 5px" />
					
				</td> 
			 
		
			<button href="#" class="easyi-linkbutton" plain="true"
				onclick="searchTea2('#teachTask-select-tea-toolbar2', '#selectTeaList2')"
				iconCls="icon-search" >查询</button> 
		</div>
</div>
<div id="select-tea-buttons2">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectTea2()">选择该教师</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel2()">取消对该教师的选择</a>
</div>

<script type="text/javascript">
$(function(){
	 $(teachTaskEditForm).find("#teacherId2").val(0);
});
function searchTea2(toolbar, datagrid) {
	var name = $(toolbar).find("#name").val();
	var code = $(toolbar).find("#code").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		name: name,
		code: code
	});
}

function selectTea2(){
    var form = $('#select-tea-dialog2').find('#openForm2').val();
    var row = $('#selectTeaList2').datagrid('getSelected');
    if (row){
    	$(form).find("#teacherId2").val(row.id);
    	$(form).find("#teacherName2").textbox('setValue',row.name);
    
    }
	$('#select-tea-dialog2').dialog('close');
}
function cancel2(){
	var form = $('#select-tea-dialog2').find('#openForm2').val();
	$(form).find("#teacherId2").val(0);
	$(form).find("#teacherName2").textbox('setValue',"");
	$('#select-tea-dialog2').window('close')
}
</script>
