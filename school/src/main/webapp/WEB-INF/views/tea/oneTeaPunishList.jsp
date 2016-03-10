<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div style="width: 99%; height: auto">
	<div id="singlePunishToolbar" style="padding: 5px; height: auto">
		<div>
			<td><span>处罚学年:</span></td>
			<td><select class="easyui-combobox" 
					name="schoolYearId"  id="schoolYearId"
					style="width: 100px; height: 31px; padding: 5px"
					data-options="editable:false,panelHeight: 'auto'">
					<option value="">请选择</option>
					<c:forEach var="s" items="${sList }">
						<option value="${s.id }">${s.name }</option>
					</c:forEach>	
				</select>
				</td> 
				 
				<td><span>处罚学期:</span></td>
				<td><select class="easyui-combobox" 
					name="schoolTermType"  id="schoolTermType"
					style="width: 100px; height: 31px; padding: 5px"
					data-options="editable:false,panelHeight: 'auto'">
					<option value="">请选择</option>
					<option value="32001">第一学期</option>
					<option value="32002">第二学期</option>
					</select>
				</td>
				
				<td><span>处罚名称:</span></td>
				<td><input class="easyui-validatebox textbox" 
					name="title"  id="title"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>    
				<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchSingleTeaPunish('#singlePunishToolbar', '#singlePunishList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	
	<table id="singlePunishList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getSingleTeacherPunishList.do" 
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="schoolYear" width="120" align="center">学年</th>
				<th field="schoolTermTypeStr" width="100" align="center">学期</th>
				<th field="title" width="150" align="center">处罚名称</th>
				<th field="punishmentTypeStr" width="150" align="center">处罚类型</th>
				<th field="content" width="220" align="center">处罚内容</th>
				<th field="punishDateStr" width="150" align="center">处罚日期</th>
				<th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>
</div>
<script type="text/javascript">
	function searchSingleTeaPunish(toolbar,datagrid){
		var schoolYearId = $(toolbar).find('#schoolYearId').combobox('getValue');
		var schoolTermType = $(toolbar).find('#schoolTermType').combobox('getValue');
		var title = $(toolbar).find('#title').val();
		$(datagrid).datagrid('load',{
			"schoolYearId" : schoolYearId,
			"schoolTermType" : schoolTermType,
			"title" : title
		});
	}
</script>