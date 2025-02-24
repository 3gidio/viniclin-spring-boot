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
import br.com.viniclin.entities.Procedimento;
import br.com.viniclin.services.ProcedimentoService;


@Controller
public class ProcedimentoController {
	@Autowired
	private ProcedimentoService procedimentoService;

	@GetMapping(value = "/cadastrar-procedimento") // End Point
	public String carregarPaginaCadastro() {
		return "page-cadastrar-procedimento";
	}

	@PostMapping(value = "/cadastrar-procedimento")
	public String cadastrarProcedimento(Procedimento procedimento, Model model) {
		try {
			procedimentoService.cadastrar(procedimento);
			model.addAttribute("sucesso", "Procedimento Cadastrado com Sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}

		return "page-cadastrar-procedimento";

	}

	@GetMapping(value = "/visualizar-procedimento")
	public String carregarVisualiza(Model model) {
		List<Procedimento> procedimentos = procedimentoService.getAll();
		model.addAttribute("procedimentos", procedimentos);
		return "visualizar-procedimentos";
	}

	@GetMapping(value = "/editar-procedimento")
	public String carregarPaginaEditar(@RequestParam String idProcedimento, Model model) {
		Procedimento procedimento = procedimentoService.getById(idProcedimento);
		model.addAttribute("procedimento", procedimento);

		return "page-editar-procedimento";
	}

	@PostMapping(value = "/editar-procedimento")
	public String editarProcedimento(Procedimento procedimento, Model model) {
		try {
			procedimentoService.editar(procedimento);
			model.addAttribute("sucesso", "Procedimento Editado com Sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}
		List<Procedimento> procedimentos = procedimentoService.getAll();
		model.addAttribute("procedimentos", procedimentos);
		return "visualizar-procedimentos"; // Redirect sempre direciona para um GetMapping.

	}

	@GetMapping(value = "/apagar-procedimento")
	public String carregarApagarProcedimento(@RequestParam String idProcedimento, Model model) {
		model.addAttribute("confirmacaoExcluir", "Deseja mesmo Excluir esse procedimento?");
		List<Procedimento> procedimentos = procedimentoService.getAll();
		model.addAttribute("procedimentos", procedimentos);
		model.addAttribute("idProcedimentoExcluir", idProcedimento);
		return "visualizar-procedimentos";
	}

	@PostMapping(value = "/apagar-procedimento")
	public String apagarProcedimento(String idProcedimento, Model model) {
		try {
			procedimentoService.apagar(idProcedimento);
			model.addAttribute("atencao", "Procedimento Excluido com Sucesso!");

		} catch (RuntimeException ex) {
			model.addAttribute("atencao", ex.getLocalizedMessage());

		}
		List<Procedimento> procedimentos = procedimentoService.getAll();
		model.addAttribute("procedimentos", procedimentos);
		return "visualizar-procedimentos";

	}

}
