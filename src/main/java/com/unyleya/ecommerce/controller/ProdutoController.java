package com.unyleya.ecommerce.controller;

import com.unyleya.ecommerce.dal.ProdutoRepository;
import com.unyleya.ecommerce.model.Produto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Produto> listarTodosProdutos() {
        System.out.println("Obtendo todos os produtos.");

        return produtoRepository.findAll();
    }
}
