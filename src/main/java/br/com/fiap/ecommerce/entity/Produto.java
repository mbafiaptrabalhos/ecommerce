package br.com.fiap.ecommerce.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Setter @Getter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;

    @OneToOne(cascade = CascadeType.ALL)
    private CategoriaProduto categoriaProduto;
    @OneToOne(cascade = CascadeType.ALL)
    private Estoque estoque;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "produto")
    @JsonIgnoreProperties("produto")
    private Set<Item> itens = new HashSet<Item>();

    public Produto() {
    }
}
