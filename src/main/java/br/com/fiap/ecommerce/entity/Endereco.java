package br.com.fiap.ecommerce.entity;

import javax.persistence.*;

import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter @Setter
public class Endereco {
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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Endereco() {
    }
}
