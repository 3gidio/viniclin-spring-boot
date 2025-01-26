package br.com.viniclin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viniclin.entities.Procedimento;

@Repository
public interface ProcedimentoRepository extends MongoRepository<Procedimento, String>{

}
