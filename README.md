# Projeto de Gestão de Cadastros - Revisão Spring Boot

Este repositório contém uma API REST robusta desenvolvida em Java com Spring Boot, focada no gerenciamento de Clientes e Funcionários. O objetivo principal é demonstrar boas práticas de arquitetura, tratamento de erros e persistência de dados.

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência)
* **RestControllerAdvice** (Tratamento global de exceções)
* **Maven** (Gerenciador de dependências)

## 🏗️ Estrutura e Funcionalidades

O projeto segue o padrão de camadas para melhor manutenção e escalabilidade:

### 1. Camada de Serviço (Service)
Contém a lógica de negócio principal. Exemplo de métodos implementados:
* `listartodos()`: Retorna a lista completa de registros do banco de dados.
* `salvar()`: Realiza a persistência de novos dados com **validação de e-mail duplicado**. Se um e-mail já existir, a aplicação impede o cadastro e lança uma exceção.

### 2. Tratamento de Exceções (Global Exception Handler)
Utiliza a anotação `@RestControllerAdvice` para capturar erros em toda a aplicação de forma centralizada.
* **IllegalArgumentException**: Quando ocorre um erro de validação (como e-mail duplicado), o sistema captura a exceção e retorna um status `407 CONFLICT` com uma mensagem amigável em JSON, em vez de um erro genérico do servidor.

## 💻 Exemplo de Código

```java
// Exemplo da lógica de validação no Service
public ClienteModel salvarCliente(ClienteModel cliente) {
    if (repository.findByEmail(cliente.getEmail()).isPresent()) {
        throw new IllegalArgumentException("Cliente já cadastrado.");
    }
    return repository.save(cliente);
}
