# 🥟 Baozi Store API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0-brightgreen?style=for-the-badge&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A22?style=for-the-badge&logo=apache-maven&logoColor=white)

A **Baozi Store API** é um sistema de back-end robusto para gerenciamento de um e-commerce. Construída com Java 21 e Spring Boot, a aplicação fornece endpoints RESTful para o gerenciamento completo de **Clientes**, **Produtos** e **Pedidos**, garantindo integridade de dados e facilidade de integração com interfaces Front-end ou aplicativos Mobile.

O projeto foi desenvolvido com foco em **Código Limpo (Clean Code)**, **Arquitetura em Camadas** e boas práticas de modelagem de dados relacional (ORM).

---

## 🏗️ Arquitetura do Projeto

A aplicação segue uma arquitetura em camadas bem definida para garantir a separação de responsabilidades e escalabilidade:

*   **`controller`**: Gerencia as requisições HTTP, mapeia os endpoints (URIs) e delega as regras de negócio, retornando os status codes (HTTP 200, 201, etc.) adequados.
*   **`model`**: Contém as entidades de domínio (Cliente, Produto, Pedido) mapeadas via JPA/Hibernate para o banco de dados. Utiliza boas práticas como `@JsonPropertyOrder` para previsibilidade do JSON e o pacote `java.time` para o tratamento seguro de datas.
*   **`repository`**: Interfaces que estendem o Spring Data JPA para comunicação simplificada e eficiente com o banco de dados MySQL, sem a necessidade de queries repetitivas (Boilerplate).

---

## 🚀 Tecnologias Utilizadas

*   **Java 21**: Linguagem de programação (versão LTS mais recente).
*   **Spring Boot**: Framework principal para criação da API REST.
*   **Spring Data JPA / Hibernate**: Para o mapeamento objeto-relacional (ORM) e persistência de dados.
*   **MySQL**: Banco de dados relacional em produção/desenvolvimento.
*   **Lombok**: Automação de getters, setters e construtores, reduzindo a verbosidade do código.
*   **Maven**: Gerenciador de dependências e build do projeto.

---

## ⚙️ Como executar o Projeto

### Pré-requisitos
*   [JDK 21](https://jdk.java.net/java-se-ri/21) Java 21 instalado (JAVA_HOME Configurado).
*   [MySQL Workbench](https://www.mysql.com/downloads/) Servidor MySQL rodando localmente ou em um container.

### 1. Clone o repositório:
```bash
git clone https://github.com/Jm619353/baozistore-api.git
```

### 2. Entre na pasta do projeto:
```bash
cd baozistore-api
```

### 3. Configure o banco de dados no arquivo src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/baozidb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true
spring.datasource.username=SEU_USUARIO_MYSQL
spring.datasource.password=SUA_SENHA_MYSQL
spring.jpa.hibernate.ddl-auto=update
```

### 4. Execute a aplicação usando o Maven Wrapper (não é necessário ter o Maven instalado globalmente):
```bash
./mvnw spring-boot:run
```

### 5. A API estará disponível em http://localhost:8080 .

---
## 📡 Endpoints da API

A API segue os padrões RESTful. Abaixo estão os principais módulos implementados:

### 👤 Clientes (`/clientes`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/clientes` | Lista todos os clientes cadastrados. |
| `GET` | `/clientes/{id}` | Busca um cliente específico pelo ID. |
| `POST` | `/clientes` | Cadastra um novo cliente. |
| `PUT` | `/clientes/{id}` | Atualiza os dados de um cliente existente. |
| `DELETE`| `/clientes/{id}` | Remove um cliente do sistema. |

### 📦 Produtos (`/produtos`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/produtos` | Lista todos os produtos no estoque. |
| `GET` | `/produtos/{id}` | Retorna detalhes de um produto. |
| `POST` | `/produtos` | Cadastra um novo produto (ex: *Baozi de Carne Especial*). |
| `PUT` | `/produtos/{id}` | Atualiza informações e preços de um produto. |
| `DELETE`| `/produtos/{id}` | Remove um produto do catálogo. |

### 🛒 Pedidos (`/pedidos`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/pedidos` | Lista o histórico completo de pedidos. |
| `GET` | `/pedidos/{id}` | Consulta um pedido específico. |
| `POST` | `/pedidos` | Registra uma nova venda, associando Cliente e Produto. |
| `PUT` | `/pedidos/{id}` | Atualiza o status/quantidade de um pedido. |
| `DELETE`| `/pedidos/{id}` | Cancela e remove um pedido. |

---

## 💻 Exemplos de Uso (JSON)

### 1. Criando um Cliente
**Requisição `POST /clientes`**
```json
{
  "nome": "João Miguel",
  "clienteDesde": "2024-05-05"
}
```

**Resposta**(```200 OK```)
```json
{
  "id": 1,
  "nome": "João Miguel",
  "clienteDesde": "2024-05-05"
}
```

### 2. Criando um Produto
**Requisição `POST /produtos`**
```json
{
  "nome": "Baozi de Carne Especial",
  "preco": 16.00,
  "estoque": true
}
```

**Resposta**(```200 OK```)
```json
{
  "id": 1,
  "nome": "Baozi de Carne Especial",
  "preco": 16.00,
  "estoque": true
}
```
### 3. Criando um Pedido
**Requisição `POST /pedidos`**
```json
{
  "cliente": {
    "id": 1
  },
  "produto": {
    "id": 1
  },
  "quantidade": 7
}
```

**Resposta**(```200 OK```)
```json
{
  "id": 1,
  "cliente": {
    "id": 1,
    "nome": "João Miguel",
    "clienteDesde": "2024-05-05"
  },
  "produto": {
    "id": 1,
    "nome": "Baozi de Carne Especial",
    "preco": 16.00,
    "estoque": true
  },
  "quantidade": 7
}
```


## 🛣️ Roadmap e Próximos Passos

- [x] Modelagem das entidades centrais (Cliente, Produto).
- [ ] Implementar Spring Security com autenticação JWT.
- [ ] Containerização da aplicação usando **Docker**.
- [ ] Implementação de testes unitários (JUnit e Mockito) e testes de integração.
- [ ] Implementação de camada de Serviço (Service) para isolar ainda mais as regras de negócio complexas.
- [ ] Tratamento global de exceções (@ControllerAdvice) para padronizar os erros da API.
- [ ] Validação de dados (Spring Boot Validation) no payload de entrada (Ex: @NotBlank, @Min).
- [ ] Documentação automatizada no formato OpenAPI (Swagger/OpenAPI 3).
- [ ] Configuração de pipeline CI/CD (GitHub Actions).
- [ ] Padronizar os HTTP Status Codes da API (ex: retornar 201 Created nos métodos POST e 204 No Content nos métodos DELETE).

## 🤝 Como Contribuir

Contribuições fazem com que a comunidade open source seja um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/FeatureIncrivel`)
3. Faça o Commit de suas mudanças (`git commit -m 'Adicionando uma Feature Incrível'`)
4. Faça o Push para a Branch (`git push origin feature/FeatureIncrivel`)
5. Abra um Pull Request

---
⌨️ Desenvolvido com dedicação por [Jm619353](https://github.com/Jm619353)
