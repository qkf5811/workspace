<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div style="margin: 5px" id="searchBuildingCondition">
		<span>所属校区:</span>
		<!-- <input class="easyui-textbox" id="campusRefer" name="campusRefer"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" /> -->
			<select class="easyui-combobox" id="campusRefer"
					name="campusRefer" style="width: 150px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['campusRefer']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${campusList}" var="campus">
							<option value="${campus.id}">${campus.name}</option>
						</c:forEach>
					</select>
        <span>教学楼名称:</span>
		<input class="easyui-textbox" id="buildingRefer" name="buildingRefer"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search" id="showBuildingList"
			data-options="plain:false">查询</a> 
		<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#searchBuildingCondition')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a>
		</div>
	
	<form id="buildingForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="buildingList" pagination="true"
				toolbar="#buildingSettingToolbar"
				url="${contextPath}/sch/getBuildingList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="name" width="120px" align="center">教学楼名称</th>
						<th field="campusName" width="150px" align="center">所属校区</th>
						<th field="remark" width="180px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="buildingSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addBuilding"
					data-options="plain:true" onclick="openNewBuildingDialog()">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editBuilding"
					data-options="plain:true" onclick="openEditBuildingDialog('#editBuildingForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove"
					id="delBuilding" data-options="plain:true"
					onclick="DeleteBuildingById()">删除</a>
			</div>
		</div>
	</form>
</div>



<!-- 弹出添加教学楼信息的对话框 -->
<div id="newBuildingDialog" class="easyui-dialog" title="添加教学楼"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addBuildingBtn'"
	style="width: 450px; height: 320px; padding: 17px;">
	<form id="newBuildingForm" method="post">
		<table cellpadding="7" align="center">			
			<tr>
				<td>教学楼名称:</td>
				<td><input class="easyui-textbox"
					id="nameSetting" name="nameSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属校区:</td>
				<td><select class="easyui-combobox" id="campusSelect"
					name="campusSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['campusSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${campusList}" var="campus">
							<option value="${campus.id}">${campus.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="newBuildingRemark" name="newBuildingRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="addBuildingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewBuilding('#newBuildingForm')">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="clearNewBuildingForm('#newBuildingForm')">重置</a>
	</div>
</div>


<!-- 弹出修改教学楼信息的对话框 -->
<div id="editBuildingDialog" class="easyui-dialog" title="修改教学楼"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editBuildingBtn'"
	style="width: 450px; height: 320px; padding: 17px;">
	<form id="editBuildingForm" method="post">
		<table cellpadding="7" align="center">
		<input id="editBuildingId" type="hidden">			
			<tr>
				<td>教学楼名称:</td>
				<td><input class="easyui-textbox"
					id="editName" name="editName"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属校区:</td>
				<td><select class="easyui-combobox" id="editCampusSelect"
					name="editCampusSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editCampusSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${campusList}" var="campus">
							<option value="${campus.id}">${campus.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="editBuildingRemark" name="editBuildingRemark"
                     data-options="multiline:true" style="width:220px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="editBuildingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateBuilding('#editBuildingForm')">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#editBuildingDialog').dialog('close');disableValidationAtEdit();">取消</a>			
	</div>
</div>


<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<script type="text/javascript">
//清空查询条件
function cleanSearch(condition){
	    $(condition).find("#campusRefer").combobox('select','');
	    $(condition).find("#buildingRefer").textbox('setValue','');
	  }
/********************************点击查询按钮后执行动作******************************/

$(function() {
		$("#searchBuildingCondition").find('#showBuildingList').click(
				function() {
					var campusRefer = $('#searchBuildingCondition').find(
					'#campusRefer').combobox(
					'getValue');
					var buildingRefer = $('#searchBuildingCondition').find(
					'#buildingRefer').textbox('getValue');
					//alert('campusRefer : '+campusRefer+' , buildingRefer : '+buildingRefer);
					//!-AJAX请求数据
					$('#buildingForm').find('#buildingList').datagrid('load',{												
							"name" : buildingRefer,
							"campusId" : campusRefer					
					});
				});

	})
	
	
/********************************弹出添加教学楼信息对话框****************************/
    function openNewBuildingDialog() {
	
	   $('#newBuildingDialog').dialog('open');
    }
	//重置数据
	function clearNewBuildingForm(condition) {
		$(condition).find('#nameSetting').textbox('setValue','');
		$(condition).find('#campusSelect').combobox('setValue','');
		$(condition).find('#newBuildingRemark').textbox('setValue','');		
		//取消表单验证
		disableValidationAtNew();
	}

	//添加教学楼信息
	function addNewBuilding(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;
		
		var name = $(form).find('#nameSetting').val();
		var campusId = $(form).find('#campusSelect').combobox('getValue');
		var remark = $(form).find('#newBuildingRemark').val();
		//alert("name:"+name+" ,"+"campusId:" +campusId+" ,"+"remark:"+remark);
		$.post('sch/addBuilding.do', {
			"name" : name,
			"campusId" : campusId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "课程教学楼添加成功!", "info");
						$('#newBuildingDialog').dialog('close');
						$('#buildingForm').find('#buildingList').datagrid(
								'reload');
						clearNewBuildingForm('#newBuildingForm');
					}
				})
				//取消表单验证
				disableValidationAtNew();
	}	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newBuildingForm').form('disableValidation').form('validate');	
	}
	
	
	//*********************************修改一行教学楼记录*****************************************
	function openEditBuildingDialog(form) {

		var row = $('#buildingList').datagrid('getSelected');
		if (row) {
			$(form).find('#editBuildingId').val(row.id);
			//重新设置名称
			$(form).find('#editName').textbox('setValue',row.name);
			//重新设置校区
			$(form).find('#editCampusSelect').combobox('select',row.campusId);
			//重新设置备注
			$(form).find('#editBuildingRemark').textbox('setValue',row.remark);
			//打开窗口
			$('#editBuildingDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的教学楼记录!", "warning");
	}

	function updateBuilding(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;

		var id = $(form).find('#editBuildingId').val();
		var name = $(form).find('#editName').val();
		var campusId = $(form).find('#editCampusSelect').combobox('getValue');
		var remark = $(form).find('#editBuildingRemark').val();
		//alert("name:"+name+" ,"+"campusId:" +campusId+" ,"+"remark:"+remark);
		$.post('sch/updateBuilding.do', {
			"id" : id,
			"name" : name,
			"campusId" : campusId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "教学楼记录修改成功!", "info");
						$('#editBuildingDialog').dialog('close');
						$('#buildingForm').find('#buildingList').datagrid('reload');
					}
				});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editBuildingForm').form('disableValidation').form('validate');		
	}
		
	//*********************************删除一行教学楼信息记录*****************************************		
	function DeleteBuildingById() {
		var row = $('#buildingList').datagrid('getSelected');
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function(data) {
				if (data)
					$.post('sch/deleteBuilding.do', {
						id : row.id
					}, function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 1) {
							$.messager.alert("操作提示", "学楼信息删除成功!", "info");
							$('#buildingForm').find('#buildingList').datagrid('reload');
						}
					})
				else
					;
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的教学楼信息!", "warning");
	}
</script>
