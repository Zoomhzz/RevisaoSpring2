package com.example.Revisao2.controller;

import com.example.Revisao2.model.FuncionarioModel;
import com.example.Revisao2.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionariosService service;

    @GetMapping
    public List<FuncionarioModel> listar (){
        return service.listartodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FuncionarioModel funcionario){
        service.salvarFuncionario(funcionario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Funcionario já cadastrado"));
    }
}