package com.unyleya.ecommerce.controller;

import com.unyleya.ecommerce.dal.ProdutosRepository;
import com.unyleya.ecommerce.model.Produtos;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/")
public class ProdutosController {
    private final ProdutosRepository produtosRepository;

    public ProdutosController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public Object listarTodosProdutos() {
        System.out.println("Obtendo todos os produtos.");

        List<Produtos> produtos = produtosRepository.findAll();

        if (produtos.isEmpty()) {
            return "Nenhum produto encontrado!";
        }

        return produtos;
    }

    @RequestMapping(value = "/produto/{codigo}", method = RequestMethod.GET)
    public Object obterProdutoPorCodigo(@PathVariable(value = "codigo") String codigo) {
        System.out.println("Obter produto específico: " + codigo);

        Optional<Produtos> produtos = produtosRepository.findById(codigo);

        if (produtos.isEmpty()) {
            return "Produto não encontrado!";
        }

        return produtos;
    }

    @RequestMapping(value = "/produto/cadastrar", method = RequestMethod.POST)
    public Produtos adicionarProduto(@RequestBody Produtos produtos) {
        System.out.println("Cadastro de produto.");

        return produtos;

        // return produtosRepository.save(produtos);
    }
}
