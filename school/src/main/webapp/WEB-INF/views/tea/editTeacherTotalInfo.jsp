<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style scoped>
	#editTeacherTotalInfoForm b {
		float: right;
		margin-right: 25px;
	}
	#editTeacherTotalInfoForm select {
		width: 150px;
	} 
</style>
<div id="editTeacherTotalInfoForm" style="margin: 15px">
	<input type="text" value="${teacherId }" id="teacherId" hidden="true">
	<form>
		<!-- 基本信息 -->
		<table id="" style="margin: 10px auto auto 30px">
			
			<tr hidden="true">
				<td>id:</td>
				<td><input class="easyui-textbox" id="idOfTeacher"></td>
			</tr>
			<tr>
				<td><b>教师姓名:</b></td>
				<td><input class="easyui-validatebox textbox" id="name"
					style="width: 150px; height: 20px"
					data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><b>教师编号:</b></td>
				<td><input class="easyui-validatebox textbox" id="code"
					style="width: 150px; height: 20px"
					data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><b>担任职位:</b></td>
				<td><input class="easyui-validatebox textbox" id="nowPosition"
					style="width: 150px; height: 20px"
					data-options="missingMessager:'该处未填写!',novalidate:true">
				</td>
			</tr>
			<tr>
				<td><b>职称:</b></td>
				<td><select class="easyui-combobox"
					id="titleType" name="titleType"
                        data-options="editable:false,panelHeight: 'auto'e">
						<option value="0">请选择</option>
						<c:forEach items="${titleType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>教职工类型:</b></td>
				<td><select class="easyui-combobox"
					id="staffType" name="staffType"
						validtype="selectRequired['staffType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${staffType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>教师职位状态:</b></td>
				<td><select class="easyui-combobox"
					id="positionType" name="positionType"
						validtype="selectRequired['positionType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${positionType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>参加工作日期:</b></td>
				<td><span class="easyui-datebox" data-options="editable:false"
					id="workStartTime"></span></td>
			</tr>
			<tr>
				<td><b>在本校任职日期:</b></td>
				<td><span class="easyui-datebox" data-options="editable:false"
					id="takeOfficeTime"></td>
			</tr>
			<tr>
				<td><b>教师基本信息备注:</b></td>
				<td><textArea cols="50" rows="3" id="remarkOfTea"></textArea></td>
			</tr>
			<!-- 教师教育经历 -->
<!-- 			<tr>
				<td><b>教育类型:</b></td>
				<td><select class="easyui-combobox"
					data-options="editable:false,panelHeight:'auto'" id="educationType">
						<option value="0">请选择</option>
						<c:forEach items="${educationType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>所属学校:</b></td>
				<td><input class="easyui-validatebox textbox" id="school"
					style="width: 150px; height: 20px"
					data-options="required:true, missingMessage:'该处未填写!',novalidate:true">
				</td>
			</tr>
			<tr>
				<td><b>所属专业:</b></td>
				<td><input class="easyui-validatebox textbox" id="major"
					style="width: 150px; height: 20px"
					data-options="required:true, missingMessage:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><b>开始时间:</b></td>
				<td><span class="easyui-datebox" data-options="editable:false"
					id="startDate"></span></td>
			</tr>
			<tr>
				<td><b>结束时间:</b></td>
				<td><span class="easyui-datebox" data-options="editable:false"
					id="endDate"></span></td>
			</tr>
			
			<tr>
				<td><b>教师教育经历备注:</b></td>
				<td><textArea cols="50" rows="5" id="remarkOfTeaEdu"></textArea></td>
			</tr>
			-->
			<!-- 详细信息 -->
			<tr>
				<td><b>学历:</b></td>
				<td><select class="easyui-combobox"
					id="degreeType" name="degreeType"
						validtype="selectRequired['degreeType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${degreeType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>性别:</b></td>
				<td><select class="easyui-combobox"
					id="sexType" name="sexType"
						validtype="selectRequired['sexType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${sexType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>出生年月:</b></td>
				<td><span class="easyui-datebox" data-options="editable:false,required:true,missingMessage:'该处未填写', novalidate:true"
					id="birthday"></span></td>
			</tr>
			<tr>
				<td><b>证件类型:</b></td>
				<td><select class="easyui-combobox"
					id="idCardType" name="idCardType"
						validtype="selectRequired['idCardType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${idCardType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>证件号:</b></td>
				<td><input class="easyui-validatebox textbox" id="idCard"
					style="width: 150px; height: 20px"
					 data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
			</tr>
			<tr>
				<td><b>国籍:</b></td>
				<td><select class="easyui-combobox"
					 id="countryId" name="countryId"
						validtype="selectRequired['countryId']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${countryId }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>民族:</b></td>
				<td><select class="easyui-combobox"
					id="nationType" data-options="editable:false,panelHeight:'auto'">
						<option value="0">请选择</option>
						<c:forEach items="${nationType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>政治面貌:</b></td>
				<td><select class="easyui-combobox"
					id="politicalFeatureType" name="politicalFeatureType"
						validtype="selectRequired['politicalFeatureType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${politicalFeature }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>籍贯:</b></td>
				<td><textArea cols="50" rows="3" id="nativePlace"></textArea></td>
			</tr>
			<tr>
				<td><b>婚姻状况:</b></td>
				<td><select class="easyui-combobox"
					id="maritalStatus" name="maritalStatus"
						validtype="selectRequired['maritalStatus']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${maritalStatus }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>户籍类型:</b></td>
				<td><select class="easyui-combobox"
					id="householdType" name="householdType"
						validtype="selectRequired['householdType']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
						<option value="0">请选择</option>
						<c:forEach items="${householdType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<!-- 		<tr>
			<td><b>学历:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="degreeType">
					<option value="0">请选择</option>
			</select></td>
		</tr> -->
			<tr>
				<td><b>家庭地址:</b></td>
				<td><textArea cols="50" rows="2" id="familyAddress"></textArea></td>
			</tr>
			<tr>
				<td><b>邮政编码:</b></td>
				<td><input class="easyui-textbox" id="postcode"></td>
			</tr>
			<tr>
				<td><b>家庭电话:</b></td>
				<td><input class="easyui-textbox" id="familyPhone"></td>
			</tr>
			<tr>
				<td><b>办公电话:</b></td>
				<td><input class="easyui-textbox" id="officePhone"></td>
			</tr>
			<tr>
				<td><b>移动电话:</b></td>
				<td><input class="easyui-textbox" id="mobilePhone"></td>
			</tr>
			<tr>
				<td><b>电子邮件:</b></td>
				<td><input class="easyui-textbox" id="email"></td>
			</tr>
			<tr>
				<td><b>教师详细信息备注:</b></td>
				<td><textArea cols="50" rows="3" id="remarkOfTeaInfo"></textArea></td>
			</tr>
		</table>

	</form>
	<div style="text-align: center; margin: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="editTeacherTotalInfo()">确认</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="closeTab(getCurrentTab())">取消</a>
	</div>
</div>


<script>
	//---------------------
	//基本信息
	$(function (){
		$.post('tea/getTeacherTotalInfo.do?',
			{teacherId:$('#editTeacherTotalInfoForm').find('#teacherId').val()},
			function (data) {
				var dto = eval('(' + data + ')');
				dto = eval('(' + dto.result+ ')');
		//		console.log("对象:");
		//		console.log(dto);
				$('#editTeacherTotalInfoForm').find('#idOfTeacher').textbox('setValue',
						dto.idOfTeacher);
				
				$('#editTeacherTotalInfoForm').find('#name').val(dto.nameOfTeacher);
				$('#editTeacherTotalInfoForm').find('#code').val(dto.code);
				$('#editTeacherTotalInfoForm').find('#nowPosition').val(dto.nowPosition);
				$('#editTeacherTotalInfoForm').find('#titleType').combobox('select',
						dto.titleType);
				$('#editTeacherTotalInfoForm').find('#staffType').combobox('select',
						dto.staffType);
				$('#editTeacherTotalInfoForm').find('#positionType').combobox('select',
						dto.positionType);
				$('#editTeacherTotalInfoForm').find('#workStartTime').datebox('setValue',
						dto.workStartTime);
				$('#editTeacherTotalInfoForm').find('#takeOfficeTime').datebox('setValue',
						dto.takeOfficeTime);
				//教育经历信息
				$('#editTeacherTotalInfoForm').find('#educationType').combobox('select',
						dto.educationType);
				$('#editTeacherTotalInfoForm').find('#school').val(dto.school);
				$('#editTeacherTotalInfoForm').find('#major').val(dto.major);
				$('#editTeacherTotalInfoForm').find('#startDate').datebox('setValue',
						dto.startDate);
				$('#editTeacherTotalInfoForm').find('#endDate').datebox('setValue',
						dto.endDate);
				$('#editTeacherTotalInfoForm').find('#degreeType').combobox('select',
						dto.degreeType);
				$('#editTeacherTotalInfoForm').find('#remarkOfTeaEdu').val(dto.remarkOfTeaEdu);
				//详细信息
				$('#editTeacherTotalInfoForm').find('#sexType')
						.combobox('select', dto.sexType);
				$('#editTeacherTotalInfoForm').find('#birthday').datebox('setValue',
						dto.birthday);
				$('#editTeacherTotalInfoForm').find('#idCardType').combobox('select',
						dto.idCardType);
				$('#editTeacherTotalInfoForm').find('#idCard').val(dto.idCard);
				$('#editTeacherTotalInfoForm').find('#countryId').combobox('select',
						dto.countryId);
				$('#editTeacherTotalInfoForm').find('#nationType').combobox('select',
						dto.nationType);
				$('#editTeacherTotalInfoForm').find('#politicalFeatureType').combobox('select',
						dto.politicalFeatureType);
				$('#editTeacherTotalInfoForm').find('#nativePlace').val(dto.nativePlace);
				$('#editTeacherTotalInfoForm').find('#maritalStatus').combobox('select',
						dto.maritalStatus);
				$('#editTeacherTotalInfoForm').find('#householdType').combobox('select',
						dto.householdType);
				$('#editTeacherTotalInfoForm').find('#familyAddress').val(dto.familyAddress);
				$('#editTeacherTotalInfoForm').find('#postcode').textbox('setValue',
						dto.postcode);
				$('#editTeacherTotalInfoForm').find('#familyPhone').textbox('setValue',
						dto.familyPhone);
				$('#editTeacherTotalInfoForm').find('#officePhone').textbox('setValue',
						dto.officePhone);
				$('#editTeacherTotalInfoForm').find('#mobilePhone').textbox('setValue',
						dto.mobilePhone);
				$('#editTeacherTotalInfoForm').find('#email').textbox('setValue', dto.email);
				$('#editTeacherTotalInfoForm').find('#remarkOfTeaInfo').val(dto.remark);
			}
		);
/*		*/
		//		$('#showAndEditWindow').find('#staffType').combobox('select', rows[0].staffType);
		//		$('#showAndEditWindow').find('#staffType').combobox('select', rows[0].staffType);
	})
	

	//修改教师完整信息
	function editTeacherTotalInfo() {

		//在提交数据之前执行表单验证
		$('#editTeacherTotalInfoForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$('#editTeacherTotalInfoForm').form('validate')){
			return false;
		} 
		//获取window里的参数
		var param = {
			//基本信息
			idOfTeacher : $('#editTeacherTotalInfoForm').find('#idOfTeacher').textbox(
					'getValue'),
			nameOfTeacher : $('#editTeacherTotalInfoForm').find('#name').val(),
			code : $('#editTeacherTotalInfoForm').find('#code').val(),
			nowPosition : $('#editTeacherTotalInfoForm').find('#nowPosition').val(),
			titleType : $('#editTeacherTotalInfoForm').find('#titleType').combobox(
					'getValue'),
			staffType : $('#editTeacherTotalInfoForm').find('#staffType').combobox(
					'getValue'),
			positionType : $('#editTeacherTotalInfoForm').find('#positionType')
					.combobox('getValue'),
			workStartTime : $('#editTeacherTotalInfoForm').find('#workStartTime')
					.datebox('getValue'),
			takeOfficeTime : $('#editTeacherTotalInfoForm').find('#takeOfficeTime')
					.datebox('getValue'),
			workStartTimeStr : $('#editTeacherTotalInfoForm').find('#workStartTime')
					.datebox('getValue'),
			takeOfficeTimeStr : $('#editTeacherTotalInfoForm').find('#takeOfficeTime')
					.datebox('getValue'),
			//教育经历信息
/*			educationType : $('#editTeacherTotalInfoForm').find('#educationType')
					.combobox('getValue'),
			school : $('#editTeacherTotalInfoForm').find('#school').val(),
			major : $('#editTeacherTotalInfoForm').find('#major').val(),
			startDate : $('#editTeacherTotalInfoForm').find('#startDate').datebox(
					'getValue'),
			startDateStr : $('#editTeacherTotalInfoForm').find('#startDate').datebox(
					'getValue'),
			endDate : $('#editTeacherTotalInfoForm').find('#endDate').datebox(
					'getValue'),
			endDateStr : $('#editTeacherTotalInfoForm').find('#endDate').datebox(
					'getValue'),
			remarkOfTeaEdu : $('#editTeacherTotalInfoForm').find('#remarkOfTeaEdu')
					.val(),
					*/
			//详细信息
			name : $('#editTeacherTotalInfoForm').find('#name').val(),
			sexType : $('#editTeacherTotalInfoForm').find('#sexType').combobox(
					'getValue'),
			birthday : $('#editTeacherTotalInfoForm').find('#birthday').datebox(
					'getValue'),
			birthdayStr : $('#editTeacherTotalInfoForm').find('#birthday').datebox(
					'getValue'),
			idCardType : $('#editTeacherTotalInfoForm').find('#idCardType').combobox(
					'getValue'),
			idCard : $('#editTeacherTotalInfoForm').find('#idCard').val(),
			countryId : $('#editTeacherTotalInfoForm').find('#countryId').combobox(
					'getValue'),
			nationType : $('#editTeacherTotalInfoForm').find('#nationType').combobox(
					'getValue'),
			politicalFeatureType : $('#editTeacherTotalInfoForm').find(
					'#politicalFeatureType').combobox('getValue'),
			nativePlace : $('#editTeacherTotalInfoForm').find('#nativePlace').val(),
			maritalStatus : $('#editTeacherTotalInfoForm').find('#maritalStatus')
					.combobox('getValue'),
			householdType : $('#editTeacherTotalInfoForm').find('#householdType')
					.combobox('getValue'),
			degreeType : $('#editTeacherTotalInfoForm').find('#degreeType').combobox(
					'getValue'),
			familyAddress : $('#editTeacherTotalInfoForm').find('#familyAddress')
					.val(),
			postcode : $('#editTeacherTotalInfoForm').find('#postcode').textbox(
					'getValue'),
			familyPhone : $('#editTeacherTotalInfoForm').find('#familyPhone').textbox(
					'getValue'),
			officePhone : $('#editTeacherTotalInfoForm').find('#officePhone').textbox(
					'getValue'),
			mobilePhone : $('#editTeacherTotalInfoForm').find('#mobilePhone').textbox(
					'getValue'),
			email : $('#editTeacherTotalInfoForm').find('#email').textbox('getValue'),
			remark : $('#editTeacherTotalInfoForm').find('#remarkOfTeaInfo').val()
		};
//		console.log(param);
		$.post('${contextPath}/tea/editTeacherTotalInfo.do', param, 
				function(data) {
	//		alert('报错');
			var obj = eval('(' + data + ')');
	//		console.log(obj)
			if (obj.result == 1) {
				$.messager.alert("操作提示", "教师信息修改成功!", 'info');
				//closeWin();
				closeTab(getCurrentTab());
				$('#teacherInfoForm').find('#teaInfoTable').datagrid('reload');
			} else if (obj.result == 0) {
				$.messager.alert("操作提示", "教师信息修改失败!/n请稍后再尝试!", "warning");
			}
		})
	}
</script>