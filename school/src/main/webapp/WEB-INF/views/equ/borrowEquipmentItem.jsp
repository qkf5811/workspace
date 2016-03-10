<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="" style="width: 99%">
	<form id="borrowEquipmentItemForm">

		<div style="margin: 10px">
			<span>
				<table id="bequipmentItemList" style="width: auto;"
					parination="true" rownumbers="true" singleSelect="false"
					iconCls="icon-search" data-option="pageSize:10"
					toolbar="#bsearchEquToolbar">
				</table>
			</span>
		</div>
		<div id="bsearchEquToolbar" style="padding:5px">
			<span>设备分类</span> <select id="bcateSelect" name="bcateSelect"
				class="easyui-combobox"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'"
				style="width:150px;height:28px">
				<option value="请选择">请选择</option>
				<c:forEach items="${borrowCategoryList }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select> &nbsp;&nbsp; <span>设备种类</span> <select id="bequipSelect"
				name="bequipSelect" class="easyui-combobox"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'"
				style="width:150px;height:28px">
				<option value="0">请选择</option>
			</select> &nbsp;&nbsp; <input id="bfree" type="checkbox"
				style="vertical-align: middle" checked="true">仅显示未使用<strong
				id="searchRecord" hef="#" class="easyui-linkbutton" plain="true"
				style="width: 80px;" iconCls="icon-search"
				onclick="blistEquipmentItem()">查 询</strong>
			<!-- 	 <span
				id="selectAllOfUseEqu" class="easyui-linkbutton" plain="true"
				style="width: 80px" onclick="bselectAllOfUseEqu()">全 选</span><span
				id="selectAllOfUseEqu" class="easyui-linkbutton" plain="true"
				style="width: 80px" onclick="unselectAllOfBorrow()">全不选</span> <strong
				class="easyui-linkbutton" plain="true">(提示：点击选中需要领用的设备)</strong> -->
		</div>

		<div class="easyui-window" id="borrowWin" title="请填写借用信息" iconCls="icon-edit" 
		data-options="modal:true, iconCls:'icon-edit', closed:true"
		style="padding:15px; ">
			<div style="margin-bottom: 20px">
				<span>借用者ID:</span> <span><input
					class="easyui-validatebox textbox" id="borrowUserId"
					name="borrowUserId"
					data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
					style="width: 200px; height: 18px; padding: 5px" /></span>
			</div>
			<div style="margin-bottom: 20px">
				<span>借用日期:</span> <span><input class="easyui-datetimebox"
					id="borrowDate" name="borrowDate"
					data-options="editable:false,novalidate:true"
					validtype="selectRequired['borrowDate']"
					style="height: 33px; width: 212px"></span>
			</div>
			<div style="margin-bottom: 20px">
				<span>借用期限:</span> <span><input class="easyui-datetimebox"
					id="borrowDealine" name="borrowDealine"
					data-options="editable:false,novalidate:true"
					validtype="selectRequired['borrowDealine']"
					style="height: 33px; width: 212px"></span>
			</div>
			<div>
				<span>备注:</span><br>
				<textArea class="textarea" id="borrowRemark" name="borrowRemark"
					rows="6" cols="60"></textArea>
			</div>
			<div style="text-align: center; padding: 5px; margin: 20px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="borrowCommit" iconCls="icon-ok">借 用</a> <a href="javascript:void(0)"
					class="easyui-linkbutton" id="borrowClear" iconCls="icon-cancel">重 置</a>
			</div>
		</div>

		<div style="text-align: center; padding: 5px; margin: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="openBorrowWin()">提 交</a>
		</div>
	</form>


</div>

<script>
	var bselectedRecord;
	var bcodes = "";
	//获取选中的记录
	function bgetSelections() {
		bcodes = "";
		bselectedRecord = $('#borrowEquipmentItemForm').find(
				'#bequipmentItemList').datagrid('getSelections');
		//	console.log(selectedRecord);
		for (var i = 0; i < bselectedRecord.length; ++i) {
			bcodes += "," + bselectedRecord[i].code;
		}
		//	console.log(codes);
	}
	//全选
	function bselectAllOfUseEqu() {
		$('#borrowEquipmentItemForm').find('#bequipmentItemList').datagrid(
				'selectAll');
	}
	//全不选
	function unselectAllOfBorrow() {
		$('#borrowEquipmentItemForm').find('#bequipmentItemList').datagrid(
				'unselectAll');
	}
	//重置
	$('#borrowClear').click(function() {
//		var tab = getCurrentTab();
//		closeTab(tab);
//		openTab('equ/toBorrowEquipmentItem.do', '借用设备');
		$('#borrowUserId').val('');
//		$('#borrowDate').datetimebox('getValue');
		$('#borrowDealine').datetimebox(
				'setValue','');
		$('#borrowRemark').val('');
	});
	//获取某种种类的设备的记录数
	function blistEquipmentItem() {
		var value = $('#bequipSelect').combobox('getValue');
		var isFree = document.getElementById("bfree").checked;
		if (value == "请选择" || value == 0) {
			$.messager.alert("操作提示", '请先选择设备种类!',"warning");
		} else {
			$('#borrowEquipmentItemForm').find('#bequipmentItemList').datagrid(
					{
						url : "${contextPath }/equ/getEquipmentItemCount.do",
						queryParams : {
							equipmentId : value,
							isFree : isFree
						}
					});
			//		$("#equipmentItemList").datagrid('load', {
			//			equipmentId:value
			//		});
		}
	}

	$(function() {
		$('#borrowCommit').click(
				function() {
					//在提交数据之前执行表单验证
					$('#borrowEquipmentItemForm').form('enableValidation')
							.form('validate');

					//判断表单验证是否通过
					if (!$('#borrowEquipmentItemForm').form('validate')) {
						return false;
					}
					bgetSelections();
					//得到所有参数，发送请求
					var borrowUserId = $('#borrowUserId').val();
					if (isNaN(borrowUserId)) {
						$.messager.alert("操作提示", "借用者id必须为数字!","warning");
						return;
					}
					var borrowDate = $('#borrowDate').datetimebox('getValue');
					var borrowDealine = $('#borrowDealine').datetimebox(
							'getValue');
					var remark = $('#borrowRemark').val();

					var param = {
						"codes" : bcodes,
						"borrowUserId" : borrowUserId,
						"borrowDateStr" : borrowDate,
						"borrowDealineStr" : borrowDealine,
						"remark" : remark,
					};
					console.log(param);
					$.post("equ/borrowEqu.do", param, function(data) {
						var obj = eval('(' + data + ')');
						var result = eval('(' + obj.result + ')');
						console.log(result[0] + ", " + result[1]);
						if (result[0] == -1) {
							$.messager.alert("操作提示", "必要信息填写不完整,或设备已报废或正在使用!","warning");
							$('#borrowEquipmentItemForm').find(
									'#bequipmentItemList').datagrid('reload');
						} else if (result[0] == 0) {
							$.messager.alert("操作提示", "信息提交失败!请稍后再尝试。","warning");
							$('#borrowEquipmentItemForm').find(
									'#bequipmentItemList').datagrid('reload');
						} else if (result[0] == 1) {
							$.messager.alert("操作提示", "借用信息提交成功!"
									+ "共借用 " + result[1] + " 台设备!","warning");
							$('#borrowEquipmentItemForm').find(
									'#bequipmentItemList').datagrid('reload');
							$('#borrowWin').window('close');
						}
					});

				});
		//初始化表头
		$('#borrowEquipmentItemForm').find('#bequipmentItemList').datagrid({
			url : "",
			fitColumns : true,
			rownumbers : true,
			pagination : true,
			pageSize : 10,
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

		$('#borrowEquipmentItemForm').find('#bequipmentItemList').datagrid('loadData',{total:0,rows:[]});

		//设置默认领用日期
		var bdate = new Date();
		var bnow = bdate.getFullYear() + "-" + (bdate.getMonth() + 1) + "-"
				+ bdate.getDate() + " " + bdate.getHours() + ":"
				+ bdate.getMinutes() + ":" + bdate.getSeconds();
		$('#borrowEquipmentItemForm').find('#borrowDate').datetimebox({
			value : bnow
		});

		//获取设备种类
		var bcSelect = $('#bcateSelect');
		bcSelect.combobox({
			onSelect : function() {
				var val = bcSelect.combobox('getValue');
				var txt = bcSelect.combobox('getText');
				//		alert("value: " + val + ", " + "Text: " + txt);
				$('#bequipSelect').combobox({
					valueField : "id",
					textField : "name",
					url : "${contextPath}/equ/getEquInfo.do?categoryId=" + val,
					editable : false,
					value : "请选择"
				});
			}
		});
	})
	function openBorrowWin() {
		$('#borrowWin').window('open');
	}
</script>