package br.com.viniclin.services;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Procedimento;

@Service
public interface ProcedimentoService {
	public void cadastrar (Procedimento procedimento);

}
