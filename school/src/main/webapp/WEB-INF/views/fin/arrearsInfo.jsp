<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
	
	<div id="arrearsInfoForm" style="margin:5px">
		
		<!-- 查询 -->
		<div style="margin:5px">
			<span>年级:</span>
			<select id="gradeOfArrearsInfo" class="easyui-combobox"
					style="width: 150px"
					data-options="editable:false,panelWidth:'150px', panelHeight:'auto'">
				
				<option value="0">请选择</option>
				<c:forEach items="${grade }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>		
			</select>
			&nbsp;&nbsp;&nbsp;
			<span>专业:</span>
			<select id="majorOfArrearsInfo" class="easyui-combobox"
					style="width: 150px"
					data-options="editable:false,panelWidth:'150px', panelHeight:'auto'">
				
				<option value="请选择">请选择</option>
				<c:forEach items="${major }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>		
			</select>
			&nbsp;&nbsp;&nbsp;
			<span>专业方向:</span>
			<select id="fieldOfArrearsInfo" class="easyui-combobox"
					style="width: 150px"
					data-options="editable:false,panelWidth:'150px', panelHeight:'auto'">
				
				<option value="0">请选择</option>
			</select>
			&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-search"
					onclick="findStudentArrearsInfo()">查询</a>
			&nbsp;&nbsp;	
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-print"
					onclick="exportStudentArrearsInfo()">导出欠费信息</a>
		</div>
		
		<!-- datagrid -->
		<table id="datagridOfArrearsInfo" class="easyui-datagrid" pagination="true"
			   rownumbers="true" singleSelect="true" data-options="pageSize:10"
			   toolbar="#arrearsInfoToolbar"
			   url="${contextPath }/fin/findStudentArrearsInfo.do?gradeId=0&majorId=0&fieldId=0"
			   style="padding: 5px;">
			
			<thead>
				<tr>
					<th field="name" width="100px" align="center">姓名</th>
					<th field="code" width="110px" align="center">学号</th>
					<th field="gradeStr" width="50px" align="center">年级</th>
					<th field="classStr" width="100px" align="center">班级</th>
					<th field="termTypeStr" width="100px" align="center">学期类型</th>
					<th field="tuitionFee" width="100px" align="center">应扣学费</th>
					<th field="roomFee" width="100px" align="center">应扣住宿费</th>
					<th field="bookFee" width="100px" align="center">应扣书费</th>
					<th field="totalFee" width="100px" align="center">应扣金额</th>
					<th field="paidTuitionFee" width="100px" align="center">上缴学费</th>
					<th field="paidRoomFee" width="100px" align="center">上缴住宿费</th>
					<th field="paidBookFee" width="100px" align="center">上缴书费</th>
					<th field="paidTotalFee" width="100px" align="center">上缴金额</th>
					<th field="payTime" width="180px" align="center">最后上缴时间</th>
					<th field="deductRemark" width="150px" align="center">非税扣费备注</th>
					<th field="remark" width="150px" align="center">备注</th>
				</tr>
			</thead>
		</table>
		<div id="arrearsInfoToolbar">
	<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-print"
					onclick="openChoiceGradeWin()">导出欠费信息</a>
		</div> -->
	</div>
<!-- 	
	<div id="choiceGradeWindowOfArrearsInfo" class="easyui-window" title="请选择需要导出的年级"
		data-options="modal:true,iconCls:'icon-print',closed:true"
		style="width: 350px; height: 285px; padding: 5px;">
		
		<div style="margin:25px 25px auto 65px">
			<span>年级:</span>
			<select class="easyui-combobox" id="gradeChoice" 
					style="width:150px"
					data-options="editable:false,panelHeight:'auto',panelWidth:'150px'">
				<option value="0">请选择</option>
				<c:forEach items="${grade }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>	
			</select>
			<span>专业:</span>
			<select class="easyui-combobox" id="gradeChoice" 
					style="width:150px"
					data-options="editable:false,panelHeight:'auto',panelWidth:'150px'">
				<option value="请选择">请选择</option>
				<c:forEach items="${grade }" var="item">
					<option value="${item.id }">${item.name }</option>
				</c:forEach>	
			</select>
			<select class="easyui-combobox" id="gradeChoice" 
					style="width:150px"
					data-options="editable:false,panelHeight:'auto',panelWidth:'150px'">
				<option value="0">请选择</option>
			</select>
		<div style="text-align: center; padding: 5px;margin-top:25px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="">导出</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="closeChoiceGradeWin()">关闭</a>
		</div>
	</div>
	 -->
</div>

<script type="text/javascript">
	
	$(function(){
	
		//专业和专业方向二级联动
		var major = $('#arrearsInfoForm').find('#majorOfArrearsInfo');
		major.combobox({
			onSelect : function() {
				var majorId = major.combobox('getValue');
			//	alert(majorId);
				if (majorId != '请选择' && majorId != null) {
					$(
							'#arrearsInfoForm')
							.find('#fieldOfArrearsInfo')
							.combobox(
									{
										url : "${contextPath}/stu/getMajorFieldInfo.do?majorId="
												+ majorId,
										valueField : 'id',
										textField : 'name',
										value : "请选择"
									});
				} else {
					$(
							'#arrearsInfoForm')
							.find('#fieldOfArrearsInfo')
							.combobox('loadData', {});
					$(
							'#arrearsInfoForm')
							.find('#fieldOfArrearsInfo')
							.combobox('setValue', '请选择');
				}
			}
		});
	})
	
	//打开年级选择窗口，用于导出欠费信息
	function openChoiceGradeWin() {
		
		$('#choiceGradeWindowOfArrearsInfo').window('open');
	}
	
	//关闭年级选择窗口
	function closeChoiceGradeWin() {
		
		$('#choiceGradeWindowOfArrearsInfo').window('close');
	}
	
	//查找
	function findStudentArrearsInfo() {
		
		var gradeId = $('#arrearsInfoForm').find('#gradeOfArrearsInfo').combobox('getValue');
		var majorId = $('#arrearsInfoForm').find('#majorOfArrearsInfo').combobox('getValue');
		var fieldId = $('#arrearsInfoForm').find('#fieldOfArrearsInfo').combobox('getValue');
		
		if (gradeId == '请选择')
			gradeId = 0;
		if (majorId == '请选择')
			majorId = 0;
		if (fieldId == '请选择')
			fieldId = 0;
		
		$('#arrearsInfoForm').find('#datagridOfArrearsInfo').datagrid({
			url : "${contextPath }/fin/findStudentArrearsInfo.do",
			queryParams : {
				gradeId : gradeId,
				majorId: majorId,
				fieldId : fieldId
			}
		});
		
	}
	
	//导出
	function exportStudentArrearsInfo() {
		
		var gradeId = $('#arrearsInfoForm').find('#gradeOfArrearsInfo').combobox('getValue');
		var majorId = $('#arrearsInfoForm').find('#majorOfArrearsInfo').combobox('getValue');
		var fieldId = $('#arrearsInfoForm').find('#fieldOfArrearsInfo').combobox('getValue');
		
		if (gradeId == '请选择')
			gradeId = 0;
		if (majorId == '请选择')
			majorId = 0;
		if (fieldId == '请选择')
			fieldId = 0;
		
		var gradeStr = "";
		var majorStr = "";
		var fieldStr = "";
		
		if (gradeId == 0)
			gradeStr = "全年级";
		else 
			gradeStr = $('#arrearsInfoForm').find('#gradeOfArrearsInfo').combobox('getText');
		
		if (majorId == 0 || majorId == "请选择")
			;
		else 
			majorStr = $('#arrearsInfoForm').find('#majorOfArrearsInfo').combobox('getText');
		
		if (fieldId == 0 || fieldId == "请选择") {
			;
		} else {
			fieldStr = " " + $('#arrearsInfoForm').find('#fieldOfArrearsInfo').combobox('getText')
		}
		
		$.messager.confirm("请确认...", "导出 " + gradeStr + majorStr + fieldStr + " 的学生欠费信息?" ,
				function(b) {
			if (b) {
				window.open('fin/exportStudentArrearsInfo.do?gradeId=' + gradeId + '&majorId=' + majorId + '&fieldId=' + fieldId);
			}
		})
		
	}
</script>