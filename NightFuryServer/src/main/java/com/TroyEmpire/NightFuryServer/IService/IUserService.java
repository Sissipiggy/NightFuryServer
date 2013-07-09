package com.TroyEmpire.NightFuryServer.IService;

import com.TroyEmpire.NightFuryServer.Entity.User;



public interface IUserService {
	boolean checkUserIfExistByEmain(String email);
	User validateUser(String email, String password);
	void saveUser(User user);
}
