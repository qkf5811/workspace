<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style scoped type="text/css">
#conditionsOfTeaInfo #moreBtn {
	text-decoration: none
}

#conditionsOfTeaInfo #moreBtn:hover {
	color: red;
}

#conditionsOfTeaInfo div select {
	width: 180px;
}

#showAndEditWindow b {
	float: right;
	margin-right: 25px;
}

#showAndEditWindow select {
	
}

#teacherItem b {
	float: right;
}

#teacherInfoItem b {
	float: right;
}

#teacherEduExpItem b {
	float: right;
}

</style>
<div style="margin: 5px" id="teacherInfoForm">

	<div id="conditionsOfTeaInfo" class="easyui-panel" title="综合查询"
		style="border: none">
		<div style="margin: 10px;">
			<span> <span>工号:</span> <input
				class="easyui-validatebox textbox" id="code"
				style="width: 100px; height: 18px; padding: 5px">
			</span>&nbsp; <span> <span>姓名:</span> <input
				class="easyui-validatebox textbox" id="name"
				style="width: 100px; height: 18px; padding: 5px">
			</span>&nbsp; <span> <span>职位:</<span> <!-- 	<select class="easyui-combobox" id="nowPosition" data-options="editable:false,panelHeight:'auto'">
					<option value="0">请选择</option>
				</select> --> <input class="easyui-validatebox textbox"
						id="nowPosition" style="width: 100px; height: 18px; padding: 5px">
				</span>&nbsp; <strong style=""> <a href="javascript:void(0)"
						class="easyui-linkbutton" data-options="plain:true"
						style="vertical-align: middle" iconCls="icon-search"
						onclick="searchTeacherInfo('#conditionsOfTeaInfo')">查询</a> <a
						href="javascript:void(0)" onclick="moreConditions()"
						class="easyui-linkbutton"
						id="moreBtn" data-options="plain:true">更多∨</a>
				</strong>
		</div>
		<div id="moreConditions" style="">
			<table style="margin: 1px auto 12px 10px;">
				<tr>
					<strong>
						<td style="float: right">职称:</td>
						<td><select class="easyui-combobox" id="titleType"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${titleType }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td style="float: right">部门:</td>
						<td><select class="easyui-combobox" id="departmentId"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${department }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td style="float: right">学历:</td>
						<td><select class="easyui-combobox" id="degreeType"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${degreeType }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td>政治面貌:</td>
						<td><select class="easyui-combobox" id="politicalFeature"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${politicalFeatureType }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
				</tr>
				<tr>
					<strong>
						<td style="float: right">性别:</td>
						<td><select class="easyui-combobox" id="sex"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${sex }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td>婚姻状况:</td>
						<td><select class="easyui-combobox" id="maritalStatus"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${maritalStatus }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td>户口性质:</td>
						<td><select class="easyui-combobox" id="householdType"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${householdType }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
					<strong>
						<td>在职状态:</td>
						<td><select class="easyui-combobox" id="positionType"
							data-options="editable:false,panelHeight:'auto'">
								<option value="0">请选择</option>
								<c:forEach items="${positionType }" var="item">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
						</select></td>
					</strong>
				</tr>
			</table>
		</div>
	</div>



	<!-- 导出花名册窗口 -->
	<div class="easyui-window" id="exportRoster"
		data-options="modal:true,closed:true,iconCls:'icon-print'"
		title="导出花名册" style="width: 620px; height: 460px;">

		<div class="easyui-panel" title="教职工基本信息" id="teacherItem"
			data-options="collapsible:true,iconCls:'icon-search',panelHeight:'auto'"
			style="border: 0px;">
			<table style="margin: 0px auto auto auto;width:100%">
				<tr>
					<td style="float:right"><b>姓名:</b></td>
					<td><input type="checkbox" name="name" id="name"></td>
					<td style="float:right"><b>编号:</b></td>
					<td><input type="checkbox" name="code" id="code"></td>
					<td style="float:right"><b>专业:</b></td>
					<td><input type="checkbox" name="majorId" id="majorId"></td>
					<td style="float:right"><b>职位:</b></td>
					<td><input type="checkbox" name="nowPosition" id="nowPosition"></td>
					<td style="float:right"><b>职称:</b></td>
					<td><input type="checkbox" name="titleType" id="titleType"></td>

				</tr>
				<tr>
					<td style="float:right"><b>职工类型:</b></td>
					<td><input type="checkbox" name="staffType" id="staffType"></td>
					<td style="float:right"><b>职位状态:</b></td>
					<td><input type="checkbox" name="positionType"
						id="positionType"></td>
					<td style="float:right"><b>参加工作日期:</b></td>
					<td><input type="checkbox" name="workStartTime"
						id="workStartTime"></td>
					<td style="float:right"><b>在本校任职日期:</b></td>
					<td><input type="checkbox" name="takeOfficeTime"
						id="takeOfficeTime"></td>
					<td style="float:right"><b>教师基本信息备注:</b></td>
					<td><input type="checkbox" name="remarkOfTeacher"
						id="remarkOfTeacher"></td>
				</tr>
			</table>
			<div>
				<a style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="notSelectAllTeacherItem('#exportRoster')">全不选</a> <a
					style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="selectAllTeacherItem('#exportRoster')">全选</a>
			</div>
		</div>
		<div class="easyui-panel" title="教职工教育经历信息" id="teacherEduExpItem"
			data-options="collapsible:true,iconCls:'icon-search',panelHeight:'auto'"
			style="border: 0px">
			<table style="margin: 0px auto auto auto;width:100%">
				<tr>
					<td style="float:right"><b>教育类型:</b></td>
					<td><input type="checkbox" name="educationType"
						id="educationType"></td>
					<td style="float:right"><b>毕业学校:</b></td>
					<td><input type="checkbox" name="school" id="school"></td>
					<td style="float:right"><b>所属专业:</b></td>
					<td><input type="checkbox" name="major" id="major"></td>
					<td style="float:right"><b>开始时间:</b></td>
					<td><input type="checkbox" name="startDate" id="startDate"></td>
					<td style="float:right"><b>结束时间:</b></td>
					<td><input type="checkbox" name="endDate" id="endDate"></td>
				</tr>
				<tr>
					<td style="float:right"><b>学历:</b></td>
					<td><input type="checkbox" name="degreeType" id="degreeType"></td>

					<td style="float:right"><b>教师教育经历备注:</b></td>
					<td><input type="checkbox" name="remarkOfTeacherEduExp"
						id="remarkOfTeacherEduExp"></td>
				</tr>
			</table>
			<div>
				<a style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="notSelectAllTeacherEduExpItem('#exportRoster')">全不选</a> <a
					style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="selectAllTeacherEduExpItem('#exportRoster')">全选</a>
			</div>
		</div>
		<div class="easyui-panel" title="教职工详细信息" id="teacherInfoItem"
			data-options="collapsible:true,iconCls:'icon-search',panelHeight:'auto'"
			style="border: 0px">
			<table style="margin: 0px auto auto auto;width:100%">
				<tr>
					<td style="float:right"><b>性别:</b></td>
					<td><input type="checkbox" name="sexType" id="sexType"></td>
					<td style="float:right"><b>出生日期:</b></td>
					<td><input type="checkbox" name="birthday" id="birthday"></td>
					<td style="float:right"><b>证件类型:</b></td>
					<td><input type="checkbox" name="idCardType" id="idCardType"></td>
					<td style="float:right"><b>证件号:</b></td>
					<td><input type="checkbox" name="idCard" id="idCard"></td>
					<td style="float:right"><b>国籍:</b></td>
					<td><input type="checkbox" name="countryId" id="countryId"></td>

				</tr>
				<tr>
					<td style="float:right"><b>民族:</b></td>
					<td><input type="checkbox" name="nationType" id="nationType"></td>
					<td style="float:right"><b>政治面貌:</b></td>
					<td><input type="checkbox" name="politicalFeatureType"
						id="politicalFeatureType"></td>
					<td style="float:right"><b>户籍:</b></td>
					<td><input type="checkbox" name="nativePlace" id="nativePlace"></td>
					<td style="float:right"><b>婚姻状况:</b></td>
					<td><input type="checkbox" name="maritalStatus"
						id="maritalStatus"></td>
					<td style="float:right"><b>户籍类型:</b></td>
					<td><input type="checkbox" name="householdType"
						id="householdType"></td>
				</tr>
				<tr>
					<td style="float:right"><b>家庭地址:</b></td>
					<td><input type="checkbox" name="familyAddress"
						id="familyAddress"></td>
					<td style="float:right"><b>邮编:</b></td>
					<td><input type="checkbox" name="postcode" id="postcode"></td>
					<td style="float:right"><b>家庭电话:</b></td>
					<td><input type="checkbox" name="familyPhone" id="familyPhone"></td>
					<td style="float:right"><b>工作电话:</b></td>
					<td><input type="checkbox" name="officePhone" id="officePhone"></td>
					<td style="float:right"><b>移动电话:</b></td>
					<td><input type="checkbox" name="mobilePhone" id="mobilePhone"></td>

				</tr>
				<tr>
					<td style="float:right"><b>电子邮箱:</b></td>
					<td><input type="checkbox" name="email" id="email"></td>
					<td style="float:right"><b>教职工详细信息备注:</b></td>
					<td><input type="checkbox" name="remarkOfTeacherInfo"
						id="remarkOfTeacherInfo"></td>
				</tr>
			</table>
			<div>
				<a style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="notSelectAllTeacherInfoItem('#exportRoster')">全不选</a> <a
					style="float: right;color:red" href="javascript:void(0)"
					class="easyui-linkbutton"
					onclick="selectAllTeacherInfoItem('#exportRoster')">全选</a>
			</div>
		</div>
		<div style="text-align: center; margin: 20px auto auto 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="exportRoster()">导出</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="closeExportWin()">关闭</a>
		</div>
	</div>

	<!-- 通过excel导入教师信息 -->
	<div class="easyui-window" id="addTeacherByExcel"
		data-options="modal:true,closed:true,iconCls:'icon-print'"
		title="excel表导入教职工信息" style="width: 520px; height: 200px">
		<div style="margin: 30px auto auto auto">
			<span style="color: red; margin-left: 20px">注意:请按照excel表模版的格式上传教职工信息，如未下载模版，请点击:</span>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-print" data-options="plain:true"
				onclick="downloadTeaModelExcel()">模板下载</a><br />
			<div style="margin: 30px auto auto 60px;">
				<input type="text" class="easyui-textbox" id="excelFileName"
					style="width: 250px; height: 25px;" editable="false"> <a
					onclick="$('#addTeacherByExcel').find('#teaFile').click()"
					class="easyui-linkbutton" iconCls="icon-search">浏览</a> <input
					type="file" name="teaFile" id="teaFile"
					style="position: absolute; display: none"
					onchange="$('#addTeacherByExcel').find('#excelFileName').textbox('setValue', this.value)" />
				<a onclick="uploadTeacherTotalInfoFile()" id="teaFileUpload"
					class="easyui-linkbutton" iconCls="icon-save">上传</a>
			</div>
		</div>
	</div>
	<!-- ------------------- -->
	<div id="teaInfoToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" data-options="plain:true"
			onclick="openTab('tea/openInputTeacherInfoTab.do', '教师信息录入')">基本信息录入</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" data-options="plain:true"
			onclick="openAddTeacherByExcel()">导入职工信息</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" data-options="plain:true"
			onclick="showTeacherInfoTab()">查看个人信息</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"
			data-options="plain:true" onclick="openEditTeacherTab()">编辑个人信息</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" data-options="plain:true"
			onclick="openInputTeaEduExpTab()">教育经历</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" data-options="plain:true"
			onclick="openResumeInfo('#teaInfoTable')">工作经历</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" data-options="plain:true"
			onclick="openInputTeaFamilyTab()">家庭成员</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-print" data-options="plain:true"
			onclick="openExportRoster()">导出花名册</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-print"
			data-options="plain:true" onclick="exportTotalInfo()">导出个人信息</a>
	</div>

	<table id="teaInfoTable" class="easyui-datagrid" pagination="true"
		rownumbers="true" singleSelect="false" data-options="pageSize:10"
		toolbar="#teaInfoToolbar"
		url="${contextPath}/tea/searchTeacherInfo.do">
		<!-- url="${contextPath}/tea/searchTeacherInfo.do" -->

		<thead>
			<tr>
				<th field="" checkbox="true"></th>
				<!-- 教师信息 -->
				<th field="code" align="center" width="80px">工号</th>
				<th field="nameOfTeacher" align="center" width="80px">姓名</th>
				<th field="sexTypeStr" align="center" width="60px">性别</th>
				<th field="birthday" align="center" width="100px">出生日期</th>
				<th field="maritalStatusStr" align="center" width="60px">婚姻状况</th>
				<th field="nationTypeStr" align="center" width="100px">民族</th>
				<th field="nowPosition" align="center" width="100px">职务</th>
				<th field="titleTypeStr" align="center" width="160px">职称</th>
				<th field="school" align="center" width="">毕业学校</th>
				<th field="degreeTypeStr" align="center" width="100px">学历</th>
				<th field="workStartTime" align="center" width="100px">从教日期</th>
				<th field="politicalFeatureTypeStr" align="center" width="100px">政治面貌</th>
				<th field="idCard" align="center" width="160px">身份证号</th>
				<th field="departmentIdStr" align="center" width="100px">部门</th>
				<th field="positionTypeStr" align="center" width="60px">在职状态</th>
			</tr>
		</thead>
	</table>
</div>

<script type="text/javascript">
	$(function() {
		$('#moreConditions').panel({
			//		title:"更多条件",
			border : false,
			collapse : true,
			collapsed : true
		//		collapsible: true
		});
		//	$('#moreConditions').panel('open');
	})

	//点击更多条件按钮
	function moreConditions() {
		if ($('#moreBtn').text() == '更多∨') { //折叠状态
			$('#moreBtn').text("收起∧");
			//	$('#moreBtn').css({padding: '2px 5px'});
			$('#moreConditions').panel('expand', true);
		} else {
			$('#moreBtn').text("更多∨");
			//	$('#moreBtn').css({padding: '2px'});
			$('#moreConditions').panel('collapse', true);
		}

	}

	//打开window
	function openEditTeacherTab() {
		var rows = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (rows.length == 0)
			$.messager.alert("操作提示", "请先选择一条教职工信息!", "warning");
		else if (rows.length > 1)
			$.messager.alert("操作提示", "显示/编辑 每次只能选择一条教职工信息!", "warning");
		else {
			//js填写完整信息
			//		console.log(rows[0]);
			if ($('#main').tabs('exists', '教职工信息编辑')) {
				$('#main').tabs('close', '教职工信息编辑');
			}
			openTab("tea/openEditTeacherTotalInfo.do?teacherId="
					+ rows[0].idOfTeacher, "教职工信息编辑");
			//		//打开显示
		}
	}

	//关闭
	function closeWin() {
		$('#showAndEditWindow').window('close');
	}
	//查询
	function searchTeacherInfo(form) {

		var code = $(form).find('#code').val();
		var name = $(form).find('#name').val();
		var nowPosition = $(form).find('#nowPosition').val();
		var titleType = $(form).find('#titleType').combobox('getValue');
		var department = $(form).find('#departmentId').combobox('getValue');
		var degreeType = $(form).find('#degreeType').combobox('getValue');
		var politicalFeature = $(form).find('#politicalFeature').combobox(
				'getValue');
		var sex = $(form).find('#sex').combobox('getValue');
		var maritalStatus = $(form).find('#maritalStatus').combobox('getValue');
		var householdType = $(form).find('#householdType').combobox('getValue');
		var positionType = $(form).find('#positionType').combobox('getValue');

		/*	alert("工号: " + code + ", 姓名: " + name + ", 职位: " + nowPosition + ", 职称: " + titleType + 
					", 学历: " + degreeType + ", 政治面貌: " + politicalFeature + ", 性别: " + sex
					+ ", 婚姻状况: " + maritalStatus + ", 户籍类型: " + householdType + ", 在职状态: " + positionType );*/
		var param = {
			//	tea: {
			code : code,
			name : name,
			nowPosition : nowPosition,
			titleType : titleType,
			positionType : positionType,
			//	},
			//teaInfo: {
			degreeType : degreeType,
			politicalFeatureType : politicalFeature,
			sexType : sex,
			maritalStatus : maritalStatus,
			householdType : householdType,
			//	}
			//user
			departmentId : department

		}

			$('#teacherInfoForm').find('#teaInfoTable').datagrid({
				url: '${contextPath}/tea/searchTeacherInfo.do',
				/* queryparams : {
					dto: param
				} */
				queryParams: param
			});
		/* $.post("${contextPath}/tea/searchTeacherInfo.do", param,
				function(data) {
					var obj = eval('(' + data + ')');
					$('#teacherInfoForm').find('#teaInfoTable').datagrid(
							'loadData', obj);
				}); */

	}

	//打开导出花名册窗口
	function openExportRoster() {
		var rows = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (rows.length == 0) {
			$.messager.alert("操作提示", "至少选中一条教职工信息!", "warning");
		} else {
			$('#exportRoster').window('open');
		}
	}
	//关闭导出花名册窗口
	function closeExportWin() {
		$('#exportRoster').window('close');
	}
	//导出花名册
	function exportRoster() {
		//	alert("导出");	
		//获取参数
		var idArr = new Array();
		var rows = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		for (var i = 0; i < rows.length; ++i) {
			idArr[i] = rows[i].idOfTeacher;
			//	alert(idArr[i]);
		}
		var param = {
			//所有选中id
			idArr : idArr,
			//教师基本信息
			name : $('#exportRoster').find('#teacherItem').find('#name')[0].checked,
			code : $('#exportRoster').find('#teacherItem').find('#code')[0].checked,
			majorId : $('#exportRoster').find('#teacherItem').find('#majorId')[0].checked,
			nowPosition : $('#exportRoster').find('#teacherItem').find(
					'#nowPosition')[0].checked,
			titleType : $('#exportRoster').find('#teacherItem').find(
					'#titleType')[0].checked,
			staffType : $('#exportRoster').find('#teacherItem').find(
					'#staffType')[0].checked,
			positionType : $('#exportRoster').find('#teacherItem').find(
					'#positionType')[0].checked,
			workStartTime : $('#exportRoster').find('#teacherItem').find(
					'#workStartTime')[0].checked,
			takeOfficeTime : $('#exportRoster').find('#teacherItem').find(
					'#takeOfficeTime')[0].checked,
			remarkOfTeacher : $('#exportRoster').find('#teacherItem').find(
					'#remarkOfTeacher')[0].checked,
			//教师教育经历信息
			educationType : $('#exportRoster').find('#teacherEduExpItem').find(
					'#educationType')[0].checked,
			school : $('#exportRoster').find('#teacherEduExpItem').find(
					'#school')[0].checked,
			major : $('#exportRoster').find('#teacherEduExpItem')
					.find('#major')[0].checked,
			startDate : $('#exportRoster').find('#teacherEduExpItem').find(
					'#startDate')[0].checked,
			endDate : $('#exportRoster').find('#teacherEduExpItem').find(
					'#endDate')[0].checked,
			degreeType : $('#exportRoster').find('#teacherEduExpItem').find(
					'#degreeType')[0].checked,
			remarkOfTeacherEduExp : $('#exportRoster').find(
					'#teacherEduExpItem').find('#remarkOfTeacherEduExp')[0].checked,
			//教师
			sexType : $('#exportRoster').find('#teacherInfoItem').find(
					'#sexType')[0].checked,
			birthday : $('#exportRoster').find('#teacherInfoItem').find(
					'#birthday')[0].checked,
			idCardType : $('#exportRoster').find('#teacherInfoItem').find(
					'#idCardType')[0].checked,
			idCard : $('#exportRoster').find('#teacherInfoItem')
					.find('#idCard')[0].checked,
			countryId : $('#exportRoster').find('#teacherInfoItem').find(
					'#countryId')[0].checked,
			nationType : $('#exportRoster').find('#teacherInfoItem').find(
					'#nationType')[0].checked,
			politicalFeatureType : $('#exportRoster').find('#teacherInfoItem')
					.find('#politicalFeatureType')[0].checked,
			nativePlace : $('#exportRoster').find('#teacherInfoItem').find(
					'#nativePlace')[0].checked,
			maritalStatus : $('#exportRoster').find('#teacherInfoItem').find(
					'#maritalStatus')[0].checked,
			householdType : $('#exportRoster').find('#teacherInfoItem').find(
					'#householdType')[0].checked,
			familyAddress : $('#exportRoster').find('#teacherInfoItem').find(
					'#familyAddress')[0].checked,
			postCode : $('#exportRoster').find('#teacherInfoItem').find(
					'#postcode')[0].checked,
			familyPhone : $('#exportRoster').find('#teacherInfoItem').find(
					'#familyPhone')[0].checked,
			officePhone : $('#exportRoster').find('#teacherInfoItem').find(
					'#officePhone')[0].checked,
			mobilePhone : $('#exportRoster').find('#teacherInfoItem').find(
					'#mobilePhone')[0].checked,
			email : $('#exportRoster').find('#teacherInfoItem').find('#email')[0].checked,
			remarkOfTeacherInfo : $('#exportRoster').find('#teacherInfoItem')
					.find('#remarkOfTeacherInfo')[0].checked
		};

		//	console.log(param)
		//至少选中一个
		var allC = $('#exportRoster').find('input');
		var flag = false;
		for (var i = 0; i < allC.length; ++i) {
			//	alert(allC[i].checked);
			if (allC[i].checked) {
				flag = true;
				break;
			}
		}
		if (flag)
			$
					.post(
							'${contextPath}/tea/exportRoster.do',
							param,
							function(data) {
								if (data != "0") {
									var filename = escape(data);
									window
											.open("${contextPath}/tea/toDownloadExportRoster.do?file="
													+ encodeURI(filename));
								}
							});
		else
			$.messager.alert("操作提示", "至少选中一条教职工信息!", 'warning');
	}

	//导出个人信息
	function exportTotalInfo() {

		var rows = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (rows.length < 1) {
			$.messager.alert("操作提示", "请先选择一条教职工信息!", "warning");
		} else if (rows.length > 1) {
			$.messager.alert("操作提示", "每次导出只能选择一条教职工信息!", "warning");
		} else {
			$.post(
							'${contextPath}/tea/isAddTeacherEduExp.do',
							{
								teacherId : rows[0].idOfTeacher
							},
							function(data) {
								var obj = eval('(' + data + ')');
								if (obj.result == 0) {
									$.messager.alert("操作提示", "请先将教育经历信息补充完整!",
											"warning");
								} else if (obj.result == 1) {
									window.open('${contextPath}/tea/exportPersonalInfo.do?teacherId='
													+ rows[0].teacherId);
								}
							});
		}
	}
	//教师基本信息全选
	function selectAllTeacherItem(form) {
		var win = $(form).find('#teacherItem');
		win.find('input').each(function() {
			this.checked = true;
		});
	}
	//教师基本信息全不选
	function notSelectAllTeacherItem(form) {
		var win = $(form).find('#teacherItem');
		win.find('input').each(function() {
			this.checked = false;
		});
	}
	//教师教育经历信息全选
	function selectAllTeacherEduExpItem(form) {
		var win = $(form).find('#teacherEduExpItem');
		win.find('input').each(function() {
			this.checked = true;
		});
	}
	//教师教育经历信息全不选
	function notSelectAllTeacherEduExpItem(form) {
		var win = $(form).find('#teacherEduExpItem');
		win.find('input').each(function() {
			this.checked = false;
		});
	}
	//教师详细信息全选
	function selectAllTeacherInfoItem(form) {
		var win = $(form).find('#teacherInfoItem');
		win.find('input').each(function() {
			this.checked = true;
		});
	}
	//教师详细信息全不选
	function notSelectAllTeacherInfoItem(form) {
		var win = $(form).find('#teacherInfoItem');
		win.find('input').each(function() {
			this.checked = false;
		});
	}
	//打开导入教师信息窗口
	function openAddTeacherByExcel() {
		$('#addTeacherByExcel').window('open');

	}
	//下载教师excel模板
	function downloadTeaModelExcel() {
		window.open('${contextPath}/tea/downloadTeaModelExcel.do');
	}
	//打开显示教师信息tab
	function showTeacherInfoTab() {
		var row = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择一条教职工信息!", "warning");
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "每次显示只能选择一条教职工信息!", "warning");
		} else {
			var name = row[0].nameOfTeacher;
			var id = row[0].idOfTeacher;
			//		alert(name + ", " + id);
			if ($('#main').tabs('exists', '教师信息')) {
				$('#main').tabs('close', '教师信息');
			}
			openTab('tea/openTeacherInfoTab.do?id=' + id, '教师信息');
		}

	}
	function openInputTeaEduExpTab() {
		var row = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择一条教职工信息!", "warning");
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "每次显示只能选择一条教职工信息!", "warning");
		} else {
			//searchTeacherEduExpList<!--  -->openInputTeacherEduExpTab
			//		openTab('tea/searchTeacherEduExpList.do?teacherId='
			//			+ row[0].idOfTeacher, row[0].nameOfTeacher + '教育经历录入');
			if ($('#main').tabs('exists', '教育经历')) {
				$('#main').tabs('close', '教育经历');
				//	closeTab(tab);
			}
			openTab('tea/openTeacherEduExpPage.do?id=' + row[0].idOfTeacher,
					'教育经历');
		}
	}
	
	function openInputTeaFamilyTab() {
		var row = $('#teacherInfoForm').find('#teaInfoTable').datagrid(
				'getSelections');
		if (row.length == 0) {
			$.messager.alert("操作提示", "请先选择一条教职工信息!", "warning");
		} else if (row.length > 1) {
			$.messager.alert("操作提示", "每次显示只能选择一条教职工信息!", "warning");
		} else {
				$('#main').tabs('close', '家庭信息');
				openTab('tea/teaFamilyList.do?id=' + row[0].idOfTeacher,
				'家庭信息');
			}
		
	}
	
 
	//上传
	function uploadTeacherTotalInfoFile() {
		if ($('#addTeacherByExcel').find('#excelFileName').textbox('getValue')
				.trim() == '')
			$.messager.alert('操作提示', '请先选择文件!', 'warning');
		else {
			$.messager.progress({
				title : '操作提示',
				text : '正在上传...'
			});
			//			alert('哈哈');
			//ajaxFileUpload组件上传文件
			$.ajaxFileUpload({
						url : 'tea/importTeacherTotalInfoByExcel.do',
						//		type : 'post',
						fileElementId : 'teaFile',
						secureuri : false,
						dataType : 'text',
						success : function(data, status) {
						//	alert(data);
							data = data.replace("<html>", "");
							data = data.replace("</html>", "");
							data = data.replace(/<pre>|<pre[\s\S]+?>/, "");
							data = data.replace("<pre>", "");
							data = data.replace("</pre>", "");
							data = data.replace("<body>", "");
							data = data.replace("</body>", "");
							$.messager.progress('close');
							//		alert(data);
							//		console.log(data);
							//		console.log(data);
							var obj = eval('(' + data + ')');
							//		console.log(obj);
						//	obj.result = Long.valueOf(obj.result);
						//	alert(obj.result)
							if (obj.result > 1000010000) {
						//		alert("进入!" +  Math.floor(obj.result/10000) + ", ");
								$.messager.alert("操作提示", "成功录入 " + Math.floor(obj.result/100000)%10000 + " 名教职工, 更新 " + 
										obj.result%10000 + " 名教职工!", "info");
								$('#teacherInfoForm').find('#teaInfoTable')
								.datagrid('reload');   
							} else if (obj.result >= 10000) {
								$.messager.alert("操作提示", "成功更新 " + obj.result%10000
										+ " 名教师信息!", "info");
								$('#teacherInfoForm').find('#teaInfoTable')
										.datagrid('reload');
							} else if (obj.result > 0) {
								$.messager.alert("操作提示", "成功录入 " + obj.result
										+ " 名教师信息!", "info");
								$('#teacherInfoForm').find('#teaInfoTable')
										.datagrid('reload');
							} else if (obj.result == -1) {
								$.messager.alert("操作提示", "上传的文件格式不正确!",
										"warning");
							} else if (obj.result == -2) {
								$.messager.alert("操作提示", "暂不支持Excel 2007!",
										"warning");
							} else if (obj.result == -3) {
								$.messager.alert("操作提示", "教职工信息格式错误!请检查!",
										"warning");
							} else if (obj.result == -4) {
								$.messager.alert("操作提示", "文件上传失败!请稍后再尝试!",
										"warning");  
							} else if (obj.result == -5) {
								$.messager.alert("操作提示", "模板格式错误!请重新下载!",
								"warning"); 
							} else if (obj.result < -10000) {
								$.messager.alert("操作提示", "第 " + (obj.result*-1)%10000 + " 行的部门不存在!<br>请检查!",
								"warning"); 
							} else if (obj.result < -1000) {
								$.messager.alert("操作提示", "第 " + (obj.result*-1)%1000 + " 行的所属专业不存在!<br>请检查!",
								"warning"); 
							} 
						}
					//		error: function(data, status, e) {
					//			$.messager.alert("操作提示","访问失败!\n请检查网络是否连接。", "warming");
					//		}
					})     
			$('#addTeacherByExcel').find('#excelFileName').textbox('setValue',
					'')
		}
		
	}
	
	//打开简历信息列表
	function openResumeInfo(datagrid){
		var row = $(datagrid).datagrid('getSelected');
		if (row){
			openTab('tea/toResumeList.do?id='+row.id,
					'教职工简历信息列表');
		} else{
			$.messager.alert('操作提示', '请先选择一条教职工信息!', 'warning');
		}
	}
</script>