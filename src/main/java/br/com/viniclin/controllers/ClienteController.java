package br.com.viniclin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Cliente;


@Controller
public class ClienteController {
	@GetMapping(value = "/cadastrar-cliente") //end Point
public String carregarPaginaCadastro() {
	return "page-cadastrar-cliente";
}
	@PostMapping(value = "/cadastrar-cliente") 
public String cadastrarCliente(@RequestBody Cliente cliente) {
	return "";
}

}
