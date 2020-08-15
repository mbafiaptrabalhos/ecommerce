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

import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "RUA")
	private String rua;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "CEP")
	private String cep;
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_ENDERECO")
	private TipoEndereco tipoEndereco;

	public Endereco() {
	}
}
