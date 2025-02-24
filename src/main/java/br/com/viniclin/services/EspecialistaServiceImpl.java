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
		List<Especialista> especialistas = especialistaRepository.findAll();
		return especialistas;
	}

	@Override
	public Especialista getById(String idEspecialista) {
		Especialista especialista = especialistaRepository.findById(idEspecialista).orElse(null);
		return especialista;
	}

	@Override
	public void editar(Especialista especialista) {
		if (especialista.getNomeEspecialista() != null && especialista.getTelefone() != null &&
				especialista.getEspecialidade() != null && especialista.getTipoRegistro() != null &&
				especialista.getNumeroRegistro() != null) {
			especialistaRepository.save(especialista);
		} else {
			throw new RuntimeException("Preencha os campos e tente novamente");
		}
		
	}

	@Override
	public void apagar(String idEspecialista) {
		Especialista especialista = especialistaRepository.findById(idEspecialista).orElse(null);
		if (especialista != null) {
			especialistaRepository.deleteById(idEspecialista);
		} else {
			throw new RuntimeException("Especialista nao encontrado!");
		}
		
	}

	@Override
	public List<Especialista> findAllByNomeEspecialista(String nomeEspecialista) {
		List<Especialista> especialistas = especialistaRepository.findAllByNomeEspecialista(nomeEspecialista);
		return especialistas;
	}

}
