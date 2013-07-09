package com.TroyEmpire.NightFuryServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.NightFuryServer.DAO.IUserDAO;
import com.TroyEmpire.NightFuryServer.Entity.User;
import com.TroyEmpire.NightFuryServer.IService.IUserService;
import com.TroyEmpire.NightFuryServer.Util.MathUtil;


@Component
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public boolean checkUserIfExistByEmain(String email) {
		return userDao.getUserByEmail(email) == null ? false : true;
	}

	public User validateUser(String email, String password) {
		User user = userDao.getUserByEmail(email);
		try {
			if (user == null)
				return null;
			else if (user.getPassward() != null
					&& MathUtil.Md5(password).equals(user.getPassward()))
				return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
