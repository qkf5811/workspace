<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div
	style="background: rgb(238, 238, 238); margin: 0px; width: 100%; height: 100%">
	<form id="customForm_1">
		<table class="ctable">
	<table class="easyui-datagrid" id="dataGrid_1" pagination="true"
		toolbar="#seqToolbar" url="${contextPath}/seq/getSeqJson.do" rownumbers="true"
		singleSelect="true" data-options="pageSize:50">
		<thead>
			<tr>
			<th field="ck" width="" align="center" checkbox="true"></th>
				<th field="id" width="250px" align="center">id</th>
				<th field="seq" width="150px" align="center" editor="numberbox">seq</th>
				<!-- <th field="fun" width="280px" align="center">fun</th> -->
			</tr>
		</thead>
	</table>
	</table>
	
	<div id="seqToolbar">
		<a class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="enableEdit()">编辑</a>
		<a class="easyui-linkbutton" plain="true" iconCls="icon-save" onclick="updateEdit()">更新</a>
	</div>
</div>

<script type="text/javascript">
	var editRow = null;
	var nowRow = null;
	$("#dataGrid_1").datagrid({
		onLoadSuccess : function(data) {
			$.parser.parse($(".easyui-linkbutton").parent());
		},
		onClickRow: function (index, row) {
			//alert(index);
			nowRow = row;
			if (editRow != nowRow) {
				var index = $("#dataGrid_1").datagrid('getRowIndex', editRow);
				$("#dataGrid_1").datagrid('endEdit', index);
				editRow = null;
			}
		}
		});

	function enableEdit() {
		if (editRow == null) {
			var row = $("#dataGrid_1").datagrid('getSelected');
			console.log(row);
			if (row != null) {
				nowRow = row;
				editRow = row;
				var index = $("#dataGrid_1").datagrid('getRowIndex', row);
		//		console.log(index);
				$("#dataGrid_1").datagrid('beginEdit', index);
		//		$("#dataGrid_1").datagrid('unselectAll');
		//		$("#dataGrid_1").datagrid('getEditor', {index: index, field: 'seq'});
		//		var editors = $("#dataGrid_1").datagrid("getEditors", index);
		//		console.log(editors);
		//		row.id.onblur = function() {alert("asdf");}
			} else {
				$.messager.alert("操作提示", "请先选择需要操作行.", "info");
			}
		}
	}

	function updateEdit() {
		var row = $("#dataGrid_1").datagrid('getSelected');
		if (row != null) {
			var index = $("#dataGrid_1").datagrid('getRowIndex', row);
			$("#dataGrid_1").datagrid('endEdit', index);

			console.log(row);
			$.post("${contextPath}/seq/setSeqJson.do", {
				key : row.id,
				value : row.seq
			}, function(data) {
				if (data == 1) {
					$.messager.alert("操作提示", "更新成功!", "info");
				} else {
					$.messager.alert("操作提示", "更新失败!", "warning");
				}
				editRow = null;
			});
		}  else {
			$.messager.alert("操作提示", "请先选择需要操作行.", "info");
		}
	}

</script>
