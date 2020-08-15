package br.com.fiap.ecommerce.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "entrega")
@Setter
@Getter
public class Entrega implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATA_PREVISTA")
	@Temporal(value = TemporalType.DATE)
	Calendar dataPrevista;
	@Column(name = "DATA_STATUS")
	@Temporal(value = TemporalType.DATE)
	Calendar dataStatus;

	@OneToOne
	private Pedido pedido;

	public Entrega() {
	}
}
