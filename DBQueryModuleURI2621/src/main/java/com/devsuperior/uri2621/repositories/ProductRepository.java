package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT products.name " + "FROM products "
			+ "INNER JOIN providers ON providers.id = products.id_providers "
			+ "WHERE products.amount BETWEEN :min AND :max "
			+ "AND providers.name LIKE CONCAT(:initialNameCharacter, '%')")
	List<ProductProjection> search1(Integer min, Integer max, String initialNameCharacter);

	@Query("SELECT new com.devsuperior.uri2621.dto.ProductDTO(obj.name) " + "FROM Product obj "
			+ "WHERE obj.amount BETWEEN :min AND :max "
			+ "AND obj.provider.name LIKE CONCAT(:initialNameCharacter, '%')")
	List<ProductDTO> search2(Integer min, Integer max, String initialNameCharacter);
}
