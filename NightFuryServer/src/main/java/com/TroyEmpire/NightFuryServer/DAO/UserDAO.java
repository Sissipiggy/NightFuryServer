package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.User;



@Component
public class UserDAO extends DAO<User, Long> implements IUserDAO {

	public User getUserByEmail(String email) {
		User user = null;
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.email=:email", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (null != users && users.size() == 1) {
			user = users.get(0);
		}
		em.getTransaction().commit();
		em.close();
		return user;
	}

}
