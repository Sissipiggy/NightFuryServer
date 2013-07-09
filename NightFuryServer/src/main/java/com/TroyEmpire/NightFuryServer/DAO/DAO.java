package com.TroyEmpire.NightFuryServer.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.TroyEmpire.NightFuryServer.IDAO.IDAO;
import com.TroyEmpire.NightFuryServer.Util.HibernateUtil;

public abstract class DAO<T, ID extends Serializable> implements IDAO<T, ID> {

	protected EntityManager getEntityManager() {
		return HibernateUtil.getEntityManager();
	}

	public void save(T entity) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void update(T entity) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(T entity) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}

	public T findByID(Class<T> clazz, Long id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		T t = null;
		t = (T) em.find(clazz, id);
		em.getTransaction().commit();
		em.close();
		return t;
	}

	public List<T> findAll(Class<T> clazz) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<T> query = em.createQuery(
				"SELECT e FROM " + clazz.getSimpleName() + " e ", clazz);
		List<T> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}

	public void saveAll(List<T> entities) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		for (T entity : entities) {
			em.merge(entity);
		}
		em.getTransaction().commit();
		em.close();
	}

}
