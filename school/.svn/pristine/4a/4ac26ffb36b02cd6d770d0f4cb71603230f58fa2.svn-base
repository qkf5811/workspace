<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">

	<!-- datagrid -->
	<div style="padding:5px" id="newStudentPaymentFormOfDatagrid">
		<div style="padding: 5px;">
			<span>姓名:</span>
			<input class="easyui-textbox" style="height: 28px" id="stuName">
			&nbsp;&nbsp;&nbsp;
			<span>录取号:</span>
			<input class="easyui-textbox" style="height: 28px" id="admissionNumber">
			&nbsp;&nbsp;&nbsp;
			<span>身份证号:</span>
			<input class="easyui-textbox" style="height: 28px" id="idCard">
			&nbsp;&nbsp;&nbsp;
			<span>所属专业:</span>
			<select class="easyui-combobox"  id="majorOfNewStudentPayment" style="width: 150px;height:28px" data-options="editable:false,panelHeight:'auto',panelWidth: '150px'">
				<option value="请选择">请选择</option>
				<c:forEach items="${major }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select>
			<select class="easyui-combobox" id="fieldOfNewStudentPayment" name="fieldOfNewStudentPayment" style="width: 150px;height:28px" data-options="novalidate:true,missingMessager:'该处未选择',editable:false,panelHeight:'auto',panelWidth: '150px'"
					validtype="selectRequired['fieldOfNewStudentPayment']">
				<option value="请选择">请选择</option>
			</select>
			&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search"
				onclick="findNewStudentPaymentByConditions()">查询</a>
		</div>
		
		<table id="datagridOfNewStudentPayment" class="easyui-datagrid" pagination="true"
			   rownumbers="true" singleSelect="true" data-options="pageSize:10"
			   toolbar="#newStudentPaymentToolbar"
			   url="${contextPath }/fin/findNewStudentPayment.do?name= &admissionNumber= &idCard= &fieldId=0"
			   style="padding: 5px;"
		>
			<thead>
				<tr>
					<th field="name" width="120px" align="center">姓名</th>
					<th field="admissionNumber" width="150px" align="center">录取号</th>
					<th field="idCard" width="200px" align="center">身份证号</th>
					<th field="payTypeStr" width="120px" align="center">缴费方式</th>
					<th field="payMoney" width="120px" align="center">缴费金额</th>
					<th field="payTime" width="200px" align="center">缴费时间</th>
					<th field="payOrder" width="200px" align="center">缴费单号</th>
					<th field="remark" width="200px" align="center">备注</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- datagrid toolbar -->
	<div id="newStudentPaymentToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openImportNewStudentPaymentWindow()">导入新生缴费资料</a>
	</div>

	<!-- window -->
	<div style="text-align:center;width: 540px; height: 180px" class="easyui-window"
		 id="importNewStudentPaymentWindow"
		 data-options="modal:true,closed:true,iconCls:'icon-print'"
		 title="excel表导入新生缴费资料">
			<div style="margin:15px">
				<strong style="text-align:center;">导入新生缴费资料</strong><br />
				<span style="color: red; margin-left: 20px">注意:请按照excel表模版的格式上传新生缴费信息，如未下载模版，请点击:</span>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-print" data-options="plain:true"
					onclick="downloadNewStudentPaymentExcel()">模板下载</a>
			</div>
		  	<form id="newStudentPaymentUploadForm" method="post">
		  		<input type="text" class="easyui-textbox" id="newStudentPaymentExcelFile" name="newStudentPaymentExcelFile"
						   style="width: 250px; height: 25px;" editable="false">
		  		<a onclick="$('#newStudentPaymentUploadForm').find('#newStudentPaymentExcel').click()"
					   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
		  		<input type="file" id="newStudentPaymentExcel" name="newStudentPaymentExcel" style="display:none"
		  			onchange="$('#newStudentPaymentUploadForm').find('#newStudentPaymentExcelFile').textbox('setValue', this.value)">
		  		<a onclick="uploadNewStudentPaymentExcelFile()"
					   class="easyui-linkbutton" iconCls="icon-save">导入</a>
		  	</form>
	</div>
</div>

<script type="text/javascript">

	$(function(){
		
		//专业和专业方向二级联动
		var major = $('#newStudentPaymentFormOfDatagrid').find('#majorOfNewStudentPayment');
		major.combobox({
			onSelect : function() {
				var majorId = major.combobox('getValue');
			//	alert(majorId);
				if (majorId != '请选择' && majorId != null) {
					$(
							'#newStudentPaymentFormOfDatagrid')
							.find('#fieldOfNewStudentPayment')
							.combobox(
									{
										url : "${contextPath}/stu/getMajorFieldInfo.do?majorId="
												+ majorId,
										valueField : 'id',
										textField : 'name',
										value : "请选择"
									});
				} else {
					$(
							'#newStudentPaymentFormOfDatagrid')
							.find('#fieldOfNewStudentPayment')
							.combobox('loadData', {});
					$(
							'#newStudentPaymentFormOfDatagrid')
							.find('#fieldOfNewStudentPayment')
							.combobox('setValue', '请选择');
				}
			}
		});
	})
	
	//下载新生缴费资料模板
	function downloadNewStudentPaymentExcel() {
		
		window.open("fin/downloadNewStudentPaymentExcel.do");
	}
	
	//上传新生缴费资料模板
	function uploadNewStudentPaymentExcelFile() {
		
		if ($('#newStudentPaymentUploadForm').find('#newStudentPaymentExcelFile').textbox('getValue')
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
						url : 'fin/importNewStudentPaymentByExcel.do',
						//		type : 'post',
						fileElementId : 'newStudentPaymentExcel',
						secureuri : false,
						dataType : 'text',
						success : function(data, status) {
							data = data.replace("<html>", "");
							data = data.replace("</html>", "");
							data = data.replace(/<pre[\s\S]+?>/, "");
							data = data.replace("</pre>", "");
							data = data.replace("<body>", "");
							data = data.replace("</body>", "");
							$.messager.progress('close');
							//		alert(data);
							//		console.log(data);
							//		console.log(data);
					//		var obj = eval('(' + data + ')');
							//		console.log(obj);
						//	obj.result = Long.valueOf(obj.result);
						//	obj = parseFloat(obj); 
						//	alert(data);
							obj = data;
							if (obj > 1000010000) {
								//alert("进入!" +  Math.floor(obj.result/10000) + ", ");
								$.messager.alert("操作提示", "成功录入 " + Math.floor(obj/100000)%10000 + " 条新生缴费记录, 更新 " + 
										obj%10000 + " 条新生缴费记录!", "info");
								$('#datagridOfNewStudentPayment')
								.datagrid('reload');   
							} 
						//	if (obj > 10000000000000) {
						//		$.messager.alert("操作提示", "录入失败!<br>身份证号为 " + obj + " 的新生缴费记录已经存在!", "warning");
						//	}
							else if (obj > 100000) {
						//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
								$.messager.alert("操作提示", "成功更新 " + obj%100000 + " 条新生缴费资料记录!", "info");
								$('#datagridOfNewStudentPayment').datagrid('reload');   
							} 
							else if (obj > 10000) {
						//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
								$.messager.alert("操作提示", "成功录入 " + obj%10000 + " 条新生缴费资料记录!", "info");
								$('#datagridOfNewStudentPayment').datagrid('reload');   
							} else if (obj == 0) {
								$.messager.alert("操作提示", "导入时发生错误!", "info");
								$('#teacherInfoForm').find('#teaInfoTable')
										.datagrid('reload');
							} else if (obj == -1) {
								$.messager.alert("操作提示", "文件读取出错!<br>请稍后再尝试!",
										"warning");
							} else if (obj == -2) {
								$.messager.alert("操作提示", "文件上传失败!<br>请稍后再尝试!",
										"warning");
							} else if (obj == -3) {
								$.messager.alert("操作提示", "模板格式错误!<br>请重新下载!",
										"warning");
							} else if (obj == -4) {
								$.messager.alert("操作提示", "非Excel文件!",
										"warning");  
							} else if (obj == -5) {
								$.messager.alert("操作提示", "新生缴费条目格式错误!<br>请检查!",
								"warning"); 
					//		} else if (obj == -6) {
					//			$.messager.alert("操作提示", "新生(详细信息中)的身份证号重复!<br>请将重复信息删除后再进行导入操作!",
					//			"warning"); 
							} else if (obj < -10000) {
								$.messager.alert("操作提示", "第 " + obj*(-1)%10000 + " 行的新生(详细信息中)的身份证号有重复!<br>请将重复信息删除后再进行导入操作!",
								"warning"); 
							} else if (obj < -1000) {
								$.messager.alert("操作提示", "第 " + obj*(-1)%1000 + " 行缴费信息发生错误!<br>请检查新生的身份证号是否正确!",
								"warning"); 
							}
						}
					//		error: function(data, status, e) {
					//			$.messager.alert("操作提示","访问失败!\n请检查网络是否连接。", "warming");
					//		}
					})     
			$('#newStudentPaymentUploadForm').find('#newStudentPaymentExcelFile').textbox('setValue','')
		}
	}
	
	//打开导入窗口
	function openImportNewStudentPaymentWindow(){
		
		$('#importNewStudentPaymentWindow').window('open');
	}
	
	//查找
	function findNewStudentPaymentByConditions() {
		
		var name = $('#newStudentPaymentFormOfDatagrid').find('#stuName').textbox('getValue');
		var idCard = $('#newStudentPaymentFormOfDatagrid').find('#idCard').textbox('getValue');
		var majorId = $('#newStudentPaymentFormOfDatagrid').find('#majorOfNewStudentPayment').combobox('getValue');
		var fieldId = $('#newStudentPaymentFormOfDatagrid').find('#fieldOfNewStudentPayment').combobox('getValue');
		var admissionNumber = $('#newStudentPaymentFormOfDatagrid').find('#admissionNumber').textbox('getValue');
		
 		//判断major是否有选中
 	//	$('#newStudentPaymentFormOfDatagrid').form('enableValidation').form('validate');
 	//	if(!$('#newStudentPaymentFormOfDatagrid').form('validate')){
 	//		;
	//	} 
		if (majorId != "请选择" && fieldId == "请选择") {
		//	alert();
					//在提交数据之前执行表单验证
			$('#newStudentPaymentFormOfDatagrid').form('enableValidation').form('validate');
			    	//判断表单验证是否通过
			if(!$('#newStudentPaymentFormOfDatagrid').form('validate')){
				return false;
			} 
		} else {
			$.parser.parse($('#newStudentPaymentFormOfDatagrid').find('#fieldOfNewStudentPayment').parent());
			//在提交数据之前执行表单验证
				//	$('#newStudentPaymentFormOfDatagrid').form('enableValidation').form('validate');
			    	//判断表单验证是否通过
		//	if(!$('#newStudentPaymentFormOfDatagrid').form('validate')){
			//	;
			//} 
		} 
		
		fieldId = isNaN(fieldId)?0:fieldId;
		
		var param = {
				name : name,
				idCard : idCard,
				admissionNumber : admissionNumber, 
				fieldId : fieldId
		}
		console.log(param);
		
		$('#newStudentPaymentFormOfDatagrid').find('#datagridOfNewStudentPayment').datagrid({
			url : "${contextPath}/fin/findNewStudentPayment.do",
			queryParams : param
			
		});
	}
</script>
