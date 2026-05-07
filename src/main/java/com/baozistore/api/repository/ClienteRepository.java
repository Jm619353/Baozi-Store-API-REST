package com.baozistore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozistore.api.model.Cliente;

/* 
 * Interface de abstração da camada de dados para a entidade Cliente.
 * Ao estender JpaRepository, o Spring Boot realiza Proxy Dinâmico para implementar
 * em tempo de execução os métodos padrão de manipulação de dados (CRUD).
 * @param <Cliente> A entidade mapeada.
 * @param <Long> O tipo da chave primária (ID).
 * */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
