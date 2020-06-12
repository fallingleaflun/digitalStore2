package store.web.client;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import store.utils.MailUtils;
import store.domain.Order;
import store.domain.OrderItem;
import store.domain.Product;
import store.domain.User;
import store.service.OrderService;

//生成订单
@WebServlet("/client/createOrder")
public class CreateOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		// 2.从购物车中获取商品信息
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
		if(cart == null) {
			response.getWriter().write("购物车无任何商品，无法结算");
			return;
		}
		// 3.将数据封装到订单对象中
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		order.setUser(user);// 封装用户信息到订单.
		for (Product p : cart.keySet()) {
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setBuynum(cart.get(p));
			item.setP(p);
			order.getOrderItems().add(item);
		}
		System.out.println(order);
		// 4.调用service中添加订单操作.
		OrderService service = new OrderService();
		int order_id = service.addOrder(order);
		// 5.发送确认订单邮件，这里申请服务器之后要填服务器的地址
					String emailMsg = "感谢你在数码商城购物，点击"
							+ "<a href='http://101.200.206.46:8080/mystore/activeOrder?order_id="
							+ order_id + "'>&nbsp;确认订单</a>";
					try {
						MailUtils.sendMail(user.getEmail(), emailMsg);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						System.out.print("订单确定邮件发送出错");
						e.printStackTrace();
					}
		response.sendRedirect(request.getContextPath() + "/client/createOrderSuccess.jsp");
	}

}
