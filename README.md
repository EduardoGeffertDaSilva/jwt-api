# Spring Security

Esse projeto tem como objetivo aplicar o conteúdo aprendido na weg da matéria Back-End, colocando em prática os conhecimentos de API Rest, Jpa, Spring Security.

### API REST

* **Arquitetura e Endpoints:** Construção de controladores (`@RestController`) para expor rotas HTTP (GET, POST, PUT, DELETE).
* **Tratamento de Dados:** Utilização de DTOs (Data Transfer Objects) para entrada e saída de dados, garantindo desacoplamento da camada de modelo.
* **Respostas HTTP:** Uso de `ResponseEntity` para gerenciar status HTTP (200 OK, 201 Created, 400 Bad Request, etc.) e padronizar o retorno dos recursos.


### JPA (Java Persistence API)

* **Mapeamento Objeto-Relacional (ORM):** Mapeamento de entidades com anotações Spring Data JPA (`@Entity`, `@Table`, `@Id`, etc.).
* **Persistência e Repositórios:** Criação de interfaces herdando de `JpaRepository` para operações de CRUD e consultas customizadas com JPQL / Derived Queries.
* **Relacionamentos:** Implementação de associações no banco de dados, como `@ManyToOne`, `@OneToMany` e `@ManyToMany`.


### Spring Security
  
* **Autenticação e Autorização:** Configuração de cadeias de filtros (`SecurityFilterChain`) para proteger rotas e gerenciar permissões de acesso por perfis/roles.
* **Integração com JWT:** Implementação de tokens JWT (JSON Web Tokens) para autenticação *stateless*, validando requisições por meio de cabeçalhos HTTP (`Authorization: Bearer <token>`).
* **Criptografia:** Codificação segura de senhas no banco de dados utilizando algoritmos como `BCryptPasswordEncoder`.
