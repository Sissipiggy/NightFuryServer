package com.TroyEmpire.NightFuryServer.DAO;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.PublicIdea;
import com.TroyEmpire.NightFuryServer.IDAO.IPublicIdeaDAO;


@Component
public class PublicIdeaDAO extends DAO<PublicIdea, Integer> implements
		IPublicIdeaDAO {

}
