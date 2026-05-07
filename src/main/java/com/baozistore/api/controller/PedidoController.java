package com.baozistore.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importação necessária
import org.springframework.web.bind.annotation.*;
import com.baozistore.api.model.Pedido;
import com.baozistore.api.model.Cliente;
import com.baozistore.api.model.Produto;
import com.baozistore.api.repository.PedidoRepository;
import com.baozistore.api.repository.ClienteRepository;
import com.baozistore.api.repository.ProdutoRepository;
/*
 * Controlador REST que gerencia as requisições do módulo Pedido.
 * Atua como a camada de Orquestração, validando a entrada e
 * comunicando-se com os repositórios para persistência.
 * */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    /*
     * Registra uma nova transação de pedido.
     * Realiza a busca das entidade Cliente e Produto pelos IDs fornecidos para
     * garantir que o pedido seja vinculado a registros válidos no BD.
     * */
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        Long clienteId = pedido.getCliente().getId();
        Long produtoId = pedido.getProduto().getId();

        // Recupera as instâncias completas das entidades relacionadas
        Cliente clienteCompleto = clienteRepository.findById(clienteId).orElse(null);
        Produto produtoCompleto = produtoRepository.findById(produtoId).orElse(null);

        pedido.setCliente(clienteCompleto);
        pedido.setProduto(produtoCompleto);

        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(pedido -> ResponseEntity.ok(pedido))
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Atualiza as informações de um pedido, permitindo a retribuição de Clientes ou Produtos.
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setQuantidade(pedidoAtualizado.getQuantidade());

                    // Lógica de validação para novos vínculos de entidades
                    if (pedidoAtualizado.getCliente() != null) {
                        Cliente c = clienteRepository.findById(pedidoAtualizado.getCliente().getId()).orElse(null);
                        pedidoExistente.setCliente(c);
                    }
                    if (pedidoAtualizado.getProduto() != null) {
                        Produto p = produtoRepository.findById(pedidoAtualizado.getProduto().getId()).orElse(null);
                        pedidoExistente.setProduto(p);
                    }

                    Pedido salvo = pedidoRepository.save(pedidoExistente);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}