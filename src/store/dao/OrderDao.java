package store.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import store.domain.Order;
import store.domain.User;
import store.utils.DataSourceUtils;
/**
 * 订单
 * @author admin
 *
 */
public class OrderDao {
	/**
	 *  生成订单
	 * @param order
	 * @throws SQLException
	 */
	public int addProduct(Order order) throws SQLException {
		// 1.生成Sql语句
		String sql = "insert into orders(user_id, money, buyerName, buyerTel, buyerAddress, purchased) values("
							+ order.getUser().getId() +"," + order.getMoney() +",'" + order.getBuyerName() + "','" + order.getBuyerTel() + "','"+ order.getBuyerAddress() +"',0)";
		/*
		// 2.生成执行sql语句的QueryRunner,不传递参数
		QueryRunner runner = new QueryRunner();
        // 3.执行update()方法插入数据
		runner.update(DataSourceUtils.getConnection(), sql,  order.getUser().getId(),	order.getMoney(), order.getBuyerName(), order.getBuyerTel(),order.getBuyerAddress());
		*/
		
		
		//获取
		Statement  stmt = DataSourceUtils.getConnection().createStatement();  
		stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);                      // 向驱动指明需要自动获取generatedKeys！  
	    int autoIncKeyFromApi = -1;
	    ResultSet  rs = stmt.getGeneratedKeys();                                  // 获取自增主键！  
	    if (rs.next()) {  
	        autoIncKeyFromApi = rs.getInt(1);  
	    }  else {  
	        System.out.println("返回自增主键失败");
	    }   
	    rs.close();  
	    rs = null;  
	    System.out.println("Key returned from getGeneratedKeys():"  
	        + autoIncKeyFromApi);
	    return autoIncKeyFromApi;
	}
	/**
	 * 查找用户所属订单
	 */
	public List<Order> findOrderByUser(final User user) throws SQLException {
		String sql = "select * from orders where user_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setMoney(rs.getDouble("money"));
					order.setOrdertime(rs.getDate("ordertime"));
					order.setPurchased(rs.getInt("purchased"));
					order.setBuyerAddress(rs.getString("buyerAddress"));
					order.setBuyerName(rs.getString("buyerName"));
					order.setBuyerTel(rs.getString("buyerTel"));
					order.setUser(user);
					orders.add(order);
				}
				return orders;
			}
		}, user.getId());
	}
	/**
	 * 根据id查找订单信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Order findOrderById(String id) throws SQLException {
		String sql = "select * from orders,user where orders.user_id=user.id and orders.id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<Order>() {
			public Order handle(ResultSet rs) throws SQLException {
				Order order = new Order();
				while (rs.next()) {
					order.setId(rs.getInt("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPurchased(rs.getInt("orders.purchased"));
					order.setBuyerAddress(rs.getString("orders.buyerAddress"));
					order.setBuyerName(rs.getString("orders.buyerName"));
					order.setBuyerTel(rs.getString("orders.buyerTel"));

					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setIntroduce(rs.getString("user.introduce"));
					user.setPassword(rs.getString("user.password"));
					user.setRegisterTime(rs.getDate("user.registertime"));
					user.setRole(rs.getShort("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setTel(rs.getString("user.tel"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
				}
				return order;
			}
		}, id);
	}
	/**
	 *  查找所有订单
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findAllOrder() throws SQLException {
		//1.创建sql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id order by orders.user_id";
		//2.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //3.返回QueryRunner对象query()方法的查询结果
		return runner.query(sql, new ResultSetHandler<List<Order>>() {			
			public List<Order> handle(ResultSet rs) throws SQLException {
				//创建订单集合
				List<Order> orders = new ArrayList<Order>();
                //循环遍历订单和用户信息
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPurchased(rs.getInt("orders.purchased"));
					order.setBuyerAddress(rs.getString("orders.buyerAddress"));
					order.setBuyerName(rs.getString("orders.buyerName"));
					order.setBuyerTel(rs.getString("orders.buyerTel"));
					orders.add(order);

					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setIntroduce(rs.getString("user.introduce"));
					user.setPassword(rs.getString("user.password"));
					user.setRegisterTime(rs.getDate("user.registertime"));
					user.setRole(rs.getShort("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setTel(rs.getString("user.tel"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
				}
				return orders;
			}
		});
	}
	/**
	 *  根据订单号修改订单状态
	 * @param id
	 * @throws SQLException
	 */
	public void updateOrderState(String id) throws SQLException {
		String sql = "update orders set purchased=1 where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
		System.out.println(runner.update(sql, id));
	}
	/**
	 *  多条件查询
	 * @param id
	 * @param buyerName
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findOrderByManyCondition(String id, String buyerName)
			throws SQLException {
		//1.创建集合对象
		List<Object> objs = new ArrayList<Object>();
		//2.定义查询sql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id ";
		//3.根据参数拼接sql语句
		if (id != null && id.trim().length() > 0) {
			sql += " and orders.id=?";
			objs.add(id);
		}
		if (buyerName != null && buyerName.trim().length() > 0) {
			sql += " and buyerName=?";
			objs.add(buyerName);
		}
		sql += " order by orders.user_id";
		//4.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//5.返回QueryRunner对象query方法的执行结果
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
               //循环遍历出订单和用户信息
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPurchased(rs.getInt("orders.purchased"));
					order.setBuyerAddress(rs
							.getString("orders.buyerAddress"));
					order.setBuyerName(rs.getString("orders.buyerName"));
					order.setBuyerTel(rs.getString("orders.buyerTel"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setIntroduce(rs.getString("user.introduce"));
					user.setPassword(rs.getString("user.password"));
					user.setRegisterTime(rs.getDate("user.registertime"));
					user.setRole(rs.getShort("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setTel(rs.getString("user.tel"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);

				}

				return orders;
			}
		}, objs.toArray());
	}
	/**
	 * 根据id删除订单
	 * @param id
	 * @throws SQLException
	 */
	public void delOrderById(String id) throws SQLException {
		String sql="delete from orders where id=?";		
		QueryRunner runner = new QueryRunner();		
		runner.update(DataSourceUtils.getConnection(),sql,id);		
	}
}
