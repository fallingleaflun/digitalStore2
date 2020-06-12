<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>数码商城</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/client/js/my.js"></script>
</head>
<body class="main">
	<div id="divcontent">
	   <font style="font-weight:bold; color:#ff0000">权限不足,请登录后操作</font><br />
		<br /> 
		<a href="${pageContext.request.contextPath }/client/index.jsp">
			<span id="second">5</span>秒后自动为您转跳回首页
		</a>
							
	</div>
</body>
</html>
