package br.com.fiap.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter @Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_cliente")
    private int codCliente;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column(name = "end_cobranca")
    private String enderecoCobranca;
    @Column(name = "end_entrega")
    private String enderecoEntrega;
    @Column
    private boolean ativo;
}