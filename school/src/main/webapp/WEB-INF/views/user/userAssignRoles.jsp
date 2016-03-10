<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="userRoleDialog"
	style="width: 750px; height: 420px; padding: 10px 20px;" closed="true"
	buttons="#userDialog-buttons">
	<!-- <div class="ftitle">人员</div> -->
	<form id="userRoleForm" method="post" novalidate>
		<input id="userId" name="userId" type="hidden" value="<c:out value='${userId}'/>" />
		<!-- <div class="fitem">
			<label>姓名:</label> <input id="name" name="name" disabled="true"　readOnly="true">
		</div> -->
		
		<div style="margin-bottom: 20px">
				<td>
				<span style="font-size: 13px">用户姓名:</span>
				</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" readOnly="true" data-options="novalidate:true,required:true,missingMessage:'该处未填写',validType:'length[3,20]',invalidMessage:'字数范围为3-20' "
					style="width: 140px; height: 18px; padding: 5px; font-size: 18px"/>
					
				</td>
				</div>
		
		<div class="fitem">
			<div class="easyui-panel" title="分配角色：" style="width:213px">
				<c:forEach items="${roleList}" var="role">
					<c:choose>
						<c:when test="${role.checked}">
							<input type="checkbox" name="roleCheckbox" value="${role.id}" checked>${role.name}</input><p>
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="roleCheckbox" value="${role.id}">${role.name}</input><p>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</div>
		</div>
	</form>
	<div id="userDialog-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="assignRoleToUser('#userRoleForm')">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="closeTab(getCurrentTab())">取消</a>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		getUser("#userRoleForm");
	});

	function getUser(form) {
		var id = $(form).find("#userId").val();
		$.post('user/getUser.do', {
			"id" : id
		}, function(data) {
			$(form).find("#account").val(data.user.account);
			$(form).find("#name").val(data.user.name);
		}, "json")
	}

	function assignRoleToUser(form) {
		var userId = $(form).find("#userId").val();

		var roleIds = "";
		var count = 0;
		var roleCheckBox=document.getElementsByName("roleCheckbox");
		
		for (var i = 0; i < roleCheckBox.length; i++) {
			if(roleCheckBox[i].checked){ //判断复选框是否选中
				if (count > 0) {
					roleIds += ",";
				} 
				roleIds += roleCheckBox[i].value; //值的拼凑 .. 具体处理看你的需要
				count++;
			}
		}
		
		$.post('user/updateUserRole.do', {
			"userId" : userId,
			"roleIds" : roleIds
		}, function(result) {
			$.messager.alert("操作提示", "分配角色成功！","info");
			$('#userList').datagrid('reload');
			closeTab(getCurrentTab());
		}, "json")
	}
</script>