package com.TroyEmpire.NightFuryServer.IService;

import java.util.List;

import com.TroyEmpire.NightFuryServer.Entity.Restaurant;


public interface IRestaurantService {
    public Restaurant findByPersonName(String name);
    
    public List<Restaurant> getAllRestaurant(int campus);
 
    public void saveNewRestaurant(Restaurant restaurant);
 
    public Restaurant findRestaurantById(Long id);
 
    public void deleteRestaurant(Restaurant restaurant);

}
