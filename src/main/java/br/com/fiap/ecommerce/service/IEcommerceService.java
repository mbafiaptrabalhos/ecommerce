package br.com.fiap.ecommerce.service;

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

	// Get All
	List<CategoriaProduto> getAllCategorias();

	List<Cliente> getAllCliente();

	List<Endereco> getAllEndereco();

	List<Entrega> getAllEntrega();

	List<Produto> getAllProduto();

	List<Rastreamento> getAllRastreamento();

	List<Status> getAllStatus();

	List<TipoPagamento> getAllTipoPagamento();
	
	List<Pedido> getAllPedido();

	// Get id
	Produto getProdutoById(long id);

	Cliente getClienteById(long id);
	
	Pedido getPedidoById(long id);

	// Add
	Produto addProduto(Produto produto);

	Cliente addCliente(Cliente cliente);

	CategoriaProduto addCategoria(CategoriaProduto categoria);

	Pedido addPedido(Pedido pedido);
	
	// Delete
	void deleteProduto(long id);

	void deleteCliente(long id);

	void deleteCategoria(long id);
	
	// Update
	Produto updateProduto(Produto produto);

	Cliente updateCliente(Cliente cliente);

	CategoriaProduto updateCategoria(CategoriaProduto categoria);
	
}
