package br.com.viniclin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.viniclin.entities.Cliente;
import br.com.viniclin.services.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/cadastrar-cliente") // end Point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-cliente";
	}

	@PostMapping(value = "/cadastrar-cliente")
	public String cadastrarCliente(Cliente cliente, Model model) {

		try {
			clienteService.cadastrar(cliente);
			model.addAttribute("sucesso", "Cliente Cadastrado com Sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}

		return "page-cadastrar-cliente"; // Redirect sempre direciona para um GetMapping.

	}

	@GetMapping(value = "/visualizar-clientes")
	public String carregarVisualiza(Model model) {
		List<Cliente> clientes = clienteService.getAll();
		model.addAttribute("clientes", clientes);
		return "page-visualizar-clientes";
	}

	@GetMapping(value = "/editar-cliente")
	public String carregarPaginaEditar(@RequestParam String idCliente, Model model) {
		Cliente cliente = clienteService.getById(idCliente);
		model.addAttribute("cliente", cliente);

		return "page-editar-cliente";
	}

	@PostMapping(value = "/editar-cliente")
	public String editarCliente(Cliente cliente, Model model) {
		try {
			clienteService.editar(cliente);
			model.addAttribute("sucesso", "Cliente Editado com Sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}
		List<Cliente> clientes = clienteService.getAll();
		model.addAttribute("clientes", clientes);
		return "page-visualizar-clientes"; // Redirect sempre direciona para um GetMapping.

	}

	@GetMapping(value = "/apagar-cliente")
	public String carregarApagarCliente(@RequestParam String idCliente, Model model) {
		model.addAttribute("confirmacaoExcluir", "Deseja mesmo Excluir esse Cliente?");
		List<Cliente> clientes = clienteService.getAll();
		model.addAttribute("clientes", clientes);
		model.addAttribute("idClienteExcluir", idCliente);
		return "page-visualizar-clientes";
	}

	@PostMapping(value = "/apagar-cliente")
	public String apagarCliente(String idCliente, Model model) {
		Boolean temAgendamento = clienteService.clienteTemAgendamento(idCliente);
		if (temAgendamento == true) {
			model.addAttribute("atencao","Esse Cliente possui Agendamento Cadastrado!!" );
		}
		try {
			clienteService.apagar(idCliente);
			model.addAttribute("atencao", "CLiente Excluido com Sucesso!");

		} catch (RuntimeException ex) {
			model.addAttribute("atencao", ex.getLocalizedMessage());

		}
		List<Cliente> clientes = clienteService.getAll();
		model.addAttribute("clientes", clientes);
		return "page-visualizar-clientes";

	}

}
