package br.com.viniclin.services;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Especialista;

@Service
public interface EspecialistaService {
	public void cadastrar (Especialista especialista);
}
