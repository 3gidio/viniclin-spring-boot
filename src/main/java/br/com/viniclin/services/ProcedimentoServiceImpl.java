package br.com.viniclin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Cliente;
import br.com.viniclin.entities.Procedimento;
import br.com.viniclin.repositories.ProcedimentoRepository;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {
	@Autowired
	ProcedimentoRepository procedimentoRepository;

	@Override
	public void cadastrar(Procedimento procedimento) {
		if (procedimento.getNomeProcedimento() != null && procedimento.getNomeProcedimento() != null
				&& procedimento.getValor() != 0) {
			procedimentoRepository.insert(procedimento);
		}
	}

	@Override
	public List<Procedimento> getAll() {
		List<Procedimento> procedimentos = procedimentoRepository.findAll();
		return procedimentos;
	}

	@Override
	public void editar(Procedimento procedimento) {
		if (procedimento.getNomeProcedimento() != null && procedimento.getNomeProcedimento() != null
				&& procedimento.getValor() != 0) {
			procedimentoRepository.save(procedimento);
		} else {
			throw new RuntimeException("Preencha os campos e tente novamente");
		}

	}

	@Override
	public Procedimento getById(String idProcedimento) {
		Procedimento procedimento = procedimentoRepository.findById(idProcedimento).orElse(null);
		return procedimento;
	}

	@Override
	public void apagar(String idProcedimento) {

		Procedimento procedimento = procedimentoRepository.findById(idProcedimento).orElse(null);
		if (procedimento != null) {
			procedimentoRepository.deleteById(idProcedimento);
		} else {
			throw new RuntimeException("Procedimento nao encontrado");
		}
	}
}
