package com.devsuperior.uri2990.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projetos")
public class Projeto {

	@Id
	private Long pnumero;
	private String pnome;

	@ManyToOne
	@JoinColumn(name = "dnumero")
	private Departamento departamento;

	@ManyToMany(mappedBy = "projetosOndeTrabalha")
	private Set<Empregado> empregados = new HashSet<>();

	public Projeto() {
	}

	public Long getPnumero() {
		return pnumero;
	}

	public void setPnumero(Long pnumero) {
		this.pnumero = pnumero;
	}

	public String getPnome() {
		return pnome;
	}

	public void setPnome(String pnome) {
		this.pnome = pnome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
