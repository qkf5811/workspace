<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<form id="editApprovalNodeForm" style="margin-left:10%;margin-top: 25px">
		<div style="display:none">
			<input id="apvNodeId" value="${id }">
		</div>
		<table cellpadding="7">
			
			<tr>
					<td>申请类型:</td>
					<td><select class="easyui-combobox" id="applicationTypeOfEditApvNode"
						name="applicationTypeOfEditApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['applicationTypeOfEditApvNode']"
						style="width: 120px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationType}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td>
				
			</tr>
			
			<tr>
				<td>审批环节:</td>
				<td><input class="easyui-validatebox textbox" type="text"
						id="nodeNameOfEditApvNode" name="nodeNameOfEditApvNode"
						data-options="required:true,novalidate:true,missingMessage:'该处未填写',novalidate:true"
						style="width: 120px; height: 20px; padding: 5px"></input></td>
			</tr>
			
			<tr>
				
					<td>审批角色:</td>
					<td><select class="easyui-combobox" id="roleIdOfEditApvNode"
						name="roleIdOfEditApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['roleIdOfEditApvNode']"
						style="width: 120px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${roleList}" var="item">
							<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td>
				
			</tr>
			
			<tr>
			
					<td>申请顺序:</td>
					<td><select class="easyui-combobox" id="seqOfEditApvNode"
						name="seqOfEditApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['seqOfEditApvNode']"
						style="width: 120px; height: 33px; padding: 5px">
						<option value="1">步骤1</option>
						<option value="2">步骤2</option>
						<option value="3">步骤3</option>
						<option value="4">步骤4</option>
						<option value="5">步骤5</option>
						<option value="6">步骤6</option>
						<option value="7">步骤7</option>
						<option value="8">步骤8</option>
					</select></td>
			
			</tr>
			
			<tr hidden="true">
				
					<td style="vertical-align:middle">最后环节:</td>
					<td  style="vertical-align:middle">
						<input type="radio" name="islastOfNewApvNode" value="true" id="yesOfEditApvNode" style="vertical-align:middle">是
						<input type="radio" name="islastOfNewApvNode" value="false" id="noOfEditApvNode" style="vertical-align:middle">否</td>
				
			</tr>
			
			<tr>
			
					<td>备注:</td>
					<td><textArea class="textarea" id="remarkOfEditApvNode" name="remarkOfEditApvNode" rows="3"
						cols="60"></textArea></td>
				
			</tr>
		</table>
		
		<div style="margin-left: 45%;margin-top:25px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="editNewApprovalNode('#editApprovalNodeForm')">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeEditApprovalNodeTab()">关闭</a>
		</div>
	</form>
</div>

<script type="text/javascript">
	
	$(function() {

		$.post('${contextPath}/apv/getApvNodeInfoById.do',
			{
				id: $("#editApprovalNodeForm").find("#apvNodeId").val()
			}, function (data) {
				
				data = eval('(' + data + ')');
		//		console.log(data);
				$("#editApprovalNodeForm").find("#applicationTypeOfEditApvNode").combobox("setValue", data.applicationType);
				$("#editApprovalNodeForm").find("#nodeNameOfEditApvNode").val(data.nodeName);
				$("#editApprovalNodeForm").find("#roleIdOfEditApvNode").combobox("setValue", data.roleId);
				$("#editApprovalNodeForm").find("#seqOfEditApvNode").combobox("setValue", data.seq);
				if (data.isLast == 2001)
					$("#editApprovalNodeForm").find('#yesOfEditApvNode').attr("checked", "true");
				else 
					$("#editApprovalNodeForm").find('#noOfEditApvNode').attr("checked", "true");
				$("#editApprovalNodeForm").find("#remarkOfEditApvNode").val(data.remark);
			})
		
	})
	
	//修改
	function editNewApprovalNode(form) {
		
		//参数
    	var param = {
				id : $(form).find("#apvNodeId").val(),
    			applicationType : $(form).find("#applicationTypeOfEditApvNode").combobox('getValue'),
    			nodeName : $(form).find('#nodeNameOfEditApvNode').val(),
    			roleId : $(form).find("#roleIdOfEditApvNode").combobox('getValue'),
    			seq : $(form).find('#seqOfEditApvNode').combobox('getValue'),
    			isLastStr : $(form).find('input[type="radio"]:checked').val()=="true" ? "是":"否",
    			remark : $(form).find('#remarkOfEditApvNode').val()
    	};
		console.log(param);
		
		$.post("${contextPath}/apv/editApprovalNode.do",
			param,
			function (data) {

				data = eval('(' + data + ')');
			//	alert(data);
				
				if (data.result == 0) {
					$.messager.alert("操作信息", "审批节点修改失败!<br/>请稍后再尝试!", "warning");
				} else if (data.result == 1) {
					$.messager.alert("操作信息", "审批节点修改成功!", "info");
					$("#datagridOfApproveSetting").datagrid('reload');
				}
		});
	}
	
	//关闭
	function closeEditApprovalNodeTab() {
		var tab = getCurrentTab();
		closeTab(tab);
	}
</script>