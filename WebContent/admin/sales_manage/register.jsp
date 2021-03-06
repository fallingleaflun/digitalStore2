<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>销售人员注册页面</title>
<%--导入css和js --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/form.js"></script>
</head>

<body class="main">
<!-- 销售注册  start -->
	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/SalesmanRegisterServlet" method="post" onsubmit="return checkForm();">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding: 30px"><h1>销售人员注册</h1>
						<table width="90%" border="0" cellspacing="2">
							<tr>
								<td style="text-align: right">用户名：</td>
								<td><input type="text" class="textinput"  id="username" name="username" onkeyup="checkUsername();"/></td>
								<td colspan="2"><span id="usernameMsg"></span><font color="#999999">字母数字下划线1到10位, 不能是数字开头</font></td>
							</tr>
							<tr>
								<td style="text-align: right">密码：</td>
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
								<td style="text-align: right; width: 20%">邮箱：</td>
								<td style="width: 40%"><input type="text" class="textinput"  id="email" name="email" onkeyup="checkEmail();"/></td>
								<td><span id="emailMsg"></span><font color="#999999">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align: right">个人介绍：</td>
								<td><textarea class="textarea" name="introduce" id="introduce" style="resize:none" onkeyup="checkIntroduce();"></textarea></td>
                                <td><span id="introduceMsg"></span><font color="#999999">30字以内</font></td>
							</tr>
							<tr>
                                <td style="text-align: right">负责商品类别：</td>
                                <td><select name="category" id="category">
                                                <option value="" selected="selected">--选择负责商品类别--</option>
                                                <option value="手机">手机</option>
                                                <option value="笔记本">笔记本</option>
                                                <option value="相机">相机</option>
                                                <option value="影音娱乐">影音娱乐</option>
                                                <option value="数码配件">数码配件</option>
                                            </select>
                               </td>
                            </tr>
						</table>
                        <hr style="height:2px;border:none;border-top:2px groove skyblue;" />
                        <div align="center">
                            <input type="image" src="${pageContext.request.contextPath}/client/images/submit.png" name="submit" border="0" width="40" height="40"/>
                        </div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
 <!-- 销售注册  end -->
</body>
</html>
