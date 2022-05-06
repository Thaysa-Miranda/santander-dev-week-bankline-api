package com.dio.santander.bankline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	CorrentistaRepository correntistaRepository;

	public void save(CorrentistaDTO correntistaDTO) {
		Correntista correntista = new Correntista();
		correntista.setCpf(correntistaDTO.getCpf());
		correntista.setNome(correntistaDTO.getNome());

		Conta conta = new Conta();
		conta.setNumero(new Date().getTime());
		conta.setSaldo(0.0);

		correntista.setConta(conta);

		correntistaRepository.save(correntista);
	}

}
