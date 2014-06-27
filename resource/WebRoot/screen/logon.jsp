<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@include file="hs_common.jsp"%>
<!DOCTYPE html><html lang="en-US"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title></title><link rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/css/focusmin.css" />
<script type="text/javascript" src="<%=basepath %>/js/jquery/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basepath %>/js/login/common.js"></script>
</head>
<body class="login" style="background:url('<%=basepath %>/css/images/bg.jpg') center top no-repeat ;">
<div class="login-main cf">
<div class="login-form" id="login_content_box">
<div class="form-element">
<div class="login_error t-c" id="login_error">
<c:if test="${ not empty message}">
${message }
</c:if>
</div>
<form id="login_form" name="login_form" method="post" action="<%=basepath%>/userinfo/logon" onsubmit="return checkform();">
<ul class="prop-list vm-0">
<li><div class="prop-label">账号</div>
<div class="prop-value">
<input type="text" id="userName" name="userName" maxlength="20"/></div>
</li>
<li><div class="prop-label">密码</div><div class="prop-value">
<input class="password" type="password" id="password" name="password" maxlength="50"/>
</div></li>
<li><div class="prop-label">&nbsp;</div><div class="prop-value vm-1 login-submit">
<button type="submit" class="signin" id="loginBtn"></button></div></li></ul></form><div class="pwd cf">

<script type="text/javascript">
$(function(){

        $('.login-form input').focusin(function(){
            $(this).addClass('focus');
        });
        $('.login-form input').focusout(function(){
            $(this).removeClass('focus');
        });

        if ('' == '') {
            $('#username').focus();
        }else{

            var item = '#';
            $(item).focus();
        }

        $('#get_new_image').click(getNewVerifyImage);


    });
</script></div><div class="footer"><span>Copyright 2014</span><span class="hp-2">###</span></div></body></html>