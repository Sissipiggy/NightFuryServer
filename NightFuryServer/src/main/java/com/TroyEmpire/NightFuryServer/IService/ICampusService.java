package com.TroyEmpire.NightFuryServer.IService;

import com.TroyEmpire.NightFuryServer.Entity.Campus;


public interface ICampusService {
	public void saveNewCampus(Campus campus);
	
	public Campus getCampusByName(String name);

}
