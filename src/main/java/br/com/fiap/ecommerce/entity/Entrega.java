package br.com.fiap.ecommerce.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "entrega")
@Setter @Getter @Builder
public class Entrega {
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

}
