package store.web.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.User;
import store.service.UserService;

/**
 * Servlet implementation class FindSalesmanByManyCondition
 */
@WebServlet("/FindSalesmanByManyCondition")
public class FindSalesmanByManyCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSalesmanByManyCondition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单数据
		String id = request.getParameter("id"); // 商品id
		// 2.创建UserService对象
		UserService service = new UserService();
		// 3.调用service层用于条件查询的方法
		List<User>  salesmanList= service.findSalesmanByManyCondition(id);
		// 4.将条件查询的结果放进request域中
		request.setAttribute("salesmanList", salesmanList);
		// 5.请求重定向到商品管理首页list.jsp页面
		request.getRequestDispatcher("/admin/sales_manage/list.jsp").forward(
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
