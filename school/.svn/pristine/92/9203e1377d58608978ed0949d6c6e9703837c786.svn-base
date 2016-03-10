<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="maintainRecordEditForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${maintainRecordId}'/>" />
			
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
					<td>设备名称:</td>
					<td><input class="easyui-validatebox textbox" id="equName"
						name="equName"
						data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " 
						style="width: 200px; height: 25px; padding: 5px"/>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备品牌:</td>
					<td><input class="easyui-validatebox textbox" id="equBrand"
						name="equBrand"
						data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " 
						style="width: 200px; height: 25px; padding: 5px"/>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备型号:</td>
					<td><input class="easyui-validatebox textbox" id="equModel"
						name="equModel"
						data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' " 
						style="width: 200px; height: 25px; padding: 5px"/>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>维护人员：</td>
					<td><select class="easyui-combobox" id="maintainUser" name="maintainUser"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '90px'" style="height:30px;width: 100px">
						<option value="">请选择</option>
						<c:forEach items="${maintainUsers}" var="maintainUser">
							<option value="${maintainUser.id}">${maintainUser.name}</option>
						</c:forEach>			
					</select></td>
				</div>
			</tr>
			
			<tr>
			<div style="margin-bottom: 20px">
				<td>维护日期：</td>
				<td>
					<input class="easyui-datetimebox" id="maintainDate" name="maintainDate" data-options="required:true" style="width:200px; height: 25px; padding: 5px"></input>
				</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
				<td>维护记录:</td>
				<td><input class="easyui-textbox" type="text" 
					id="remark" name="remark" 
					data-options="required:true,novalidate:true,multiline:true" style="width: 400px; height: 200px; padding: 5px"/></td>
				</div>
			</tr>
			


		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="editMaintainRecord('#maintainRecordEditForm')">提交</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="clearForm()">重置</a>
	</div>

</div>



<script type="text/javascript">
	$(function(){
		getMaintainRecord("#maintainRecordEditForm");
	});
	
	function getMaintainRecord(form){
		var id=$(form).find("#id").val();
		$.post('maintainRecord/getMaintainRecord.do',{
			"id":id
		},function(data){
			
			$(form).find("#itemCode").combobox('select',data.maintainRecord.itemId); 
			$(form).find("#maintainUser").combobox('select',data.maintainRecord.maintainUserId); 
			$(form).find("#equName").val(data.maintainRecord.equName);
			$(form).find("#equBrand").val(data.maintainRecord.equBrand);
			$(form).find("#equModel").val(data.maintainRecord.equModel);
			alert(data.maintainRecord.maintainRecordSTime);
			$(form).find("#maintainDate").datebox('setText',data.maintainRecord.maintainRecordSTime);
			//$(form).find("#remark").val(data.maintainRecord.remark);
			var remark=(data.maintainRecord.remark);
			remark=remark.replace("\r\n","<br/>");
			$(form).find("#remark").textbox('setValue',remark);
			
		},"json")
	}
	
	function editMaintainRecord(form) {
		var id = $(form).find("#id").val();
		//var itemId=$(".textbox-value")[0].value;
		//alert(typeof itemId);
		//var maintainUserId=$(".textbox-value")[1].value;
		var itemCode=$(form).find("#itemCode").combobox('getText');
		var itemId = $(form).find("#itemCode").combobox('getValue');
		var equName=$(form).find("#equName").val();
		var equBrand=$(form).find("#equBrand").val();
		var equModel=$(form).find("#equModel").val();
		//alert(equName);
		var maintainUserName=$(form).find("#maintainUser").combobox('getText');
		var maintainUserId=$(form).find("#maintainUser").combobox('getValue');
		var maintainRecordSTime=$(form).find("#maintainDate").datebox('getText');
		alert(maintainRecordSTime);
		var remark=$(form).find("#remark").textbox('getValue');

		$.post('maintainRecord/editMaintainRecord.do', {
			"id":id,
			"itemId":itemId,
			"equName":equName,
			"equBrand":equBrand,
			"equModel":equModel,
			"maintainUserId":maintainUserId,
			"itemCode" : itemCode,
			"maintainUserName" : maintainUserName,
			"maintainRecordSTime" : maintainRecordSTime,
			"remark" : remark,
		}, function(result) {
			closeTab(getCurrentTab());
			$('#maintainRecordList').datagrid('reload');
		}, "json")
	}
	
	function clearForm() {
		$('#maintainRecordEditForm').form('clear');
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
