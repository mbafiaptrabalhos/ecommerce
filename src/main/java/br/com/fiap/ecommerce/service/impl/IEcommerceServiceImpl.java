package br.com.fiap.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	@Cacheable(value = "allCategoriasCache", unless = "#result.size() == 0")
	public List<CategoriaProduto> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	@Cacheable(value = "allClientesCache", unless = "#result.size() == 0")
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	@Cacheable(value = "allEnderecosCache", unless = "#result.size() == 0")
	public List<Endereco> getAllEndereco() {
		return enderecoRepository.findAll();
	}

	@Override
	@Cacheable(value = "allEntregasCache", unless = "#result.size() == 0")
	public List<Entrega> getAllEntrega() {
		return entregaRepository.findAll();
	}

	@Override
	@Cacheable(value = "allPedidosCache", unless = "#result.size() == 0")
	public List<Pedido> getAllPedido() {
		return pedidoRepository.findAll();
	}

	@Override
	@Cacheable(value = "allProdutosCache", unless = "#result.size() == 0")
	public List<Produto> getAllProduto() {
		return produtoRepository.findAll();
	}

	@Override
	@Cacheable(value = "allRastreamentosCache", unless = "#result.size() == 0")
	public List<Rastreamento> getAllRastreamento() {
		return rastreamentoRepository.findAll();
	}

	@Override
	@Cacheable(value = "allStatusCache", unless = "#result.size() == 0")
	public List<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	@Override
	@Cacheable(value = "allTiposPagamentoCache", unless = "#result.size() == 0")
	public List<TipoPagamento> getAllTipoPagamento() {
		return tipoPagamentoRepository.findAll();
	}

	@Override
	@Cacheable(value = "produtoCache", key = "#id")
	public Produto getProdutoById(long id) {
		return produtoRepository.findById(id).get();
	}

	@Override
	@Cacheable(value = "pedidoCache", key = "#id")
	public Pedido getPedidoById(long id) {
		return pedidoRepository.findById(id).get();
	}

	@Override
	@Cacheable(value = "clienteCache", key = "#id")
	public Cliente getClienteById(long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	@Caching(put = { @CachePut(value = "produtoCache", key = "#produto.id") }, evict = {
			@CacheEvict(value = "allProdutosCache", allEntries = true) })
	public Produto addProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.id") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })
	public Pedido addPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#cliente.id") }, evict = {
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Caching(put = { @CachePut(value = "categoriaCache", key = "#categoria.id") }, evict = {
			@CacheEvict(value = "allCategoriasCache", allEntries = true) })
	public CategoriaProduto addCategoria(CategoriaProduto categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	@CacheEvict(value = "allProdutosCache", allEntries = true)
	public void deleteProduto(long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "clienteCache", key = "#id"),
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public void deleteCliente(long id) {
		clienteRepository.delete(clienteRepository.findById(id).get());
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "categoriaCache", key = "#id"),
			@CacheEvict(value = "allCategoriasCache", allEntries = true) })
	public void deleteCategoria(long id) {
		categoriaRepository.delete(categoriaRepository.findById(id).get());
	}

	@Override
	@Caching(put = { @CachePut(value = "produtoCache", key = "#produto.id") }, evict = {
			@CacheEvict(value = "allProdutosCache", allEntries = true) })
	public Produto updateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#cliente.id") }, evict = {
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Caching(put = { @CachePut(value = "categoriaCache", key = "#categoria.id") }, evict = {
			@CacheEvict(value = "allCategoriasCache", allEntries = true) })
	public CategoriaProduto updateCategoria(CategoriaProduto categoria) {
		return categoriaRepository.save(categoria);
	}

}
