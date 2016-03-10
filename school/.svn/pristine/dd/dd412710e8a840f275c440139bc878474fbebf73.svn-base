<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 20px 70px">
	<form id="newTeacherThesisForm" method="post">
		<table cellpadding="7">
				
			<tr style="diplay:none">
				<input id="teacherId" name="teacherId" type="hidden" value="<c:out value='${teacherId}'/>" />
			</tr>
			<tr>   
				<div style="margin-bottom: 20px">
					<td>论文类型:</td>
					
					<td><select class="easyui-combobox" id="teacherThesisType"
						name="teacherThesisType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '105px',novalidate:true"
						validtype="selectRequired['teacherThesisType']"
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
			onclick="addNewTeacherThesis('#newTeacherThesisForm')">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel();">取消</a>
	</div>
	
</div>


<script type="text/javascript">
	
	
	function addNewTeacherThesis(form) {

		//在提交数据之前执行表单验证
		$('#newTeacherThesisForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$(form).form('validate')) {
			return false;
		}
		
		
		var teacherId = $(form).find("#teacherId").val();
		var teacherThesisType = $(form).find('#teacherThesisType').combobox('getValue');	
		var publishDateStr = $(form).find("#publishDate").datebox('getValue');
		var thesisName = $(form).find("#thesisName").val();
		var publication = $(form).find("#publication").val();
		var authorOrder = $(form).find("#authorOrder").val();
		var remark = $(form).find("#remark").val();
		$.post('tea/addTeacherThesis.do', {
			"teacherId":teacherId,
			"thesisType" : teacherThesisType,
			"publishDateStr" : publishDateStr,
			"thesisName" : thesisName,
			"publication" : publication,
			"authorOrder" : authorOrder,
			"remark" : remark
		}, function(data) {
			if (data.result > 0) {
				closeTab(getCurrentTab());
				$.messager.alert("操作提示", "添加论文著作成功！", "info");
				$('#teacherThesisList').datagrid('reload');
			} else if (data.result == -1) {
				$.messager.alert("操作提示", "输入的论文著作信息不完整!", "warning");
			}
		}, "json")
	}
	
	function cancel(){
		closeTab(getCurrentTab());
	}
</script>

<style scoped="scoped">
.textbox {
	height: 20px;
	margin: 0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>