package br.com.fiap.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.ecommerce.entity.enums.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_pagamento")
@Getter
@Setter
public class TipoPagamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
