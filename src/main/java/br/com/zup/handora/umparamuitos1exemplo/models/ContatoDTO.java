package br.com.zup.handora.umparamuitos1exemplo.models;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ContatoDTO {

    @NotBlank
    private String nome;

    private String empresa;

    @Valid
    @NotEmpty
    private Set<TelefoneDTO> telefones;

    public ContatoDTO(@NotBlank String nome, @NotBlank String empresa,
                      @NotEmpty Set<TelefoneDTO> telefones) {
        this.nome = nome;
        this.empresa = empresa;
        this.telefones = telefones;
    }

    public Contato toModel() {
        Contato contato = new Contato(nome, empresa);

        telefones.forEach(telefoneDTO -> {
            contato.adicionar(telefoneDTO.toModel());
        });

        return contato;
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
