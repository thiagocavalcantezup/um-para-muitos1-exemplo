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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "contato")
    private Set<Telefone> telefones = new HashSet<>();

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

    public Long getId() {
        return id;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

}
