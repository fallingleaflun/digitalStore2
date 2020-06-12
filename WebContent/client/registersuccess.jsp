<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>数码商城</title>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<script type="text/javascript" src="js/my.js"></script>
</head>

<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divcontent">
        <div align="center" style="border-radius:5px">
            <img src="${pageContext.request.contextPath}/client/images/successIcon.png" width="128" height="128" />
            <br />
            <font style="font-weight:bold; color:#FF0000">注册成功！</font><br />
            <br /> 
            <a href="${pageContext.request.contextPath }/client/index.jsp">
                <span id="second">3</span>秒后自动为您转跳回首页
            </a>
            <br />
        </div>
	</div>
    <div>
        <br />
    </div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
