package com.baozistore.api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entidade de transação que consolida o vínculo entre Cliente e Produto.
 * A anotação @JsonPropertyOrder define o contrato da API, garantindo uma 
 * estrutura lógica e previsível para o consumidor do JSON.
 */
@JsonPropertyOrder({ "id", "cliente", "produto", "quantidade" })
@Entity
public class Pedido {
	/*
	 * Chave Primária da tabela. Og GenerationType.IDENTITY garante
	 * que o ID seja gerado pelo auto-incremento do MySQL.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Relacionamento N:1 com Cliente.
     * Define a obrigatoriedade de um vínculo associativo para a existência do pedido.
     * @JoinColumn especifica a coluna de Chave Estrangeira (FK) no esquema físico.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /**
     * Relacionamento N:1 com Produto.
     * Estabelece a dependência de integridade referencial com o catálogo.
     */
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    /**
     * Define o volume de itens adquiridos na transação.
     */
    private Integer quantidade;

    public Pedido() {}

 // Getters e Setters para manipulação via Controller/Repository
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}