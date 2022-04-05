package br.com.zup.handora.umparamuitos1exemplo.models;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ContatoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String empresa;

    @NotEmpty
    private Set<TelefoneDTO> telefones;

    public ContatoDTO(@NotBlank String nome, @NotBlank String empresa,
                      @NotEmpty Set<TelefoneDTO> telefones) {
        this.nome = nome;
        this.empresa = empresa;
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public Set<TelefoneDTO> getTelefones() {
        return telefones;
    }

}
