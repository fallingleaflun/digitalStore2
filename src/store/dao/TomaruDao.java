package store.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import store.domain.Order;
import store.domain.OrderItem;
import store.domain.Product;
import store.domain.Tomaru;
import store.utils.DataSourceUtils;

public class TomaruDao {
	// 添加驻留时间
	public void addTomaru(Tomaru tomaru) throws SQLException {
		String sql = "insert into `tomaru` values(?,?,?,?);";
		QueryRunner runner = new QueryRunner();
		runner.update(DataSourceUtils.getConnection(), sql, tomaru.getUser_id(),
				tomaru.getProduct_id(), tomaru.getState_time(),tomaru.getState_jikai());
	}
	
	// 获取所有驻留时间
	public List<Tomaru> getAllTomaru() throws SQLException {
		String sql = "select * from `tomaru`;";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Tomaru>(Tomaru.class));
	}
	
	//增加某用户某商品的驻留时间，同时次数+1
	public void increaseTomaru(int user_id, int product_id, int increaseTime) throws SQLException {
		String sql = "UPDATE `tomaru` SET `state_time` = `state_time` + ?, `state_jikai` = `state_jikai` + 1  WHERE `user_id` = ? and `product_id` = ? ";
		QueryRunner runner = new QueryRunner();
		runner.update(DataSourceUtils.getConnection(), sql, increaseTime, user_id, product_id);
	}
	
	//查询某用户某商品的驻留时间，不存在就返回null
	public Tomaru getTomaruByTwoId(int user_id, int product_id) throws SQLException {
		String sql = "select  * from `tomaru`  WHERE `user_id` = ? and `product_id` = ? ";
		QueryRunner runner = new QueryRunner();
		return runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<Tomaru>(Tomaru.class),user_id, product_id);
	}
}
