<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div style="margin: 5px" id="searchEquipmentCondition">
		<span>所属分类:</span>
			<select class="easyui-combobox" id="categoryRefer"
					name="categoryRefer" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['categoryRefer']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
        <span>设备名称:</span>
		<input class="easyui-textbox" id="equipmentRefer" name="equipmentRefer"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search" id="showEquipmentList"
			data-options="plain:false">查询</a> 
		<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#searchEquipmentCondition')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a>
		</div>
	
	<form id="equipmentForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="equipmentList" pagination="true"
				toolbar="#equipmentSettingToolbar"
				url="${contextPath}/equ/getEquipmentList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="name" width="120px" align="center">设备名称</th>
						<th field="brand" width="120px" align="center">设备品牌</th>
						<th field="model" width="120px" align="center">设备型号</th>
						<th field="categoryName" width="150px" align="center">所属分类</th>
						<th field="remark" width="180px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="equipmentSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addEquipmentInfo"
					data-options="plain:true" onclick="openNewEquipmentDialog()">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editEquipment"
					data-options="plain:true" onclick="openEditEquipmentDialog('#editEquipmentForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove"
					id="delEquipment" data-options="plain:true"
					onclick="DeleteEquipmentById()">删除</a>
			</div>
		</div>
	</form>
</div>



<!-- 弹出添加设备种类列表的对话框 -->
<div id="newEquipmentDialog" class="easyui-dialog" title="添加设备种类"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addEquipmentInfoBtn'"
	style="width: 400px; height: 410px; padding: 17px;">
	<form id="newEquipmentForm" method="post">
		<table cellpadding="7" align="center">			
			<tr>
				<td>设备名称:</td>
				<td><input class="easyui-textbox"
					id="nameSetting" name="nameSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
			<tr>
				<td>设备品牌:</td>
				<td><input class="easyui-textbox"
					id="brandSetting" name="brandSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
			<tr>
				<td>设备型号:</td>
				<td><input class="easyui-textbox"
					id="modelSetting" name="modelSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属分类:</td>
				<td><select class="easyui-combobox" id="categorySelect"
					name="categorySelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['categorySelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="newEquipmentRemark" name="newEquipmentRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="addEquipmentInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewEquipmentInfo('#newEquipmentForm')">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="clearNewEquipmentForm('#newEquipmentForm')">重置</a>
	</div>
</div>


<!-- 弹出修改设备种类列表的对话框 -->
<div id="editEquipmentDialog" class="easyui-dialog" title="修改设备种类"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editEquipmentBtn'"
	style="width: 400px; height: 410px; padding: 17px;">
	<form id="editEquipmentForm" method="post">
		<table cellpadding="7" align="center">
		<input id="editEquipmentId" type="hidden">			
			<tr>
				<td>设备名称:</td>
				<td><input class="easyui-textbox"
					id="editName" name="editName"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
			<tr>
				<td>设备品牌:</td>
				<td><input class="easyui-textbox"
					id="editBrand" name="editBrand"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
			<tr>
				<td>设备型号:</td>
				<td><input class="easyui-textbox"
					id="editModel" name="editModel"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属分类:</td>
				<td><select class="easyui-combobox" id="editCategorySelect"
					name="editCategorySelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editCategorySelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="editEquipmentRemark" name="editEquipmentRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="editEquipmentBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateEquipment('#editEquipmentForm')">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#editEquipmentDialog').dialog('close');disableValidationAtEdit();">取消</a>			
	</div>
</div>


<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<script type="text/javascript">
//清空查询条件
function cleanSearch(condition){
	    $(condition).find("#categoryRefer").combobox('select','');
	    $(condition).find("#equipmentRefer").textbox('setValue','');
	  }
/********************************点击查询按钮后执行动作******************************/

$(function() {
		$("#searchEquipmentCondition").find('#showEquipmentList').click(
				function() {
					var categoryRefer = $('#searchEquipmentCondition').find(
					'#categoryRefer').combobox(
					'getValue');
					var equipmentRefer = $('#searchEquipmentCondition').find(
					'#equipmentRefer').textbox('getValue');
					//!-AJAX请求数据
					$('#equipmentForm').find('#equipmentList').datagrid('load',{												
							"name" : equipmentRefer,
							"categoryId" : categoryRefer					
					});
				});

	})
	
	
/********************************弹出添加设备种类列表对话框****************************/
    function openNewEquipmentDialog() {
	
	   $('#newEquipmentDialog').dialog('open');
    }
	//重置数据
	function clearNewEquipmentForm(condition) {
		$(condition).find('#nameSetting').textbox('setValue','');
		$(condition).find('#brandSetting').textbox('setValue','');
		$(condition).find('#modelSetting').textbox('setValue','');
		$(condition).find('#categorySelect').combobox('setValue','');
		$(condition).find('#newEquipmentRemark').textbox('setValue','');		
		//取消表单验证
		disableValidationAtNew();
	}

	//添加设备种类
	function addNewEquipmentInfo(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;
		
		var name = $(form).find('#nameSetting').val();
		var brand = $(form).find('#brandSetting').val();
		var model = $(form).find('#modelSetting').val();
		var categoryId = $(form).find('#categorySelect').combobox('getValue');
		var remark = $(form).find('#newEquipmentRemark').val();
		$.post('equ/addEquipmentInfo.do', {
			"name" : name,
			"brand" : brand,
			"model" : model,
			"categoryId" : categoryId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "设备种类添加成功!", "info");
						$('#newEquipmentDialog').dialog('close');
						$('#equipmentForm').find('#equipmentList').datagrid(
								'reload');
						clearNewEquipmentForm('#newEquipmentForm');
					}
				})
				//取消表单验证
				disableValidationAtNew();
	}	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newEquipmentForm').form('disableValidation').form('validate');	
	}
	
	
	//*********************************修改一行设备种类记录*****************************************
	function openEditEquipmentDialog(form) {

		var row = $('#equipmentList').datagrid('getSelected');
		if (row) {
			$(form).find('#editEquipmentId').val(row.id);
			//重新设备名称
			$(form).find('#editName').textbox('setValue',row.name);
			//重新设备品牌
			$(form).find('#editBrand').textbox('setValue',row.brand);
			//重新设备型号
			$(form).find('#editModel').textbox('setValue',row.model);
			//重新设备分类
			$(form).find('#editCategorySelect').combobox('select',row.categoryId);
			//重新设备备注
			$(form).find('#editEquipmentRemark').textbox('setValue',row.remark);
			//打开窗口
			$('#editEquipmentDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的设备种类记录!", "warning");
	}

	function updateEquipment(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;

		var id = $(form).find('#editEquipmentId').val();
		var name = $(form).find('#editName').val();
		var brand = $(form).find('#editBrand').val();
		var model = $(form).find('#editModel').val();
		var categoryId = $(form).find('#editCategorySelect').combobox('getValue');
		var remark = $(form).find('#editEquipmentRemark').val();
		$.post('equ/updateEquipment.do', {
			"id" : id,
			"name" : name,
			"brand" : brand,
			"model" : model,
			"categoryId" : categoryId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "设备种类修改成功!", "info");
						$('#editEquipmentDialog').dialog('close');
						$('#equipmentForm').find('#equipmentList').datagrid('reload');
					}
				});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editEquipmentForm').form('disableValidation').form('validate');		
	}
		
	//*********************************删除一行教学楼信息记录*****************************************		
	function DeleteEquipmentById() {
		var row = $('#equipmentList').datagrid('getSelected');
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function(data) {
				if (data)
					$.post('equ/deleteEquipment.do', {
						id : row.id
					}, function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 1) {
							$.messager.alert("操作提示", "设备种类删除成功!", "info");
							$('#equipmentForm').find('#equipmentList').datagrid('reload');
						}
					})
				else
					;
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的设备种类!", "warning");
	}
</script>
