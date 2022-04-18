package br.com.zup.handora.umparamuitos1exemplo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String empresa;

    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, mappedBy = "contato", orphanRemoval = true)
    private Set<Telefone> telefones = new HashSet<>();

    private boolean ativo = true;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Contato() {}

    public Contato(String nome, String empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public void adicionar(Telefone telefone) {
        telefone.setContato(this);
        telefones.add(telefone);
    }

    public void atualizar(String nome, String empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public boolean isAtivo() {
        return ativo;
    }

}
