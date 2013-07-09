package com.TroyEmpire.NightFuryServer.IDAO;


import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.PublicIdeaReply;


public interface IPublicIdeaRelyDAO extends IDAO<PublicIdeaReply, Integer> {
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id);
}
