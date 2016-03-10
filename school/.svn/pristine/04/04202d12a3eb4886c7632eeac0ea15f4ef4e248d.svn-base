<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="newRoomApplicationForm" method="post">
		<input type="hidden" id="status" name="status" value="42001">
		<table cellpadding="7">

			<tr>
				<div style="margin-bottom: 20px">
					<td>申请名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="appName" name="name"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' "
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>功能室:</td>
					<td><select class="easyui-combobox" id="functionRoomId"
						name="functionRoomId"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['functionRoomId']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${functionRoomList}" var="obj">
								<option value="${obj.id}">${obj.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>


			<!-- <tr>
				<div style="margin-bottom: 20px">
					<td>当前节点:</td>
					<td><select class="easyui-combobox" id="nodeId"
						name="nodeId"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['nodeId']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<option value="1">节点1</option>
					</select></td>
				</div>
			</tr> -->

			<tr>
				<div style="margin-bottom: 20px">
					<td>申请原因:</td>
					<td><input class="easyui-validatebox textbox" type="text"
						id="reason" name="reason"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' "
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>


			<tr>
				<div style="margin-bottom: 20px">
					<td>使用开始时间:</td>
					<td><input class="easyui-datetimebox textbox" type="text"
						id="useFromDate" name="useFromDateStr"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>使用结束时间:</td>

					<td><input class="easyui-datetimebox textbox" type="text"
						id="useToDate" name="useToDateStr"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>备注:</td>

					<td>
					<input class="easyui-textbox" data-options="multiline:true" 
					style="width:500px;height:60px" id="remark" name="remark">
					
					</td>
				</div>
			</tr>

		</table>
	</form>

	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addRoomApplication('#newRoomApplicationForm',1)">保存为草稿</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="addRoomApplication('#newRoomApplicationForm',2)">提交申请</a>
	</div>

</div>

<script type="text/javascript">
	

	function addRoomApplication(form,status) {
		//在提交数据之前执行表单验证
		$('#newRoomApplicationForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
		if(status == 2) {
			$("#status").val("42002");
		}
		$.post('equ/addRoomApplication.do', $(form).serialize(), function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加申请成功！", "info");
				$('#roomApplicationList').datagrid('reload');

			} else if (data.result == 0) {
				$.messager.alert("操作提示", "添加申请失败!", "warning");
			} else if (data.result == -1) {

				$.messager.alert("操作提示", "输入的申请信息不完整!", "warning");
			} else if (data.result == -2) {
				$.messager.alert("操作提示", "申请已存在!", "warning");
			}
		}, "json");
	}

</script>