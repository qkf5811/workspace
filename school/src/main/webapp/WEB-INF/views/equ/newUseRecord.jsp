<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newUseRecordForm" method="post">
		<table cellpadding="7">

			
			<tr>
			<div style="margin-bottom: 20px">
				<td>领用设备编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="itemId"
					name="itemId"
					data-options="required:true,validType:'length[1,11]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-11' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
		
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>领用者编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="useUserId"
					name="useUserId"
					data-options="required:true,validType:'length[1,11]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-11' " 
					style="width: 200px; height: 18px; padding: 5px"/>

				</td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>领用日期:</td>
				<td><input class="easyui-datetimebox textbox" 
					id="useDate" name="useDate"
					data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'" style="height: 33px; width: 200px"></input></td>
				</div>				
			</tr> 

			<tr>
				<div style="margin-bottom: 20px">
				<td>领用期限:</td>

				<td><input class="easyui-datetimebox textbox" type="text"
					id="useDealine" name="useDealine"
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
			onclick="addNewUseRecord('#newUseRecordForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>


<script type="text/javascript">
	function addNewUseRecord(form) {
		
		//在提交数据之前执行表单验证
		$('#newUseRecordForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
		
		
		var itemId = $(form).find("#itemId").val();
		/* var itemName = $(form).find("#itemName").val(); */
		var useUserId = $(form).find("#useUserId").val();		
		/* var name = $(form).find("#name").val();
		var email = $(form).find("#email").val();
		var mobile =$(form).find("#mobile").val();
		var address = $(form).find("#address").val(); */
		var useDateSTime=$(form).find("#useDate").datebox('getValue');
		var useDealineSTime=$(form).find("#useDealine").datebox('getValue');
		var remark = $(form).find("#remark").val();
		
		$.post('equ/addUseRecord.do', {
			
			"itemId" : itemId,
			/* "itemName" : itemName, */
			"useUserId":useUserId,
			/* "name" : name,
			"email" : email,
			"mobile" : mobile,
			"address" : address, */
			"useDateSTime" : useDateSTime,
			"useDealineSTime" : useDealineSTime,
			"remark" : remark
		}, function(data) {
			if(data.result>0){
			closeTab(getCurrentTab());
			$.messager.alert("操作提示", "添加领用记录成功！","info");
			$('#useRecordMood').datagrid('reload');
			}else if(data.result==0){
				$.messager.alert("操作提示","添加领用记录失败!","warning");
			}else if(data.result==-1){
				
				$.messager.alert("操作提示","输入的领用记录信息不完整!","warning");
			}else if(data.result==-2){
				
				$.messager.alert("操作提示","领用记录已存在!","warning");
			}
		}, "json")
	}
	
	function clearForm() {
		$('#newUseRecordForm').form('clear');
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