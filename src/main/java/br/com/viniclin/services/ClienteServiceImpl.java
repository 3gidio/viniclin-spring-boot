package br.com.viniclin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Cliente;
import br.com.viniclin.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService { //No Service serao definidas as regras de Negocio
	@Autowired
	ClienteRepository clienteRepository; //AutoWired injecao de dependencia (comunicao da Service com o Repository sob o controle do Spring-Boot	
	
	@Override
	public void cadastrar(Cliente cliente) {
		if (cliente.getNome() != null && cliente.getTelefone() != null
				&& cliente.getEmail() != null && cliente.getEndereco() != null
				&& cliente.getCpf() != 0 && cliente.getPlanoSaude() != null) {
		clienteRepository.insert(cliente);
		}
		else {
			throw new RuntimeException("Preencha os campos e tente novamente!"); 
		}
	}
	
}
