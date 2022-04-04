package br.com.zup.handora.umparamuitos1exemplo.models;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class NotaFiscalDTO {

    @NotBlank
    private String numero;

    @NotNull
    @PositiveOrZero
    private BigDecimal total;

    @NotEmpty
    private Set<ItemDTO> itens;

    public NotaFiscalDTO(@NotBlank String numero, @NotNull @PositiveOrZero BigDecimal total,
                         @NotEmpty Set<ItemDTO> itens) {
        this.numero = numero;
        this.total = total;
        this.itens = itens;
    }

    public NotaFiscal toModel() {
        Set<Item> novosItens = itens.stream().map(ItemDTO::toModel).collect(Collectors.toSet());

        return new NotaFiscal(numero, total, novosItens);
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<ItemDTO> getItens() {
        return itens;
    }

}
