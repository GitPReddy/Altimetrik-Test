package com.java.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.fds.model.Food;
import com.java.fds.model.Restaurent;
import com.java.fds.repository.FoodRepository;
import com.java.fds.repository.RestaurentRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	RestaurentRepository restaurentRepository;

	@Override
	public List<Food> getFoodItems() {
		return foodRepository.findAll();
	}

	@Override
	public Food saveFoodItem(Food food) {
		return foodRepository.save(food);
	}
	
	
	
}
