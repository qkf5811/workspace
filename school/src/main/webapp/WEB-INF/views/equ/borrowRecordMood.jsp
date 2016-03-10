<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="borrowRecordToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>设备编号：</td>
				<td><input class="easyui-validatebox textbox" id="itemId"
					name="itemId" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>借用者姓名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchBorrowRecord('#borrowRecordToolbar', '#borrowRecordMood')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="borrowRecordMood" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getBorrowRecordList.do" toolbar="#borrowRecordOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="itemId" width="150" align="center">借用设备编号</th>
				<th field="itemName" width="150" align="center">借用设备名称</th>
				<th field="borrowUserId" width="100" align="center">借用者编号</th>
				<th field="name" width="100" align="center">借用者姓名</th>
				<th field="email" width="150" align="center">借用者邮箱</th>
				<th field="mobile" width="150" align="center">借用者移动电话</th>
				<th field="address" width="100" align="center">借用者地址</th>
				<th field="borrowDateSTime" width="200" align="center">借用日期</th>
				<th field="borrowDealineSTime" width="200" align="center">借用期限</th>
				<th field="remark" width="100" align="center">备注</th>

			</tr>
		</thead>
	</table>
	<div id="borrowRecordOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('equ/toAddBorrowRecord.do','新建借用记录')">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditBorrowRecord()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteBorrowRecord()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		function searchBorrowRecord(toolbar, datagrid) {
			var itemId=$(toolbar).find("#itemId").val();
			var name = $(toolbar).find("#name").val();
			
			//!-AJAX请求数据
			$(datagrid).datagrid('load', {
				itemId:itemId,
				name: name
			});
		}
        
        function toEditBorrowRecord(){
            var row = $('#borrowRecordMood').datagrid('getSelected');
            if (row){
            	openTab('equ/toEditBorrowRecord.do?id='+row.itemId,'编辑借用记录');
            }
        }
        

        
        function deleteBorrowRecord(){
        	
            var row = $('#borrowRecordMood').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此借用记录吗?',function(r){
                    if (r){
                        $.post('equ/deleteBorrowRecord.do',{id:row.itemId},function(result){
                            if (result.success){
                            	$.messager.alert("操作提示", "删除成功！","info");
                                $('#borrowRecordMood').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除借用记录失败'
                                });
                            }
                        },'json');
                    }
                });
            }
        }
        
       
</script> 