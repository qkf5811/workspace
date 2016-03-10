<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="select-student-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:550px;height:425px;"
        title="选择学号" iconCls="icon-search" modal="true"
        toolbar="#select-student-toolbar" buttons="#select-student-buttons">
    <input id="openForm" name="openForm" type="hidden">
	<table id="selectStudentList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/stu/getStudentList.do"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="100">学生学号</th>
				<th field="name" width="100">学生姓名</th>
				<th field="majorFieldClassName" width="170">班级</th>
			</tr>
		</thead>
	</table>
</div>
<div id="select-student-toolbar">
		<div>
			学生学号:<input id="code">  
			学生姓名:<input id="name">
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStudent('#select-student-toolbar', '#selectStudentList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="select-student-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectStudent()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#select-student-dialog').dialog('close')">取消</a>
</div>

<script type="text/javascript">

function searchStudent(toolbar, datagrid) {
	var name = $(toolbar).find("#name").val();
	var code = $(toolbar).find("#code").val();
	
	//!-AJAX请求数据
	$(datagrid).datagrid('load', {
		name: name,
		code: code
	});
}

function selectStudent(){
    var form = $('#select-student-dialog').find('#openForm').val();
    var row = $('#selectStudentList').datagrid('getSelected');
    if (row){
    	$(form).find("#studentId").val(row.id);
    	$(form).find("#code").textbox('setValue',row.code);
    	$(form).find("#name").textbox('setValue',row.name);
     	$(form).find("#outClassName").textbox('setValue',row.majorFieldClassName); 
     	
     	//HIU add,加载异动类型
		$("#newStudentChangeForm").find('#changeType').combobox({   
			url:"${contextPath}/stu/getStudentChangeListByStuCode.do?stuCode="+row.code,   
			valueField:'id',   
			textField:'name'  
		});
    }
	$('#select-student-dialog').dialog('close');
}
</script>
