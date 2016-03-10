<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<div style="margin: 5px" id="searchCoursePlanCondition">
		<span>年级:</span>
		<input class="easyui-textbox" id="gradeName" name="gradeName"
			style="width: 150px; height: 25px; padding: 10px; font-size: 15px" />
		<a class="easyui-linkbutton" iconCls="icon-search" id="showCoursePlan"
			data-options="plain:false">查询</a>
	</div>
	<form id="coursePlanForm">
		<div style="margin-bottom: 20px">
			<table class="easyui-datagrid" id="coursePlanList" pagination="true"
				toolbar="#coursePlanSettingToolbar"
				url="${contextPath}/edu/getCoursePlanList.do" rownumbers="true"
				singleSelect="true" data-options="pageSize:10">
				<thead>
					<tr>
						<th field="gradeName" width="100px" align="center">年级</th>
						<th field="termTypeStr" width="100px" align="center">学期</th>
						<th field="courseName" width="160px" align="center">课程名称</th>
						<th field="courseCode" width="100px" align="center">课程编号</th>
						<th field="courseTypeStr" width="75px" align="center">课程类型</th>
						<th field="examineTypeStr" width="75px" align="center">考核方式</th>
						<th field="credit" width="60px" align="center">课程学分</th>
						<th field="hours" width="60px" align="center">课程学时</th>
						<th field="remark" width="180px" align="center">课程计划备注</th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="coursePlanSettingToolbar">
			<div style="">
				<a class="easyui-linkbutton" iconCls="icon-add" id="addCoursePlan"
					data-options="plain:true" onclick="openNewCoursePlanDialog()">添加课程计划</a>
				<a class="easyui-linkbutton" iconCls="icon-edit" id="editCoursePlan"
					data-options="plain:true" onclick="openEditCoursePlanDialog()">修改课程计划</a>
				<a class="easyui-linkbutton" iconCls="icon-remove"
					id="delCoursePlan" data-options="plain:true"
					onclick="DeleteCoursePlanById()">删除课程计划</a>
			</div>
		</div>
	</form>
</div>



<!-- 弹出添加课程计划的窗口 -->
<div id="newCoursePlanDialog" class="easyui-dialog" title="添加课程计划"
	data-options="modal:true,iconCls:'icon-add',closed:true , buttons:'#addCoursePlanBtn'"
	style="width: 480px; height: 600px; padding: 5px;">
	<form id="newCoursePlanForm" method="post">
		<table cellpadding="7" align="center">
			<tr>
				<td>课程名称:</td>
				<td><select class="easyui-combobox" id="courseSelect"
					name="courseSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: '150px'" validtype="selectRequired['courseSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${courseList}" var="course">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>年级:</td>
				<td><select class="easyui-combobox" id="gradeSelect"
					name="gradeSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['gradeSelect']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${gradeList}" var="grade">
							<option value="${grade.id}">${grade.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>学期类型:</td>
				<td><select class="easyui-combobox" id="termTypeSelect"
					name="termTypeSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['termTypeSelect']"
					editable="false" >
						<option value="">请选择</option>
						<c:forEach items="${termTypeList}" var="termType">
							<option value="${termType.id}">${termType.name}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>课程类型:</td>
				<td><select class="easyui-combobox" id="courseTypeSelect"
					name="courseTypeSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['courseTypeSelect']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${courseTypeList}" var="courseType">
							<option value="${courseType.id}">${courseType.name}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>考核方式:</td>
				<td><select class="easyui-combobox" id="examineTypeSelect"
					name="examineTypeSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['examineTypeSelect']"   
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${examineTypeList}" var="examineType">
							<option value="${examineType.id}">${examineType.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>课程学分:</td>
				<td><input class="easyui-numberbox"
					id="creditSetting" name="creditSetting"
					data-options="validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-3',precision:1 "
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>

			<tr>
				<td>课程学时:</td>
				<td><input class="easyui-numberbox" id="hourSetting"
					name="hourSetting"
					data-options="validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-3' "
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>

			<tr>
				<td>备注:</td>
				<td><textArea type="textarea" rows="5" cols="50"
						id="coursePlanRemark" name="coursePlanRemark"
						style="width: 200px; height: 60px; padding: 8px; font-size: 15px; border-radius: 5px; font-family: '微软雅黑'"></textArea>

				</td>
			</tr>

		</table>
	</form>

	<div id="addCoursePlanBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewCoursePlan()">添加</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="clearNewCoursePlanForm()">重置</a>
	</div>
</div>



<!-- 弹出修改课程计划的窗口 -->
<div id="editCoursePlanDialog" class="easyui-dialog" title="修改课程计划"
	data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editCoursePlanBtn'"
	style="width: 480px; height: 600px; padding: 5px;">
	<form id="editCoursePlanForm" method="post">
		<table cellpadding="7" align="center">
			<input id="editCoursePlanId" type="hidden">

			<tr>
				<td>课程名称:</td>
				<td><select class="easyui-combobox" id="editCourse"
					name="editCourse" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: '150px'" validtype="selectRequired['editCourse']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${courseList}" var="course">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>年级:</td>
				<td><select class="easyui-combobox" id="editGrade"
					name="editGrade" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editGrade']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${gradeList}" var="grade">
							<option value="${grade.id}">${grade.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>学期类型:</td>
				<td><select class="easyui-combobox" id="editTermType"
					name="editTermType" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editTermType']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${termTypeList}" var="termType">
							<option value="${termType.id}">${termType.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>课程类型:</td>
				<td><select class="easyui-combobox" id="editCourseType"
					name="editCourseType" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editCourseType']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${courseTypeList}" var="courseType">
							<option value="${courseType.id}">${courseType.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>考核方式:</td>
				<td><select class="easyui-combobox" id="editExamineType"
					name="editExamineType" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['editExamineType']"
					editable="false" >
					    <option value="">请选择</option>
						<c:forEach items="${examineTypeList}" var="examineType">
							<option value="${examineType.id}">${examineType.name}</option>
						</c:forEach>
					</select></td>
			</tr>

			<tr>
				<td>课程学分:</td>
				<td><input class="easyui-numberbox" id="editCredit"
					name="editCredit"
					data-options="validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-3' ,precision:1"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>

			<tr>
				<td>课程学时:</td>
				<td><input class="easyui-numberbox" id="editHours"
					name="editHours"
					data-options="validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-3' "
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />

				</td>
			</tr>

			<tr>
				<td>备注:</td>
				<td><textArea type="textarea" rows="5" cols="50"
						id="editCoursePlanRemark" name="editCoursePlanRemark"
						style="width: 200px; height: 60px; padding: 8px; font-size: 15px; border-radius: 5px; font-family: '微软雅黑'"></textArea>

				</td>
			</tr>

		</table>
	</form>

	<div id="editCoursePlanBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updateCoursePlan()">确认</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="$('#editCoursePlanDialog').dialog('close');disableValidationAtEdit();">取消</a>

			
	</div>
</div>
<!-- *****************************************************************************************************************************-->



<script type="text/javascript">

/********************************点击查询按钮后执行动作******************************/
 
 $(function() {
		$("#searchCoursePlanCondition").find('#showCoursePlan').click(
				function() {
					var gradeName = $('#searchCoursePlanCondition').find(
					'#gradeName').textbox('getValue');
					$('#coursePlanForm').find('#coursePlanList').datagrid({
						url : "${contextPath}/edu/getCoursePlanList.do",
						queryParams : {
							"gradeName" : gradeName
						}
					});
					//点击查询后重置查询条件
					//$('#searchCoursePlanCondition').find('#majorRefer').textbox({value:""});
				});

	})

/********************************弹出添加课程计划窗口****************************/
function openNewCoursePlanDialog() {
	//var majorId=null;
	$('#newCoursePlanDialog').dialog('open');
	//每次打开窗口后重置数据
	//$('#newCoursePlanForm').form('clear');
	//选择专业
	$('#newCoursePlanForm').find('#majorSelect').combobox({
		url : "sch/getMajorOfJson.do",
		valueField : 'id',
		textField : 'name',
		value : '请选择'
	});
	//选择专业方向	
	$('#newCoursePlanForm')
				.find('#majorSelect')
				.combobox(
						{
							onSelect : function() {
								var majorId = $('#newCoursePlanForm').find(
										'#majorSelect').combobox('getValue');
								if (majorId != '请选择') {
									$('#newCoursePlanForm')
											.find('#majorFieldSelect')
											.combobox(
													{
														url : "sch/getMajorFieldJsonByMajorId.do?majorId="
																+ majorId,
														valueField : 'id',
														textField : 'name',
														value : "请选择"
													});
								}								
								
							}
						});
	}


	//清空数据
	function clearNewCoursePlanForm() {
		
	//$('#newCoursePlanForm').form('clear');
		$('#newCoursePlanForm').find('#courseSelect').combobox('setValue',
				'请选择');
		$('#newCoursePlanForm').find('#gradeSelect')
				.combobox('setValue', '请选择');
		$('#newCoursePlanForm').find('#termTypeSelect').combobox('setValue',
				'请选择');
		$('#newCoursePlanForm').find('#courseTypeSelect').combobox('setValue',
				'请选择');
		$('#newCoursePlanForm').find('#examineTypeSelect').combobox('setValue',
				'请选择');
		$('#newCoursePlanForm').find('#creditSetting').numberbox('setValue',
		'');
		$('#newCoursePlanForm').find('#hourSetting').numberbox('setValue',
		'');
		$('#newCoursePlanForm').find('#coursePlanRemark').val("");
		
		//取消表单验证
		disableValidationAtNew();

	}

	//添加课程计划
	function addNewCoursePlan() {
		//在提交数据之前执行表单验证
		$('#newCoursePlanForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#newCoursePlanForm').form('validate'))
			return false;

		var courseId = $('#newCoursePlanForm').find('#courseSelect').combobox(
				'getValue');
		var gradeId = $('#newCoursePlanForm').find('#gradeSelect').combobox(
				'getValue');
		var termType = $('#newCoursePlanForm').find('#termTypeSelect')
				.combobox('getValue');
		var courseType = $('#newCoursePlanForm').find('#courseTypeSelect')
				.combobox('getValue');
		var examineType = $('#newCoursePlanForm').find('#examineTypeSelect')
				.combobox('getValue');
		var credit = $('#newCoursePlanForm').find('#creditSetting').val();
		var hours = $('#newCoursePlanForm').find('#hourSetting').val();
		var remark = $('#newCoursePlanForm').find('#coursePlanRemark').val();
		//alert("gradeId:"+gradeId+" ,"+"termType:" +termType+" ,"+"courseType:"+courseType+" ,"+"examineType:"+examineType);

		$.post('edu/addCoursePlan.do', {
			gradeId : gradeId,
			termType : termType,
			courseId : courseId,
			courseType : courseType,
			examineType : examineType,
			credit : credit,
			hours : hours,
			remark : remark
		},
				function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "课程计划添加成功!", "info");
						$('#newCoursePlanDialog').dialog('close');
						$('#coursePlanForm').find('#coursePlanList').datagrid(
								'reload');
						clearNewCoursePlanForm();
					}
				})
				//取消表单验证
				disableValidationAtNew();

	}
	
	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#newCoursePlanForm').form('disableValidation').form('validate');
		
	}

	//*********************************修改一行课程计划记录*****************************************
	function openEditCoursePlanDialog() {

		var row = $('#coursePlanList').datagrid('getSelected');
		if (row) {
			$('#editCoursePlanForm').find('#editCoursePlanId').val(row.id);

			$('#editCoursePlanForm').find('#editMajor').html(row.majorName);

			$('#editCoursePlanForm').find('#editMajorField').html(
					row.majorFieldName);

			//重新选择年级
			$('#editCoursePlanForm').find('#editGrade').combobox('select',
					row.gradeId);
			//重新选择课程
			$('#editCoursePlanForm').find('#editCourse').combobox('select',
					row.courseId);
			//重新设置学期类型
			$('#editCoursePlanForm').find('#editTermType').combobox('select',
					row.termType);
			//重新设置课程类型
			$('#editCoursePlanForm').find('#editCourseType').combobox('select',
					row.courseType);
			//重新设置考核方式
			$('#editCoursePlanForm').find('#editExamineType').combobox(
					'select', row.examineType);
			//重新设置学分.numberbox('setValue',data.grade.seq);
			$('#editCoursePlanForm').find('#editCredit').numberbox('setValue',row.credit);
			//重新设置学时
			$('#editCoursePlanForm').find('#editHours').numberbox('setValue',row.hours);
			//重新设置备注
			$('#editCoursePlanForm').find('#editCoursePlanRemark').val(
					row.remark);
			//打开窗口
			$('#editCoursePlanDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要修改的课程计划!", "warning");
	}

	function updateCoursePlan() {
		//在提交数据之前执行表单验证
		$('#editCoursePlanForm').form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$('#editCoursePlanForm').form('validate'))
			return false;

		var id = $('#editCoursePlanForm').find('#editCoursePlanId').val();
		var courseId = $('#editCoursePlanForm').find('#editCourse').combobox(
				'getValue');
		var gradeId = $('#editCoursePlanForm').find('#editGrade').combobox(
				'getValue');
		var termType = $('#editCoursePlanForm').find('#editTermType').combobox(
				'getValue');
		var courseType = $('#editCoursePlanForm').find('#editCourseType')
				.combobox('getValue');
		var examineType = $('#editCoursePlanForm').find('#editExamineType')
				.combobox('getValue');
		var credit = $('#editCoursePlanForm').find('#editCredit').val();
		var hours = $('#editCoursePlanForm').find('#editHours').val();
		var remark = $('#editCoursePlanForm').find('#editCoursePlanRemark')
				.val();

		$.post('edu/updateCoursePlan.do', {
			"id" : id,
			"courseId" : courseId,
			"gradeId" : gradeId,
			"termType" : termType,
			"courseType" : courseType,
			"examineType" : examineType,
			"credit" : credit,
			"hours" : hours,
			"remark" : remark
		},
				function(data) {
					//var obj = eval('(' + data + ')');
					var obj =  JSON.parse(data);
					if (obj.result == 1) {
						$.messager.alert("操作提示", "课程计划修改成功!", "info");
						$('#editCoursePlanDialog').dialog('close');
						$('#coursePlanForm').find('#coursePlanList').datagrid(
								'reload');
					}
				});
		//在提交数据之前取消表单验证
		disableValidationAtEdit();
	}
	
	//在提交数据之前取消表单验证
	function disableValidationAtEdit(){
		//在提交数据之前取消表单验证
		$('#editCoursePlanForm').form('disableValidation').form('validate');
		
	}

	
	//*********************************删除一行课程计划记录*****************************************		
	function DeleteCoursePlanById() {
		var row = $('#coursePlanList').datagrid('getSelected');
		if (row) {
			$.messager.confirm("请确认...", "您确定要删除此信息吗?", function(data) {
				if (data)
					$.post('edu/deleteCoursePlan.do', {
						id : row.id
					}, function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 1) {
							$.messager.alert("操作提示", "课程计划删除成功!", "info");
							$('#coursePlanForm').find('#coursePlanList')
									.datagrid('reload');
						}
					})
				else
					;
				//$.messager.alert("操作信息", "课程计划删除失败，请稍后再试!", "info");
			});
		} else
			$.messager.alert("操作提示", "请先选择一条需要删除的课程计划!", "warning");

	}
</script>
