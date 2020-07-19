package com.java.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.fds.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

	List<Food> findByItemName(String foodItem);

}
