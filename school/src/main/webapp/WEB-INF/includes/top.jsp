<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header" style="background: #3366CC; color: #fff">
	<div id="header-inner">
		<table cellpadding="0" cellspacing="0" style="width: 100%;">
			<tr>
				<td rowspan="2" style="width: 20px;"></td>
				<td style="height: 52px;">
					<div style="color: #fff; font-size: 22px; font-weight: bold;">
						<a
							style="color: #fff; font-size: 22px; font-weight: bold; text-decoration: none">${sessionScope.schoolName}学校综合管理平台</a>
					</div>
					<div style="color: #fff">
						<a style="color: #fff; text-decoration: none"></a>
					</div>
				</td>
				<td
					style="padding-right: 5px; padding-bottom: 5px; text-align: right; vertical-align: bottom;">
					<div id="topmenu">
						<label style="font-size: 14px;">${sessionScope.user.name}，欢迎您！</label> 
						<a onclick="openTab('user/changePasswordView.do','修改密码')" class="easyui-linkbutton" iconCls="icon-edit">修改密码</a>
						<a onclick="logout()" class="easyui-linkbutton" iconCls="icon-no">退出</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
function logout(){
    $.messager.confirm('请确认...','您确定安全退出系统吗?',function(r){
        if (r){
        	window.location.href="logout.do";
        }
    });
} 
</script>
