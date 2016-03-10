<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
<div id="allCourseToolbar" style="padding: 5px; height: auto">
		<div>
			
				<td>学年：</td>
					<td><select class="easyui-combobox" id="studyYearId" name="studyYearId"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
						<option value="0">请选择</option>
						<c:forEach items="${studyYearList}" var="obj">
							<option value="${obj.id}">${obj.name}</option>
						</c:forEach>	
					</select>
				</td>
				
				
				<td>学期：</td>
					<td><select class="easyui-combobox" id="termType" name="termType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
						<option value="0">请选择</option>
						<c:forEach items="${termTypeList}" var="obj">
							<option value="${obj.id}">${obj.name}</option>
						</c:forEach>
					</select>
				</td>
			
			
			<td>课程名称：</td>
				<td><input class="easyui-validatebox textbox" id="courseName"
					name="courseName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				
				
				<td>所属专业：</td>
					<td><select class="easyui-combobox" id="majorSelect" name="majorSelect"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
						<option value="">请选择</option>
						<c:forEach items="${majorList}" var="obj">
							<option value="${obj.id}">${obj.name}</option>
						</c:forEach>		
					</select>
				</td>
					
					
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchallCourse('#allCourseToolbar', '#allCourseList')"
				iconCls="icon-search">查询</button>
		</div>
		</div>
	<table id="allCourseList" class="easyui-datagrid" style="width: auto;" toolbar="#allCourseOpenToolbar"
		pagination="true" url="${contextPath}/edu/getAllCourseList.do"
		 rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="studyYearName" width="10%" align="center">学年</th>
				<th field="termTypeStr" width="10%" align="center">学期</th>
				<th field="name" width="15%" align="center">课程名称</th>
				<th field="code" width="10%" align="center">课程编号</th>
				<th field="major" width="10%" align="center">所属专业</th>
			</tr>
		</thead>
	</table>

	<div id="allCourseOpenToolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" data-options="plain:true"
			onclick="showCourseCount()">成绩统计</a>
	</div>

</div>

<script type="text/javascript">
	function showCourseCount() {
		var row = $('#allCourseList').datagrid('getSelected');
		if (row) {
			if ($('#main').tabs('exists', '成绩统计')) {
		        $('#main').tabs('close', '成绩统计')
		    }
			var type = 1
			if(row.scoreTypeStr == '等级制') {
				type= 2
			}
			var obj = "?courseId=" + row.id + "&studyYearId=" + row.studyYearId + "&termType=" +row.termType
					+ "&studyYearName=" + row.studyYearName + "&termTypeStr=" + row.termTypeStr
			openTab("edu/toCourseCount.do"+ obj, "成绩统计");
		}else {
			$.messager.alert("操作提示", "请先选择一条课程信息!", "warning");
			return;
		}
	}

	function searchallCourse(toolbar, datagrid) {
		var name = $(toolbar).find("#courseName").val();
		var majorId = $(toolbar).find("#majorSelect").combobox('getValue');
		var studyYearId = $(toolbar).find("#studyYearId").combobox('getValue');
		var termType = $(toolbar).find("#termType").combobox('getValue');
		//!-AJAX请求数据
		$('#allCourseList').datagrid({
			url : "${contextPath}/edu/getAllCourseList.do",
			queryParams : {
				"name" : name,
				"major" : majorId,
				"studyYearId" : studyYearId,
				"termType" : termType
			}
		});

	}
	
</script>
