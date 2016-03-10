<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="reformRecordEditForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${reformRecordId}'/>" />
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>设备编号：</td>
				<td><select class="easyui-combobox" id="itemCode" name="itemCode"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
					<option value="">请选择</option>
					<c:forEach items="${equipmentItems}" var="equipmentItem">
						<option value="${equipmentItem.id}">${equipmentItem.code}</option>
					</c:forEach>		
				</select></td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>改造人员：</td>
				<td><select class="easyui-combobox" id="reformUser" name="reformUser"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
					<option value="">请选择</option>
					<c:forEach items="${reformUsers}" var="reformUser">
				<option value="${reformUser.id}">${reformUser.name}</option>
			</c:forEach>
						
				</select></td>
				
			</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>改造日期：</td>
				<td>
					<input class="easyui-datetimebox" id="reformDate" name="reformDate" data-options="required:true" style="width:200px; height: 25px; padding: 5px"></input>
				</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>改造记录:</td>
				<td><input class="easyui-textbox" type="text" 
					id="remark" name="remark" 
					data-options="required:true,novalidate:true,multiline:true" style="width: 400px; height: 200px; padding: 5px"/></td>
				</div>
			</tr>
			


		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editReformRecord('#reformRecordEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>



<script type="text/javascript">
	$(function(){
		getReformRecord("#reformRecordEditForm");
	});
	
	function getReformRecord(form){
		var id=$(form).find("#id").val();
		$.post('reformRecord/getReformRecord.do',{
			"id":id
		},function(data){
			
			$(form).find("#itemCode").combobox('select',data.reformRecord.itemId); 
			$(form).find("#reformUser").combobox('select',data.reformRecord.reformUserId); 
			$(form).find("#reformDate").datebox('setValue',data.reformRecord.reformRecordSTime);
			//$(form).find("#remark").val(data.reformRecord.remark);
			var remark=(data.reformRecord.remark);
			remark=remark.replace("\r\n","<br/>");
			$(form).find("#remark").textbox('setValue',remark);
		},"json")
	}
	
	function editReformRecord(form) {
		var id = $(form).find("#id").val();
		var itemCode=$(form).find("#itemCode").combobox('getText');
		var itemId = $(form).find("#itemCode").combobox('getValue');
		var reformUserName=$(form).find("#reformUser").combobox('getText');
		var reformUserId=$(form).find("#reformUser").combobox('getValue');
		var reformRecordSTime=$(form).find("#reformDate").datebox('getValue');
		//var remark=$(form).find("#remark").val();
		var remark=$(form).find("#remark").textbox('getValue');
		
		$.post('reformRecord/editReformRecord.do', {
			"id":id,
			"itemId":itemId,
			"reformUserId":reformUserId,
			"itemCode" : itemCode,
			"reformUserName" : reformUserName,
			"reformRecordSTime" : reformRecordSTime,
			"remark" : remark,
		}, function(result) {
			closeTab(getCurrentTab());
			$('#reformRecordList').datagrid('reload');
		}, "json")
	}
	
	function clearForm() {
		$('#reformRecordEditForm').form('clear');
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
