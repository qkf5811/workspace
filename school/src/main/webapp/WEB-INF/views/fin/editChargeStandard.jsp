<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="editChargeStandardForm" method="post">
    <table cellpadding="7">
      <input id="id" name="id" type="hidden"
             value="<c:out value='${id}'/>" />

      <tr>
        <div style="margin-bottom: 20px">
          <td>所属年级:</td>
          <td><input class="easyui-textbox" id="editChargeStandardGrade"
                     name="editChargeStandardGrade"
                     disabled="true"
                     style="width: 216px; height: 30px; padding: 5px"/>
              <input id="editChargeStandardHiddenGrade" name="editChargeStandardHiddenGrade" type="hidden"/>
          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>学期类型:</td>
          <td><input class="easyui-textbox" id="editChargeStandardTermType"
                     name="editChargeStandardTermType"
                     disabled="true"
                     style="width: 216px; height: 30px; padding: 5px"/>
            <input id="editChargeStandardHiddenTermType" name="editChargeStandardHiddenTermType" type="hidden"/>
          </td>
        </div>
      </tr>


      <tr>
        <div style="margin-bottom: 20px">
          <td>所属专业方向:</td>

          <td>
            <input class="easyui-textbox" id="editChargeStandardMajor"
                   name="editChargeStandardMajor"
                   disabled="true"
                   style="width: 70px; height: 30px; padding: 5px"/>
            <input id="editChargeStandardHiddenMajor" name="editChargeStandardHiddenMajor" type="hidden"/>
            <input class="easyui-textbox" id="editChargeStandardMajorField"
                   name="editChargeStandardMajorField"
                   disabled="true"
                   style="width: 142px; height: 30px; padding: 5px"/>
            <input id="editChargeStandardHiddenMajorField" name="editChargeStandardHiddenMajorField" type="hidden"/>
          </td>

        </div>
      </tr>


      <tr>
        <div style="margin-bottom: 20px">
          <td>学费:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="editChargeStandardTuitionFee" name="editChargeStandardTuitionFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 216px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>住宿费（男）:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="editChargeStandardRoomFeeBoy" name="editChargeStandardTuitionFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 216px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>住宿费（女）:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="editChargeStandardRoomFeeGirl" name="editChargeStandardTuitionFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 216px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>课本资料费:</td>

          <td><input class="easyui-numberbox" type="text"
                     id="editChargeStandardBookFee" name="editChargeStandardBookFee" data-options="required:true,novalidate:true,validType:'length[5,20]',missingMessage:'该处未填写',invalidMessage:'字数范围为5-20',precision:3"
                     style="width: 216px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="editChargeStandard('#editChargeStandardForm')">修改</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="closeForm()">取消</a>
  </div>

</div>



<script type="text/javascript">

  $(function(){
    getChargrStandard("#editChargeStandardForm");
  });

  function getChargrStandard(form){
    var id=$(form).find("#id").val();
    $.post('fin/getChargeStandardByChargeStandardId.do',{
      "id":id
    },function(data){
      $(form).find("#editChargeStandardGrade").textbox('setValue',data.chargeStandard.gradeName);
      $(form).find("#editChargeStandardTermType").textbox('setValue',data.chargeStandard.termTypeString);
      $(form).find("#editChargeStandardMajor").textbox('setValue',data.chargeStandard.majorName);
      $(form).find("#editChargeStandardMajorField").textbox('setValue',data.chargeStandard.majorFieldName);
      $(form).find("#editChargeStandardTuitionFee").numberbox('setValue',data.chargeStandard.tuitionFee);
      $(form).find("#editChargeStandardRoomFeeBoy").numberbox('setValue',data.chargeStandard.roomFeeBoy);
      $(form).find("#editChargeStandardRoomFeeGirl").numberbox('setValue',data.chargeStandard.roomFeeGirl);
      $(form).find("#editChargeStandardBookFee").numberbox('setValue',data.chargeStandard.bookFee);
      $(form).find("#editChargeStandardHiddenGrade").val(data.chargeStandard.gradeId);
      $(form).find("#editChargeStandardHiddenTermType").val(data.chargeStandard.termType);
      $(form).find("#editChargeStandardHiddenMajor").val(data.chargeStandard.majorId);
      $(form).find("#editChargeStandardHiddenMajorField").val(data.chargeStandard.fieldId);



    },"json")
  }




  //修改收费标准
  function editChargeStandard(form){
    //在提交数据之前执行表单验证
    $('#editChargeStandardForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('fin/editChargeStandard.do', {
      "id":$(form).find('#id').val(),
      "gradeId": $(form).find('#editChargeStandardHiddenGrade').val(),
      "termType": $(form).find('#editChargeStandardHiddenTermType').val(),
      "majorId": $(form).find('#editChargeStandardHiddenMajor').val(),
      "fieldId": $(form).find('#editChargeStandardHiddenMajorField').val(),
      "tuitionFee": $(form).find('#editChargeStandardTuitionFee').numberbox('getValue'),
      "roomFeeBoy": $(form).find('#editChargeStandardRoomFeeBoy').numberbox('getValue'),
      "roomFeeGirl": $(form).find('#editChargeStandardRoomFeeGirl').numberbox('getValue'),
      "bookFee": $(form).find('#editChargeStandardBookFee').numberbox('getValue')
    }, function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "修改收费标准成功！","info");
        $('#chargeStandardList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","修改收费标准失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的收费标准信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","收费标准已存在!","warning");
      }
    }, "json");
  }


  function closeForm(){
    closeTab(getCurrentTab());
  }

</script>
