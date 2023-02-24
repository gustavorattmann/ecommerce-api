package com.unyleya.ecommerce.controller;

import com.unyleya.ecommerce.dal.ProdutosRepository;
import com.unyleya.ecommerce.model.Produtos;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
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
    public ResponseEntity<String> adicionarProduto(@Valid @RequestBody Produtos produtos) {
        System.out.println("Cadastro de produto.");

        Produtos criarProduto = produtosRepository.save(produtos);

        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @RequestMapping(value = "/produto/alterar/{codigo}", method = RequestMethod.PATCH)
    public Object alterarProduto(@PathVariable(value = "codigo") String codigo, @RequestBody Produtos produtos) {
        System.out.println("Alteração de produto.");

        System.out.println(produtos);

        Optional<Produtos> buscarProduto = produtosRepository.findById(codigo);

        if (buscarProduto.isEmpty()) {
            return "Produto não encontrado!";
        }

        Produtos alterarProduto = produtosRepository.save(produtos);

        return ResponseEntity.ok("Produto alterado com sucesso!");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
