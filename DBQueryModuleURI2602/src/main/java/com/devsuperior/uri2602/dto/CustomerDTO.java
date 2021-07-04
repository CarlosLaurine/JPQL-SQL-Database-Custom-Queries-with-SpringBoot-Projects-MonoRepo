package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerProjection;

public class CustomerDTO {

	private String name;
	
	public CustomerDTO() {
	}

	public CustomerDTO(String name) {
		this.name = name;
	}

	public CustomerDTO(CustomerProjection projection) {
		name = projection.getName();
	}
	
	String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + "]";
	}
}
