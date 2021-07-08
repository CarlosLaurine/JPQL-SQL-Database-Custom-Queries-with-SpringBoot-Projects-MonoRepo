package com.devsuperior.uri2990.dto;

import com.devsuperior.uri2990.projections.EmpregadoProjection;

public class EmpregadoDTO {

	private String cpf;
	private String enome;
	private String dnome;

	public EmpregadoDTO() {
	}

	public EmpregadoDTO(String cpf, String enome, String dnome) {
		this.cpf = cpf;
		this.enome = enome;
		this.dnome = dnome;
	}

	public EmpregadoDTO(EmpregadoProjection projection) {
		cpf = projection.getCpf();
		enome = projection.getEnome();
		dnome = projection.getDnome();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEnome() {
		return enome;
	}

	public void setEnome(String enome) {
		this.enome = enome;
	}

	public String getDnome() {
		return dnome;
	}

	public void setDnome(String dnome) {
		this.dnome = dnome;
	}

	@Override
	public String toString() {
		return "EmpregadoDeptDTO [cpf=" + cpf + ", enome=" + enome + ", dnome=" + dnome + "]";
	}
}
