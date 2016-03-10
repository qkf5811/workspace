<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<form id="scrapRecordDetailsForm" method="post">
		<table cellpadding="7">

			<input id="id" name="id" type="hidden"
			value="<c:out value='${scrapRecordId}'/>" />
			
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
					<td>报废人员：</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="scrapUser" name="scrapUser"
						data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>报废日期：</td>
					<td>
						<input class="easyui-validatebox textbox" type="text"
							id="scrapDate" name="scrapDate"
							data-options="required:true,novalidate:true" readonly="readonly" style="width: 200px; height: 18px; padding: 5px"></input>
					</td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>报废记录:</td>
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
		getScrapRecord("#scrapRecordDetailsForm");
	});
	
	function getScrapRecord(form){
		var id=$(form).find("#id").val();
		$.post('scrapRecord/getScrapRecord.do',{
			"id":id
		},function(data){
			$(form).find("#itemCode").val(data.scrapRecord.itemCode); 
			$(form).find("#equName").val(data.scrapRecord.equName); 
			$(form).find("#equBrand").val(data.scrapRecord.equBrand); 
			$(form).find("#equModel").val(data.scrapRecord.equModel); 
			$(form).find("#scrapUser").val(data.scrapRecord.scrapUserName); 
			$(form).find("#scrapDate").val(data.scrapRecord.scrapRecordSTime);
			//$(form).find("#remark").val(data.scrapRecord.remark);
			var remark=(data.scrapRecord.remark);
			remark=remark.replace("\r\n","<br/>");
			$(form).find("#remark").textbox('setValue',remark);
		},"json")
	}
	
	
	function lookOk(){
		closeTab(getCurrentTab());
		$('#scrapRecordList').datagrid('reload');
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
