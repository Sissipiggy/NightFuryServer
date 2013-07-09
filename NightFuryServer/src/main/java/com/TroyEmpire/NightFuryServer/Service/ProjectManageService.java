package com.TroyEmpire.NightFuryServer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.NightFuryServer.Entity.Bug;
import com.TroyEmpire.NightFuryServer.Entity.BugReply;
import com.TroyEmpire.NightFuryServer.Entity.Building;
import com.TroyEmpire.NightFuryServer.Entity.Cell;
import com.TroyEmpire.NightFuryServer.Entity.PublicIdea;
import com.TroyEmpire.NightFuryServer.Entity.PublicIdeaReply;
import com.TroyEmpire.NightFuryServer.Entity.YellowPage;
import com.TroyEmpire.NightFuryServer.IDAO.IBugDAO;
import com.TroyEmpire.NightFuryServer.IDAO.IBugReplyDAO;
import com.TroyEmpire.NightFuryServer.IDAO.IBuildingDAO;
import com.TroyEmpire.NightFuryServer.IDAO.ICellDAO;
import com.TroyEmpire.NightFuryServer.IDAO.IPublicIdeaDAO;
import com.TroyEmpire.NightFuryServer.IDAO.IPublicIdeaRelyDAO;
import com.TroyEmpire.NightFuryServer.IDAO.IYellowPageDAO;
import com.TroyEmpire.NightFuryServer.IService.IProjectManageService;

@Service
@Component
public class ProjectManageService implements IProjectManageService {

	@Autowired
	private IBugDAO bugDao;
	@Autowired
	private IBugReplyDAO bugReplyDao;
	@Autowired
	private IPublicIdeaDAO publicIdeaDao;
	@Autowired
	private IPublicIdeaRelyDAO publicIdeaReplyDao;
	@Autowired
	private IBuildingDAO buildingDao;
	@Autowired
	private IYellowPageDAO yellowPageDao;
	@Autowired
	private ICellDAO cellDao;

	@Override
	public void saveBug(Bug bug) {
		bugDao.save(bug);
	}

	@Override
	public void saveBugReply(BugReply bugReply) {
		bugReplyDao.save(bugReply);
	}

	@Override
	public void savePublicIdea(PublicIdea publicIdea) {
		publicIdeaDao.save(publicIdea);
	}

	@Override
	public void savePublicIdeaReply(PublicIdeaReply publicIdeaReply) {
		publicIdeaReplyDao.save(publicIdeaReply);
	}

	@Override
	public Bug getBugById(int id) {
		return bugDao.findByID(Bug.class, Long.valueOf(id));
	}

	@Override
	public List<Bug> getAllBugs() {
		return bugDao.findAll(Bug.class);
	}

	@Override
	public List<BugReply> getBugReplyByBugId(int id) {
		return bugReplyDao.getBugReplyByBugId(id);
	}

	@Override
	public PublicIdea getPublicIdeaById(int id) {
		return publicIdeaDao.findByID(PublicIdea.class, Long.valueOf(id));
	}

	@Override
	public List<PublicIdea> getAllPublicIdea() {
		return publicIdeaDao.findAll(PublicIdea.class);
	}

	@Override
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id) {
		return publicIdeaReplyDao.getPublicIdeaReplyByIdeaId(id);
	}

	@Override
	public List<Cell> getAllCellByBuildingId(int id) {
		return cellDao.getCellsByBuildingId(id);
	}

	@Override
	public Cell getCellById(int id) {
		return cellDao.findByID(Cell.class, Long.valueOf(id));
	}

	@Override
	public void saveCell(Cell cell) {
		cellDao.save(cell);
	}

	@Override
	public List<Building> getAllBuildings() {
		return buildingDao.findAll(Building.class);
	}

	@Override
	public Building getBuildingById(int id) {
		return buildingDao.findByID(Building.class, Long.valueOf(id));
	}

	@Override
	public void saveYellowPage(YellowPage entity) {
		yellowPageDao.save(entity);
	}

	@Override
	public List<YellowPage> getAllYellowPages() {
		return yellowPageDao.findAll(YellowPage.class);
	}

}
