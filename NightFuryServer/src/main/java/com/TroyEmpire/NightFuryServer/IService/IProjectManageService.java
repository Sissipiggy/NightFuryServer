package com.TroyEmpire.NightFuryServer.IService;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.Bug;
import com.TroyEmpire.NightFuryServer.Entity.BugReply;
import com.TroyEmpire.NightFuryServer.Entity.Building;
import com.TroyEmpire.NightFuryServer.Entity.Cell;
import com.TroyEmpire.NightFuryServer.Entity.PublicIdea;
import com.TroyEmpire.NightFuryServer.Entity.PublicIdeaReply;
import com.TroyEmpire.NightFuryServer.Entity.YellowPage;


public interface IProjectManageService {
	public void saveBug(Bug bug);
	public void saveBugReply(BugReply bugReply);
	public void savePublicIdea(PublicIdea publicIdea);
	public void savePublicIdeaReply(PublicIdeaReply publicIdeaReply);
	
	public Bug getBugById(int id);
	public List<Bug> getAllBugs();
	
	public List<BugReply> getBugReplyByBugId(int id);
	
	public PublicIdea getPublicIdeaById(int id);
	public List<PublicIdea> getAllPublicIdea();
	
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id);
	
	public List<Cell> getAllCellByBuildingId(int id);
	public Cell getCellById(int id);
	public void saveCell(Cell cell);
	
	public List<Building> getAllBuildings();
	public Building getBuildingById(int id);
	
	public void saveYellowPage(YellowPage entity);
	public List<YellowPage> getAllYellowPages();
}
