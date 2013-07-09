package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.Restaurant;
import com.TroyEmpire.NightFuryServer.IDAO.IRestaurantDAO;

@Component
public class RestaurantDAO extends DAO<Restaurant, Integer> implements
		IRestaurantDAO {

	@Override
	public Restaurant findByName(String name) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		Restaurant res = null;
		String sql = "SELECT r FROM Restaurant r WHERE r.name = :name";
		TypedQuery<Restaurant> query = em.createQuery(sql, Restaurant.class)
				.setParameter("name", name);
		res = query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return res;
	}

	@Override
	public List<Restaurant> findRestsaurantByCampusId(int campusId) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		String sql = "SELECT r FROM Restaurant r WHERE r.campusId = :campusId";
		TypedQuery<Restaurant> query = em.createQuery(sql, Restaurant.class)
				.setParameter("campusId", campusId);
		List<Restaurant> res = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return res;
	}
}
