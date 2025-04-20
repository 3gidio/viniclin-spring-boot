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
	private ClienteService clienteService; // Required = False e uma excessao para caso o usuario digite
	// um nome, mas se nao digitar o programa executara normalemnte

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

	@GetMapping(value = "/visualizar-agendamentos")
	public String visualizarAgendamento(Model model) {

		List<Agendamento> agendamentos = agendamentoService.getAll();
		model.addAttribute("agendamentos", agendamentos);

		return "page-visualizar-agendamento";
	}

	@GetMapping(value = "/editar-agendamento")
	public String carregarPaginaEditar(@RequestParam String idAgendamento, Model model) {
		Agendamento agendamento = agendamentoService.getById(idAgendamento);
		model.addAttribute("agendamento", agendamento);

		List<Especialista> especialistas = especialistaService.getAll();
		for (int i = 0; i < especialistas.size(); i++) {
			if (especialistas.get(i).getIdEspecialista().equals(agendamento.getEspecialista().getIdEspecialista())) {
				especialistas.remove(i);
			}
		}
		model.addAttribute("especialistas", especialistas);

		List<Procedimento> procedimentos = procedimentoService.getAll();
		for (int i = 0; i < procedimentos.size(); i++) {
			if (procedimentos.get(i).getIdProcedimento().equals(agendamento.getProcedimento().getIdProcedimento())) {
				procedimentos.remove(i);
			}
		}
		model.addAttribute("procedimentos", procedimentos);

		return "page-editar-agendamento";
	}

	@PostMapping(value = "/editar-agendamento")
	public String editarAgendamento(AgendamentoDTO agendamentoDTO, Model model) {
		try {
			agendamentoService.editar(agendamentoDTO.toEntity());
			model.addAttribute("sucesso", "Agendamento Editado com Sucesso");
		} catch (RuntimeException ex) {
			model.addAttribute("erro", ex.getLocalizedMessage());
		}
		List<Agendamento> agendamentos = agendamentoService.getAll();
		model.addAttribute("agendamentos", agendamentos);
		return "page-visualizar-agendamento"; // Redirect sempre direciona para um GetMapping.

	}
	@GetMapping(value= "/apagar-agendamento")
	public String carregarApagarAgendamento(@RequestParam String idAgendamento, Model model) {
		model.addAttribute("confirmacaoExcluir", "Deseja Mesmo Excluir esse Agendamento?");
		List<Agendamento> agendamentos = agendamentoService.getAll();
		model.addAttribute("agendamentos", agendamentos);
		model.addAttribute("idAgendamentoExcluir", idAgendamento);
		return "page-visualizar-agendamento";
		}
	
	@PostMapping(value = "/apagar-agendamento")
	public String apagarAgendamento(String idAgendamento, Model model) {
		try {
			agendamentoService.apagar(idAgendamento);
			model.addAttribute("atencao","Agendamento Excluido com Sucesso");
			
		} catch (RuntimeException ex) {
			model.addAttribute("atencao", ex.getLocalizedMessage());
		}
		List<Agendamento> agendamentos = agendamentoService.getAll();
		model.addAttribute("agendamentos", agendamentos);
		return "page-visualizar-agendamento";
	}
	
	
}
