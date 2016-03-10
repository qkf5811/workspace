<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="teaFamilyDiv" style="width: 99%; height: auto">
	<input id="teacherIdByFamily" value="${id }" hidden="true">
	<div style="margin: 15px"><strong>${name }</strong> 的家庭信息:</div>
	<table id="teaFamilyList" class="easyui-datagrid" style="width: auto;"
		pagination="true"  toolbar="#teaFamilyOperToolbar"  url="${contextPath}/tea/getTeaFamilyList.do?id=${id}"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="120" align="center">家庭成员姓名</th>
				<th field="relationTypeStr" width="120" align="center">亲属关系</th>
				<th field="sex" width="100" align="center">家庭成员性别</th>
				<th field="birthdayStr" width="140" align="center">家庭成员出生年月</th>
				<th field="phone" width="150" align="center">家庭成员联系方式</th>
				<th field="remark" width="350" align="center">备注</th>
			</tr>
		</thead>
	</table>
	<div id="teaFamilyOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addTeaFamily()"">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditTeacherFamily()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTeaFamily()">删除</a>
    </div>
</div> 

<script type="text/javascript">
		function addTeaFamily(){
			var teacherId =$('#teaFamilyDiv').find("#teacherIdByFamily").val();
			openTab('tea/toAddTeacherFamily.do?teacherId='+teacherId,'新建家庭成员');
                    
               
		}
      

        
        function deleteTeaFamily(){
        	
            var row = $('#teaFamilyList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此教职工家庭信息吗?',function(r){
                    if (r){
                        $.post('tea/deleteTeaFamily.do',{id:row.id},function(result){
                            if (result.success){
                            	$.messager.alert("操作提示", "删除成功！","info");
                                $('#teaFamilyList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除教职工家庭信息'
                                });
                            }
                        },'json');
                    }
                });
            } else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}
        }
        function toEditTeacherFamily(){
            var row = $('#teaFamilyList').datagrid('getSelected');
            var teacherId =$('#teaFamilyDiv').find("#teacherIdByFamily").val();
          
           if (row){
            	openTab('tea/toEditTeacherFamily.do?id='+row.id+'&teacherId='+teacherId,'编辑教职工家庭信息');
            } else {
    			$.messager.alert("操作提示", "请先选择一行!", "warning");
    		}
        }
        
       
</script> 