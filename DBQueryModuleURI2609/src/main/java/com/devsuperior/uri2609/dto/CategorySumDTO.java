package com.devsuperior.uri2609.dto;

import com.devsuperior.uri2609.projections.CategorySumProjection;

public class CategorySumDTO {

	private String name;
	private Long sum;
	
	public CategorySumDTO() {
	}

	public CategorySumDTO(String name, Long sum) {
		this.name = name;
		this.sum = sum;
	}

	public CategorySumDTO(CategorySumProjection projection) {
		name = projection.getName();
		sum = projection.getSum();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "CategorySumDTO [name=" + name + ", sum=" + sum + "]";
	}
}
