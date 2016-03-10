<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div style="text-align:center;margin:7% 7% 7% 7%;">
			<div style="padding-bottom:10px;">
				<strong style="text-align:center;">导入课程表</strong>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print"
					data-options="plain:true"
					onclick="downloadCourseScheduleExcel()">模板下载</a><br/>
			</div>
		  	<form id="importCourseFileUploadForm" method="post">
		  		<input type="text" class="easyui-textbox" id="excelCourseFile" name="excelCourseFile"
						   style="width: 250px; height: 25px;" editable="false">
		  		<a onclick="$('#importCourseFileUploadForm').find('#courseFileXls').click()"
		  				id="browserExcelFile"
					   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
		  		<input type="file" id="courseFileXls" name="courseFileXls" style="display:none"
		  			onchange="$('#importCourseFileUploadForm').find('#excelCourseFile').textbox('setValue', this.value)">
		  		<a id="courseScheduleInfoUpload" 
					   class="easyui-linkbutton" iconCls="icon-save">导入</a>
		  	</form>
	</div>
</div>

<script type="text/javascript">
	
	/*-- ajax上传组件 --*/
	$(function(){
		
		$('#courseScheduleInfoUpload').click(function(){
			if ($('#importCourseFileUploadForm').find('#excelCourseFile').textbox('getValue').trim() == '')
			{
				$.messager.alert('操作提示', '请先选择文件', 'warning');
			}/* 
			else if (($('#importCourseFileUploadForm').find('#excelCourseFile').textbox('getValue').lastIndexOf('xls') == -1
					|| $('#importCourseFileUploadForm').find('#excelCourseFile').textbox('getValue').lastIndexOf('xlsx') == -1) ){
				$.messager.alert('操作提示','文件格式不正确!','error');
				$('#importCourseFileUploadForm').find('#excelCourseFile').textbox('setValue','');
			}*/
			else{
				$.messager.progress({
					title: "详细信息",
					text : "正在上传...ing"
				});
				$.ajaxFileUpload({
					url : 'edu/uploadSchedule.do',
					fileElementId : 'courseFileXls',
					secureuri : false,
					dataType : 'text',
					success : function(data,status){
						data = data.replace("<html>", "");
						data = data.replace("</html>", "");
						data = data.replace(/<pre[\s\S]+?>/, "");
						data = data.replace("</pre>", "");
						data = data.replace("<body>", "");
						data = data.replace("</body>", "");
						
						$.messager.progress('close');
						var obj = $.parseJSON(data);
						if (obj.result == 0){
							$.messager.alert('操作提示','成功导入课表,请到查询页面查询','info');
							return ;
						} else if (obj.result == -1){
							$.messager.alert("操作提示","上传的文件格式不对","warning");
						}else if (obj.result == -2){
							$.messager.alert("操作提示","学年信息有误,请修改后重试","warning");
						}else if (obj.result == -3){
							$.messager.alert("操作提示","学期信息有误,请修改后重试","warning");
						}else if (obj.result == -4){
							$.messager.alert("操作提示","课程信息有误,请修改后重试","warning");
						}else if(obj.result == -5){
							$.messager.alert("操作提示","暂时无匹配的课程计划!","warning");
						}else if (obj.result == -6){
							$.messager.alert("操作提示","课程类型信息有误,请修改后重试","warning");
						}else if (obj.result == -7){
							$.messager.alert("操作提示","专业信息有误,请修改后重试","warning");
						}else if(obj.result == -8){
							$.messager.alert("操作提示","文件内存在班级错误!","warning");
						}else if(obj.result == -9){
							$.messager.alert("操作提示","年级信息有误,请修改后重试!","warning");
						} else if (obj.result == -10){
							$.messager.alert('操作提示','教室信息有误,请修改后重试','warning');
						} else if (obj.result == -11){
							$.messager.alert('操作提示','教师信息有误,请修改后重试','warning');
						} else if (obj.result == -12){
							$.messager.alert('操作提示','上课时间信息有误,请修改后重试','warning');
						} else if (obj.result == -13){
							$.messager.alert('操作提示','表中数据与已有课程冲突!','warning');
						} else if (obj.result == -15){
							$.messager.alert('操作提示','找不到相应的教师授课记录!','warning');
						}else if (obj.result == -20){
							$.messager.alert('操作提示','请检查该excel表是否适用于导入!','warning');
						}
					}
				});
			$('#importCourseFileUploadForm').find('#excelCourseFile').textbox('setValue','');
		}
	});
		
	});
	
	/*下载江门幼师课表模板*/
	function downloadCourseScheduleExcel(){
		var filename = escape('江门幼师课表模板.xls');
		window.open('${contextPath}/edu/toDownloadCourseBaseFile.do?filename='+encodeURI(filename));
	}
	
</script>