package com.github.rshtishi.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.rshtishi.demo.entity.Person;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	@Order(1)
	void testFindAll() {
		// setup
		// execute
		List<Person> persons = personRepository.findAll();
		// verify
		int expectedSize = 1;
		assertEquals(expectedSize, persons.size());
	}

	@Test
	@Order(2)
	void testFindById() {
		// setup
		long id = 1L;
		// execute
		Person person = personRepository.findById(id);
		// verify
		String expectedName = "Rando";
		assertEquals(id, person.getId());
		assertEquals(expectedName, person.getFirstname());
	}

	@Test
	@Order(3)
	void testSave() {
		// setup
		Person person = new Person("Linus", "Torvalds", LocalDate.of(1969, 12, 28));
		// execute
		personRepository.save(person);
		// verify
		List<Person> persons = personRepository.findAll();
		int expectedSize = 2;
		assertEquals(expectedSize, persons.size());
	}

	@Test
	@Order(4)
	void testDeleteById() {
		// setup
		long id = 2L;
		// execute
		personRepository.deleteById(id);
		// verify
		List<Person> persons = personRepository.findAll();
		int expectedSize = 1;
		assertEquals(expectedSize, persons.size());
	}

	@Test
	@Order(5)
	void testFindByFirstName() {
		// setup
		String firstName = "Rando";
		// execute
		List<Person> persons = personRepository.findByFirstname(firstName);
		// verify
		assertEquals(firstName, persons.get(0).getFirstname());
	}

	@Test
	@Order(6)
	void testFindByName() {
		// setup
		String name = "Shtishi";
		// execute
		List<Person> persons = personRepository.findByName(name);
		// verify
		assertEquals(name, persons.get(0).getLastname());
	}

}
