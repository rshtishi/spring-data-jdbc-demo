package com.github.rshtishi.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Person {
	
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	
	public Person() {
		super();
	}
	public Person(Long id, String firstName, String lastName, LocalDate birthdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
	public Person(String firstName, String lastName, LocalDate birthdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	

}
