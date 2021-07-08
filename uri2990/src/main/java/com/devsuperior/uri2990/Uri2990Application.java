package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDTO;
import com.devsuperior.uri2990.projections.EmpregadoProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoProjection> projectionResultList = repository.rootSqlSearch1();
		List<EmpregadoDTO> dtoResultList = projectionResultList.stream().map(x -> new EmpregadoDTO(x))
				.collect(Collectors.toList());

		System.out.println("\n*** Root SQL Result (NOT AT Query):");
		for (EmpregadoDTO obj : dtoResultList) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<EmpregadoDTO> dtoResultList2 = repository.jpqlSearch1();

		System.out.println("\n*** JPQL Result:");
		for (EmpregadoDTO obj : dtoResultList2) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<EmpregadoProjection> projectionResultList3 = repository.rootSqlSearch2();
		List<EmpregadoDTO> dtoResultList3 = projectionResultList3.stream().map(x -> new EmpregadoDTO(x))
				.collect(Collectors.toList());

		System.out.println("\n*** Root SQL Result (LEFT JOIN Query):");
		for (EmpregadoDTO obj : dtoResultList3) {
			System.out.println(obj);
		}
		System.out.println("\n\n");
	}
}
