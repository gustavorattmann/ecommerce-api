package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends MongoRepository<Produtos, String> {
}
