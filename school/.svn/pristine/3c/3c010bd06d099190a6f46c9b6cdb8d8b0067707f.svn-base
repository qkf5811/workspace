<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
#fin_exportStuCharge_div div {
	margin-left: 10px;
	margin-top:15px;
}

#fin_exportStuCharge_div label{
    font-size:15px;
}
</style>

<div id="fin_exportStuCharge_div"
	style="margin-top: 50px; margin-left: 200px">
	<div style="margin-left:70px;">
	<strong><label>导出批扣文件</label></strong>
	</div>
	<div> 
	<label>学年：</label>
	<select class="easyui-combobox"
		id="fin_studyYear" name="termType"
		data-options="editable:false,panelHeight: 'auto',width:120">
			<option value="0">请选择</option>
			<c:forEach items="${studyYearList}" var="studyYear">
				<option value="${studyYear.id}">${studyYear.name}</option>
			</c:forEach>

	</select> <a href="javascript:void(0)" class="easyui-linkbutton"
			 onclick="f_setCurrentStudyYear()">选择当前学年</a> 	
	</div> 
	<br /> 
	<div> 
	<label>学期：</label> <select
		class="easyui-combobox" id="fin_termType" name="termType"
		data-options="editable:false,panelHeight: 'auto',width:120">
			<option value="0">请选择</option>
			<option value="32001">第一学期</option>
			<option value="32002">第二学期</option>
	</select>
	</div> 
	<br/> 
	
	<div> 
	<label>年级：</label> <select
		class="easyui-combobox" id="fin_grade" name="grade"
		data-options="editable:false,panelHeight: 'auto',width:120">
			<option value="0">请选择</option>
			<c:forEach items="${gradeList}" var="grade">
				<option value="${grade.id}">${grade.name}</option>
			</c:forEach>
	</select>
	</div>
	<div style="padding-left:50px;">	

	    <a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-print" onclick="f_exportList()">导出批扣文件</a>
	 </div>
</div>



<script type="text/javascript">
	function f_exportList() {

		var studyYear = $('#fin_studyYear').combobox('getValue');
		var termType = $('#fin_termType').combobox('getValue');

		if (studyYear == '0') {
			$.messager.alert("操作提示", "请先选择学年", "warning");
			return;
		}
		/*
		if(termType=='0'){
		 $.messager.alert("操作提示","请先选择学期","warning");
		 return;
		}*/

		var grade = $('#fin_grade').combobox('getValue');

		window.open("${contextPath}/fin/exportList.do?studyYear=" + studyYear
				+ "&termType=" + termType + "&grade=" + grade);
	}

	function f_setCurrentStudyYear() {
		$.post("${contextPath}/fin/getCurrentStudyYear.do", function(data) {
			var value = $.parseJSON(data).result;

			if (value == '0') {
				$.messager.alert("操作提示", "系统没有找到当前的学年", "warning");
				return;
			}

			$('#fin_studyYear').combobox('setValues', value);

		})
	}
</script>
