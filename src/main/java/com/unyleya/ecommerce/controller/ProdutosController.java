package com.unyleya.ecommerce.controller;

import com.unyleya.ecommerce.dal.ProdutosRepository;
import com.unyleya.ecommerce.model.Produtos;
import org.springframework.web.bind.annotation.*;

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

    /*@RequestMapping(value = "/produto/{codigo}", method = RequestMethod.GET)
    public Produtos obterProdutoPorId(@PathVariable Integer codigo) {
        System.out.println("Obter produto específico: " + codigo);

        return codigo;
    }*/

    @RequestMapping(value = "/produto/cadastrar", method = RequestMethod.POST)
    public Produtos adicionarProduto(@RequestBody Produtos produtos) {
        System.out.println("Cadastro de produto.");

        return produtos;

        // return produtosRepository.save(produtos);
    }
}
