<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div   style="width: 99%; height: auto">
	<div id="tuitionToolbar" style="padding: 5px; height: auto">
	
			<td>姓名：</td>
			<td><input class="easyui-validatebox textbox" id="name"
				name="name" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			
			<td>学号:</td>
			<td><input class="easyui-validatebox textbox" id="code"
				name="code" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			
			<td>班级:</td>
			<td><input class="easyui-validatebox textbox" id="className"
				name="className" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			
			<td>是/否免学费：</td>
				<td><select class="easyui-combobox" id="isFreeTuition"
					name="isFreeTuition" style="width:70px; height: 31px; padding: 5px "align="center" 
					data-options="editable:false,panelHeight: 'auto'">
					<option value="">请选择</option>
					<option value="2001">是</option>
					<option value="2002">否</option>
					</select>
				</td> 
				
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStudent('#tuitionToolbar', '#tuitionList')"
				iconCls="icon-search">查询</button>
		</div>

	<div id="tuitionOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="setTuitionFree()">设置免学费</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="cancelTuitionFree()">取消免学费</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="openAddFreeTuitionStudentByExcel()">导入免学费学生信息</a>
	</div>
	
	<div id="tuitionTable" style="margin: 5px;">
		<table id="tuitionList" class="easyui-datagrid" style="width: auto;"
			pagination="true" url="${contextPath}/fin/getStudentList.do"
			toolbar="#tuitionOperToolbar" rownumbers="true" singleSelect="false"
			data-options="pageSize:10">
			<thead>
				<tr>
					<th field="" checkbox="true"></th>
					<th field="name" align="center" width="80px">姓名</th>
					<th field="code" align="center" width="80px">学号</th>
					<th field="className" align="center" width="60px">所属班别</th>
					<th field="studentInfoId" align="center" width="100px">学生基本信息ID</th>
					<th field="stuStatus" align="center" width="60px">学籍状态</th>
					<th field="stuIsFreeTuition" align="center" width="100px">是否免学费</th>
					<th field="remark" align="center" width="100px">备注</th>
				</tr>
			</thead>
		</table>
	</div>
<!-- 通过excel导入免学费学生信息 -->
	<div class="easyui-window" id="addFreeTuitionStudentByExcel"
		data-options="modal:true,closed:true,iconCls:'icon-print'"
		title="excel表导入免学费学生信息" style="width: 540px; height: 200px">
		<div style="margin: 30px auto auto auto">
			<span style="color: red; margin-left: 20px">注意:请按照excel表模版的格式上传免学费学生信息，如未下载模版，请点击:</span>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-print" data-options="plain:true"
				onclick="downloadFreeTuitionStudentModelExcel()">模板下载</a><br />
			<div style="margin: 30px auto auto 60px;">
		<!--  		<input id="uploadfile" class="easyui-filebox" data-options="prompt:'请选择一个Excel文件' ,iconCls:'icon-search',buttonText:'浏览'" style="width:80%;">-->
	
				 <input type="text" class="easyui-textbox"
					id="excelFreeTuitionStudentName"
					style="width: 250px; height: 25px;" editable="false"> 
					<a
					onclick="$('#addFreeTuitionStudentByExcel').find('#freeTuitionStudentFile').click()"
					class="easyui-linkbutton" iconCls="icon-search">浏览</a> 
					<input
					type="file" name="freeTuitionStudentFile" id="freeTuitionStudentFile"
					style="position: absolute; display: none"
					onchange="$('#addFreeTuitionStudentByExcel').find('#excelFreeTuitionStudentName').textbox('setValue',this.value)" />
				<a onclick="uploadFreeTuitionStudentTotalInfoFile()" id="freeTuitionStudentFileUpload"
					class="easyui-linkbutton" iconCls="icon-save" >上传</a>
				
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
	
	function searchStudent() {
		var name = $(tuitionToolbar).find("#name").val();
		var code = $(tuitionToolbar).find("#code").val();
		var className = $(tuitionToolbar).find("#className").val();
		var isFreeTuition = $(tuitionToolbar).find("#isFreeTuition").combobox('getValue');

		//!-AJAX请求数据		
			$('#tuitionTable').find('#tuitionList').datagrid({
				url : "${contextPath }/fin/getStudentList.do",
				queryParams : {
					//	condition : text
					name : name,
					code : code,
					className : className,
					isFreeTuition : isFreeTuition
				}
		});
	}
	//一键设置免学费
	function setTuitionFree() {
		var setFreeIds = "";
		var selecteds = $('#tuitionTable').find('#tuitionList').datagrid(
				'getSelections');
		for (var i = 0; i < selecteds.length; ++i) {
			setFreeIds += selecteds[i].id;
			if (i < selecteds.length - 1)
				setFreeIds += ","
		}
		
		if (setFreeIds == "")
			$.messager.alert("操作提示", "请先选择需要设置免学费的学生!", "warning");
		else
			$.messager.confirm("操作提示", "您确定要执行操作吗?", function(data) {
				if (data) {
					$.post('fin/setTuitionFree.do', {
						setFreeIds : setFreeIds
					}, function(data) {
						var obj = eval('(' + data + ')');
						$.messager.alert("操作提示", obj.result + " 名学生设置免学费成功!",
								"info");
						$('#tuitionTable').find('#tuitionList').datagrid(
								'reload');
					});
				}
			});
	}
	//一键取消免学费
	function cancelTuitionFree() {
		var cancelFreeIds = "";
		var selecteds = $('#tuitionTable').find('#tuitionList').datagrid(
				'getSelections');
		for (var i = 0; i < selecteds.length; ++i) {
			cancelFreeIds += selecteds[i].id;
			if (i < selecteds.length - 1)
				cancelFreeIds += ","
		}
		
		if (cancelFreeIds == "")
			$.messager.alert("操作提示", "请先选择需要取消免学费的学生!", "warning");
		else
			$.messager.confirm("操作提示", "您确定要执行操作吗?", function(data) {
				if (data) {
					$.post('fin/cancelTuitionFree.do', {
						cancelFreeIds : cancelFreeIds
					}, function(data) {
						var obj = eval('(' + data + ')');
						$.messager.alert("操作提示", obj.result + " 名学生取消免学费成功!",
								"info");
						$('#tuitionTable').find('#tuitionList').datagrid(
								'reload');
					});
				}
			});
	}
	//打开导入免学费学生信息窗口
	function openAddFreeTuitionStudentByExcel() {
		
		$('#addFreeTuitionStudentByExcel').window('open');

	}

	//下载免学费学生信息excel模板
	function downloadFreeTuitionStudentModelExcel() {
		window.open('${contextPath}/fin/downloadFreeTuitionStudentModelExcel.do');
	}

	//上传
	function uploadFreeTuitionStudentTotalInfoFile() {
		if ($('#addFreeTuitionStudentByExcel').find('#excelFreeTuitionStudentName')
				.textbox('getValue').trim() == '')
			$.messager.alert('操作提示', '请先选择文件!', 'warning');
		else {
			$.messager.progress({
				title : '操作提示',
				text : '正在上传...'
			});
			
			$.ajaxFileUpload({
				url : 'fin/importFreeTuitionStudentByExcel.do',
				//		type : 'post',
				fileElementId : 'freeTuitionStudentFile',
				secureuri : false,
				dataType : 'text',
				success : function(data) {
					data = data.replace(/<pre>|<pre[\s\S]+?>/, "");
					data = data.replace("</pre>", "");
					$.messager.progress('close');
					//var obj = eval('(' + data + ')');
					var obj=JSON.parse(data);
				    if (obj.result >= 0) {
						$.messager.alert("操作提示", "成功更新 " + obj.result + " 条免学费学生信息记录!<br/><br/>"+"录入失败学生名单(学号错误/重复)："+obj.errorStr);
						$('#tuitionTable').find('#tuitionList').datagrid('reload');
					} else if (obj.result == -1) {
						$.messager.alert("操作提示", "上传的文件格式不正确!", "warning");
					} else if (obj.result == -2) {
						$.messager.alert("操作提示", "暂不支持Excel 2007!", "warning");
					} else if (obj.result == -3) {
						$.messager.alert("操作提示", "免学费学生信息格式错误!请检查!", "warning");
					} else if (obj.result == -4) {
						$.messager.alert("操作提示", "文件上传失败!请稍后再尝试!", "warning");
					} else if (obj.result == -5) {
						$.messager.alert("操作提示", "模板格式错误!请重新下载模板!", "warning");
					} else if (obj.result == -6) {
						$.messager.alert("操作提示", "模板内容错误!请重新下载模板!", "warning");
					}
				}
			})
			$('#addFreeTuitionStudentByExcel').find('#excelFreeTuitionStudentName').textbox('setValue','') 
			$('#addFreeTuitionStudentByExcel').window('close'); 
		
		}
	}
	
</script>
