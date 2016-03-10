<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newBorrowRecordForm" method="post">
		<table cellpadding="7">

			<tr>
			<div style="margin-bottom: 20px">
				<td>借用设备编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="itemId"
					name="itemId"
					data-options="required:true,validType:'length[1,11]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-11' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
		
			<tr>
			<div style="margin-bottom: 20px">
				<td>借用者编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="borrowUserId"
					name="borrowUserId"
					data-options="required:true,validType:'length[1,11]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-11' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			
			 <tr>
				<div style="margin-bottom: 20px">
				<td>借用日期:</td>
				<td><input class="easyui-datetimebox textbox" 
					id="borrowDate" name="borrowDate"
					data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'" style="height: 33px; width: 200px"></input></td>
				</div>				
			</tr> 
		
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>借用期限:</td>

				<td><input class="easyui-datetimebox textbox" type="text"
					id="borrowDealine" name="borrowDealine"
					data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'" style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="remark" name="remark"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
		
			
		</table>
		<!-- <div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="10"
				cols="100"></textArea>
		</div> -->
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addNewBorrowRecord('#newBorrowRecordForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>

<script src='js/My97DatePicker/WdatePicker.js'></script>
<script type="text/javascript">
	function addNewBorrowRecord(form) {
		
		//在提交数据之前执行表单验证
		$('#newBorrowRecordForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}  
		
		
		var itemId = $(form).find("#itemId").val();
		/* var itemName = $(form).find("#itemName").val(); */
		var borrowUserId = $(form).find("#borrowUserId").val();		
		/* var name = $(form).find("#name").val();
		var email = $(form).find("#email").val();
		var mobile =$(form).find("#mobile").val();
		var address = $(form).find("#address").val(); */
		var borrowDateSTime=$(form).find("#borrowDate").datebox('getValue');
		var borrowDealineSTime=$(form).find("#borrowDealine").datebox('getValue');
		var remark = $(form).find("#remark").val();
		
		$.post('equ/addBorrowRecord.do', {
			
			"itemId" : itemId,
			/* "itemName" : itemName, */
			"borrowUserId":borrowUserId,
			/* "name" : name,
			"email" : email,
			"mobile" : mobile,
			"address" : address, */
			"borrowDateSTime" : borrowDateSTime,
			"borrowDealineSTime" : borrowDealineSTime,
			"remark" : remark
		}, function(data) {
			if(data.result>0){
			closeTab(getCurrentTab());
			$.messager.alert("操作提示", "添加借用记录成功！","info");
			$('#borrowRecordMood').datagrid('reload');
			}else if(data.result==0){
				$.messager.alert("操作提示","添加借用记录失败!","warning");
			}else if(data.result==-1){
				
				$.messager.alert("操作提示","输入的借用记录信息不完整!","warning");
			}else if(data.result==-2){
				
				$.messager.alert("操作提示","借用记录已存在!","warning");
			}
		}, "json")
	}
	
	function clearForm() {
		$('#newBorrowRecordForm').form('clear');
	}
</script>

<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>