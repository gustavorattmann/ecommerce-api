# API de e-commerce de produtos

## Executando a API
Esse projeto é responsável por criar a API para disponibilizar os produtos de um e-commerce fictício em um objeto JSON.

Para iniciar o projeto, basta rodar o comando:
```java
mvn spring-boot:run
```

## Rotas
Para obter todos os produtos:
```
/api/produtos
```

Para obter um produto específico:
```
/api/produto/63f6f2a4093d752d2dae4f2f
```

Para cadastrar um novo produto:
```
/api/produto/cadastrar
```

Para alterar um produto específico:
```
/api/produto/alterar/63f6f2a4093d752d2dae4f2f
```

Para deletar um produto específico:
```
/api/produto/deletar/63f6f2a4093d752d2dae4f2f
```

***Observação**: os códigos em todas as rotas são para exemplo.*