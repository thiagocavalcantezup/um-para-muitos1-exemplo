package br.com.zup.handora.umparamuitos1exemplo.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    @PositiveOrZero
    private BigDecimal total;

    @OneToMany
    Set<Item> itens;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public NotaFiscal() {}

    public NotaFiscal(String numero, @PositiveOrZero BigDecimal total, Set<Item> itens) {
        this.numero = numero;
        this.total = total;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

}
