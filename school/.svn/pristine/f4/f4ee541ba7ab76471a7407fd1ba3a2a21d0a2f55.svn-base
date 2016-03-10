<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="width: 99%; height: auto">
    <div id="stuListToolbar" style="padding: 5px; height: auto">
        <div>
            <td>
                学生姓名:
            </td>
            <td>
                <input class="easyui-textbox" id="stuListName" style="width: 122px; height: 30px; padding: 5px">
            </td>

            <td>班级:</td>

            <td>
                <input class="easyui-textbox" id="stuListClass" style="width: 150px; height: 30px; padding: 5px">
            </td>

            <td>性别:</td>
            <td><select class="easyui-combobox" id="stuListSex" name="stuListSex"
                        data-options="editable:false,panelHeight: 'auto',panelWidth: '62px',novalidate:true"
                        style="height:30px;width:63px">
                <option value="">请选择</option>
                <c:forEach items="${sexList}" var="sex">
                    <option value="${sex.id}">${sex.name}</option>
                </c:forEach>
            </select>
            </td>
            <td>注册状态:</td>
            <td><select class="easyui-combobox" id="stuListStatus" name="stuListStatus"
                        data-options="editable:false,panelHeight: 'auto',panelWidth: '62px',novalidate:true"
                        style="height:30px;width:63px">
                <option value="">请选择</option>
                <c:forEach items="${statusList}" var="status">
                    <option value="${status.id}">${status.name}</option>
                </c:forEach>
            </select>
            </td>
            <td>学籍状态:</td>
            <td><select class="easyui-combobox" id="stuListStudentStatus" name="stuListStudentStatus"
                        data-options="editable:false,panelHeight: 'auto',panelWidth: '80px',novalidate:true"
                        style="height:30px;width:81px">
                <option value="">请选择</option>
                <c:forEach items="${studentStatusList}" var="studentStatus">
                    <option value="${studentStatus.id}">${studentStatus.name}</option>
                </c:forEach>
            </select>
            </td>


            <button href="#" class="easyui-linkbutton" plain="true"
                    onclick="searchStudent('#stuListToolbar', '#stuList')"
                    iconCls="icon-search">查询
            </button>
        </div>
    </div>
    <table id="stuList" class="easyui-datagrid" style="width: auto;"
           pagination="true" url="${contextPath}/stu/getStuList.do" toolbar="#stuListOperToolbar"
           rownumbers="true" singleSelect="true" data-options="pageSize:10">
        <thead>
        <tr>
            <th field="code" width="80" align="center">学号</th>
            <th field="name" width="80" align="center">学生姓名</th>
            <th field="sex" width="35" align="center">性别</th>
            <th field="className" width="80" align="center">班级</th>
            <th field="birthday" width="100" align="center">出生年月</th>
            <th field="idCard" width="155" align="center">身份证</th>
            <th field="nation" width="80" align="center">民族</th>
            <th field="nativePlace" width="100" align="center">籍贯</th>
            <th field="householdTypeString" width="60" align="center">户口类型</th>
            <th field="householdLocation" width="100" align="center">户籍所在地</th>
            <th field="politicalFeatureTypeString" width="60" align="center">政治面貌</th>
            <th field="isHkMcString" width="60" align="center">是否港澳</th>
            <th field="familyAddress" width="100" align="center">家庭住址</th>
            <th field="postcode" width="60" align="center">邮政编码</th>
            <th field="familyPhone" width="110" align="center">家庭电话</th>
            <th field="examineeTypeString" width="80" align="center">考生类别</th>
            <th field="graduationSchool" width="100" align="center">毕业学校</th>
            <th field="examTotalScore" width="60" align="center">入学总分</th>
            <th field="studyTypeString" width="60" align="center">学习形式</th>
            <th field="enterSchoolTypeString" width="60" align="center">入学方式</th>
            <th field="eduStageTypeString" width="60" align="center">招生起点</th>
            <th field="stuStatus" width="60" align="center">注册状态</th>
            <th field="studentStatusString" width="60" align="center">学籍状态</th>
<%----%>
        </tr>
        </thead>
    </table>


    <div id="stuListOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true"
           onclick="toStuListDetail()">详细信息</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
           onclick="toEditStuListDetail()">基本信息编辑</a>
    </div>
</div>

<script type="text/javascript">
    function searchStudent(toolbar, datagrid) {

        var name = $(toolbar).find("#stuListName").textbox('getValue');
        var className = $(toolbar).find("#stuListClass").textbox('getValue');
        var sex = $(toolbar).find("#stuListSex").combobox('getValue');
        var status = $(toolbar).find("#stuListStatus").combobox('getValue');
        var studentStatus = $(toolbar).find("#stuListStudentStatus").combobox('getValue');
        //!-AJAX请求数据
        $(datagrid).datagrid('load', {

            name: name,
            className: className,
            sexType: sex,
            status: status,
            studentStatus:studentStatus
        });
    }

    function toStuListDetail() {
        var row = $('#stuList').datagrid('getSelected');
        if (row) {
            if ($('#main').tabs('exists', '学生详细资料')) {
                $('#main').tabs('close', '学生详细资料');
            }
            openTab('stu/toGetStuListDetail.do?id=' + row.id, '学生详细资料');


        }else{
            $.messager.alert("操作提示", "请选择要查看的在籍生！","warning");
        }
    }
    function toEditStuListDetail() {
        var row = $('#stuList').datagrid('getSelected');
        if (row) {
            if ($('#main').tabs('exists', '编辑学生信息')) {
                $('#main').tabs('close', '编辑学生信息')
            }
            openTab('stu/toEditStuListDetail.do?id=' + row.id, '编辑学生信息');


        }else{
            $.messager.alert("操作提示", "请选择要编辑的在籍生！","warning");
        }
    }


</script>   