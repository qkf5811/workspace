<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="width: 99%; height: auto" id="divideClass">
	<div style="padding: 3px; height: auto"> 
		<input name="classCount" type="hidden" /> 
		<input name="majorFieldStuCount" type="hidden" />
	</div>
	<table id="infoOfMajorField" class="easyui-datagrid" style="width: auto;"
		pagination="true" rownumbers="true" singleSelect="true"
		url = "stu/getInfoOfDivideClass.do"
		toolbar="#majorFieldInfoOperToolbar">
		<thead>
			<tr>
				<th field="fieldName" width="150" align="center">专业方向</th>
				<th field="classCount" width="150" align="center">专业方向开设班数</th>
				<th field="studentCount" width="150" align="center">所报专业方向学生人数</th>				
				<th field="divided_studentCount" width="150" align="center">已分班人数</th>
				<th field="not_divided_studentCount" width="150" align="center">未分班人数</th>
			</tr>
		</thead>
	</table>

	<div id="majorFieldInfoOperToolbar">
	    <a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="openTab('stu/toNotAutoDivideClassSettingList.do', '手动分班')">手动分班</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-man" plain="true" onclick="autoDivideClassSetting()">自动分班</a>
	</div>
</div>




<script type="text/javascript">
$(function(){
    $.messager.alert("温馨提示","1.分班设置包含两种设置方式：手动设置、自动设置。 <br/>2.如需先为个别学生设置固定班级，请先执行手动设置。 <br/>3.手动设置和自动设置均可多次执行。");
})
//执行自动分班
function autoDivideClassSetting(){
	  $.messager.confirm("请确认...", "自动分班之后将不能进行手动分班，如需单独为个别学生设置分班，请先进行手动分班！", function(data) {
			if (data)
				$.post('stu/autoDivideClassSetting.do', {					
				},function(data) {
							//var obj = eval('(' + data + ')');
							var obj =  JSON.parse(data);
							if (obj.result > 0) {
								$.messager.alert("操作提示", "自动分班设置成功!已设置"+obj.result+"名学生", "info");	
								//刷新各专业方向分班情况
								$('#divideClass').find('#infoOfMajorField').datagrid('reload');  
								//刷新新生管理页面
								$('#inputNewStuTable').find('#stuInfoTable').datagrid('reload');
							}else if(obj.result == 0){
								$.messager.alert("操作提示", "目前已无未分班的学生或部分专业方向未开设相关班级！", "warning");
							}
							else{
								$.messager.alert("操作提示", "自动分班设置失败，请稍候再试!", "warning");
							}
						})						
			else
				;				
		});
}

</script>
