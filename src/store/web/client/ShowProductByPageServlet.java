package store.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.domain.PageBean;
import store.service.ProductService;

//分页显示数据
@WebServlet("/showProductByPage")
public class ShowProductByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.定义当前页码，默认为1
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.定义每页显示条数,默认为4
		int currentCount = 4;
		String _currentCount = request.getParameter("currentCount");
		if (_currentCount != null) {
			currentCount = Integer.parseInt(_currentCount);
		}
		// 3.获取查找的分类
		String category = "全部商品";
		String _category = request.getParameter("category");
		System.out.println("ShowProductServlet:获得的category是:" + _category);
		if (_category != null) {
			category = _category;
		}
		if(_category == null) {
			_category=(String)request.getAttribute("category");
			if (_category != null) {
				category = _category;
			}
			else {
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				return;
			}
		}
		// 4.调用service，完成获取当前页分页Bean数据.
		ProductService service = new ProductService();
		PageBean bean = service.findProductByPage(currentPage, currentCount,
				category);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/client/product_list.jsp").forward(request, response);
		return;
	}
}
