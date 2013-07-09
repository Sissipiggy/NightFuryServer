package com.TroyEmpire.NightFuryServer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.NightFuryServer.Entity.Restaurant;
import com.TroyEmpire.NightFuryServer.IDAO.IRestaurantDAO;
import com.TroyEmpire.NightFuryServer.IService.IRestaurantService;


@Service
@Component
public class RestaurantService implements IRestaurantService {

	@Autowired
	private IRestaurantDAO personDAO;

	@Override
	public Restaurant findByPersonName(String name) {
		Restaurant restaurant = null;
		try {
			restaurant = personDAO.findByName(name);
		} catch (Exception e) {
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurant(int campus) {
		List<Restaurant> res = personDAO.findAll(Restaurant.class);
		return res;
	}

	@Override
	public void saveNewRestaurant(Restaurant restaurant) {
		try {
			personDAO.save(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant findRestaurantById(Long id) {
		Restaurant rs = null;
		try {
			rs = personDAO.findByID(Restaurant.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		try {
			personDAO.delete(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
