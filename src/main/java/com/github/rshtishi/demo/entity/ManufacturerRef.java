package com.github.rshtishi.demo.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT_MANUFACTURER")
public class ManufacturerRef {

	Long manufacturer;

	public ManufacturerRef(Long manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}

	public Long getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Long manufacturer) {
		this.manufacturer = manufacturer;
	}

}
