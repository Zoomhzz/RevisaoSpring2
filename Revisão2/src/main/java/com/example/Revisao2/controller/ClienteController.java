    package com.example.Revisao2.controller;

    import com.example.Revisao2.model.ClienteModel;
    import com.example.Revisao2.service.ClienteService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;

    @RestController
    @RequestMapping("/clientes")
    public class ClienteController {
        @Autowired
        private ClienteService service;

        @GetMapping
        public List<ClienteModel> listar (){
            return service.listartodos();
        }

        @PostMapping
        public ResponseEntity<Map<String, String>> salvar(@RequestBody ClienteModel cliente){
            service.salvarCliente(cliente);

                 return ResponseEntity
                     .status(HttpStatus.CREATED)
                     .body(Map.of("Mensagem","Cliente já cadastrado"));
        }
    }
