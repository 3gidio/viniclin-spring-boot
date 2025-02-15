package br.com.viniclin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viniclin.entities.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
