<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="mainTainRecordToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>设备编号：</td>
			<td><input class="easyui-validatebox textbox" id="itemCode"
				name="itemCode" 
				style="width: 100px; height: 18px; padding: 5px" />
				
			</td> 
			
			<td>设备名称:</td>
			<td><input class="easyui-validatebox textbox" id="equName"
				name="equName" 
				style="width: 100px; height: 18px; padding: 5px" />
				
			</td> 
			
			<td>设备品牌:</td>
			<td><input class="easyui-validatebox textbox" id="equBrand"
				name="equBrand" 
				style="width: 100px; height: 18px; padding: 5px" />
				
			</td>  
			
			<td>维护人员名称:</td>
			<td><input class="easyui-validatebox textbox" id="maintainUserName"
				name="maintainUserName" 
				style="width: 100px; height: 18px; padding: 5px" />
				
			</td> 
			<button href="#" class="easyui-linkbutton" plain="true" 
				onclick="searchMaintainRecord('#mainTainRecordToolbar', '#maintainRecordList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="maintainRecordList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/maintainRecord/getMaintainRecordList.do" toolbar="#mainTainRecordOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="itemCode" width="100" align="center">设备编号</th>
				<th field="equName" width="100" align="center">设备名称</th>
				<th field="equBrand" width="100" align="center">设备品牌</th>
				<th field="equModel" width="100" align="center">设备型号</th>
				<th field="maintainUserName" width="100" align="center">维护人员姓名</th>
				<th field="maintainRecordSTime" width="200" align="center">维护时间</th>
			</tr>
		</thead>
	</table>
	
    <div id="mainTainRecordOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="lookMaintainDetails()">查看记录</a>
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditMainTainRecord()">编辑</a> -->
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteMainTainRecord()">删除</a>
    </div>
</div>   
    
    <script type="text/javascript">
		function searchMaintainRecord(toolbar, datagrid) {
			var itemCode=$(toolbar).find("#itemCode").val();
			var equName=$(toolbar).find("#equName").val();
			var equBrand=$(toolbar).find("#equBrand").val();
			var maintainUserName = $(toolbar).find("#maintainUserName").val();
			
			//alert(account);
			//alert(name);
			//!-AJAX请求数据
			//指定table的id，"load" 发送数据的时候自动向table的url发送异步请求。
			$(datagrid).datagrid('load', {
				itemCode: itemCode,
				equName:equName,
				equBrand:equBrand,
				maintainUserName: maintainUserName
			});
		}
        
		function lookMaintainDetails(){
			var row = $('#maintainRecordList').datagrid('getSelected');
            if (row){
            	openTab('maintainRecord/toMaintainRecordDetails.do?id='+row.id,'记录详情');   	
            }
		}
		/* 
        function toEditMainTainRecord(){
            var row = $('#maintainRecordList').datagrid('getSelected');
            //alert(row.id);
            if (row){
            	openTab('maintainRecord/toEditMaintainRecord.do?id='+row.id,'编辑维护记录');   	
            }
        }
         */
        function deleteMainTainRecord(){
            var row = $('#maintainRecordList').datagrid('getSelected');
            if (row){
                $.messager.confirm('请确认','您确定要删除此记录吗?',function(r){
                    if (r){
                        $.post('maintainRecord/deleteMaintainRecord.do',{id:row.id},function(result){
                            if (result.success){
                                $('#maintainRecordList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除记录失败'
                                });
                            }
                        },'json');
                    }
                });
            }
        }
        
</script>