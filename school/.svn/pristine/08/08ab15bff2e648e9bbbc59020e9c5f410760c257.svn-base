<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
    <form id="newClassListForm" method="post">
        <table cellpadding="7">

            <tr>
                <div style="margin-bottom: 20px">
                    <td>所属年级:</td>
                    <td><select class="easyui-combobox" id="newClassGrade" name="newClassGrade"
                                data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['newClassGrade']" style="width:98px;height:30px;">
                        <option value="">请选择</option>
                        <c:forEach items="${gradeList}" var="grade">
                            <option value="${grade.id}">${grade.name}</option>
                        </c:forEach>
                    </select></td>
                </div>
            </tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td>班级名称:</td>
                    <td><input class="easyui-validatebox textbox" id="newClassName"
                               name="newClassName"
                               data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                               style="width: 200px; height: 18px; padding: 5px"/>

                    </td>
                </div>
            </tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td>入学年份:</td>
                    <td><input class="easyui-validatebox textbox" id="enrollYear" name="enrollYear"
                               data-options="validType:'length[2,10]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-10' "
                               style="width: 200px; height: 18px; padding: 5px"/>
                    </td>
                </div>
            </tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td>班主任:</td>
                    <input id="newClassTeacherId" name="newClassTeacherId" type="hidden" required="true">
                    <td><input class="easyui-textbox" type="text"
                               id="newClassTeacher" name="newClassTeacher"
                               data-options="buttonText:'请选择',buttonIcon:'icon-search',onClickButton:showTeachersDialog,required:true,novalidate:true,missingMessage:'该处未填写'" style="width: 216px; height: 30px; padding: 5px"></input></td>
                </div>
            </tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td>备注:</td>

                    <td><input class="easyui-validatebox textbox" type="text"
                               id="newStudyYearRemark" name="newStudyYearRemark"
                                style="width: 204px; height: 18px; padding: 5px"></input></td>
                </div>
            </tr>



        </table>
    </form>

    <div style="text-align: center; padding: 5px">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           onclick="addNewClass('#newClassListForm')">添加</a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            onclick="clearForm()">重置</a>
    </div>

</div>

<div id="selectTeacherByNewClass" class="easyui-dialog" title="教师列表" data-options="modal:true,iconCls:'icon-add',closed:true"
     style="width:500px;height:425px;padding:5px;" toolbar="#selectTeacherByNewClassToolbar" buttons="#selectTeacherByNewClassButton">
    <table id="selectTeaListByNewClass" class="easyui-datagrid" style="width: auto;"
           pagination="true" url="${contextPath}/tea/getTeaList.do"
           rownumbers="true" singleSelect="true" data-options="pageSize:10">
        <thead>
        <tr>
            <th field="code" width="100">教师编号</th>
            <th field="name" width="100">教师姓名</th>
        </tr>
        </thead>
    </table>

</div>

<div id="selectTeacherByNewClassToolbar">
    <div>
        教师编号:<input id="code">
        教师姓名:<input id="name">
        <button href="#" class="easyi-linkbutton" plain="true"
                onclick="searchTeacherByNewClass('#selectTeacherByNewClassToolbar', '#selectTeaListByNewClass')"
                iconCls="icon-search">查询</button>
    </div>

</div>

<div id="selectTeacherByNewClassButton">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="selectTeacherByNewClassInDatagrid()">选择</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#selectTeacherByNewClass').dialog('close')">取消</a>

</div>



<script type="text/javascript">

    //显示教师选择列表
    function showTeachersDialog(){

        $('#selectTeacherByNewClass').dialog('open');
    }

    //按教师姓名和教师编号搜索教师信息
    function searchTeacherByNewClass(toolbar, datagrid) {
        var name = $(toolbar).find("#name").val();
        var code = $(toolbar).find("#code").val();

        //!-AJAX请求数据
        $(datagrid).datagrid('load', {
            name: name,
            code: code
        });
    }

    //选择教师
    function selectTeacherByNewClassInDatagrid(){
        var row = $('#selectTeaListByNewClass').datagrid('getSelected');
        if(row){
            $("#newClassListForm").find("#newClassTeacher").textbox('setValue',row.name);
            $("#newClassListForm").find("#newClassTeacherId").val(row.id);

            $('#selectTeacherByNewClass').dialog('close');
        }
    }

    //添加新班级
    function addNewClass(form){
        //在提交数据之前执行表单验证
        $('#newClassListForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }

        $.post('stu/addClass.do', {

            "name": $(form).find('#newClassName').val(),
            "gradeId": $(form).find('#newClassGrade').combobox('getValue'),
            "enrollYear": $(form).find('#enrollYear').val(),
            "teacherId": $(form).find('#newClassTeacherId').val(),
            "remark": $(form).find('#newStudyYearRemark').val()
        }, function (data) {
            if(data.result>0){
                closeTab(getCurrentTab());
                $.messager.alert("操作提示", "添加班级成功！","info");
                $('#classList').datagrid('reload');
                //取消教师列表selectTeaListByNewClass的所选
                $('#selectTeaListByNewClass').datagrid('uncheckAll');
            }else if(data.result==0){
                $.messager.alert("操作提示","添加班级失败!","warning");
            }else if(data.result==-1){

                $.messager.alert("操作提示","输入的班级信息不完整!","warning");
            }else if(data.result==-2){

                $.messager.alert("操作提示","班级已存在!","warning");
            }
        }, "json");
    }


    function clearForm(){
        $('#newClassListForm').form('clear');
        //设置下拉框的选择为'请选择'

        $('#newClassListForm').find("#newClassGrade").combobox('setValue',"");
    }

</script>