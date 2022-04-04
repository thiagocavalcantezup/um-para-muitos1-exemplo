package br.com.zup.handora.umparamuitos1exemplo.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @PositiveOrZero
    private BigDecimal valor;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Produto() {}

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(String nome, @PositiveOrZero BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

}
