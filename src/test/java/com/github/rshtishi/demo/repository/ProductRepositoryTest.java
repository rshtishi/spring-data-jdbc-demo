package com.github.rshtishi.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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
	@Order(1)
	void testFindAll() {
		// setup
		// execute
		List<Product> products = productRepository.findAll();
		// verify
		int expectedSize = 1;
		assertEquals(expectedSize, products.size());
	}

	@Test
	@Order(2)
	void testFindById() {
		// setup
		int id = 1;
		// execute
		Product product = productRepository.findById(id);
		// verify
		String expectedName = "Tablet";
		assertEquals(expectedName, product.getName());
	}

	@Test
	@Order(3)
	void testSave() {
		// setup
		Product product = new Product(null, "Lap Top", new ProductDetails("Rando", LocalDateTime.now()));
		// execute
		productRepository.save(product);
		// verify
		int expectedSize = 2;
		List<Product> products = productRepository.findAll();
		assertEquals(expectedSize, products.size());
	}

	@Test
	@Order(4)
	void testDeleteById() {
		// setup
		long id = 1;
		// execute
		productRepository.deleteById(id);
		// verify
		int expectedSize = 1;
		List<Product> products = productRepository.findAll();
		assertEquals(expectedSize, products.size());
		
	}

}
