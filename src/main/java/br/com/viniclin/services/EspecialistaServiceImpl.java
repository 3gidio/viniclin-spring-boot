package br.com.viniclin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniclin.entities.Especialista;
import br.com.viniclin.repositories.EspecialistaRepository;

@Service
public class EspecialistaServiceImpl implements EspecialistaService {
	@Autowired
	EspecialistaRepository especialistaRepository;
	
	@Override
	public void cadastrar (Especialista especialista) {
		if (especialista.getNomeEspecialista() != null && especialista.getEspecialidade() != null
				&& especialista.getNumeroRegistro() != null && especialista.getTipoRegistro() != null
				&& especialista.getTelefone() != null ) {
			especialistaRepository.insert(especialista);
		}
	}

	@Override
	public List<Especialista> getAll() {
	
		return null;
	}

	@Override
	public Especialista getById(String idEspecialista) {
		
		return null;
	}

	@Override
	public void editar(Especialista especialista) {
		
		
	}

}
