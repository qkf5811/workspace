<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div style="width: 99%; height: auto" id="divideClass">
		<div title="手动随机分班" style="padding:10px;">
			<div id="divideClassToolbar" style="padding: 5px; height: auto">
				<div>
					<span>专业:&nbsp;</span> 
					<select class="easyui-combobox" editable="false" 
					id="majorSelected" style="width: 120px"
					data-options="panelWidth:'120px', panelHeight:'auto'">
						<option>请选择</option>
						<c:forEach items="${majorList }" var="item">
							<option value="${item.id }">${item.name }</option>
						</c:forEach>
					</select>
					<span>&nbsp;&nbsp;专业方向:&nbsp;</span> 
					<select class="easyui-combobox" editable="false" 
					id="majorFieldSelected" style="width: 120px"
					data-options="panelWidth:'120px', panelHeight:'auto'">
						<option value="0">请选择</option>
					</select>
					<a class="easyui-linkbutton" iconCls="icon-search"
						id="showMarjorFeiedInfo" data-options="plain:true">查询</a>　　　
					<a class="easyui-linkbutton" iconCls="icon-add" id="addExcel"
						data-options="plain:true" onclick="openExcelWindows()">导入excel文件分班</a>
					<input name="classCount" type="hidden"/>
					<input name="majorFieldStuCount" type="hidden"/>
				</div>
			</div>
			<table id="majorFieldInfo" class="easyui-datagrid" style="width: auto;"
				pagination="true" rownumbers="true" singleSelect="true" toolbar="#majorFieldInfoOperToolbar">
				<thead>
					<tr>
						<th field="majorFieldStuCount" width="105">所报专业方向人数</th>
						<th field="classCount" width="105">所报专业开设班数</th>
					</tr>
				</thead>
			</table>
			
			<div id="majorFieldInfoOperToolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="divideClassSetting()">执行分班</a>
		    </div>  
		</div>
		
		<div id="excellWindows" class="easyui-window" title="导入excel文件分班"
		data-options="modal:true,iconCls:'icon-add',closed:true"
		style="width: 480px; height: 195px; padding: 5px;">
			<form id="stuInfoToClassUploadForm" method="post" enctype="multipart/form-data">
				<div align="center" style="padding-top: 20px">
					<%--<strong>通过Excel表导入学生信息:</strong>--%>
					<div align="left">
					<p style="color:red">注意:请按照excel表模版的格式上传学生信息，如未下载模版，请点击
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print"
						data-options="plain:true"
						onclick="downDivideClassBaseExcel()">表格下载</a></p><br/></div>
						<div align="center">
					<input type="text" class="easyui-textbox" id="excelFileName"
						   style="width: 250px; height: 25px;" editable="false">
				    <a onclick="$('#stuInfoToClassUploadForm').find('#fileField').click()"
					   class="easyui-linkbutton" iconCls="icon-search">浏览</a>
					<input type="file" name="fileField" id="fileField"
					   		  style="position:absolute; display:none"
					   		  onchange="$('#stuInfoToClassUploadForm').find('#excelFileName').textbox('setValue', this.value)" />
					<a id="uploadExcel" class="easyui-linkbutton" iconCls="icon-save">上传</a>
							</div>
				</div>
			</form>
	</div>
</div>
    
    <script type="text/javascript">
	    $(function(){
	    	//获取专业
			var tcSelect = $('#majorSelected');
			//		alert(cSelect);
			tcSelect.combobox({
				onSelect : function() {
					var val = tcSelect.combobox('getValue');
					//alert(val);
					var txt = tcSelect.combobox('getText');
					//alert(txt);
					//		alert("value: " + val + ", " + "Text: " + txt);
					if(val!="请选择"&&val!=null){
				
						$('#majorFieldSelected').combobox({
							valueField : "id",
							textField : "name",
							url : "${contextPath}/divideClass/getMajorFieldInfo.do?majorId=" + val,
							editable : false,
							value : "请选择"
						});		
						
					}else{
						$('#divideClass').find('#majorFieldSelected')
						.combobox('loadData', {});
						$('#divideClass').find('#majorFieldSelected')
						.combobox('setValue', '');
					}
				}
			});
	    });
       	
		$("#showMarjorFeiedInfo").click(function(){
			var majorId =$('#majorSelected').combobox('getValue');
			var majorFieldId =$('#majorFieldSelected').combobox('getValue');
			if(majorId!="请选择"&&majorFieldId!="请选择"){
				$('#majorFieldInfo').datagrid({
					url : "${contextPath}/divideClass/getInfoByMarjorFieldId.do?majorFieldId=" + majorFieldId,
				 	columns:[[   
				           {field:'majorFieldStuCount',title:'所报专业方向人数',width:105},
				           {field:'classCount',title:'所报专业开设班数',width:105}
				    ]],
				    loadMsg:'Processing, please wait …'
				});
			}else{
				$.messager.alert("错误","请选择专业方向");
			}
			$.post("${contextPath}/divideClass/getInfoByMarjorFieldId.do", {
				majorFieldId : majorFieldId
			}, function(data) {
				var obj = eval('(' + data + ')')
				//给两个隐藏域设置值
				$('input[name="majorFieldStuCount"]').val(obj[0].majorFieldStuCount);
				$('input[name="classCount"]').val(obj[0].classCount);
			});
		});
		
		function divideClassSetting(){
			var row = $('#majorFieldInfo').datagrid('getSelected');
			 if (row){
	                $.messager.confirm('确认','您确定对选该专业的学生进行分班吗？',function(r){
	                	
	                	var majorFieldStuCount=$('input[name="majorFieldStuCount"]').val();
	    				var classCount=$('input[name="classCount"]').val();
	    				if(majorFieldStuCount==0){
	    					$.messager.alert("提示","没有学生选该专业");
	    				}else if(classCount==0){
	    					$.messager.alert("提示","该专业没有设置班");
	    				}else{
	    					var majorFieldId=$('#majorFieldSelected').combobox('getValue');
	                            $.post('${contextPath}/divideClass/toDoDivideClass.do',
	                            	{
	                            	majorFieldId:majorFieldId,
	                            	majorFieldStuCount:majorFieldStuCount,
	                            	classCount:classCount
	                            	},
	                            	function(result){
		                                if (result.success){
		                                    $('#majorFieldInfo').datagrid('reload');    // reload the data
		                                    $('input[name="majorFieldStuCount"]').val("0");
		                                    $.messager.alert("成功","分班成功");
		                                } else {
		                                    $.messager.show({    // show error message
		                                        title: 'Error',
		                                        msg: '分班失败'
		                                    });
		                                }
		                            },'json'); 
	    				}
	                });
			 }else{
				 $.messager.alert("提示","请选择一行");
			 }
		}
		
		
		function openExcelWindows(){
			$('#excellWindows').window('open');
		}
		
		$('#stuInfoToClassUploadForm').find('#uploadExcel').click(function(){
			//导入Excel分班
			//得到上传文件的全路径  
	        var fileName=$('#stuInfoToClassUploadForm').find('#excelFileName').textbox('getValue').trim();  
			//alert(fileName);
			if(fileName==""){     
                $.messager.alert('提示','请选择上传文件！','info');   
            }else{  
                //对文件格式进行校验  
                var d1=/\.[^\.]+$/.exec(fileName);   
                if(d1==".xls"||d1==".xlsx"){    
                	//如果是.xls和.xlsx后缀的文件，就进行如下操作
                	//Easy-UI的进度条提示
                	$.messager.progress({
    					title:'操作提示',
    					text: '正在上传，等稍等...'
    				});
					//向目的url发送异步请求
                    $.ajaxFileUpload({
    					url:'divideClass/divideClassByExcel.do',
    					type : 'post',
    					fileElementId:'fileField',
    					secureuri: false,
    					dataType : 'text',
    					success: function(data, status) {
    						data = data.replace("<html>", "");
    						data = data.replace("</html>", "");
    						data = data.replace(/<pre[\s\S]+?>/, "");
    						data = data.replace("</pre>", "");
    						data = data.replace("<body>", "");
    						data = data.replace("</body>", "");
    						
    						var obj = eval('(' + data + ')');
    						//alert(obj);
    						$.messager.progress('close');
    						if(obj.result==1){
    							$.messager.alert('操作提示','分班成功！','info');
    						}else if(obj.result==-1){
    							$.messager.alert('操作提示','上传的excel文件格式不对!','warming');
    						}else if(obj.result==-2){
    							$.messager.alert('操作提示','excel表数据信息有误!','warming');
    						}else if(obj.result==-3){
    							$.messager.alert('操作提示','excel表数据信息有误!','warming');
    						}else if(obj.result==-4){
    							$.messager.alert('操作提示','专业方向名称有误，请检查导入的excel文件!','warming');
    						}else if(obj.result==-5){
    							$.messager.alert('操作提示','excell表中所有的数据都已经分班!','warming');
    						}else if(obj.result==-6){
    							$.messager.alert('操作提示','excell表学生名字有误，请确保新生信息中有该名字!','warming');
    						}
    					}
    				});
                
                    //清空
                    $('#stuInfoToClassUploadForm').find('#excelFileName').textbox('setValue', '');
               }else{  
                    $.messager.alert('提示','请选择xls或xlsx格式文件！','info');   
                 	//清空
                    $('#stuInfoToClassUploadForm').find('#excelFileName').textbox('setValue', '');
               }  
            }    
		});
		
		//下载分班录入的原始表格
		function downDivideClassBaseExcel(){
			var filename = escape("专业分班表格模板.xls");
			window.open("${contextPath}/divideClass/downExcelFile.do?filename="+encodeURI(filename));
		}
</script>