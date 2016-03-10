<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div style="margin: 5px" id="searchStorageCondition">
		<span>所属教学楼:</span>
			<select class="easyui-combobox" id="buildingRefer"
					name="buildingRefer" style="width: 130px; height: 25px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['buildingRefer']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${buildingList}" var="building">
							<option value="${building.id}">${building.name}</option>
						</c:forEach>
					</select>
		<span>所属教室:</span>
			<select class="easyui-combobox" id="roomRefer"
					name="roomRefer" style="width: 130px; height: 25px"
					data-options="novalidate:true,disabled:true,panelHeight: 'auto'" validtype="selectRequired['roomRefer']"
					editable="false">
					  
					</select>
        <span>仓库名称:</span>
		<input class="easyui-textbox" id="storageRefer" name="storageRefer"
			style="width: 130px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search" id="showStorageList"
			data-options="plain:false">查询</a> 
		<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#searchStorageCondition')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a>
		</div>
	
	<form id="storageForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="storageList" pagination="true"
				toolbar="#storageSettingToolbar"
				url="${contextPath}/equ/getStorageList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="name" width="120px" align="center">仓库名称</th>
						<th field="buildingName" width="120px" align="center">所属教学楼</th>
						<th field="roomName" width="120px" align="center">所属教室</th>
						<th field="remark" width="180px" align="center">备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="storageSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addStorageInfo"
					data-options="plain:true" onclick="openNewStorageDialog();clearNewStorageForm('#newStorageForm')">添加</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editStorage"
					data-options="plain:true" onclick="openEditStorageDialog('#editStorageForm')">编辑</a>
				<a class="easyui-linkbutton" iconCls="icon-remove"
					id="delStorage" data-options="plain:true"
					onclick="DeleteStorageById()">删除</a>
			</div>
		</div>
	</form>
</div>



<!-- 弹出添加仓库列表的对话框 -->
<div id="newStorageDialog" class="easyui-dialog" title="添加仓库"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addStorageInfoBtn'"
	style="width: 340px; height: 365px; padding: 17px;">
	<form id="newStorageForm" method="post">
		<table cellpadding="7" align="center">			
			<tr>
				<td>仓库名称:</td>
				<td><input class="easyui-textbox"
					id="nameSetting" name="nameSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 180px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
			<tr>
				<td>所属教学楼:</td>
				<td><select class="easyui-combobox" id="buildingSelect"
					name="buildingSelect" style="width: 130px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['buildingSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${buildingList}" var="g">
							<option value="${g.id}">${g.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>所属教室:</td>
				<td><select class="easyui-combobox" id="roomSelect"
					name="roomSelect" style="width: 130px; height: 30px"
					data-options="novalidate:true,disabled:true,panelHeight: 'auto'" validtype="selectRequired['roomSelect']"
					editable="false">
				
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="newStorageRemark" name="newStorageRemark"
                     data-options="multiline:true" style="width:180px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="addStorageInfoBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewStorageInfo('#newStorageForm')">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; 
		<a href="javascript:void(0)"class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="clearNewStorageForm('#newStorageForm')">重置</a>
	</div>
</div>


<!-- 弹出修改仓库列表的对话框 -->
<div id="editStorageDialog" class="easyui-dialog" title="修改仓库"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#editStorageBtn'"
	style="width: 340px; height: 365px; padding: 17px;">
	<form id="editStorageForm" method="post">
		<table cellpadding="7" align="center">
		<input id="editStorageId" type="hidden">			
			<tr>
				<td>仓库名称:</td>
				<td><input class="easyui-textbox"
					id="editName" name="editName"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					style="width: 180px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>
			
            <tr>
				<td>所属教学楼:</td>
				<td><select class="easyui-combobox" id="editBuildingSelect"
					name="editBuildingSelect" style="width: 130px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editBuildingSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${buildingList}" var="c">
							<option value="${c.id}">${c.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<tr>
				<td>所属教室:</td>
				<td><select class="easyui-combobox" id="editRoomSelect"
					name="editRoomSelect" style="width: 130px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editRoomSelect']"
					editable="false">
			
					</select></td>
			</tr>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="editStorageRemark" name="editStorageRemark"
                     data-options="multiline:true" style="width:180px;height:100px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="editStorageBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateStorage('#editStorageForm')">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#editStorageDialog').dialog('close');disableValidationAtEdit();">取消</a>			
	</div>
</div>


<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------------------------------------------------------------- -->
<script type="text/javascript">
//清空查询条件
function cleanSearch(condition){
	    $(condition).find("#buildingRefer").combobox('select','');
	    $(condition).find('#roomRefer').combobox('loadData',{});
	    $(condition).find("#roomRefer").combobox('select',"");
	    $(condition).find("#storageRefer").textbox('setValue',"");
	    }
	  
//查询中教学楼和教室的二级联动
$('#buildingRefer').combobox({
	onSelect : function() {
		var buildingId = $('#searchStorageCondition').find(
		'#buildingRefer').combobox(
			'getValue');
			if (buildingId !=''){
			//	alert(buildingId);
				$.post('equ/getClassRoomByBuilding.do',{
			          "buildingId":buildingId
			          },function(data){
			              //返回的是string字符串，需要把字符串转成json对象
			              var resultJson=JSON.parse(data);
			              //添加一个下拉框元素"请选择"
			              var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
			              //使用unshift方法，在resultJson前面加上firstSelectJson
			              resultJson.unshift(firstSelectJson);

			              //加载所属教室下拉框数据
			              $('#searchStorageCondition').find('#roomRefer').combobox({
			                  valueField:'id',
			                  textField:'name',
			                  data:resultJson,
			                  editable:false,
			                  disabled:false

			                });
			              });
			} else{
				    $('#searchStorageCondition').find('#roomRefer').combobox('disable');
					$('#searchStorageCondition').find('#roomRefer').combobox('loadData',{});
					$('#searchStorageCondition').find('#roomRefer').combobox('setValue','');
					}
		}
});
		
//添加仓库信息中教学楼和教室的二级联动
$('#buildingSelect').combobox({
	onSelect : function() {
		var buildingId = $('#buildingSelect').combobox('getValue');
			if (buildingId !=""){
				$.post('equ/getClassRoomByBuilding.do',{
			          "buildingId":buildingId
			          },function(data){
			              //返回的是string字符串，需要把字符串转成json对象
			              var resultJson=JSON.parse(data);
			              //添加一个下拉框元素"请选择"
			              var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
			              //使用unshift方法，在resultJson前面加上firstSelectJson
			              resultJson.unshift(firstSelectJson);

			              //加载所属教室下拉框数据
			              $('#roomSelect').combobox({
			                  valueField:'id',
			                  textField:'name',
			                  data:resultJson,
			                  editable:false,
			                  disabled:false

			                });
			              });
			} else{
				    $('#roomSelect').combobox('disable');
					$('#roomSelect').combobox('loadData',{});
					$('#roomSelect').combobox('setValue','');
					}
		}
});
//修改仓库信息中教学楼和教室的二级联动
$('#editBuildingSelect').combobox({
	onSelect : function(){
	var buildingId = $('#editBuildingSelect').combobox('getValue');
	if (buildingId != null){
			$('#editRoomSelect').combobox({
			url : 'equ/getClassRoomByBuilding.do?buildingId=' + buildingId,
				valueField : 'id',
				textField : 'name',
				value : '请选择'
			});
	} else{
			$('#editRoomSelect').combobox('loadData',{});
			$('#editRoomSelect').combobox('setValue',"");
		}
	}
});
		
/********************************点击查询按钮后执行动作******************************/
$(function() {
	$("#searchStorageCondition").find('#showStorageList').click(
		function() {
			var buildingRefer = $('#searchStorageCondition').find(
			'#buildingRefer').combobox(
			'getValue');
			var roomRefer = $('#searchStorageCondition').find(
				'#roomRefer').combobox(
				'getValue');
			var storageRefer = $('#searchStorageCondition').find(
				'#storageRefer').textbox('getValue');
				//!-AJAX请求数据
				$('#storageForm').find('#storageList').datagrid('load',{												
					"name" : storageRefer,
					"roomId" : roomRefer,
					"buildingId" : buildingRefer
				});
			});

})
	
/********************************弹出添加仓库列表对话框****************************/
    function openNewStorageDialog() {
	
	   $('#newStorageDialog').dialog('open');
    }
	//重置数据
	function clearNewStorageForm(condition) {
		
		$(condition).find('#nameSetting').textbox('setValue','');
		$(condition).find('#buildingSelect').combobox('setValue','');
		$(condition).find('#roomSelect').combobox('loadData',{});
		$(condition).find('#roomSelect').combobox('setValue','');
		$(condition).find('#newStorageRemark').textbox('setValue','');		
		//取消表单验证
		disableValidationAtNew();
	}

	//添加仓库
	function addNewStorageInfo(form) {
		//在提交数据之前执行表单验证
		$('#newStorageForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newStorageForm').form('validate'))
			return false;
		
		var name = $('#newStorageForm').find('#nameSetting').val();
		var buildingId = $('#newStorageForm').find('#buildingSelect').combobox('getValue');
		var roomId = $('#newStorageForm').find('#roomSelect').combobox('getValue');
		var remark = $('#newStorageForm').find('#newStorageRemark').val();
		$.post('equ/addStorageInfo.do', {
			"name" : name,
			"buildingId" : buildingId,
			"roomId" : roomId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "仓库添加成功!", "info");
						$('#newStorageDialog').dialog('close');
						$('#storageForm').find('#storageList').datagrid(
								'reload');
						clearNewStorageForm('#newStorageForm');
					}
				})
				//取消表单验证
				disableValidationAtNew();
	}	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newStorageForm').form('disableValidation').form('validate');	
	}
	
	
	//*********************************修改一行仓库记录*****************************************
	function openEditStorageDialog(form) {

		var row = $('#storageList').datagrid('getSelected');
		if (row) {
			$('#editStorageForm').find('#editStorageId').val(row.id);
			//重新仓库名称
			$('#editStorageForm').find('#editName').textbox('setValue',row.name);
			//重新所属教学楼
			$('#editStorageForm').find('#editBuildingSelect').combobox('select',row.buildingId);
			//重新所属教室
			$('#editStorageForm').find('#editRoomSelect').combobox('select',row.roomId);
			//重新设备备注
			$('#editStorageForm').find('#editStorageRemark').textbox('setValue',row.remark);
			//打开窗口
			$('#editStorageDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的仓库记录!", "warning");
	}

	function updateStorage(form) {
		//在提交数据之前执行表单验证
		$('#editStorageForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editStorageForm').form('validate'))
			return false;

		var id = $('#editStorageForm').find('#editStorageId').val();
		var name = $('#editStorageForm').find('#editName').val();
		var buildingId = $('#editStorageForm').find('#editBuildingSelect').combobox('getValue');
		var roomId = $('#editStorageForm').find('#editRoomSelect').combobox('getValue');
		var remark = $('#editStorageForm').find('#editStorageRemark').val();
		$.post('equ/updateStorage.do', {
			"id" : id,
			"name" : name,
			"buildingId" : buildingId,
			"roomId" : roomId,
			"remark" : remark
		},function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "仓库修改成功!", "info");
						$('#editStorageDialog').dialog('close');
						$('#storageForm').find('#storageList').datagrid('reload');
					}
				});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	
	//在提交数据之前取消表单验证
 	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editStorageForm').form('disableValidation').form('validate');	 
	} 
		
	//*********************************删除一行仓库信息记录*****************************************		
	function DeleteStorageById() {
		var row = $('#storageList').datagrid('getSelected');
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function(data) {
				if (data)
					$.post('equ/deleteStorage.do', {
						id : row.id
					}, function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 1) {
							$.messager.alert("操作提示", "仓库删除成功!", "info");
							$('#storageForm').find('#storageList').datagrid('reload');
						}
					})
				else
					;
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的仓库!", "warning");
	}
</script>
