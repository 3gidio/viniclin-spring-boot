package br.com.viniclin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Agendamento;

@Service
public interface AgendamentoService {
	public void cadastrar(Agendamento agendamento);

	public void editar(Agendamento agendamento);

	public List<Agendamento> getAll();

	public Agendamento getById(String idAgendamento);

	public void apagar(String idAgendamento);

}
