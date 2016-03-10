<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="width: 99%; height: auto" id="divideClass">

	<div id="divideClassToolbar" style="padding: 5px; height: auto">
        <span>&nbsp;是否已分班:&nbsp;</span>
        <select class="easyui-combobox" id="isDivideClassSelected" name="isDivideClassSelected"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '70px',novalidate:true,onSelect:selectMajor"
                validtype="selectRequired['majorSelected']" style="width:70px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${booleanList}" var="isDivideClass">
            <option value="${isDivideClass.id}">${isDivideClass.name}</option>
          </c:forEach>
        </select>
        <span>&nbsp;姓名:&nbsp;</span>
		<input class="easyui-textbox" id="studentNameRefer" name="studentNameRefer"
			style="width: 100px; height: 30px; padding: 10px; font-size: 15px" />   
		<a class="easyui-linkbutton" iconCls="icon-search"
		   id="showInfoOfMarjorFeiedAndStudentName" data-options="plain:true">查询</a>
		<a href="#"
		   class="easyui-linkbutton" plain="true"
		   onclick="cleanSearch('#divideClassToolbar')" iconCls="icon-reload"
		   style="margin-left: 10px;">清空 </a>
		</div> 
	</div>
	<table id="studentToDivideList" class="easyui-datagrid" style="width: auto;"
		pagination="true" rownumbers="true" singleSelect="true"
		url="stu/getStudentListToDivide.do"
		toolbar="#studentToDivideListToolbar">
		<thead>
			<tr>
			    <th field="newStu_name" width="160" align="center">姓名</th>				
				<th field="is_divide_class_str" width="100" align="center">是否已分班</th>
				<th field="code" width="120" align="center">学号</th>				
				<th field="class_name" width="120" align="center">班级</th>
                <th field="status_str" width="120" align="center">是否已注册</th>
                <th field="is_free_tuition_str" width="100" align="center">是否免学费</th>
                <th field="remark" width="200" align="center">备注</th>
			</tr>
		</thead>
	</table>

	<div id="studentToDivideListToolbar">
	    <a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="openDivideClassSettingDialog('#divideClassSettingForm')">设置分班</a>
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="">修改分班</a> -->
	</div>


<!-- 弹出设置分班的对话框 -->
<div id="divideClassSettingDialog" class="easyui-dialog" title="设置分班"
	data-options="modal:true,iconCls:'icon-edit',closed:true , buttons:'#divideClassSettingBtn'"
	style="width: 600px; height: 450px; padding: 15px;">
	<form id="divideClassSettingForm" method="post">
		<table cellpadding="7" align="center">			
			<tr>
				<td>姓名:</td>
				<td><input class="easyui-textbox"
					id="nameSetting" name="nameSetting"
					data-options="required:true,validType:'length[1,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-10'"
					editable="false"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			
			<tr>
				<td>学号:</td>
				<td><input class="easyui-textbox"
					id="codeSetting" name="codeSetting"
					data-options="required:true,validType:'length[1,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-20'"
					editable="false"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			
            <tr>
				<td>所属班别:</td>
				<td><select class="easyui-combobox" id="classSelect"
					name="classSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['classSelect']"
					editable="false">
					</select></td>
			</tr>
			
			<tr>
				<td>学生基本信息ID:</td>
				<td><input class="easyui-textbox"
					id="studentInfoIdSetting" name="studentInfoIdSetting"
					data-options="required:true,validType:'length[1,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为1-20'"
					editable="false"
					style="width: 220px; height: 30px; padding: 8px; font-size: 15px" />
				</td>
			</tr>
			
			<tr>
				<td>学籍状态:</td>
				<td><select class="easyui-combobox" id="statusSelect"
					name="statusSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['statusSelect']"
					editable="false">
					    
						<c:forEach items="${statusList}" var="status">
							<option value="${status.id}">${status.name}</option>
						</c:forEach>
					</select></td>
			</tr>
			
			<%-- <tr>
				<td>是否免学费:</td>
				<td><select class="easyui-combobox" id="isFreeTuitionSelect"
					name="isFreeTuitionSelect" style="width: 220px; height: 30px"
					data-options="novalidate:true,panelHeight: 'auto'" validtype="selectRequired['isFreeTuitionSelect']"
					editable="false">
					    <option value="">请选择</option>
						<c:forEach items="${booleanList}" var="isFreeTuition">
							<option value="${isFreeTuition.id}">${isFreeTuition.name}</option>
						</c:forEach>
					</select></td>
			</tr> --%>
			
			<tr>
				<td>备注:</td>
				<td><input class="easyui-textbox" id="divideClassSettingRemark" name="divideClassSettingRemark"
                     data-options="multiline:true" style="width:220px;height:80px ;font-size: 15px">
				</td>
			</tr>

		</table>
	</form>

	<div id="divideClassSettingBtn" style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="addNewStudentInAClass('#divideClassSettingForm')">确定</a> &nbsp;&nbsp;
		&nbsp;&nbsp; &nbsp;&nbsp; <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="cleardivideClassSettingForm('#divideClassSettingForm')">重置</a>
	</div>
</div>



<script type="text/javascript">
  //清空查询条件
  function cleanSearch(condition){
    $(condition).find("#isDivideClassSelected").combobox('select','');
    $(condition).find("#studentNameRefer").textbox('setValue','');
  }

  //设置专业信息下拉框的选择触发事件
  function selectMajor(){
      var id=$("#majorSelected").combobox("getValue");
      if(id!=""){
        $.post('stu/getMajorFieldInfo.do',{
          "majorId":id
        },function(data){
          //返回的是string字符串，需要把字符串转成json对象
          var resultJson=JSON.parse(data);
          //添加一个下拉框元素"请选择"
          var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
          //使用unshift方法，在resultJson前面加上firstSelectJson
          resultJson.unshift(firstSelectJson);
          //加载专业方向下拉框数据
          $("#majorFieldSelected").combobox({
            valueField:'id',
            textField:'name',
            data:resultJson,
            editable:false,
            disabled:false
          });
        });
      }else{
        //设置专业方向下拉框为不可选
        $("#majorFieldSelected").combobox('disable');
        $("#majorFieldSelected").combobox('loadData',{});
        $("#majorFieldSelected").combobox('setValue','');
      }
  }

  
  /********************************点击查询按钮后执行动作******************************/
  $(function() {
  		$("#divideClassToolbar").find('#showInfoOfMarjorFeiedAndStudentName').click(
  				function() {
   					var isDivideClassSelected = $('#divideClassToolbar').find(
  					'#isDivideClassSelected').combobox(
  					'getValue'); 					
  					var studentNameRefer = $('#divideClassToolbar').find(
  					'#studentNameRefer').textbox('getValue');
  					//alert('majorFieldSelected : '+majorFieldSelected+' , studentNameRefer : '+studentNameRefer);
  					//!-AJAX请求数据
  					$('#studentToDivideList').datagrid('load',{												
  							"is_divide_class" : isDivideClassSelected,
  							"newStu_name" : studentNameRefer					
  					});
  				});

  	})
  	
 	
/********************************手动设置一个学生的分班信息****************************/
  
    function openDivideClassSettingDialog(form) {
	  var row = $('#studentToDivideList').datagrid('getSelected');
		if (row) {
			//检测选择的学生是否已分班
			if(row.is_divide_class_str=='是'){
				$.messager.alert("操作提示", "您选择的学生已分班，不能重新进行设置!", "warning");
				$('#divideClassSettingDialog').dialog('close');
				return;
			}
			//检测选择的专业方向下是否已经开设有相关班级
			$.post('stu/getClassByMajorFieldTest.do', {
				"majorFieldId" : row.major_field_id
			},function(data) {
						//var obj = eval('(' + data + ')');
						var obj =  JSON.parse(data);
						if (obj.result == 0) {
							$.messager.alert("操作提示", "您选择的学生所属的专业方向还没开设任何班级，请先为该专业方向开设班级!", "warning");
							$('#divideClassSettingDialog').dialog('close');
							return;
						}
					})
			//设置姓名
			$(form).find('#nameSetting').textbox('setValue',row.newStu_name);
			$(form).find('#nameSetting').textbox('disable');
			//设置学生基本信息ID
			$(form).find('#studentInfoIdSetting').textbox('setValue',row.newStu_id);
			$(form).find('#studentInfoIdSetting').textbox('disable');
			//设置学籍状态
			$(form).find('#statusSelect').combobox('disable');
			//选择班别
			$(form).find('#classSelect').combobox({
				url : "stu/getClassByMajorField.do?majorFieldId=0",
				valueField : 'id',
				textField : 'name',
				value : '请选择'
			});
			//获取学号
			$(form).find('#codeSetting').textbox('disable');
			$(form)
			.find('#classSelect')
			.combobox(
					{
						onSelect : function() {
							var classId = $(form).find('#classSelect').combobox('getValue');
							//alert(classId);
							if (classId != '请选择') {
								$.post("stu/getCodeByMarjorFieldIdAndClassID.do", {
									'majorFieldId' : row.major_field_id,
									'classId' : classId 
								}, function(data) {
									var obj = eval('(' + data + ')')
									$(form).find('#codeSetting').textbox('setValue',obj.code);
								});
							}								
							
						}
					});
						
			//打开窗口
			$('#divideClassSettingDialog').dialog('open');
		} else
			$.messager.alert("操作提示", "请先选择一条需要设置的学生记录!", "warning");   
    }
	//重置数据
	function cleardivideClassSettingForm(condition) {
		$(condition).find('#codeSetting').textbox('setValue','');
		$(condition).find('#classSelect').combobox('setValue','请选择');
		$(condition).find('#isFreeTuitionSelect').combobox('setValue','');
		$(condition).find('#divideClassSettingRemark').textbox('setValue','');		
		//取消表单验证
		disableValidationAtNew();
	}

	//添加学生信息
	function addNewStudentInAClass(form) {
		//在提交数据之前执行表单验证
		$(form).form('enableValidation').form('validate');
		//判断表单验证是否通过
		if (!$(form).form('validate'))
			return false;
		
		var name = $(form).find('#nameSetting').val();
		var code = $(form).find('#codeSetting').val();
		var classId = $(form).find('#classSelect').combobox('getValue');
		var studentInfoId = $(form).find('#studentInfoIdSetting').val();
		var status = $(form).find('#statusSelect').combobox('getValue');
		//var isFreeTuition = $(form).find('#isFreeTuitionSelect').combobox('getValue');
		var remark = $(form).find('#divideClassSettingRemark').val();
		//alert("classSelect:"+classSelect+" ,"+"isFreeTuitionSelect:" +isFreeTuitionSelect+" ,"+"remark:"+remark);
		$.messager.confirm("请确认...", "设置分班之后不能修改，您确定做出此设置吗?", function(data) {
				if (data)
					$.post('stu/addNewStudentInAClass.do', {
						"name" : name,
						"code" : code,
						"classId" : classId,
						"studentInfoId" : studentInfoId,
						"status" : status,
						//"isFreeTuition" : isFreeTuition,
						"remark" : remark
					},function(data) {
								//var obj = eval('(' + data + ')');
								var obj =  JSON.parse(data);
								if (obj.result == 1) {
									$.messager.alert("操作提示", "学生分班信息添加成功!", "info");
									$('#divideClassSettingDialog').dialog('close');
									$('#studentToDivideList').datagrid('reload');
									//刷新各专业方向分班情况
									$('#divideClass').find('#infoOfMajorField').datagrid('reload');
									cleardivideClassSettingForm('#divideClassSettingForm');
								}
							})
							
				else
					$('#divideClassSettingDialog').dialog('close');				
				    cleardivideClassSettingForm('#divideClassSettingForm');
					
			});
		//取消表单验证
		disableValidationAtNew();
	}	
	//在提交数据之前取消表单验证
	function disableValidationAtNew(){
		//在提交数据之前取消表单验证
		$('#divideClassSettingForm').form('disableValidation').form('validate');	
	}
		
  

</script>