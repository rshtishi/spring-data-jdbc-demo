package com.github.rshtishi.demo.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.rshtishi.demo.entity.Product;
import com.github.rshtishi.demo.entity.ProductDetails;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void testSave() {
		// setup
		Product product = new Product(null, "Lap Top", new ProductDetails("Rando", LocalDateTime.now()));
		// execute
		productRepository.save(product);
	}

}
