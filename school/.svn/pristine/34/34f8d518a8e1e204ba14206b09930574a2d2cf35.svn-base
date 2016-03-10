<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<form id="editStuListDetailForm" method="post">
  <table cellpadding="7">

    <input id="editStuListDetailId" name="editStuListDetailId" type="hidden"
           value="<c:out value='${id}'/>" />
    <tr>
      <div style="margin-bottom: 20px">
        <td>学生名:</td>
        <td><input class="easyui-validatebox textbox" id="stuListDetailName"
                   name="stuListDetailName"
                   data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                   style="width: 200px; height: 18px; padding: 5px"/>

        </td>
      </div>
    </tr>

    <tr>
      <div style="margin-bottom: 20px">
        <td>性别:</td>
        <td><select class="easyui-combobox" id="stuListDetailSex" name="stuListDetailSex"
                    data-options="editable:false,panelHeight: 'auto',panelWidth: '92px'" style="width:89px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${sexList}" var="sex">
            <option value="${sex.id}">${sex.name}</option>
          </c:forEach>

        </select></td>
      </div>
    </tr>

    <tr>
        <div style="margin-bottom: 20px">
            <td>出生年月:</td>
            <td><input class="easyui-datebox textbox" type="text" id="stuListDetailBirthday" name="stuListDetailBirthday"
                        data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false" style="width: 208px; height: 30px; padding: 5px"></input></td>
        </div>
    </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>身份证:</td>

              <td><input class="easyui-validatebox textbox" type="text" id="stuListDetailIdCard"
                         name="stuListDetailIdCard" data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>

    <tr>
      <div style="margin-bottom: 20px">
        <td>民族：</td>

        <td><select class="easyui-combobox" id="stuListDetailNation" name="stuListDetailNation"
                    data-options="editable:false,panelHeight: '200px',panelWidth: '92px'" style="width:89px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${nationList}" var="nation">
            <option value="${nation.id}">${nation.name}</option>
          </c:forEach>

        </select></td>

      </div>
    </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>籍贯:</td>

              <td><input class="easyui-validatebox textbox" type="text"
                         id="stuListDetailNativePlace" name="stuListDetailNativePlace"
                         data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>户口类型：</td>

              <td><select class="easyui-combobox" id="stuListDetailHouseholdType" name="stuListDetailHouseholdType"
                          data-options="editable:false,panelHeight: 'auto',panelWidth: '92px'" style="width:89px;height:30px">
                  <option value="">请选择</option>
                  <c:forEach items="${houseHoldList}" var="houseHold">
                      <option value="${houseHold.id}">${houseHold.name}</option>
                  </c:forEach>

              </select></td>

          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>户籍所在地:</td>

              <td><input class="easyui-validatebox textbox" type="text"
                         id="stuListDetailHouseholdLocation" name="stuListDetailHouseholdLocation"
                         data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>政治面貌：</td>

              <td><select class="easyui-combobox" id="stuListDetailPoliticalFeatureType" name="stuListDetailPoliticalFeatureType"
                          data-options="editable:false,panelHeight: 'auto',panelWidth: '92px'" style="width:89px;height:30px">
                  <option value="">请选择</option>
                  <c:forEach items="${politicalFeatureList}" var="politicalFeature">
                      <option value="${politicalFeature.id}">${politicalFeature.name}</option>
                  </c:forEach>

              </select></td>

          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>是否港澳：</td>

              <td><select class="easyui-combobox" id="stuListDetailIsHkMc" name="stuListDetailIsHkMc"
                          data-options="editable:false,panelHeight: 'auto',panelWidth: '92px'" style="width:89px;height:30px">
                  <option value="">请选择</option>
                  <c:forEach items="${isHkMcList}" var="isHkMc">
                      <option value="${isHkMc.id}">${isHkMc.name}</option>
                  </c:forEach>

              </select></td>

          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>家庭住址:</td>

              <td><input class="easyui-validatebox textbox" type="text"
                         id="stuListDetailFamilyAddress" name="stuListDetailFamilyAddress"
                         data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>邮政编码:</td>

              <td><input class="easyui-validatebox textbox" type="text"
                         id="stuListDetailPostcode" name="stuListDetailPostcode"
                         data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>

      <tr>
          <div style="margin-bottom: 20px">
              <td>家庭电话:</td>

              <td><input class="easyui-validatebox textbox" type="text"
                         id="stuListDetailFamilyPhone" name="stuListDetailFamilyPhone"
                         data-options="required:true,novalidate:true" style="width: 200px; height: 18px; padding: 5px"></input></td>
          </div>
      </tr>








  </table>
</form>

<div style="text-align: center; padding: 5px">
  <a href="javascript:void(0)" class="easyui-linkbutton"
     onclick="editStuListDetail('#editStuListDetailForm')">提交</a> <a
        href="javascript:void(0)" class="easyui-linkbutton"
        onclick="closeForm()">取消</a>
</div>

</div>

<script type="text/javascript">

    $(function(){
        getTheEditStuListDetail("#editStuListDetailForm");
    });

    function getTheEditStuListDetail(form){
        var id=$(form).find("#editStuListDetailId").val();
        $.post('stu/getStuListDetail.do',{
            "id":id
        },function(data){
            $(form).find("#stuListDetailName").val(data.name);
            $(form).find("#stuListDetailSex").combobox('select',data.sexType);
            $(form).find('#stuListDetailBirthday').datebox('setValue',data.birthday);
            $(form).find("#stuListDetailIdCard").val(data.idCard);
            $(form).find("#stuListDetailNation").combobox('select',data.nationType);
            $(form).find("#stuListDetailNativePlace").val(data.nativePlace);
            $(form).find("#stuListDetailHouseholdType").combobox('select',data.householdType);
            $(form).find("#stuListDetailHouseholdLocation").val(data.householdLocation);
            $(form).find("#stuListDetailPoliticalFeatureType").combobox('select',data.politicalFeatureType);
            $(form).find("#stuListDetailIsHkMc").combobox('select',data.isHkMc);
            $(form).find("#stuListDetailFamilyAddress").val(data.familyAddress);
            $(form).find("#stuListDetailPostcode").val(data.postcode);
            $(form).find("#stuListDetailFamilyPhone").val(data.familyPhone);
        },"json")
    }
    function editStuListDetail(form) {

        //开启单个文本框验证
        $("#editStuListDetailForm").find("#stuListDetailName").validatebox('enableValidation').validatebox('validate');

        //判断表单验证是否通过
        /*if(!$(form).form('validate')){
            return false;
        }*/

        //对单个文本框进行验证，返回true或者false
        if($("#editStuListDetailForm").find("#stuListDetailName").validatebox('isValid')==false){
            return false;
        }

        var editStuListDetailId = $(form).find("#editStuListDetailId").val();
        var stuListDetailName = $(form).find("#stuListDetailName").val();
        var stuListDetailSex = $(form).find("#stuListDetailSex").combobox('getValue');
        var stuListDetailBirthday=$(form).find('#stuListDetailBirthday').datebox('getValue');
        var stuListDetailIdCard=$(form).find("#stuListDetailIdCard").val();

        var stuListDetailNation = $(form).find("#stuListDetailNation").combobox('getValue');
        var stuListDetailNativePlace=$(form).find("#stuListDetailNativePlace").val();
        var stuListDetailHouseholdType=$(form).find("#stuListDetailHouseholdType").combobox('getValue');
        var stuListDetailHouseholdLocation=$(form).find("#stuListDetailHouseholdLocation").val();
        var stuListDetailPoliticalFeatureType=$(form).find("#stuListDetailPoliticalFeatureType").combobox('getValue');
        var stuListDetailIsHkMc=$(form).find("#stuListDetailIsHkMc").combobox('getValue');
        var stuListDetailFamilyAddress=$(form).find("#stuListDetailFamilyAddress").val();
        var stuListDetailPostcode=$(form).find("#stuListDetailPostcode").val();
        var stuListDetailFamilyPhone=$(form).find("#stuListDetailFamilyPhone").val();


        $.post('stu/editStuListDetail.do', {
            "id" : editStuListDetailId,
            "name" : stuListDetailName,
            "sexType" : stuListDetailSex,
            "birthday" : stuListDetailBirthday,
            "idCard" : stuListDetailIdCard,
            "nationType" : stuListDetailNation,
            "nativePlace" : stuListDetailNativePlace,
            "householdType" : stuListDetailHouseholdType,
            "householdLocation" : stuListDetailHouseholdLocation,
            "politicalFeatureType" : stuListDetailPoliticalFeatureType,
            "isHkMc" : stuListDetailIsHkMc,
            "familyAddress" : stuListDetailFamilyAddress,
            "postcode" : stuListDetailPostcode,
            "familyPhone" : stuListDetailFamilyPhone

        }, function(result) {
            closeTab(getCurrentTab());
            $.messager.alert("操作提示", "修改学生信息成功！","info");
            $('#stuList').datagrid('reload');
        }, "json")
    }

    function closeForm() {
       closeTab(getCurrentTab());
    }
</script>


<style scoped="scoped">
    .textbox {
        height: 20px;
        margin: 0;
        padding: 0 2px;
        box-sizing: content-box;
    }
</style>
