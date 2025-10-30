
# Social Media API

Projeto desenvolvido em **Spring Boot** com **MongoDB**, com foco no aprendizado de banco de dados orientado a documentos, operações CRUD e design de entidades aninhadas e referenciadas.

---

## 🎯 Objetivo do Projeto

- Compreender as principais diferenças entre paradigmas **orientado a documentos** e **relacional**.  
- Implementar operações de **CRUD** (Create, Read, Update, Delete).  
- Refletir sobre decisões de design para um banco de dados orientado a documentos.  
- Implementar **associações entre objetos**:
  - Objetos aninhados
  - Referências
- Realizar consultas com **Spring Data** e **MongoRepository**.

---

## 🛠 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3 
- Spring Data MongoDB  
- MongoDB Community Server  
- Maven  
- Git/GitHub

---

## 📋 Funcionalidades

### Usuário (User)

* Listar todos os usuários (GET `/users`)
* Buscar usuário por ID (GET `/users/{id}`)
* Criar usuário (POST `/users`)
* Atualizar usuário (PUT `/users/{id}`)
* Deletar usuário (DELETE `/users/{id}`)
* Retornar posts de um usuário (GET `/users/{id}/posts`)

### Post

* Criar post com autor aninhado (`User`)
* Consultas por título (query methods ou @Query)
* Consultas por múltiplos critérios (texto e intervalo de datas)
* Inserir comentários nos posts

---

## 🧩 DTO (Data Transfer Object)

* Otimiza tráfego de dados
* Evita exposição de informações sensíveis
* Permite customizar dados retornados para cada endpoint

---

## 🔗 Conexão com MongoDB

No `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

* Criar base: `workshop_mongo`
* Criar coleção: `user`
* Inserir alguns documentos manualmente no MongoDB Compass ou via código.

---

## 🔧 Comandos Úteis

* Iniciar MongoDB:

  ```cmd
  mongod
  ```
* Rodar projeto Spring Boot:

  ```bash
  mvn spring-boot:run
  ```
* Testar endpoints:

  * GET `/users`
  * GET `/users/{id}`
  * POST `/users`
  * PUT `/users/{id}`
  * DELETE `/users/{id}`

---

## 📄 Exemplo de Documento User

```json
{
  "id": "1001",
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "posts": [
    {
      "date": "2018-03-21",
      "title": "Partiu viagem",
      "body": "Vou viajar para São Paulo. Abraços!",
      "comments": [
        {
          "text": "Boa viagem mano!",
          "date": "2018-03-21",
          "author": {"id": "1013", "name": "Alex Green"}
        },
        {
          "text": "Aproveite!",
          "date": "2018-03-22",
          "author": {"id": "1027", "name": "Bob Grey"}
        }
      ]
    },
    {
      "date": "2018-03-23",
      "title": "Bom dia",
      "body": "Acordei feliz hoje!",
      "comments": [
        {
          "text": "Tenha um ótimo dia!",
          "date": "2018-03-23",
          "author": {"id": "1013", "name": "Alex Green"}
        }
      ]
    }
  ]
}
```

---
