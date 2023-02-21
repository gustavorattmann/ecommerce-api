package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produtos;

import java.util.List;

public interface ProdutosDAL {
    List<Produtos> listarTodosProdutos();

    Produtos obterProdutoPorId(String codigo);

    Produtos adicionarProduto(Produtos produto);
}
