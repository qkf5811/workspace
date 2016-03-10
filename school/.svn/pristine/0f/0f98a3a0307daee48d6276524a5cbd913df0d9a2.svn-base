<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="newApplicationForm" method="post">
		<table cellpadding="7">
			<tr style="diplay:none">
				<input id="userId" name="userId" type="hidden" value="<c:out value='${userId}'/>" />
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>申请类型:</td>
					<td><select class="easyui-combobox" id="applicationType"
						name="applicationType"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '110px',novalidate:true"
						validtype="selectRequired['applicationType']"
						style="width: 110px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${applicationTypeList}" var="applicationType">
							<option value="${applicationType.id}">${applicationType.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>
		</table>
	</form>
	
	
</div>


<script type="text/javascript">


</script>

<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>