<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
	<form id="majorSettingDatagrid">
		<div style="margin-bottom: 20px">
			<table id="majorList" class="easyui-datagrid" style="width: auto;"
				pagination="true" url="${contextPath}/sch/getAllMajorPage.do"
				toolbar="#majorOperToolbar" rownumbers="true" singleSelect="true"
				data-options="pageSize:10">
				<thead>
					<tr>
						<th field="name" width="270px" align="center">专业名称</th>
						<th field="remark" width="270px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="majorOperToolbar">
			<a class="easyui-linkbutton" iconCls="icon-add" id="addMajorInfo"
				data-options="plain:true" onclick="openNewMajorDialog()">新建</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="toEditMajor()">编辑</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="deleteMajor()">删除</a>
		</div>
	</form>	
	<!-- 弹出新建专业的窗口 -->
	<div id="newMajorDialog" class="easyui-dialog" title="新建专业"
		data-options="modal:true,iconCls:'icon-add',closed:true, buttons:'#addMajorBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="newMajorForm" method="post">
			<table  align="center">
			<tr height="20px">
				</tr>
				<tr>
					<td>专业名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="newMajorName" name="newMajorName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入专业名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
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
		<div id="addMajorBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="addMajor('#newMajorForm')">提交</a>&nbsp;&nbsp;
			&nbsp;&nbsp; <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'" onclick="clearNewMajorForm();disableValidationAtNew();">
				重置</a>
		</div>
	</div>

	<!-- 弹出修改专业的窗口 -->
	<div id="editMajorDialog" class="easyui-dialog" title="修改专业"
		data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editMajorBtn'"
		style="width: 270px; height: 220px; padding: 5px;">
		<form id="editMajorForm" method="post">
			<table align="center">
				<tr height="20px">
				</tr>
				<tr>
					<input id="editMajorId" type="hidden" />
					<td>专业名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="editMajorName" name="editMajorName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入专业名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
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

		<div id="editMajorBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="updateMajor('#editMajorForm')">提交</a> &nbsp;&nbsp;
			&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="$('#editMajorDialog').dialog('close');disableValidationAtEdit();"> 取消</a>
		</div>
	</div>
</div>

<script type="text/javascript">

	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newMajorForm').form('disableValidation').form('validate');
		
	}
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editMajorForm').form('disableValidation').form('validate');
		
	}
	//清空数据
	function clearNewMajorForm() {
		$('#newMajorForm').find('#newMajorName').val("");
		$('#newMajorForm').find('#newRemark').val("");
	}
	//打开新建专业窗口
	function openNewMajorDialog() {
		$('#newMajorDialog').dialog('open');
		clearNewMajorForm();
	}
	//添加专业
	function addMajor(form) {
		//在提交数据之前执行表单验证
		$('#newMajorForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newMajorForm').form('validate'))
			return false;
		var name = $(form).find('#newMajorName').val()
		var remark = $(form).find('#newRemark').val()
		$.post('sch/toAddNewMajor.do', {
			"name" : name,
			"remark" : remark
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.result == 1) {
				$.messager.alert("操作提示", "专业添加成功!", "info");
				$('#newMajorDialog').dialog('close');
				$('#majorSettingDatagrid').find('#majorList').datagrid('reload');
				clearNewMajorForm();
			}
		})
		//取消表单验证
		disableValidationAtNew();
	}
    //修改专业信息
	function toEditMajor() {
		var row = $('#majorList').datagrid('getSelected');
		if (row) {
			$('#editMajorForm').find('#editMajorId').val(row.id);
			$('#editMajorForm').find('#editMajorName').val(row.name);
			$('#editMajorForm').find('#editRemark').val(row.remark);
			$('#editMajorDialog').dialog('open');

		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的专业信息!", "warning");
	}

	function updateMajor(form) {
		//在提交数据之前执行表单验证
		$('#editMajorForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editMajorForm').form('validate'))
			return false;
		var id = $(form).find('#editMajorId').val();
		var name = $(form).find('#editMajorName').val();
		var remark = $(form).find('#editRemark').val();
		$.post('sch/updateMajor.do', {
			"id" : id,
			"name" : name,
			"remark" : remark
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "专业信息修改成功!", "info");
				$('#editMajorDialog').dialog('close');
				$('#majorSettingDatagrid').find('#majorList').datagrid('reload');
			} else {
				$.messager.show({ // show error message
					title : 'Error',
					msg : '修改专业失败'
				});
			}
		});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	//删除专业
	function deleteMajor() {
		var row = $('#majorList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此专业吗?', function(r) {
				if (r) {
					$.post('sch/toDeleteMajor.do', {
						id : row.id
					}, function(data) {
						var obj = eval('(' + data + ')');
						if (obj.result == 1) {
							$.messager.alert("操作提示", "专业删除成功!", "info");
							$('#majorSettingDatagrid').find('#majorList').datagrid('reload'); // reload the major data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '删除专业失败'
							});
						}
					});
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的专业!", "warning");
	}
</script>
