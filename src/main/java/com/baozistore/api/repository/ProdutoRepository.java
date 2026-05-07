package com.baozistore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozistore.api.model.Produto;

/**
 * Interface responsável pela comunicação entre a aplicação e a tabela de produtos.
 * Permite a execução de consultas e operações de escrita sem a necessidade 
 * de codificação de Boilerplate Code (código repetitivo).
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
