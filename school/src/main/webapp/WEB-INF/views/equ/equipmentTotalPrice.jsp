<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="" style="">
	<form id="totalPriceForm" style="margin-top:10px;">
		<div style="margin-bottom: 20px">
			<span>
				<table id="totalPriceList" style="width: auto;" parination="true"
					rownumbers="true" singleSelect="false"
					iconCls="icon-search" data-option="pageSize:10"
					toolbar="#totalPriceToolbar">
				</table>
			</span>
		</div>
		<div id="totalPriceToolbar">
			<span>设备分类</span> <select id="totalPriceCateSelect"
				name="totalPriceCateSelect" class="easyui-combobox" style="width:150px"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'">
				<option value="请选择">请选择</option>
				<c:forEach items="${totalPriceCategory }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select> &nbsp;&nbsp; <span>设备种类</span> <select id="totalPriceEquipSelect"
				name="totalPriceEquipSelect" class="easyui-combobox" style="width:150px"
				data-options="editable:false,panelHeight: 'auto',panelWidth: '150px'" >
				<option value="0">请选择</option>
			</select> &nbsp;&nbsp; <strong id="totalPriceSearchRecord" hef="#"
				class="easyui-linkbutton" plain="true" style="width: 80px;"
				iconCls="icon-search" onclick="totalPriceListEquipmentItem()">查
				询</strong> 
		</div>
	</form>
</div>
<script>
	$(function() {
		//初始化表头
		$('#totalPriceForm').find('#totalPriceList').datagrid({
			url : "",
			fitColumns : true,
			rownumbers : true,
			pagination : true,
			pageSize : 10,
			collapsible : true,
			columns : [ [ {
				field : "equipmentName",
				width : "120px",
				align : "center",
				title : "设备种类"
			}, {
				field : "amount",
				width : "200px",
				align : "center",
				title : "数量"
			}, {
				field : "price",
				width : "200px",
				align : "center",
				title : "单价"
			}, {
				field : "totalPrice",
				width : "200px",
				align : "center",
				title : "总价"
			}, ] ]
		});

		//获取设备种类
		var tcSelect = $('#totalPriceCateSelect');
		//		alert(cSelect);
		tcSelect.combobox({
			onSelect : function() {
				var val = tcSelect.combobox('getValue');
				var txt = tcSelect.combobox('getText');
				//		alert("value: " + val + ", " + "Text: " + txt);
				$('#totalPriceEquipSelect').combobox({
					valueField : "id",
					textField : "name",
					url : "${contextPath}/equ/getEquInfo.do?categoryId=" + val,
					editable : false,
					value : "请选择"
				});
			}
		});
	})
	//查询
	function totalPriceListEquipmentItem() {
		var value = $('#totalPriceEquipSelect').combobox('getValue');
		if (value == "请选择" || value == 0) {
	//		$.messager.alert("警告", "请先选择设备种类!");
			$('#totalPriceForm').find('#totalPriceList').datagrid({
				url : "${contextPath }/equ/getAllPriceList.do"
				});
		} else {
			$.post("equ/getPriceListWithEquipmentId.do", {
				"equipmentId" : value
			}, function(data) {
				//先清空所有数据
				$('#totalPriceForm').find('#totalPriceList').datagrid('loadData', {total:0, rows:[]});
		//		console.log(data);
				var obj = eval('(' + data + ')');
		//		console.log(obj);
				var result = eval('(' + obj.data + ')');
		//		console.log(result);
				$('#totalPriceForm').find('#totalPriceList').datagrid('insertRow',{
						index:0,
						row:{
							"equipmentName": result.equipmentName,
							"amount": result.amount,
							"price": result.price,
							"totalPrice": result.totalPrice
						}});
			} );
		}
		
	}
	//查询所有
//	function totalPriceListAll() {
//		$('#totalPriceForm').find('#totalPriceList').datagrid({
//			url : "${contextPath }/equ/getAllPriceList.do"
//			});
//	}
</script>