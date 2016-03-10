<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div style="width: 99%; height: auto">
    <div id="studyYearListToolbar" style="padding: 5px; height: auto">
        <div>


            <%--<button href="#" class="easyui-linkbutton" plain="true"
                    onclick="searchUser('#studyYearListToolbar', '#studyYearListList')"
                    iconCls="icon-search">查询</button>--%>
        </div>
    </div>
    <table id="studyYearList" class="easyui-datagrid" style="width: auto;"
           pagination="true" url="${contextPath}/sch/getStudyYearList.do" toolbar="#studyYearListOperToolbar"
           rownumbers="true" singleSelect="true" data-options="pageSize:10">
        <thead>
        <tr>
            <th field="name" width="100" align="center">学年年度</th>
            <th field="startDate" width="100" align="center">开始日期</th>
            <th field="endDate" width="100" align="center">结束日期</th>
            <th field="remark" width="100" align="center">备注</th>

        </tr>
        </thead>
    </table>


    <!-- 弹出新建学年的窗口 -->
    <div id="newStudyYear" class="easyui-window" title="新建学年" data-options="modal:true,iconCls:'icon-add',closed:true"
         style="width:340px;height:340px;padding:5px;">
        <form id="newStudyYearForm" method="post">

            <table text-align="center" cellspacing="10">
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="newStudyYearName">学年:</label></td>
                        <td><input class="easyui-validatebox textbox"
                                   id="newStudyYearName" name="newStudyYearName"
                                   style="width: 150px; height: 15px; padding: 10px;font-size: 15px;"
                                   data-options="prompt:'请输入学年名',iconWidth:38,required:true,validType:'length[3,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' ">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="newStudyYearStartDate">开始日期:</label></td>
                        <td><input class="easyui-datebox textbox" type="text"
                                   id="newStudyYearStartDate" name="newStudyYearStartDate"
                                   style="width: 150px; height: 30px; padding: 12px"
                                   data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="newStudyYearEndDate">结束日期:</label></td>
                        <td><input class="easyui-datebox textbox" type="text"
                                   id="newStudyYearEndDate" name="newStudyYearEndDate"
                                   style="width: 150px; height: 30px; padding: 12px"
                                   data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="newStudyYearRemark">备注:</label></td>
                        <td><input class="easyui-validatebox textbox"
                                   id="newStudyYearRemark" name="newStudyYearRemark"
                                   style="width: 150px; height: 15px; padding: 10px;font-size: 15px;"
                                   data-options="prompt:'请输入备注',iconWidth:38,missingMessage:'该处未填写',novalidate:true ">
                        </td>
                    </div>
                </tr>
                <%-- <tr height="10px"><td></td></tr>
                 <tr>

                   <div style="margin-bottom: 20px">
                     <td align="right"><label for="newRemark">备注:</label></td> <td><input class="easyui-validatebox textbox"
                                                                                          id="newRemark" name="newRemark"
                                                                                          style="width: 300px; height: 20px; padding: 12px"
                                                                                          data-options="prompt:'备注(可不填)',iconWidth:38">
                   </td></div>
                 </tr>--%>
            </table>


        </form>

        <div style="text-align: center;margin:25px 0 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="addStudyYear('#newStudyYearForm')" style="margin-right:20px;"> <span
                    style="font-size: 14px;">提交</span>
            </a><a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="$('#newStudyYear').window('close');$('#newStudyYearForm').form('clear');"> <span
                style="font-size: 14px;"> 取消</span>
        </a>
        </div>
    </div>


    <!-- 弹出修改学年的窗口 -->
    <div id="editStudyYear" class="easyui-window" title="新建学年" data-options="modal:true,iconCls:'icon-add',closed:true"
         style="width:340px;height:340px;padding:5px;">
        <form id="editStudyYearForm" method="post">

            <table text-align="center" cellspacing="10">
                <input id="editStudyYearId" type="hidden">
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="editStudyYearName">学年:</label></td>
                        <td><input class="easyui-validatebox textbox"
                                   id="editStudyYearName" name="editStudyYearName"
                                   style="width: 150px; height: 15px; padding: 10px;font-size: 15px;"
                                   data-options="prompt:'请输入学年名',iconWidth:38,required:true,validType:'length[3,100]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' ">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="editStudyYearStartDate">开始日期:</label></td>
                        <td><input class="easyui-datebox textbox" type="text"
                                   id="editStudyYearStartDate" name="editStudyYearStartDate"
                                   style="width: 150px; height: 30px; padding: 12px"
                                   data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="editStudyYearEndDate">结束日期:</label></td>
                        <td><input class="easyui-datebox textbox" type="text"
                                   id="editStudyYearEndDate" name="editStudyYearEndDate"
                                   style="width: 150px; height: 30px; padding: 12px"
                                   data-options="novalidate:true,required:true,missingMessage:'该处未选择',editable:false">
                        </td>
                    </div>
                </tr>
                <tr>
                    <div style="margin-bottom: 20px">
                        <td><label for="editStudyYearRemark">备注:</label></td>
                        <td><input class="easyui-validatebox textbox"
                                   id="editStudyYearRemark" name="editStudyYearRemark"
                                   style="width: 150px; height: 15px; padding: 10px;font-size: 15px;"
                                   data-options="prompt:'请输入备注',iconWidth:38,missingMessage:'该处未填写',novalidate:true">
                        </td>
                    </div>
                </tr>

            </table>


        </form>

        <div style="text-align: center;margin:25px 0 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'" onclick="updateStudyYear('#editStudyYearForm')" style="margin-right:20px;"> <span
                    style="font-size: 14px;">提交</span>
            </a><a href="javascript:void(0)" class="easyui-linkbutton"
                   data-options="iconCls:'icon-cancel'" onclick="$('#editStudyYear').window('close');$('#editStudyYearForm').form('clear');"> <span
                style="font-size: 14px;"> 取消</span>
        </a>
        </div>
    </div>

    <div id="studyYearListOperToolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
           onclick="$('#newStudyYear').window('open');">新建</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditStudyYear()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
           onclick="deleteStudyYear()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true"
           onclick="findCurrentStudyYearAndTermTypeDialog('#currentStudyYearAndTermTypeForm')">当前学年和学期</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-filter" plain="true"
           onclick="openChangeDefaultStudyYearAndTermTypeDialog()">设置当前学年和学期</a>

    </div>


    <div id="changeDefaultStudyYearAndTermTypeDialog" class="easyui-dialog" closed="true" style="padding:5px;width:350px;height:200px;"
         title="设置当前学年和学期" iconCls="icon-search" modal="true"
         toolbar="" buttons="#changeDefaultStudyYearAndTermTypeButtons">
        <form id="changeDefaultStudyYearAndTermTypeForm" method="post">
        <table cellpadding="7">
            <tr>
                <div style="margin-bottom: 20px">
                    <td>所选学年：</td>
                    <td><input class="easyui-textbox" id="changeDefaultStudyYear" name="changeDefaultStudyYear" disabled="true" style="width: 180px; height: 30px; padding: 5px"></td>
                    </div>
                </tr>

        <tr>
            <div style="margin-bottom: 20px">
                <td>所选学期:</td>
                <td><select class="easyui-combobox" id="changeDefaultTermType" name="changeDefaultTermType"
                            data-options="editable:false,panelHeight: 'auto',panelWidth: '98px',novalidate:true" validtype="selectRequired['changeDefaultTermType']" style="width:98px;height:30px;">

                </select></td>
            </div>
        </tr>
            </table>
            </form>
        <div id="changeDefaultStudyYearAndTermTypeButtons">
            <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="changeDefaultStudyYear('#changeDefaultStudyYearAndTermTypeForm')">提交</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#changeDefaultStudyYearAndTermTypeDialog').dialog('close')">取消</a>
        </div>
    </div>


    <div id="currentStudyYearAndTermTypeDialog" class="easyui-dialog" closed="true" style="padding:5px;width:350px;height:200px;"
         title="查看当前学年和学期" iconCls="icon-search" modal="true"
         toolbar="" buttons="">
        <form id="currentStudyYearAndTermTypeForm" method="post">
            <table cellpadding="7">
                <tr>
                    <div style="margin-bottom: 20px">
                        <td>所选学年：</td>
                        <td><input class="easyui-textbox" id="currentStudyYear" name="currentStudyYear" disabled="true" style="width: 180px; height: 30px; padding: 5px"></td>
                    </div>
                </tr>

                <tr>
                    <div style="margin-bottom: 20px">
                        <td>所选学期:</td>
                        <td>
                            <input class="easyui-textbox" id="currentTermType" name="currentTermType" disabled="true" style="width: 180px; height: 30px; padding: 5px">
                            </td>
                    </div>
                </tr>
            </table>
        </form>

    </div>

</div>

<script type="text/javascript">
    function searchUser(toolbar, datagrid) {
        /* var account=$(toolbar).find("#account").val();
         var name = $(toolbar).find("#name").val();*/

        //!-AJAX请求数据
        $(datagrid).datagrid('load', {});
    }


    function addStudyYear(form) {

        //在提交数据之前执行表单验证
        $('#newStudyYearForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }


        $.post('sch/addStudyYear.do', {

            "name": $(form).find('#newStudyYearName').val(),
            "startDate": $(form).find('#newStudyYearStartDate').datebox('getValue'),
            "endDate": $(form).find('#newStudyYearEndDate').datebox('getValue'),
            "remark": $(form).find('#newStudyYearRemark').val()
        }, function (data) {
            if(data.result>0){
                $.messager.alert("操作提示", "添加学年成功！","info");
                $('#newStudyYear').window('close');
                $('#newStudyYearForm').form('clear');
                $('#newStudyYearForm').form('disableValidation').form('validate');
                $('#studyYearList').datagrid('reload');
            }else if(data.result==0){
                $.messager.alert("操作提示","添加学年失败!","warning");
            }else if(data.result==-1){

                $.messager.alert("操作提示","输入的学年信息不完整!","warning");
            }else if(data.result==-2){

                $.messager.alert("操作提示","学年已存在!","warning");
            }

        }, "json");
    }


    function toEditStudyYear(){
        var row=$('#studyYearList').datagrid('getSelected');
        if(row){
            $('#editStudyYearForm').find('#editStudyYearId').val(row.id);
            $('#editStudyYearForm').find('#editStudyYearName').val(row.name);
            $('#editStudyYearForm').find('#editStudyYearStartDate').datebox('setValue',row.startDate);
            $('#editStudyYearForm').find('#editStudyYearEndDate').datebox('setValue',row.endDate);
            $('#editStudyYearForm').find('#editStudyYearRemark').val(row.remark);
            $('#editStudyYear').window('open');
        }else{
            $.messager.alert("操作提示", "请选择要编辑的学年！","warning");
        }
    }
    function updateStudyYear(form){

        //在提交数据之前执行表单验证
        $('#editStudyYearForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }

        $.post('sch/updateStudyYear.do',{
            "id":$('#editStudyYearForm').find('#editStudyYearId').val(),
            "name": $('#editStudyYearForm').find('#editStudyYearName').val(),
            "startDate": $('#editStudyYearForm').find('#editStudyYearStartDate').datebox('getValue'),
            "endDate": $('#editStudyYearForm').find('#editStudyYearEndDate').datebox('getValue'),
            "remark": $('#editStudyYearForm').find('#editStudyYearRemark').val()
        },function(result){
            $('#editStudyYear').window('close');
            $.messager.alert("操作提示", "修改学年成功！","info");
            $('#studyYearList').datagrid('reload');
        }, "json");

    }

    function deleteStudyYear(){
        var row=$('#studyYearList').datagrid('getSelected');
        if (row){

            $.messager.confirm('请确认...','您确定要删除此学年吗?',function(r) {
                if (r) {
                    $.messager.confirm('请再次确认...','删除学年可能会导致数据混乱！',function(r){
                        if (r){
                            $.post('sch/deleteStudyYear.do',{id:row.id},function(result){
                                if (result.success){
                                    $.messager.alert("操作提示", "删除学年成功！","info");
                                    $('#studyYearList').datagrid('reload');
                                } else {
                                    $.messager.show({    // show error message
                                        title: 'Error',
                                        msg: '删除学年失败'
                                    });
                                }
                            },'json');
                        }
                    });
                }
            });


        }else{
            $.messager.alert("操作提示", "请选择要删除的学年！","warning");
        }
    }

    function openChangeDefaultStudyYearAndTermTypeDialog(){

        var row=$('#studyYearList').datagrid('getSelected');
        if(row){
            $("#changeDefaultStudyYear").textbox('setValue', row.name);
            $.post('sch/getAllTermType.do',{

            },function(data){
                //返回的是string字符串，需要把字符串转成json对象
                var resultJson=JSON.parse(data);
                //添加一个下拉框元素"请选择"
                var firstSelectJson=JSON.parse("{\"id\":\"\",\"name\":\"请选择\"}");
                //使用unshift方法，在resultJson前面加上firstSelectJson
                resultJson.unshift(firstSelectJson);

                //加载专业方向下拉框数据
                $("#changeDefaultTermType").combobox({
                    valueField:'id',
                    textField:'name',
                    data:resultJson,
                    editable:false,
                    disabled:false

                });
            });
            $("#changeDefaultStudyYearAndTermTypeDialog").dialog('open');
        }else{
            $.messager.alert("操作提示", "请选择要设置的学年！","warning");
        }


    }

    function changeDefaultStudyYear(form){

        //在提交数据之前执行表单验证
        $('#changeDefaultStudyYearAndTermTypeForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }

        var row=$('#studyYearList').datagrid('getSelected');
        var termType=$(form).find('#changeDefaultTermType').combobox('getValue');
        if (row){
            $.messager.confirm('请确认...','您确定要设置为当前学年和学期吗?',function(r) {
                if (r) {
                            $.post('sch/changeDefaultStudyYear.do',{id:row.id,termType:termType},function(result){
                                if (result.success){
                                    $.messager.alert("操作提示", "设置当前学年和学期成功！","info");
                                    $('#studyYearList').datagrid('reload');
                                    $("#changeDefaultStudyYearAndTermTypeDialog").dialog('close');
                                } else {
                                    $.messager.show({    // show error message
                                        title: 'Error',
                                        msg: '设置当前学年和学期失败'
                                    });

                        }
                    },'json');
                }
            });


        }else{
            $.messager.alert("操作提示", "请选择要设置的学年！","warning");
        }
    }

    function findCurrentStudyYearAndTermTypeDialog(form){
        $.post('sch/getCurrentStudyYearAndTermType.do',function(data){

            $(form).find('#currentStudyYear').textbox('setValue',data.studyYear);
            $(form).find('#currentTermType').textbox('setValue',data.termType);

        },'json');

        $("#currentStudyYearAndTermTypeDialog").dialog('open');
    }
</script>

<style>


    span.datebox {
        font-size: 20px;
    }
</style>