<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@include file="hs_common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆界面</title>

<link rel="stylesheet" type="text/css" href="<%=basepath%>/css/logon.css" />
<script type="text/javascript" src="<%=basepath %>/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
<div class="codrops-demos">
</div>
<div id="wrapper">
		<div id="login" class="animate form">
<form action="<%=basepath%>/userinfo/logon" method="POST">
	<h1>计算机实验室管理系统</h1> 
				<p> 
					<label for="userPassword" class="uname" data-icon="u" >您的工号</label>
					<input id="userNo" name="userNo" required="required" type="text" placeholder="请填写工号"/>
				</p>
				<p> 
					<label for="password" class="youpasswd" data-icon="p">您的密码</label>
					<input id="password" name="password" required="required" type="password" placeholder="请填写密码" /> 
				</p>

				<p> 
					<font color="red">${message }</font>
				</p>
				<p class="login button"> 
					<input type="submit" value="登录"/>
				</p>
</form>
</div>
</div>
</body>
</html>
