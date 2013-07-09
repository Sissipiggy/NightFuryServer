package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.BugReply;
import com.TroyEmpire.NightFuryServer.IDAO.IBugReplyDAO;


@Component
public class BugReplyDAO extends DAO<BugReply, Integer> implements IBugReplyDAO {

	@Override
	public List<BugReply> getBugReplyByBugId(int id) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		List<BugReply> bugReplyList = null;
		String sql = "select br from BugReply br where br.bugId = :bugId";
		TypedQuery<BugReply> query = em.createQuery(sql, BugReply.class).setParameter("bugId", id);
		bugReplyList = query.getResultList();
		em.getTransaction().commit();
		em.close();

		return bugReplyList;
	}
}
