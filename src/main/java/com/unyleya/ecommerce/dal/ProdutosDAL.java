package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produtos;

public interface ProdutosDAL {
    Object listarTodosProdutos();

    Object obterProdutoPorCodigo(String codigo);

    Produtos adicionarProduto(Produtos produto);
}
