<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="schoolEditDialog"
	style="width: 800px; height: 420px; padding: 10px 20px;" closed="true"
	buttons="#schoolDialog-buttons">
	<div class="ftitle">学校信息</div>
	<form id="schoolEditForm" method="post" novalidate>
		<input id="id" name="id" type="hidden" value="${school.id}" />
        <div class="fitem">
            <label>学校名称:</label>
            <input class="easyui-textbox" id="name" name="name" required="true" value="${school.name}">
        </div>
        <div class="fitem">
            <label>学校编号:</label>
            <input class="easyui-textbox" id="code" name="code" value="${school.code}">
        </div>
        <div class="fitem">
            <label>学校类型:</label>
			<select id="schoolTypeList" class="easyui-combobox">
				<option value="0">--请选择--</option>
				<c:forEach items="${schoolTypeList}" var="schoolType">
					<c:choose>
						<c:when test="${schoolType.id eq school.schoolType}">
							<option value="${schoolType.id}" selected>${schoolType.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${schoolType.id}">${schoolType.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
        </div>
        <div class="fitem">
            <label>学校性质:</label>
			<select id="natureTypeList" class="easyui-combobox">
				<option value="0">--请选择--</option>
				<c:forEach items="${natureTypeList}" var="natureType">
					<c:choose>
						<c:when test="${natureType.id eq school.natureType}">
							<option value="${natureType.id}" selected>${natureType.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${natureType.id}">${natureType.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
        </div>
        <div class="fitem">
            <label>联系电话:</label>
            <input class="easyui-textbox" id="phone" name="phone" value="${school.phone}">
        </div>
        <div class="fitem">
            <label>学校地址:</label>
            <input class="easyui-textbox" id="address" name="address" value="${school.address}">
        </div>
        <div class="fitem">
            <label>邮政编码:</label>
            <input class="easyui-textbox" id="postcode" name="postcode" value="${school.postcode}">
        </div>
        <div class="fitem">
            <label>网址:</label>
            <input class="easyui-textbox" id="website" name="website" value="${school.website}">
        </div>
        <div class="fitem">
            <label>邮箱:</label>
            <input class="easyui-textbox" id="email" name="email" value="${school.email}">
        </div>
        <div class="fitem">
            <label>学校简介:</label>
            <input class="easyui-textbox" id="remark" name="remark" data-options="multiline:true" 
            	style="width:400px;height:100px;" value="${school.remark}">
        </div>
	</form>
	<div id="schoolDialog-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateSchool('#schoolEditForm')">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="closeTab(getCurrentTab())">取消</a>
	</div>
</div>

<script type="text/javascript">

	function updateSchool(form) {
		var id = $(form).find("#id").val();
		var name = $(form).find("#name").val();
		var code = $(form).find("#code").val();
		var schoolType = $(form).find("#schoolTypeList").combobox('getValue');
		var natureType = $(form).find("#natureTypeList").combobox('getValue');
		var phone = $(form).find("#phone").val();
		var address = $(form).find("#address").val();
		var postcode = $(form).find("#postcode").val();
		var website = $(form).find("#website").val();
		var email = $(form).find("#email").val();
		var remark = $(form).find("#remark").val();
		
		if (name == "") {
			$.messager.alert("操作提示", "学校名称不能为空！","warning");
			return;
		}

		$.post('sch/updateSchool.do', {
			"id" : id,
			"code" : code,
			"name" : name,
			"schoolType" : schoolType,
			"natureType" : natureType,
			"phone" : phone,
			"address" : address,
			"postcode" : postcode,
			"website" : website,
			"email" : email,
			"remark" : remark
		}, function(data) {
			if (data.result > 0) {
    			$.messager.alert("操作提示", "修改学校成功！","info");
			} else if (data.result == 0) {
    			$.messager.alert("操作提示", "修改学校不成功！","warning");
			} else if (data.result == -1) {
    			$.messager.alert("操作提示", "输入的学校信息不完整！","warning");
			}
		}, "json");
	}
</script>
