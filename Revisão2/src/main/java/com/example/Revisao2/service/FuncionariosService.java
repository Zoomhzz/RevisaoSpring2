package com.example.Revisao2.service;

import com.example.Revisao2.model.FuncionarioModel;
import com.example.Revisao2.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository repository;

    public List<FuncionarioModel> listartodos() {
        return repository.findAll();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionario) {
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Funcionario já cadastrado.");
        }
        return repository.save(funcionario);
    }
}