<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="reformRecordDetailsForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${reformRecordId}'/>" />
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备编号：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="itemCode" name="itemCode"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备名称：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="equName" name="equName"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备品牌：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="equBrand" name="equBrand"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备型号：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="equModel" name="equModel"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>改造人员：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="reformUser" name="reformUser"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>改造日期：</td>
					<td>
						<input class="easyui-validatebox textbox" type="text"
							id="reformDate" name="reformDate"
							data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>改造记录:</td>
					<td><input class="easyui-textbox" type="text"
						id="remark" name="remark"
						data-options="required:true,novalidate:true,multiline:true" readonly="readonly" style="width: 400px; height: 200px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			


		</table>
	</form>

	<div style="text-align: center; padding: 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="lookOk()">关闭</a>
	</div>

</div>



<script type="text/javascript">
	$(function(){
		getReformRecord("#reformRecordDetailsForm");
	});
	
	function getReformRecord(form){
		var id=$(form).find("#id").val();
		$.post('reformRecord/getReformRecord.do',{
			"id":id
		},function(data){
			$(form).find("#itemCode").val(data.reformRecord.itemCode); 
			$(form).find("#equName").val(data.reformRecord.equName); 
			$(form).find("#equBrand").val(data.reformRecord.equBrand); 
			$(form).find("#equModel").val(data.reformRecord.equModel); 
			$(form).find("#reformUser").val(data.reformRecord.reformUserName); 
			$(form).find("#reformDate").val(data.reformRecord.reformRecordSTime);
			//$(form).find("#remark").val(data.reformRecord.remark);
			var remark=(data.reformRecord.remark);
			remark=remark.replace("\r\n","<br/>");
			$(form).find("#remark").textbox('setValue',remark);
		},"json")
	}
	
	
	function lookOk(){
		closeTab(getCurrentTab());
		$('#reformRecordList').datagrid('reload');
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
