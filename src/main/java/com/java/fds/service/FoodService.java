package com.java.fds.service;

import java.util.List;


import com.java.fds.model.Food;


public interface FoodService {

	public List<Food> getFoodItems();

	public Food saveFoodItem(Food food);
	
}
