<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
<input id="id" name="id" type="hidden"
	   value="<c:out value='${id}'/>" />
<table id="stuListDetail" class="easyui-propertygrid" style="width:325px" data-options="

				showGroup:true,
				scrollbarSize:0,
				showHeader:false
				">

</table>
</div>

<script type="text/javascript">
	$(function(){
		getStuListDetail();
	});

	function getStuListDetail(){
		var id=$("#id").val();
		$.post('stu/getStuListDetail.do',{
			"id":id
		},function(data){


			var rows=[{"name":"姓名","value":data.name,"group":"个人信息"},
				{"name":"性别","value":data.sex,"group":"个人信息"},
				{"name":"班级","value":data.className,"group":"个人信息"},
				{"name":"出生年月","value":data.birthday,"group":"个人信息"},
				{"name":"身份证","value":data.idCard,"group":"个人信息"},
				{"name":"民族","value":data.nation,"group":"个人信息"},
				{"name":"学号","value":data.code,"group":"个人信息"},
				{"name":"籍贯","value":data.nativePlace,"group":"个人信息"},
				{"name":"户口类型","value":data.householdTypeString,"group":"个人信息"},
				{"name":"户籍所在地","value":data.householdLocation,"group":"个人信息"},
				{"name":"政治面貌","value":data.politicalFeatureTypeString,"group":"个人信息"},
				{"name":"是否港澳","value":data.isHkMcString,"group":"个人信息"},
				{"name":"家庭住址","value":data.familyAddress,"group":"联系信息"},
				{"name":"邮政编码","value":data.postcode,"group":"联系信息"},
				{"name":"家庭电话","value":data.familyPhone,"group":"联系信息"},
				{"name":"考生类别","value":data.examineeTypeString,"group":"个人信息"},
				{"name":"毕业学校","value":data.graduationSchool,"group":"个人信息"},
				{"name":"入学总分","value":data.examTotalScore,"group":"个人信息"},
				{"name":"学习形式","value":data.studyTypeString,"group":"个人信息"},
				{"name":"入学方式","value":data.enterSchoolTypeString,"group":"个人信息"},
				{"name":"招生起点","value":data.eduStageTypeString,"group":"个人信息"},
				{"name":"注册状态","value":data.stuStatus,"group":"个人信息"},
				{"name":"学籍状态","value":data.studentStatusString,"group":"个人信息"}

			];
			$("#stuListDetail").propertygrid('loadData',rows);
		},"json")

	}
</script>

