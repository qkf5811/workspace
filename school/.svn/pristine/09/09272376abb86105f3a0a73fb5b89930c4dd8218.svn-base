<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="" style="width: 99%">
	<form id="returnEquipmentItemForm">

		<div style="margin:5px">
			<td>归还日期:</td>
			<td><input class="easyui-datetimebox" id="returnDate"
				name="returnDate" data-options="editable:false,novalidate:true"
				validtype="selectRequired['returnDate']"
				style="height: 33px; width: 212px">
		</div>
		<div style="margin-bottom: 20px">
			<span>
				<table id="returnEquipmentItemList" style="width: auto;"
					parination="true" rownumbers="true" singleSelect="false"
					iconCls="icon-search"
					data-option="pageSize:10" toolbar="#returnSearchEquToolbar">
				</table>
			</span>
		</div>
		<div id="returnSearchEquToolbar" style="padding:5px">
			<div>
				<span>设备分类</span> <select id="returnCateSelect"
					name="returnCateSelect" class="easyui-combobox"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'" style="width: 150px;height: 28px">
					<option value="请选择">请选择</option>
					<c:forEach items="${returnCategoryList }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select> &nbsp;&nbsp; <span>设备种类</span> <select id="returnEquipSelect"
					name="returnEquipSelect" class="easyui-combobox"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'" style="width: 150px;height:28px">
					<option value="0">请选择</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp; <span>
					<td>设备编号:</td>
					<td><input class="easyui-validatebox textbox" id="code"
						name="code"
						style="width: 200px; height: 25px; letter-spacing: 1px;" /></td>
				</span>&nbsp;&nbsp;&nbsp;&nbsp; <span>
					<td>使用者ID:</td>
					<td><input class="easyui-validatebox textbox" id="userId"
						name="userId"
						style="width: 200px; height: 25px; letter-spacing: 1px;" /></td>
				</span>
				<!-- <br> <strong style="margin-right: 45%;"
					class="easyui-linkbutton" plain="true">(提示：点击选中需要录入的设备)</strong> --> <strong
					id="returnSearchRecord" hef="#" class="easyui-linkbutton"
					plain="true" style="width: 80px;" iconCls="icon-search"
					onclick="returnListEquipmentItem()">查 询</strong> 
				<!-- 	<span
					id="selectAllOfRetEqu" class="easyui-linkbutton" plain="true"
					style="width: 80px" 
					onclick="selectAllOfRetEqu()">全 选</span><span
					id="selectAllOfRetEqu" class="easyui-linkbutton" plain="true"
					style="width: 80px;" 
					onclick="unSelectAllOfReturn()">全不选</span> -->
			</div>
		</div>

		<div style="text-align: center; padding: 5px; margin: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				id="returnCommit">归 还</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" id="returnClear">重 置</a>
		</div>
	</form>


</div>

<script>
	$(function() {
		//初始化表头
		$('#returnEquipmentItemForm').find('#returnEquipmentItemList')
				.datagrid({
					url : "",
					fitColumns : true,
					rownumbers : true,
					pagination : true,
					pageSize : 10,
					pagination : true,
					rownumbers : true,
					collapsible : true,
					columns : [ [ {
						field : "ck",
						width : "120px",
						align : "center",
						checkbox : true,
						title : "选择"
					}, {
						field : "code",
						width : "200px",
						align : "center",
						title : "设备编号"
					}, {
						field : "storageName",
						width : "120px",
						align : "center",
						title : "存放地点"
					}, {
						field : "useStatusStr",
						width : "120px",
						align : "center",
						title : "使用状态"
					}, {
						field : "useUserId",
						width : "120px",
						align : "center",
						title : "使用者ID"
					}, {
						field : "dateOfOutStr",
						width : "200px",
						align : "center",
						title : "使用日期"
					}, {
						field : "dateOfDealineStr",
						width : "200px",
						align : "center",
						title : "使用期限"
					}, ] ]
				});
		//设置默认归还日期
		var rdate = new Date();
		var rnow = rdate.getFullYear() + "-" + (rdate.getMonth() + 1) + "-"
				+ rdate.getDate() + " " + rdate.getHours() + ":"
				+ rdate.getMinutes() + ":" + rdate.getSeconds();
		$('#returnEquipmentItemForm').find('#returnDate').datetimebox({
			value : rnow
		});

		//获取设备种类
		var rcSelect = $('#returnCateSelect');
		rcSelect.combobox({
			onSelect : function() {
				var val = rcSelect.combobox('getValue');
				var txt = rcSelect.combobox('getText');
				//		alert("value: " + val + ", " + "Text: " + txt);
				$('#returnEquipSelect').combobox({
					valueField : "id",
					textField : "name",
					url : "${contextPath}/equ/getEquInfo.do?categoryId=" + val,
					editable : false,
					value : "请选择"
				});
			}
		});

	});
	var rselectedRecord;
	var rcodes = "";
	//获取选中的记录
	function rgetSelections() {
		rcodes = "";
		rselectedRecord = $('#returnEquipmentItemForm').find(
				'#returnEquipmentItemList').datagrid('getSelections');
		//	console.log(rselectedRecord);
		for (var i = 0; i < rselectedRecord.length; ++i) {
			rcodes += "," + rselectedRecord[i].code;
		}
		//	console.log(rcodes);
		//参数就只是code...
		if (rcodes == "")
			$.messager.alert("操作提示", "请先选中需要归还的设备!","warning");
		else
			$.post('equ/returnEqu.do', {
				codes : rcodes
			}, function(data) {
				var obj = eval('(' + data + ')');
				//		console.log(obj);
				if (obj.result > 0)
					$.messager.alert("操作提示", "设备归还成功!共归还  " + obj.result
							+ " 台设备。");
				$('#returnEquipmentItemForm').find('#returnEquipmentItemList')
						.datagrid('reload');
			});

	}
	//重置
	$('#returnClear').click(function() {
		var tab = getCurrentTab();
		closeTab(tab);
		openTab('equ/toReturnEquipmentItem.do', '归还设备');
	});
	//查找
	function returnListEquipmentItem() {
		//获取设备种类ID （没选择：0）
		var equipmentId = $('#returnEquipSelect').combobox('getValue');
		//		var text = $('#returnEquipSelect').combobox('getText');
		//	alert(equipmentId + ", " + text);
		//获取设备编号(没填写为: "")
		var code = $('#returnEquipmentItemForm').find('#code').val();
		//	alert(code);
		//获取使用者id(同上)
		var userId = $('#returnEquipmentItemForm').find('#userId').val();
		if (userId.trim() == "")
			userId = -99999;
		//	alert(userId);

		$('#returnEquipmentItemForm')
				.find('#returnEquipmentItemList')
				.datagrid(
						{
							url : "${contextPath }/equ/getEquipmentItemByConditions.do",
							queryParams : {
								equipmentId : equipmentId,
								code : code,
								userId : userId
							}
						});
	}
	//全选
	function selectAllOfRetEqu() {
		$('#returnEquipmentItemForm').find('#returnEquipmentItemList')
				.datagrid('selectAll');
	}

	//全不选
	function unSelectAllOfReturn() {
		$('#returnEquipmentItemForm').find('#returnEquipmentItemList')
				.datagrid('unselectAll');
	}
	$('#returnCommit').click(function() {
		//	alert('fuck!');
		rgetSelections();
	});
</script>