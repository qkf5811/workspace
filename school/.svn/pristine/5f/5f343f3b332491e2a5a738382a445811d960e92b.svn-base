<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="functionRoomToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>功能室名称：</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				
				<td>所属教学楼：</td>
					<td><select class="easyui-combobox" id="selectBuildingId" name="selectBuildingId"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
						<option value="">请选择</option>
						<c:forEach items="${building}" var="obj">
							<option value="${obj.id}">${obj.name}</option>
						</c:forEach>		
					</select></td>
					
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchfunctionRoom('#functionRoomToolbar', '#FunctionRoomList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id=FunctionRoomList class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getFunctionRoomList.do" toolbar="#functionRoomOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="15%" align="center">功能室名称</th>
				<th field="buildingName" width="15%" align="center">所属教学楼</th>
				<th field="roomName" width="10%" align="center">所属教室</th>
				<th field="userName" width="10%" align="center">当前使用者</th>
				<th field="useFromDate" width="10%" align="center">使用开始日期</th>
				<th field="useToDate" width="10%" align="center">使用结束日期</th>
				<th field="remark" width="25%" align="center">备注</th>

			</tr>
		</thead>
	</table>
	<div id="functionRoomOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('equ/toAddFunctionRoom.do','新建功能室')">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditfunctionRoom()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deletefunctionRoom()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		function searchfunctionRoom(toolbar, datagrid) {
			var buildingId=$("#selectBuildingId").combobox("getValue");
			var name = $(toolbar).find("#name").val();
			
			
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				buildingId:buildingId,
				name: name
			});
		}
        
        
        function toEditfunctionRoom() {
            var row = $('#FunctionRoomList').datagrid('getSelected');
            if (row) {
              if ($('#main').tabs('exists', '编辑功能室')) {
                $('#main').tabs('close', '编辑功能室')
              }
              openTab('equ/toEditFunctionRoom.do?id=' + row.id, '编辑功能室');


            }else{
              $.messager.alert("操作提示", "请选择要编辑的功能室！","warning");
            }
          }

        
        function deletefunctionRoom(){
            var row = $('#FunctionRoomList').datagrid('getSelected');
            if (row){

                $.messager.confirm('请确认...','您确定要删除此功能室吗?',function(r){
                  if (r){
                        $.post('equ/deleteFunctionRoom.do',{id:row.id},function(result){
                          if (result.success){
                           	 $.messager.alert("操作提示", "删除功能室成功！","info");
                            $('#FunctionRoomList').datagrid('reload');
                          } else {
                            $.messager.show({    // show error message
                              title: 'Error',
                              msg: '删除功能室失败'
                            });
                          }
                        },'json');
                  }
                });
              }else{
                $.messager.alert("操作提示", "请选择要删除的功能室！","warning");
              }
        }
        
       
</script> 