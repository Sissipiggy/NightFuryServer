package com.TroyEmpire.NightFuryServer.IDAO;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.Cell;


public interface ICellDAO extends IDAO<Cell, Integer>{
	public List<Cell> getCellsByBuildingId(int id);
}
