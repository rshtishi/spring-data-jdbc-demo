package com.github.rshtishi.demo.entity;

import java.time.LocalDateTime;

public class UserDetails {
	
	private String createdBy;
	private LocalDateTime createdOn;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
