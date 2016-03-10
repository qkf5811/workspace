<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div style="width: 99%; height: auto">
  <div id="sysLogToolbar" style="padding: 5px; height: auto">
    <div>

      <td>操作类型：</td>
      <td><select class="easyui-combobox" id="sysLogOperType" name="sysLogOperType"
                  data-options="editable:false,panelHeight: 'auto',panelWidth: '80px',novalidate:true"  style="width:80px;height:30px">
          <option value="">请选择</option>
          <c:forEach items="${operTypeList}" var="operType">
              <option value="${operType.id}">${operType.name}</option>
          </c:forEach>
      </select>


      </td>

      <td>用户姓名:</td>
      <td><input class="easyui-validatebox textbox" id="sysLogOperUserName"
                 name="sysLogOperUserName"
                 style="width: 100px; height: 18px; padding: 5px" />

      </td>
        <td>开始时间:</td>
        <td>
            <input class="easyui-datetimebox textbox" type="text"
                   id="sysLogStartTime" name="sysLogStartTime"
                   data-options="novalidate:true,required:true,editable:false,buttons:datetimeButtons " style="width: 100px; height: 30px; padding: 5px"></input>
        </td>
        <td>结束时间:</td>
        <td>
            <input class="easyui-datetimebox textbox" type="text"
                   id="sysLogStopTime" name="sysLogStopTime"
                   data-options="novalidate:true,required:true,editable:false,buttons:datetimeButtons " style="width: 100px; height: 30px; padding: 5px"></input>
        </td>
      <button href="#" class="easyui-linkbutton" plain="true"
              onclick="searchSysLog('#sysLogToolbar', '#sysLogList')"
              iconCls="icon-search">查询</button>
    </div>
  </div>
  <table id="sysLogList" class="easyui-datagrid" style="width: auto;"
         pagination="true" url="${contextPath}/user/getSysLogList.do" toolbar="#sysLogOperToolbar"
         rownumbers="true" singleSelect="true" data-options="pageSize:10">
    <thead>
    <tr>

      <th field="operTypeName" width="100" align="center">操作类型</th>
      <th field="operUserName" width="100" align="center">用户姓名</th>
      <th field="createTime" width="180" align="center">操作时间</th>


    </tr>
    </thead>
  </table>


</div>





  <script type="text/javascript">
    function searchSysLog(toolbar, datagrid) {

      var sysLogOperType = $(toolbar).find("#sysLogOperType").combobox('getValue');
      var sysLogOperUserName=$(toolbar).find("#sysLogOperUserName").val();
        var sysLogStartTime=$(toolbar).find("#sysLogStartTime").datebox('getValue');
        var sysLogStopTime=$(toolbar).find("#sysLogStopTime").datebox('getValue');

      //!-AJAX请求数据
      $(datagrid).datagrid('load', {
          operType:sysLogOperType,
          userName:sysLogOperUserName,
          startTime:sysLogStartTime,
          stopTime:sysLogStopTime
      });
    }
  </script>
