package com.example.Revisao2.service;

import com.example.Revisao2.model.ClienteModel;
import com.example.Revisao2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteModel> listartodos() {
        return repository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente) {
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        return repository.save(cliente);
    }
}
