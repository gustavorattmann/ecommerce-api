package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoDALImpl implements ProdutoDAL {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Produto> listarTodosProdutos() {
        return mongoTemplate.findAll(Produto.class);
    }

    @Override
    public Produto obterProdutoPorId(String codigo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(codigo));

        return mongoTemplate.findOne(query, Produto.class);
    }

    @Override
    public Produto adicionarProduto(Produto produto) {
        mongoTemplate.save(produto);

        return produto;
    }
}
