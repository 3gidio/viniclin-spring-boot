package br.com.viniclin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Especialista;

@Service
public interface EspecialistaService {
	public void cadastrar(Especialista especialista);

	public List<Especialista> getAll();

	public Especialista getById(String idEspecialista);

	public void editar(Especialista especialista);

}
