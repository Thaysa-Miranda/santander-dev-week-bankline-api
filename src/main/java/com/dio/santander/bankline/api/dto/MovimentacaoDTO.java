package com.dio.santander.bankline.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.dio.santander.bankline.api.model.MovimentacaoTipo;

public class MovimentacaoDTO {
	@NotEmpty
	private String descricao;
	@NotNull
	private Double valor;

	private MovimentacaoTipo tipo;
	@NotNull
	private Integer idConta;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimentacaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

}
