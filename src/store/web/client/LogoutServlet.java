package store.web.client;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.domain.IpRecord;
import store.domain.User;
import store.service.UserService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/client/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取session对象.
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		UserService service = new UserService();
		//记录登出ip
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
        ipRecord.setOpType((short)(1));//操作类型为登出
        service.recordIp(ipRecord);
		// 销毁session
		session.invalidate();
		// flag标识
		String flag = request.getParameter("flag");
		if (flag == null || flag.trim().isEmpty()) {
			// 重定向到首页
			response.sendRedirect(request.getContextPath() + "/client/index.jsp");
		}
	}
}
