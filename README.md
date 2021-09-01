# Spring Boot Microservices

## Sobre o Projeto

Projeto desenvolvido para criaçāo de uma estrutura de microserviços utilizando as stacks do Spring Cloud (API Gateway, Config Service, Discovery Service Eureka, Open Feign).
A ideia é permitir a construçāo de uma API de microserviços descomplicada onde o registro dos microserviços e instâncias fiquem no Eureka, a porta de entrar de todos os microserviços fiquem centralizados na API Gateway, as configurações fique no Config Service e a comunicaçāo entre os microserviços utilize o Open Feign.

# Spring Boot Microservices

![](https://img.shields.io/badge/build-success-brightgreen.svg)

# Stack

![](https://img.shields.io/badge/java_11-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/spring_cloud-%E2%9C%93-blue.svg)
![](https://img.shields.io/badge/swagger2-✓-blue.svg)

## Início

### Pré-requisitos

* `Java 11 ou superior`
* `Maven`
* `Postman ou outro API Client para chamadas HTTP`
* `$JAVA_HOME e $M2_HOME configurados`

### Instalação

1. Clonar o repositório
   ```sh
   git clone https://github.com/edubiss/spring-boot-microservices.git
   ```
2. Navegar para o diretório
   ```sh
   cd spring-boot-microservices
   ```
3. Navegar para os diretórios dos projetos
   ```sh
   cd config-service | cd discovery-service | cd gateway-service | cd equipe-service | cd confronto-service
   ```
3. Instale as dependências (em cada um dos projetos)
   ```sh
   mvn install
   ```
4. Rodar o projeto (em cada um dos projetos verificando os pré-requisitos)
   ```sh
   mvn spring-boot:run
   ```
5. Verificar se os serviços foram registrados no Eureka
   ```sh
   http://localhost:8061
   ```

## Uso


### Rotas

Consulta equipes
```
$ curl -X GET http://localhost:8060/equipe/
```

Consulta de Equipes por ID
```
$ curl -X GET http://localhost:8060/equipe/{id}
```

Inclusão de Equipes
```
$ curl -X POST http://localhost:8060/equipe/
```
```javascript
{
  "nome": "Flamengo",
  "logo": "flamengo.jpg"
}
```

Consulta confrontos
```
$ curl -X GET http://localhost:8060/confronto/
```

Consulta de Confrontos por ID
```
$ curl -X GET http://localhost:8060/confronto/{id}
```

Inclusão de Confrontos
```
$ curl -X POST http://localhost:8060/confronto/
```
```javascript
{
    "local": "Maracana",
    "equipeMandante": 1,
    "equipeVisitante": 2
}
```