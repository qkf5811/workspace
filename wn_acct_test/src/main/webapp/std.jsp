<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="margin: auto auto">

	<fieldset>
		<legend>商户查询服务</legend>
		<form id="queryMerchantForm">
			<input name="isEdit" value="false" hidden="true"> <input
				name="actionId" value="010101" hidden="true"> <span>商户ID(可选):</span>
			<input class="easyui-textbox" name="pkid"> <span>有效状态:</span>
			<select class="easyui-combobox" name="valid" editable="false"
				width="" panelHeight="auto" style="width: 100px">
				<option value="">全部</option>
				<option value="1">仅有效</option>
				<option value="2">仅停用</option>
			</select> <span>当前页:</span><input class="easyui-textbox" name="currentPage">
			<span>每页记录数:</span><input class="easyui-textbox" name="pageSize">
			<a class="easyui-linkbutton" iconCls="icon-search"
				onclick="javascript:goTest('#queryMerchantForm')">测试</a>
		</form>
	</fieldset>

	<fieldset>
		<legend>商户修改保存服务</legend>
		<form id="saveMerchantForm">
			<input name="isEdit" value="true" hidden="true"> <input
				name="actionId" value="010102" hidden="true"> <span>商户id(新增是为空，修改时必填):</span>
			<input class="easyui-textbox" name="pkid">
			<hr>
			<span>编码:</span> <input class="easyui-textbox" name="code"> <span>名称:</span>
			<input class="easyui-textbox" name="name"> <span>联系人:</span>
			<input class="easyui-textbox" name="contactPerson"> <span>联系电话:</span>
			<input class="easyui-textbox" name="contactPhone"> <span>地址:</span>
			<input class="easyui-textbox" name="address"> <span>邮编:</span>
			<input class="easyui-textbox" name="postCode"> <span>工商等级号:</span>
			<input class="easyui-textbox" name="registrationCertif"> <span>商户类型:</span>
			<select class="easyui-combobox" name="merchantType" editable="false"
				panelHeight="auto" style="width: 100px">
				<option value="1">正常</option>
				<option value="2">停用</option>
			</select> <a class="easyui-linkbutton" iconCls="icon-edit"
				onclick="javascript:goTest('#saveMerchantForm')">测试</a>
		</form>
	</fieldset>

	<fieldset>
		<legend>商户部门查询服务</legend>
		<form id="queryDepartmentForm">
			<input name="isEdit" value="false" hidden="true"> <input
				name="actionId" value="010103" hidden="true"> <span>商户ID(可选):</span>
			<input class="easyui-textbox" name="pkid"> <span>有效状态:</span>
			<select class="easyui-combobox" name="valid" editable="false"
				panelHeight="auto" style="width: 100px">
				<option value="">全部</option>
				<option value="1">仅有效</option>
				<option value="2">仅停用</option>
			</select> <span>当前页:</span><input class="easyui-textbox" name="currentPage">
			<span>每页记录数:</span><input class="easyui-textbox" name="pageSize">
			<a class="easyui-linkbutton" iconCls="icon-search"
				onclick="javascript:goTest('#queryDepartmentForm')">测试</a>
		</form>
	</fieldset>

	<fieldset>
		<legend>商户部门修改保存服务</legend>
		<form id="saveDepartmentForm">
			<input name="isEdit" value="true" hidden="true"> <input
				name="actionId" value="010104" hidden="true"> <span>商户id(必填):</span>
			<input class="easyui-textbox" name="merchantPkid">
			<hr>
			<span>编码(必填):</span> <input class="easyui-textbox" name="code">
			<span>名称(必填):</span> <input class="easyui-textbox" name="name">
			<span>有效状态(必填):</span> <select class="easyui-combobox" name="valid"
				panelHeight="auto" style="width: 100px" editable="false">
				<option value="1">正常</option>
				<option value="2">停用</option>
			</select> <span>上级部门id(必填):</span> <input class="easyui-textbox"
				name="parentPKID"> <a class="easyui-linkbutton"
				iconCls="icon-edit"
				onclick="javascript:goTest('#saveDepartmentForm')">测试</a>
		</form>
	</fieldset>

	<fieldset>
		<legend>职员查询服务</legend>
		<form id="queryEmployeesForm">
			<input name="isEdit" value="false" hidden="true"> <input
				name="actionId" value="010105" hidden="true"> <span>商户ID:</span>
			<input class="easyui-textbox" name="merchantPkid"> <span>部门ID:</span>
			<input class="easyui-textbox" name="departmentId"> <span>当前页:</span><input
				class="easyui-textbox" name="currentPage"> <span>每页记录数:</span><input
				class="easyui-textbox" name="pageSize"> <a
				class="easyui-linkbutton" iconCls="icon-search"
				onclick="javascript:goTest('#queryEmployeesForm')">测试</a>
		</form>
	</fieldset>

	<fieldset>
		<legend>职员修改保存服务(全部必填)</legend>
		<form id="saveEmployeesForm">
			<input name="isEdit" value="true" hidden="true">
			<input name="actionId" value="010106" hidden="true"> <span>商户ID:</span>
			<input class="easyui-textbox" name="merchantPkid"> <span>部门ID:</span>
			<input class="easyui-textbox" name="departmentId"> <span>编码:</span>
			<input class="easyui-textbox" name="code"> <span>名称:</span> <input
				class="easyui-textbox" name="name"> <span>类型:</span> <select
				class="easyui-combobox" name="employeeType" panelHeight="auto"
				style="width: 100px" editable="false">
				<option value="1">医生</option>
				<option value="2">护士</option>
				<option value="3">收费员</option>
			</select> <span>当前状态:</span> <select class="easyui-combobox" name="valid"
				panelHeight="auto" style="width: 100px" editable="false">
				<option value="1">正常</option>
				<option value="2">停用</option>
			</select> <a class="easyui-linkbutton" iconCls="icon-edit"
				onclick="javascript:goTest('#saveEmployeesForm')">测试</a>
		</form>
	</fieldset>

</div>

<script type="text/javascript">
	
</script>