package br.com.fiap.ecommerce;

import br.com.fiap.ecommerce.entity.Cliente;
import br.com.fiap.ecommerce.entity.Endereco;
import br.com.fiap.ecommerce.entity.enums.TipoEndereco;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

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
                .tipoEndereco(TipoEndereco.COBRANCA.name())
                .build();

        Endereco enderecoEntrega = Endereco.builder()
                .rua("rua onde judas perdeu as botas, 456")
                .cep("04841-100")
                .cidade("Salvador")
                .tipoEndereco(TipoEndereco.ENTREGA.name())
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

        clienteRepository.save(cliente);
    }
}
