<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="scrapRecordEditForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${scrapRecordId}'/>" />
			
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
				<td>报废人员：</td>
				<td><select class="easyui-combobox" id="scrapUser" name="scrapUser"
					data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
					<option value="">请选择</option>
					<c:forEach items="${scrapUsers}" var="scrapUser">
				<option value="${scrapUser.id}">${scrapUser.name}</option>
			</c:forEach>
						
				</select></td>
				
			</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>报废日期：</td>
				<td>
					<input class="easyui-datetimebox" id="scrapDate" name="scrapDate" data-options="required:true" style="width:200px; height: 25px; padding: 5px"></input>
				</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>报废记录:</td>
				<td><input class="easyui-textbox" type="text" 
					id="remark" name="remark" 
					data-options="required:true,novalidate:true,multiline:true" style="width: 400px; height: 200px; padding: 5px"/></td>
				</div>
			</tr>
			


		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editScrapRecord('#scrapRecordEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>



<script type="text/javascript">
	$(function(){
		getScrapRecord("#scrapRecordEditForm");
	});
	
	function getScrapRecord(form){
		var id=$(form).find("#id").val();
		$.post('scrapRecord/getScrapRecord.do',{
			"id":id
		},function(data){
			
			$(form).find("#itemCode").combobox('select',data.scrapRecord.itemId); 
			$(form).find("#scrapUser").combobox('select',data.scrapRecord.scrapUserId); 
			$(form).find("#scrapDate").datebox('setValue',data.scrapRecord.scrapRecordSTime);
			//$(form).find("#remark").val(data.scrapRecord.remark);
			var remark=(data.scrapRecord.remark);
			remark=remark.replace("\r\n","<br/>");
			$(form).find("#remark").textbox('setValue',remark);
		},"json")
	}
	
	function editScrapRecord(form) {
		var id = $(form).find("#id").val();
		var itemCode=$(form).find("#itemCode").combobox('getText');
		var itemId = $(form).find("#itemCode").combobox('getValue');
		var scrapUserName=$(form).find("#scrapUser").combobox('getText');
		var scrapUserId=$(form).find("#scrapUser").combobox('getValue');
		var scrapRecordSTime=$(form).find("#scrapDate").datebox('getValue');
		//var remark=$(form).find("#remark").val();
		var remark=$(form).find("#remark").textbox('getValue');
		
		$.post('scrapRecord/editScrapRecord.do', {
			"id":id,
			"itemId":itemId,
			"scrapUserId":scrapUserId,
			"itemCode" : itemCode,
			"scrapUserName" : scrapUserName,
			"scrapRecordSTime" : scrapRecordSTime,
			"remark" : remark,
		}, function(result) {
			closeTab(getCurrentTab());
			$('#scrapRecordList').datagrid('reload');
		}, "json")
	}
	
	function clearForm() {
		$('#scrapRecordEditForm').form('clear');
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
