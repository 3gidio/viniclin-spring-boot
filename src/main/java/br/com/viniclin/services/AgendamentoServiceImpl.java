package br.com.viniclin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.repositories.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Override
	public void cadastrar (Agendamento agendamento) {
		if (agendamento.getData() != null && agendamento.getHorario() != null 
			&& agendamento.getIdCliente() != null && agendamento.getIdEspecialista() != null
			&& agendamento.getIdProcedimento() != null ) {
			agendamentoRepository.insert(agendamento);
		}
		
	}
}
