<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="store.domain.User"%>
<script type="text/javascript">
//退出确认框
function confirm_logout() {   
    var msg = "您确定要退出登录吗？";   
    if (confirm(msg)==true){   
    return true;   
    }else{   
    return false;   
    }   
} 
</script>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath }/client/index.jsp">
					<img src="${pageContext.request.contextPath}/client/images/logo.png" width="200" height="60" border="0" /> 
				</a>
			</td>
			<td style="text-align:right">
				  <a href="${pageContext.request.contextPath}/client/cart.jsp"><img src="${pageContext.request.contextPath}/client/images/cart.png" width="50" height="40" style="margin-top:6px"/></a> 
				&nbsp; 
                <img src="${pageContext.request.contextPath}/client/images/myAcount.png" width="20" height="20" style="margin-top:6px"/>
                <a href="${pageContext.request.contextPath}/client/myAccount.jsp" >我的账户</a>
				<% 
				User user = (User) request.getSession().getAttribute("user");
				if(null == user){
				%>
				| <a href="${pageContext.request.contextPath}/client/register.jsp">新用户注册</a>							
				<% 	
				}else{
				%>
				| <a href="${pageContext.request.contextPath}/client/logout" onclick="javascript:return confirm_logout()">用户退出</a> | 欢迎您： ${user.username}
				<% 	
				}
				%>			
			</td>		
		</tr>
	</table>
</div>