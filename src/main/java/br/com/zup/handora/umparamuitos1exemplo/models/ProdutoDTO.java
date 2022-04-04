package br.com.zup.handora.umparamuitos1exemplo.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoDTO {

    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    public ProdutoDTO(@NotBlank String nome, @NotNull @PositiveOrZero BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Produto toModel() {
        return new Produto(nome, valor);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
