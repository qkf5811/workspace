<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<style type="text/css">
	.item {
		text-align:right;
		<!--padding-right:20px;
		-->
	}
</style>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form method="post" id="resumeInfo">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师编号:</td>
                       <td><input id="teacode" class="easyui-validatebox textbox" name="code"
                                    style="width: 200px; height: 18px; padding: 5px" 
                                    readonly="true"  value="${t.code }">
                    </td>
                    </div>
                   <!-- 
                     <td>
                		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" 
                		plain="true" onclick="$('#fileWindow').window('open');">批量导入教职工简历</a>
               		 </td>
               		  -->
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">教师姓名:</td>
                       	 <td><input id="teaname" class="easyui-validatebox textbox" name="name"
                                    style="width: 200px; height: 18px; padding: 5px"
                                    readonly="true" value="${t.name }"
                                    data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
                    </td>
                </div>
            </tr>
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">所属单位:</td>
			            <td><input id="workPlace" class="easyui-validatebox textbox" name="workPlace"
			                     style="width: 200px; height: 18px; padding: 5px"
			                     data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
			                    </td>
			                </div>
			            </tr>
			  <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">所在职位:</td>
			          <td><input id="position" class="easyui-validatebox textbox" name="position"
			                     style="width: 200px; height: 18px; padding: 5px"
			                     data-options="required:true,missingMessage:'该处未填写',novalidate:true" >
			                    </td>
			                </div>
			            </tr>
			    <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">开始日期:</td>
			               <td><input id="startDate" class="easyui-datebox" type="text" name="startDate"
			                     style="width: 210px; height: 31px; padding: 5px" 
			                     data-options="required:true,missingMessage:'该处未填写',novalidate:true,editable:false" >
				<!--  
				<img onclick="WdatePicker({el:'startDate'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
				-->
			                    </td>
			                </div>
			            </tr>   
			       <tr>
			       	 <div style="margin-bottom: 20px">
                    <td class="item">  结束日期:</td>
			     	<td><input id="endDate" class="easyui-datebox" type="text" name="endDate"
			                     style="width: 210px; height: 31px; padding: 5px"
			                     data-options="required:true,missingMessage:'该处未填写',novalidate:true,editable:false" >
			            <!--        <img onclick="WdatePicker({el:'endDate'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			                  -->
			                    </td>
			                </div>
			       </tr>  
			       <tr>
                <div style="margin-bottom: 20px">
                    <td class="item"> 调动原因:</td>
			          <td><input id="transferCause" class="easyui-validatebox textbox" name="transferCause"
			                       data-options="required:true,missingMessage:'该处未填写',novalidate:true"
			                     style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			 </tr> 
            <tr>
                <div style="margin-bottom: 20px">
                    <td class="item">备注信息:</td>
			            <td><input id="remark" class="easyui-validatebox textbox" name="remark"
			                     style="width: 200px; height: 18px; padding: 5px">
			                    </td>
			                </div>
			 </tr>
			<tr>
			   <div style="margin-bottom: 20px">
			   	<td>
                	<input type="hidden" id="teacherId" name="teacherId" value="${t.id }">
                </td>
                </div>
            </tr>
        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="addResumeInfo('#resumeInfo')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm('#resumeInfo')">重置</a>
    </div>
</div>

<!-- 弹出所有教师列表窗口 -->
	<div id="teaWindow" class="easyui-window" title="教职工列表" 
	data-options="modal:true,iconCls:'icon-add',closed:true" style="width:502px;height:450px;padding:5px;">
		<div id="teaResumeListToolbar" style="padding: 5px; height: auto">
		<div>
			<td>教师编号:</td>
			<td><input class="easyui-validatebox textbox" id="code"
					   name="code"
					   style="width: 100px; height: 18px; padding: 5px" />

			</td>

			<td>教师姓名:</td>
				<td><input class="easyui-validatebox textbox" id="name"
					name="name" 
					style="width: 100px; height: 18px; padding: 5px" />
					
				</td>  

			<button href="#" class="easyui-linkbutton" plain="true"
				onclick="searchTeacher0List('#teaResumeListToolbar', '#allTeacherList')"
				iconCls="icon-search">查询</button>
		</div> 
	</div>
	<table id="allTeacherList" class="easyui-datagrid" style="width: auto;"
		pagination="true" url="${contextPath}/tea/getAllTeacher.do"
		rownumbers="true" singleSelect="true" data-options="pageSize:10">

	<thead>
		<tr>
			<th field="code" width="140" align="center">编号</th>
			<th field="name" width="140" align="center">姓名</th>
			<th field="nowPosition" width="150" align="center">职位</th>
		</tr>
	</thead>
</table>
	
	<div style="text-align: center;margin:25px 0 0;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="addTeaInfo()" style="margin-right:20px;"> <span
					style="font-size: 14px;">确定</span>
				</a><a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="$('#teaWindow').window('close');"> <span
					style="font-size: 14px;"> 取消</span>
				</a>
			</div>
	</div>
<!-- 弹出所有教师窗口结束 -->  

<script type="text/javascript">

		/*上传功能作废
		$('#teaResumeInfoUpload').click(function(){
			if ($('#fileUploadForm').find('#excelFileName').textbox('getValue').trim() == '')
			{
				$.messager.alert('操作提示', '请先选择文件', 'warning');
			}/* 
			else if (($('#fileUploadForm').find('#excelFileName').textbox('getValue').lastIndexOf('xls') == -1
					|| $('#fileUploadForm').find('#excelFileName').textbox('getValue').lastIndexOf('xlsx') == -1) ){
				$.messager.alert('操作提示','文件格式不正确!','error');
				$('#fileUploadForm').find('#excelFileName').textbox('setValue','');
			}
			else{
				$.messager.progress({
					title: "详细信息",
					text : "正在上传...ing"
				});
				//alert("你老母啊 ！！ ")
			//ajax上传组件 
			$.ajaxFileUpload({
				url : 'tea/importResumeInfoByXLS.do',
				fileElementId : 'fileXls',
				secureuri : false,
				dataType : 'text',
				success : function(data,status){
					//alert(data);
					data = data.replace("<html>", "");
					data = data.replace("</html>", "");
					data = data.replace(/<pre[\s\S]+?>/, "");
					data = data.replace("</pre>", "");
					data = data.replace("<body>", "");
					data = data.replace("</body>", "");
					$.messager.progress('close');
					var obj = eval('(' + data + ')');
					//alert(obj);
					if (!(obj.result < 0)){
						$('#fileWindow').window('close');
						closeTab(getCurrentTab());
						$.messager.alert("操作提示","成功录入"+ obj.result +"条记录","info");
						$('#resumeList').datagrid('reload');
					} 
					else if (obj.result == -1){
						$.messager.alert("操作提示","上传的文件格式不对","warning");
					} else if (obj.result == -2){
						$.messager.alert("操作提示","文件内部数据错误","warning");
					}
				},
				error : function(data,status,e){
					alert(e);
				}
				
			});
			$('#fileUploadForm').find('#excelFileName').textbox('setValue','');
		}
		
		});
		*/
	/*
	//下载招生录入的原始格式表格
	function downloadTeacherResumeBaseExcel() {
		var filename = escape("教师简历信息模板.xls");
		//alert(encodeURI(filename));
		window.open("${contextPath}/tea/downloadBaseExcel.do?filename="+encodeURI(filename));
	}
	
	function addTeaInfo(){
		var row = $('#allTeacherList').datagrid('getSelected');
    	if (row){
    		$('#resumeInfo').find('#code').textbox('setValue',row.code);
    		$('#resumeInfo').find('#name').val(row.name);
    		$('#resumeInfo').find('#position').val(row.nowPosition);
    		$('#resumeInfo').find('#teacherId').val(row.id);
    		$('#teaWindow').window('close');
    	}
    	
	}
	*/
	//添加单条信息
	function addResumeInfo(form){
		$('#resumeInfo').form('enableValidation').form('validate');
    	//判断表单验证是否通过
		if(!$(form).form('validate')){
			return false;
		} 
    	var teacherId = $(form).find('#teacherId').val();
		var position = $(form).find('#position').val();
		var workPlace = $(form).find('#workPlace').val();
		var startDate = $(form).find('#startDate').datebox('getValue');
		var endDate = $(form).find('#endDate').datebox('getValue');
		var transferCause = $(form).find('#transferCause').val();
		var remark = $(form).find('#remark').val();
		var params = {'teacherId':teacherId,'position':position,'workPlace':workPlace,
				'startDate':startDate,'endDate':endDate,'transferCause':transferCause,'remark':remark};
		console.log(params);
		
		$.post('tea/addSingleResumeItem.do',{
			teacherId: teacherId,
			position : position,
			workPlace:workPlace,
			startDate:startDate,
			endDate  : endDate,
			transferCause:transferCause,
			remark   :  remark
		},function(data){
			if (data.result > 0){
				closeTab(getCurrentTab());
	            $.messager.alert("操作提示", "添加信息成功！","info");
	            $('#resumeList').datagrid('reload');
			} else{
				$.messager.alert("操作提示", "添加信息失败！","warning");
			}
		},'json');
	}
	
	function clearForm(form) {
		var position = $(form).find('#position').val('');
		var workPlace = $(form).find('#workPlace').val('');
		var startDate = $(form).find('#startDate').datebox('setValue','');
		var endDate = $(form).find('#endDate').datebox('setValue','');
		var transferCause = $(form).find('#transferCause').val('');
		var remark = $(form).find('#remark').val('');
    }
	/*
	//查找 
	function searchTeacher0List(form,datagrid){
		var name = $(form).find('#name').val();
		//alert(name);
		var code = $(form).find('#code').val();
		//alert(code);
		$(datagrid).datagrid('load',{
			"name" : name,
			"code" : code
		});
	}
	*/
</script>