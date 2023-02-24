package com.unyleya.ecommerce.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produtos {
    private Object object;

    @Id
    private String codigo;

    @NotBlank(message = "O nome do produto é obrigatório!")
    @Size(max = 100, message = "Quantidade de dígitos maior do que permitido!")
    @Indexed(unique = true)
    private String nome;

    @NotNull(message = "O preço do produto é obrigatório!")
    @Digits(integer = 100, fraction = 2, message = "Preço inválido!")
    private Double preco;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
