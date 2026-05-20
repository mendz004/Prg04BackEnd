# 💰 API de Gestão Financeira

## 📌 Sobre o Projeto
Este projeto é uma API RESTful desenvolvida como parte de um desafio prático de back-end. O objetivo principal é fornecer uma base para um sistema de gestão financeira, permitindo o registro, listagem e exclusão de transações financeiras (receitas e despesas).

O projeto foi construído seguindo o padrão de **Arquitetura em Camadas** (Model, Repository, Service e Controller) para garantir um código limpo, organizado e de fácil manutenção.

## 🚀 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot**
* **Spring Web** (Para criação dos endpoints REST)
* **Spring Data JPA** (Para persistência de dados)
* **Banco de Dados:** MySql*
* **Postman / Insomnia** (Para testes da API)

## 📁 Estrutura do Projeto
O back-end está organizado nos seguintes pacotes:
* `model`: Classes de entidade que representam as tabelas no banco de dados.
* `repository`: Interfaces do Spring Data JPA para comunicação com o banco.
* `service`: Camada contendo as regras de negócio da aplicação.
* `controller`: Camada responsável por expor os endpoints e receber as requisições HTTP.

## 🔗 Endpoints da API

Abaixo estão as rotas disponíveis para a entidade principal (`/transacoes`):

| **POST** | `/transacoes` | Cria uma nova transação financeira. | `201 CREATED` |
