package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.projections.CustomerProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CustomerProjection> list = repository.searchWithSQL("RS");
		List<CustomerDTO> sqlResultDTOList = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** ROOT SQL OUTCOME:");
		for (CustomerDTO obj : sqlResultDTOList) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<CustomerDTO> jpqlResultDTOList = repository.searchWithJPQL("RS");

		System.out.println("\n*** JPQL OUTCOME:");
		for (CustomerDTO obj : jpqlResultDTOList) {
			System.out.println(obj);
		}
	}
}
