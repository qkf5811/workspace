<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${contextPath}/js/ajaxfileupload.js"></script>
<div class="easyui-panel" style="padding: 30px 70px 90px 70px">
<form id="teacherThesisEditForm" method="post">
	<table cellpadding="7">
	
			<input id="id" name="id" type="hidden" value="<c:out value='${id}'/>" />	
			<input id="code" name="code" type="hidden" value="<c:out value='${code}'/>" />	
			<tr>   
				<div style="margin-bottom: 20px">
					<td>论文类型:</td>
					
					<td><select class="easyui-combobox" id="teaThesisType"
						name="teaThesisType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['teaThesisType']"
						style="width: 105px; height: 33px; padding: 5px">
							<option value="">请选择</option>
							<c:forEach items="${teacherThesisTypeList}" var="teacherThesisType">
							<option value="${teacherThesisType.id}">${teacherThesisType.name}</option>
							</c:forEach>		
					</select></td>
				</div>
			</tr>
			
			
			<tr>
				<div style="margin-bottom: 20px">
					<td>论文著作名称:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="thesisName" name="thesisName"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
			
			
				
			<tr>
				<div style="margin-bottom: 20px">
					<td>所属刊物/出版单位:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="publication" name="publication"
						data-options="required:true,validType:'length[1,50]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-50' " 
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>

		
			<tr>
				<div style="margin-bottom: 20px">
					<td>作者排名:</td>

					<td><input class="easyui-numberbox"
						id="authorOrder" name="authorOrder"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>论文发表日期:</td>

					<td><input class="easyui-datebox textbox" type="text"
						id="publishDate" name="publishDate"
						data-options="editable:false,required:true,showSeconds:false,novalidate:true,missingMessage:'该处未填写'"
						style="height: 33px; width: 200px"></input></td>
				</div>
			</tr>
			
			<tr>
				<div style="margin-bottom: 20px">
					<td >备注:</td>

					<td><input class="easyui-validatebox textbox" type="text"
						id="remark" name="remark"
						style="width: 200px; height: 18px; padding: 5px"></input></td>
				</div>
			</tr>
	
		</table>
		<!-- <div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="remark" name="remark" rows="3"
				cols="60"></textArea>
		</div> -->
</form>
<div style="margin-left:180px; margin-top:20px;padding: 5px">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="editTeacherThesis('#teacherThesisEditForm')">提交</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
</div>
</div>


</div>

<script type="text/javascript">
	$(function() {
		getTeacherThesis("#teacherThesisEditForm");
	});

	
	function cancel(){
		closeTab(getCurrentTab());
	}
	function getTeacherThesis(form) {
		var id = $(form).find("#id").val();
		$.post('tea/getTeacherThesis.do', {
			"id" : id,
		}, function(data) {
			$(form).find('#teaThesisType').combobox('select',data.ttDto.thesisType);
			$(form).find('#thesisName').val(data.ttDto.thesisName);
			$(form).find("#publishDate").datebox('setText',data.ttDto.publishDateStr);
			$(form).find("#publication").val(data.ttDto.publication);
			$('#authorOrder').numberbox('setValue', data.ttDto.authorOrder);
			/* $(form).find("#authorOrder").val(data.ttDto.authorOrder); */
			$(form).find("#remark").val(data.ttDto.remark);
			

		}, "json")
	}
	function editTeacherThesis(form) {
		//在提交数据之前执行表单验证
		$('#teacherThesisEditForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		}
		
		var id = $(form).find("#id").val();
		var code = $(form).find("#code").val();
		var thesisName = $(form).find("#thesisName").val();
		var thesisType = $(form).find('#teaThesisType')
		.combobox('getValue');	
		var publishDateStr=$(form).find("#publishDate").datebox('getText');
		var authorOrder = $(form).find("#authorOrder").val();
		var publication = $(form).find("#publication").val();
		var remark = $(form).find("#remark").val(); 
		


		$.post('tea/editTeacherThesis.do', {

			"id" : id,
			"code":code,
			"thesisType" : thesisType,
			"publishDateStr" : publishDateStr,
			"thesisName" : thesisName,
			"publication" : publication,
			"authorOrder" : authorOrder,
			"remark" : remark
		}, function(result) {
			closeTab(getCurrentTab());
			$('#teacherThesisList').datagrid('reload');
			$.messager.alert("操作提示", "编辑论文著作信息成功！","info");
		}, "json")
	}

	
</script>


<style scoped="scoped">
.textbox {
	height: 20px;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
