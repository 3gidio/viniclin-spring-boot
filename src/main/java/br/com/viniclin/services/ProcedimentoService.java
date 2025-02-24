package br.com.viniclin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Procedimento;

@Service
public interface ProcedimentoService {
	public void cadastrar (Procedimento procedimento);
	

	public void editar(Procedimento procedimento);


	void apagar(String idProcedimento);


	Procedimento getById(String idProcedimento);


	List<Procedimento> getAll();

}
