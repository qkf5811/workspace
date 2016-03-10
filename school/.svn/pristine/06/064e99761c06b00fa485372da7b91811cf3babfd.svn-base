<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div style="width: 99%; height: auto">
	<div id="singleTeaConEduToolbar" style="padding: 5px; height: auto">
		<div>
				<td><span>课程类型:</span></td>
				<td><select class="easyui-combobox" 
					name="courseType"  id="courseType"
					style="width: 100px; height: 31px; padding: 5px"
					data-options="editable:false,panelHeight: 'auto'" style="height:30px">
					<option value="">请选择</option>
					<c:forEach items="${courseList }" var="c">
						<option value="${c.id }">${c.name }</option>
					</c:forEach>
					</select>
				</td>
				<td><span>施教机构:</span></td>
					<td><input class="easyui-validatebox textbox" 
					name="teachOrganization"  id="teachOrganization"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				<td><span>课程名称:</span></td>
				<td><input class="easyui-validatebox textbox" 
					name="courseName"  id="courseName"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>    
				<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchSingleTeaConEdu('#singleTeaConEduToolbar', '#singleTeaConEduList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	
	<table id="singleTeaConEduList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getMyConEduList.do" 
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="courseType" width="150" align="center">课程类型</th>
				<th field="courseName" width="150" align="center">课程名称</th>
				<th field="teachOrganization" width="200" align="center">施教机构</th>
				<th field="startDate" width="150" align="center">开始时间</th>
				<th field="endDate" width="150" align="center">结束时间</th>
				<th field="studyHours" width="100" align="center">学时</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
</div>
<script type="text/javascript">
	/*
	$(function(){
		var obj = eval();
		alert(obj);
		if (obj.result < 0){
			$.messager.alert("操作提示","请先登录","error");
		}
	});
	*/
	
	function searchSingleTeaConEdu(toolbar,datagrid){
		var courseName = $(toolbar).find('#courseName').val();
		var courseType = $(toolbar).find('#courseType').combobox('getValue');
		var teachOrganization = $(toolbar).find('#teachOrganization').val();
		$(datagrid).datagrid('load',{
			"teachOrganization" : teachOrganization,
			"courseName" : courseName,
			"courseType" : courseType
		});
	}

</script>