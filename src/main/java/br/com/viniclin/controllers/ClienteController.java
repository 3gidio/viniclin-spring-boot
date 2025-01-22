package br.com.viniclin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClienteController {
	@GetMapping(value = "/cadastrar-cliente") //end Point
public String carregarPaginaCadastro() {
	return "page-cadastrar-cliente";
}
	
}
