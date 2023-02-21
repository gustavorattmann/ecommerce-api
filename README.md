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
/produtos
```

Para obter um produto específico:
```
/produto/1
```

Para cadastrar um novo produto:
```
/produto/cadastrar
```

Para alterar um produto específico:
```
/produto/alterar/2
```

Para deletar um produto específico:
```
/produto/deletar/2
```

***Observação**: os códigos em todas as rotas são para exemplo.*