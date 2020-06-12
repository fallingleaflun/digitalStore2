package store.web.client;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.IpRecord;
import store.domain.User;
import store.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/client/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取登录页面输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.调用service完成登录操作。
		UserService service = new UserService();
		try {
			User user = service.login(username, password);
			
			// 3.登录成功，将用户存储到session中.
			request.getSession().setAttribute("user", user);
			//4.记录登录ip
			String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        if ("0:0:0:0:0:0:0:1".equals(ip)) {
	            ip = "127.0.0.1";
	        }
	        if (ip.split(",").length > 1) {
	            ip = ip.split(",")[0];
	        }
	        IpRecord ipRecord=new IpRecord();
	        ipRecord.setUser_id(user.getId());
	        ipRecord.setRole(user.getRole());
	        ipRecord.setIp(ip);
	        ipRecord.setOpType((short)(0));//操作类型为登陆
	        service.recordIp(ipRecord);
			// 获取用户的角色，其中用户的角色分普通用户和管理员两种
			int role = user.getRole();
			// 如果是管理员，就进入到网上书城的后台管理系统；否则进入我的账户页面
			if (role == 1) {
				response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
				return;
			} else if(role==2) {
				response.sendRedirect(request.getContextPath() + "/salesman/login/home.jsp");
				return;
			}else {
				response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
			}
		} catch (LoginException e) {
			// 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
	}
}
