package com.devsuperior.uri2990.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	private Long dnumero;
	private String dnome;

	@OneToMany(mappedBy = "departamento")
	private List<Empregado> empregados = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "cpf_gerente")
	private Empregado gerente;

	public Departamento() {
	}

	public Long getDnumero() {
		return dnumero;
	}

	public void setDnumero(Long dnumero) {
		this.dnumero = dnumero;
	}

	public String getDnome() {
		return dnome;
	}

	public void setDnome(String dnome) {
		this.dnome = dnome;
	}

	public Empregado getGerente() {
		return gerente;
	}

	public void setGerente(Empregado gerente) {
		this.gerente = gerente;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}
}
