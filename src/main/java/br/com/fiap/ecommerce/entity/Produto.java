package br.com.fiap.ecommerce.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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
    @Column(name = "QTD_ESTOQUE")
    private Long qtdEstoque;
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;

    @OneToOne
    private CategoriaProduto categoriaProduto;

    public Produto() {
    }
}
