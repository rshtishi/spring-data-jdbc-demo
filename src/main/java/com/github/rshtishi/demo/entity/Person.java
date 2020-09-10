package com.github.rshtishi.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Person {
	
	@Id
	private Long id;
	@Column("FIRST_NAME")
	private String firstname;
	@Column("LAST_NAME")
	private String lastname;
	private LocalDate birthdate;
	
	public Person() {
		super();
	}
	public Person(Long id, String firstname, String lastname, LocalDate birthdate) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	public Person(String firstname, String lastname, LocalDate birthdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	

}
