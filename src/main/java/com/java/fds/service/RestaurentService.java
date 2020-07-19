package com.java.fds.service;

import java.util.List;


import com.java.fds.model.Restaurent;


public interface RestaurentService {

	Restaurent saveRestaurent(Restaurent restaurent);

	List<Restaurent> getAllRestaurents();
	
	List<Restaurent> findByFoodItem(String foodItem);

	Restaurent getRestaurentByName(String name);
	
}
