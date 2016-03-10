<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="roleAuthDialog"
	style="width: 750px; height: 420px; padding: 10px 20px;" closed="true"
	buttons="#userDialog-buttons">
	<form id="roleAuthForm" method="post" novalidate>
		<input id="roleId" name="roleId" type="hidden" value="<c:out value='${roleId}'/>" />
		<!-- <div class="fitem">
			<label>角色名:</label> <input id="roleName" name="roleName" disabled="true"　readOnly="true">
		</div> -->
		<div style="margin-bottom: 20px">
				<td>
				<span style="font-size: 13px">角色名:</span>
				</td>
				<td><input class="easyui-validatebox textbox" id="roleName"
					name="roleName" readOnly="true" data-options="novalidate:true,required:true,missingMessage:'该处未填写',validType:'length[3,20]',invalidMessage:'字数范围为3-20' "
					style="width: 140px; height: 18px; padding: 5px; font-size: 18px"/>
					
				</td>
				</div>
		<div class="fitem">
			<div class="easyui-panel" title="分配权限:" style="width:200px">
				<c:forEach items="${authorityList}" var="auth">
					<c:choose>
						<c:when test="${auth.checked}">
							<input type="checkbox" name="authCheckbox" value="${auth.id}" checked>${auth.name}</input><p>
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="authCheckbox" value="${auth.id}">${auth.name}</input><p>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</div>
		</div>
	</form>
	<div id="roleDialog-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="assignAuthorityToRole('#roleAuthForm')">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="closeTab(getCurrentTab())">取消</a>
	</div>
</div>
<script type="text/javascript">
	 $(function() {
		getRole("#roleAuthForm");
	});

	function getRole(form) {
		var id = $(form).find("#roleId").val();
		$.post('role/getRole.do', {
			"roleId" : id
		}, function(data) {
			
			$(form).find("#roleName").val(data.role.name);
		}, "json")
	} 

	function assignAuthorityToRole(form) {
		var roleId = $(form).find("#roleId").val();

		var authIds = "";
		var count = 0;
		var authCheckBox=document.getElementsByName("authCheckbox");
		
		for (var i = 0; i < authCheckBox.length; i++) {
			if(authCheckBox[i].checked){ //判断复选框是否选中
				if (count > 0) {
					authIds += ",";
				} 
				authIds += authCheckBox[i].value; //值的拼凑 .. 具体处理看你的需要
				count++;
			}
		}

		$.post('role/updateRoleAuthority.do', {
			"roleId" : roleId,
			"authorityIds" : authIds
		}, function(result) {
			$.messager.alert("操作提示", "分配权限成功！","info");
			closeTab(getCurrentTab());
		}, "json")
	}
</script>
