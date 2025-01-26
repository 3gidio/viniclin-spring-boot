package br.com.viniclin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.viniclin.entities.Procedimento;

@Controller
public class ProcedimentoController {
	@GetMapping(value = "/cadastrar-procedimento") // End Point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-procedimento";
	}
	

	@PostMapping (value = "/cadastrar-procedimento")
public String cadastrarProcedimento(@RequestBody Procedimento procedimento) {
	return "";
}

}
