<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style scoped>
	#teracherTable b {
		float: right;
		margin-right: 25px;
	}
	#teracherTable select {
		width: 150px;
	} 
	teacherEduExpTable b {
		float: right;
		margin-right: 25px;
	}
	teacherEduExpTable select {
		width: 150px;
	} 
	#teacherInfoTable b {
		float: right;
		margin-right: 25px;
	}
	#teacherInfoTable select {
		width: 150px;
	} 
</style>
<div id="submitTeacherForm">
<!-- class="easyui-panel" -->
<div style="margin:10px;" title="教师基本信息" data-options="iconCls:'icon-edit',collapsible:true">
	<table id="teracherTable" style="margin:10px auto auto 100px">
		<tr>
			<td><b>教师姓名:</b></td>
			<td><input class="easyui-validatebox textbox" id="nameOfInput"
						style="width: 150px;height:20px"
						data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
		</tr>
		<tr>
			<td><b>教师编号:</b></td>
			<td><input class="easyui-validatebox textbox" id="codeOfInput"
						style="width: 150px;height:20px"
						data-options="required:true, missingMessager:'该处未填写!',novalidate:true"></td>
		</tr>
		<tr>
			<td><b>担任职位:</b></td>
			<td><input class="easyui-validatebox textbox"  id="nowPositionOfInput"
						style="width: 150px;height:20px"
						data-options="missingMessager:'该处未填写!',novalidate:true">
			</td>
		</tr>
		<tr>
			<td><b>职称:</b></td>
			<td><select class="easyui-combobox" id="titleTypeOfInput" name="titleTypeOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${titleType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>部门:</b></td>
			<td><select class="easyui-combobox" id="departmentOfInput" name="departmentOfInput"
						validtype="selectRequired['departmentOfInput']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${department }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>教职工类型:</b></td>
			<td><select class="easyui-combobox"  id="staffTypeOfInput" name="staffTypeOfInput"
						validtype="selectRequired['staffTypeOfInput']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${staffType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>教师职位状态:</b></td>
			<td><select class="easyui-combobox" id="positionTypeOfInput" name="positionTypeOfInput"
						validtype="selectRequired['positionTypeOfInput']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${positionType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>参加工作日期:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false,novalidate:true" id="workStartTimeOfInput"></span></td>
		</tr>
		<tr>
			<td><b>在本校任职日期:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false,novalidate:true" id="takeOfficeTimeOfInput"></td>
		</tr>
		<tr>
			<td><b>性别:</b></td>
			<td><select class="easyui-combobox" id="sexTypeOfInput" name="sexTypeOfInput"
						validtype="selectRequired['sexTypeOfInput']"
                        data-options="editable:false,panelHeight: 'auto',required:true,missingMessage:'该处未选择',novalidate:true">
					<option value="0">请选择</option>
					<c:forEach items="${sexType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>出生年月:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false,missingMessage:'该处未填写', novalidate:true" id="birthdayOfInput"></span></td>
		</tr>
		<tr>
			<td><b>证件类型:</b></td>
			<td><select class="easyui-combobox"  id="idCardTypeOfInput" name="idCardTypeOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${idCardType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>证件号:</b></td>
			<td><input class="easyui-validatebox textbox" id="idCardOfInput"
						style="width: 150px;height:20px" data-options="missingMessager:'该处未填写!',novalidate:true"
						></td>
		</tr>
		<tr>
			<td><b>国籍:</b></td>
			<td><select class="easyui-combobox"  id="countryIdOfInput" name="countryIdOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${countryId }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>民族:</b></td>
			<td><select class="easyui-combobox"  id="nationTypeOfInput"
						data-options="editable:false,panelHeight:'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${nationType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>政治面貌:</b></td>
			<td><select class="easyui-combobox" id="politicalFeatureTypeOfInput" name="politicalFeatureTypeOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${politicalFeature }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>籍贯:</b></td>
			<td><input class="easyui-validatebox textbox" id="nativePlaceOfInput"
						style="width: 150px;height:20px" data-options="missingMessager:'该处未填写!',novalidate:true"></td>
		</tr>
		<tr>
			<td><b>婚姻状况:</b></td>
			<td><select class="easyui-combobox"  id="maritalStatusOfInput" name="maritalStatusOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${maritalStatus }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>户籍类型:</b></td>
			<td><select class="easyui-combobox" id="householdTypeOfInput" name="householdTypeOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${householdType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr style="">
			<td><b>学历:</b></td>
			<td><select class="easyui-combobox"  id="degreeTypeOfInput" name="degreeTypeOfInput"
                        data-options="editable:false,panelHeight: 'auto'">
					<option value="0">请选择</option>
					<c:forEach items="${degreeType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>家庭电话:</b></td>
			<td><input class="easyui-textbox" id="familyPhoneOfInput"></td>
		</tr>
		<tr>
			<td><b>办公电话:</b></td>
			<td><input class="easyui-textbox" id="officePhoneOfInput"></td>
		</tr>
		<tr>
			<td><b>移动电话:</b></td>
			<td><input class="easyui-textbox" id="mobilePhoneOfInput"
						></td>
		</tr>
		<tr>
			<td><b>电子邮件:</b></td>
			<td><input class="easyui-textbox" id="emailOfInput"
						data-options="validType:'email', invalidMessage:'邮箱格式错误!'"></td>
		</tr>
		<tr>
			<td><b>邮政编码:</b></td>
			<td><input class="easyui-textbox" id="postcodeOfInput"></td>
		</tr>
		<tr>
			<td><b>家庭地址:</b></td>
			<td><textArea cols="50" rows="5" id="familyAddressOfInput"></textArea></td>
		</tr>
		<tr>
			<td><b>备注:</b></td>
			<td><textArea cols="50" rows="5" id="remarkOfTeaInfo"></textArea></td>
		</tr>
	</table>
</div>

<!-- <div class="easyui-panel" style="margin:10px" title="教师详细信息" data-options="collapsible:true,iconCls:'icon-edit'">
	<table id="teacherInfoTable" style="margin:10px auto auto 140px">
		<tr>
			<td><b>性别:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="sexType">
					<option value="0">请选择</option>
					<c:forEach items="${sexType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>出生年月:</b></td>
			<td><span class="easyui-datebox" data-options="editable:false" id="birthday"></span></td>
		</tr>
		<tr>
			<td><b>证件类型:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="idCardType">
					<option value="0">请选择</option>
					<c:forEach items="${idCardType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>身份证号:</b></td>
			<td><input class="easyui-validatebox textbox" id="idCard"
						style="width: 150px;height:20px"
						></td>
		</tr>
		<tr>
			<td><b>国籍:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="countryId">
					<option value="0">请选择</option>
					<c:forEach items="${countryId }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>民族:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="nationType">
					<option value="0">请选择</option>
					<c:forEach items="${nationType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>政治面貌:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="politicalFeatureType">
					<option value="0">请选择</option>
					<c:forEach items="${politicalFeature }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>籍贯:</b></td>
			<td><textArea cols="50" rows="5" id="nativePlace"></textArea></td>
		</tr>
		<tr>
			<td><b>婚姻状况:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="maritalStatus">
					<option value="0">请选择</option>
					<c:forEach items="${maritalStatus }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>户籍类型:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="householdType">
					<option value="0">请选择</option>
					<c:forEach items="${householdType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr style="display:none">
			<td><b>学历:</b></td>
			<td><select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'"  id="degreeType">
					<option value="0">请选择</option>
					<c:forEach items="${degreeType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><b>家庭地址:</b></td>
			<td><textArea cols="50" rows="5" id="familyAddress"></textArea></td>
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
			<td><input class="easyui-textbox" id="mobilePhone"
						></td>
		</tr>
		<tr>
			<td><b>电子邮件:</b></td>
			<td><input class="easyui-textbox" id="email"
						data-options="validType:'email', invalidMessage:'邮箱格式错误!'"></td>
		</tr>
		<tr>
			<td><b>备注:</b></td>
			<td><textArea cols="50" rows="5" id="remarkOfTeaInfo"></textArea></td>
		</tr>
	</table>
</div>
</div>
 -->
<div style="text-align:center;margin: 15px">
	<a href="javascript:void(0)" style="margin-right:20px"class="easyui-linkbutton"
		onclick="submitTeacherTotalInfo()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
	    onclick="resetSubTeacherInfoTab()">重置</a>
</div>
<script type="text/javascript">
	//提交表单
	function submitTeacherTotalInfo() {
		//在提交数据之前执行表单验证
		$('#submitTeacherForm').form('enableValidation').form('validate');
		
		//判断表单验证是否通过
		if(!$('#submitTeacherForm').form('validate')){
			return false;
		} 
		
		//得到参数(教师)
		var name = $('#submitTeacherForm').find('#teracherTable').find('#nameOfInput').val();
		var code = $('#submitTeacherForm').find('#teracherTable').find('#codeOfInput').val();
		var nowPosition = $('#submitTeacherForm').find('#teracherTable').find('#nowPositionOfInput').val();
		var titleType = $('#submitTeacherForm').find('#teracherTable').find('#titleTypeOfInput').combobox('getValue');
		var staffType = $('#submitTeacherForm').find('#teracherTable').find('#staffTypeOfInput').combobox('getValue');
		var positionType = $('#submitTeacherForm').find('#teracherTable').find('#positionTypeOfInput').combobox('getValue');
		var workStartTime = $('#submitTeacherForm').find('#teracherTable').find('#workStartTimeOfInput').datebox('getValue');
		var takeOfficeTime = $('#submitTeacherForm').find('#teracherTable').find('#takeOfficeTimeOfInput').datebox('getValue');
		
/*		alert("姓名:" + name + ", 编号:" + code + ", 专业id:" + majorId + ", 职位:" + nowPosition + ", 职称:" + 
				titleType + ", 教职工类型:" + staffType + ", 职位状态:" + positionType + ", 参加工作日期:" + 
				workStartTime + ", 本校任职日期: " + takeOfficeTime + ", 教师备注:" + remarkOfTeacher);
*/		
		var department = $('#submitTeacherForm').find('#teracherTable').find('#departmentOfInput').combobox('getValue');
		var degreeType = $('#submitTeacherForm').find('#teracherTable').find('#degreeTypeOfInput').combobox('getValue');
		//得到参数(教师信息)
		var sexType = $('#submitTeacherForm').find('#teracherTable').find('#sexTypeOfInput').combobox('getValue');
		var birthday = $('#submitTeacherForm').find('#teracherTable').find('#birthdayOfInput').datebox('getValue');
		var idCardType = $('#submitTeacherForm').find('#teracherTable').find('#idCardTypeOfInput').combobox('getValue');
		var idCard = $('#submitTeacherForm').find('#teracherTable').find('#idCardOfInput').val();
		var countryId = $('#submitTeacherForm').find('#teracherTable').find('#countryIdOfInput').combobox('getValue');
		var nationType = $('#submitTeacherForm').find('#teracherTable').find('#nationTypeOfInput').combobox('getValue');
		var politicalFeatureType = $('#submitTeacherForm').find('#teracherTable').find('#politicalFeatureTypeOfInput').combobox('getValue');
		var nativePlace = $('#submitTeacherForm').find('#teracherTable').find('#nativePlaceOfInput').val();
		var maritalStatus = $('#submitTeacherForm').find('#teracherTable').find('#maritalStatusOfInput').combobox('getValue');
		var householdType = $('#submitTeacherForm').find('#teracherTable').find('#householdTypeOfInput').combobox('getValue');	
		var familyAddress = $('#submitTeacherForm').find('#teracherTable').find('#familyAddressOfInput').val();
		var postcode = $('#submitTeacherForm').find('#teracherTable').find('#postcodeOfInput').val();
		var familyPhone = $('#submitTeacherForm').find('#teracherTable').find('#familyPhoneOfInput').val();
		var officePhone = $('#submitTeacherForm').find('#teracherTable').find('#officePhoneOfInput').val();
		var mobilePhone = $('#submitTeacherForm').find('#teracherTable').find('#mobilePhoneOfInput').val();
		var email = $('#submitTeacherForm').find('#teracherTable').find('#emailOfInput').val();
		var remarkOfTeaInfo = $('#submitTeacherForm').find('#teracherTable').find('#remarkOfTeaInfo').val();
		
/*		alert("性别:" + sexType + ", 出生日期:" + birthday + ", 证件类型:" + idCardType + ", 证件号:" + idCard + 
				", 国籍:" + countryId + ", 民族:" + nationType + ", 政治面貌:" + politicalFeatureType
				+ ", 户籍: " + nativePlace + ", 婚姻状态:" + maritalStatus + ", 户籍类型:" + householdType + 
				", 学历: " + degreeType + ", 家庭住址:" + familyAddress + ", 邮编: " + postcode + 
				", 家庭电话:" + familyPhone + ", 办公电话:" + officePhone + ", 移动电话:" + mobilePhone + 
				", 邮箱: " + email + ", 教师信息备注: " + remarkOfTeaInfo) ;
*/		
		param = {
				//教师表
				nameOfTeacher: name,
				code: code,
				majorId: majorId,
				nowPosition: nowPosition,
				titleType: titleType,
				staffType: staffType,
				positionType: positionType,
				workStartTimeStr: workStartTime,
				takeOfficeTimeStr: takeOfficeTime,
				workStartTime: workStartTime,
				takeOfficeTime: takeOfficeTime,
				
				departmentId : department,

				//教师信息表
				name: name,
				sexType: sexType,
				birthdayStr: birthday,
				birthday: birthday,
				idCardType: idCardType,
				idCard: idCard,
				countryId: countryId,
				nationType: nationType,
				politicalFeatureType: politicalFeatureType,
				nativePlace: nativePlace,
				maritalStatus: maritalStatus,
				householdType: householdType,
				degreeType: degreeType,
				familyAddress: familyAddress,
				postcode: postcode,
				familyPhone: familyPhone,
				officePhone: officePhone,
				mobilePhone: mobilePhone,
				email: email,
				remark: remarkOfTeaInfo
		};
		console.log(param);
		$.post('${contextPath}/tea/addNewTeacher.do',
				param,
				function(data){
			
			//		alert(data);
			//		console.log(data.result);
					var obj = eval('(' + data + ')');
					if (obj.result == 1){
						$.messager.alert("操作提示", "教师信息录入成功!", 'info');	
						closeTab(getCurrentTab());
						$('#teacherInfoForm').find('#teaInfoTable')
						.datagrid('reload');
					} else if (obj.result == 0) {
						$.messager.alert("操作提示", "教师信息录入失败!请稍后再尝试!", "warning");
					} else if (obj.result == -1) {
						$.messager.alert("操作提示", "录入失败!该教职工编号已存在!", "warning");
					}
		});
	}
	//重置(重新打开tab)
	function resetSubTeacherInfoTab() {
//		var tab = getCurrentTab();
//		closeTab(tab);
//		openTab('tea/openInputTeacherInfoTab.do', '教师信息录入');
		$('#submitTeacherForm').form('clear');
		$('#submitTeacherForm').find('#teracherTable').find('#titleTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#staffTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#positionTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#departmentOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#degreeTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#sexTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#idCardTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#countryIdOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#nationTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#politicalFeatureTypeOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#maritalStatusOfInput').combobox('select', 0);
		$('#submitTeacherForm').find('#teracherTable').find('#householdTypeOfInput').combobox('select', 0);
	}
</script>