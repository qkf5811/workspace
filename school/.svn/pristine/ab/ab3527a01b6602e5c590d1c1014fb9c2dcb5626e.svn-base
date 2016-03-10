<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="editClassListForm" method="post">
    <table cellpadding="7">
      <input id="id" name="id" type="hidden"
             value="<c:out value='${classId}'/>" />

      <tr>
        <div style="margin-bottom: 20px">
          <td>所属年级:</td>
          <td><select class="easyui-combobox" id="editClassGrade" name="editClassGrade"
                      data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['editClassGrade']" style="width:98px;height:30px;">
            <option value="">请选择</option>
            <c:forEach items="${gradeList}" var="grade">
              <option value="${grade.id}">${grade.name}</option>
            </c:forEach>
          </select></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>班级名称:</td>
          <td><input class="easyui-validatebox textbox" id="editClassName"
                     name="editClassName"
                     data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>入学年份:</td>
          <td><input class="easyui-validatebox textbox" id="enrollYear" name="enrollYear"
                     data-options="validType:'length[2,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-10' "
                     style="width: 200px; height: 18px; padding: 5px"/>
          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>班主任:</td>
          <input id="editClassTeacherId" name="editClassTeacherId" type="hidden" required="true">
          <td><input class="easyui-textbox" type="text"
                     id="editClassTeacher" name="editClassTeacher"
                     data-options="buttonText:'请选择',buttonIcon:'icon-search',onClickButton:showTeachersDialog,editable:false,required:true,novalidate:true,missingMessage:'该处未填写'" style="width: 216px; height: 30px; padding: 5px"></input></td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>备注:</td>

          <td><input class="easyui-validatebox textbox" type="text"
                     id="editStudyYearRemark" name="editStudyYearRemark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="editClass('#editClassListForm')">修改</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="closeForm()">取消</a>
  </div>

</div>

<div id="selectTeacherByEditClass" class="easyui-dialog" title="教师列表" data-options="modal:true,iconCls:'icon-add',closed:true"
     style="width:500px;height:425px;padding:5px;" toolbar="#selectTeacherByEditClassToolbar" buttons="#selectTeacherByEditClassButton">
  <table id="selectTeaListByEditClass" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/tea/getTeaList.do"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>
      <th field="code" width="100">教师编号</th>
      <th field="name" width="100">教师姓名</th>
    </tr>
    </thead>
  </table>

</div>

<div id="selectTeacherByEditClassToolbar">
  <div>
    教师编号:<input id="code">
    教师姓名:<input id="name">
    <button href="#" class="easyi-linkbutton" plain="true"
            onclick="searchTeacherByEditClass('#selectTeacherByEditClassToolbar', '#selectTeaListByEditClass')"
            iconCls="icon-search">查询</button>
  </div>

</div>

<div id="selectTeacherByEditClassButton">
  <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectTeacherByEditClassInDatagrid()">选择</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#selectTeacherByEditClass').dialog('close')">取消</a>

</div>



<script type="text/javascript">
  $(function(){
    getClass("#editClassListForm");
  });

  function getClass(form){
    var id=$(form).find("#id").val();
    $.post('stu/getClazzByClazzId.do',{
      "id":id
    },function(data){
    	$(form).find("#editClassGrade").combobox('select',data.clazz.gradeId);
      	$(form).find("#editClassName").val(data.clazz.name);
      	$(form).find("#enrollYear").val(data.clazz.enrollYear);
      	$(form).find("#editClassTeacherId").val(data.clazz.teacherId);
      	$(form).find("#editClassTeacher").textbox('setValue',data.clazz.teacherName);
      	$(form).find("#editStudyYearRemark").val(data.clazz.remark);
    },"json")
  }


  //显示教师选择列表
  function showTeachersDialog(){

    $('#selectTeacherByEditClass').dialog('open');
  }

  //按教师姓名和教师编号搜索教师信息
  function searchTeacherByEditClass(toolbar, datagrid) {
    var name = $(toolbar).find("#name").val();
    var code = $(toolbar).find("#code").val();

    //!-AJAX请求数据
    $(datagrid).datagrid('load', {
      name: name,
      code: code
    });
  }

  //选择教师
  function selectTeacherByEditClassInDatagrid(){
    var row = $('#selectTeaListByEditClass').datagrid('getSelected');
    if(row){
      $("#editClassListForm").find("#editClassTeacher").textbox('setValue',row.name);
      $("#editClassListForm").find("#editClassTeacherId").val(row.id);

      $('#selectTeacherByEditClass').dialog('close');
    }
  }

  //修改班级
  function editClass(form){
    //在提交数据之前执行表单验证
    $('#editClassListForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('stu/editClass.do', {
      "id":$(form).find('#id').val(),
      "name": $(form).find('#editClassName').val(),
      "gradeId": $(form).find('#editClassGrade').combobox('getValue'),
      "enrollYear": $(form).find('#enrollYear').val(),
      "teacherId": $(form).find('#editClassTeacherId').val(),
      "remark": $(form).find('#editStudyYearRemark').val()
    }, function (result) {
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "修改班级成功！","info");
        $('#classList').datagrid('reload');
        //取消教师列表selectTeaListByEditClass的所选
        $('#selectTeaListByEditClass').datagrid('uncheckAll');

    }, "json");
  }

  function closeForm() {
    closeTab(getCurrentTab());
  }
</script>
