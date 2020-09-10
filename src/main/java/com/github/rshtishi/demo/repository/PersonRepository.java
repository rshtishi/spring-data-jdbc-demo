package com.github.rshtishi.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.rshtishi.demo.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findAll();

	Person findById(long id);

	List<Person> findByFirstname(String firstname);

	@Query("select * from person where first_name=:name or last_name=:name")
	List<Person> findByName(@Param("name") String name);

	@Modifying
	@Query("UPDATE person SET first_name=:firstname, last_name=:lastname WHERE id=:id")
	boolean updatePersonName(@Param("id") Long id, @Param("firstname") String firstname,
			@Param("lastname") String lastname);

}
