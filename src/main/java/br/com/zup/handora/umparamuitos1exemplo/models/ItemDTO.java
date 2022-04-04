package br.com.zup.handora.umparamuitos1exemplo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemDTO {

    @NotNull
    @Positive
    private Long produtoId;

    @NotNull
    @Positive
    private Integer quantidade;

    public ItemDTO(@NotNull @Positive Long produtoId, @NotNull @Positive Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Item toModel() {
        return new Item(new Produto(produtoId), quantidade);
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
