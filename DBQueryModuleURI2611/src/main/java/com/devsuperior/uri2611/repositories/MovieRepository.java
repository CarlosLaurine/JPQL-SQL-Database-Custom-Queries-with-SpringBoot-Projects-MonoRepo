package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
			+ "FROM movies "
			+ "INNER JOIN genres ON movies.id_genres = genres.id "
			+ "WHERE genres.description = :genreName")
	List<MovieProjection> search1(String genreName);

	@Query("SELECT new com.devsuperior.uri2611.dto.MovieDTO(movie.id, movie.name) "
			+ "FROM Movie movie "
			+ "WHERE movie.genre.description = :genreName")
	List<MovieDTO> search2(String genreName);
}
