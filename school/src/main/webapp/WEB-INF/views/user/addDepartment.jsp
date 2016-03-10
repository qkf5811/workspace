<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="newDepartmentForm" method="post">
    <table cellpadding="7">


      <tr>
        <div style="margin-bottom: 20px">
          <td>部门名称:</td>
          <td><input class="easyui-validatebox textbox" id="departmentName"
                     name="departmentName"
                     data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>






      <tr>
        <div style="margin-bottom: 20px">
          <td>隶属部门：</td>

          <td><select class="easyui-combobox" id="parentDepartment" name="parentDepartment"
                      data-options="required:true,missingMessage:'该处未选择',editable:false,panelHeight: 'auto',panelWidth: 'auto',novalidate:true"  style="height:30px">
            <option value="0">无</option>
            <c:forEach items="${departments}" var="department">
              <option value="${department.id}">${department.name}</option>
            </c:forEach>

          </select></td>

        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>备注:</td>
          <td><input class="easyui-validatebox textbox" id="departmentRemark"
                     name="departmentRemark"
                     data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>





    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="addDepartment('#newDepartmentForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>

</div>



<script type="text/javascript">
  function addDepartment(form) {

    //在提交数据之前执行表单验证
    $('#newDepartmentForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }


    var departmentName = $(form).find("#departmentName").val();

    var departmentId = $(form).find("#parentDepartment").combobox('getValue');

    var departmentRemark = $(form).find("#departmentRemark").val();


    /* if (account == "") {
     $.messager.alert("操作提示", "帐号不能为空！","warning");
     return;
     }
     if (password == "") {
     $.messager.alert("操作提示", "密码不能为空！","warning");
     return;
     }
     if (name == "") {
     $.messager.alert("操作提示", "姓名不能为空！","warning");
     return;
     } */


    $.post('user/addDepartment.do', {

      "name" : departmentName,
      "parentId" : departmentId,
      "remark" : departmentRemark

    }, function(data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "添加部门成功！","info");
        /*$('#userList').datagrid('reload');*/
      }else if(data.result==0){
        $.messager.alert("操作提示","添加部门失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的部门信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","部门已存在!","warning");
      }
    }, "json")
  }

  function clearForm() {
    $('#newDepartmentForm').form('clear');
  }
</script>

<!-- <script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
selectRequired: {
validator: function (value, param) {
var selectVal = $("input[name=" + param[0] + "]").val();
$("#msg").html(selectVal);
return parseInt(selectVal) > 0;
},
message:'该处未选择'
}
})
</script> -->

<style scoped="scoped">
  .textbox {
    height: 20px;
    margin: 0;
    padding: 0 2px;
    box-sizing: content-box;
  }
</style>
