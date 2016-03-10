<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="studentChargeListToolbar" style="padding: 5px; height: auto">
    <div>
      <td>年级:</td>
      <td>
        <select class="easyui-combobox" id="studentChargeGrade" name="studentChargeGrade"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" 
                style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${gradeList}" var="grade">
            <option value="${grade.id}">${grade.name}</option>
          </c:forEach>

        </select>
      </td>
      
      <td>学年:</td>
      <td>
        <select class="easyui-combobox" id="studentChargeStudyYear" name="studentChargeStudyYear"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" 
                style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${studyYearList}" var="studyYear">
            <option value="${studyYear.id}">${studyYear.name}</option>
          </c:forEach>

        </select>
      </td>

      <td>学期:</td>
      <td>
        <select class="easyui-combobox" id="studentChargeTermType" name="studentChargeTermType"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" 
                style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${termTypeList}" var="termType">
            <option value="${termType.id}">${termType.name}</option>
          </c:forEach>

        </select>
      </td>
      
      <td>姓名:</td>
      <td>
        <input class="easyui-textbox" id="studentChargeStudentName" name="studentChargeStudentName" 
               style="width: 80px; height: 30px; padding: 5px">
      </td>

      <button href="#" class="easyui-linkbutton" plain="true" id="searchStudentChargeList"
              iconCls="icon-search">查询
      </button>


    </div>
  </div>
  <table id="studentChargeList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/fin/getStudentChargeList.do" 
         toolbar="#studentChargeListOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>
      <th field="studentName" width="80" align="center">姓名</th>
      <th field="studentYearStr" width="80" align="center">学年</th>
      <th field="termTypeStr" width="80" align="center">学期</th>
      <th field="gradeName" width="80" align="center">年级</th>
      <th field="studentAccountName" width="80" align="center">学生帐户名</th>
      <th field="tuitionFee" width="80" align="center">应扣学费</th>
      <th field="roomFee" width="80" align="center">应扣住宿费</th>
      <th field="bookFee" width="80" align="center">应扣书费</th>
      <th field="totalFee" width="80" align="center">应扣金额合计</th>
      <th field="paidTuitionFee" width="80" align="center">上缴学费</th>
      <th field="paidRoomFee" width="80" align="center">上缴住宿费</th>
      <th field="paidBookFee" width="80" align="center">上缴书费</th>
      <th field="paidTotalFee" width="80" align="center">上缴金额合计</th>
      <th field="payTime" width="100" align="center">最后上缴时间</th>
      <th field="deductRemark" width="120" align="center">非税扣费备注</th>
      <th field="remark" width="120" align="center">备注</th>
    </tr>
    </thead>
  </table>


  <div id="studentChargeListOperToolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="toCountStudentCharge()">计算应扣学费</a>
  </div>
</div>


<script type="text/javascript">

$(function(){
    $.messager.alert("温馨提示","1.计算扣费之前请检查：各专业方向、各年级的收费标准是否设置完整；学生银行账号是否设置完整。 <br/>2.仅为当前学年的两个学期计算扣费信息。 <br/>3.当前学年的某项收费标准修改后，按下“计算应扣学费”按钮后可对学生扣费信息进行更新。");
})
 
/********************************点击查询按钮后执行动作******************************/
  $(function() {
		$("#studentChargeListToolbar").find('#searchStudentChargeList').click(
				function() {
					var studentChargeGrade = $('#studentChargeListToolbar').find('#studentChargeGrade').combobox('getValue');
					var studentChargeStudyYear = $('#studentChargeListToolbar').find('#studentChargeStudyYear').combobox('getValue');
					var studentChargeTermType = $('#studentChargeListToolbar').find('#studentChargeTermType').combobox('getValue');
					var studentChargeStudentName = $('#studentChargeListToolbar').find('#studentChargeStudentName').textbox('getValue');
					//alert('studentChargeGrade : '+studentChargeGrade+' , studentChargeStudyYear : '+studentChargeStudyYear);
					//!-AJAX请求数据
					$('#studentChargeList').datagrid('load',{												
							"gradeId" : studentChargeGrade,
							"studyYear" : studentChargeStudyYear,
							"termType" : studentChargeTermType,
							"studentName" : studentChargeStudentName
					});
				});

	})
  
//计算应扣学费
function toCountStudentCharge(){
	  $.messager.confirm("请确认...", "您确定进行计算应扣学费吗？", function(data) {
			if (data){
				$.messager.progress({
	                title:'请等待',
	                msg:'系统正在计算中...'
	            })
			
				$.post('fin/toCountAllStudentsCharge.do', {					
				},function(data) {
					        $.messager.progress('close');
							//var obj = eval('(' + data + ')');
							var obj =  JSON.parse(data);
							if (obj.insertCount >= 1||obj.updateCount >= 1) {
								$.messager.alert("操作提示", "应扣学费计算成功!已插入"+obj.insertCount+"条名学生计算应扣学费记录;更新"+obj.updateCount+"条学生应扣学费记录。<br/>注：不包含已计算扣费学生。", "info");	
								//刷新各位学生收费和缴费情况列表
								$('#studentChargeList').datagrid('reload');  
								
							}else{
								$.messager.alert("操作提示", "无符合条件的学生用以计算应扣学费或无学生需要更新应扣学费，请检查收费标准是否设置完整后再试!", "warning");
							}
						})			
			}
			else
				;				
		});
}
</script>
