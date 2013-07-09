package com.TroyEmpire.NightFuryServer.IDAO;

import com.TroyEmpire.NightFuryServer.Entity.Building;



public interface IBuildingDAO extends IDAO<Building, Integer>{
	public Building getBuildingByname(String name);
	public Building getBuildingByCellName(String name);
}
