package store.web.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.User;
import store.domain.UserPortrait;
import store.service.UserPortraitService;
import store.service.UserService;

/**
 * Servlet implementation class GetUserPortraitServlet
 */
@WebServlet("/GetUserPortraitServlet")
public class GetUserPortraitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserPortraitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单数据
		String id = request.getParameter("id"); // 用户id
		// 2.创建UserPortraitService对象
		UserPortraitService  ups= new UserPortraitService();
		// 3.调用service层用于条件查询的方法
		UserPortrait up= ups.getUserPortraitService(id);
		// 4.将条件查询的结果放进request域中
		request.setAttribute("userPortrait", up);
		// 5.请求重定向到商品管理首页list.jsp页面
		request.getRequestDispatcher("/admin/portrait/list.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
