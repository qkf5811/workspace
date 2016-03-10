<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div id="teaChangeToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>教师姓名：</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>教师编号:</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeaChange('#teaChangeToolbar', '#teaChangeList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="teaChangeList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getTeaChangeList.do" toolbar="#teaChangeOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="90" align="center">教师姓名</th>
				<th field="code" width="120" align="center">教师编号</th>
				<!-- <th class="changeType" field="changeTypeStr" width="100" align="center">异动类型</th> -->
				<th data-options="field:'changeTypeStr',width:80,align:'right',styler:cellStyler">异动类型</th>
				
				<th field="cause" width="250" align="center">异动原因</th>
				<th field="changeDateStr" width="100" align="center">异动日期</th>
				<th field="operUser" width="90" align="center">处理人员</th>
				<th field="remark" width="250" align="center">备注</th>
			</tr>
		</thead>
	</table>
	<div id="teaChangeOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('tea/toAddTeaChange.do','新建教师异动')">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTeaChange()">撤销记录</a>
    </div>
</div> 

<script type="text/javascript">
		function cellStyler(value,row,index){
    		if (value == "病休"){
        		return 'background-color:#f58220;';
    		}
    		if (value == "离职"){
    			return 'background-color:#ffee00;';
    		}
    		if (value == "调动"){
        		return 'background-color:#8552a1;';
    		}
    		if (value == "退休"){
        		return 'background-color:#ff0000;';
    		}
    		
		}

		function searchTeaChange(toolbar, datagrid) {
			var name=$(toolbar).find("#name").val();
			var code = $(toolbar).find("#code").val();
			
			
			//!-AJAX请求数据
		
			$(datagrid).datagrid('load', {
				name:name,
				code: code
			});
		}
        
      

        
        function deleteTeaChange(){
        	
            var row = $('#teaChangeList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要撤销此教师异动信息吗?',function(r){
                    if (r){
                        $.post('tea/deleteTeaChange.do',{id:row.id,code:row.code},function(result){
                            if (result.success){
                            	$.messager.alert("操作提示", "撤销成功！","info");
                                $('#teaChangeList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '撤销教师异动信息失败'
                                });
                            }
                        },'json');
                    }
                });
            }
            else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}
        }
        
       
</script> 