package com.github.rshtishi.demo.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	private Long id;
	private String name;
	private ProductDetails details;
	private Set<Review> reviews;
	
	public Product(Long id, String name,ProductDetails details, Set<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.reviews = reviews;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductDetails getDetails() {
		return details;
	}
	public void setDetails(ProductDetails details) {
		this.details = details;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
}
