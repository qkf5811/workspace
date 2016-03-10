<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	<div style="text-align:center;margin:5% 5% 5% 5%;">
			<div style="padding-bottom:10px;">
				<strong style="text-align:center;">导入批扣文件</strong>
			</div>
		  	<form id="stuPayExcelForm" method="post">
		  		<input type="text" class="easyui-textbox" id="stuPayFilename" name="stuPayFilename"
						   style="width: 250px; height: 25px;" editable="false">
		  		<a onclick="$('#stuPayExcelForm').find('#stuPayfileXls').click()"
					   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
		  		<input type="file" id="stuPayfileXls" name="stuPayfileXls" style="display:none"
		  			onchange="$('stuPayExcelForm').find('stuPayFilename').textbox('setValue', this.value)">
		  		<a id="stuPayInfoUpload" 
					   class="easyui-linkbutton" iconCls="icon-save">导入</a>
		  	</form>
	</div>
</div>
<!-- js上传组件 -->
<script type="text/javascript">
	$.ajaxFileUpload({
		
	});
</script>