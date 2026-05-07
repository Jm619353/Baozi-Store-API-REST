package com.baozistore.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classe de testes de integração para validação do contexto da aplicação.
 * O objetivo desta suite é garantir que o framework consiga inicializar 
 * todos os beans e dependências corretamente.
 */
@SpringBootTest
class ApiApplicationTests {

	/**
     * Smoke Test.
     * Verifica se o ApplicationContext do Spring Boot é carregado sem erros.
     * Caso haja falhas na configuração do banco de dados ou injeção de 
     * dependências, este teste falhará no bootstrapping da aplicação.
     */
	@Test
	void contextLoads() {
		// Método vazio, pois o sucesso é determinado pelo carregamento do contexto.
	}

}
