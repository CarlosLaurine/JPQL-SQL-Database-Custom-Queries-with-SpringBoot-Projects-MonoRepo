package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> projectionList = repository.sqlSearch();
		List<CategorySumDTO> dtoResultList1 = projectionList.stream().map(x -> new CategorySumDTO(x))
				.collect(Collectors.toList());

		System.out.println("\n*** Root SQL Result:");
		for (CategorySumDTO obj : dtoResultList1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<CategorySumDTO> dtoResultList2 = repository.jpqlSearch();

		System.out.println("\n*** JPQL Result:");
		for (CategorySumDTO obj : dtoResultList2) {
			System.out.println(obj);
		}
	}
}
