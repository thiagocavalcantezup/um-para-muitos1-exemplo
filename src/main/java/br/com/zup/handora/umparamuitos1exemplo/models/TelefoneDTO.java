package br.com.zup.handora.umparamuitos1exemplo.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TelefoneDTO {

    @NotBlank
    private String tipo;

    @NotBlank
    @Pattern(regexp = "^\\+[1-9][0-9]{2,15}$")
    private String numero;

    public TelefoneDTO(@NotBlank String tipo, @NotBlank String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public Telefone toModel() {
        return new Telefone(tipo, numero);
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

}
