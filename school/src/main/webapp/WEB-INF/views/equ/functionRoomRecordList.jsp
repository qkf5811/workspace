<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="functionRoomRecordToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>功能室名称：</td>
				<td><input class="easyui-validatebox textbox" id="funRoomName"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
					
					<td>使用者：</td>
				<td><input class="easyui-validatebox textbox" id="uname"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchfunctionRoomRecord('#functionRoomRecordToolbar', '#functionRoomRecordList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id=functionRoomRecordList class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getFunctionRoomRecordList.do" toolbar="#functionRoomRecordOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="roomName" width="15%" align="center">功能室名称</th>
				<th field="userName" width="15%" align="center">使用者</th>
				<th field="useFromDate" width="15%" align="center">使用开始日期</th>
				<th field="useToDate" width="15%" align="center">使用结束日期</th>
				<th field="remark" width="30%" align="center">备注</th>

			</tr>
		</thead>
	</table>
</div> 

<script type="text/javascript">
		function searchfunctionRoomRecord(toolbar, datagrid) {
			var funRoomName = $(toolbar).find("#funRoomName").val();
			var uname = $(toolbar).find("#uname").val();
			
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				funRoomName:funRoomName,
				uname: uname
			});
		}
       
</script> 