<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="newFunctionRoomForm" method="post">
    <table cellpadding="7">


      <tr>
        <div style="margin-bottom: 20px">
          <td>功能室名称:</td>
          <td><input class="easyui-validatebox textbox" id="newFunctionRoomName"
                     name="name"
                     data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
      <td>所属教学楼:</td>
      <td>
        <select class="easyui-combobox" id="newFunctionRoomBuildingId" name="buildingId"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectBuilding" 
                validtype="selectRequired['buildingId']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${building}" var="obj">
            <option value="${obj.id}">${obj.name}</option>
          </c:forEach>

        </select>

      </td>
      </tr>

      <tr>
        <td>所属教室:</td>
        <td><select id="newFunctionRoomRoomId" name="roomId" class="easyui-combobox"
         data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '98px'" 
         validtype="selectRequired['roomId']" style="width:98px;height:30px">
        </select>
        </td>

      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>备注:</td>

          <td><input class="easyui-validatebox textbox" type="text"
                     id="newFunctionRoomRemark" name="remark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="addNewFunctionRoom('#newFunctionRoomForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>

</div>




<script type="text/javascript">

  //设置校区下拉框的选择触发事件
  function selectBuilding(){

    var id=$("#newFunctionRoomBuildingId").combobox("getValue");
    if(id!=""){
      $.post('sch/getClassByBuildingId.do',{
        "id":id
      },function(data){
        //返回的是string字符串，需要把字符串转成json对象
        var resultJson=JSON.parse(data);
        //添加一个下拉框元素"请选择"
        var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
        //使用unshift方法，在resultJson前面加上firstSelectJson
        resultJson.unshift(firstSelectJson);

        //加载教学楼下拉框数据
        $("#newFunctionRoomRoomId").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置教学楼下拉框为不可选
      $("#newFunctionRoomRoomId").combobox('disable');
      $("#newFunctionRoomRoomId").combobox('loadData',{});
      $("#newFunctionRoomRoomId").combobox('setValue','');
    }

  }


  //添加新教室
  function addNewFunctionRoom(form){
    //在提交数据之前执行表单验证
     $('#newFunctionRoomForm').form('enableValidation').form('validate');
    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    } 

    $.post('equ/addFunctionRoom.do',
    $(form).serialize(), function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "添加功能室成功！","info");
        $('#FunctionRoomList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","添加功能室失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的功能室信息不完整!","warning");
      }else if(data.result==-2){
        $.messager.alert("操作提示","功能室已存在!","warning");
      }
    }, "json");
  }

  function clearForm(){
    $('#newFunctionRoomForm').form('clear');

    //设置下拉框的选择为'请选择'
    $('#newFunctionRoomForm').find("#newFunctionRoomBuildingId").combobox('setValue',"");
    $('#newFunctionRoomForm').find("#newFunctionRoomRoomId").combobox('setValue',"");
    $('#newFunctionRoomForm').find("#newFunctionRoomRoomId").combobox('disable');
    $('#newFunctionRoomForm').find("#newFunctionRoomRoomId").combobox('loadData',{});
  }
</script>