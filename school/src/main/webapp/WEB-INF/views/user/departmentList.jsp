<%--
  Created by IntelliJ IDEA.
  User: sk
  Date: 2015/5/11
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<table>
    <tr>
        <td>
<div class="easyui-panel" style="padding:5px;width:270px;height: 590px">
<div id="departmentOperToolbar" style="margin:15px 0;">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="toAddChildrenDepartment()">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="toEditChildrenDepartment('#editDepartmentForm')">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteChildrenDepartment()">删除</a>

</div>
<div class="easyui-panel" style="padding:5px;width:260px;height: 501px">
<ul id="tt"></ul>
</div>



    </div>
        </td>
        <td>
            <div class="easyui-panel" style="padding:5px;width:900px;height: 590px">
                <table id="userListForDepartmentList" class="easyui-datagrid" style="width: auto;"
                       pagination="true" url="${contextPath}/user/getUserList.do" toolbar=""
                       rownumbers="true" singleSelect="true" data-options="pageSize:10">
                    <thead>
                    <tr>
                        <th field="name" width="100" align="center">姓名</th>
                        <th field="sex" width="100" align="center">性别</th>
                        <th field="departmentName" width="100" align="center">所属部门</th>
                        <th field="roleName" width="100" align="center">角色</th>
                        <th field="email" width="100" align="center">注册邮箱</th>
                        <th field="mobile" width="100" align="center">移动电话</th>
                        <th field="address" width="100" align="center">地址</th>
                        <th field="isBlockedString" width="100" align="center">是否冻结</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </td>
    </tr>
</table>



<div id="newChildrenDepartment" class="easyui-window" title="添加子部门" data-options="modal:true,iconCls:'icon-add',closed:true" style="width:350px;height:285px;padding:5px;">
    <form id="newDepartmentForm" method="post">
        <table text-align="center">


            <tr>
                <div style="margin-bottom: 20px">
                    <td><label for="departmentName">部门名称:</label></td>
                    <td><input class="easyui-validatebox textbox" id="departmentName"
                               name="departmentName"
                               data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                               style="width: 200px; height: 20px; padding: 8px;font-size:15px"/>

                    </td>
                </div>
            </tr>



            <tr height="10px"><td></td></tr>


            <tr>
                <div style="margin-bottom: 20px">
                    <td>隶属部门：</td>

                    <td><select class="easyui-combobox" id="parentDepartment" name="parentDepartment"
                                data-options="required:true,missingMessage:'该处未选择',editable:false,panelHeight: 'auto',panelWidth: '115px',novalidate:true,valueField:'id',textField:'name'"  style="height:30px;width: 115px">


                    </select></td>

                </div>
            </tr>


            <tr height="10px"><td></td></tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td><label for="departmentRemark">备注:</label></td>
                    <td><input class="easyui-validatebox textbox" id="departmentRemark"
                               name="departmentRemark"

                               style="width: 200px; height: 20px; padding: 8px;font-size:15px"/>

                    </td>
                </div>
            </tr>





        </table>
    </form>

    <div style="text-align: center; padding: 25px 0 0;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" onclick="addChildrenDepartment('#newDepartmentForm')"><span style="font-size:14px">提交</span></a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            data-options="iconCls:'icon-cancel'" onclick="closeNewDepartmentForm()"><span style="font-size:14px">取消</span></a>
    </div>

</div>


<div id="editChildrenDepartment" class="easyui-window" title="更改子部门" data-options="modal:true,iconCls:'icon-add',closed:true" style="width:350px;height:285px;padding:5px;">
    <form id="editDepartmentForm" method="post">
        <table text-align="center">


            <tr>
                <div style="margin-bottom: 20px">
                    <input id="editDepartmentId" type="hidden">
                    <td><label for="editDepartmentName">部门名称:</label></td>
                    <td><input class="easyui-validatebox textbox" id="editDepartmentName"
                               name="editDepartmentName"
                               data-options="required:true,validType:'length[2,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为2-20' "
                               style="width: 200px; height: 20px; padding: 8px;font-size:15px"/>

                    </td>
                </div>
            </tr>



            <tr height="10px"><td></td></tr>


            <tr>
                <div style="margin-bottom: 20px">
                    <td>隶属部门：</td>

                    <td><select class="easyui-combobox" id="editParentDepartment" name="editParentDepartment"
                                data-options="required:true,missingMessage:'该处未选择',editable:false,panelHeight: 'auto',panelWidth: '115px',novalidate:true,valueField:'id',textField:'name'"  style="height:30px;width: 115px">


                    </select></td>

                </div>
            </tr>


            <tr height="10px"><td></td></tr>

            <tr>
                <div style="margin-bottom: 20px">
                    <td><label for="editDepartmentRemark">备注:</label></td>
                    <td><input class="easyui-validatebox textbox" id="editDepartmentRemark"
                               name="editDepartmentRemark"

                               style="width: 200px; height: 20px; padding: 8px;font-size:15px"/>

                    </td>
                </div>
            </tr>





        </table>
    </form>

    <div style="text-align: center; padding: 25px 0 0;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           data-options="iconCls:'icon-ok'" onclick="editChildrenDepartment('#editDepartmentForm')"><span style="font-size:14px">提交</span></a> <a
            href="javascript:void(0)" class="easyui-linkbutton"
            data-options="iconCls:'icon-cancel'" onclick="closeEditDepartmentForm()"><span style="font-size:14px">取消</span></a>
    </div>

</div>

<script type="text/javascript">
    $("#tt").tree({
        lines:true,
      url:"${contextPath}/user/findAllDepartment.do",
        onBeforeExpand:function(data){

            $("#tt").tree("options").url="${contextPath}/user/findAllDepartment.do";
        },onClick:function(data){
            $("#userListForDepartmentList").datagrid('load', {
                departmentId:$('#tt').tree('getSelected').id
            });
        }/*,onSelect:function(data){
            $(this).tree('toggle',data.target);
        }*/
    });

</script>
<script type="text/javascript">
    function toAddChildrenDepartment(){
        //判断是否有选择部门
        if($('#tt').tree('getSelected')==null){
            $.messager.alert("操作提示","请选择要添加子部门的部门!","warning");

            return false;
        }

        $('#newChildrenDepartment').window('open');

       $.post('user/toAddDepartment.do',{

        },function(data){
            //返回的是string字符串，需要把字符串转成json对象
           var resultJson=JSON.parse(data);

           //添加一个最高父节点
           var superJson=JSON.parse("{\"id\":0,\"parentId\":0,\"name\":\"全部\",\"remark\":\"全部\"}");
           //使用unshift方法，在resultJson前面加上superJson
           resultJson.unshift(superJson);

           //把返回的json数据赋值到combobox
           $('#newDepartmentForm').find('#parentDepartment').combobox({
               data:resultJson


           });

           //获取所选的树状结构的部门id
           var parentDepartmentId=($('#tt').tree('getSelected').id);

           //根据parentDepartmentId改变默认所选项
           $('#newDepartmentForm').find('#parentDepartment').combobox('select',parentDepartmentId);

        });



    }

    function addChildrenDepartment(form){

        //在提交数据之前执行表单验证
        $('#newDepartmentForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }

        var departmentName = $(form).find("#departmentName").val();

        var departmentId = $(form).find("#parentDepartment").combobox('getValue');

        var departmentRemark = $(form).find("#departmentRemark").val();

        $.post('user/addDepartment.do', {

            "name" : departmentName,
            "parentId" : departmentId,
            "remark" : departmentRemark

        }, function(data) {

            if(data.result>0){


                $.messager.alert("操作提示", "添加部门成功！","info");

                //假如添加子节点的父节点本身是没有子节点的，需要使用append方法添加一个无数据的节点，否则下面的reload方法无法执行。
                $('#tt').tree('append',{
                    parent:$('#tt').tree('find',departmentId).target,
                    data:[{

                    }]
                });


                $('#newChildrenDepartment').window('close');

                $('#newDepartmentForm').form('clear');

                //根据所选的父节点id找到该父节点并返回target，用于执行reload方法，从而刷新该父节点的内容
              $('#tt').tree('reload',$('#tt').tree('find',departmentId).target);

            }else if(data.result==0){
                $.messager.alert("操作提示","添加部门失败!","warning");
            }else if(data.result==-1){

                $.messager.alert("操作提示","输入的部门信息不完整!","warning");
            }else if(data.result==-2){

                $.messager.alert("操作提示","部门已存在!","warning");
            }
        }, "json")

    }


    function toEditChildrenDepartment(form){

        //判断是否有选择部门
        if($('#tt').tree('getSelected')==null){
            $.messager.alert("操作提示","请选择要编辑的部门!","warning");

            return false;
        }


        $('#editChildrenDepartment').window('open');

        $.post('user/toEditDepartment.do',{

        },function(data){
            //返回的是string字符串，需要把字符串转成json对象
            var resultJson=JSON.parse(data);

            //添加一个最高父节点
            var superJson=JSON.parse("{\"id\":0,\"parentId\":0,\"name\":\"全部\",\"remark\":\"全部\"}");
            //使用unshift方法，在resultJson前面加上superJson
            resultJson.unshift(superJson);

            //把返回的json数据赋值到combobox
            $(form).find('#editParentDepartment').combobox({
                data:resultJson


            });

            //获取所选的节点id(部门id)并赋值到editDepartmentId
            $(form).find('#editDepartmentId').val($('#tt').tree('getSelected').id);
            //获取所选的节点text(部门name)并赋值到editDepartmentName
            $(form).find('#editDepartmentName').val($('#tt').tree('getSelected').text);

            //判断所选的节点是否为根节点，假如是根节点则没有父节点。根节点id默认为0
            if($('#tt').tree('getSelected').id!=0) {
                //获取所选的节点parentId(父部门id)并改变combobox的默认所选项
                $(form).find('#editParentDepartment').combobox('select', $('#tt').tree('getSelected').attributes.parentId);
            }
            //获取所选的节点remark(部门的remark)并赋值到editDepartmentRemark
            $(form).find('#editDepartmentRemark').val($('#tt').tree('getSelected').remark);


        });


    }

    function editChildrenDepartment(form){
        $('#editDepartmentForm').form('enableValidation').form('validate');

        //判断表单验证是否通过
        if(!$(form).form('validate')){
            return false;
        }

        var departmentId=$(form).find("#editDepartmentId").val();
        var departmentName = $(form).find("#editDepartmentName").val();

        var parentDepartmentId = $(form).find("#editParentDepartment").combobox('getValue');

        var departmentRemark = $(form).find("#editDepartmentRemark").val();


        //判断所选的父部门是否为当前要更改的部门
        if(departmentId==parentDepartmentId){
            $.messager.alert('My Title','父部门和子部门相同!','warning');
            return;
        }

        //获取要修改的部门的父部门id
        var checkParentDepartmentId=parentDepartmentId;

        //通过遍历，判断所选的父部门是否属于所选部门的子部门
        for(;checkParentDepartmentId!=0;){
            //根据所选的父部门id获取父部门，从而获取父部门的父部门id
            checkParentDepartmentId=$('#tt').tree('getParent',  $('#tt').tree('find',checkParentDepartmentId).target).id;

            //判断遍历出来的父部门id是否与所选部门id相同
            if(checkParentDepartmentId==$('#tt').tree('getSelected').id){
                $.messager.alert('My Title','父部门不能直接成为其子部门的子部门!','warning');
                return;
            }
        }



        $.post('user/editDepartment.do',{
            "id":departmentId,
            "name" : departmentName,
            "parentId" : parentDepartmentId,
            "remark" : departmentRemark
        },function(data){
            if(data.result==-2) {
                $.messager.alert("操作提示", "部门名重复！", "warning");
            }else{
                $.messager.alert("操作提示", "编辑部门名成功！", "info");
                $('#editChildrenDepartment').window('close');

                /*alert($('#tt').tree('getSelected').attributes.parentId);
                 alert(parentDepartmentId);*/



                //判断原来的父部门id和提交的父部门id是否一样
                if($('#tt').tree('getSelected').attributes.parentId==parentDepartmentId){

                    //根据提交的父部门id执行reload方法，刷新提交的父部门id所在位置
                    $('#tt').tree('reload',$('#tt').tree('find',parentDepartmentId).target);
                }else {

                    //在提交的父部门id所在位置执行添加节点的方法。因为假如提交的父节点本身是没有子节点的，需要使用append方法添加一个无数据的节点，否则下面的reload方法无法执行。
                    $('#tt').tree('append',{
                        parent:$('#tt').tree('find', parentDepartmentId).target,
                        data:[{

                        }]
                    });

                    //删除所选的旧节点位置
                    $('#tt').tree('remove',$('#tt').tree('getSelected').target);

                    //根据提交的父部门id执行reload方法，刷新提交的父部门id所在位置
                    $('#tt').tree('reload', $('#tt').tree('find', parentDepartmentId).target);
                }
            }


        }, "json");

    }


    function deleteChildrenDepartment(){

        //判断是否有选择部门
        if($('#tt').tree('getSelected')==null){
            $.messager.alert("操作提示","请选择要删除的部门!","warning");

            return false;
        }

        //判断所选部门是否含有子部门
        if($('#tt').tree('getSelected').state=='closed'||$('#tt').tree('getSelected').state=='open'&&$('#tt').tree('getChildren',$('#tt').tree('getSelected').target).length>0){

            $.messager.confirm("请确认","要删除该部门及其所有子部门吗？",function(r){
                if(r){
                    $.post('user/deleteDepartment.do',{
                       "departmentId":$('#tt').tree('getSelected').id
                    },function(result){
                        if(result.success){
                            //根据所选节点的父部门id执行reload方法，刷新父部门位置的信息
                            $('#tt').tree('reload', $('#tt').tree('find',  $('#tt').tree('getSelected').attributes.parentId).target);
                            $.messager.alert("操作提示", "删除部门及其所有子部门成功！", "info");

                        }
                    },'json');
                }
            });

        }else{

            $.messager.confirm("请确认","要删除该部门吗？",function(r){
                if(r){
                    $.post('user/deleteDepartment.do',{
                        "departmentId":$('#tt').tree('getSelected').id
                    },function(result){

                        if(result.success){
                            $.messager.alert("操作提示", "删除部门成功！", "info");
                            //根据所选节点的父部门id执行reload方法，刷新父部门位置的信息
                            $('#tt').tree('reload', $('#tt').tree('find',  $('#tt').tree('getSelected').attributes.parentId).target);

                        }else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: '删除部门失败'
                            });
                        }
                    },'json');
                }
            });
        }


    }

    //关闭添加子部门的window窗口
    function closeNewDepartmentForm(){

        $('#newDepartmentForm').form('clear');
        $('#newChildrenDepartment').window('close');
    }

    //关闭编辑部门的window窗口
    function closeEditDepartmentForm(){
        $('#editChildrenDepartment').window('close');
    }
</script>