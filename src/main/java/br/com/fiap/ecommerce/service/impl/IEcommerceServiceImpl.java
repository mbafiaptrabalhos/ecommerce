package br.com.fiap.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.entity.CategoriaProduto;
import br.com.fiap.ecommerce.entity.Cliente;
import br.com.fiap.ecommerce.entity.Endereco;
import br.com.fiap.ecommerce.entity.Entrega;
import br.com.fiap.ecommerce.entity.Pedido;
import br.com.fiap.ecommerce.entity.Produto;
import br.com.fiap.ecommerce.entity.Rastreamento;
import br.com.fiap.ecommerce.entity.Status;
import br.com.fiap.ecommerce.entity.TipoPagamento;
import br.com.fiap.ecommerce.repository.CategoriaProdutoRepository;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import br.com.fiap.ecommerce.repository.EnderecoRepository;
import br.com.fiap.ecommerce.repository.EntregaRepository;
import br.com.fiap.ecommerce.repository.PedidoRepository;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import br.com.fiap.ecommerce.repository.RastreamentoRepository;
import br.com.fiap.ecommerce.repository.StatusRepository;
import br.com.fiap.ecommerce.repository.TipoPagamentoRepository;
import br.com.fiap.ecommerce.service.IEcommerceService;

@Service
public class IEcommerceServiceImpl implements IEcommerceService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CategoriaProdutoRepository categoriaRepository;
	@Autowired
	EntregaRepository entregaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	RastreamentoRepository rastreamentoRepository;
	@Autowired
	StatusRepository statusRepository;
	@Autowired
	TipoPagamentoRepository tipoPagamentoRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public List<CategoriaProduto> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public List<Endereco> getAllEndereco() {
		return enderecoRepository.findAll();
	}

	@Override
	public List<Entrega> getAllEntrega() {
		return entregaRepository.findAll();
	}

	@Override
	public List<Pedido> getAllPedido() {
		return pedidoRepository.findAll();
	}

	@Override
	public List<Produto> getAllProduto() {
		return produtoRepository.findAll();
	}

	@Override
	public List<Rastreamento> getAllRastreamento() {
		return rastreamentoRepository.findAll();
	}

	@Override
	public List<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	@Override
	public List<TipoPagamento> getAllTipoPagamento() {
		return tipoPagamentoRepository.findAll();
	}

	@Override
	public Produto getProdutoById(long id) {
		return produtoRepository.findById(id).get();
	}

	@Override
	public Pedido getPedidoById(long id) {
		return pedidoRepository.findById(id).get();
	}
	
	@Override
	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public Produto addProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Override
	public Pedido addPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public CategoriaProduto addCategoria(CategoriaProduto categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void deleteProduto(long id) {
		produtoRepository.delete(produtoRepository.findById(id).get());
	}

	@Override
	public void deleteCliente(long id) {
		clienteRepository.delete(clienteRepository.findById(id).get());
	}

	@Override
	public void deleteCategoria(long id) {
		categoriaRepository.delete(categoriaRepository.findById(id).get());
	}

	@Override
	public Produto updateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public CategoriaProduto updateCategoria(CategoriaProduto categoria) {
		return categoriaRepository.save(categoria);
	}
	
}
