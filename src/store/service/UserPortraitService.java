package store.service;

import java.sql.SQLException;
import java.util.List;

import store.dao.UserPortraitDao;
import store.domain.UserPortrait;

public class UserPortraitService {
	UserPortraitDao dao=new UserPortraitDao();

	public UserPortrait getUserPortraitService(String id) {
		// TODO Auto-generated method stub
		UserPortrait up = null;
		try {
			up = dao.getUserPortraitService(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return up;
	}

}
