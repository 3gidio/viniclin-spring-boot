package br.com.viniclin.services;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Agendamento;

@Service
public interface AgendamentoService {
	public void cadastrar (Agendamento agendamento);

}
