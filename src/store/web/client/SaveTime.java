package store.web.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.domain.Tomaru;
import store.domain.User;
import store.service.TomaruService;

/**
 * Servlet implementation class SaveTime
 */
@WebServlet("/saveTime")
public class SaveTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取时间和商品id
        String s_time = request.getParameter("state_time");
        String p_id = request.getParameter("product_id");
        int state_time = Integer.parseInt(s_time) / 1000;//以整数秒为单位
        int product_id = Integer.parseInt(p_id);
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();
        //2.查询是否已经存在记录
        TomaruService tomaruService = new TomaruService();
        Tomaru tomaru = null;
        try {
			tomaru = tomaruService.getTomaruByTwoId(user_id, product_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(tomaru == null) {//不存在记录
        	tomaru = new Tomaru();
        	tomaru.setUser_id(user_id);
        	tomaru.setProduct_id(product_id);
        	tomaru.setState_time(state_time);
        	tomaru.setState_jikai(1);
        	tomaruService.addTomaru(tomaru);
        	return;
        }
        //存在记录
        try {
			tomaruService.increaseTomaru(user_id, product_id, state_time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
