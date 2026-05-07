package com.baozistore.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.baozistore.api.model.Produto;
import com.baozistore.api.repository.ProdutoRepository;

/*
 * Controlador responsável pelas operações de catálogo de produtos.
 * */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    /*
     * Utiliza Method Reference (ResponseEntity::ok) para uma sintaxe mais concisa e funcional.
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return repository.findById(id)
                .map(produtoExistente -> {
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    produtoExistente.setEstoque(produtoAtualizado.getEstoque());
                    Produto salvo = repository.save(produtoExistente);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /*
     * Executa a remoção lógica/física do produto.
     * Retornando o status 204 (No Content) após a exclusão bem-sucedida, conforme padrões RESTful.
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}