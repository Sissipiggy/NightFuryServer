package com.TroyEmpire.NightFuryServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.NightFuryServer.DAO.CampusDAO;
import com.TroyEmpire.NightFuryServer.Entity.Campus;
import com.TroyEmpire.NightFuryServer.IDAO.ICampusDAO;
import com.TroyEmpire.NightFuryServer.IService.ICampusService;



@Service
@Component
public class CampusService implements ICampusService{

	@Autowired
	private ICampusDAO campusDao;
	@Override
	public void saveNewCampus(Campus campus) {
		campusDao.save(campus);	
	}
	
	@Override
	public Campus getCampusByName(String name) {
		return campusDao.getCampusByName(name);
	}

}
