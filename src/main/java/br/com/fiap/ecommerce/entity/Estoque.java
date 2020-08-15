package br.com.fiap.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estoque")
@Data
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "QUANTIDADE")
    private Long quantidade;

    public Estoque() {
    }
}
