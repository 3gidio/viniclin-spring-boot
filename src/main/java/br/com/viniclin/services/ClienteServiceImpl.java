package br.com.viniclin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.entities.Cliente;
import br.com.viniclin.repositories.AgendamentoRepository;
import br.com.viniclin.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService { // No Service serao definidas as regras de Negocio
	@Autowired
	ClienteRepository clienteRepository; // AutoWired injecao de dependencia (comunicao da Service com o Repository sob
											// o controle do Spring-Boot
	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Override
	public void cadastrar(Cliente cliente) {
		if (cliente.getNome() != null && cliente.getTelefone() != null && cliente.getEmail() != null
				&& cliente.getEndereco() != null && cliente.getCpf() != 0 && cliente.getPlanoSaude() != null) {
			clienteRepository.insert(cliente);
		} else {
			throw new RuntimeException("Preencha os campos e tente novamente!");
		}
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@Override
	public void editar(Cliente cliente) {
		if (cliente.getNome() != null && cliente.getTelefone() != null && cliente.getEmail() != null
				&& cliente.getEndereco() != null && cliente.getCpf() != 0 && cliente.getPlanoSaude() != null) {
			clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("Preencha os campos e tente novemente!");
		}

	}

	@Override
	public Cliente getById(String idCliente) {
		Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
		return cliente;
	}

	@Override
	public void apagar(String idCliente) {
		
		Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
		if (cliente != null) {
			clienteRepository.deleteById(idCliente);
		} else {
			throw new RuntimeException("Cliente nao encontrado");
		}
		
		
	}

	@Override
	public List<Cliente> findAllByNome(String nome) {
		List<Cliente> clientes = clienteRepository.findAllByNome(nome);
		return clientes;
	}

	@Override
	public Boolean clienteTemAgendamento(String idCliente) {
		Optional<Agendamento> agendamentoOptional = agendamentoRepository.findByCliente_idCliente(idCliente);
		return agendamentoOptional.isPresent() ;
	}

}
