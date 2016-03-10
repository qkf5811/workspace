<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="" style="width: 99%">
	<form id="useEquipmentItemForm">

		<div style="margin: 10px 10px 20px 10px">
			<span>
				<table id="useEquipmentItemList" style="width: auto;"
					 iconCls="icon-search"
					parination="true" rownumbers="true" singleSelect="false"
					data-option="pageSize:10" toolbar="#useSearchEquToolbar">
				</table>
			</span>
		</div>
		<div id="useSearchEquToolbar" style="padding:5px">
			<span>设备分类</span> <select id="useCateSelect" name="useCateSelect"
				class="easyui-combobox"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'"
				style="width:150px;height:28px">
				<option value="请选择">请选择</option>
				<c:forEach items="${useCategoryList }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select> &nbsp;&nbsp; <span>设备种类</span> <select id="useEquipSelect"
				name="useEquipSelect" class="easyui-combobox"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'"
				style="width:150px;height:28px">
				<option value="0">请选择</option>
			</select> &nbsp;&nbsp; <input id="ufree" type="checkbox"
				style="vertical-align: middle" checked="true">仅显示未使用<strong
				id="searchRecord" hef="#" class="easyui-linkbutton" plain="true"
				style="width: 80px;" iconCls="icon-search"
				onclick="useListEquipmentItem()">查 询</strong> 
			<!-- 	<span
				id="selectAllOfUseEqu" class="easyui-linkbutton" plain="true"
				style="width: 80px" onclick="selectAllOfUseEqu()">全 选</span><span
				id="selectAllOfUseEqu" class="easyui-linkbutton" plain="true"
				style="width: 80px" onclick="unselectAllOfUse()">全不选</span> <strong
				class="easyui-linkbutton" plain="true">(提示：点击选中需要领用的设备)</strong> -->
		</div>

		<div class="easyui-window" title="请填写领用信息" id="useEquWin"
			 data-options="modal:true, iconCls:'icon-edit', closed:true"
			 style="padding:15px">
			<div style="margin-bottom: 20px">
				<span>领用者ID:</span> <span><input
					class="easyui-validatebox textbox" id="useUserId" name="useUserId"
					data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
					style="width: 200px; height: 18px; padding: 5px" /></span>
			</div>
			<div style="margin-bottom: 20px">
				<span>领用日期:</span> <span><input class="easyui-datetimebox"
					id="useDate" name="useDate"
					data-options="editable:false,novalidate:true"
					validtype="selectRequired['useDate']"
					style="height: 33px; width: 212px"></span>
			</div>
			<div style="margin-bottom: 20px">
				<span>领用期限:</span> <span><input class="easyui-datetimebox"
					id="useDealine" name="useDealine"
					data-options="editable:false,novalidate:true"
					validtype="selectRequired['useDealine']"
					style="height: 33px; width: 212px"></span>
			</div>
			<div>
				<span>备注:</span><br>
				<textArea class="textarea" id="useRemark" name="useRemark" rows="6"
					cols="60"></textArea>
			</div>
			
			<div style="text-align:center; padding: 5px;margin-top: 20px">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="useCommit">领 用</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="useClear" >重 置</a>
			</div>
		</div>
		<div style="text-align: center; padding: 5px; margin: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openUseEquWin()">提 交</a>
	<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton" id="useCommit" onclick="">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" id="useClear">重置</a> -->
		</div>
	</form>


</div>

<script>
	var useSelectedRecord;
	var useCodes = "";
	//获取选中的记录
	function getSelections() {
		useCodes = "";
		useSelectedRecord = $('#useEquipmentItemForm').find(
				'#useEquipmentItemList').datagrid('getSelections');
		//	console.log(selectedRecord);
		for (var i = 0; i < useSelectedRecord.length; ++i) {
			useCodes += "," + useSelectedRecord[i].code;
		}
		//	console.log(codes);
	}
	//全选
	function selectAllOfUseEqu() {
		$('#useEquipmentItemForm').find('#useEquipmentItemList').datagrid(
				'selectAll');
	}
	//全不选
	function unselectAllOfUse() {
		$('#useEquipmentItemForm').find('#useEquipmentItemList').datagrid(
				'unselectAll');
	}
	//重置
	$('#useClear').click(function() {
//		var tab = getCurrentTab();
//		closeTab(tab);
//		openTab('equ/toUseEquipmentItem.do', '领用设备');
//		$('#useDate').datetimebox('setValue', '');
		$('#useDealine').datetimebox('setValue', '');
		$('#useRemark').val('');
		$('#useUserId').val('')
	});
	//获取某种种类的设备的记录数
	function useListEquipmentItem() {
		//	alert("开始");
		//		var index = $('#equipSelect')[0].selectedIndex;
		//		var value = $('#equipSelect')[0].options[index].value;
		var value = $('#useEquipSelect').combobox('getValue');
		var isFree = document.getElementById("ufree").checked;
		//	alert(value);
		if (value == "请选择" || value == 0) {
			$.messager.alert("操作提示", '请先选择设备种类!',"warning");
		} else {
			$('#useEquipmentItemForm').find('#useEquipmentItemList').datagrid({
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
		$('#useCommit').click(
				function() {
					//在提交数据之前执行表单验证
					$('#useEquipmentItemForm').form('enableValidation').form(
							'validate');

					//判断表单验证是否通过
					if (!$('#useEquipmentItemForm').form('validate')) {
						return false;
					}
					getSelections();
					//得到所有参数，发送请求
					var useUserId = $('#useUserId').val();
					if (isNaN(useUserId)) {
						$.messager.alert("操作提示", "领用者id必须是数字!","warning");
						return;
					}
					var useDate = $('#useDate').datetimebox('getValue');
					var useDealine = $('#useDealine').datetimebox('getValue');
					var remark = $('#useRemark').val();

					var param1 = {
						"codes" : useCodes,
						"useUserId" : useUserId,
						"useDateStr" : useDate,
						"useDealineStr" : useDealine,
						"remark" : remark
					};
					console.log(param1);
					$.post("equ/useEqu.do", param1,
							function(data) {
								var obj = eval('(' + data + ')');
								var result = eval('(' + obj.result + ')');
								console.log(result[0] + ", " + result[1]);
								if (result[0] == -1) {
									$.messager.alert("操作提示",
											"必要信息填写不完整,或设备已报废或正在使用!","warning");
									$('#useEquipmentItemForm').find(
											'#useEquipmentItemList').datagrid(
											'reload');
								} else if (result[0] == 0) {
									$.messager.alert("操作提示", "信息提交失败!请稍后再尝试。","warning");
									$('#useEquipmentItemForm').find(
											'#useEquipmentItemList').datagrid(
											'reload');
								} else if (result[0] == 1) {
									$.messager.alert("操作提示",
											"领用信息提交成功!" + "共领用 " + result[1]
													+ " 台设备!","warning");
									$('#useEquipmentItemForm').find(
											'#useEquipmentItemList').datagrid(
											'reload');
									$('#useEquWin').window('close');
								}
							});

				});
		//初始化表头
		$('#useEquipmentItemForm').find('#useEquipmentItemList').datagrid({
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

		$('#useEquipmentItemForm').find('#useEquipmentItemList').datagrid('loadData',{total:0,rows:[]});

		//设置默认领用日期
		var udate = new Date();
		var unow = udate.getFullYear() + "-" + (udate.getMonth() + 1) + "-"
				+ udate.getDate() + " " + udate.getHours() + ":"
				+ udate.getMinutes() + ":" + udate.getSeconds();
		$('#useEquipmentItemForm').find('#useDate').datetimebox({
			value : unow
		});

		//获取设备种类
		var ucSelect = $('#useCateSelect');
		//		alert(cSelect);
		ucSelect.combobox({
			onSelect : function() {
				var val = ucSelect.combobox('getValue');
				var txt = ucSelect.combobox('getText');
				//		alert("value: " + val + ", " + "Text: " + txt);
				$('#useEquipSelect').combobox({
					valueField : "id",
					textField : "name",
					url : "${contextPath}/equ/getEquInfo.do?categoryId=" + val,
					editable : false,
					value : "请选择"
				});
			}
		});
	})
	function openUseEquWin() {
		$('#useEquWin').window('open');
	}
</script>