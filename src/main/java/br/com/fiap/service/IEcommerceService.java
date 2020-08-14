package br.com.fiap.service;

import java.util.List;

import br.com.fiap.ecommerce.entity.CategoriaProduto;
import br.com.fiap.ecommerce.entity.Cliente;
import br.com.fiap.ecommerce.entity.Endereco;
import br.com.fiap.ecommerce.entity.Entrega;
import br.com.fiap.ecommerce.entity.Pedido;
import br.com.fiap.ecommerce.entity.Produto;
import br.com.fiap.ecommerce.entity.Rastreamento;
import br.com.fiap.ecommerce.entity.Status;
import br.com.fiap.ecommerce.entity.TipoPagamento;

public interface IEcommerceService {
	
	List<CategoriaProduto> getAllCategorias();
	List<Cliente> getAllCliente();
	List<Endereco> getAllEndereco();
 	List<Entrega> getAllEntrega();
 	List<Pedido> getAllPedido();
 	List<Produto> getAllProduto();
 	List<Rastreamento> getAllRastreamento();
 	List<Status> getAllStatus();
 	List<TipoPagamento> getAllTipoPagamento();
 	
 	Produto getProdutoById(long id);
 	Cliente getClienteById(long id);
} 
