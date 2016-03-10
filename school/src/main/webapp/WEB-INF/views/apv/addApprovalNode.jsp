<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">
	<form id="newApprovalNodeForm" method="post" style="margin-left:10%;margin-top: 25px">
		<table cellpadding="7">
			
			<tr>
				
					<td>申请类型:</td>
					<td><select class="easyui-combobox" id="applicationTypeOfNewApvNode"
						name="applicationTypeOfNewApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['applicationTypeOfNewApvNode']"
						style="width: 120px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationType}" var="item">
							<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td>
				
			</tr>
			
			<tr>
		<!--		<div style="margin-left: 10px; margin-bottom: -15px">
					<label style="margin-right: 10px"> </label> 
					<input id="nodeNameOfNewApvNode" name="nodeNameOfNewApvNode" class="easyui-textbox textbox"
						data-options="buttonText:'选择',buttonIcon:'icon-search',editable:false,required:true,novalidate:true,missingMessage:'该处未填写'"
						style="width: 200px; height: 33px; padding: 5px">
				</div>  -->
				<td>审批环节:</td>
				<td><input class="easyui-validatebox textbox" type="text"
						id="nodeNameOfNewApvNode" name="nodeNameOfNewApvNode"
						data-options="required:true,novalidate:true,missingMessage:'该处未填写',novalidate:true"
						style="width: 120px; height: 20px; padding: 5px"></input></td>
			</tr>
			
			<tr>
				
					<td>审批角色:</td>
					<td><select class="easyui-combobox" id="roleIdOfNewApvNode"
						name="roleIdOfNewApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['roleIdOfNewApvNode']"
						style="width: 120px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${roleList}" var="item">
							<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td>
				
			</tr>
			
			<tr>
			
					<td>申请顺序:</td>
					<td><select class="easyui-combobox" id="seqOfNewApvNode"
						name="seqOfNewApvNode"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '120px',novalidate:true"
						validtype="selectRequired['seqOfNewApvNode']"
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
						<input type="radio" name="islastOfNewApvNode" value="true" id="yesOfNewApvNode" style="vertical-align:middle">是
						<input type="radio" name="islastOfNewApvNode" value="false" id="noOfNewApvNode" style="vertical-align:middle">否</td>
				
			</tr>
			
			<tr>
			
					<td>备注:</td>
					<td><textArea class="textarea" id="remarkOfNewApvNode" name="remarkOfNewApvNode" rows="3"
						cols="60"></textArea></td>
				
			</tr>
		</table>
		
		<div style="margin-left: 45%;margin-top:25px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addNewApprovalNode('#newApprovalNodeForm')">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="resetNewApprovalNode('#newApprovalNodeForm')">重置</a>
		</div>
	</form>
</div>

<script type="text/javascript">
	
	$(function(){
		$("#newApprovalNodeForm").find("#noOfNewApvNode").attr("checked", "true");
	})
	
	//添加
	function addNewApprovalNode(form) {
		
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
    	
    	//参数
    	var param = {
    			applicationType : $(form).find("#applicationTypeOfNewApvNode").combobox('getValue'),
    			nodeName : $(form).find('#nodeNameOfNewApvNode').val(),
    			roleId : $(form).find("#roleIdOfNewApvNode").combobox('getValue'),
    			seq : $(form).find('#seqOfNewApvNode').combobox('getValue'),
    			isLastStr : $(form).find('input[type="radio"]:checked').val()=="true" ? "是":"否",
    			remark : $(form).find('#remarkOfNewApvNode').val()
    	};
    //	console.log(param);
    	$.post('${contextPath}/apv/addNewApprovalNode.do',
    			param,
    			function(data) {
    			
    				data = eval('(' + data + ')');
    				if (data == 1) {
    					$.messager.alert("操作信息", "审批节点添加成功!", "info");
    					$("#datagridOfApproveSetting").datagrid('reload');
    				} else if (-1) {
    					$.messager.alert("操作信息", "审批节点添加失败!<br>请稍后再尝试!", "info");
    				}
    	});
	}
	
	//重置
	function resetNewApprovalNode(form) {
		
		$(form).find('#applicationTypeOfNewApvNode').combobox('setValue', 0);
		$(form).find('#nodeNameOfNewApvNode').val("")
		$(form).find('#roleIdOfNewApvNode').combobox('setValue', 0);
	//	$(form).find("#noOfNewApvNode").attr("checked", "true");
		$(form).find('#seqOfNewApvNode').combobox('setValue', 1);
		$(form).find('#remarkOfNewApvNode').val("")
	}
</script>