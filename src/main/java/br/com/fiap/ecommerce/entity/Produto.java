package br.com.fiap.ecommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Setter @Getter
public class Produto  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
