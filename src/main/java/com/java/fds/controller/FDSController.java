package com.java.fds.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.fds.model.Food;
import com.java.fds.model.Restaurent;
import com.java.fds.service.FoodService;
import com.java.fds.service.RestaurentService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FDSController {
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	RestaurentService restaurentService;
	
	@PostMapping("/item")
	public ResponseEntity<Object> saveFoodItem(@RequestBody Food food) {
		Food saveFood = foodService.saveFoodItem(food);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveFood.getItemId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/items")
	public List<Food> getAllFoodItems(){
		return foodService.getFoodItems();
	}
	
	
	
	@PostMapping("/restaurent")
	public ResponseEntity<Object> saveFoodItem(@RequestBody Restaurent restaurent) {
		Restaurent saveFood = restaurentService.saveRestaurent(restaurent);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveFood.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/restaurents")
	public List<Restaurent> getAllRestaurents(){
		return restaurentService.getAllRestaurents();
	}
	
	@GetMapping("/restaurents/{foodItem}")
	public List<Restaurent> getRestaurentsByFoodItem(@PathVariable String foodItem){
		return restaurentService.findByFoodItem(foodItem);
	}
	
}
