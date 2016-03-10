<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="chargeStandardListToolbar" style="padding: 5px; height: auto">
    <div>


      <td>所属年级:</td>
      <td>
        <select class="easyui-combobox" id="chargeStandardGrade" name="chargeStandardGrade"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${gradeList}" var="grade">
            <option value="${grade.id}">${grade.name}</option>
          </c:forEach>

        </select>
      </td>

      <td>学期类型:</td>
      <td>
        <select class="easyui-combobox" id="chargeStandardTermType" name="chargeStandardTermType"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${termTypeList}" var="termType">
            <option value="${termType.id}">${termType.name}</option>
          </c:forEach>

        </select>
      </td>

      <td>专业方向:</td>
      <td>
        <select class="easyui-combobox" id="chargeStandardMajor" name="chargeStandardMajor"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectMajor" validtype="selectRequired['majorListForClass']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${majorList}" var="major">
            <option value="${major.id}">${major.name}</option>
          </c:forEach>

        </select>
        <select id="chargeStandardMajorField" name="chargeStandardMajorField" class="easyui-combobox" data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '155px'" style="width:155px;height:30px">

        </select>
      </td>





      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchChargeStandardList('#chargeStandardListToolbar', '#chargeStandardList')"
              iconCls="icon-search">查询
      </button>


    </div>
  </div>
  <table id="chargeStandardList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/fin/getChargeStandardList.do" toolbar="#chargeStandardListOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>

      <th field="gradeName" width="80" align="center">年级</th>
      <th field="termTypeString" width="80" align="center">学期</th>
      <th field="majorName" width="80" align="center">专业</th>
      <th field="majorFieldName" width="155" align="center">专业方向</th>
      <th field="tuitionFee" width="155" align="center">学费</th>
      <th field="roomFeeBoy" width="155" align="center">住宿费(男生)</th>
      <th field="roomFeeGirl" width="155" align="center">住宿费(女生)</th>
      <th field="bookFee" width="155" align="center">课本资料费</th>

    </tr>
    </thead>
  </table>


  <div id="chargeStandardListOperToolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openTab('fin/toAddChargeStandard.do','新建收费标准')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="toEditChargeStandard()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="deleteChargeStandard()">删除</a>
  </div>
</div>
<script type="text/javascript">

  //设置专业信息下拉框的选择触发事件
  function selectMajor(){

    var id=$("#chargeStandardMajor").combobox("getValue");
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
        $("#chargeStandardMajorField").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置专业方向下拉框为不可选
      $("#chargeStandardMajorField").combobox('disable');
      $("#chargeStandardMajorField").combobox('loadData',{});
      $("#chargeStandardMajorField").combobox('setValue','');
    }

  }


  function searchChargeStandardList(toolbar, datagrid) {


    var chargeStandardGradeId = $(toolbar).find("#chargeStandardGrade").combobox('getValue');
    var chargeStandardTermType = $(toolbar).find("#chargeStandardTermType").combobox('getValue');
    var chargeStandardMajor = $(toolbar).find("#chargeStandardMajor").combobox('getValue');
    var chargeStandardMajorField = $(toolbar).find("#chargeStandardMajorField").combobox('getValue');


    //!-AJAX请求数据
    $(datagrid).datagrid('load', {
      gradeId: chargeStandardGradeId,
      termType: chargeStandardTermType,
      majorId: chargeStandardMajor,
      majorFieldId:chargeStandardMajorField
    });
  }


  function toEditChargeStandard() {
    var row = $('#chargeStandardList').datagrid('getSelected');
    if (row) {
      if ($('#main').tabs('exists', '编辑收费标准')) {
        $('#main').tabs('close', '编辑收费标准')
      }
      openTab('fin/toEditChargeStandard.do?id=' + row.id, '编辑收费标准');


    }else{
      $.messager.alert("操作提示", "请选择要编辑的收费标准！","warning");
    }
  }

  function deleteChargeStandard(){
    var row = $('#chargeStandardList').datagrid('getSelected');
    if (row){

      $.messager.confirm('请确认...','您确定要删除此收费标准吗?',function(r){
        if (r){
          $.messager.confirm('请再次确认...','删除收费标准可能会导致数据混乱！',function(r){
            if(r){
              $.post('fin/deleteChargeStandard.do',{id:row.id},function(result){
                if (result.success){
                  $.messager.alert("操作提示", "删除收费标准成功！","info");
                  $('#chargeStandardList').datagrid('reload');
                } else {
                  $.messager.show({    // show error message
                    title: 'Error',
                    msg: '删除收费标准失败'
                  });
                }
              },'json');
            }
          });

        }
      });
    }else{
      $.messager.alert("操作提示", "请选择要删除的收费标准！","warning");
    }
  }

</script>
