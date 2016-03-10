<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div style="width: 99%; height: auto">
	<div id="roleToolbar" style="padding: 5px; height: auto">
		<div>
			
			<td>角色名称:</td>
				<td><input class="easyui-validatebox textbox" id="roleName"
					name="roleName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>   
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchRole('#roleToolbar', '#roleList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="roleList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/role/getRoleList.do" toolbar="#roleOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="100" align="center" data-option="editor:'text'">职位名称</th>
				<th field="remark" width="100" align="center">备注</th>
			</tr>
		</thead>
	</table>
	
	<!-- 弹出新建角色的窗口 -->
	<div id="newRole" class="easyui-window" title="新建角色" data-options="modal:true,iconCls:'icon-add',closed:true" style="width:410px;height:300px;padding:5px;">
		<form id="newRoleForm" method="post">
			
			<table text-align="center">
			<tr>
			<div style="margin-bottom: 20px">
					<td><label for="newRoleName">角色名:</label> </td>
					<td><input class="easyui-validatebox textbox"
						id="newRoleName" name="newRoleName"
						style="width: 300px; height: 20px; padding: 12px"
						data-options="prompt:'请输入角色名',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</div>				
				</tr>
				<tr height="10px"><td></td></tr>
				<tr>
				
				<div style="margin-bottom: 20px">
					<td align="right"><label for="newRemark">备注:</label></td> <td><input class="easyui-textbox"
						id="newRemark" name="newRemark"
						style="width: 326px; height: 45px; padding: 12px"
						data-options="prompt:'备注(可不填)',iconWidth:38">
				</td></div>
			</tr>
			</table>

		
	</form>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addRole('#newRoleForm')" style="margin-right:20px;"> <span
					style="font-size: 14px;">提交</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#newRole').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
	
	
	<!-- 弹出修改角色的窗口 -->
	<div id="editRole" class="easyui-window" title="修改角色" data-options="modal:true,iconCls:'icon-add',closed:true" style="width:410px;height:300px;padding:5px;">
		<form id="editRoleForm" method="post">
			
			<table text-align="center">
			<tr>
			<div style="margin-bottom: 20px">
			<input id="editRoleId" type="hidden"/>
					<td><label for="editRoleName">角色名:</label> </td>
					<td><input class="easyui-validatebox textbox"
						id="editRoleName" name="editRoleName"
						style="width: 300px; height: 20px; padding: 12px"
						data-options="prompt:'请输入角色名',iconWidth:38,required:true,validType:'length[2,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</div>				
				</tr>
				<tr height="10px"><td></td></tr>
				<tr>
				
				<div style="margin-bottom: 20px">
					<td align="right"><label for="editRemark">备注:</label></td> <td><input class="easyui-textbox"
						id="editRemark" name="editRemark"
						style="width: 326px; height: 45px; padding: 12px"
						data-options="prompt:'备注(可不填)',iconWidth:38">
				</td></div>
			</tr>
			</table>

		
	</form>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="updateRole('#editRoleForm')" style="margin-right:20px;"> <span
					style="font-size: 14px;">提交</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#editRole').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
	
    <div id="roleOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#newRole').window('open');">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditRole()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRole()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-filter" plain="true" onclick="assignAuthority()">分配权限</a>
    </div>
</div>   
    
    <script type="text/javascript">
		function searchRole(toolbar, datagrid) {
			var name = $(toolbar).find("#roleName").val();
			
			//!-AJAX请求数据
			$(datagrid).datagrid('load', {
				name: name
			});
		}
        
		function addRole(form){

			//在提交数据之前执行表单验证
			$('#newRole').form('enableValidation').form('validate');

			//判断表单验证是否通过
			if(!$(form).form('validate')){
				return false;
			}

			$.post('role/addRole.do',{
        		
        		"name":$(form).find('#newRoleName').val(),
        		"remark":$(form).find('#newRemark').val()
        	},function(data){
				if(data.result==-2){
					$.messager.alert("操作提示", "新建失败，该角色已存在！","warning");
				}else{
					//清空newRoleForm表单
					$('#newRoleForm').form('clear');
					//关闭newRoleForm表单的验证
					$('#newRole').form('disableValidation').form('validate');
					$('#newRole').window('close');
					$.messager.alert("操作提示", "添加角色成功！","info");
					$('#roleList').datagrid('reload');
				}

        	},"json");
		}
		
        function toEditRole(){
            var row = $('#roleList').datagrid('getSelected');
            if (row){
                //openTab('role/roleEdit.do?id='+row.id,'编辑职位');
            	$('#editRoleId').val(row.id);
                $('#editRoleName').val(row.name);
            	$('#editRemark').textbox('setValue',row.remark);
                $('#editRole').window('open');
            	
            	
            }else{
				$.messager.alert("操作提示", "请选择角色！","warning");
			}
        }
        
        function updateRole(form){

			//在提交数据之前执行表单验证
			$('#editRole').form('enableValidation').form('validate');

			//判断表单验证是否通过
			if(!$(form).form('validate')){
				return false;
			}

        	var id=$(form).find('#editRoleId').val();
        	var name=$(form).find('#editRoleName').val();
        	var remark=$(form).find('#editRemark').val();
        	
        	$.post('role/updateRole.do',{
        		"id":id,
        		"name":name,
        		"remark":remark
        	},function(data){
				if(data.result==-2){
					$.messager.alert("操作提示", "角色名重复！","warning");
				}else{
					$.messager.alert("操作提示", "编辑角色成功！","info");
					$('#editRole').window('close');
					/* var tab=$('#main').tabs('getTab','角色列表');
					 tab.panel('refresh'); */
					$('#roleList').datagrid('reload');
				}

        	},"json");
        }
        
        function deleteRole(){
            var row = $('#roleList').datagrid('getSelected');
            if (row){
            	
                $.messager.confirm('请确认...','您确定要删除此角色吗?',function(r){
                    if (r){
                        $.post('role/deleteRole.do',{roleId:row.id},function(result){
                            if (result.success){
								$.messager.alert("操作提示", "删除角色成功！","info");
                                $('#roleList').datagrid('reload');    // reload the role data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: '删除角色失败'
                                });
                            }
                        },'json');
                    }
                });
            }else{
				$.messager.alert("操作提示", "请选择角色！","warning");
			}
        }
        
        function assignAuthority(){
        	var row=$('#roleList').datagrid('getSelected');
        	if(row){
        		openTab('role/roleAssignAuthority.do?id='+row.id,'分配角色权限');
        	}else{
				$.messager.alert("操作提示", "请选择角色！","warning");
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
