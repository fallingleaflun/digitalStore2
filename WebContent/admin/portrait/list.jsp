<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/admin/css/Style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/main2.css" />
    <script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
    <script>
    function CheckNull()
    {
        if(document.getElementById("Form1_userId").value == "")
        {
            window.alert("请输入用户id");
            document.getElementById(strElem).focus();
            return false;
        }
        
        return true;
    }
    </script>
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
            <form id="Form1" name="Form1"
                action="${pageContext.request.contextPath}/GetUserPortraitServlet"
                method="post">
                <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                    <TBODY>
                        <tr>
                            <td class="ta_01" align="center" bgColor="#afd1f3">
                                <strong>查 询 条 件</strong>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                    <tr>
                                        <td height="22" align="center" bgColor="#f5fafe" class="ta_01">用户id</td>
                                        <td class="ta_01" bgColor="#ffffff">
                                            <input type="text" name="id" size="15" value="" id="Form1_userId" class="bg" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="100" height="22" align="center" bgColor="#f5fafe" class="ta_01"></td>
                                        <td class="ta_01" bgColor="#ffffff">
                                            <font face="宋体" color="red"> &nbsp;</font>
                                        </td>
                                        <td align="right" bgColor="#ffffff" class="ta_01">
                                            <br /><br />
                                        </td>
                                        <td align="right" bgColor="#ffffff" class="ta_01">
                                            <button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">
                                                查询
                                            </button> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                            <input type="reset" name="reset" value="&#37325;&#32622;" class="button_view" />
                                        </td>
                                        <td align="right" bgColor="#ffffff" class="ta_01">
                                            <button><a href='${pageContext.request.contextPath}/admin/login/home.jsp'>
                                                退出</a>
                                            </button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td class="ta_01" align="center" bgColor="#afd1f3"><strong>用户列表</strong>
                            </TD>
                        </tr>
                        <tr>
                            <td class="ta_01" align="center" bgColor="#f5fafe">
                                <table cellspacing="0" cellpadding="1" rules="all"
                                    bordercolor="gray" border="1" id="DataGrid1"
                                    style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                                    <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                        <td align="center" width="10%">用户id</td>
                                        <td align="center" width="20%">姓名</td>
                                        <td align="center" width="10%">浏览最多的商品id</td>
                                        <td align="center" width="15%">浏览最多的商品类型</td>
                                        <td align="center" width="15%">登录最多时段</td>
                                    </tr>
                                    <!--  输出 -->
                                        <tr onmouseover="this.style.backgroundColor = 'white'"
                                            onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${userPortrait.id }</td>
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%">${userPortrait.username }</td>
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="10%">${userPortrait.product_id }</td>
                                            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">${userPortrait.category }</td>
                                            <c:if test="${userPortrait.freq_login_time==1 }"><td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">早上</td> </c:if>
                                            <c:if test="${userPortrait.freq_login_time==2 }"><td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">下午</td> </c:if>
                                            <c:if test="${userPortrait.freq_login_time==3 }"><td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">晚上</td> </c:if>
                                        </tr>
                                </table>
                            </td>
                        </tr>
                    </TBODY>
                </table>
            </form>
        </div>
    </div>
</body>
</HTML>