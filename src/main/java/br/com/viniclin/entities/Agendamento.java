package br.com.viniclin.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Agendamento {
	@Id
	private String idAgendamento;
	private String idEspecialista;
	private String idProcedimento;
	private String idCliente;
	private LocalDate data;
	private LocalTime horario;
	public String getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public String getIdEspecialista() {
		return idEspecialista;
	}
	public void setIdEspecialista(String idEspecialista) {
		this.idEspecialista = idEspecialista;
	}
	public String getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(String idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	
}
