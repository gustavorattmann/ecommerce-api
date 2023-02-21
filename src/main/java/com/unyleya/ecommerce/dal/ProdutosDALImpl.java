package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProdutosDALImpl implements ProdutosDAL {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Produtos> listarTodosProdutos() {
        return mongoTemplate.findAll(Produtos.class);
    }

    @Override
    public Produtos obterProdutoPorCodigo(Integer codigo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(codigo));

        return mongoTemplate.findOne(query, Produtos.class);
    }

    @Override
    public Produtos adicionarProduto(Produtos produto) {
        mongoTemplate.save(produto);

        return produto;
    }
}
