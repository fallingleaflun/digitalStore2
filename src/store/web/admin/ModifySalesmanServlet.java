package store.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.User;
import store.service.UserService;

/**
 * Servlet implementation class ModifySalesmanServlet
 */
@WebServlet("/ModifySalesmanServlet")
public class ModifySalesmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifySalesmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
        int user_id = Integer.parseInt(request.getParameter("id"));
		String tel = request.getParameter("tel");
		String introduce = request.getParameter("introduce");
        HttpServletRequest req = (HttpServletRequest) request;
		UserService userService = new UserService();
		userService.modifyUser(user_id,password, tel, introduce);
		response.sendRedirect(request.getContextPath() + "/admin/sales_manage/list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
