<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/My97DatePicker/lang/zh-cn.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<!--

//-->

<div style="width: 99%; height: auto">
	<div id="equipmentToolbar" style="padding: 5px; height: auto">
		<div>
			<td>类别:</td>
				<td><input class="easyui-validatebox textbox" id="category"
					name="category" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
			
			<td>来源:</td>
				<td>
					<select class="easyui-combobox" id="source" name="source"
						data-options="editable:false,panelHeight: 'auto'" style="width:80px;height:31px">
						<option value="">请选择</option>			
						<c:forEach items="${sList }" var="s">
							<option value="${s.id }">${s.name }</option>
						</c:forEach>		
					</select>
				</td>  
				
			<td>使用状态:</td>
			<td>
				<select class="easyui-combobox" id="useStatus" name="useStatus" 
					data-options="editable:false,panelHeight: 'auto'" style="width:80px;height:31px">
					<option value="">请选择</option> 
					<c:forEach items="${uList }" var="u">
						<option value="${u.id }">${u.name }</option>
					</c:forEach>
				</select>
				</td> 
			
			<!-- 
			<td>购买日期 :</td>
			<td><input class="easyui-datebox" id="buyTime" name="buyTime" 
				style="width: 100px; height: 31px; padding: 5px" />
			 -->
				<!--  
			<img onclick="WdatePicker({el:'buyTime'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			-->
			</td>
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchEquipment('#equipmentToolbar', '#equList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="equList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/equ/getEquList.do" toolbar="#equOperToolbar"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="name" width="100" align="center">名称</th>
				<th field="code" width="200" align="center">编号</th>
				<th field="brand" width="100" align="center">品牌</th>
				<th field="model" width="100" align="center">型号</th>
				<th field="category" width="100" align="center">类别</th>
				<th field="useStatusStr" width="100" align="center">使用状态</th>
				<th field="sourceStr" width="100" align="center">来源</th>
				<th field="buyTime" width="100" align="center">购买日期</th>
				<th field="store" width="100" align="center">存放地</th>
				<th field="building" width="100" align="center">楼号</th>
				<th field="room" width="100" align="center">房间号</th>
				<th field="remark" width="100" align="center">备注</th>
			</tr>
		</thead>
	</table>
	
    <div id="equOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="openTab('equ/toAddEquipmentItem.do','添加新设备')">添加新设备</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true"
				onclick="openImportEquItemByExcelWindow('#importEquItemByExcel')">批量导入新设备</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-undo" plain="true"
			onclick="openTab('equ/toReturnEquipmentItem.do', '归还设备')">归还设备</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" 
        	iconCls="icon-search" plain="true" onclick="showUseDetail()">查看设备使用详情</a>
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
    
	  <script type="text/javascript">
	  function searchEquipment(toolbar, datagrid) {
			var category = $(toolbar).find("#category").val();
			//var brand = $(toolbar).find("#brand").val();
			//var model = $(toolbar).find("#model").val();
			//var code = $(toolbar).find("#code").val();
			//var buyTime = $(toolbar).datebox('getValue');
			var useStatus = $(toolbar).find("#useStatus").combobox('getValue');
			var source = $(toolbar).find("#source").combobox('getValue');
		  	// alert("searching...");
			//!-AJAX请求数据
			 $(datagrid).datagrid('load', {
				category:category,
				useStatus:useStatus,
				source:source
//				buyTime:buyTime
			}); 
			/*
			$.post("equ/getEquList.do",{category:category,useStatus:useStatus,source:source,buyTime:buyTime},function(data){
				alert(data);
			});*/
		
		}
	  
	  function showUseDetail(){
		  var row = $('#equList').datagrid('getSelected');
		  if (row){	  
			  //openTab("equ/toEquUseDetail?id="+row.id,'设备使用详情');
			  openTab("equ/toEquUseDetail.do?id="+row.id,'设备使用详情');
		  } else{
			  $.messager.alert('操作提示','请先选择一行!','warning');
		  }
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
	 					//	alert(obj.result);
	 					//	if (obj.result > 1000010000) {
	 					//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
	 					//		$.messager.alert("操作提示", "成功录入 " + Math.floor(obj.result/100000)%10000 + " 名教职工, 更新 " + 
	 					//				obj.result%10000 + " 名教职工!", "info");
	 					//		$('#teacherInfoForm').find('#teaInfoTable')
	 					//		.datagrid('reload');   
	 					//	} else if (obj.result >= 10000) {
	 					//		$.messager.alert("操作提示", "成功更新 " + obj.result%10000
	 					//				+ " 名教师信息!", "info");
	 					//		$('#teacherInfoForm').find('#teaInfoTable')
	 					//				.datagrid('reload');
	 					//	} else 
	 						if (obj.result > 0) {
	 							$.messager.alert("操作提示", "成功录入 " + obj.result
	 									+ " 台设备信息!", "info");
	 							$('#equList').datagrid('reload');
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
	 						} else if (obj.result < -100000) {
	 							$.messager.alert("操作提示", "第 " + (obj.result*-1)%100000 + " 行的设备信息不完整!<br>请检查!",
								"warning"); 
	 						}  else if (obj.result < -10000) {
	 							$.messager.alert("操作提示", "第 " + (obj.result*-1)%10000 + " 行的设备分类不存在!<br>请先创建该分类!",
								"warning"); 
	 						} else if (obj.result < -1000) {
	 							$.messager.alert("操作提示", "第 " + (obj.result*-1)%1000 + " 行的仓库不存在!<br>请检查!",
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