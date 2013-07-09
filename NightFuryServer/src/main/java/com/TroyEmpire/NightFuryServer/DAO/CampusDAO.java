package com.TroyEmpire.NightFuryServer.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.Campus;
import com.TroyEmpire.NightFuryServer.IDAO.ICampusDAO;

@Component
public class CampusDAO extends DAO<Campus, Integer> implements ICampusDAO {

	@Override
	public Campus getCampusByName(String campusName) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		Campus cam = null;
		String sql = "SELECT c FROM Campus c WHERE c.name = :name";
		TypedQuery<Campus> query = em.createQuery(sql, Campus.class)
				.setParameter("name", campusName);
		try {
			cam = query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return cam;
		} catch (NoResultException nre) {
			em.getTransaction().commit();
			em.close();
			return null;
		} 
	}

}
