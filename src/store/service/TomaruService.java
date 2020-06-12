package store.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import store.dao.TomaruDao;
import store.domain.Product;
import store.domain.Tomaru;
import store.exception.AddProductException;
import store.utils.DataSourceUtils;

public class TomaruService {
	TomaruDao dao = new TomaruDao();
	// 添加商品
	public void addTomaru(Tomaru tomaru){
		try {
			dao.addTomaru(tomaru);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 获取所有驻留时间
	public List<Tomaru> getAllTomaru() {
		try {
			return dao.getAllTomaru();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//增加某用户某商品的驻留时间，同时次数+1
	public void increaseTomaru(int user_id, int product_id, int increaseTime) throws SQLException {
		try {
			dao.increaseTomaru(user_id, product_id, increaseTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询某用户某商品的驻留时间，不存在就返回null
	public Tomaru getTomaruByTwoId(int user_id, int product_id) throws SQLException {
		try {
			return dao.getTomaruByTwoId(user_id, product_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
