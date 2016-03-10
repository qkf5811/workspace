<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style scoped type="text/css">
#teachTaskToolbar #findMoreBtn {
	text-decoration: none
}

#teachTaskToolbar #findMoreBtn:hover {
	color: red;
}
</style>
<div style="width: 99%; height: auto">
	<div id="teachTaskToolbar" style="padding: 5px; height: auto" 
		>
		<div>	
			<input id="studyYearId1" name="studyYearId1" type="hidden"
					/>
			<input id="termTypeId1" name="termTypeId1" type="hidden"
					 />		
			<td>课程名称：</td>
					<td><input class="easyui-validatebox textbox" id="courseName"
					name="courseName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
					</td> 
			<td>年级:</td>				
			<td>
				<select class="easyui-combobox" id="grade" name="grade" 
					data-options="editable:false,panelHeight: 'auto',panelWidth: '105px'"
					style="width: 105px; height: 33px; padding: 5px">
					<option value="请选择">请选择</option> 
					<c:forEach items="${gradeList }" var="m">
						<option value="${m.id }">${m.name }</option>
					</c:forEach>
				</select>
			</td> 

			<button href="#" class="easyui-linkbutton" plain="true" id="search"
				onclick="searchTeachTask('#teachTaskToolbar', '#teachTaskList')"
				iconCls="icon-search">查询</button>
				
		</div>
		
		
	</div>
	<table id="teachTaskList" class="easyui-datagrid"
		style="width: auto;" pagination="true"
		toolbar="#teachTaskOperToolbar" rownumbers="true"
		singleSelect="true" data-options="pageSize:10">
		<thead>
			<tr>
				<th field="studyYearDateStr" width="250" align="center">学年日期</th>
				<th field="termTypeStr" width="100" align="center">学期类型</th>
				<th field="courseName" width="120" align="center">课程名称</th>
				<th field="grade" width="90" align="center">所属年级</th>
				<th field="className" width="100" align="center">上课班级</th>
				<th field="teacherNames" width="100" align="center">任课老师姓名</th>
				<th field="courseSeq" width="60" align="center">课程序号</th>
				<th field="courseTypeStr" width="60" align="center">课程类型</th>
				<th field="examineTypeStr" width="60" align="center">考核方式</th>
				<th field="credit" width="60" align="center">学分</th>
				<th field="hours" width="60" align="center">学时</th>
			</tr>
		</thead>
	</table>
	<div id="teachTaskOperToolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="$('#createTeachTask').window('open');">读取教学任务</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="toEditTeachTask()">编辑</a>
	</div>
	
	 <!-- 弹出新建角色的窗口 -->
    <div id="createTeachTask" class="easyui-window" title="读取教学任务" data-options="modal:true,iconCls:'icon-add',closed:true"
         style="width:345px;height:180px;padding:5px;">
        <form id="createTeachTaskForm" method="post">

            <table text-align="center" cellspacing="10">
       
				<div style="margin-bottom: 20px">
					<td>学年:</td>
					<td><select class="easyui-combobox" id="studyYearId"
						name="studyYearId"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true"
						validtype="selectRequired['studyYearId']"
						style="width: 76px; height: 30px;">
							<option value="">请选择</option>
							<c:forEach items="${studyYearList}" var="teaChangeType">
							<option value="${teaChangeType.id}">${teaChangeType.name}</option>
							</c:forEach>
					</select></td>
				</div>
	
			
		
				<div style="margin-bottom: 20px">
					<td>学期类型:</td>
					<td><select class="easyui-combobox" id="termType"
						name="termType"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '67px',novalidate:true"
						validtype="selectRequired['termType']"
						style="width: 80px; height: 30px;">
							<option value="">请选择</option>
							<c:forEach items="${termTypeList}" var="teaChangeType">
							<option value="${teaChangeType.id}">${teaChangeType.name}</option>
							</c:forEach>
					</select></td>
				</div>
	
            
            
             <%--   <td >学年:</td>
				<td><select class="easyui-combobox" id="studyYearId"
					data-options="editable:false,panelHeight:'auto',novalidate:true"validtype="selectRequired['studyYearId']" style="width: 80px; height: 30px;">
					<option value="0">请选择</option>
					<c:forEach items="${studyYearList }" var="item">
					<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>
				<td >学期类型:</td>
				<td><select class="easyui-combobox" id="termType"
					data-options="editable:false,panelHeight:'auto',novalidate:true" validtype="selectRequired['termType']" style="width: 76px; height: 30px;">
					<option value="0">请选择</option>
					<c:forEach items="${termTypeList }" var="item">
					<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select></td>	 --%>
               
            </table>


        </form>

        <div style="text-align: center;margin:25px 0 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="createTeachTask('#createTeachTask', '#teachTaskList')" style="margin-right:20px;"> <span
                    style="font-size: 14px;">读取</span>
            </a><a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="cancel();"> <span
                style="font-size: 14px;"> 取消</span>
        	</a>
        </div>
    </div>
</div>

<script type="text/javascript">
	$(function() {
		 $.messager.alert("温馨提示", "查询前请点击“读取教学任务”按钮，选择您要读取或生成的教学任务信息", "info");
		
		 /*
			专业和方向的二级联动 
			*/
			$('#major').combobox({
			onSelect : function(){
				var majorId = $('#teachTaskToolbar')
						.find('#major').combobox('getValue');
				if (majorId != '请选择' || majorId != null ){
					$('#field').combobox({
						url : 'edu/getFieldByMajorId.do?majorId=' + majorId,
						valueField : 'id',
						textField : 'name',
						value : '请选择'
					});
				} else{
					$('#field').combobox('setValue','请选择');
					
				}
			}
			});

		function setTeachTaskDefaultListBySetTimeout(){
			$("#teachTaskList").datagrid('loadData',{total:0,rows:[]});
		}

		setTimeout(setTeachTaskDefaultListBySetTimeout,200);


	});
	
	function cancel(){
		$('#createTeachTask').window('close');
		$('#createTeachTaskForm').form('clear');
		$('#createTeachTaskForm').find('#studyYearId').combobox('setValue','请选择');
		$('#createTeachTaskForm').find('#termType').combobox('setValue','请选择');
	}
	function createTeachTask(toolbar, datagrid) {
		//在提交数据之前执行表单验证
		$('#createTeachTaskForm').form('enableValidation').form('validate');

		//判断表单验证是否通过
		if (!$('#createTeachTaskForm').form('validate')) {
			return false;
		}

		
		var studyYearId = $(toolbar).find('#studyYearId').combobox('getValue');
		var termType = $(toolbar).find('#termType').combobox('getValue');
		$('#teachTaskToolbar').find('#studyYearId1').val(studyYearId);
		$('#teachTaskToolbar').find('#termTypeId1').val(termType);
		if(termType!=0 && studyYearId!=0) {
			$(datagrid).datagrid({
				url : "${contextPath}/edu/getTeachTaskList.do",
				queryParams: {
					termType:termType,
					studyYearId:studyYearId
					
				}
			});
		}else {
			 $.messager.alert("操作提示", "请选择学年和学期类型！", "warning");
		}
		$('#createTeachTask').window('close');
		/* $('#createTeachTaskForm').form('clear');
		$('#createTeachTaskForm').find('#studyYearId').combobox('setValue','请选择');
		$('#createTeachTaskForm').find('#termType').combobox('setValue','请选择'); */
		
	}
	
	function searchTeachTask(toolbar, datagrid) {
		
		var studyYearId = $(toolbar).find('#studyYearId1').val();
		var termType = $(toolbar).find('#termTypeId1').val();
		var courseName = $(toolbar).find("#courseName").val();
		var grade = $(toolbar).find("#grade").combobox('getValue');
		
		//!-AJAX请求数据
		if(isNaN(grade)) {
			grade =0;
		}
		if(termType!=0 && studyYearId!=0) {
			$(datagrid).datagrid({
				url : "${contextPath}/edu/getTeachTaskList.do",
				queryParams: {
					termType:termType,
					studyYearId:studyYearId,
					courseName : courseName,
					grade : grade
				}
			});
		}else {
			 $.messager.alert("操作提示", "请选择学年和学期类型！", "warning");
		}
		
	}
	





	function toEditTeachTask() {

		
		var row = $('#teachTaskList').datagrid('getSelected');
		
		/* var courseName = $('#teachTaskToolbar').find("#courseName").val();
		var major = $('#teachTaskToolbar').find("#major").val();
		var field = $('#teachTaskToolbar').find("#field").val();
		var grade = $('#teachTaskToolbar').find("#grade").val();
		var className = $('#teachTaskToolbar').find("#className").val();
		var courseSeq = $('#teachTaskToolbar').find("#courseSeq").val();
		var examineTypeStr = $('#teachTaskToolbar').find("#examineTypeStr").val();
		var courseTypeStr = $('#teachTaskToolbar').find("#courseTypeStr").val();
		var credit = $('#teachTaskToolbar').find("#credit").val();
		var hours = $('#teachTaskToolbar').find("#hours").val(); */
		if (row) {
			openTab('edu/toEditTeachTask.do?id=' + row.id + "&termType=" + row.termType+ "&courseId=" + row.courseId+ "&coursePlanId=" + row.coursePlanId+ "&teacherId1=" + row.teacherId1+ "&teacherId2=" + row.teacherId2
					+ "&studyYearId=" + row.studyYearId+ "&courseName=" + row.courseName+ "&major=" 
					+ row.major+ "&grade=" + row.grade+ "&classId=" + row.classId+ "&className=" + row.className+ "&field=" + row.field+ "&courseSeq=" + row.courseSeq+ "&teacherNames=" + row.teacherNames, '编辑教学任务信息');
		}else {
			$.messager.alert("操作提示", "请先选择一行!", "warning");
		}
	}

</script>
