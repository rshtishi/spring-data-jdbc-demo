package com.github.rshtishi.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.rshtishi.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	
	Product findById(long id);

}
