package com.java.fds.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.fds.model.Food;
import com.java.fds.model.Restaurent;
import com.java.fds.repository.FoodRepository;
import com.java.fds.repository.RestaurentRepository;

@Service
public class RestaurentServiceImpl implements RestaurentService {
	
	@Autowired
	RestaurentRepository restaurentRepository;
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public Restaurent saveRestaurent(Restaurent restaurent) {
		return restaurentRepository.save(restaurent);
	}

	@Override
	public List<Restaurent> getAllRestaurents() {
		return restaurentRepository.findAll();
	}

	@Override
	public List<Restaurent> findByFoodItem(String foodItem) {
		List<Restaurent> restaurents = new ArrayList<>();
		List<Food> foodItems = foodRepository.findByItemName(foodItem);
		for(Food item : foodItems) {
			Optional<Restaurent> restaurent =  restaurentRepository.findById(item.getResId());
			if(restaurent.isPresent()) {
				restaurents.add(restaurent.get());
			}
			
		}
		//Collections.sort(restaurents, new RatingPriceComparator());
		return restaurents;
	}
	
	

	
	@Override
	public Restaurent getRestaurentByName(String name) {
		return restaurentRepository.findByName(name);
	}




	static class RatingPriceComparator implements Comparator<Restaurent>{
		@Override
		public int compare(Restaurent restaurent1, Restaurent restaurent2) {
			int ratingCompare = restaurent1.getRating() - restaurent2.getRating();
			Iterator<Food> itrFood1 = restaurent1.getFood().iterator();
			Iterator<Food> itrFood2 = restaurent2.getFood().iterator();
			double foodItem1Price = 0;
			double foodItem2Price = 0;
			while(itrFood1.hasNext()) {
				Food foodItem = itrFood1.next();
				foodItem1Price = foodItem.getPrice();
			}
			while(itrFood2.hasNext()) {
				Food foodItem = itrFood2.next();
				foodItem2Price = foodItem.getPrice();
			}
			int priceCompare = (int) (foodItem1Price - foodItem2Price);
			if(ratingCompare == 0) {
				return (priceCompare == 0 ? ratingCompare : priceCompare);
			}else {
				return ratingCompare;
			}
		}
	}
	
}
