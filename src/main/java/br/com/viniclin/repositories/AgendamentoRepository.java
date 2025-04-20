package br.com.viniclin.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viniclin.entities.Agendamento;

@Repository
public interface AgendamentoRepository  extends MongoRepository<Agendamento, String>{

	Optional<Agendamento>  findByCliente_idCliente(String idCliente);

}
