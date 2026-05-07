package com.baozistore.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importação necessária
import org.springframework.web.bind.annotation.*;
import com.baozistore.api.model.Cliente;
import com.baozistore.api.repository.ClienteRepository;

/*
 * Recurso REST para gestão de clientes.
 * Define os endpoints para manipulação da entidade Cliente no ecossistema da API.
 * */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	/*Injeção de dependências do repositório de clientes para operações de persistência.
	 * */
    @Autowired
    private ClienteRepository repository;

    /*
     * Persiste um novo cliente no BD.
     * @param cliente Objeto desserializado a partir do JSON enviado no corpo da requisição (@RequestBody).
     * */
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    /*
     * Recupera a listagem completa de clientes cadastrados.
     * */
    @GetMapping
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    /*
     * Busca um cliente específico através de seu identificado único.
     * @param id Valor capturado diretamente do path da URL (@PathVariable).
     * @return ResponseEntity contendo o status 200 (OK) e o objeto, ou 404 (Not Found).
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Atualiza os dados de um cliente existente com base no ID fornecido.
     * Implementa a lógica de busca prévia para garantir a existência do registro antes da alteração.
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return repository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteAtualizado.getNome());
                    clienteExistente.setClienteDesde(clienteAtualizado.getClienteDesde());
                    Cliente salvo = repository.save(clienteExistente);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Remove o registro de um cliente do BD.
     * */
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id); 
    }
}