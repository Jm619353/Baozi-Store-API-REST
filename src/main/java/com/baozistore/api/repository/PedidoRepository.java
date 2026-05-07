package com.baozistore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozistore.api.model.Pedido;

/**
 * Mecanismo de acesso a dados para a entidade Pedido.
 * Esta interface abstrai a complexidade do JDBC e SQL, fornecendo uma API 
 * de alto nível para persistência e recuperação de transações de venda.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
