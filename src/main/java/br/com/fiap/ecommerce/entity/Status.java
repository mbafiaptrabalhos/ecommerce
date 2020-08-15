package br.com.fiap.ecommerce.entity;

import br.com.fiap.ecommerce.entity.enums.StatusRastreamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter @Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_RASTREAMENTO")
    StatusRastreamento statusRastreamento;

    public Status() {
    }
}
