package br.com.viniclin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Cliente;
import br.com.viniclin.services.ClienteService;



@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/cadastrar-cliente") //end Point
public String carregarPaginaCadastro() {
	return "page-cadastrar-cliente";
}
	@PostMapping(value = "/cadastrar-cliente") 
public String cadastrarCliente(@RequestBody Cliente cliente) {
		clienteService.cadastrar(cliente);
		try {
			clienteService.cadastrar(cliente);
			//model.addAttribute("sucesso", "Cliente Cadastrado com Sucesso");
		} catch (RuntimeException ex) {
			//model.addAttribute("erro", ex.getLocalizedMessage()); 
		}
		
	return "redirect:/cadastrar-cliente"; //Redirect sempre direciona para um GetMapping.
	
}

}
