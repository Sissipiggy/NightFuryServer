package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Constant.Constant;
import com.TroyEmpire.NightFuryServer.Constant.NewsType;
import com.TroyEmpire.NightFuryServer.Entity.News;
import com.TroyEmpire.NightFuryServer.IDAO.INewsDAO;

@Component
public class NewsDAO extends DAO<News, Integer> implements INewsDAO {

	@Override
	public News findLatestNews(NewsType type) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();

		String sql = "select n from News n where n.newsType = :type order by n.id DESC";
		TypedQuery<News> query = em.createQuery(sql, News.class).setParameter(
				"type", type);
		query.setMaxResults(1);
		try {
			News news = query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return news;
		} catch (NoResultException nre) {
			em.getTransaction().commit();
			em.close();
			return null;
		} catch (Exception ex) {
			em.getTransaction().commit();
			em.close();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<News> findNewsAboveAnId(NewsType type, int id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		String sql = "select n from News n where n.newsType = :type and id > :id "
				+ "order by n.id DESC";
		TypedQuery<News> query = em.createQuery(sql, News.class)
				.setParameter("type", type).setParameter("id", id);
		query.setMaxResults(Constant.NUMBER_UPDATE_NEWS_TO_CLIENT);
		List<News> newsList = query.getResultList();

		em.getTransaction().commit();
		em.close();
		return newsList;
	}

	@Override
	public List<News> findNewsAboveAnId(int id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		String sql = "select n from News n where id > :id "
				+ "order by n.id DESC";
		TypedQuery<News> query = em.createQuery(sql, News.class).setParameter(
				"id", id);
		query.setMaxResults(Constant.NUMBER_UPDATE_NEWS_TO_CLIENT);
		List<News> newsList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return newsList;
	}

}
