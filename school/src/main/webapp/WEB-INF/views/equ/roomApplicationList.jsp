<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="roomApplicationToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>申请名称：</td>
				<td><input class="easyui-validatebox textbox" id="appName"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
					
				<td>使用者：</td>
				<td><input class="easyui-validatebox textbox" id="uname"
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchroomApplication('#roomApplicationToolbar', '#roomApplicationList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id=roomApplicationList class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getRoomApplicationList.do" toolbar="#roomApplicationOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="appName" width="25%" align="center">申请名称</th>
				<th field="roomName" width="10%" align="center">功能室名称</th>
				<th field="userName" width="10%" align="center">使用者</th>
				<th field="useFromDate" width="15%" align="center">使用开始日期</th>
				<th field="useToDate" width="15%" align="center">使用结束日期</th>
				<th field="remark" width="20%" align="center">备注</th>

			</tr>
		</thead>
	</table>
	
	<div id="roomApplicationOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('equ/toAddRoomApplication.do','新建')">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditRoomApplication()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRoomApplication()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		function searchroomApplication(toolbar, datagrid) {
			var funRoomName = $(toolbar).find("#appName").val();
			var uname = $(toolbar).find("#uname").val();
			
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				appName:funRoomName,
				userName: uname
			});
		}
       
		 function toEditRoomApplication() {
	            var row = $('#roomApplicationList').datagrid('getSelected');
	            if (row) {
	              if ($('#main').tabs('exists', '编辑功能室申请')) {
	                $('#main').tabs('close', '编辑功能室申请')
	              }
	              openTab('equ/toEditRoomApplication.do?id=' + row.id + '&appName=' + row.appName , '编辑功能室申请');

	            }else{
	              $.messager.alert("操作提示", "请选择要编辑的功能室申请！","warning");
	            }
	          }

	        
	        function deleteRoomApplication(){
	            var row = $('#roomApplicationList').datagrid('getSelected');
	            if (row){
	                $.messager.confirm('请确认...','您确定要删除此功能室申请吗?',function(r){
	                  if (r){
	                        $.post('equ/deleteRoomApplication.do',{id:row.id},function(result){
	                          if (result.success){
	                           	 $.messager.alert("操作提示", "删除功能室申请成功！","info");
	                            $('#roomApplicationList').datagrid('reload');
	                          } else {
	                            $.messager.show({    // show error message
	                              title: 'Error',
	                              msg: '删除功能室申请失败'
	                            });
	                          }
	                        },'json');
	                  }
	                });
	              }else{
	                $.messager.alert("操作提示", "请选择要删除的功能室申请！","warning");
	              }
	        }
</script> 