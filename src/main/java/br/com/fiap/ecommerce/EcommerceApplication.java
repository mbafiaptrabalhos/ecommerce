package br.com.fiap.ecommerce;

import br.com.fiap.ecommerce.entity.*;
import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import br.com.fiap.ecommerce.repository.CategoriaProdutoRepository;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import br.com.fiap.ecommerce.repository.PedidoRepository;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
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
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

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

        Pedido pedido = new Pedido();
        pedido.setDataPedido(Calendar.getInstance());
        pedido.setValorTotal(new BigDecimal(200.0));
        pedido.setCliente(cliente);

        Pedido pedido2 = new Pedido();
        pedido2.setDataPedido(Calendar.getInstance());
        pedido2.setValorTotal(new BigDecimal(3000.0));
        pedido2.setCliente(cliente);

        clienteRepository.save(cliente);

        pedidoRepository.save(pedido);
        pedidoRepository.save(pedido2);

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
                .pedido(pedido)
                .descricao("Bate qualquer coisa")
                .nome("Liquidificar Ninja")
                .qtdEstoque(3L)
                .valorUnitario(new BigDecimal(200.00))
                .build();

        Produto produto2 = Produto.builder()
                .categoriaProduto(categoriaProduto2)
                .pedido(pedido2)
                .descricao("Onde nao tem sinal esse equipamento tera")
                .nome("Celular Chuck Norris")
                .qtdEstoque(10L)
                .valorUnitario(new BigDecimal(3000.00))
                .build();

        produtoRepository.save(produto);
        produtoRepository.save(produto2);
    }
}
