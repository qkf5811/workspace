<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<div class="easyui-panel" style="width: 99%; height: auto">
	<div id="stuPayToolbar" style="padding: 5px; height: auto">
		<div>
				<td><span>学生学号:</span></td>
				<td><input class="easyui-validatebox textbox" id="stuPayCode"
					name="stuPayCode" type="text" 
					style="width: 100px; height: 18px; padding: 5px" />
				</td>  
				
				<td><span>学生姓名:</span></td>
				<td><input class="easyui-validatebox textbox" id="stuPayName"
					name="stuPayName" type="text" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  
				
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchStuPay('#stuPayToolbar', '#stuPayList')"
				iconCls="icon-search">查询</button>
		<!-- 
		<a class="easyui-linkbutton" iconCls="icon-redo" plain="true" 
				style="text-align:center;margin-left:250px" 
				onclick="exportStuPayDialog()">导出成批扣文件</a>
		
			<a class="easyui-linkbutton" iconCls="icon-print" 
				onclick="downloadStuPayBaseFile()" plain="true">批扣文件模板下载</a>
		 -->
		</div>
	</div>
	<table id="stuPayList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/fin/getStudentPaymentList.do" 
		toolbar="#stuPayOperToolbar" rownumbers="true" 
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="stuPayCode" width="80" align="center">学号</th>
				<th field="stuPayName" width="50" align="center">姓名</th>
				<th field="payOrder" width="100" align="center">缴费单号</th>
				<th field="payTypeStr" width="60" align="center">缴费类型</th>
				<th field="payMoney" width="60" align="center">缴费金额</th>
				<th field="tuitionFee" width="60" align="center">应缴学费</th>
				<th field="paidTuitionFee" width="60" align="center">已缴学费</th>
				<th field="bookFee" width="60" align="center">应缴书费</th>
				<th field="paidBookFee" width="60" align="center">已缴书费</th>
				<th field="roomFee" width="80" align="center">应缴住宿费</th>
				<th field="paidRoomFee" width="80" align="center">已缴住宿费</th>
				<th field="payTime" width="80" align="center">缴费时间</th>
				<th field="deductRemark" width="120" align="center">非扣税费用备注</th>
				<th field="remark" width="120" align="center">备注</th>
			</tr>
		</thead>
	</table>

	 
    <div id="stuPayOperToolbar">
    <!-- 
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openTab('stu/toAddStuPayInfo.do','添加学生缴费条目')">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditStuPay()">编辑</a>
        -->
       	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
       			onclick="uploadStuPayInfo()">导入扣费信息</a>
       	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print" 
				onclick="downloadStuPayBaseFile()" plain="true">扣费清单文件下载</a>
       <!-- 
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteStuPay()">删除</a>
		 -->
  </div> 
  
  <div class="easyui-dialog" id="stuPayUploadDialog" title="导入扣费信息" resizable="false" 
 		 style="width:420px;height:250px;padding:10px;-moz-user-select:none;"
 		 data-options="modal:true,iconCls:'icon-edit',closed:true" top="50px">
  		<div style="text-align:center;padding-bottom:10px;">
			<strong style="text-align:center;">导入批扣文件</strong>
		</div>
  		<form id="stuPayExcelForm" method="post">
			<div style="text-align:center">
  			文件名:<input type="text" class="easyui-textbox" id="stuPayFilename" name="stuPayFilename"
				   style="width: 250px; height: 25px;" editable="false" size="100px">
			<br><br>
  			<a onclick="$('#stuPayExcelForm').find('#stuPayfileXls').click()"
			   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
  			<input type="file" id="stuPayfileXls" name="stuPayfileXls" style="display:none"
  			onchange="$('#stuPayExcelForm').find('#stuPayFilename').textbox('setValue', this.value)">
  			<a id="stuPayInfoUpload" 
			   class="easyui-linkbutton" iconCls="icon-save">导入</a>
			</div>
	  	</form>
	  	<div style="text-align: center;margin:25px 0 0;">
	  	<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" style="font-size:14px"
						onclick="$('#stuPayUploadDialog').dialog('close');">关闭</a>
	  	</div>
  	</div>
</div>

<script	type="text/javascript">
	$(function(){
		$('#stuPayInfoUpload').click(function(){
			if ($('#stuPayExcelForm').find('#stuPayFilename').textbox('getValue').trim() == ''){
				$.messager.alert('操作提示','请先选择文件!','warning');
			} /*else if (($('#stuPayExcelForm').find('#stuPayFilename').textbox('getValue').lastIndexOf('.xls') == -1
					|| $('#stuPayExcelForm').find('#stuPayFilename').textbox('getValue').lastIndexOf('.xlsx')) == -1){
				$.messager.alert('操作提示','文件格式不正确!','error');
				
			}*/else {
				//console.log('开始上床。。。');
				$.messager.progress({
					title : '正在上传',
					text  : '正在上传ing...'
				});
				//上传组件
				$.ajaxFileUpload({
					url : 'fin/uploadStuPayInfo.do',
					fileElementId : 'stuPayfileXls',
					secureuri : false,
					dataType : 'text',
					success : function(data,status){
						data = data.replace("<html>", "");
						data = data.replace("</html>", "");
						data = data.replace(/<pre[\s\S]+?>/, "");
						data = data.replace("</pre>", "");
						data = data.replace("<body>", "");
						data = data.replace("</body>", "");
						//alert(data);
						$.messager.progress('close');
						var obj = $.parseJSON(data);
						console.log(obj);
						if (obj != null && obj.result == -1){
							$.messager.alert('操作提示','上传的文件格式不正确!','warning');
						} else if (obj.result > 0){
							$.messager.alert("操作提示","成功录入(更新)"+ obj.result +"条记录","info");
							$('#stuPayList').datagrid('reload');
						}
					}
				});
				$('#stuPayExcelForm').find('#stuPayFilename').textbox('setValue','');
			}
		});
		
	});
	
	/*打开导入窗口*/
	function uploadStuPayInfo(){
		//alert('233333');
		$('#stuPayUploadDialog').dialog('open');
	}
	
	function searchStuPay(toolbar,datagrid){
		//alert("xxx");
		var stuPayCode = $(toolbar).find("#stuPayCode").val();
		var stuPayName = $(toolbar).find("#stuPayName").val();
		$(datagrid).datagrid('load',{
			'stuPayName' 	: stuPayName,
			'stuPayCode' 	: stuPayCode
		});
			
	}
	//下载
	function downloadStuPayBaseFile(){
		var filename = escape("扣费不成功清单.xls");
		window.open("${contextPath}/fin/downloadStuPayBaseFile.do?filename="
				+encodeURI(filename));
	}

	function toEditStuPay(){}
	
	function deleteStuPay(){
		var row = $("#stuPayList").datagrid('getSelected');
		if (row){
			$.messager.confirm('请确认...','您确定要删除此信息吗?',function(r){
				if (r){
					$.post("stu/deleteStuPayInfo.do",{id : row.id},function(result){
						if (result.success){
							$.messager.alert('操作提示','删除成功!','info');
							$("#stuPayList").datagrid('reload');
						} else{
							$.messager.show(
							{
								title : 'Error',
								msg   : '删除信息失败 '
							});
						}
					},'json');
				}
			});
		} else{
			$.messager.alert('操作提示','请先选择要删除的条目!','warning');
		}
	}
	/*
	function exportStuPayDialog(){
		var rows = $('#stuPayList').datagrid('getSelections');
		console.log(rows);
		var params = [];
		var param = null;
		if (rows.length == 0){
			$.messager.alert('操作提示','请至少选择一项','warning');
			return false;
		}
		else {
			for (var i = 0; i < rows.length; i++){
				params.push(rows[i].stuPayCode);
			}
			param = params.join();
			console.log(param);
			$.post('fin/exportStuPayList.do',{
				'param':param
			},function(data){
				//var result = $.parseJSON(data);
				if (data == '-1')
					$.messager.alert('操作提示',
							'导出失败请刷新后重试!','error');
				else {
					var filename = escape(data);
					window.open('${contextPath}/fin/downloadExportExcel.do?filename='
								+ encodeURI(filename));
				}
			});
		}
	}*/
</script>