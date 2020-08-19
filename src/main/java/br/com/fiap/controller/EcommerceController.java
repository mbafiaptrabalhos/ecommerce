package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.entity.CategoriaProduto;
import br.com.fiap.ecommerce.entity.Cliente;
import br.com.fiap.ecommerce.entity.Endereco;
import br.com.fiap.ecommerce.entity.Entrega;
import br.com.fiap.ecommerce.entity.Pedido;
import br.com.fiap.ecommerce.entity.Produto;
import br.com.fiap.ecommerce.entity.Rastreamento;
import br.com.fiap.ecommerce.entity.Status;
import br.com.fiap.ecommerce.entity.TipoPagamento;
import br.com.fiap.service.IEcommerceService;

@RestController
@RequestMapping("ecommerce")
public class EcommerceController {

	@Autowired
	private IEcommerceService ecommerceService;

	// Get All
	@GetMapping("categoriaProduto")
	public ResponseEntity<List<CategoriaProduto>> getAllCategorias() {
		List<CategoriaProduto> lista = ecommerceService.getAllCategorias();
		return new ResponseEntity<List<CategoriaProduto>>(lista, HttpStatus.OK);
	}

	@GetMapping("clientes")
	public ResponseEntity<List<Cliente>> getAllCliente() {
		List<Cliente> lista = ecommerceService.getAllCliente();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@GetMapping("endereco")
	public ResponseEntity<List<Endereco>> getAllEndereco() {
		List<Endereco> lista = ecommerceService.getAllEndereco();
		return new ResponseEntity<List<Endereco>>(lista, HttpStatus.OK);
	}

	@GetMapping("entrega")
	public ResponseEntity<List<Entrega>> getAllEntrega() {
		List<Entrega> lista = ecommerceService.getAllEntrega();
		return new ResponseEntity<List<Entrega>>(lista, HttpStatus.OK);
	}

	@GetMapping("pedido")
	public ResponseEntity<List<Pedido>> getAllPedido() {
		List<Pedido> lista = ecommerceService.getAllPedido();
		return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
	}

	@GetMapping("produto")
	public ResponseEntity<List<Produto>> getAllProduto() {
		List<Produto> lista = ecommerceService.getAllProduto();
		return new ResponseEntity<List<Produto>>(lista, HttpStatus.OK);
	}

	@GetMapping("rastreamento")
	public ResponseEntity<List<Rastreamento>> getAllRastreamento() {
		List<Rastreamento> lista = ecommerceService.getAllRastreamento();
		return new ResponseEntity<List<Rastreamento>>(lista, HttpStatus.OK);
	}

	@GetMapping("status")
	public ResponseEntity<List<Status>> getAllStatus() {
		List<Status> lista = ecommerceService.getAllStatus();
		return new ResponseEntity<List<Status>>(lista, HttpStatus.OK);
	}

	@GetMapping("tipoPagamento")
	public ResponseEntity<List<TipoPagamento>> getAllTipoPagamento() {
		List<TipoPagamento> lista = ecommerceService.getAllTipoPagamento();
		return new ResponseEntity<List<TipoPagamento>>(lista, HttpStatus.OK);
	}

	// Get id

	@GetMapping("produto/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
		Produto produto = ecommerceService.getProdutoById(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
		Cliente cliente = ecommerceService.getClienteById(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
}