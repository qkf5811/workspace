<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="classRoomListToolbar" style="padding: 5px; height: auto">
    <div>
      <td>教室名称:</td>
      <td>
        <input class="easyui-textbox" id="classRoomName" style="width: 122px; height: 30px; padding: 5px" />
      </td>

      <td>所属校区:</td>
      <td>
        <select class="easyui-combobox" id="campusForList" name="campusForList"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true,onSelect:selectCampus" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${campusList}" var="campus">
            <option value="${campus.id}">${campus.name}</option>
          </c:forEach>

        </select>
        <select id="buildingIdForList" name="buildingIdForList" class="easyui-combobox" data-options="editable:false,disabled:true,panelHeight: 'auto',panelWidth: '114px'" style="width:114px;height:30px">

        </select>
      </td>

      <td>教室类型:</td>
      <td>
        <select class="easyui-combobox" id="classRoomTypeForList" name="classRoomTypeForList"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${roomTypeList}" var="roomType">
            <option value="${roomType.id}">${roomType.name}</option>
          </c:forEach>

        </select>
      </td>




      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchClassRoomList('#classRoomListToolbar', '#classRoomList')"
              iconCls="icon-search">查询
      </button>


    </div>
  </div>
  <table id="classRoomList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/sch/getClassRoomList.do" toolbar="#classRoomListOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>

      <th field="name" width="80" align="center">名称</th>
      <th field="campusName" width="80" align="center">所属校区</th>
      <th field="buildingName" width="80" align="center">所属教学楼</th>
      <th field="floor" width="100" align="center">所属楼层</th>
      <th field="capacity" width="100" align="center">教室容量(人)</th>
      <th field="roomTypeString" width="100" align="center">教室类型</th>
      <th field="remark" width="155" align="center">备注</th>

    </tr>
    </thead>
  </table>


  <div id="classRoomListOperToolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openTab('sch/toAddClassRoom.do','新建教室')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="toEditClassRoom()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="deleteClassRoom()">删除</a>
  </div>
</div>
<script type="text/javascript">

  //设置校区下拉框的选择触发事件
  function selectCampus(){

    var id=$("#campusForList").combobox("getValue");
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
        $("#buildingIdForList").combobox({
          valueField:'id',
          textField:'name',
          data:resultJson,
          editable:false,
          disabled:false

        });
      });


    }else{
      //设置教学楼下拉框为不可选
      $("#buildingIdForList").combobox('disable');
      $("#buildingIdForList").combobox('loadData',{});
      $("#buildingIdForList").combobox('setValue','');
    }

  }


  function searchClassRoomList(toolbar, datagrid) {

    var name = $(toolbar).find("#classRoomName").textbox('getValue');
    var campusForList = $(toolbar).find("#campusForList").combobox('getValue');
    var buildingIdForList = $(toolbar).find("#buildingIdForList").combobox('getValue');
    var classRoomTypeForList = $(toolbar).find("#classRoomTypeForList").combobox('getValue');

    //!-AJAX请求数据
    $(datagrid).datagrid('load', {
      name: name,
      campusId: campusForList,
      buildingId: buildingIdForList,
      roomType: classRoomTypeForList
    });
  }


  function toEditClassRoom() {
    var row = $('#classRoomList').datagrid('getSelected');
    if (row) {
      if ($('#main').tabs('exists', '编辑教室信息')) {
        $('#main').tabs('close', '编辑教室信息')
      }
      openTab('sch/toEditClassRoom.do?id=' + row.id, '编辑教室信息');


    }else{
      $.messager.alert("操作提示", "请选择要编辑的教室！","warning");
    }
  }

  function deleteClassRoom(){
    var row = $('#classRoomList').datagrid('getSelected');
    if (row){

      $.messager.confirm('请确认...','您确定要删除此教室吗?',function(r){
        if (r){
          $.messager.confirm('请再次确认...','删除教室可能会导致数据混乱！',function(r){
            if(r){
              $.post('sch/deleteClassRoom.do',{id:row.id},function(result){
                if (result.success){
                  $.messager.alert("操作提示", "删除教室成功！","info");
                  $('#classRoomList').datagrid('reload');
                } else {
                  $.messager.show({    // show error message
                    title: 'Error',
                    msg: '删除教室失败'
                  });
                }
              },'json');
            }
          });

        }
      });
    }else{
      $.messager.alert("操作提示", "请选择要删除的教室！","warning");
    }
  }

</script>
