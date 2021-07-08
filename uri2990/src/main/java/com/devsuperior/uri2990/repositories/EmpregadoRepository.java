package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.dto.EmpregadoDTO;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	@Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome "
			+ "FROM empregados "
			+ "INNER JOIN departamentos ON departamentos.dnumero = empregados.dnumero "
			+ "WHERE empregados.cpf NOT IN ( "
			+ "    SELECT empregados.cpf "
			+ "    FROM empregados "
			+ "    INNER JOIN trabalha ON empregados.cpf = trabalha.cpf_emp "
			+ ") "
			+ "ORDER BY empregados.cpf")
	List<EmpregadoProjection> rootSqlSearch1();
	
	@Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDTO(obj.cpf, obj.enome, obj.departamento.dnome) "
			+ "FROM Empregado obj "
			+ "WHERE obj.cpf NOT IN ( "
			+ "    SELECT obj.cpf "
			+ "    FROM Empregado obj "
			+ "    INNER JOIN obj.projetosOndeTrabalha "
			+ ") "
			+ "ORDER BY obj.cpf")
	List<EmpregadoDTO> jpqlSearch1();
	
	@Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome "
			+ "FROM empregados "
			+ "INNER JOIN departamentos ON departamentos.dnumero = empregados.dnumero "
			+ "LEFT JOIN trabalha ON empregados.cpf = trabalha.cpf_emp "
			+ "WHERE pnumero IS NULL "
			+ "ORDER BY empregados.cpf")
	List<EmpregadoProjection> rootSqlSearch2();
}
