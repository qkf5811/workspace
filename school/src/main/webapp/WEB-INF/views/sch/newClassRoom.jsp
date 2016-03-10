<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="newClassRoomForm" method="post">
    <table cellpadding="7">


      <tr>
        <div style="margin-bottom: 20px">
          <td>教室名称:</td>
          <td><input class="easyui-validatebox textbox" id="newClassRoomName"
                     name="newClassRoomName"
                     data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
      <td>所属校区:</td>
      <td>
        <select class="easyui-combobox" id="newClassRoomCampus" name="newClassRoomCampus"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectCampus" validtype="selectRequired['newClassRoomCampus']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${campusList}" var="campus">
            <option value="${campus.id}">${campus.name}</option>
          </c:forEach>

        </select>

      </td>
      </tr>

      <tr>
        <td>所属教学楼:</td>
        <td><select id="newClassRoomBuildingId" name="newClassRoomBuildingId" class="easyui-combobox" data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '98px'" validtype="selectRequired['newClassRoomBuildingId']" style="width:98px;height:30px">

        </select>
        </td>

      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>所属楼层:</td>
          <td><input class="easyui-numberbox" id="newClassRoomFloor" type="text"
                     name="newClassRoomFloor"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>教室容纳人数:</td>
          <td><input class="easyui-numberbox" id="newClassRoomCapacity" type="text"
                     name="newClassRoomCapacity"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <td>教室类型:</td>
      <td>
        <select class="easyui-combobox" id="newClassRoomType" name="newClassRoomType"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newClassRoomType']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${roomTypeList}" var="roomType">
            <option value="${roomType.id}">${roomType.name}</option>
          </c:forEach>

        </select>
      </td>

      <tr>
        <div style="margin-bottom: 20px">
          <td>备注:</td>

          <td><input class="easyui-validatebox textbox" type="text"
                     id="newClassRoomRemark" name="newClassRoomRemark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="addNewClassRoom('#newClassRoomForm')">添加</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="clearForm()">重置</a>
  </div>

</div>




<script type="text/javascript">

  //设置校区下拉框的选择触发事件
  function selectCampus(){

    var id=$("#newClassRoomCampus").combobox("getValue");
    if(id!=""){

      $.post('sch/getBuildingByCampusId.do',{
        "id":id
      },function(data){
        //返回的是string字符串，需要把字符串转成json对象
        var resultJson=JSON.parse(data);
        //添加一个下拉框元素"请选择"
        var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
        //使用unshift方法，在resultJson前面加上firstSelectJson
        resultJson.unshift(firstSelectJson);

        //加载教学楼下拉框数据
        $("#newClassRoomBuildingId").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置教学楼下拉框为不可选
      $("#newClassRoomBuildingId").combobox('disable');
      $("#newClassRoomBuildingId").combobox('loadData',{});
      $("#newClassRoomBuildingId").combobox('setValue','');
    }

  }


  //添加新教室
  function addNewClassRoom(form){
    //在提交数据之前执行表单验证
    $('#newClassRoomForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('sch/addClassRoom.do', {

      "name": $(form).find('#newClassRoomName').val(),
      "buildingId": $(form).find('#newClassRoomBuildingId').combobox('getValue'),
      "floor": $(form).find('#newClassRoomFloor').val(),
      "capacity": $(form).find('#newClassRoomCapacity').val(),
      "roomType": $(form).find('#newClassRoomType').combobox('getValue'),
      "remark": $(form).find('#newClassRoomRemark').val()
    }, function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "添加教室成功！","info");
        $('#classRoomList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","添加教室失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的教室信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","教室已存在!","warning");
      }
    }, "json");
  }

  function clearForm(){
    $('#newClassRoomForm').form('clear');

    //设置下拉框的选择为'请选择'
    $('#newClassRoomForm').find("#newClassRoomCampus").combobox('setValue',"");
    $('#newClassRoomForm').find("#newClassRoomBuildingId").combobox('setValue',"");
    $('#newClassRoomForm').find("#newClassRoomBuildingId").combobox('disable');
    $('#newClassRoomForm').find("#newClassRoomBuildingId").combobox('loadData',{});
    $('#newClassRoomForm').find("#newClassRoomType").combobox('setValue',"");
  }
</script>