<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数码商城</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main2.css" />
</head>

<body class="linear1">
    <div id="header"><img class="img_logo" src="${pageContext.request.contextPath}/admin/images/top_11.png" style="	min-width:100%;
	max-width:100%;
	height:60px;"></div>
    <div id="section">
        <div id="nav">
            <ul>
                <li>功能</li>
                <li><a href="${pageContext.request.contextPath}/admin/sales_manage/list.jsp">修改销售人员信息</a></li>
                <li><a href="${pageContext.request.contextPath}/statistic">销售统计</a></li>
                <li><a href="${pageContext.request.contextPath}/getAllTomaru">停留时间统计</a></li>
                <li><a href="${pageContext.request.contextPath}/GetIpRecordServlet">所有人员操作统计</a></li>
                                 <li><a href="${pageContext.request.contextPath}/admin/portrait/list.jsp">用户画像</a></li>
                <li><a href="${pageContext.request.contextPath}/client/logout">退出登录</a></li>
            </ul>
        </div>
        <div id="article">  
        </div>
    </div>
</body>
</html>