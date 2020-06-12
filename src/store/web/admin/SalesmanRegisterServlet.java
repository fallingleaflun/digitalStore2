package store.web.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import store.domain.User;
import store.exception.RegisterException;
import store.service.UserService;

/**
 * Servlet implementation class SalesmanRegisterServlet
 */
@WebServlet("/SalesmanRegisterServlet")
public class SalesmanRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesmanRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将表单提交的数据封装到javaBean
			User user = new User();
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			user.setRole((short)(2));//用户设置为销售类型
			
			// 调用service完成注册操作。
			UserService service = new UserService();
			try {
				service.register(user);
			} catch (RegisterException e) {
				e.printStackTrace();
				response.getWriter().write(e.getMessage());
				return;
			}
			// 注册成功，跳转到registersuccess.jsp
			response.sendRedirect(request.getContextPath() + "/admin/sales_manage/registersuccess.jsp");
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
