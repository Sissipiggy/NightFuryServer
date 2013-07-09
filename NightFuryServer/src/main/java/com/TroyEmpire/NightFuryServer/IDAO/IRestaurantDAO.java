package com.TroyEmpire.NightFuryServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.Restaurant;



/**
 * @author Hector
 */
public interface IRestaurantDAO extends IDAO<Restaurant, Integer>{
	public  Restaurant findByName(String name);
	public List<Restaurant> findRestsaurantByCampusId(int campusId);
}
