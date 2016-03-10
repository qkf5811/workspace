<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div style="margin: 5px" id="searchMajorFieldCondition">
		<span>所属专业:</span>
			<select class="easyui-combobox" id="majorRefer"
					name="majorRefer" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['majorRefer']"
					editable="false">
					    <option value="0">请选择</option>
						<c:forEach items="${majorList}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
        <!-- <span>专业方向:</span>
		<input class="easyui-textbox" id="majorFieldRefer" name="majorFieldRefer"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" /> -->
		<a class="easyui-linkbutton" iconCls="icon-search" id="showMajorFieldList"
			data-options="plain:false">查询</a> 
	<!-- 	<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#searchMajorFieldCondition')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a> -->
		</div>
	
	<form id="majorFieldForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="majorFieldList" pagination="true"
				toolbar="#majorFieldSettingToolbar"
				url="${contextPath}/sch/getMajorFieldByMajorId.do?majorId=0" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="name" width="150px" align="center">专业方向</th>
						<th field="majorStr" width="150px" align="center">所属专业</th>
						<th field="remark" width="180px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="majorFieldSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addMajorField"
					data-options="plain:true" onclick="openNewMajorFieldDialog();disableValidationAtNew();">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editMajorField"
					data-options="plain:true" onclick="openEditMajorFieldDialog('#editMajorFieldForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove"
					id="delBuilding" data-options="plain:true"
					onclick="DeleteMajorFieldById()">删除</a>
			</div>
		</div>
	</form>
</div>



<!-- 弹出添加专业方向的对话框 -->
<div id="newMajorFieldDialog" class="easyui-dialog" title="添加专业方向"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addMajorFieldBtn'"
	style="width: 400px; height: 320px; padding: 17px;">
	<form id="newMajorFieldForm" method="post">
		<table cellpadding="7" align="center">			
			<tr>
				<td>专业方向:</td>
				<td><input class="easyui-textbox"
					id="nameSetting" name="nameSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属专业:</td>
				<td><select class="easyui-combobox" id="majorSelect"
					name="majorSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['majorSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${majorList}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="newMajorFieldRemark" name="newMajorFieldRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="addMajorFieldBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewMajorField('#newMajorFieldForm');clearNewMajorFieldForm('#newMajorFieldForm')">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="clearNewMajorFieldForm('#newMajorFieldForm')">重置</a>
	</div>
</div>


<!-- 弹出修改专业方向的对话框 -->
<div id="editMajorFieldDialog" class="easyui-dialog" title="修改专业方向"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editMajorFieldBtn'"
	style="width: 400px; height: 320px; padding: 17px;">
	<form id="editMajorFieldForm" method="post">
		<table cellpadding="7" align="center">
		<input id="editMajorFieldId" type="hidden">			
			<tr>
				<td>专业方向:</td>
				<td><input class="easyui-textbox"
					id="editName" name="editName"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属专业:</td>
				<td><select class="easyui-combobox" id="editMajorSelect"
					name="editMajorSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,disabled:true,panelHeight: 'auto'" validtype="selectRequired['editMajorSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${majorList}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="editMajorFieldRemark" name="editMajorFieldRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="editMajorFieldBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateMajorField('#editMajorFieldForm')">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#editMajorFieldDialog').dialog('close');disableValidationAtEdit();">取消</a>			
	</div>
</div>


<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<script type="text/javascript">
//清空查询条件
/* function cleanSearch(condition){
	    $(condition).find("#majorRefer").combobox('select','');
	    $(condition).find("#majorFieldRefer").textbox('setValue','');
	  } */
/********************************点击查询按钮后执行动作******************************/

$(function() {

		//获得专业方向信息
		$("#searchMajorFieldCondition").find('#showMajorFieldList').click(
				function() {
					var id = $('#searchMajorFieldCondition').find(
							'#majorRefer').combobox('getValue');
					//alert(id);
					$('#majorFieldForm').find('#majorFieldList').datagrid({
						url : "${contextPath}/sch/getMajorFieldByMajorId.do",
						queryParams : {
							majorId : id
						}
					});
				});

	})
/********************************弹出添加专业方向对话框****************************/
    function openNewMajorFieldDialog() {
	
	   $('#newMajorFieldDialog').dialog('open');
    }
	//重置数据
	function clearNewMajorFieldForm(condition) {
		$(condition).find('#nameSetting').textbox('setValue','');
		$(condition).find('#majorSelect').combobox('setValue','');
		$(condition).find('#newMajorFieldRemark').textbox('setValue','');		
		//取消表单验证
		disableValidationAtNew();
	}

	//添加专业方向
	function addNewMajorField(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;
		
		var name = $(form).find('#nameSetting').val();
		var majorId = $(form).find('#majorSelect').combobox('getValue');
		var remark = $(form).find('#newMajorFieldRemark').val();
		//alert("name:"+name+" ,"+"campusId:" +campusId+" ,"+"remark:"+remark);
		$.post('sch/toAddNewMajorField.do', {
			"name" : name,
			"majorId" : majorId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "专业方向添加成功!", "info");
						$('#newMajorFieldDialog').dialog('close');
						$('#majorFieldForm').find('#majorFieldList').datagrid(
								'reload');
						clearNewBuildingForm('#newMajorFieldForm');
					}
				})
				//取消表单验证
				disableValidationAtNew();
	}	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newMajorFieldForm').form('disableValidation').form('validate');	
	}
	
	
	//*********************************修改一行专业方向记录*****************************************
	function openEditMajorFieldDialog(form) {

		var row = $('#majorFieldList').datagrid('getSelected');
		if (row) {
			$(form).find('#editMajorFieldId').val(row.id);
			//重新设置名称
			$(form).find('#editName').textbox('setValue',row.name);
			$(form).find('#editMajorSelect').combobox('select',row.majorId);
			//重新设置备注
			$(form).find('#editMajorFieldRemark').textbox('setValue',row.remark);
			//打开窗口
			$('#editMajorFieldDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的专业方向记录!", "warning");
	}

	function updateMajorField(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;

		var id = $(form).find('#editMajorFieldId').val();
		var name = $(form).find('#editName').val();
		var majorId = $(form).find('#editMajorSelect').combobox('getValue');
		var remark = $(form).find('#editMajorFieldRemark').val();
		//alert("id: "+id+"name:"+name+" ,"+"campusId:" +campusId+" ,"+"remark:"+remark);
		$.post('${contextPath}/sch/updateMajorField.do', {
			"id" : id,
			"name" : name,
		    "majorId" : majorId,
			"remark" : remark 
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.success == 1) {
						$.messager.alert("操作提示", "专业方向修改成功!", "info");
						$('#editMajorFieldDialog').dialog('close');
						$('#majorFieldForm').find('#majorFieldList').datagrid('reload');
					}
				});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editMajorFieldForm').form('disableValidation').form('validate');		
	}
		
	//*********************************删除一行专业方向记录*****************************************		
	function DeleteMajorFieldById() {
		var row = $('#majorFieldList').datagrid('getSelected');
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function(data) {
				if (data)
					$.post('sch/toDeleteMajorField.do', {
						id : row.id
					}, function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 1) {
							$.messager.alert("操作提示", "专业方向删除成功!", "info");
							$('#majorFieldForm').find('#majorFieldList').datagrid('reload');
						}
					})
				else
					;
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的专业方向!", "warning");
	}
</script>
