package br.com.fiap.ecommerce.entity;

import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@Getter @Setter @Builder
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;
}
