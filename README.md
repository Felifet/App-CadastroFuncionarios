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
