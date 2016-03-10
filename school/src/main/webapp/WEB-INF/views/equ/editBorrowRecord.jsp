<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="borrowRecordEditForm" method="post">
		<table cellpadding="7">

			<%-- <input id="id" name="id" type="hidden"
			value="<c:out value='${borrowRecordId}'/>" /> --%>
			<tr>
			<div style="margin-bottom: 20px">
				<td>借用设备编号:</td>
				<td><input class="easyui-validatebox textbox" type="text" id="itemId"
					name="itemId" value="<c:out value='${itemId}'/>"
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
	<!-- 	<div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="10"
				cols="100"></textArea>
		</div> -->
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editBorrowRecord('#borrowRecordEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>

<script type="text/javascript">

	$(function(){
		getBorrowRecord("#borrowRecordEditForm");
	});
	
	function getBorrowRecord(form){
		var id=$(form).find("#itemId").val();
		$.post('equ/getBorrowRecord.do',{
			"id":id
		},function(data){
			$(form).find("#itemId").val(data.brDto.itemId);
		/* 	$(form).find("#itemName").val(data.brDto.itemName); */
			$(form).find("#borrowUserId").val(data.brDto.borrowUserId);		
			/* $(form).find("#name").val(data.brDto.name);
			$(form).find("#email").val(data.brDto.email);
			$(form).find("#mobile").val(data.brDto.mobile);
			$(form).find("#address").val(data.brDto.address); */
			$(form).find("#borrowDate").datebox('setText',data.brDto.borrowDateSTime);
			$(form).find("#borrowDealine").datebox('setText',data.brDto.borrowDealineSTime);
			$(form).find("#remark").val(data.brDto.remark);
			
		},"json")
	}
	function editBorrowRecord(form) {
		//在提交数据之前执行表单验证
		$('#borrowRecordEditForm').form('enableValidation').form('validate');
		
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
		var borrowDateSTime = $(form).find("#borrowDate").datebox('getText');
		var borrowDealineSTime = $(form).find("#borrowDealine").datebox('getText');
		var remark = $(form).find("#remark").val();

		$.post('equ/editBorrowRecord.do', {
		
			"itemId" : itemId,
			/* "itemName" : itemName, */
			"borrowUserId":borrowUserId,
		/* 	"name" : name,
			"email" : email,
			"mobile" : mobile,
			"address" : address, */
			"borrowDateSTime" : borrowDateSTime,
			"borrowDealineSTime" : borrowDealineSTime,
			"remark" : remark
		}, function(result) {
			closeTab(getCurrentTab());
			$('#borrowRecordMood').datagrid('reload');
		}, "json")
	}
	
	function clearForm() {
		$('#borrowRecordEditForm').form('clear');
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
