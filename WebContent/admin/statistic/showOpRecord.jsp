<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/admin/css/Style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main2.css" />
</HEAD>

<body class="linear1">
    <div id="header"><img class="img_logo" src="${pageContext.request.contextPath}/admin/images/top_11.png" style=" min-width:100%;
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
            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <TBODY>
                    <tr>
                        <td class="ta_01" align="center" bgColor="#afd1f3">
                            <strong>操 作 统 计</strong>
                        </td>
                    </tr>
                    <tr>
                        <td class="ta_01" align="right"></td>
                    </tr>
                    <tr>
                        <td class="ta_01" align="center" bgColor="#f5fafe">
                            <table cellspacing="0" cellpadding="1" rules="all"
                                bordercolor="gray" border="1" id="DataGrid1"
                                style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                                <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                    <td align="center" width="20%">用户id</td>
                                    <td align="center" width="20%">用户身份</td>
                                    <td align="center" width="20%">ip</td>
                                    <td align="center" width="20%">时间</td>
                                    <td align="center" width="20%">操作</td>
                                </tr>
                                <c:forEach items="${iprecordList}" var="iprecord">
                                    <tr onmouseover="this.style.backgroundColor = 'white'"
                                        onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">${iprecord.user_id}</td>
                                        <c:if test="${iprecord.role==0 }">
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">普通用户</td>
                                        </c:if> 
                                        <c:if test="${iprecord.role==1 }">
                                                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">管理员</td>
                                        </c:if>
                                       <c:if test="${iprecord.role==2 }">
                                                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">销售员</td>
                                        </c:if>
                                        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${iprecord.ip }</td>
                                        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${iprecord.opTime }</td>
                                        <c:if test="${iprecord.opType==0 }">
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">登录</td>
                                        </c:if> 
                                        <c:if test="${iprecord.opType==1 }">
                                                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">登出</td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </TBODY>
            </table>
        </div>
    </div>
</body>
</HTML>