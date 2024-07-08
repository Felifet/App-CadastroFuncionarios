# App-CadastroFuncionarios
 
## Cadastro de Funcionários e Diárias

Este projeto é uma aplicação Java Spring desenvolvido como trabalho final para as disciplinas de "Frameworks para Desenvolvimento de Software" e "Programação com Padrões de Projeto". O objetivo é gerenciar o cadastro de funcionários e o registro de diárias. Utilizando as tecnologias Spring JPA, Spring Web e Spring Security, a aplicação permite a criação, leitura, atualização e exclusão de dados de funcionários, além de possibilitar o registro detalhado de diárias trabalhadas.

### Funcionalidades

- **Cadastro de Funcionários:** Permite adicionar, visualizar, editar e remover funcionários.
- **Registro de Diárias:** Funcionalidade para registrar e consultar as diárias trabalhadas por cada funcionário.
- **Autenticação e Autorização:** Utilização do Spring Security para gerenciar o acesso à aplicação, com diferentes níveis de permissão (ADMIN e USUARIO).

### Estrutura do Projeto

- **config:** Configurações de segurança e outras configurações gerais.
- **controller:** Controladores responsáveis por receber as requisições HTTP e retornar as respostas apropriadas.
- **service:** Contém a lógica de negócios, dividido em subdiretórios para entidade e repositório.
- **entity:** Entidades JPA que representam as tabelas do banco de dados.
- **repository:** Interfaces que estendem JpaRepository para acesso aos dados.

### Tecnologias Utilizadas

- **Spring Boot**
- **Spring JPA**
- **Spring Web**
- **Spring Security**
- **Jakarta Persistence API (JPA)**
### Padrões de Projeto Utilizados

---

Este projeto utiliza vários padrões de projeto para garantir um código limpo, manutenível e escalável. Abaixo estão os principais padrões aplicados:

#### Padrão MVC (Model-View-Controller)

O padrão MVC é utilizado para separar a lógica de negócio, a lógica de apresentação e a lógica de controle. 

- **Model:** Representa os dados da aplicação e a lógica de negócios, encapsulados nas entidades JPA.
- **View:** Não aplicável diretamente, mas o Spring Boot facilita a criação de APIs RESTful que podem ser consumidas por diferentes tipos de clientes.
- **Controller:** Classes responsáveis por receber as requisições HTTP, processá-las e retornar as respostas apropriadas.

#### Padrão DAO (Data Access Object)

O padrão DAO é aplicado através dos repositórios JPA. Ele abstrai e encapsula o acesso aos dados, fornecendo uma interface para realizar operações de banco de dados.

- **Repository:** Interfaces que estendem `JpaRepository`, fornecendo métodos prontos para operações CRUD e permitindo a definição de consultas personalizadas.

#### Padrão Service

O padrão Service é utilizado para encapsular a lógica de negócios, separando-a da camada de controle e da camada de acesso a dados.

- **Service:** Classes que contêm métodos de negócio, coordenando operações entre repositórios e controladores.

#### Padrão Singleton

O padrão Singleton é aplicado na configuração de segurança e em outras configurações gerais do Spring, garantindo que apenas uma instância da configuração seja criada.

- **Config:** Classes de configuração do Spring, anotadas com `@Configuration`, são geridas como singletons pelo contêiner de injeção de dependências do Spring.
