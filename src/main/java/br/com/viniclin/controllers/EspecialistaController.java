package br.com.viniclin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Especialista;

@Controller
public class EspecialistaController {
	@GetMapping(value = "/cadastrar-especialista") // end point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-especialista";
	}

	@PostMapping(value = "/cadastrar-especialista")
	public String cadastrarEspecialista(@RequestBody Especialista especialista) {
		return "";
	}

}
