package br.com.fiap.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.ecommerce.entity.enums.StatusRastreamento;
import lombok.Getter;
import lombok.Setter;

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
