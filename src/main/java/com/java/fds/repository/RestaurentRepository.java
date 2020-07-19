package com.java.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.fds.model.Restaurent;


@Repository
public interface RestaurentRepository extends JpaRepository<Restaurent, Long>{

	Restaurent findByName(String name);

}
