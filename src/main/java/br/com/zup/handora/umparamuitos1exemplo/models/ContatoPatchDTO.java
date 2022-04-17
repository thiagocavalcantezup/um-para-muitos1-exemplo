package br.com.zup.handora.umparamuitos1exemplo.models;

import javax.validation.constraints.NotBlank;

public class ContatoPatchDTO {

    @NotBlank
    private String nome;

    private String empresa;

    public ContatoPatchDTO(@NotBlank String nome, @NotBlank String empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

}
