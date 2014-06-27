
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

<c:set var="ctx" value="<%= basepath%>"/>
    <link href="<%=basepath %>/css/default.css" rel="stylesheet" type="text/css" />
    
       <link href="<%=basepath %>/themes/default/icon.css" rel="stylesheet" type="text/css" />
         <link href="<%=basepath %>/css/validator.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="<%=basepath %>/js/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=basepath %>/js/jquery/jquery-ui.js"></script>
  	    <script type="text/javascript" src="<%=basepath %>/js/jquery/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/locale/easyui-lang-zh_CN.js"></script>
	<script  type="text/javascript" src="<%=basepath %>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basepath %>/js/jquery/validform.js"></script>
		<script type="text/javascript" src="<%=basepath %>/js/sys_js/myLoad.js"></script>
	
	<script>
	
	var skin = getCookie("hsSkin");
	if (skin) {
	    document.write('<link href="'+'../themes/' + skin + '/easyui.css" rel="stylesheet" type="text/css" />');
	}
 

	////////////////////////////////////////////////////////////////////////////////////////
	function getCookie(sName) {
	    var aCookie = document.cookie.split("; ");
	    var lastMatch = null;
	    for (var i = 0; i < aCookie.length; i++) {
	        var aCrumb = aCookie[i].split("=");
	        if (sName == aCrumb[0]) {
	            lastMatch = aCrumb;
	        }
	    }
	    if (lastMatch) {
	        var v = lastMatch[1];
	        if (v === undefined) return v;
	        return unescape(v);
	    }
	    return null;
	}
	
	</script>
	