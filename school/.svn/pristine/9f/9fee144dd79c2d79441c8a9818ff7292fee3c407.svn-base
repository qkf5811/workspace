<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
	<div id="courseToolbar" style="padding: 5px; height: auto">
		<div>
		课程名称: <input class="easyui-validatebox textbox" id="courseName"
				name="name" style="width: 100px; height: 18px; padding: 5px" />
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchCourse('#courseToolbar', '#courseList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="courseList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/edu/getCourseList.do"
		toolbar="#courseOperToolbar" rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="270px" align="center">课程名称</th>
				<th field="code" width="270px" align="center">课程编号</th>
				<th field="remark" width="270px" align="center">课程备注</th>
			</tr>
		</thead>
	</table>

	<!-- 弹出新建课程的窗口 -->
	<div id="newCourseDialog" class="easyui-dialog" title="新建课程"
		data-options="modal:true,iconCls:'icon-add',closed:true, buttons:'#addCourseBtn'"
		style="width: 300px; height: 270px; padding: 5px;">
		<form id="newCourseForm" method="post">

			<table  align="center">
			<tr height="10px">
				</tr>
				<tr>
					<td>课程名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="newCourseName" name="newCourseName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入课程名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>课程编号:</td>
					<td><input class="easyui-validatebox textbox"
						id="newCourseCode" name="newCourseCode"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入课程编号',iconWidth:38,required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' ">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td align="right">备注:</td>
					<td><input class="easyui-validatebox textbox" id="newRemark"
						name="newRemark" style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'备注(可不填)',iconWidth:38"></td>
				</tr>
			</table>
		</form>
		<div id="addCourseBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="addCourse('#newCourseForm')">提交</a>&nbsp;&nbsp;
			&nbsp;&nbsp; <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'" onclick="clearNewCourseForm();disableValidationAtNew();">
				重置</a>
		</div>
	</div>

	<!-- 弹出修改课程的窗口 -->
	<div id="editCourseDialog" class="easyui-dialog" title="修改课程"
		data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editCourseBtn'"
		style="width: 300px; height: 270px; padding: 5px;">
		<form id="editCourseForm" method="post">
			<table align="center">
				<tr height="10px">
				</tr>
				<tr>
					<input id="editCourseId" type="hidden" />
					<td>课程名称:</td>
					<td><input class="easyui-validatebox textbox"
						id="editCourseName" name="editCourseName"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入课程名称',iconWidth:38,required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' ">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>课程编号:</td>
					<td><input class="easyui-validatebox textbox"
						id="editCourseCode" name="editCourseCode"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入课程编号',iconWidth:38,required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' ">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>开设专业:</td>
					<td><select class="easyui-combobox" id="majorSelectByEdit"
						name="majorSelectByEdit" style="width: 100px; height: 30px"
						data-options="novalidate:true , panelHeight: 'auto' ,editable:false"
						validtype="selectRequired['majorSelectByEdit']" >
							<option value="">请选择</option>
							<c:forEach items="${majorList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach></td>
				</tr>
				<tr height="7px">
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

		<div id="editCourseBtn" style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="updateCourse('#editCourseForm')">提交</a> &nbsp;&nbsp;
			&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="$('#editCourseDialog').dialog('close');disableValidationAtEdit();"> 取消</a>
		</div>
	</div>

	<div id="courseOperToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" id="addCourse"
			data-options="plain:true" onclick="openNewCourseDialog()">新建</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditCourse()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteCourse()">删除</a>

	</div>
</div>

<script type="text/javascript">
	function searchCourse(toolbar, datagrid) {
		var name = $(toolbar).find("#courseName").val();
		//!-AJAX请求数据
		$('#courseList').datagrid({
			url : "${contextPath}/edu/getCourseList.do",
			queryParams : {
				"name" : name,
			}
		});

	}
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newCourseForm').form('disableValidation').form('validate');
		
	}
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editCourseForm').form('disableValidation').form('validate');
		
	}
	//清空数据
	function clearNewCourseForm() {
		$('#newCourseForm').find('#newCourseName').val("");
		$('#newCourseForm').find('#newCourseCode').val("");
		$('#newCourseForm').find('#newRemark').val("");
	}
	//打开新建课程窗口
	function openNewCourseDialog() {
		$('#newCourseDialog').dialog('open');
		clearNewCourseForm();
	}
	//添加课程
	function addCourse(form) {
		//在提交数据之前执行表单验证
		$('#newCourseForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newCourseForm').form('validate'))
			return false;
		$.post('edu/addCourse.do', {
			"name" : $(form).find('#newCourseName').val(),
			"code" : $(form).find('#newCourseCode').val(),
			"remark" : $(form).find('#newRemark').val()
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "课程添加成功!", "info");
				$('#newCourseDialog').dialog('close');
				$('#courseList').datagrid('reload');
				clearNewCourseForm();
			}
		})
		//取消表单验证
		disableValidationAtNew();
	}
    //修改课程
	function toEditCourse() {
		var row = $('#courseList').datagrid('getSelected');
		if (row) {
			$('#editCourseForm').find('#editCourseId').val(row.id);
			$('#editCourseForm').find('#editCourseName').val(row.name);
			$('#editCourseForm').find('#editCourseCode').val(row.code);
			$('#editCourseForm').find('#majorSelectByEdit').combobox('select',row.majorId);
			$('#editCourseForm').find('#editRemark').val(row.remark);
			$('#editCourseDialog').dialog('open');

		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的课程!", "warning");
	}

	function updateCourse(form) {
		//在提交数据之前执行表单验证
		$('#editCourseForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editCourseForm').form('validate'))
			return false;
		var id = $(form).find('#editCourseId').val();
		var name = $(form).find('#editCourseName').val();
		var code = $(form).find('#editCourseCode').val();
		var majorId = $(form).find('#majorSelectByEdit').combobox('getValue');
		var remark = $(form).find('#editRemark').val();
		$.post('edu/updateCourse.do', {
			"id" : id,
			"name" : name,
			"code" : code,
			"majorId" : majorId,
			"remark" : remark
		}, function(data) {
			var obj = eval('(' + data + ')');
			if (obj.success == 1) {
				$.messager.alert("操作提示", "课程修改成功!", "info");
				$('#editCourseDialog').dialog('close');
				$('#courseList').datagrid('reload');
			} else {
				$.messager.show({ // show error message
					title : 'Error',
					msg : '修改课程失败'
				});
			}
		});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	//删除课程
	function deleteCourse() {
		var row = $('#courseList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要删除此课程吗?', function(r) {
				if (r) {
					$.post('edu/deleteCourse.do', {
						courseId : row.id
					}, function(data) {
						var obj = eval('(' + data + ')');
						if (obj.success == 1) {
							$.messager.alert("操作提示", "课程删除成功!", "info");
							$('#courseList').datagrid('reload'); // reload the course data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '删除课程失败'
							});
						}
					});
				}
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的课程!", "warning");
	}
</script>
