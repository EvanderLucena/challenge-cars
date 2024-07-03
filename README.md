# Car Management System

## Descrição
Este sistema de gerenciamento de carros permite aos usuários criar, atualizar, deletar e visualizar informações detalhadas sobre carros e seus modelos. O projeto utiliza Spring Boot para facilitar o desenvolvimento e manutenção.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Spring com mais facilidade e rapidez.
- **H2 Database**: Banco de dados em memória ideal para desenvolvimento e testes.
- **Java Persistence API (JPA)**: Para gerenciar a persistência dos dados de forma eficiente.
- **Hibernate**: Framework ORM para mapear objetos Java a tabelas de banco de dados.
- **Spring Data JPA**: Simplifica a implementação de repositórios de dados.
- **Swagger**: Documentação automatizada para APIs REST.

## Pré-Requisitos
- Java JDK 17 ou superior
- Maven 3.6 ou superior
- Uma IDE como IntelliJ IDEA ou Eclipse

## Configuração
### Banco de Dados
Configuração do H2 Database:
```properties
spring.datasource.url=jdbc:h2:file:./data/mydatabase;AUTO_SERVER=TRUE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
### Acesso ao H2 Console
Para acessar o banco de dados via browser, navegue até:
http://localhost:8080/h2-console

### Acesso a Documentação das API
Para acessar a documentacão via browser, navegue até:
http://localhost:8080/swagger-ui.html
