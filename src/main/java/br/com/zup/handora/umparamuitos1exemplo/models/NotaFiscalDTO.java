package br.com.zup.handora.umparamuitos1exemplo.models;

import java.math.BigDecimal;
import java.util.Set;

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
