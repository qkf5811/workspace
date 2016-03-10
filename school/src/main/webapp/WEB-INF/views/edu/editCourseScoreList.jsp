<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="width: 99%; height: auto">
<div id="editTeaCourseToolbar" style="padding: 5px; height: auto">
<input type="hidden" id="teaCourseId" value="${teaCourseId }">
<input type="hidden" id="classId" value="${classId }">

		<div>
			
			<td>学号：</td>
				<td><input class="easyui-validatebox textbox" id="code"
					name="code" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td> 
				
				
				<td>姓名：</td>
				<td><input class="easyui-validatebox textbox" id="userName"
					name="userName" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>
					
					
			
			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searcheditTeaCourse('#editTeaCourseToolbar', '#editTeaCourseList')"
				iconCls="icon-search">查询</button>
		</div>
		</div>
	<table id="editTeaCourseList" class="easyui-datagrid" style="width: auto;" toolbar="#editTeaCourseOpenToolbar"
		pagination="true" url="${contextPath}/edu/getEditCourseScoreList.do?teaCourseId=${teaCourseId }&classId=${classId}"
		 rownumbers="true" singleSelect="true"
		data-options="pageSize:10">
		<thead>
			<tr>
				<th field="code" width="15%" align="center">学号</th>
				<th field="name" width="10%" align="center">姓名</th>
				<c:if test="${type == 35001 }">
				<th field="hundredUsualScore" width="10%" align="center">平时</th>
				<th field="hundredExamScore" width="10%" align="center">考试</th>
				<th field="hundredTotalScore" width="10%" align="center">总评</th>
				</c:if>
				
				<c:if test="${type == 35002 }">
				<th field="gradeUsualStr" width="10%" align="center">平时</th>
				<th field="gradeExamStr" width="10%" align="center">考试</th>
				<th field="gradeTotalStr" width="10%" align="center">总评</th>
				</c:if>
				
				<th field="examNatureTypeStr" width="20%" align="center">考试性质</th>
			</tr>
		</thead>
	</table>

	<div id="editTeaCourseOpenToolbar">
		<a class="easyui-linkbutton" iconCls="icon-edit" 
			data-options="plain:true" onclick="editCourseScore()">修改</a>
	</div>
	
	
	<div id="editCourseScoreDialog" class="easyui-dialog" title="学生成绩修改修改"
		data-options="modal:true,iconCls:'icon-edit',closed:true,buttons:'#editCourseScoreBtn'"
		style="width: 300px; height: 380px; padding: 5px;">
		<form id="editCourseScoreForm" method="post">
		<input type="hidden"  id="editId" name="id">
			<table align="center">
				<tr height="10px">
				</tr>
				<tr>
					<input id="editCourseId" type="hidden" />
					<td>学号:</td>
					<td><span id="code"></span>
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>姓名:</td>
					<td><span id="name"></span>
					</td>
				</tr>
				<c:if test="${type == 35001 }">
				<tr height="7px">
				</tr>
				<tr>
					<td>平时成绩:</td>
					<td><input class="easyui-validatebox textbox" onblur="calculate()"
						id="hundredUsualScore" name="hundredUsualScore"  precision="2" min = "0"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入平时成绩',iconWidth:38,required:true,validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true ">
						
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>考试成绩:</td>
					<td><input class="easyui-validatebox textbox" onblur="calculate()"
						id="hundredExamScore" name="hundredExamScore"
						style="width: 150px; height: 18px; padding: 5px"
						data-options="prompt:'请输入考试成绩',iconWidth:38,required:true,validType:'length[1,3]',missingMessage:'该处未填写',novalidate:true ">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				
				<tr>
					<td>总平成绩:</td>
					<td><input class="easyui-validatebox textbox" readonly="readonly"
						id="hundredTotalScore" name="hundredTotalScore"
						style="width: 150px; height: 18px; padding: 5px">
					</td>
				</tr>
				<tr height="7px">
				</tr>
				</c:if>
				
				<c:if test="${type == 35002 }">
				<tr height="7px">
				</tr>
				<tr>
					<td>平时成绩:</td>
					<td>
					<select class="easyui-combobox" id="gradeUsualScore"
						name="gradeUsualScore"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['gradeUsualScore']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${gradeList}" var="obj">
								<option value="${obj.id}">${obj.name}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="7px">
				</tr>
				<tr>
					<td>考试成绩:</td>
					<td>
					<select class="easyui-combobox" id="gradeExamScore"
						name="gradeExamScore"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['gradeExamScore']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${gradeList}" var="obj">
								<option value="${obj.id}">${obj.name}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="7px">
				</tr>
				
				<tr>
					<td>总平成绩:</td>
					<td>
					<select class="easyui-combobox" id="gradeTotalScore"
						name="gradeTotalScore"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['gradeTotalScore']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${gradeList}" var="obj">
								<option value="${obj.id}">${obj.name}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="7px">
				</tr>
				</c:if>
				
				<tr>
					<td>考试性质:</td>
					<td>
					<select class="easyui-combobox" id="examNatureType"
						name="examNatureType"
						data-options="required:true,editable:false,panelHeight: 'auto',panelWidth: '86px',novalidate:true"
						validtype="selectRequired['examNatureType']"
						style="width: 86px; height: 33px; padding: 5px">
							<option value="0">请选择</option>
							<c:forEach items="${examNatureList}" var="obj">
								<option value="${obj.id}">${obj.name}</option>
							</c:forEach>
					</select>

					</td>
				</tr>
				<tr height="7px">
				</tr>
			</table>


		</form>
		<div style="text-align: center;margin:25px 0 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				onclick="updateCourseScore('#editCourseScoreForm')">提交</a> &nbsp;&nbsp;
			&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="$('#editCourseScoreDialog').dialog('close');"> 取消</a>
        </div>
	</div>

</div>

<script type="text/javascript">
	function searcheditTeaCourse(toolbar, datagrid) {
		var code = $(toolbar).find("#code").val();
		var userName = $(toolbar).find("#userName").val();
		var teaCourseId = $("#teaCourseId").val()
		//!-AJAX请求数据
		$('#editTeaCourseList').datagrid({
			url : "${contextPath}/edu/getEditCourseScoreList.do",
			queryParams : {
				"name" : userName,
				"code" : code,
				"teaCourseId":teaCourseId,
				"classId":$("#classId").val()
			}
		});

	}
	
	function calculate(){
		var bl = parseFloat('${bl}');
		var v1 = $("#hundredUsualScore").val()
		var v2 = $("#hundredExamScore").val()
		if(!isNaN(v1) && !isNaN(v2)) {
			var cost = v1 * bl * 100 + v2 * (1-bl) * 100;
			if(parseFloat(cost) > 0) {
				$("#hundredTotalScore").val(cost / 100)
			}
		  
		}else {
			 $.messager.alert("操作提示", "请输入数字","warning");
		}
	    
	} 
	
	function updateCourseScore(form) {
		$(form).form('enableValidation').form('validate');
	    //判断表单验证是否通过
	    if(!$(form).form('validate')){
	      return false;
	    } 
	    $.post('edu/editCourseScore.do',
	    $(form).serialize(), function (data) {
	      if(data>0){
	    	  $('#editCourseScoreDialog').dialog('close');
	        $.messager.alert("操作提示", "学生成绩修改成功！","info");
	        $('#editTeaCourseList').datagrid('reload');

	      }else{
	        $.messager.alert("操作提示","学生成绩修改失败!","warning");
	      }
	    }, "json");
	}
	
	function editCourseScore() {
		var row = $('#editTeaCourseList').datagrid('getSelected');
		if (row) {
		 $.post('edu/getCourseScoreById.do',{
		        "id":row.id
		      },function(data){
		    	  var resultJson=JSON.parse(data);
		    	  $('#editCourseScoreForm').find('#editId').val(row.id);
					$('#editCourseScoreForm').find('#code').html(row.code);
					$('#editCourseScoreForm').find('#name').html(row.name);
					var type = '${type}'
					if(type == 35001) {
						$('#editCourseScoreForm').find('#hundredUsualScore').val(resultJson.hundredUsualScore);
						$('#editCourseScoreForm').find('#hundredExamScore').val(resultJson.hundredExamScore);
						$('#editCourseScoreForm').find('#hundredTotalScore').val(resultJson.hundredTotalScore);
					}else {
						$("#gradeUsualScore").combobox('select', resultJson.gradeUsualScore);
						$("#gradeExamScore").combobox('select', resultJson.gradeExamScore);
						$("#gradeTotalScore").combobox('select', resultJson.gradeTotalScore);
					}
					
				    $("#examNatureType").combobox('select', resultJson.examNatureType);
					$('#editCourseScoreDialog').dialog('open');
		      });
		
			

		} else
			$.messager.alert("操作提示", "请先选择一条学生成绩修改!", "warning");
	}
	
	
</script>
