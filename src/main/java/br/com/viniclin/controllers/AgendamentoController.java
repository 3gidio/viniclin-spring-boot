package br.com.viniclin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Agendamento;

@Controller
public class AgendamentoController {
	@GetMapping(value = "/cadastrar-agendamento") // end Point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-agendamento";
	}
@PostMapping(value = "/cadastrar-agendamento")
public String cadastrarAgendamento(@RequestBody Agendamento agendamento) {
	return "" ;
}

}
