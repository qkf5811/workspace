<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="userToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>帐号：</td>
				<td><input class="easyui-validatebox textbox" id="account"
					name="account" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>名称:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchUser('#userToolbar', '#userList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="userList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/user/getUserList.do" toolbar="#userOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="account" width="100" align="center">帐号</th>
				<th field="password" width="100" align="center">密码</th>
				<th field="name" width="100" align="center">姓名</th>
				<th field="sex" width="100" align="center">性别</th>
				<th field="departmentName" width="100" align="center">所属部门</th>
				<th field="roleName" width="100" align="center">角色</th>
				<th field="email" width="100" align="center">注册邮箱</th>
				<th field="mobile" width="100" align="center">移动电话</th>
				<th field="address" width="100" align="center">地址</th>
				<th field="isBlockedString" width="100" align="center">是否冻结</th>
			</tr>
		</thead>
	</table>
	
	
	
	
	
	
    <div id="userOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('user/toAddUser.do','新建人员')">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditUser()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-filter" plain="true" onclick="assignRole()">分配角色</a>
    </div>
</div>   
    
    <script type="text/javascript">
		function searchUser(toolbar, datagrid) {
			var account=$(toolbar).find("#account").val();
			var name = $(toolbar).find("#name").val();

			//!-AJAX请求数据
			$(datagrid).datagrid('load', {
				account:account,
				name: name
			});
		}
        
		
		
        function toEditUser(){
            var row = $('#userList').datagrid('getSelected');
            if (row){
            	openTab('user/toEditUser.do?id='+row.id,'编辑用户');
            	
            	
            }else{
				$.messager.alert("操作提示", "请选择用户！","warning");
			}
        }
        
        function updateRole(){
        	var id=$('#editRoleId').val();
        	var name=$('#editRoleName').val();
        	var remark=$('#editRemark').val();
        	
        	$.post('role/updateRole.do',{
        		"id":id,
        		"name":name,
        		"remark":remark
        	},function(result){
        		$('#editRole').window('close');
        		var tab=$('#main').tabs('getTab','角色列表');
        		tab.panel('refresh');
        	},"json");
        }
        
        function deleteUser(){
            var row = $('#userList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此用户吗?',function(r){
                    if (r){
                        $.post('user/deleteUser.do',{id:row.id},function(result){
                            if (result.success){
								$.messager.alert("操作提示", "删除用户成功！","info");
                                $('#userList').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除用户失败'
                                });
                            }
                        },'json');
                    }
                });
            }else{
				$.messager.alert("操作提示", "请选择用户！","warning");
			}
        }
        
        function assignRole(){
        	var row=$('#userList').datagrid('getSelected');
        	if(row){
        		openTab('user/userAssignRole.do?id='+row.id,'分配用户角色');
        	}else{
				$.messager.alert("操作提示", "请选择用户！","warning");
			}
        }
</script>

<!-- <script>
		$(function(){
			$('input.easyui-validatebox').validatebox({
				tipOptions: {	// the options to create tooltip
					showEvent: 'mouseenter',
					hideEvent: 'mouseleave',
					showDelay: 0,
					hideDelay: 0,
					zIndex: '',
					onShow: function(){
						if (!$(this).hasClass('validatebox-invalid')){
							if ($(this).tooltip('options').prompt){
								$(this).tooltip('update', $(this).tooltip('options').prompt);
							} else {
								$(this).tooltip('tip').hide();
							}
						} else {
							$(this).tooltip('tip').css({
								color: '#000',
								borderColor: '#CC9933',
								backgroundColor: '#FFFFCC'
							});
						}
					},
					onHide: function(){
						if (!$(this).tooltip('options').prompt){
							$(this).tooltip('destroy');
						}
					}
				}
			}).tooltip({
				position: 'right',
				content: function(){
					var opts = $(this).validatebox('options');
					return opts.prompt;
				},
				onShow: function(){
					$(this).tooltip('tip').css({
						color: '#000',
						borderColor: '#CC9933',
						backgroundColor: '#FFFFCC'
					});
				}
			});
		});
	</script>

<script type="text/javascript">
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
	</script> -->