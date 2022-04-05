package br.com.zup.handora.umparamuitos1exemplo.models;

import javax.validation.constraints.NotBlank;

public class TelefoneDTO {

    @NotBlank
    private String tipo;

    @NotBlank
    private String numero;

    public TelefoneDTO(@NotBlank String tipo, @NotBlank String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

}
