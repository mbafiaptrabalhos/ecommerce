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
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

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
        massaTeste();
    }

    private void massaTeste() {
        // Massa de teste
        Endereco enderecoCobranca = new Endereco();
        enderecoCobranca.setRua("rua onde judas perdeu as botas, 456");
        enderecoCobranca.setCep("04841-100");
        enderecoCobranca.setCidade("Salvador");
        enderecoCobranca.setTipoEndereco(TipoEndereco.COBRANCA);

        Endereco enderecoEntrega = new Endereco();
        enderecoEntrega.setRua("Av. a volta dos que não foram, 1500");
        enderecoEntrega.setCep("04841-100");
        enderecoEntrega.setCidade("Salvador");
        enderecoEntrega.setTipoEndereco(TipoEndereco.ENTREGA);

        Set<Endereco> enderecos = new LinkedHashSet<>();
        enderecos.add(enderecoCobranca);
        enderecos.add(enderecoEntrega);

        Cliente cliente = new Cliente();
        cliente.setNome("Alessandra Silva");
        cliente.setCnpj("");
        cliente.setCpf("214.789.456-89");
        cliente.setEnderecos(enderecos);

        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setFormaPagamento(FormaPagamento.BOLETO);
        tipoPagamento.setAtivo(true);
        tipoPagamentoRepository.save(tipoPagamento);

        clienteRepository.save(cliente);

        CategoriaProduto categoriaProduto = new CategoriaProduto();
        categoriaProduto.setCategoria("Eletrodomestico");

        CategoriaProduto categoriaProduto2 = new CategoriaProduto();
        categoriaProduto.setCategoria("Celular");

        categoriaProdutoRepository.save(categoriaProduto);
        categoriaProdutoRepository.save(categoriaProduto2);

        Produto produto = new Produto();
        produto.setCategoriaProduto(categoriaProduto);
        produto.setDescricao("Bate qualquer coisa");
        produto.setNome("Liquidificar Ninja");
        produto.setQtdEstoque(3L);
        produto.setValorUnitario(new BigDecimal(200.00));

        Produto produto2 = new Produto();
        produto2.setCategoriaProduto(categoriaProduto2);
        produto2.setDescricao("Onde nao tem sinal esse equipamento tera");
        produto2.setNome("Celular Chuck Norris");
        produto2.setQtdEstoque(10L);
        produto2.setValorUnitario(new BigDecimal(3000.00));

        Produto produto3 = new Produto();
        produto3.setCategoriaProduto(categoriaProduto2);
        produto3.setDescricao("Novo lg");
        produto3.setNome("LG A6");
        produto3.setQtdEstoque(5L);
        produto3.setValorUnitario(new BigDecimal(650.00));

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

        Entrega entrega = new Entrega();
        entrega.setPedido(pedido);
        entrega.setDataPrevista(Calendar.getInstance());
        entrega.setDataStatus(Calendar.getInstance());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Entrega entrega2 = new Entrega();
        entrega2.setPedido(pedido2);
        entrega2.setDataPrevista(calendar);
        entrega2.setDataStatus(Calendar.getInstance());

        entregaRepository.save(entrega);
        entregaRepository.save(entrega2);

        Status status = new Status();
        status.setStatusRastreamento(StatusRastreamento.EM_TRANSITO);
        statusRepository.save(status);

        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setPedido(pedido);
        rastreamento.setStatus(status);
        rastreamento.setDataStatus(Calendar.getInstance());
        rastreamento.setDescricao("produto frágil");
        rastreamento.setLatitude("-23.5677666");
        rastreamento.setLongitude("-46.6487763");

        rastreamentoRepository.save(rastreamento);
    }
}
