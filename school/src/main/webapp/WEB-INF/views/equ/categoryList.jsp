<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
	<table id="categoryList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getCategoryList.do"
		toolbar="#categoryOperToolbar" rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="270px" align="center">分类名称</th>
				<th field="remark" width="270px" align="center">备注</th>
			</tr>
		</thead>
	</table>

	<!-- 弹出新建设备分类的窗口 -->
	<div id="newCategoryDialog" class="easyui-dialog" title="新建设备分类"
		data-options="modal:true,iconCls:'icon-add',closed:true, buttons:'#addCategoryBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="newCategoryForm" method="post">
			<table  align="center">
			<tr height="20px">
				</tr>
				<tr>
					<td>分类名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="newCategoryName" name="newCategoryName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入分类名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
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
		<div id="addCategoryBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="addCategory('#newCategoryForm')">提交</a>&nbsp;&nbsp;
			&nbsp;&nbsp; <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'" onclick="clearNewCategoryForm();disableValidationAtNew();">
				重置</a>
		</div>
	</div>

	<!-- 弹出修改设备分类的窗口 -->
	<div id="editCategoryDialog" class="easyui-dialog" title="修改设备分类"
		data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editCategoryBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="editCategoryForm" method="post">
			<table align="center">
				<tr height="20px">
				</tr>
				<tr>
					<input id="editCategoryId" type="hidden" />
					<td>分类名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="editCategoryName" name="editCategoryName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入分类名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
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

		<div id="editCategoryBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="updateCategory('#editCategoryForm')">提交</a> &nbsp;&nbsp;
			&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="$('#editCategoryDialog').dialog('close');disableValidationAtEdit();"> 取消</a>
		</div>
	</div>

	<div id="categoryOperToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" id="addCourse"
			data-options="plain:true" onclick="openNewCategoryDialog()">新建</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditCategory()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteCategory()">删除</a>

	</div>
</div>

<script type="text/javascript">

	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newCategoryForm').form('disableValidation').form('validate');
		
	}
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editCategoryForm').form('disableValidation').form('validate');
		
	}
	//清空数据
	function clearNewCategoryForm() {
		$('#newCategoryForm').find('#newCategoryName').val("");
		$('#newCategoryForm').find('#newRemark').val("");
	}
	//打开新建设备分类窗口
	function openNewCategoryDialog() {
		$('#newCategoryDialog').dialog('open');
		clearNewCategoryForm();
	}
	//添加设备分类
	function addCategory(form) {
		//在提交数据之前执行表单验证
		$('#newCategoryForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newCategoryForm').form('validate'))
			return false;
		$.post('equ/addCategoryInfo.do', {
			"name" : $(form).find('#newCategoryName').val(),
			"remark" : $(form).find('#newRemark').val()
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "分类添加成功!", "info");
				$('#newCategoryDialog').dialog('close');
				$('#categoryList').datagrid('reload');
				clearNewCategoryForm();
			}
		})
		//取消表单验证
		disableValidationAtNew();
	}
    //修改分类信息
	function toEditCategory() {
		var row = $('#categoryList').datagrid('getSelected');
		if (row) {
			$('#editCategoryForm').find('#editCategoryId').val(row.id);
			$('#editCategoryForm').find('#editCategoryName').val(row.name);
			$('#editCategoryForm').find('#editRemark').val(row.remark);
			$('#editCategoryDialog').dialog('open');

		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的分类信息!", "warning");
	}

	function updateCategory(form) {
		//在提交数据之前执行表单验证
		$('#editCategoryForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editCategoryForm').form('validate'))
			return false;
		var id = $(form).find('#editCategoryId').val();
		var name = $(form).find('#editCategoryName').val();
		var remark = $(form).find('#editRemark').val();
		$.post('equ/updateCategory.do', {
			"id" : id,
			"name" : name,
			"remark" : remark
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "分类信息修改成功!", "info");
				$('#editCategoryDialog').dialog('close');
				$('#categoryList').datagrid('reload');
			} else {
				$.messager.show({ // show error message
					title : 'Error',
					msg : '修改分类失败'
				});
			}
		});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	//删除课程
	function deleteCategory() {
		var row = $('#categoryList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此分类吗?', function(r) {
				if (r) {
					$.post('equ/deleteCategory.do', {
						categoryId : row.id
					}, function(data) {
						var obj = eval('(' + data + ')');
						if (obj.success == 1) {
							$.messager.alert("操作提示", "分类删除成功!", "info");
							$('#categoryList').datagrid('reload'); // reload the category data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '删除分类失败'
							});
						}
					});
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的分类!", "warning");
	}
</script>
