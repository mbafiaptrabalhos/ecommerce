package br.com.fiap.ecommerce.entity;

import br.com.fiap.ecommerce.entity.enums.FormaPagamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipo_pagamento")
@Getter @Setter
public class TipoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "FORMA_PAGAMENTO")
    FormaPagamento formaPagamento;
    @Column(name = "ATIVO")
    private boolean ativo;

    public TipoPagamento() {
    }
}
