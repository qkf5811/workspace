<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="editGradeForm" method="post">
    <table cellpadding="7">
      <input id="id" name="id" type="hidden"
             value="<c:out value='${gradeId}'/>" />

      <tr>
        <div style="margin-bottom: 20px">
          <td>年级名称:</td>
          <td><input class="easyui-validatebox textbox" id="editGradeName"
                     name="editGradeName"
                     data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>所属教育阶段:</td>
          <td><select class="easyui-combobox" id="editGradeEduStage" name="editGradeEduStage"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['editGradeEduStage']" style="width:98px;height:30px;">
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
          <td><input class="easyui-numberbox" id="editGradeSeq" type="text"
                     name="editGradeSeq"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>是否毕业年级:</td>
          <td><select class="easyui-combobox" id="editGradeIsGraduation" name="editGradeIsGraduation"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['editGradeIsGraduation']" style="width:98px;height:30px;">
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
                     id="editGradeRemark" name="editGradeRemark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="editGrade('#editGradeForm')">修改</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="closeForm()">取消</a>
  </div>

</div>




<script type="text/javascript">
  $(function(){
    getGrade("#editGradeForm");
  });

  function getGrade(form){
    var id=$(form).find("#id").val();
    $.post('sch/getGradeByGradeId.do',{
      "id":id
    },function(data){
      $(form).find("#editGradeName").val(data.grade.name);
      $(form).find("#editGradeEduStage").combobox('select',data.grade.eduStageType);
      $(form).find("#editGradeSeq").numberbox('setValue',data.grade.seq);
      $(form).find("#editGradeIsGraduation").combobox('select',data.grade.isGraduation);

      $(form).find("#editGradeRemark").val(data.grade.remark);


    },"json")
  }


  //编辑年级
  function editGrade(form){
    //在提交数据之前执行表单验证
    $('#editGradeForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('sch/editGrade.do', {
      "id":$(form).find('#id').val(),
      "name": $(form).find('#editGradeName').val(),
      "eduStageType": $(form).find('#editGradeEduStage').combobox('getValue'),
      "seq": $(form).find('#editGradeSeq').val(),
      "isGraduation": $(form).find('#editGradeIsGraduation').combobox('getValue'),
      "remark": $(form).find('#editGradeRemark').val()
    }, function (result) {
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "修改年级成功！","info");
        $('#gradeList').datagrid('reload');

    }, "json");
  }

  function closeForm() {
    closeTab(getCurrentTab());
  }
</script>