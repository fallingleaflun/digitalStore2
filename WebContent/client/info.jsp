<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>数码商城</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
	<!-- 统计停留时间 -->
	<script src="${pageContext.request.contextPath }/client/js/jquery-3.4.1.min.js" type="text/javascript"></script>
</head>

 <script language="javascript" type="text/javascript">
    var a='<%=session.getAttribute("user")%>';
    if(a=="null"||a=="")
    {
        //没有登录不用统计停留时间
    }
    else
    {
        var start;
        var end;
        var state;
        start = new Date();//start是用户进入页面时间
        $(document).ready(function() {//用户页面加载完毕，这个是jquery初始化的语句（不知道初始化这个词用的是否正确）
        	window.onbeforeunload = function() {//页面卸载，就是用户关闭页面、点击链接跳转到其他页面或者刷新页面都会执行
                end = new Date();//用户退出时间
                state = end.getTime() - start.getTime();//停留时间=退出时间-开始时间（得到的是一个整数，应该是毫秒为单位，1秒=1000）
                //$.post("action_to_sql.jsp", { state_time: state, state_url: window.location.pathname ,state_title: $("title").html() });//把值传到action_to_sql.jsp页面写入数据库（一开始我不想这样做，希望在本页面直接处理写入数据库，后来发现我的是生成静态页面的，无法在原来页面完成数据处理，所以学习jquery，并采用这种方法解决，才发现jquery真的是个好东西。）
                location.href = "${pageContext.request.contextPath}/saveTime?state_time="
                    + state + "&product_id=" + ${p.id};//这里会通过url传参，跳转到ChangeCartServlet来实现对购物车商品的修改
                
            };
        });
    }
</script>

<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
        <div id="divcontent">
            <table width="100%%" border="0" cellspacing="0">
                <tr>
                    <td width="30%">
                        <div class="divbookcover">
                            <p>
                                <img src="${pageContext.request.contextPath}${p.imgurl}" width="213" height="269" border="0" />
                            </p>
                        </div>
                    </td>
                    <td style="padding:20px 5px 5px 5px">
                        <img src="${pageContext.request.contextPath }/client/images/miniicon3.gif" width="16" height="16" />
                        <font class="bookname">&nbsp;${p.name}</font>
                        <hr />售价：<font color="#FF0000">￥${p.price}</font>
                        <hr /> 类别：${p.category }
                        <hr />
                        <p>
                            <b>内容简介：</b>
                        </p> ${p.description}
                        <hr />
                        <br /> 已售：${p.sold}件 <br /> 库存：${p.remain}件
                        <hr />
                        <div style="text-align:center; margin-top:10px">
                            <a href="${pageContext.request.contextPath}/addCart?id=${p.id}">
                                <img src="${pageContext.request.contextPath }/client/images/addToCart.png" border="0" width="200" height="50" /> 
                            </a>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
