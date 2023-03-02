package com.mongo.mongodb.service;

import com.mongo.mongodb.model.Cliente;
import com.mongo.mongodb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    ClienteRepository Repository;

    @Override
    public CrudRepository<Cliente, Long> getDao() {
        return Repository;
    }
}
