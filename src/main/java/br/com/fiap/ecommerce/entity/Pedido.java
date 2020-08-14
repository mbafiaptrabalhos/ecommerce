package br.com.fiap.ecommerce.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "DATA_PEDIDO")
    private Calendar dataPedido;

    @ManyToOne
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
