package com.java.fds.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;

@Entity

public class Food implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemName;
	private Long resId;
	private double price;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
@JoinTable(name = "food_restaurents",
joinColumns = { @JoinColumn(name = "restaurent_id") },
inverseJoinColumns = { @JoinColumn(name = "food_id") })
	private Set<Restaurent> restaurent = new HashSet<>(0);
	
	public Food() {
		
		
	}

	public Food(Long itemId, String itemName, Long resId, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.resId = resId;
		this.price = price;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public Set<Restaurent> getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(Set<Restaurent> restaurent) {
		this.restaurent = restaurent;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
	
	
}
