package com.dio.santander.bankline.api.dto;

import javax.validation.constraints.NotEmpty;

public class CorrentistaDTO {
	@NotEmpty
	private String nome;
	@NotEmpty
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
