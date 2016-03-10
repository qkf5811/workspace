<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="useRecordEditForm" method="post">
		<table cellpadding="7">

			<%-- <input id="id" name="id" type="hidden"
			value="<c:out value='${useRecordId}'/>" /> --%>
			<tr>
			<div style="margin-bottom: 20px">
				<td>领用设备编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="itemId"
					name="itemId" value="<c:out value='${itemId}'/>"
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
			onclick="editUseRecord('#useRecordEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>

<script type="text/javascript">

	$(function(){
		getUseRecord("#useRecordEditForm");
	});
	
	function getUseRecord(form){
		var id=$(form).find("#itemId").val();
		$.post('equ/getUseRecord.do',{
			"id":id
		},function(data){
			$(form).find("#itemId").val(data.urDto.itemId);
			/* $(form).find("#itemName").val(data.urDto.itemName); */
			$(form).find("#useUserId").val(data.urDto.useUserId);		
			/* $(form).find("#name").val(data.urDto.name);
			$(form).find("#email").val(data.urDto.email);
			$(form).find("#mobile").val(data.urDto.mobile); */
			$(form).find("#useDate").datebox('setText',data.urDto.useDateSTime);
			$(form).find("#useDealine").datebox('setText',data.urDto.useDealineSTime);
			/* $(form).find("#address").val(data.urDto.address); */
			$(form).find("#remark").val(data.urDto.remark);
			
		},"json")
	}
	function editUseRecord(form) {
		//在提交数据之前执行表单验证
		$('#useRecordEditForm').form('enableValidation').form('validate');
		
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
		var useDateSTime=$(form).find("#useDate").datebox('getText');
		var useDealineSTime=$(form).find("#useDealine").datebox('getText');
		var remark = $(form).find("#remark").val();

		$.post('equ/editUseRecord.do', {
			
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
		}, function(result) {
			closeTab(getCurrentTab());
			$('#useRecordMood').datagrid('reload');
		}, "json")
	}
	
	function clearForm() {
		$('#useRecordEditForm').form('clear');
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
