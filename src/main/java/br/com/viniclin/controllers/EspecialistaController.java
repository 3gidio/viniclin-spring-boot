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
import br.com.viniclin.entities.Especialista;
import br.com.viniclin.services.EspecialistaService;

@Controller
public class EspecialistaController {

	@Autowired
	private EspecialistaService especialistaService;

	@GetMapping(value = "/cadastrar-especialista") // end point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-especialista";
	}

	@PostMapping(value = "/cadastrar-especialista")
	public String cadastrarEspecialista(Especialista especialista, Model model) {
		try {
			especialistaService.cadastrar(especialista);
			model.addAttribute("sucesso", "Especialista Cadastrado com Sucesso!");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}

		return "page-cadastrar-especialista";
	}

	@GetMapping(value = "/visualizar-especialista")
	public String carrregarVisualiza(Model model) {
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialistas);
		return "visualizar-especialistas";

	}

	@GetMapping(value = "/editar-especialista")
	public String carreagarPaginaEditar(@RequestParam String idEspecialista, Model model) {
		Especialista especialista = especialistaService.getById(idEspecialista);
		model.addAttribute("especialista", especialista);

		return "page-editar-especialista";

	}

	@PostMapping(value = "/editar-especialista")
	public String editarEspecialista(Especialista especialista, Model model) {
		try {
			especialistaService.editar(especialista);
			model.addAttribute("sucesso", "Especialista editado com sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialista);
		return "visualizar-especialistas";
	}

	@GetMapping(value = "/apagar-especialista")
	public String carregarApagarEspecialista(@RequestParam String idEspecialista, Model model) {
		model.addAttribute("confirmacaoExcluir", "Deseja mesmo Excluir esse Especialista?");
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialistas);
		model.addAttribute("idEspecialistaExcluir", idEspecialista);
		return "visualizar-especialista";
	}

	@PostMapping(value = "/apagar-especialista")
	public String apagarEspecialista(String idEspecialista, Model model) {
		try {
			especialistaService.apagar(idEspecialista);
			model.addAttribute("atencao", "Especialista Excluido com Sucesso!");

		} catch (RuntimeException ex) {
			model.addAttribute("atencao", ex.getLocalizedMessage());

		}
		List<Especialista> especialistas = especialistaService.getAll();
		model.addAttribute("especialistas", especialistas);
		return "visualizar-especialistas";
	}

}
