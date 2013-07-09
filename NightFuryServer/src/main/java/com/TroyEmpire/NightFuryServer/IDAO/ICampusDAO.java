package com.TroyEmpire.NightFuryServer.IDAO;

import com.TroyEmpire.NightFuryServer.Entity.Campus;


public interface ICampusDAO extends IDAO<Campus, Integer>{
	public Campus getCampusByName(String campusName);
}
