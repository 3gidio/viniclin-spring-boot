package br.com.viniclin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.entities.Cliente;
import br.com.viniclin.entities.Especialista;
import br.com.viniclin.services.EspecialistaService;

@Controller
public class AgendamentoController {
	@Autowired
	private EspecialistaService especialistaService;

	@GetMapping(value = "/cadastrar-agendamento") // end Point
	public String carregarPaginaCadastro(Model model) {
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialistas);
		return "page-cadastrar-agendamento";
	}

	@PostMapping(value = "/cadastrar-agendamento")
	public String cadastrarAgendamento(Agendamento agendamento) {
		return "page-cadastrar-agendamento";
	}
	
	@GetMapping(value = "procurar-especialista-pelo-nome")
			public String procurarEspecialistaPeloNome(Model model, String nomeEspecialista) {
		List<Especialista> especialistas = especialistaService.findAllByNomeEspecialista(nomeEspecialista);
		model.addAttribute("especialistas", especialistas);
		return "page-cadastrar-agendamento";
	}
	

}
