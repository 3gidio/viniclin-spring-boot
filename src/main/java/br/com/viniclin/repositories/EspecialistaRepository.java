package br.com.viniclin.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viniclin.entities.Especialista;

@Repository
public interface EspecialistaRepository extends MongoRepository<Especialista, String> {

	List<Especialista> findAllByNomeEspecialista(String nomeEspecialista);

}
