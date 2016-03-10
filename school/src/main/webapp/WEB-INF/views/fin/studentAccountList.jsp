<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">
	<div id="studentAccountToolbar" style="padding: 5px; height: auto">
		<div>

			<td>学生姓名：</td>
			<td><input class="easyui-validatebox textbox" id="finStuName"
				name="finStuName" style="width: 100px; height: 18px; padding: 5px" />

			</td>

			<!-- <td>年级:</td>
			<td><input class="easyui-validatebox textbox" id="finGrade"
				name="finGrade" style="width: 100px; height: 18px; padding: 5px" />

			</td> -->
			<td>班级:</td>
			<td><input class="easyui-validatebox textbox" id="finClassName"
				name="finClassName" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			<td>年级:</td>
			<td>
				<select class="easyui-combobox" id="finGrade" name="finGrade" 
					data-options="editable:false,panelHeight: 'auto',panelWidth: '105px'"
					style="width: 105px; height: 33px; padding: 5px">
					<option value="请选择">请选择</option> 
					<c:forEach items="${gradeList }" var="m">
						<option value="${m.id }">${m.name }</option>
					</c:forEach>
				</select>
			</td> 
			<!-- <td>所属专业:</td>
			<td><input class="easyui-validatebox textbox" id="finMajor"
				name="finMajor" style="width: 100px; height: 18px; padding: 5px" />

			</td>
			<td>专业方向:</td>
			<td><input class="easyui-validatebox textbox" id="finField"
				name="finField" style="width: 100px; height: 18px; padding: 5px" />

			</td> -->
			<td>所属专业:</td>
			<td>
				<select class="easyui-combobox" id="finMajor" name="finMajor" 
					data-options="editable:false,panelHeight: 'auto',panelWidth: '105px'"
					style="width: 105px; height: 33px; padding: 5px">
					<option value="请选择">请选择</option> 
					<c:forEach items="${majorList }" var="m">
						<option value="${m.id }">${m.name }</option>
					</c:forEach>
				</select>
			</td> 
			<td>专业方向：</td>
			<td>
				<select class="easyui-combobox" id="finField" name="finField" 
					data-options="editable:false,panelHeight: 'auto',panelWidth: '105px'"  style="width: 105px; height: 33px; padding: 5px">
					<option value="0">请选择</option> 
				</select>
			</td>
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStudentAccount('#studentAccountToolbar', '#studentAccountList')"
				iconCls="icon-search">查询</button>
		</div>
	</div>
	<table id="studentAccountList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		url="${contextPath}/fin/getStudentAccountList.do"
		toolbar="#studentAccountOperToolbar" rownumbers="true"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="finStuName" width="90" align="center">学生姓名</th>
				<th field="finStuCode" width="100" align="center">学号</th>
				<th field="finGrade" width="90" align="center">年级</th>
				<th field="finClassName" width="120" align="center">班级</th>
				<th field="finMajor" width="120" align="center">所属专业</th>
				<th field="finField" width="155" align="center">专业方向</th>
				<th field="name" width="100" align="center">银行户名</th>
				<th field="account" width="200" align="center">银行账号</th>
				
			</tr>
		</thead>
	</table>
	<div id="studentAccountOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="openTab('fin/toAddStudentAccount.do','新增学生账号')">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditStudentAccount()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="openAddStudentAccountByExcel()">导入学生账号</a>
	</div>
	
	<!-- 通过excel导入教师信息 -->
	<div class="easyui-window" id="addStudentAccountByExcel"
		data-options="modal:true,closed:true,iconCls:'icon-print'"
		title="excel表导入学生银行账号" style="width: 520px; height: 200px">
		<div style="margin: 30px auto auto auto">
			<span style="color: red; margin-left: 20px">注意:请按照excel表模版的格式上传学生银行账号，如未下载模版，请点击:</span>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-print" data-options="plain:true"
				onclick="downloadStudentAccountModelExcel()">模板下载</a><br />
			<div style="margin: 30px auto auto 60px;">
		<!--  		<input id="uploadfile" class="easyui-filebox" data-options="prompt:'请选择一个Excel文件' ,iconCls:'icon-search',buttonText:'浏览'" style="width:80%;">-->
	
				 <input type="text" class="easyui-textbox"
					id="excelStudentAccountFileName"
					style="width: 250px; height: 25px;" editable="false"> 
					<a
					onclick="$('#addStudentAccountByExcel').find('#studentAccountFile').click()"
					class="easyui-linkbutton" iconCls="icon-search">浏览</a> 
					<input
					type="file" name="studentAccountFile" id="studentAccountFile"
					style="position: absolute; display: none"
					onchange="$('#addStudentAccountByExcel').find('#excelStudentAccountFileName').textbox('setValue',this.value)" />
				<a onclick="uploadStudentAccountTotalInfoFile()" id="teaFileUpload"
					class="easyui-linkbutton" iconCls="icon-save" >上传</a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	/*
	专业和方向的二级联动 
	*/
	$('#finMajor').combobox({
	onSelect : function(){
		var majorId = $('#studentAccountToolbar')
				.find('#finMajor').combobox('getValue');
		if (majorId != '请选择' || majorId != null ){
			$('#finField').combobox({
				url : 'edu/getFieldByMajorId.do?majorId=' + majorId,
				valueField : 'id',
				textField : 'name',
				value : '请选择'
			});
		} else{
			$('#finField').combobox('setValue','请选择');
			
		}
	}
	});
});
	//打开导入学生账号窗口
	function openAddStudentAccountByExcel() {
		
		$('#addStudentAccountByExcel').window('open');

	}

	//下载学生账号excel模板
	function downloadStudentAccountModelExcel() {
		//取得所有未录入的学生的id
		$.post('fin/getStudentIdsByNotSettingStudentAccount.do', {
					}, function(result) {
					/* 	 console.log(result);  */
						
						if(result.length==0) {
							$.messager.alert("操作提示", "您好，全部学生已经录入完毕，无需下载模板！", "info");
						}else {
							/* var str = '';
							for(var i = 0; i < result.length; ++i) {
								str += result[i].id;
								if (result.length > (i+1))
									str += ',';
							}  */
							window.open('${contextPath}/fin/downloadStudentAccountModelExcel.do?stuId=' + result);
						}
					/* 	console.log(str); */
						
					}, 'json');
		
	}

	//上传
	function uploadStudentAccountTotalInfoFile() {
		if ($('#addStudentAccountByExcel').find('#excelStudentAccountFileName')
				.textbox('getValue').trim() == '')
			$.messager.alert('操作提示', '请先选择文件!', 'warning');
		else {
			$.messager.progress({
				title : '操作提示',
				text : '正在上传...'
			});
			
			$.ajaxFileUpload({
				url : 'fin/importStudentAccountByExcel.do',
				//		type : 'post',
				fileElementId : 'studentAccountFile',
				secureuri : false,
				dataType : 'text',
				success : function(data, status) {
				//	data = data.replace("<html>", "");
				//	data = data.replace("</html>", "");
					/* data = data.replace(/<pre[\s\S]+?>/, "");
					data = data.replace("<pre>", "");
					data = data.replace("</pre>", ""); */
				//	data = data.replace("<body>", "");
				//	data = data.replace("</body>", "");
				data = data.replace(/<pre>|<pre[\s\S]+?>/, "");
				data = data.replace("</pre>", "");
					$.messager.progress('close');
					//		alert(data);
					//		console.log(data);
					//		console.log(data);
					var obj = eval('(' + data + ')');
					//		console.log(obj);
					//	obj.result = Long.valueOf(obj.result);
					//	alert(obj.result)
					if (obj.result > 1000010000) {
						//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
						$.messager.alert("操作提示", "成功录入 "
								+ Math.floor(obj.result / 100000) % 10000
								+ " 条学生银行账号记录, 更新 " + obj.result % 10000 + " 条学生银行账号记录!",
								"info");
						$('#studentAccountList').datagrid(
								'reload');
					} else if (obj.result >= 10000) {
						$.messager.alert("操作提示", "成功更新 " + obj.result % 10000
								+ " 条学生银行账号记录!", "info");
						$('#studentAccountList').datagrid(
								'reload');
					} else if (obj.result > 0) {
						$.messager.alert("操作提示", "成功录入 " + obj.result
								+ " 条学生银行账号记录!", "info");
						$('#studentAccountList').datagrid(
								'reload');
					} else if (obj.result == -1) {
						$.messager.alert("操作提示", "上传的文件格式不正确!", "warning");
					} else if (obj.result == -2) {
						$.messager.alert("操作提示", "暂不支持Excel 2007!", "warning");
					} else if (obj.result == -3) {
						$.messager.alert("操作提示", "学生银行账号格式错误!请检查!", "warning");
					} else if (obj.result == -4) {
						$.messager.alert("操作提示", "文件上传失败!请稍后再尝试!", "warning");
					} else if (obj.result == -5) {
						$.messager.alert("操作提示", "模板格式错误!请重新下载模板!", "warning");
					} else if (obj.result == -6) {
						$.messager.alert("操作提示", "模板内容错误!请重新下载模板!", "warning");
					}else if (obj.result == -8) {
						$.messager.alert("操作提示", "已有相同的银行账号存在，请检查!", "warning");
					}
					else if (obj.result == -7) {
						$.messager.alert("操作提示", "银行账号只能为16位或19位的纯数字", "warning");
					}else if (obj.result == -9) {
						$.messager.alert("操作提示", "导入的excel表格存在银行账号重复的记录，请检查！", "warning");
					}
				}
			})
			$('#addStudentAccountByExcel').find('#excelStudentAccountFileName').textbox('setValue',
					'') 
		}
	}

	function searchStudentAccount(toolbar, datagrid) {
		var finStuName = $(toolbar).find("#finStuName").val();
		var finClassName = $(toolbar).find("#finClassName").val();
		var finGrade = $(toolbar).find("#finGrade").combobox('getValue');
		var finField = $(toolbar).find("#finField").combobox('getValue');
		var finMajor = $(toolbar).find("#finMajor").combobox('getValue');
		if(finMajor=="请选择") {
			finMajor=0;
		}
		if(finGrade=="请选择") {
			finGrade=0;
		}
		if(finField=="请选择") {
			finField=0;
		}
		//!-AJAX请求数据
		if(isNaN(finField)) {
			finField =0;
		}
		if(isNaN(finMajor)) {
			finMajor =0;
		}
		$(datagrid).datagrid('load', {
			finStuName : finStuName,
			finGrade : finGrade,
			finClassName : finClassName,
			finMajor : finMajor,
			finField : finField,
		});
	}

	function toEditStudentAccount() {

		var row = $('#studentAccountList').datagrid('getSelected');
		if (row) {
			openTab('fin/toEditStudentAccount.do?id=' + row.id + "&studentId="
					+ row.studentId + "&name=" + row.name + "&account="
					+ row.account + "&finGrade=" + row.finGrade
					+ "&finClassName=" + row.finClassName + "&finMajor="
					+ row.finMajor + "&finField=" + row.finField + "&finStuName=" + row.finStuName + "&finStuCode=" + row.finStuCode, '编辑学生银行信息');
		} else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
	}

	function deleteStudentAccount() {

		var row = $('#studentAccountList').datagrid('getSelected');
		if (row) {

			$.messager.confirm('请确认...', '您确定要撤销此教师异动信息吗?', function(r) {
				if (r) {
					$.post('tea/deleteStudentAccount.do', {
						id : row.id,
						code : row.code
					}, function(result) {
						if (result.success) {
							$.messager.alert("操作提示", "撤销成功！", "info");
							$('#studentAccountList').datagrid('reload'); // reload the user data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : '撤销教师异动信息失败'
							});
						}
					}, 'json');
				}
			});
		} else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
	}
</script>
