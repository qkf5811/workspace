<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
  <div id="gradeListToolbar" style="padding: 5px; height: auto">
    <div>
      <td>
        年级名称:
      </td>
      <td>
        <input class="easyui-textbox" id="gradeName" style="width: 122px; height: 30px; padding: 5px">
      </td>

      <td>教育阶段类型:</td>
      <td>
        <select class="easyui-combobox" id="eduStage" name="eduStage"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['eduStage']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${eduStageList}" var="eduStage">
            <option value="${eduStage.id}">${eduStage.name}</option>
          </c:forEach>

        </select>
      </td>
      <td>是否毕业年级:</td>
      <td>
        <select class="easyui-combobox" id="isGraduation" name="isGraduation"
                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['isGraduation']" style="width:98px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${isGraduationList}" var="isGraduation">
            <option value="${isGraduation.id}">${isGraduation.name}</option>
          </c:forEach>

        </select>
      </td>



      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchGradeList('#gradeListToolbar', '#gradeList')"
              iconCls="icon-search">查询
      </button>


    </div>
  </div>
  <table id="gradeList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/sch/getGradeList.do" toolbar="#gradeListOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>

      <th field="name" width="80" align="center">名称</th>
      <th field="eduStageTypeString" width="80" align="center">教育阶段</th>
      <th field="seq" width="50" align="center">顺序</th>
      <th field="isGraduationString" width="110" align="center">是否为毕业年级</th>
      <th field="remark" width="155" align="center">备注</th>

    </tr>
    </thead>
  </table>


  <div id="gradeListOperToolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openTab('sch/toAddGrade.do','新建年级')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
       onclick="toEditGrade()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="deleteGrade()">删除</a>
  </div>
</div>
<script type="text/javascript">




  function searchGradeList(toolbar, datagrid) {

    var name = $(toolbar).find("#gradeName").textbox('getValue');
    var eduStage = $(toolbar).find("#eduStage").combobox('getValue');
    var isGraduation = $(toolbar).find("#isGraduation").combobox('getValue');

    //!-AJAX请求数据
    $(datagrid).datagrid('load', {
      name: name,
      eduStageType: eduStage,
      isGraduation: isGraduation
    });
  }


  function toEditGrade() {
    var row = $('#gradeList').datagrid('getSelected');
    if (row) {
      if ($('#main').tabs('exists', '编辑年级信息')) {
        $('#main').tabs('close', '编辑年级信息')
      }
      openTab('sch/toEditGrade.do?id=' + row.id, '编辑年级信息');


    }else{
      $.messager.alert("操作提示", "请选择要编辑的年级！","warning");
    }
  }

  function deleteGrade(){
    var row = $('#gradeList').datagrid('getSelected');
    if (row){

      $.messager.confirm('请确认...','您确定要删除此年级吗?',function(r){
        if (r){
          $.messager.confirm('请再次确认...','删除年级可能会导致数据混乱！',function(r){
            if(r){
              $.post('sch/deleteGrade.do',{id:row.id},function(result){
                if (result.success){
                  $.messager.alert("操作提示", "删除年级成功！","info");
                  $('#gradeList').datagrid('reload');
                } else {
                  $.messager.show({    // show error message
                    title: 'Error',
                    msg: '删除年级失败'
                  });
                }
              },'json');
            }
          });

        }
      });
    }else{
      $.messager.alert("操作提示", "请选择要删除的年级！","warning");
    }
  }

</script>