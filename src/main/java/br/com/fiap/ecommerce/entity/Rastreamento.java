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
@Table(name = "rastreamento")
@Getter
@Setter
public class Rastreamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "LATITUDE")
	private String latitude;
	@Column(name = "LONGITUDE")
	private String longitude;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATA_STATUS")
	private Calendar dataStatus;

	@OneToOne
	private Pedido pedido;
	@OneToOne
	private Status status;

	public Rastreamento() {
	}
}
