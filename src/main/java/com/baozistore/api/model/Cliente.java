package com.baozistore.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * Representa a entidade Cliente no domínio da aplicação.
 * Mapeia os dados dos consumidores para a tabela correspondente no banco de dados relacional.
 * A anotação @JsonPropertyOrder define o contrato da API, garantindo uma 
 * estrutura lógica e previsível para o consumidor do JSON.
 * */
@JsonPropertyOrder({ "id", "nome", "clienteDesde" })
@Entity
public class Cliente {
	
	/**
     * Identificador único do cliente. 
     * O uso de GenerationType.IDENTITY delega ao banco de dados (MySQL) a responsabilidade 
     * pelo gerenciamento do auto-incremento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nome do consumidor. Mapeado como uma coluna de texto simples.
     */
    private String nome;
    
    /**
     * Armazena a data de registro utilizando a API java.time, 
     * garantindo compatibilidade com os padrões ISO de data.
     */
    private LocalDate clienteDesde;

    /**
     * Construtor padrão exigido pela especificação JPA para instanciar a entidade
     * durante a recuperação de dados via Reflection.
     */
    public Cliente() {}

 // Getters e Setters mantidos para garantir o encapsulamento dos dados
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
    public LocalDate getClienteDesde() {
        return clienteDesde;
    }
    public void setClienteDesde(LocalDate clienteDesde) {
        this.clienteDesde = clienteDesde;
    }
}