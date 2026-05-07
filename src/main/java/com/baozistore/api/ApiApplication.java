package com.baozistore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*A classe principal que inicia todo o ecossistema Spring Boot.
 * A anotação @SpringBootApplication habilita a auto-configuração,
 * a varredura de componentes (Component Scan) e as definições de 
 * configuração.
 * */
@SpringBootApplication
public class ApiApplication {

	/*
	 * Método Principal que delega a execução para a classe ApiApplication,
	 * disparando o processo de inicialização do contexto da aplicação e do
	 * servidor web embarcado (Tomcat)*/
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
