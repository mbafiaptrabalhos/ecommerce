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
    private EnderecoRepository enderecoRepository;

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
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ItemRepository itemRepository;

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

        enderecoRepository.save(enderecoCobranca);
        enderecoRepository.save(enderecoEntrega);

        Set<Endereco> enderecos = new LinkedHashSet<>();
        enderecos.add(enderecoCobranca);
        enderecos.add(enderecoEntrega);

        Cliente cliente = new Cliente();
        cliente.setNome("Alessandra Silva");
        cliente.setCnpj("");
        cliente.setCpf("214.789.456-89");
        cliente.setEnderecos(enderecos);
        cliente.setAtivo(true);

        clienteRepository.save(cliente);

        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setFormaPagamento(FormaPagamento.BOLETO);
        tipoPagamento.setAtivo(true);
        tipoPagamentoRepository.save(tipoPagamento);

        CategoriaProduto categoriaProduto = new CategoriaProduto();
        categoriaProduto.setCategoria("Eletrodomestico");

        CategoriaProduto categoriaProduto2 = new CategoriaProduto();
        categoriaProduto2.setCategoria("Celular");

        CategoriaProduto categoriaProduto3 = new CategoriaProduto();
        categoriaProduto3.setCategoria("Automotivo");

        categoriaProdutoRepository.save(categoriaProduto);
        categoriaProdutoRepository.save(categoriaProduto2);
        categoriaProdutoRepository.save(categoriaProduto3);

        Estoque estoque = new Estoque();
        estoque.setQuantidade(3L);

        Estoque estoque2 = new Estoque();
        estoque2.setQuantidade(10L);

        Estoque estoque3 = new Estoque();
        estoque3.setQuantidade(5L);

        Estoque estoque4 = new Estoque();
        estoque4.setQuantidade(6L);

        estoqueRepository.save(estoque);
        estoqueRepository.save(estoque2);
        estoqueRepository.save(estoque3);
        estoqueRepository.save(estoque4);

        Produto produto = new Produto();
        produto.setCategoriaProduto(categoriaProduto);
        produto.setDescricao("Bate qualquer coisa");
        produto.setNome("Liquidificador Ninja");
        produto.setEstoque(estoque);
        produto.setValorUnitario(new BigDecimal(200.00));

        Produto produto2 = new Produto();
        produto2.setCategoriaProduto(categoriaProduto2);
        produto2.setDescricao("Onde nao tem sinal esse equipamento tera");
        produto2.setNome("Celular Chuck Norris");
        produto2.setEstoque(estoque2);
        produto2.setValorUnitario(new BigDecimal(3000.00));

        Produto produto3 = new Produto();
        produto3.setCategoriaProduto(categoriaProduto2);
        produto3.setDescricao("Novo lg");
        produto3.setNome("LG A6");
        produto3.setEstoque(estoque3);
        produto3.setValorUnitario(new BigDecimal(650.00));

        Produto produto4 = new Produto();
        produto4.setCategoriaProduto(categoriaProduto3);
        produto4.setDescricao("Som Automotivo Pioneer MP3 Player AM/FM USB - Auxiliar MVH-98UB");
        produto4.setNome("Som Automotivo Pioneer MP3 Player");
        produto4.setEstoque(estoque4);
        produto4.setValorUnitario(new BigDecimal(199.90));

        produtoRepository.save(produto);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);
        produtoRepository.save(produto4);

        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(1L);

        Item item2 = new Item();
        item2.setProduto(produto2);
        item2.setQuantidade(1L);

        Item item3 = new Item();
        item3.setProduto(produto3);
        item3.setQuantidade(1L);

        Item item4 = new Item();
        item4.setProduto(produto4);
        item4.setQuantidade(2L);

        itemRepository.save(item);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(Calendar.getInstance());
        pedido.setTipoPagamento(tipoPagamento);
        pedido.setCliente(cliente);
        pedido.setItem(Arrays.asList(item, item2));
        pedido.setValorTotal(new BigDecimal(3200.00));

        Pedido pedido2 = new Pedido();
        pedido2.setDataPedido(Calendar.getInstance());
        pedido2.setTipoPagamento(tipoPagamento);
        pedido2.setCliente(cliente);
        pedido2.setItem(Arrays.asList(item3, item4));
        pedido2.setValorTotal(new BigDecimal(1049.8));

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
