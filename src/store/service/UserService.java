package store.service;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.apache.commons.dbutils.QueryRunner;

import store.dao.IpRecordDao;
import store.dao.UserDao;
import store.domain.IpRecord;
import store.domain.Product;
import store.domain.SalesProduct;
import store.domain.User;
import store.exception.RegisterException;
import store.utils.DataSourceUtils;

public class UserService {
	private UserDao dao = new UserDao();
	// 注册操作
	public void register(User user) throws RegisterException {
		// 调用dao完成注册操作
		try {
			dao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("Register fail");
		}
	}
	// 登录操作
	public User login(String username, String password) throws LoginException {
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, password);
			//如果找到，还需要确定用户是否为激活用户
			if (user != null) {
				// 只有用户可用才能登录成功，否则提示“用户不可用”
				if (user.getState() == 1) {
					return user;
				}
				throw new LoginException("no such user");
			}
			throw new LoginException("username or password is incorrect");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("login fail");
		}
	}
	public void modifyUser(int user_id, String password, String tel, String introduce) {
		// TODO Auto-generated method stub
		try {
			dao.modifyUser(user_id, password, tel, introduce);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new RegisterException("modify fail");
			} catch (RegisterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//记录登录ip
	public void recordIp(IpRecord ipRecord) {
		// TODO Auto-generated method stub
				try {
					IpRecordDao dao=new IpRecordDao();
					//新建一个记录
					dao.insertIpRecord(ipRecord);
				} catch (Exception e) {
					e.printStackTrace();
					try {
						throw new RegisterException("recordip fail");
					} catch (RegisterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	}
	
	// 多条件查询
	public List<User> findSalesmanByManyCondition(String id) {
		List<User> ps = null;
		try {
			ps = dao.findSalesmanByManyCondition(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public User findUserById(String id) {
		User user = null;
		try {
			user = dao.findUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		try {
			dao.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
}
