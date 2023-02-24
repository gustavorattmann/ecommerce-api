package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutosDALImpl implements ProdutosDAL {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Object listarTodosProdutos() {
        return mongoTemplate.findAll(Produtos.class);
    }

    @Override
    public Object obterProdutoPorCodigo(String codigo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(codigo));

        return mongoTemplate.findOne(query, Produtos.class);
    }

    @Override
    public Produtos adicionarProduto(Produtos produtos) {
        return mongoTemplate.save(produtos);
    }

    @Override
    public Object alterarProduto(Produtos produtos) {
        return mongoTemplate.save(produtos);
    }

    @Override
    public Object deletarProduto(String codigo) {
        Query query = new Query(Criteria.where("id").is(codigo));

        return mongoTemplate.remove(query, Produtos.class);
    }
}
