<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="width: 99%; height: auto" id="teacherTotalInfoGrid">
	<input id="idOfTeacher" name="idOfTeacher" type="hidden"
	   	value="<c:out value='${id}'/>" />
	<table style="width:99%" id="teacherTotalInfoDetailList" class="easyui-propertygrid" style="width:325px" data-options="

				showGroup:true,
				scrollbarSize:0,
				showHeader:false
				">

	</table>

</div>
<script>
	$(function () {
		getTeacherTotalInfoById();
	})
	
	function getTeacherTotalInfoById() {
		var id = $('#idOfTeacher').val();
		$.post('${contextPath}/tea/getTeacherTotalInfoListByTeacherId.do', {
			id : id
		}, function (data) {
			console.log(data)
			
			var rows="";
			rows+='{"name":"姓名","value":data.name, "group":"个人基本信息"}';
			rows+=',{"name":"性别","value":data.sexTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"工号","value":data.code, "group":"个人基本信息"}';
			rows+=',{"name":"担任职位","value":data.nowPosition, "group":"个人基本信息"}';
			rows+=', {"name":"职称","value":data.titleTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"教职工类型","value":data.staffTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"职位状态","value":data.positionTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"参加工作日期","value":data.workStartTime, "group":"个人基本信息"}';
			rows+=',{"name":"在本校任职日期","value":data.takeOfficeTime, "group":"个人基本信息"}';
			rows+=',{"name":"出生年月","value":data.birthday, "group":"个人基本信息"}';
			rows+=', {"name":"证件类型","value":data.idCardTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"证件号","value":data.idCard, "group":"个人基本信息"}';
			rows+=',{"name":"学历","value":data.degreeTypeStr, "group":"个人基本信息"}';
			rows+=', {"name":"国籍","value":data.countryIdStr, "group":"个人基本信息"}';
			rows+=', {"name":"民族","value":data.nationTypeStr, "group":"个人基本信息"}';
			rows+=', {"name":"政治面貌","value":data.politicalFeatureTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"籍贯","value":data.nativePlace, "group":"个人基本信息"}';
			rows+=', {"name":"婚姻状态","value":data.maritalStatusStr, "group":"个人基本信息"}';
			rows+=',{"name":"户籍类型","value":data.householdTypeStr, "group":"个人基本信息"}';
			rows+=',{"name":"家庭地址","value":data.familyAddress, "group":"联系信息"}';
			rows+=',{"name":"邮政编码","value":data.postcode, "group":"联系信息"}';
			rows+=',{"name":"家庭电话","value":data.familyPhone, "group":"联系信息"}';
			rows+=',{"name":"办公电话","value":data.officePhone, "group":"联系信息"}';
			rows+=',{"name":"移动电话","value":data.mobilePhone, "group":"联系信息"}';
			rows+=',{"name":"电子邮件","value":data.email, "group":"联系信息"}';
			rows+=',{"name":"教职工备注","value":data.remarkOfTeacher, "group":"备注信息"}';
			rows+=', {"name":"教职工基本信息备注","value":data.remark, "group":"备注信息"}';
			
			
			
			rows='['+rows+']';
			rows=eval(rows);
			$('#teacherTotalInfoDetailList').propertygrid('loadData', rows);
	//		console.log(data);
		}, 'json');
	}
</script>