# Electronics-Story

# API de Produtos Eletrônicos

## Descrição

Esta é uma API desenvolvida com **Java** e **Spring Boot** para gerenciar produtos eletrônicos. A API permite realizar operações CRUD (Criar, Ler, Atualizar e Deletar) de produtos, onde cada produto possui um nome e um preço.

A aplicação utiliza **PostgreSQL** como banco de dados, **JPA** para a persistência de dados e **Flyway** para migrações de banco de dados. Ela está encapsulada em um container **Docker** para facilitar a execução em qualquer ambiente.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **JPA (Hibernate)**
- **PostgreSQL**
- **Flyway**
- **Docker**

## Funcionalidades

A API possui as seguintes funcionalidades:

- **Cadastrar Produto**: Permite adicionar um novo produto eletrônico.
- **Listar Produtos**: Exibe todos os produtos cadastrados.
- **Atualizar Produto**: Permite atualizar o nome ou o preço de um produto existente.
- **Deletar Produto**: Remove um produto da base de dados.

## Endpoints

- **GET /products**: Retorna todos os produtos eletrônicos.
- **POST /products**: Cria um novo produto eletrônico.
- **PUT /products/{id}**: Atualiza um produto existente pelo seu ID.
- **DELETE /products/{id}**: Deleta um produto eletrônico pelo seu ID.

## Autenticação e Autorização

A API utiliza **Spring Security** juntamente com **JSON Web Tokens (JWT)** para autenticação e autorização dos usuários. A autenticação leva em consideração o papel (role) do usuário, como **ROLE_ADMIN**.

### Endpoints de Autenticação

#### 1. **Login**
Este endpoint permite ao usuário se autenticar e obter um **JWT**. O login exige apenas o **username** e **password**.

- **URL**: `/auth/login`
- **Método**: `POST`
- **Corpo da requisição**:
   ```json
   {
     "username": "usuário",
     "password": "senha"
   }

Se as credenciais forem válidas, a resposta será um token JWT:

    {
        "token": "token_jwt_aqui"
    }

Após obter o token, o usuário pode usá-lo para acessar os endpoints protegidos da API.
2. Register

Este endpoint permite registrar um novo usuário na aplicação. É necessário fornecer o username, password e o role (por exemplo, ROLE_USER ou ROLE_ADMIN).

- **URL**: '/auth/register'

- **Método**: 'POST'


- **Corpo da requisição**:

      {
        "username": "novo_usuario",
        "password": "nova_senha",
        "role": "ROLE_ADMIN"
      }

  Ao registrar o usuário, ele será inserido no banco de dados com o role especificado. O role pode ser ROLE_USER, ROLE_ADMIN ou outro que você tenha configurado.

Acesso a Recursos Protegidos

Para acessar os endpoints protegidos da API, o token JWT deve ser incluído no cabeçalho de autorização da requisição.

- **Cabeçalho da requisição**:



        Authorization: Bearer {token_jwt_aqui}
     


Caso o token seja válido e o usuário tenha as permissões necessárias (com base em sua role), o acesso será liberado. Caso contrário, será retornado um erro 403 (Forbidden) ou 401 (Unauthorized).

Endpoints Protegidos

    GET /products: Exemplo de endpoint protegido que requer autenticação. Apenas usuários com role adequado (como ROLE_ADMIN) terão permissão para acessá-lo.

Como Adicionar Usuários e Roles

A base de dados deve conter as credenciais dos usuários com seus respectivos papéis (como ROLE_USER, ROLE_ADMIN), que são utilizados para autorizar ou restringir o acesso aos recursos da API.

O papel do usuário pode ser configurado durante o registro, e a autenticação levará em conta esse papel ao verificar se ele tem permissão para acessar determinados endpoints.


**Como Rodar a Aplicação**
1. Clone o repositório

        git clone https://github.com/seu-usuario/produtos-eletronicos-api.git
        cd produtos-eletronicos-api

2. **Configuração do Banco de Dados**

Se você estiver usando o Docker, pode rodar o PostgreSQL com o seguinte comando:

    docker-compose up -d

O Flyway fará a migração automática das tabelas no banco de dados PostgreSQL.
3. **Rodando a aplicação**

Com o banco configurado, você pode rodar a aplicação com o comando Maven:

    ./mvnw spring-boot:run

A aplicação estará rodando em http://localhost:8080.
4. Testando a API

Você pode usar o Postman ou Insomnia para fazer requisições HTTP para testar os endpoints da API. Exemplo de endpoint para listar os produtos:

    GET http://localhost:8080/products

Docker

Caso queira rodar a aplicação diretamente via Docker, use o comando:

    docker build -t produtos-eletronicos-api .
    docker run -p 8080:8080 produtos-eletronicos-api

A aplicação estará acessível em http://localhost:8080.
Dependências para Autenticação JWT

Adicione as seguintes dependências ao pom.xml para usar o Spring Security e JWT:

    <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-security</artifactId>
     </dependency>
    <dependency>
     <groupId>io.jsonwebtoken</groupId>
     <artifactId>jjwt</artifactId>
     <version>0.11.5</version>
    </dependency>

Contribuindo

- Faça o fork deste repositório.
- Crie uma branch para sua feature (git checkout -b feature/nome-da-feature).
- Faça commit das suas alterações (git commit -am 'Add nova feature').
- Envie para a branch do repositório (git push origin feature/nome-da-feature).
- Abra um Pull Request.


