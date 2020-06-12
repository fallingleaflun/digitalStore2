package store.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import store.domain.Tomaru;
import store.domain.UserPortrait;
import store.utils.DataSourceUtils;

public class UserPortraitDao {

	public UserPortrait getUserPortraitService(String id) throws SQLException {
		UserPortrait up=new UserPortrait();
		//调用存储过程
		//1.从池子里获取数据库连接
		Connection conn=DataSourceUtils.getConnection();
		//2.设置一个call语句
		String sql = "{call getUserPortrait(?,?,?,?,?)}";
		CallableStatement stmt = conn.prepareCall(sql);
		//填入输入项
		stmt.setObject(1, Integer.parseInt(id));//输入用户id
		//填入输出项
		stmt.registerOutParameter(2, Types.VARCHAR);//用户姓名
		stmt.registerOutParameter(3, Types.INTEGER);//看最多的商品id
		stmt.registerOutParameter(4, Types.VARCHAR);//看最多的类别
		stmt.registerOutParameter(5, Types.INTEGER);//时间段,1早2下午3晚上
		//3.执行
		stmt.execute();
			//获取输出
			String name = stmt.getString(2);
			int pid=stmt.getInt(3);
			String ptype = stmt.getString(4);
			int ptime=stmt.getInt(5);
			up.setId(Integer.parseInt(id));
			up.setUsername(name);
			up.setProduct_id(pid);
			up.setCategory(ptype);
			up.setFreq_login_time(ptime);
		return up;
	}
}
