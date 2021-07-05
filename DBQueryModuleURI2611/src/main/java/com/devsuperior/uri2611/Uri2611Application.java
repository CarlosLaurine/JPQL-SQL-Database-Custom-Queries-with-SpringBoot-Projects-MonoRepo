package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.projections.MovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieProjection> list = repository.search1("Action");
		List<MovieDTO> result1DTOList = list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());

		System.out.println("\n*** Root SQL Result Query:");
		for (MovieDTO obj : result1DTOList) {
			System.out.println(obj);
		}
		System.out.println("\n\n");

		List<MovieDTO> result2DTOList = repository.search2("Action");

		System.out.println("\n*** JPQL Result Query:");
		for (MovieDTO obj : result2DTOList) {
			System.out.println(obj);
		}
	}
}
