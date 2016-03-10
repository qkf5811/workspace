<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div style="margin: 5px" id="searchCourseToQueryScoCondition">
		<span>学年:</span>
			<select class="easyui-combobox" id="studyYearRefer"
					name="studyYearRefer" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['studyYearRefer']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${studyYearList}" var="studyYear">
							<option value="${studyYear.id}">${studyYear.name}</option>
						</c:forEach>
			</select>
		<span>学期:</span>
			<select class="easyui-combobox" id="termTypeRefer"
					name="termTypeRefer" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['termTypeRefer']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${termTypeList}" var="termType">
							<option value="${termType.id}">${termType.name}</option>
						</c:forEach>
			</select>	
        <span>课程名称:</span>
		<input class="easyui-textbox" id="courseNameRefer" name="courseNameRefer"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search" id="showCourseToQueryScoList"
			data-options="plain:false">查询</a> 
		<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#searchCourseToQueryScoCondition')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a>
		</div>
	
	<form id="courseToQueryScoForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="courseToQueryScoList" pagination="true"
				toolbar="#buildingSettingToolbar"
				url="edu/getCourseToQueryScoByHTList.do?classId=${classId }" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="courseCode" width="160px" align="center">课程编号</th>
						<th field="courseName" width="160px" align="center">课程名称</th>
						<th field="studyYearStr" width="160px" align="center">学年</th>
						<th field="termTypeStr" width="160px" align="center">学期</th>
						<th field="className" width="160px" align="center">所属班级</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="buildingSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-search" id="queryScoreByCourseOfHT"
					data-options="plain:true" onclick="queryScoreByTeachCourseId()">查询课程成绩</a>
			</div>
		</div>
	</form>
</div>



<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<script type="text/javascript">
//清空查询条件
function cleanSearch(condition){
	    $(condition).find("#studyYearRefer").combobox('select','');
	    $(condition).find("#termTypeRefer").combobox('select','');
	    $(condition).find("#courseNameRefer").textbox('setValue','');
	  }
/********************************点击查询按钮后执行动作******************************/

$(function() {
		$("#searchCourseToQueryScoCondition").find('#showCourseToQueryScoList').click(
				function() {
					var studyYearRefer = $('#searchCourseToQueryScoCondition').find(
					'#studyYearRefer').combobox(
					'getValue');
					var termTypeRefer = $('#searchCourseToQueryScoCondition').find(
					'#termTypeRefer').combobox(
					'getValue');
					var courseNameRefer = $('#searchCourseToQueryScoCondition').find(
					'#courseNameRefer').textbox('getValue');
					//alert('studyYearRefer : '+studyYearRefer+' , termTypeRefer : '+termTypeRefer);
					//!-AJAX请求数据
					$('#courseToQueryScoForm').find('#courseToQueryScoList').datagrid('load',{												
							"studyYearId" : studyYearRefer,
							"termType" : termTypeRefer,
							"courseName" : courseNameRefer					
					});
				});

	})
		


	//*********************************查询课程成绩*****************************************		
	function queryScoreByTeachCourseId() {
		var row = $('#courseToQueryScoList').datagrid('getSelected');
		//alert(encodeURI(row.studyYearStr));
		if (row) {
			//alert(row.termType)
			openTab(
					"edu/queryScoreByTeachCourseId.do?classId=${classId }&teachCourseId="
							+ row.teachCourseId + "&studyYear="
							+ encodeURI(row.studyYearStr) + "&termType="
							+ encodeURI(row.termTypeStr) + "&courseName="
							+ encodeURI(row.courseName) + "&courseCode="
							+ encodeURI(row.courseCode) + "&studyYearId="
							+ row.studyYearId + "&termTypeId=" + row.termType
							+ "&courseId=" + row.courseId + "&coursePlanId="
							+ row.coursePlanId, "课程成绩");

		} else
			$.messager.alert("操作提示", "请先选择一门需要查询成绩的课程!", "warning");
	}
</script>
