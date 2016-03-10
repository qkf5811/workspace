<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="scrapRecordToolbar" style="padding: 5px; height: auto">
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
			
			<td>报废人员名称:</td>
			<td><input class="easyui-validatebox textbox" id="scrapUserName"
				name="scrapUserName" 
				style="width: 100px; height: 18px; padding: 5px" />
				
			</td>  
			<button href="#" class="easyui-linkbutton" plain="true" 
				onclick="searchScrapRecord('#scrapRecordToolbar', '#scrapRecordList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="scrapRecordList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/scrapRecord/getScrapRecordList.do" toolbar="#scrapRecordOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="itemCode" width="100" align="center">设备编号</th>
				<th field="equName" width="100" align="center">设备名称</th>
				<th field="equBrand" width="100" align="center">设备品牌</th>
				<th field="equModel" width="100" align="center">设备型号</th>
				<th field="scrapUserName" width="100" align="center">报废人员姓名</th>
				<th field="scrapRecordSTime" width="200" align="center">报废时间</th>
			</tr>
		</thead>
	</table>
	
    <div id="scrapRecordOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="lookScrapDetails()">查看记录</a>
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditScrapRecord()">编辑</a> -->
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteScrapRecord()">删除</a>
    </div>
</div>   
    
    <script type="text/javascript">
		function searchScrapRecord(toolbar, datagrid) {
			var itemCode=$(toolbar).find("#itemCode").val();
			var equName=$(toolbar).find("#equName").val();
			var equBrand=$(toolbar).find("#equBrand").val();
			var scrapUserName = $(toolbar).find("#scrapUserName").val();
			
			//alert(account);
			//alert(name);
			//!-AJAX请求数据
			//指定table的id，"load" 发送数据的时候自动向table的url发送异步请求。
			$(datagrid).datagrid('load', {
				itemCode: itemCode,
				equName:equName,
				equBrand:equBrand,
				scrapUserName: scrapUserName
			});
		}
        
		function lookScrapDetails(){
			var row = $('#scrapRecordList').datagrid('getSelected');
            if (row){
            	openTab('scrapRecord/toScrapRecordDetails.do?id='+row.id,'记录详情');   	
            }
		}
		
       /*  function toEditScrapRecord(){
            var row = $('#scrapRecordList').datagrid('getSelected');
            //alert(row.id);
            if (row){
            	openTab('scrapRecord/toEditScrapRecord.do?id='+row.id,'编辑报废记录');   	
            }
        } */
        
        function deleteScrapRecord(){
            var row = $('#scrapRecordList').datagrid('getSelected');
            if (row){
                $.messager.confirm('请确认','您确定要删除此记录吗?',function(r){
                    if (r){
                        $.post('scrapRecord/deleteScrapRecord.do',{id:row.id},function(result){
                            if (result.success){
                                $('#scrapRecordList').datagrid('reload');    // reload the user data
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