package com.TroyEmpire.NightFuryServer.DAO;

import com.TroyEmpire.NightFuryServer.Entity.User;
import com.TroyEmpire.NightFuryServer.IDAO.IDAO;



public interface IUserDAO extends IDAO<User, Long> {

	User getUserByEmail(String email);
}
