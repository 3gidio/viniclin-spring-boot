package br.com.viniclin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viniclin.entities.Agendamento;

@Repository
public interface AgendamentoRepository  extends MongoRepository<Agendamento, String>{

}
