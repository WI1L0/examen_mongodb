package com.mongo.mongodb.repository;

import com.mongo.mongodb.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {
}
