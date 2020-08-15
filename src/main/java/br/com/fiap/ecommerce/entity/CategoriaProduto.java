package br.com.fiap.ecommerce.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIA_PRODUTO")
@Setter @Getter
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CATEGORIA")
    private String categoria;

    public CategoriaProduto() {
    }
}
