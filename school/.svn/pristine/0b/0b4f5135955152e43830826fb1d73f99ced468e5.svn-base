<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
  <div id="sysConfigToolbar" style="padding: 5px; height: auto">
    <div>

      </td>

      <td>名称:</td>
      <td><input class="easyui-textbox" id="sysConfigName"
                 name="sysConfigName"
                 style="width: 122px; height: 30px; padding: 5px" />

      </td>

      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchSysConfig('#sysConfigToolbar', '#sysConfigList')"
              iconCls="icon-search">查询</button>
    </div>
  </div>
  <table id="sysConfigList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/sys/getSysConfigList.do" toolbar="#sysConfigOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>

      <th field="name" width="100" align="center">名称</th>
      <th field="code" width="120" align="center">编号</th>
      <th field="defaultValue" width="150" align="center">默认值</th>
      <th field="value" width="150" align="center">实际值</th>
      <th field="remark" width="100" align="center">备注</th>


    </tr>
    </thead>
  </table>


</div>





<script type="text/javascript">
  function searchSysConfig(toolbar, datagrid) {

    var name = $(toolbar).find("#sysConfigName").textbox('getValue');
    //!-AJAX请求数据
    $(datagrid).datagrid('load', {
      name:name
    });
  }
</script>
