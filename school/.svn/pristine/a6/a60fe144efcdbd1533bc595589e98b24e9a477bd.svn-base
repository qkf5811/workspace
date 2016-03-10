<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>江门幼师管理系统</title>

<style type="text/css">
#rl {
	margin: 0 auto;
	border: 0px solid #000;
	width: 400px;
	padding: 30px 70px 20px 70px;
}
</style>
</head>
<body>
	
	
</body>
<script type="text/javascript">
	
	window.alert = function(str)
	{
	var shield = document.createElement("DIV");
	shield.id = "shield";
	shield.style.position = "absolute";
	shield.style.left = "0px";
	shield.style.top = "0px";
	shield.style.width = "100%";
	shield.style.height = document.body.scrollHeight+"px";
	//弹出对话框时的背景颜色
	shield.style.background = "#fff";
	shield.style.textAlign = "center";
	shield.style.zIndex = "25";
	
	shield.style.opacity=0.5;//设置透明度 0-1
	
	//背景透明 IE有效
	//shield.style.filter = "alpha(opacity=0)";
	var alertFram = document.createElement("DIV");
	alertFram.id="alertFram";
	alertFram.style.position = "absolute";
	alertFram.style.left = "50%";
	alertFram.style.top = "50%";
	alertFram.style.marginLeft = "-175px";
	alertFram.style.marginTop = "-175px";
	alertFram.style.width = "350px";
	alertFram.style.height = "100px";
	alertFram.style.background = "#eaf2ff";
	alertFram.style.textAlign = "center";
	alertFram.style.lineHeight = "150px";
	alertFram.style.zIndex = "300";
	strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
	strHtml += " <li style=\"background:#eaf2ff;text-align:left;padding-left:20px;font-size:14px;font-weight:bold;height:25px;line-height:25px;border:1px solid #95B8E7;\">请注意！</li>\n";
	strHtml += " <li style=\"background:#fff;text-align:center;font-size:15px;height:120px;line-height:120px;border-left:1px solid #95B8E7;border-right:1px solid #95B8E7;\">"+str+"</li>\n";
	strHtml += " <li style=\"background:#eaf2ff;text-align:center;font-weight:bold;height:25px;line-height:25px; border:1px solid #95B8E7;\"><input type=\"button\" value=\"确 定\" onclick=\"doOk()\" /></li>\n";
	strHtml += "</ul>\n";
	alertFram.innerHTML = strHtml;
	document.body.appendChild(alertFram);
	document.body.appendChild(shield);
	/* var ad = setInterval("doAlpha()",5); */
	this.doOk = function(){
		
		var curWwwPath = window.document.location.href;
	     //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
	     var pathName = window.document.location.pathname;
	     var pos = curWwwPath.indexOf(pathName);
	     //获取主机地址，如： http://localhost:8080
	     var localhostPath = curWwwPath.substring(0, pos);
	     //获取带"/"的项目名，如：/ems
	     var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	     location.href=(localhostPath + projectName)+"/logout.do";	
	
	/* alertFram.style.display = "none";
	shield.style.display = "none"; */
     
	}
	alertFram.focus();
	document.body.onselectstart = function(){return false;};
	}
	function loginTimeOutOrReLogin(){
	alert("您的帐号已被冻结，如需登录请与管理员取得联系!");
	
	}
	window.onload=loginTimeOutOrReLogin();
</script>
