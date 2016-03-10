<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="classListToolbar" style="padding: 5px; height: auto">
    <div>

      <td>
        班别:
      </td>
      <td>
        <input class="easyui-textbox" id="classListName" style="width: 122px; height: 30px; padding: 5px">
      </td>

      <td>
        年级:
      </td>
      <td>
        <select class="easyui-combobox" id="classListGradeName" name="majorListForClass"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${gradeList}" var="grade">
            <option value="${grade.id}">${grade.name}</option>
          </c:forEach>

        </select>
      </td>

      <td>
       	 班主任:
      </td>
      <td>
        <input class="easyui-textbox" id="classListTeacherName" style="width: 122px; height: 30px; padding: 5px">
      </td>



      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchClassList('#classListToolbar', '#classList')"
              iconCls="icon-search">查询
      </button>

      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="cleanSearch('#classListToolbar')"
              iconCls="icon-reload" style="margin-left: 10px;" >清空
      </button>
    </div>
  </div>
  <table id="classList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/stu/getTheClassList.do" toolbar="#classListOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>
      <th field="name" width="80" align="center">班级名称</th>
      <th field="gradeName" width="80" align="center">年级</th>
      <th field="enrollYear" width="80" align="center">入学年份</th>
      <th field="teacherName" width="80" align="center">班主任</th>
      <th field="remark" width="155" align="center">备注</th>

    </tr>
    </thead>
  </table>


  <div id="classListOperToolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openTab('stu/toAddClass.do','新建班级')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="toEditClass()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="deleteClass()">删除</a>
  </div>
</div>





<script type="text/javascript">

  //设置专业信息下拉框的选择触发事件
  function selectMajor(){

      var id=$("#majorListForClass").combobox("getValue");
      if(id!=""){

        $.post('stu/getMajorFieldInfo.do',{
          "majorId":id
        },function(data){
          //返回的是string字符串，需要把字符串转成json对象
          var resultJson=JSON.parse(data);
          //添加一个下拉框元素"请选择"
          var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
          //使用unshift方法，在resultJson前面加上firstSelectJson
          resultJson.unshift(firstSelectJson);

          //加载专业方向下拉框数据
          $("#majorFieldListForClass").combobox({
            valueField:'id',
            textField:'name',
            data:resultJson,
            editable:false,
            disabled:false

          });
        });


      }else{
        //设置专业方向下拉框为不可选
        $("#majorFieldListForClass").combobox('disable');
        $("#majorFieldListForClass").combobox('loadData',{});
        $("#majorFieldListForClass").combobox('setValue','');
      }

  }


  function searchClassList(toolbar, datagrid) {

    var name = $(toolbar).find("#classListName").textbox('getValue');
    var gradeId = $(toolbar).find("#classListGradeName").combobox('getValue');
    var teacherName = $(toolbar).find("#classListTeacherName").textbox('getValue');
    //!-AJAX请求数据
    $(datagrid).datagrid('load', {

      name: name,
      gradeId: gradeId,
      teacherName: teacherName
    });
  }


  function toEditClass() {
    var row = $('#classList').datagrid('getSelected');
    if (row) {
      if ($('#main').tabs('exists', '编辑班级信息')) {
        $('#main').tabs('close', '编辑班级信息')
      }
      openTab('stu/toEditClass.do?id=' + row.id, '编辑班级信息');


    }else{
      $.messager.alert("操作提示", "请选择要编辑的班级！","warning");
    }
  }

  function deleteClass(){
    var row = $('#classList').datagrid('getSelected');
    if (row){

      $.messager.confirm('请确认...','您确定要删除此班级吗?',function(r){
        if (r){
          $.messager.confirm('请再次确认...','删除班级可能会导致数据混乱！',function(r){
            if(r){
              $.post('stu/deleteClass.do',{id:row.id},function(result){
                if (result.success){
                  $.messager.alert("操作提示", "删除班级成功！","info");
                  $('#classList').datagrid('reload');    // reload the user data
                } else {
                  $.messager.show({    // show error message
                    title: 'Error',
                    msg: '删除班级失败'
                  });
                }
              },'json');
            }
          });

        }
      });
    }else{
      $.messager.alert("操作提示", "请选择要删除的班级！","warning");
    }
  }

  function cleanSearch(toolbar){
   $(toolbar).find("#classListName").textbox('setValue','');
    $(toolbar).find("#classListGradeName").combobox('select',"");
    $(toolbar).find("#majorListForClass").combobox('select',"");
    $(toolbar).find("#classListTeacherName").textbox('setValue','');
  }
</script>
