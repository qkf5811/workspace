<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div  style="width: 99%; height: auto">

	<div id="approveSettingForm" >
		<div style="margin:5px;">
		
			<span>申请类型:</span>
			<select id="applicationTypeOfApproveSetting" class="easyui-combobox"
					style="width: 150px"
					data-options="editable:false,panelWidth:'150px', panelHeight:'auto'">
				<option value="0">请选择</option>
				<c:forEach items="${applicationType }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>
			</select>
			&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
			   iconCls="icon-search"
			   onclick="findApproveSettingByApplicationType()"
			>查询</a>
		</div>
	</div>
	
	<!-- datagrid -->
	<!-- 	   url="${contextPath }/apv/findApproveSettingByApplicationType.do?applicationType=0" -->
	<table id="datagridOfApproveSetting" class="easyui-datagrid" pagination="true"
			  rownumbers="true" singleSelect="true" data-options="pageSize:10"
			  toolbar="#approveSettingToolbar"
			  url="${contextPath }/apv/findApproveSettingByApplicationType.do?applicationType=0"
			  style="padding: 5px;">
			
		<thead>
			<tr>
				<th field="applicationTypeStr" width="120px" align="center">申请类型</th>
				<th field="nodeName" width="120px" align="center">审批环节</th>
				<th field="roleIdStr" width="120px" align="center">审批角色</th>
				<th field="seqStr" width="120px" align="center">申请顺序</th>
				<th field="isLastStr" width="100px" align="center">是否最后环节</th>
				<th field="remark" width="120px" align="center">备注</th>
			</tr>
		</thead>
	</table>
	
	<div id="approveSettingToolbar">
		<a href="javascript:void(0)"  class="easyui-linkbutton" plain="true" iconCls="icon-add"
		   onclick="addApprovalNode()">添加</a>
		<a href="javascript:void(0)"  class="easyui-linkbutton" plain="true" iconCls="icon-edit"
		   onclick="editApprovalNode()">编辑</a>
		<a href="javascript:void(0)"  class="easyui-linkbutton" plain="true" iconCls="icon-remove"
		   onclick="deleteApprovalNode()"
		>删除</a>
	</div>
</div>

<script type="text/javascript">
	
	//查询
	function findApproveSettingByApplicationType() {
		
		var applicationType = $("#approveSettingForm").find("#applicationTypeOfApproveSetting").combobox('getValue');
	//	alert(applicationType);
		
		$("#datagridOfApproveSetting").datagrid({
			url: "${contextPath }/apv/findApproveSettingByApplicationType.do",
			queryParams : {
				applicationType : applicationType
			}
		});
	}
	
	//添加审批节点
	function addApprovalNode() {
		
		openTab("apv/addApprovalNode.do", "添加审批节点");
	}
	
	//编辑审批节点
	function editApprovalNode() {
		
		var row = $("#datagridOfApproveSetting").datagrid('getSelected');
		if (row == null)
			$.messager.alert("操作提示", "请先选择一个审批节点!", "warning");
		else
			openTab("apv/toEditApprovalNode.do?id=" + row.id, "编辑审批节点");
	}
	
	//删除审批节点
	function deleteApprovalNode() {
		
		var row = $("#datagridOfApproveSetting").datagrid('getSelected');
		if (row == null)
			$.messager.alert("操作提示", "请先选择一个审批节点!", "warning");
		else {
	//		alert(row.id);
			$.messager.confirm("请确认...", "确认删除该审批节点?", function(b) {
				
				if (b) {
					$.post("${contextPath}/apv/deleteApprovalNodeById.do",
							{
								id: row.id
							}, function (data) {
								data = eval('(' + data + ')');
								if (data.result == 1) {
									$.messager.alert("操作提示", "审批节点删除成功!!", "info");
									$("#datagridOfApproveSetting").datagrid('reload');
								} else {
									$.messager.alert("操作提示", "审批节点删除失败!<br>请稍后再尝试!", "warning");
								}
							})
				} else {
					;
				}
			});
			
		}
	}
</script>