package com.unyleya.ecommerce.controller;

import com.unyleya.ecommerce.dal.ProdutosRepository;
import com.unyleya.ecommerce.model.Produtos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProdutosController {
    private final ProdutosRepository produtosRepository;

    public ProdutosController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produtos> listarTodosProdutos() {
        System.out.println("Obtendo todos os produtos.");

        return produtosRepository.findAll();
    }
}
