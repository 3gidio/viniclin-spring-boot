package br.com.viniclin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.viniclin.controllers.dtos.AgendamentoDTO;
import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.entities.Cliente;
import br.com.viniclin.entities.Especialista;
import br.com.viniclin.entities.Procedimento;
import br.com.viniclin.services.AgendamentoService;
import br.com.viniclin.services.ClienteService;
import br.com.viniclin.services.EspecialistaService;
import br.com.viniclin.services.ProcedimentoService;

@Controller
public class AgendamentoController {
	@Autowired
	private EspecialistaService especialistaService;
	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private ProcedimentoService procedimentoService;
	@Autowired
	private ClienteService clienteService; //Required = False e uma excessao para caso o usuario digite
									//um nome, mas se nao digitar o programa executara normalemnte
	@GetMapping(value = "/cadastrar-agendamento") // end Point
	public String carregarPaginaCadastro(Model model, @RequestParam(required = false) String nome) {
		List<Cliente> clientes = clienteService.getAll();
		if (nome != null && !nome.isEmpty()) {
			clientes = clienteService.findAllByNome(nome);
			
		} 
		model.addAttribute("clientes", clientes);
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialistas);
		List<Procedimento> procedimentos = procedimentoService.getAll();
		model.addAttribute("procedimentos", procedimentos);

		return "page-cadastrar-agendamento";
	}

	@PostMapping(value = "/cadastrar-agendamento")
	public String cadastrarAgendamento(AgendamentoDTO agendamentoDTO) {
		
		agendamentoService.cadastrar(agendamentoDTO.toEntity());
		
		return "page-cadastrar-agendamento";
	}

}
