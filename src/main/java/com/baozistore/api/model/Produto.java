package com.baozistore.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Representa os itens do catálogo da loja.
 * A anotação @JsonPropertyOrder define o contrato da API, garantindo uma 
 * estrutura lógica e previsível para o consumidor do JSON.
 */
@JsonPropertyOrder({ "id", "nome", "preco", "estoque" })
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    /**
     * Utiliza BigDecimal para assegurar a precisão decimal necessária em cálculos 
     * monetários, evitando erros de arredondamento comuns em tipos de ponto flutuante.
     */
    private BigDecimal preco;
    
    /**
     * Representa o status de disponibilidade do item no inventário.
     */
    private Boolean estoque;
    
    public Produto() {}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Boolean getEstoque() {
		return estoque;
	}
	public void setEstoque(Boolean estoque) {
		this.estoque = estoque;
	}
    
    
}