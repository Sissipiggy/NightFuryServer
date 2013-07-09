package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.PublicIdeaReply;
import com.TroyEmpire.NightFuryServer.IDAO.IPublicIdeaRelyDAO;

@Component
public class PublicIdeaReplyDAO extends DAO<PublicIdeaReply, Integer>
		implements IPublicIdeaRelyDAO {

	@Override
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		List<PublicIdeaReply> publicIdeaReplyList = null;
		String sql = "select pir from PublicIdeaReply pir where pir.publicIdeaId = :publicIdeaId";
		TypedQuery<PublicIdeaReply> query = em.createQuery(sql,PublicIdeaReply.class)
				.setParameter("publicIdeaId", id);
		publicIdeaReplyList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return publicIdeaReplyList;
	}
}
