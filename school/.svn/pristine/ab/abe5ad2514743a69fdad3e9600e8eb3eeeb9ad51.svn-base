<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="newChargeStandardForm" method="post">
    <table cellpadding="7">


      <tr>
        <div style="margin-bottom: 20px">
          <td>所属年级:</td>
          <td><select class="easyui-combobox" id="newChargeStandardGrade" name="newChargeStandardGrade"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newChargeStandardGrade']" style="width:98px;height:30px;">
            <option value="">请选择</option>
            <c:forEach items="${gradeList}" var="grade">
              <option value="${grade.id}">${grade.name}</option>
            </c:forEach>
          </select></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>学期类型:</td>
          <td><select class="easyui-combobox" id="newChargeStandardTermType" name="newChargeStandardTermType"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newChargeStandardTermType']" style="width:98px;height:30px;">
            <option value="">请选择</option>
            <c:forEach items="${termTypeList}" var="termType">
              <option value="${termType.id}">${termType.name}</option>
            </c:forEach>
          </select></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>所属专业:</td>

          <td><select class="easyui-combobox" id="newChargeStandardMajor" name="newChargeStandardMajor"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectMajor" validtype="selectRequired['newChargeStandardMajor']" style="width:98px;height:30px">
            <option value="">请选择</option>
            <c:forEach items="${majorList}" var="major">
              <option value="${major.id}">${major.name}</option>
            </c:forEach>

          </select>

          </td>

        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
        <td>所属专业方向:</td>
        <td>
          <select id="newChargeStandardMajorField" name="newChargeStandardMajorField" class="easyui-combobox" data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '160px'" validtype="selectRequired['newChargeStandardMajorField']" style="width:160px;height:30px">

        </select>
        </td>
          </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>学费:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="newChargeStandardTuitionFee" name="newChargeStandardTuitionFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 160px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>住宿费（男）:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="newChargeStandardRoomFeeBoy" name="newChargeStandardRoomFeeBoy" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 160px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>住宿费（女）:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="newChargeStandardRoomFeeGirl" name="newChargeStandardRoomFeeGirl" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 160px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>课本资料费:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="newChargeStandardBookFee" name="newChargeStandardBookFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 160px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="addNewChargeStandard('#newChargeStandardForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>

</div>



<script type="text/javascript">
  //设置专业信息下拉框的选择触发事件
  function selectMajor(){

    var id=$('#newChargeStandardForm').find("#newChargeStandardMajor").combobox("getValue");
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
        $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置专业方向下拉框为不可选
      $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('disable');
      $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('loadData',{});
      $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('setValue','');
    }

  }

  //添加收费标准
  function addNewChargeStandard(form){
    //在提交数据之前执行表单验证
    $('#newChargeStandardForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('fin/addChargeStandard.do', {
      "gradeId": $(form).find('#newChargeStandardGrade').combobox('getValue'),
      "termType": $(form).find('#newChargeStandardTermType').combobox('getValue'),
      "majorId": $(form).find('#newChargeStandardMajor').combobox('getValue'),
      "fieldId": $(form).find('#newChargeStandardMajorField').combobox('getValue'),
      "tuitionFee": $(form).find('#newChargeStandardTuitionFee').numberbox('getValue'),
      "roomFeeBoy": $(form).find('#newChargeStandardRoomFeeBoy').numberbox('getValue'),
      "roomFeeGirl": $(form).find('#newChargeStandardRoomFeeGirl').numberbox('getValue'),
      "bookFee": $(form).find('#newChargeStandardBookFee').numberbox('getValue')
    }, function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "添加收费标准成功！","info");
        $('#chargeStandardList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","添加收费标准失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的收费标准信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","收费标准已存在!","warning");
      }
    }, "json");
  }


  function clearForm(){
    $('#newChargeStandardForm').form('clear');
    //设置下拉框的选择为'请选择'

    $('#newChargeStandardForm').find("#newChargeStandardGrade").combobox('setValue',"");
    $('#newChargeStandardForm').find("#newChargeStandardTermType").combobox('setValue',"");
    $('#newChargeStandardForm').find("#newChargeStandardMajor").combobox('setValue',"");
    $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('setValue',"");
    $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('disable');
    $('#newChargeStandardForm').find("#newChargeStandardMajorField").combobox('loadData',{});
  }

</script>
