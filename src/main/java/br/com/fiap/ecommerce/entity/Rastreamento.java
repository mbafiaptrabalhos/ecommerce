package br.com.fiap.ecommerce.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "rastreamento")
@Getter @Setter
public class Rastreamento {
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
