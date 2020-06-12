package store.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.User;
import store.domain.UserPortrait;
import store.service.UserPortraitService;

/**
 * Servlet implementation class GetRecommandServlet
 */
@WebServlet("/GetRecommandServlet")
public class GetRecommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecommandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前用户id
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			String id = user.getId()+""; // 用户id
			// 2.创建UserPortraitService对象
			UserPortraitService  ups= new UserPortraitService();
			// 3.调用service层用于条件查询的方法
			UserPortrait up= ups.getUserPortraitService(id);
			// 4.将条件查询的结果放进request域中
			request.setAttribute("userPortrait", up);
			String category=up.getCategory();
			System.out.println("gt:"+category);
			if(!category.equals("")) {
				request.setAttribute("category", category);
				request.getRequestDispatcher("/showProductByPage").forward(
					request, response);
			}
			else
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/client/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
