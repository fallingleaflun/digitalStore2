package store.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.IpRecordDao;
import store.domain.IpRecord;
import store.domain.Order;
import store.service.ProductService;

/**
 * Servlet implementation class StatisticServlet
 */
@WebServlet("/statistic")
public class StatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService productService = new ProductService();
		//获取一个HashMap<String,Integer>（类别，销售量）
		HashMap<String, Double> cateList = productService.getCateStatistic();
		HashMap<String, Double> dayList = productService.getDayStatistic();
		//将查询到的信息添加到request作用域
		request.setAttribute("cateList", cateList);
		request.setAttribute("dayList", dayList);
		
		// 将请求转发到list.jsp页面
		request.getRequestDispatcher("/admin/statistic/list.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
