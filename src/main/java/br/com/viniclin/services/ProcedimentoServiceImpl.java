package br.com.viniclin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Procedimento;
import br.com.viniclin.repositories.ProcedimentoRepository;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {
	@Autowired
	ProcedimentoRepository procedimentoRepository;
	
	@Override
	public void cadastrar (Procedimento procedimento) {
		if (procedimento.getNomeProcedimento() != null && procedimento.getNomeProcedimento() != null
				&& procedimento.getValor() != 0 ) {
			procedimentoRepository.insert(procedimento);
		}
			
	}

}
