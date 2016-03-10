<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
	<table id="campusList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/sch/getCampusList.do"
		toolbar="#campusOperToolbar" rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="270px" align="center">校区名称</th>
				<th field="remark" width="270px" align="center">备注</th>
			</tr>
		</thead>
	</table>

	<!-- 弹出新建校区的窗口 -->
	<div id="newCampusDialog" class="easyui-dialog" title="新建校区"
		data-options="modal:true,iconCls:'icon-add',closed:true, buttons:'#addCampusBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="newCampusForm" method="post">
			<table  align="center">
			<tr height="20px">
				</tr>
				<tr>
					<td>校区名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="newCampusName" name="newCampusName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入校区名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</tr>
				<tr height="20px">
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input class="easyui-validatebox textbox" id="newRemark"
						name="newRemark" style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'备注(可不填)',iconWidth:38"></td>
				</tr>
			</table>
		</form>
		<div id="addCampusBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="addCampus('#newCampusForm')">提交</a>&nbsp;&nbsp;
			&nbsp;&nbsp; <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'" onclick="clearNewCampusForm();disableValidationAtNew();">
				重置</a>
		</div>
	</div>

	<!-- 弹出修改校区的窗口 -->
	<div id="editCampusDialog" class="easyui-dialog" title="修改校区"
		data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editCampusBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="editCampusForm" method="post">
			<table align="center">
				<tr height="20px">
				</tr>
				<tr>
					<input id="editCampusId" type="hidden" />
					<td>校区名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="editCampusName" name="editCampusName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入校区名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</tr>
				<tr height="20px">
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input class="easyui-validatebox textbox" id="editRemark"
						name="editRemark"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'备注(可不填)',iconWidth:38"></td>
				</tr>
			</table>
		</form>

		<div id="editCampusBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="updateCampus('#editCampusForm')">提交</a> &nbsp;&nbsp;
			&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="$('#editCampusDialog').dialog('close');disableValidationAtEdit();"> 取消</a>
		</div>
	</div>

	<div id="campusOperToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" id="addCourse"
			data-options="plain:true" onclick="openNewCampusDialog()">新建</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditCampus()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteCampus()">删除</a>

	</div>
</div>

<script type="text/javascript">

	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newCampusForm').form('disableValidation').form('validate');
		
	}
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editCampusForm').form('disableValidation').form('validate');
		
	}
	//清空数据
	function clearNewCampusForm() {
		$('#newCampusForm').find('#newCampusName').val("");
		$('#newCampusForm').find('#newRemark').val("");
	}
	//打开新建校区窗口
	function openNewCampusDialog() {
		$('#newCampusDialog').dialog('open');
		clearNewCampusForm();
	}
	//添加校区
	function addCampus(form) {
		//在提交数据之前执行表单验证
		$('#newCampusForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newCampusForm').form('validate'))
			return false;
		$.post('sch/addCampus.do', {
			"name" : $(form).find('#newCampusName').val(),
			"remark" : $(form).find('#newRemark').val()
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "校区添加成功!", "info");
				$('#newCampusDialog').dialog('close');
				$('#campusList').datagrid('reload');
				clearNewCampusForm();
			}
		})
		//取消表单验证
		disableValidationAtNew();
	}
    //修改校区信息
	function toEditCampus() {
		var row = $('#campusList').datagrid('getSelected');
		if (row) {
			$('#editCampusForm').find('#editCampusId').val(row.id);
			$('#editCampusForm').find('#editCampusName').val(row.name);
			$('#editCampusForm').find('#editRemark').val(row.remark);
			$('#editCampusDialog').dialog('open');

		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的校区信息!", "warning");
	}

	function updateCampus(form) {
		//在提交数据之前执行表单验证
		$('#editCampusForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editCampusForm').form('validate'))
			return false;
		var id = $(form).find('#editCampusId').val();
		var name = $(form).find('#editCampusName').val();
		var remark = $(form).find('#editRemark').val();
		$.post('sch/updateCampus.do', {
			"id" : id,
			"name" : name,
			"remark" : remark
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "校区信息修改成功!", "info");
				$('#editCampusDialog').dialog('close');
				$('#campusList').datagrid('reload');
			} else {
				$.messager.show({ // show error message
					title : 'Error',
					msg : '修改校区失败'
				});
			}
		});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	//删除课程
	function deleteCampus() {
		var row = $('#campusList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此校区吗?', function(r) {
				if (r) {
					$.post('sch/deleteCampus.do', {
						campusId : row.id
					}, function(data) {
						var obj = eval('(' + data + ')');
						if (obj.success == 1) {
							$.messager.alert("操作提示", "校区删除成功!", "info");
							$('#campusList').datagrid('reload'); // reload the campus data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '删除校区失败'
							});
						}
					});
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的课程!", "warning");
	}
</script>
