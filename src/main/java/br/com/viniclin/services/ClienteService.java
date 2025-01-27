package br.com.viniclin.services;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Cliente;

@Service
public interface ClienteService {
	public void cadastrar (Cliente cliente);
	
	

}
