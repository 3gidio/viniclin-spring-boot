package br.com.viniclin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Cliente;

@Service
public interface ClienteService {
	public void cadastrar (Cliente cliente);

	public List<Cliente> getAll();

	public void editar(Cliente cliente);

	public Cliente getById(String idCliente);

	public void apagar(String idCliente);
	
	
	
	

}
