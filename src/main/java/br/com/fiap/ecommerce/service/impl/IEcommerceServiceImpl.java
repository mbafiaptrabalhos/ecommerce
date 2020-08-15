package br.com.fiap.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
import br.com.fiap.ecommerce.repository.ClienteRepository;
import br.com.fiap.ecommerce.service.IEcommerceService;

@Service
public class IEcommerceServiceImpl implements IEcommerceService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<CategoriaProduto> getAllCategorias() {
		return null;
	}

	@Override
	@Cacheable(value = "allClientesCache", unless = "#result.size() == 0")
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	@Cacheable(value = "allEnderecosCache", unless = "#result.size() == 0")
	public List<Endereco> getAllEndereco() {
		return null;
	}

	@Override
	@Cacheable(value = "allEntregasCache", unless = "#result.size() == 0")
	public List<Entrega> getAllEntrega() {
		return null;
	}

	@Override
	@Cacheable(value = "allPedidosCache", unless = "#result.size() == 0")
	public List<Pedido> getAllPedido() {
		return null;
	}

	@Override
	@Cacheable(value = "allProdutosCache", unless = "#result.size() == 0")
	public List<Produto> getAllProduto() {
		return null;
	}

	@Override
	@Cacheable(value = "allRastreamentosCache", unless = "#result.size() == 0")
	public List<Rastreamento> getAllRastreamento() {
		return null;
	}

	@Override
	@Cacheable(value = "allStatusCache", unless = "#result.size() == 0")
	public List<Status> getAllStatus() {
		return null;
	}

	@Override
	@Cacheable(value = "allTiposPagamentoCache", unless = "#result.size() == 0")
	public List<TipoPagamento> getAllTipoPagamento() {
		return null;
	}

	@Override
	@Cacheable(value = "produtoCache", key = "#id")
	public Produto getProdutoById(long id) {
		return null;
	}

	@Override
	@Cacheable(value = "clienteCache", key = "#id")
	public Cliente getClienteById(long id) {
		return null;
	}
}
