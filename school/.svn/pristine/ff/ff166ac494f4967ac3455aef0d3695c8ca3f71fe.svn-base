<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto;">
	
	<div style="margin:5px;" id="searchEquOfEquIn">
		<td>设备编号：</td>
			<td><input class="easyui-validatebox textbox" id="code"
				name="account" style="width: 100px; height: 18px; padding: 5px" />
			</td>
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchEquipmentByCodeInPageIn()"
				iconCls="icon-search">查询</button>
	</div>
	<table id="inEquipmentItemList" class="easyui-datagrid"
		url="${contextPath }/equ/getEquipmentItemByCode.do"
		style="width: auto;" pagination="true"
		toolbar="#inEquipOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="200" align="center">设备编号</th>
				<th field="storageName" width="120" align="center">存放地点</th>
				<th field="useStatusStr" width="120" align="center">使用状态</th>
				<th field="useUserId" width="120" align="center">使用者ID</th>
				<th field="dateOfOutStr" width="200" align="center">使用日期</th>
				<th field="dateOfDealineStr" width="200" align="center">使用期限</th>
			</tr>
		</thead>
	</table>


	<div id="inEquipOperToolbar">
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true"
				onclick="openTab('equ/toAddEquipmentItem.do','添加新设备')">添加新设备</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true"
				onclick="openImportEquItemByExcelWindow('#importEquItemByExcel')">批量导入新设备</a> 
			<a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true"
				onclick="openTab('equ/toReturnEquipmentItem.do', '归还设备')">归还设备</a> 
		<!--	<a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true"
				onclick="openTab('equ/toUseEquipmentItem.do','领用设备')">领用设备</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true"
				onclick="openTab('equ/toBorrowEquipmentItem.do', '借用设备')">借用设备</a> -->
			
		</div>

	</div>
	
	<!-- 通过excel导入设备信息 -->
	<div class="easyui-window" id="importEquItemByExcel"
		data-options="modal:true,closed:true,iconCls:'icon-print'"
		title="excel表导入设备信息" style="width: 520px; height: 200px">
		<div style="margin: 30px auto auto auto">
			<span style="color: red; margin-left: 20px">注意:请按照excel表模版的格式上传设备信息，如未下载模版，请点击:</span>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-print" data-options="plain:true"
				onclick="downloadEquItemModelExcel()">模板下载</a><br />
			<div style="margin: 30px auto auto 60px;">
				<input type="text" class="easyui-textbox" id="equItemExcelFileName"
					style="width: 250px; height: 25px;" editable="false"> <a
					onclick="$('#importEquItemByExcel').find('#equItemFile').click()"
					class="easyui-linkbutton" iconCls="icon-search">浏览</a> <input
					type="file" name="equItemFile" id="equItemFile"
					style="position: absolute; display: none"
					onchange="$('#importEquItemByExcel').find('#equItemExcelFileName').textbox('setValue', this.value)" />
				<a onclick="uploadEquItemInfoFile()" id=""
					class="easyui-linkbutton" iconCls="icon-save">上传</a>
			</div>
		</div>
	</div>
</div>
<script>
//根据设备编号查询
function searchEquipmentByCodeInPageIn() {
	
	var code = $('#searchEquOfEquIn').find('#code').val();
	$('#inEquipmentItemList').datagrid({
		url : "${contextPath }/equ/getEquipmentItemByCode.do",
		fitColumns : true,
		rownumbers : true,
		pagination : true,
		pageSize : 10,
		pagination : true,
		rownumbers : true,
		collapsible : true,
		queryParams : {
			code : code
		}
	});
}

//打开设备导入窗口
 function openImportEquItemByExcelWindow(form) {
	
	$(form).window("open");
}

//下载设备导入模板
function downloadEquItemModelExcel() {
	
	window.open("${contextPath}/equ/downloadEquItemExcel.do");
}

//上传
function uploadEquItemInfoFile() {
	
	if ($('#importEquItemByExcel').find('#equItemExcelFileName').textbox('getValue')
			.trim() == '')
		$.messager.alert('操作提示', '请先选择文件!', 'warning');
	else {
		$.messager.progress({
			title : '操作提示',
			text : '正在上传...'
		});
		//			alert('哈哈');
		//ajaxFileUpload组件上传文件
		$.ajaxFileUpload({
					url : 'equ/importEquItemByExcel.do',
					//		type : 'post',
					fileElementId : 'equItemFile',
					secureuri : false,
					dataType : 'text',
					success : function(data, status) {
					//	alert(data);
						data = data.replace("<html>", "");
						data = data.replace("</html>", "");
						data = data.replace(/<pre>|<pre[\s\S]+?>/, "");
						data = data.replace("<pre>", "");
						data = data.replace("</pre>", "");
						data = data.replace("<body>", "");
						data = data.replace("</body>", "");
						$.messager.progress('close');
						//		alert(data);
						//		console.log(data);
						//		console.log(data);
						var obj = eval('(' + data + ')');
						//		console.log(obj);
					//	obj.result = Long.valueOf(obj.result);
					//	alert(obj.result)
					//	if (obj.result > 1000010000) {
					//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
					//		$.messager.alert("操作提示", "成功录入 " + Math.floor(obj.result/100000)%10000 + " 名教职工, 更新 " + 
					//				obj.result%10000 + " 名教职工!", "info");
					//		$('#teacherInfoForm').find('#teaInfoTable')
					//		.datagrid('reload');   
					//	} else 
					//	if (obj.result >= 10000) {
					//		$.messager.alert("操作提示", "成功更新 " + obj.result%10000
					//				+ " 名教师信息!", "info");
					//		$('#teacherInfoForm').find('#teaInfoTable')
					//				.datagrid('reload');
					//	} else 
						if (obj.result > 0) {
							$.messager.alert("操作提示", "成功录入 " + obj.result
									+ " 台设备信息!", "info");
					//		$('#teacherInfoForm').find('#teaInfoTable')
					//				.datagrid('reload');
						} else if (obj.result == -1) {
							$.messager.alert("操作提示", "上传的文件格式不正确!",
									"warning");
						} else if (obj.result == -2) {
							$.messager.alert("操作提示", "暂不支持Excel 2007!",
									"warning");
						} else if (obj.result == -3) {
							$.messager.alert("操作提示", "设备信息格式错误!请检查!",
									"warning");
						} else if (obj.result == -4) {
							$.messager.alert("操作提示", "文件上传失败!请稍后再尝试!",
									"warning");  
						} else if (obj.result == -5) {
							$.messager.alert("操作提示", "模板格式错误!请重新下载!",
							"warning"); 
						} else if (obj.result < -10000) {
							$.messager.alert("操作提示", "第 " + (obj.result*-1)%10000 + " 行的设备分类不存在!<br>请先创建该分类!",
							"warning"); 
						} else if (obj.result < -1000) {
							$.messager.alert("操作提示", "第 " + (obj.result*-1)%1000 + " 行的所属专业不存在!<br>请检查!",
							"warning"); 
						} 
					}
				//		error: function(data, status, e) {
				//			$.messager.alert("操作提示","访问失败!\n请检查网络是否连接。", "warming");
				//		}
				})     
		$('#importEquItemByExcel').find('#equItemExcelFileName').textbox('setValue',
				'')
	}
}
</script>