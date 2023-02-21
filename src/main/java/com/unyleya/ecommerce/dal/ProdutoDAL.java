package com.unyleya.ecommerce.dal;

import com.unyleya.ecommerce.model.Produto;

import java.util.List;

public interface ProdutoDAL {
    List<Produto> listarTodosProdutos();

    Produto obterProdutoPorId(String codigo);

    Produto adicionarProduto(Produto produto);
}
