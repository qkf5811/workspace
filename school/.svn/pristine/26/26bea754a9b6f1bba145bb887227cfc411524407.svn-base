<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="newGradeForm" method="post">
    <table cellpadding="7">


      <tr>
        <div style="margin-bottom: 20px">
          <td>年级名称:</td>
          <td><input class="easyui-validatebox textbox" id="newGradeName"
                     name="newGradeName"
                     data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>所属教育阶段:</td>
          <td><select class="easyui-combobox" id="newGradeEduStage" name="newGradeEduStage"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newGradeEduStage']" style="width:98px;height:30px;">
            <option value="">请选择</option>
            <c:forEach items="${eduStageList}" var="eduStage">
              <option value="${eduStage.id}">${eduStage.name}</option>
            </c:forEach>
          </select></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>顺序:</td>
          <td><input class="easyui-numberbox" id="newGradeSeq" type="text"
                     name="newGradeSeq"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>是否毕业年级:</td>
          <td><select class="easyui-combobox" id="newGradeIsGraduation" name="newGradeIsGraduation"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newGradeIsGraduation']" style="width:98px;height:30px;">
            <option value="">请选择</option>
            <c:forEach items="${isGraduationList}" var="isGraduation">
              <option value="${isGraduation.id}">${isGraduation.name}</option>
            </c:forEach>
          </select></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>备注:</td>

          <td><input class="easyui-validatebox textbox" type="text"
                     id="newGradeRemark" name="newGradeRemark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="addNewGrade('#newGradeForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>

</div>




<script type="text/javascript">

  //添加新年级
  function addNewGrade(form){
    //在提交数据之前执行表单验证
    $('#newGradeForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('sch/addGrade.do', {

      "name": $(form).find('#newGradeName').val(),
      "eduStageType": $(form).find('#newGradeEduStage').combobox('getValue'),
      "seq": $(form).find('#newGradeSeq').val(),
      "isGraduation": $(form).find('#newGradeIsGraduation').combobox('getValue'),
      "remark": $(form).find('#newGradeRemark').val()
    }, function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "添加年级成功！","info");
        $('#gradeList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","添加年级失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的年级信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","年级已存在!","warning");
      }
    }, "json");
  }

  function clearForm(){
      $('#newGradeForm').form('clear');

    //设置下拉框的选择为'请选择'
    $('#newGradeForm').find("#newGradeEduStage").combobox('setValue',"");
    $('#newGradeForm').find("#newGradeIsGraduation").combobox('setValue',"");
  }
</script>
