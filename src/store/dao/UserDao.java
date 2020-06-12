package store.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import store.domain.Product;
import store.domain.User;
import store.utils.DataSourceUtils;

public class UserDao {
	// 添加用户
	public void addUser(User user) throws SQLException {
		String sql ="insert  into `user`(`username`,`password`,`tel`,`email`,`introduce`) values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, user.getUsername(), user.getPassword(),user.getTel(),user.getEmail(), 
				user.getIntroduce());
		if (row == 0) {
			throw new RuntimeException();
		}
	}

	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

	}

	// 激活用戶
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, 1, activeCode);
	}
	
	//根据用户名与密码查找用户
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}

	public void modifyUser(int user_id, String password, String tel, String introduce) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="update  `user` set `password` = ?, `tel` = ?, `introduce` = ? where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, password, tel, introduce, user_id);
	}

	// 多条件查询
		public List<User> findSalesmanByManyCondition(String id)
				throws SQLException {
			List<Object> list = new ArrayList<Object>();
			String sql = "select * from user where 1=1 and user.role=2";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

			if (id != null && id.trim().length() > 0) {
				sql += " and id=?";
				list.add(id);
			}

			Object[] params = list.toArray();

			return runner.query(sql, new BeanListHandler<User>(User.class),
					params);
		}

		public User findUserById(String id) throws SQLException {
			String sql = "select * from user where user.id=?";
			QueryRunner runner = new QueryRunner();
			return runner.query(sql, new BeanHandler<User>(User.class), id);
		}

		public void deleteUser(String id) throws SQLException {
			String sql = "delete from user where user.id=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			runner.update(sql, id);
		}
}
