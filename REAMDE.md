<div align="center">

![](https://img.shields.io/badge/Status-Concluído-brightgreen)
</div>

<div align="center">

# POC Spring-Boot-Kotlin
![](https://img.shields.io/badge/Autor-Ronnie%20Mikihiro%20Sato%20Lopes-brightgreen)
![](https://img.shields.io/badge/Language-kotlin-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)
</div>

## Fundamentos teóricos

> Kotlin é uma linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011, que compila para a Máquina virtual Java e que também pode ser traduzida para a linguagem JavaScript e compilada para código nativo.

##  Pré -requisitos

- [ `Java 17+` ](https://www.oracle.com/java/technologies/downloads/#java17)
- [ `Spring-Boot-2.7.2+` ](https://start.spring.io/)
- [ `Flyway` ](https://flywaydb.org/)

## Stack
- **Sonar** Analise de qualidade e cobertura de testes
- **Redis** Armazenamento de estrutura de dados em memória

## Portas
| Aplicação          | Porta |
|--------------------|-------|
| Redis              | 6379  |


## Links

- OpenAPI
    - Swagger
        - http://localhost:8080/swagger-ui/index.html
    - API Docs
        - http://localhost:8080/v3/api-docs

## Setup

- ### Executando a aplicação com maven
- Execute o seguinte comando:
  ```
  ./mvnw clean spring-boot:run
  ```

- ### Executar docker-compose para subir a aplicação com container docker
- Execute o seguinte comando para subir os containers:
  ```
  docker-compose up
  ```
- Execute o seguinte comando para verificar os status do containers docker:
  ```
  docker-compose ps
  ```

## TODO List

- [x] Qualidade de código
    - [x] SonarLint
