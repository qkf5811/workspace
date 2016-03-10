<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="inputNewStu" style="font-family: '微软雅黑'; margin: 5px">
	<!-- 	<span>查询条件:</span> <input class="easyui-textbox" id="searchBox"> -->
	<span>姓名:</span><input class="easyui-validatebox textbox"
		style="width: 100px; height: 18px; padding: 5px" name="studentName"
		id="studentName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%--<span>班级:</span><input
		class="easyui-validatebox textbox"
		style="width: 100px; height: 18px; padding: 5px" name="className"
		id="className">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>学号:</span><input
		class="easyui-validatebox textbox"
		style="width: 100px; height: 18px; padding: 5px" name="studentCode"
		id="studentCode">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%> <a
		href="javascript: void(0)" class="easyui-linkbutton" data-options="plain:true"
		iconCls="icon-search" onclick="searchAllStudentInfoByTable()">查询</a>

</div>

<div id="inputNewStuTable" style="margin:5px;">
	<!-- 	url="${contextPath }/stu/searchStuInfoOfTable.do" -->
	<!-- url="${contextPath }/stu/searchStuOfTable.do?className=&studentName=&studentCode="-->
	<table class="easyui-datagrid" id="stuInfoTable" pagination="true"
		toolbar="#stuInfoToolbar" rownumbers="true" singleSelect="false"
		   url="${contextPath }/stu/searchNewStudentInfo.do"
		data-options="pageSize:10">
		 		<thead>
			<tr>
				<th field="" checkbox="true"></th>
				<th field="id" align="center" hidden=true>学生id</th>
				<th field="studentNumber" align="center" width="100px">学籍号</th>
				<th field="name" align="center" width="100px">姓名</th>
				<th field="sexTypeStr" align="center" width="50px">性别</th>
				<th field="birthdayStr" align="center" width="100px">出生日期</th>
				<th field="idCard" align="center" width="200px">身份证号</th>
				<th field="nationTypeStr" align="center" width="80px">民族</th>
				<th field="politicalFeatureTypeStr" align="center" width="80px">政治面貌</th>
				<th field="healthTypeStr" align="center" width="80px">健康状况</th>
				<th field="isHkMcStr" align="center" width="60px">港澳侨胞</th>
				<th field="nativePlace" align="center" width="100px">籍贯</th>
				<th field="householdTypeStr" align="center" width="100px">户籍类型</th>
				<th field="householdLocation" align="center" width="200px">户口所在地</th>
				<th field="familyAddress" align="center" width="300px">家庭住址</th>
				<th field="postcode" align="center" width="80px">邮政编码</th>
				<th field="familyPhone" align="center" width="120px">家庭电话</th>
				<th field="graduationSchool" align="center" width="100px">毕业学校</th>
				<th field="examTotalScore" align="center" width="60px">入学总分</th>
				<th field="studyTypeStr" align="center" width="100px">学习形式</th>
				<th field="studyMethodStr" align="center" width="100px">就读方式</th>
				<th field="enterSchoolTypeStr" align="center" width="100px">入学方式</th>
				<th field="entranceDateStr" align="center" width="100px">入校时间</th>
				<th field="remark" align="center" width="200px">备注</th>
			</tr>
		</thead>
		<%--<thead>
			<tr>
				<th field="" align="center" checkbox="true"></th>
				<th field="name" align="center" width="25%">姓名</th>
				<th field="classIdStr" align="center" width="22%">班级</th>
				<th field="id" hidden=true>学生id</th>
				<th field="code" align="center" width="25%">学号</th>
				<th field="classId" align="center" width="200px" hidden=true>班级</th>
				<th field="studentInfoId" align="center" width="200px" hidden=true>学生基本信息id</th>
				<th field="status" align="center" width="200px" hidden=true>学籍状态</th>
				<th field="remark" align="center" width="25%">备注</th>
			</tr>
		</thead>--%>
	</table>
</div>

<div id="stuInfoToolbar">
	<a href="javascript:void(0)"
		onclick="openTab('stu/enrollStudent.do', '新生信息录入')"
		class="easyui-linkbutton" iconCls="icon-add" data-options="plain:true">新生信息录入</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" data-options="plain:true"
			onclick="openAddStudentByExcel()">导入新生数据</a> 
	<!-- 	<a href="javascript:void(0)" onclick="openTab('stu/', '注册')"
		class="easyui-linkbutton" iconCls="icon-edit"
		data-options="plain:true">注册</a> -->
	<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="openTab('stu/toNotAutoDivideClassSettingList.do', '手动分班')">手动分班</a>
	<!-- 
	<a href="javascript:void(0)"
		onclick="openTab('stu/toDivideClassSettingList.do', '分班设置')"
		class="easyui-linkbutton" iconCls="icon-filter"
		data-options="plain:true">分班</a>  -->
	<%--<a href="javascript:void(0)"
		class="easyui-linkbutton" iconCls="icon-edit"
		data-options="plain:true" onclick="studentRegist()">注册</a>--%> <a
		href="javascript:void(0)"
		onclick="window.open('${contextPath}/stu/downloadStudentInfo.do')"
		class="easyui-linkbutton" iconCls="icon-print" data-options="plain:true">导出学籍</a>

	<!-- <span>根据专业查询:</span> <select
		class="easyui-combobox" style="width: 150px"
		data-options="panelWidth: '150px', panelHeight: 'auto', editable:false">
		<option>请选择</option>
	</select> <select class="easyui-combobox" style="width: 150px"
		data-options="panelWidth: '150px', panelHeight: 'auto', editable:false"></select>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>根据姓名查询:</span>
	<input type="text" class="easyui-textbox"> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  -->

</div>

<!-- 通过excel导入教师信息 -->
<div class="easyui-window" id="addStudentByExcel"
	data-options="modal:true,closed:true,iconCls:'icon-print'"
	title="excel表导入新生数据" style="width: 520px; height: 200px">
		<form id="stuInfoUploadForm" style="">
			<div style="margin-top:20px;margin-left:20px;">
				<strong>通过Excel表导入新生数据:</strong>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print"
					data-options="plain:true"
					onclick="downEnrollStuBaseExcel()">模板下载</a><br/>
				<input type="text" class="easyui-textbox" id="excelFileName"
					   style="width: 250px; height: 25px;" editable="false">
			    <a onclick="$('#stuInfoUploadForm').find('#fileField').click()"
				   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
				   <input type="file" name="fileField" id="fileField"
				   		  style="position:absolute; display:none"
				   		  onchange="$('#stuInfoUploadForm').find('#excelFileName').textbox('setValue', this.value)" /> 
				<a onclick="" 
				   id="stuInfoUpload"
				   class="easyui-linkbutton" iconCls="icon-save">上传</a>
			</div>
		</form>
</div>

<script>
	$(function () {
		//文件上传
		$('#stuInfoUploadForm').find('#stuInfoUpload').click(function() {
			if ($('#stuInfoUploadForm').find('#excelFileName').textbox('getValue').trim() == '')
				$.messager.alert('操作提示', '请先选择文件', 'warning');
			else  {
				$.messager.progress({
					title:'操作提示',
					text: '正在上传...'
				});
	//			alert('哈哈');
				//ajaxFileUpload组件上传文件
				$.ajaxFileUpload({
					url:'stu/uploadStuInfoExcel.do',
			//		type : 'post',
					fileElementId:'fileField',
					secureuri: false,
					dataType : 'text',
					success: function(data, status) {
						data = data.replace("<html>", "");
						data = data.replace("</html>", "");
						data = data.replace(/<pre>|<pre[\s\S]+?>/, "");
						data = data.replace("</pre>", "");
						data = data.replace("<body>", "");
						data = data.replace("</body>", "");
						$.messager.progress('close');
						alert(data);
				//		console.log(data);
				//		console.log(data);
						var obj = eval('(' + data + ')');
					//	console.log(obj);
						if (obj.result > 100000000) {
							$.messager.alert("操作提示", "成功录入 " + Math.floor(((obj.result)/10000)%10000) + " 名学生信息!<br>" +
									"更新 " + (obj.result)%10000 + " 名学生信息!", "info");
						} else if (obj.result > 100000) {
							$.messager.alert("操作提示", "成功录入 " + obj.result%100000 + " 名学生信息!", "info");
						} else if (obj.result > 10000) {
							$.messager.alert("操作提示", "成功更新 " + obj.result%10000 + " 名学生信息!", "info");
						}
				//		else if (obj.result > 0) {
				//			$.messager.alert("操作提示", "成功录入 " + obj.result + " 名学生信息!", "info");
				//		}
						else if (obj.result == -1) {
							$.messager.alert("操作提示", "上传的文件格式不正确!", "warning");
						}
						else if (obj.result == -2) {
							$.messager.alert("操作提示", "暂不支持Excel 2007!", "warning");
						} else if (obj.result == -3) {
							$.messager.alert("操作提示", "学生信息格式填写错误!", "warning");
						} else if (obj.result == -4) {
							$.messager.alert("操作提示", "模板格式错误!请重新下载!", "warning");
						} else if (obj.result == -5) {
							$.messager.alert("操作提示", "上传文件失败!请稍后再尝试!", "warning");
						} else if (obj.result < -1000000) {
							$.messager.alert("操作提示", "第 " + (obj.result*-1)%1000000 + " 行的学生信息已存在!<br>请检查身份证号码是否正确!", "warning");
						} else if (obj.result < -100000) {
							$.messager.alert("操作提示", "第 " + (obj.result*-1)%100000 + " 行的学生信息已存在!<br>请检查身份证号码是否正确!", "warning");
						}  else if (obj.result < -10000) {
							$.messager.alert("操作提示", "第 " + (obj.result*-1)%10000 + " 行的专业方向不存在!<br>请检查!", "warning");
						}
					} 
			//		error: function(data, status, e) {
			//			$.messager.alert("操作提示","访问失败!\n请检查网络是否连接。", "warming");
			//		}
				})
				$('#stuInfoUploadForm').find('#excelFileName').textbox('setValue', '')
			}
		});

	});
	
	//打开导入新生信息窗口
	function openAddStudentByExcel() {
		$('#addStudentByExcel').window('open');

	}
	 
	//下载招生录入的原始格式表格
	function downEnrollStuBaseExcel() {
	//	alert("download!");
		var filename = escape("招生信息模板.xls");
		//alert(filename);
		window.open("${contextPath}/stu/downloadFile.do?filename="+encodeURI(filename));
	}

	//查找
	function searchAllStudentInfoByTable() {
		var studentName = $('#inputNewStu').find('#studentName').val()

		$('#inputNewStuTable').find('#stuInfoTable').datagrid({
			url : "${contextPath }/stu/searchNewStudentInfo.do",
			queryParams : {
				studentName : studentName,
			}
		});

	}

	//注册
	function studentRegist() {
		var ids = "";
		var selecteds = $('#inputNewStuTable').find('#stuInfoTable').datagrid(
				'getSelections');
		for (var i = 0; i < selecteds.length; ++i) {
			ids += selecteds[i].id;
			if (i < selecteds.length - 1)
				ids += ","
		}
		//	alert(ids);
		if (ids == "")
			$.messager.alert("操作提示", "请先选择需要注册的学生!", "warning");
		else
			$.messager.confirm("操作提示", "您确定要执行操作吗?", function(data) {
				if (data) {
					$.post('stu/studentRegist.do', {
						ids : ids
					}, function(data) {
						var obj = eval('(' + data + ')');
						$.messager.alert("操作提示", obj.result + " 名学生注册成功!",
								"info");
						$('#inputNewStuTable').find('#stuInfoTable').datagrid(
								'reload');
					});
				}
				//	else
				//	alert("取消");
			});
		//		alert(flag);

	}
	
</script>
