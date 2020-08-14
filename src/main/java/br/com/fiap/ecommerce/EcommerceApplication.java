package br.com.fiap.ecommerce;

import br.com.fiap.ecommerce.entity.*;
import br.com.fiap.ecommerce.entity.enums.FormaPagamento;
import br.com.fiap.ecommerce.entity.enums.StatusRastreamento;
import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import br.com.fiap.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start persistência");

        // Massa de teste
        Endereco enderecoCobranca = Endereco.builder()
                .rua("rua onde judas perdeu as botas, 456")
                .cep("04841-100")
                .cidade("Salvador")
                .tipoEndereco(TipoEndereco.COBRANCA)
                .build();

        Endereco enderecoEntrega = Endereco.builder()
                .rua("Av. a volta dos que não foram, 1500")
                .cep("04841-100")
                .cidade("Salvador")
                .tipoEndereco(TipoEndereco.ENTREGA)
                .build();

        Set<Endereco> enderecos = new LinkedHashSet<>();
        enderecos.add(enderecoCobranca);
        enderecos.add(enderecoEntrega);

        Cliente cliente = Cliente.builder()
                .nome("Alessandra Silva")
                .cpf("214.789.456-89")
                .cnpj("")
                .ativo(true)
                .enderecos(enderecos)
                .build();

        TipoPagamento tipoPagamento = TipoPagamento.builder()
                .formaPagamento(FormaPagamento.BOLETO)
                .ativo(true)
                .build();
        tipoPagamentoRepository.save(tipoPagamento);

        clienteRepository.save(cliente);

        CategoriaProduto categoriaProduto = CategoriaProduto.builder()
                .categoria("Eletrodomestico")
                .build();
        CategoriaProduto categoriaProduto2 = CategoriaProduto.builder()
                .categoria("Celular")
                .build();

        categoriaProdutoRepository.save(categoriaProduto);
        categoriaProdutoRepository.save(categoriaProduto2);

        Produto produto = Produto.builder()
                .categoriaProduto(categoriaProduto)
                .descricao("Bate qualquer coisa")
                .nome("Liquidificar Ninja")
                .qtdEstoque(3L)
                .valorUnitario(new BigDecimal(200.00))
                .build();

        Produto produto2 = Produto.builder()
                .categoriaProduto(categoriaProduto2)
                .descricao("Onde nao tem sinal esse equipamento tera")
                .nome("Celular Chuck Norris")
                .qtdEstoque(10L)
                .valorUnitario(new BigDecimal(3000.00))
                .build();

        Produto produto3 = Produto.builder()
                .categoriaProduto(categoriaProduto2)
                .descricao("Novo lg")
                .nome("LG A6")
                .qtdEstoque(10L)
                .valorUnitario(new BigDecimal(650.00))
                .build();

        produtoRepository.save(produto);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(Calendar.getInstance());
        pedido.setTipoPagamento(tipoPagamento);
        pedido.setProdutos(Arrays.asList(produto, produto2));
        pedido.setValorTotal(new BigDecimal(3200.0));
        pedido.setCliente(cliente);

        Pedido pedido2 = new Pedido();
        pedido2.setDataPedido(Calendar.getInstance());
        pedido2.setTipoPagamento(tipoPagamento);
        pedido2.setProdutos(Arrays.asList(produto3));
        pedido2.setValorTotal(new BigDecimal(650.0));
        pedido2.setCliente(cliente);

        pedidoRepository.save(pedido);
        pedidoRepository.save(pedido2);

        Entrega entrega = Entrega.builder()
                .pedido(pedido)
                .dataPrevista(Calendar.getInstance())
                .dataStatus(Calendar.getInstance())
                .build();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Entrega entrega2 = Entrega.builder()
                .pedido(pedido2)
                .dataPrevista(calendar)
                .dataStatus(Calendar.getInstance())
                .build();

        entregaRepository.save(entrega);
        entregaRepository.save(entrega2);

        Status status = Status.builder()
                .statusRastreamento(StatusRastreamento.EM_TRANSITO)
                .build();
        statusRepository.save(status);

        Rastreamento rastreamento = Rastreamento.builder()
                .pedido(pedido)
                .status(status)
                .dataStatus(Calendar.getInstance())
                .descricao("produto frágil")
                .latitude("-23.5677666")
                .longitude("-46.6487763")
                .build();
        rastreamentoRepository.save(rastreamento);
    }
}
