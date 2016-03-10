<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
  <form id="editClassRoomForm" method="post">
    <table cellpadding="7">
      <input id="id" name="id" type="hidden"
             value="<c:out value='${classRoomId}'/>" />

      <tr>
        <div style="margin-bottom: 20px">
          <td>教室名称:</td>
          <td><input class="easyui-validatebox textbox" id="editClassRoomName"
                     name="editClassRoomName"
                     data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                     style="width: 200px; height: 18px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <td>所属校区:</td>
        <td>
          <select class="easyui-combobox" id="editClassRoomCampus" name="editClassRoomCampus"
                  data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectCampus" validtype="selectRequired['editClassRoomCampus']" style="width:98px;height:30px">
            <option value="">请选择</option>
            <c:forEach items="${campusList}" var="campus">
              <option value="${campus.id}">${campus.name}</option>
            </c:forEach>

          </select>

        </td>
      </tr>

      <tr>
        <td>所属教学楼:</td>
        <td><select id="editClassRoomBuildingId" name="editClassRoomBuildingId" class="easyui-combobox" data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '98px'" validtype="selectRequired['editClassRoomBuildingId']" style="width:98px;height:30px">

        </select>
        </td>

      </tr>
      <tr>
        <div style="margin-bottom: 20px">
          <td>所属楼层:</td>
          <td><input class="easyui-numberbox" id="editClassRoomFloor" type="text"
                     name="editClassRoomFloor"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <tr>
        <div style="margin-bottom: 20px">
          <td>教室容纳人数:</td>
          <td><input class="easyui-numberbox" id="editClassRoomCapacity" type="text"
                     name="editClassRoomCapacity"
                     data-options="required:true,missingMessage:'该处未填写',novalidate:true "
                     style="width: 215px; height: 30px; padding: 5px"/>

          </td>
        </div>
      </tr>

      <td>教室类型:</td>
      <td>
        <select class="easyui-combobox" id="editClassRoomType" name="editClassRoomType"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['editClassRoomType']" style="width:98px;height:30px">
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
                     id="editClassRoomRemark" name="editClassRoomRemark"
                     style="width: 204px; height: 18px; padding: 5px"></input></td>
        </div>
      </tr>



    </table>
  </form>

  <div style="text-align: center; padding: 5px">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       onclick="editClassRoom('#editClassRoomForm')">保存</a> <a
          href="javascript:void(0)" class="easyui-linkbutton"
          onclick="closeForm()">取消</a>
  </div>

</div>




<script type="text/javascript">

  $(function(){
    getClassRoom("#editClassRoomForm");
  });

  function getClassRoom(form){
    var id=$(form).find("#id").val();
    $.post('sch/getClassRoomByClassRoomId.do',{
      "id":id
    },function(data){
      $(form).find("#editClassRoomName").val(data.classRoom.name);
      $(form).find("#editClassRoomCampus").combobox('select',data.classRoom.campusId);


      //在一段时间后再设置教学楼下拉框的值
      function selectBuildingIdBySetTimeout(){
        $(form).find("#editClassRoomBuildingId").combobox('select',data.classRoom.buildingId);
      }

      setTimeout(selectBuildingIdBySetTimeout,200);
      $(form).find("#editClassRoomFloor").numberbox('setValue',data.classRoom.floor);
      $(form).find("#editClassRoomCapacity").numberbox('setValue',data.classRoom.capacity);
      $(form).find("#editClassRoomType").combobox('select',data.classRoom.roomType);
      $(form).find("#editClassRoomRemark").val(data.classRoom.remark);


    },"json")
  }

  //设置校区信息下拉框的选择触发事件
  function selectCampus(){

    var id=$("#editClassRoomCampus").combobox("getValue");
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
        $("#editClassRoomBuildingId").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置教学楼下拉框为不可选
      $("#editClassRoomBuildingId").combobox('disable');
      $("#editClassRoomBuildingId").combobox('loadData',{});
      $("#editClassRoomBuildingId").combobox('setValue','');
    }

  }


  //编辑教室
  function editClassRoom(form){
    //在提交数据之前执行表单验证
    $('#editClassRoomForm').form('enableValidation').form('validate');

    //判断表单验证是否通过
    if(!$(form).form('validate')){
      return false;
    }

    $.post('sch/editClassRoom.do', {

      "id" : $(form).find('#id').val(),
      "name": $(form).find('#editClassRoomName').val(),
      "buildingId": $(form).find('#editClassRoomBuildingId').combobox('getValue'),
      "floor": $(form).find('#editClassRoomFloor').val(),
      "capacity": $(form).find('#editClassRoomCapacity').val(),
      "roomType": $(form).find('#editClassRoomType').combobox('getValue'),
      "remark": $(form).find('#editClassRoomRemark').val()
    }, function (data) {
      if(data.result>0){
        closeTab(getCurrentTab());
        $.messager.alert("操作提示", "编辑教室成功！","info");
        $('#classRoomList').datagrid('reload');

      }else if(data.result==0){
        $.messager.alert("操作提示","编辑教室失败!","warning");
      }else if(data.result==-1){

        $.messager.alert("操作提示","输入的教室信息不完整!","warning");
      }else if(data.result==-2){

        $.messager.alert("操作提示","教室已存在!","warning");
      }
    }, "json");
  }

  function closeForm() {
    closeTab(getCurrentTab());
  }
</script>
