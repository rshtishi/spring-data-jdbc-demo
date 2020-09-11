package com.github.rshtishi.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.rshtishi.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
