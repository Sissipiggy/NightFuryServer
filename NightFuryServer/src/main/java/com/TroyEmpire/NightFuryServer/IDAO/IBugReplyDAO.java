package com.TroyEmpire.NightFuryServer.IDAO;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.BugReply;


public interface IBugReplyDAO extends IDAO<BugReply, Integer> {
	public List<BugReply> getBugReplyByBugId(int id);

}
