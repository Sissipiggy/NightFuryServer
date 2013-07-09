package com.TroyEmpire.NightFuryServer.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.Building;
import com.TroyEmpire.NightFuryServer.IDAO.IBuildingDAO;


@Component
public class BuildingDAO extends DAO<Building, Integer> implements IBuildingDAO {

	@Override
	public Building getBuildingByname(String name) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		Building buil = null;
		String sql = "SELECT b FROM Building b WHERE b.name = :name";
		TypedQuery<Building> query = em.createQuery(sql, Building.class)
				.setParameter("name", name);
		buil = query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return buil;
	}

	@Override
	public Building getBuildingByCellName(String name) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		Building buil = null;
		String sql = "SELECT b FROM Cell c, Building b WHERE c.name = :name and c.buildingId = b.id";
		TypedQuery<Building> query = em.createQuery(sql, Building.class)
				.setParameter("name", name);
		buil = query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return buil;
	}

}
