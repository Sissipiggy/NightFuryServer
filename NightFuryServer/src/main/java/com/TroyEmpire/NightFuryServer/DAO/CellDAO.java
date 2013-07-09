package com.TroyEmpire.NightFuryServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.Cell;
import com.TroyEmpire.NightFuryServer.IDAO.ICellDAO;

@Component
public class CellDAO extends DAO<Cell, Integer> implements ICellDAO {
	
	@Override
	public List<Cell> getCellsByBuildingId(int id){
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		List<Cell> cellList = null;
		String sql = "select c from Cell c where c.buildingId = :buildingId";
		TypedQuery<Cell> query = em.createQuery(sql,Cell.class)
				.setParameter("buildingId", id);
		cellList = query.getResultList();
		
		em.getTransaction().commit();
		em.close();

		return cellList;
	}
}
