<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改销售员信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/form2.js"></script>
</head>
<body class="main">
	<div id="divpagecontent">
        <div id="divcontent">
            <form action="${pageContext.request.contextPath}/ModifySalesmanServlet" method="post" onsubmit="return checkForm();">
                <input style="visibility:hidden"   type="text" name="id" value="${user.id}" } >
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td width="25%">
                            <table width="100%" border="0" cellspacing="0"
                                style="margin-top:30px">
                                <tr>
                                    <td class="listtitle">销售员帐户修改</td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table cellspacing="0" class="infocontent">
                                <tr>
                                    <td>
                                        <table width="100%" border="0" cellspacing="2">
                                            <tr>
                                                <td style="text-align:right; width:20%">邮箱（不可更改）：</td>
                                                <td style="width:40%; padding-left:20px">${user.email }</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right">用户名：</td>
                                                <td style="padding-left:20px">${user.username }</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right">修改密码：</td>
                                                <td><input type="password" class="textinput"  id="password" name="password" onkeyup="checkPassword();"/></td>
                                                <td><span id="passwordMsg"></span><font color="#999999">密码请设置6-16位字符</font></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right">重复密码：</td>
                                                <td><input type="password" class="textinput"  id="repassword" name="repassword" onkeyup="checkConfirm();"/></td>
                                                <td><span id="confirmMsg"></span>&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right">手机号：</td>
                                                <td><input type="text" class="textinput"  id="tel" name="tel" onkeyup="checkTel();"/></td>
                                                <td><span id="telMsg"></span><font color="#999999">请输入有效的手机号</font></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right">个人介绍：</td>
                                                <td><textarea id="infotextarea" name="introduce" style="resize:none" onkeyup="checkIntroduce();"></textarea></td>
                                                <td><span id="introduceMsg"></span><font color="#999999">30字以内</font></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right">&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                        </table>
                                        <p style="text-align:center">
                                            <input type="image" src="${pageContext.request.contextPath }/client/images/submit.png" name="submit" border="0" width="40" height="40"/>
                                        </p>
                                        <p style="text-align:center">&nbsp;</p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
	</div>
</body>
</html>
