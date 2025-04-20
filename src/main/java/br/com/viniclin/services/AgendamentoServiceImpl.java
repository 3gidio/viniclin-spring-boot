package br.com.viniclin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Agendamento;
import br.com.viniclin.entities.Cliente;
import br.com.viniclin.entities.Especialista;
import br.com.viniclin.entities.Procedimento;
import br.com.viniclin.repositories.AgendamentoRepository;
import br.com.viniclin.repositories.ClienteRepository;
import br.com.viniclin.repositories.EspecialistaRepository;
import br.com.viniclin.repositories.ProcedimentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EspecialistaRepository especialistaRepository;

	@Autowired
	private ProcedimentoRepository procedimentoRepository;

	@Override
	public void cadastrar(Agendamento agendamento) {
		if (agendamento.getData() != null && agendamento.getHorario() != null && agendamento.getCliente() != null
				&& agendamento.getEspecialista() != null && agendamento.getProcedimento() != null) {
			agendamentoRepository.insert(agendamento);
		}

	}

	@Override
	public List<Agendamento> getAll() {
		List<Agendamento> agendamentos = agendamentoRepository.findAll();

		for (Agendamento agendamento : agendamentos) {// Para cada Agendamento da lista dos agendamentos
			String idCliente = agendamento.getCliente().getIdCliente();
			Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
			if (clienteOptional.isPresent()) {
				Cliente clienteCompleto = clienteOptional.get();
				Cliente cliente = new Cliente();
				cliente.setIdCliente(clienteCompleto.getIdCliente());
				cliente.setNome(clienteCompleto.getNome());
				cliente.setPlanoSaude(clienteCompleto.getPlanoSaude());
				agendamento.setCliente(cliente);
			}
			String idEspecialista = agendamento.getEspecialista().getIdEspecialista();
			Optional<Especialista> especialistaOptional = especialistaRepository.findById(idEspecialista);
			if (especialistaOptional.isPresent()) {
				Especialista especialistaCompleto = especialistaOptional.get();
				Especialista especialista = new Especialista();
				especialista.setIdEspecialista(especialistaCompleto.getIdEspecialista());
				especialista.setNomeEspecialista(especialistaCompleto.getNomeEspecialista());
				especialista.setEspecialidade(especialistaCompleto.getEspecialidade());
				agendamento.setEspecialista(especialista);
			}
			String idProcedimento = agendamento.getProcedimento().getIdProcedimento();
			Optional<Procedimento> procedimentoOptional = procedimentoRepository.findById(idProcedimento);
			if (procedimentoOptional.isPresent()) {
				Procedimento procedimentoCompleto = procedimentoOptional.get();
				Procedimento procedimento = new Procedimento();
				procedimento.setIdProcedimento(procedimentoCompleto.getIdProcedimento());
				procedimento.setNomeProcedimento(procedimentoCompleto.getNomeProcedimento());
				procedimento.setDuracaoEmMinutos(procedimentoCompleto.getDuracaoEmMinutos());
				procedimento.setValor(procedimentoCompleto.getValor());
				agendamento.setProcedimento(procedimento);

			}
		}

		// especialistaRepository.
		return agendamentos;
	}

	@Override
	public void editar(Agendamento agendamento) {
		System.err.println(agendamento.getIdAgendamento());
		if (agendamento.getIdAgendamento()!= null && agendamento.getCliente()!= null && agendamento.getProcedimento() != null && agendamento.getEspecialista() != null
				&& agendamento.getData() != null && agendamento.getHorario() != null ) {
			agendamentoRepository.save(agendamento);
		} else {
			throw new RuntimeException("Preencha os campos e tente novemente!");
		}
///////////// falta mostrar o nome do cliente e demais informacoes no page
////////////
//////////
	}

	@Override
	public Agendamento getById(String idAgendamento) {
		Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(idAgendamento);
		Agendamento agendamento = null;
		if (agendamentoOptional.isPresent()) {
			agendamento = agendamentoOptional.get();
			String idCliente = agendamento.getCliente().getIdCliente();
			Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
			if (clienteOptional.isPresent()) {
				Cliente clienteCompleto = clienteOptional.get();
				Cliente cliente = new Cliente();
				cliente.setIdCliente(clienteCompleto.getIdCliente());
				cliente.setNome(clienteCompleto.getNome());
				cliente.setPlanoSaude(clienteCompleto.getPlanoSaude());
				agendamento.setCliente(cliente);
			}
			String idEspecialista = agendamento.getEspecialista().getIdEspecialista();
			Optional<Especialista> especialistaOptional = especialistaRepository.findById(idEspecialista);
			if (especialistaOptional.isPresent()) {
				Especialista especialistaCompleto = especialistaOptional.get();
				Especialista especialista = new Especialista();
				especialista.setIdEspecialista(especialistaCompleto.getIdEspecialista());
				especialista.setNomeEspecialista(especialistaCompleto.getNomeEspecialista());
				especialista.setEspecialidade(especialistaCompleto.getEspecialidade());
				agendamento.setEspecialista(especialista);
			}
			String idProcedimento = agendamento.getProcedimento().getIdProcedimento();
			Optional<Procedimento> procedimentoOptional = procedimentoRepository.findById(idProcedimento);
			if (procedimentoOptional.isPresent()) {
				Procedimento procedimentoCompleto = procedimentoOptional.get();
				Procedimento procedimento = new Procedimento();
				procedimento.setIdProcedimento(procedimentoCompleto.getIdProcedimento());
				procedimento.setNomeProcedimento(procedimentoCompleto.getNomeProcedimento());
				procedimento.setDuracaoEmMinutos(procedimentoCompleto.getDuracaoEmMinutos());
				procedimento.setValor(procedimentoCompleto.getValor());
				agendamento.setProcedimento(procedimento);

			}
		}

		return agendamento;
	}

	@Override
	public void apagar(String idAgendamento) {
		Agendamento agendamento = agendamentoRepository.findById(idAgendamento).orElse(null);
		if(agendamento != null) {
			agendamentoRepository.deleteById(idAgendamento);
		} else {
			throw new RuntimeException("Agendamento nao Encontrado");
		}
		
	}
	
	
}
