package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentacaoRepository;

	@Autowired
	CorrentistaRepository correntistaRepository;

	public void save(MovimentacaoDTO movimentacaoDTO) {
		Movimentacao movimentacao = new Movimentacao();

		Double valor = movimentacaoDTO.getTipo() == MovimentacaoTipo.RECEITA ? movimentacaoDTO.getValor()
				: movimentacaoDTO.getValor() * -1;

		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(movimentacaoDTO.getDescricao());
		movimentacao.setTipo(movimentacaoDTO.getTipo());
		movimentacao.setIdConta(movimentacaoDTO.getIdConta());
		movimentacao.setValor(valor);

		Correntista correntista = correntistaRepository.findById(movimentacaoDTO.getIdConta()).orElse(null);
		if (correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}

		movimentacaoRepository.save(movimentacao);
	}

}
