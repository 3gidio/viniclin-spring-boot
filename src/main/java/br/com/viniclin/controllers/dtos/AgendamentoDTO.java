package br.com.viniclin.controllers.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.entities.Cliente;
import br.com.viniclin.entities.Especialista;
import br.com.viniclin.entities.Procedimento;

public class AgendamentoDTO { //essa classe tem a funcao de converter os valores "Strings"
	
	// do front para o Back end e tbm converter valores diferentes
	private String idAgendamento;
	
	private String idCliente;
	private String idProcedimento;
	private String idEspecialista;
	private String data;
	private String horario;
	
	public Agendamento toEntity() {
	Agendamento agendamento = new Agendamento();
	agendamento.setIdAgendamento(this.idAgendamento);
	
	Cliente cliente = new Cliente();
	cliente.setIdCliente(this.idCliente);
	
	Procedimento procedimento = new Procedimento();
	procedimento.setIdProcedimento(this.idProcedimento);
	
	Especialista especialista = new Especialista();
	especialista.setIdEspecialista(this.idEspecialista);
	
	agendamento.setCliente(cliente);
	agendamento.setProcedimento(procedimento);
	agendamento.setEspecialista(especialista);
	agendamento.setData(LocalDate.parse(this.data));
	agendamento.setHorario(LocalTime.parse(this.horario));
	
	
	return agendamento;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(String idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public String getIdEspecialista() {
		return idEspecialista;
	}
	public void setIdEspecialista(String idEspecialista) {
		this.idEspecialista = idEspecialista;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	

}
