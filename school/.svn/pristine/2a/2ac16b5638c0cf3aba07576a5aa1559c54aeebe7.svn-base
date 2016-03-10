<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="select-finStu-dialog" class="easyui-dialog" closed="true" style="padding:5px;width:550px;height:425px;"
        title="选择学号" iconCls="icon-search" modal="true"
        toolbar="#fin_select-student-toolbar" buttons="#fin_select-student-buttons">
    <input id="stuOpenForm" name="stuOpenForm" type="hidden">
	<table id="selectFinStuList" class="easyui-datagrid" style="width: auto;"
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
<div id="fin_select-student-toolbar">
		<div>
			学生学号:<input id="code">  
			学生姓名:<input id="name">
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStudent('#fin_select-student-toolbar', '#selectFinStuList')"
				iconCls="icon-search">查询</button>
		</div>
</div>
<div id="fin_select-student-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectStudent()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#select-finStu-dialog').dialog('close')">取消</a>
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
    var form = $('#select-finStu-dialog').find('#stuOpenForm').val();
    var row = $('#selectFinStuList').datagrid('getSelected');
    if (row){
    	$(form).find("#studentId").val(row.id);
    	$(form).find("#finStuCode").val(row.code);
    	$(form).find("#finStuName").textbox("setValue",row.name);
    	$(form).find("#finGrade").val(row.gradeName);
    	$(form).find("#finClassName").val(row.finClassName);
    	$(form).find("#finMajor").val(row.majorName);
    	$(form).find("#finField").val(row.majorFieldName);
    }
	$('#select-finStu-dialog').dialog('close');
}
</script>
