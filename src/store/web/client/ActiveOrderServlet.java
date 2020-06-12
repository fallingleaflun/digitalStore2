package store.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.Order;
import store.service.OrderService;

/**
 * Servlet implementation class ActiveOrderServlet
 */
@WebServlet("/activeOrder")
public class ActiveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//根据传来的订单号去设置订单为已支付状态
		String order_id = request.getParameter("order_id");
		OrderService orderService = new OrderService();
		Order order= orderService.findOrderById(order_id);
		if(order == null) {
			response.getWriter().write("No such order");
			return;
		}
		orderService.updateState(order_id);
		response.getWriter().write("Order confirm!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
