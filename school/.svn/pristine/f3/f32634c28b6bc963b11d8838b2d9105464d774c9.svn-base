<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
#stuInfoForm div {
	margin: 10px;
}
#enrollmentTable .desc {
	width: 150px;
	text-align:right;
	padding-right: 20px;
}
#enrollmentTable tr {
	height: 30px;
	font-family: "微软雅黑";
	font-size: 50px;
}
#enrollmentTable tr:hover {
//	background: #ffe0ff;
}
</style>
</head>
<body>
	<div style="margin: 25px">
		<form id="stuInfoForm">
		<table style="border-collapse:collapse" cellpadding="7" id="enrollmentTable">
			<tr>
				<td class="desc"><span>学籍号:</span></td> 
				<td><input class="easyui-textbox" id="studentNumber"
					data-options="required:true, novalidate:true, missingMessage:'该处未填写!'"></td>
			</tr>

			<tr>
				<td class="desc"><span>姓名:</span></td> 
				<td><input class="easyui-textbox" id="enrollmentName"
					data-options="required:true, novalidate:true, missingMessage:'该处未填写!'"></td>
			</tr>

			<tr>
				<td class="desc"><span>性别:</span></td>
				<td><select class="easyui-combobox" id="enrollmentSex" name="enrollmentSex"
					data-options="editable:false,panelWidth: '150px', panelHeight: 'auto'"
					validtype="selectRequired['enrollmentSex']" style="width: 150px">
					<c:forEach items="${sexType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>出生日期:</span></td>
				<td><input class="easyui-datebox" id="enrollmentBorn"
					data-options="editable:false,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
					></td>
			</tr>
			<tr>
				<td class="desc"><span>身份证号:</span></td>
				<td><input class="easyui-textbox" id="enrollmentCard"
						   data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
				></td>
			</tr>
			<tr>
				<td class="desc"><span>民族：</span></td>
				<td><select class="easyui-combobox" id="enrollmentNation"
					 data-options="editable:false,panelWidth: '150px', panelHeight: '340px'"
					 style="width: 150px">
					<c:forEach items="${nationType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select><td>
			</tr>
			<tr>
				<td class="desc"><span>政治面貌:</span></td>
				<td><select class="easyui-combobox"
					id="politicalFeature"
					data-options="editable:false, panelWidth: '150px', panelHeight:'auto'"
					style="width: 150px">
					<c:forEach items="${politicalFeatureType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>健康状况:</span></td>
				<td><select class="easyui-combobox"
					id="healthType"
					data-options="editable:false, panelWidth: '150px', panelHeight:'auto'"
					style="width: 150px">
					<c:forEach items="${healthTypeList}" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>是否港澳侨胞:</span></td>
				<td><select class="easyui-combobox" id="is_hk_mc"
					data-options="editable:false, panelWidth: '150px', panelHeight:'auto'"
					style="width: 150px">
					<c:forEach items="${booleanType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>籍贯:</span></td>
				<td><input class="easyui-textbox" id="nativePlace"
					style="width: 150px;"
					data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"></td>
			</tr>
			<tr>
				<td class="desc"><span>户籍类型:</span></td>
				<td><select class="easyui-combobox"
					id="houseHoldType"
					data-options="editable: false,panelWidth:'150px',panelHeight:'auto'"
					style="width: 150px">
					<c:forEach items="${houseHoldType }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>户籍所在地:</span></td>
				<td><input class="easyui-textbox"
					id="houseHoldLocation" style="width: 500px;"
					data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
					></td>
			</tr>
			<tr>
				<td class="desc"><span>家庭住址:</span></td>
				<td><input class="easyui-textbox" id="familyAddress"
					style="width: 500px"
					data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
					></td>
			</tr>
			<tr>
				<td class="desc"><span>邮政编码:</span></td>
				<td><input class="easyui-textbox" id="postCode"
						   data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
				></td>
			</tr>
			<tr>
				<td class="desc"><span>家庭电话:</span></td>
				<td><input class="easyui-textbox" id="familyPhone"
					       data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
				></td>
			</tr>
			<tr>
				<td class="desc"><span>来源学校:</span></td>
				<td><input class="easyui-textbox"
					id="graduationSchool"
					data-options="validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
					></td>
			</tr>
			<tr>
				<td class="desc"><span>入学总分:</span></td>
				<td><input class="easyui-textbox" id="examTotalScore"
						   data-options="novalidate:true,missingMessage:'该处未填写'"
				></td>
			</tr>
			<tr>
				<td class="desc"><span>生源类型:</span></td>
				<td><select class="easyui-combobox"
					id="examineeType"
					data-options="editable: false,panelWidth:'150px',panelHeight:'auto'"
					style="width: 150px">
					<c:forEach items="${examineeTypeList }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>就读方式:</span></td>
				<td><select class="easyui-combobox" id="studyMethod"
					data-options="editable:false, panelWidth: '150px', panelHeight: 'auto'"
					style="width: 150px">
						<c:forEach items="${studyMethodList }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>入学方式:</span></td>
				<td><select class="easyui-combobox"
					id="enterSchoolType"
					data-options="editable:false, panelWidth: '150px', panelHeight: 'auto'"
					style="width: 150px">
						<c:forEach items="${enterSchoolType }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="desc"><span>入学时间:</span></td>
				<td><input class="easyui-datebox" id="entranceDate"
					data-options="editable:false,required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20'"
					></td>
			</tr>
			<tr>
				<td class="desc"><span>备注:</span></td>
				<td><textArea type="textarea" rows="5" cols="50" id="enrollmentRemark"></textArea></td>
			</tr>
			
		</table>
		<div style="margin: 20px; padding: 5px; text-align: center">
				<a href="javascript:void(0)" id="enrollmentSubmit"
					class="easyui-linkbutton">提交</a> <a href="javascript:void(0)"
					id="enrollmentReset" class="easyui-linkbutton">重置</a>
			</div>
		</form>
	</div>
</body>
<script>
	$(function() {
		
		//点击提交按钮
		$('#enrollmentSubmit')
				.click(
						function() {
							var studentNumber = $('#stuInfoForm')
									.find('#studentNumber').val();
							var name = $('#stuInfoForm')
									.find('#enrollmentName').val();
							var sex = $('#stuInfoForm').find('#enrollmentSex')
									.combobox('getValue');
							var born = $('#stuInfoForm')
									.find('#enrollmentBorn')
									.datebox('getValue');
							var card = $('#stuInfoForm')
									.find('#enrollmentCard').val();
							//nation是int型
							var nation = $('#stuInfoForm').find(
									'#enrollmentNation').combobox('getValue');
							var politicalFeature = $('#stuInfoForm').find(
									'#politicalFeature').combobox('getValue');
							var healthType = $('#stuInfoForm').find(
									'#healthType').combobox('getValue');
							var is_hk_mc = $('#stuInfoForm').find('#is_hk_mc')
									.combobox('getValue');
							var nativePlace = $('#stuInfoForm').find(
									'#nativePlace').val();
							var houseHoldType = $('#stuInfoForm').find(
									'#houseHoldType').combobox('getValue');
							var houseHoldLocation = $('#stuInfoForm').find(
									'#houseHoldLocation').val();
							var familyAddress = $('#stuInfoForm').find(
									'#familyAddress').val();
							var postCode = $('#stuInfoForm').find('#postCode')
									.val();
							var phone = $('#stuInfoForm').find('#familyPhone')
									.val();
							var examineeType = $('#stuInfoForm').find(
									'#examineeType').combobox('getValue');
							var graduationSchool = $('#stuInfoForm').find(
									'#graduationSchool').val();
							var score = $('#stuInfoForm').find(
									'#examTotalScore').val();
							var studyMethod = $('#stuInfoForm')
									.find('#studyMethod').combobox('getValue');
							var enterSchoolType = $('#stuInfoForm').find(
									'#enterSchoolType').combobox('getValue');
							var entranceDate = $('#stuInfoForm')
									.find('#entranceDate')
									.datebox('getValue');
							var remark = $('#stuInfoForm').find(
									'#enrollmentRemark').val();
							
							//表单验证
							$('#stuInfoForm').form('enableValidation').form('validate');
							if (!$('#stuInfoForm').form('validate'))
								return false;
							if (isNaN(score) && score != '') {
								$.messager.alert("操作提示", "分数必须为数字!", "warning");
								return 0;
							}

							var param = {
								"studentNumber" : studentNumber,
								"name" : name,
								"sexType" : sex,
								"birthday" : born,
								"idCard" : card,
								"nationType" : nation,
								"politicalFeatureType" : politicalFeature,
								"healthType" : healthType,
								"isHkMc" : is_hk_mc,
								"nativePlace" : nativePlace,
								"householdType" : houseHoldType,
								"householdLocation" : houseHoldLocation,
								"familyAddress" : familyAddress,
								"postcode" : postCode,
								"familyPhone" : phone,
								"examineeType" : examineeType,
								"graduationSchool" : graduationSchool,
								"examTotalScore" : score,
								"studyMethod" : studyMethod,
								"enterSchoolType" : enterSchoolType,
								"entranceDate" : entranceDate,
								"remark" : remark
							};
									
							$.post('stu/addEnrollStuInfo.do', param, function(data, status) {
								var result = eval('(' + data + ')');
								
								if (result.result == 1) {
									$.messager.alert("操作提示", "学生信息录入成功!", "info");
									reLoadEnrollStudentTab();
								} else if (result.result == -1) {
									$.messager.alert("操作提示", "学生信息不完整!", "warning");
									reLoadEnrollStudentTab();
								} else if (result.result == -2) {
									$.messager.alert("操作提示", "该学籍号的学生已存在!", "warning");
									reLoadEnrollStudentTab();
								} else if (result.result == -3) {
									$.messager.alert("操作提示", "该身份证号的学生已存在!", "warning");
									reLoadEnrollStudentTab();
								} else {
									$.messager.alert("操作提示", "信息录入失败!<br>请稍后再尝试。", "warning");
									reLoadEnrollStudentTab();
								}
							});
						});
		
		//点击重置按钮
		$("#stuInfoForm").find('#enrollmentReset').click(function() {
			reLoadEnrollStudentTab();
		});
	})
	
	//重置tab
	function reLoadEnrollStudentTab() {
		var tab = getCurrentTab();
		closeTab(tab);
		openTab('stu/enrollStudent.do', '新生信息录入');
	}
</script>
