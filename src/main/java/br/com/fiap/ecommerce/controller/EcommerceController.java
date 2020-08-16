package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.entity.*;
import br.com.fiap.ecommerce.service.IEcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EcommerceController {

	@Autowired
	IEcommerceService service;

	// Get All
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllCliente() {
		return ResponseEntity.ok(service.getAllCliente());
	}

	@GetMapping("/categoriaProduto")
	public ResponseEntity<List<CategoriaProduto>> getAllCategorias() {
		return ResponseEntity.ok(service.getAllCategorias());
	}

	@GetMapping("/entrega")
	public ResponseEntity<List<Entrega>> getAllEntrega() {
		return ResponseEntity.ok(service.getAllEntrega());
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> getAllProduto() {
		return ResponseEntity.ok(service.getAllProduto());
	}

	@GetMapping("/rastreamento")
	public ResponseEntity<List<Rastreamento>> getAllRastreamento() {
		return ResponseEntity.ok(service.getAllRastreamento());
	}

	@GetMapping("/status")
	public ResponseEntity<List<Status>> getAllStatus() {
		return ResponseEntity.ok(service.getAllStatus());
	}

	@GetMapping("/tipoPagamento")
	public ResponseEntity<List<TipoPagamento>> getAllTipoPagamento() {
		return ResponseEntity.ok(service.getAllTipoPagamento());
	}

	@GetMapping("/endereco")
	public ResponseEntity<List<Endereco>> getAllEndereco() {
		return ResponseEntity.ok(service.getAllEndereco());
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> getAllPedido() {
		return ResponseEntity.ok(service.getAllPedido());
	}

	// Get id

	@GetMapping("produto/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
		Produto produto = service.getProdutoById(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@GetMapping("clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
		Cliente cliente = service.getClienteById(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("pedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Long id) {
		Pedido pedido = service.getPedidoById(id);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}

	// Add

	@PostMapping("produto")
	public ResponseEntity<Void> addProduto(@RequestBody Produto produto, UriComponentsBuilder builder) {
		Produto salvarProduto = service.addProduto(produto);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/produto/{id}").buildAndExpand(salvarProduto.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping("cliente") 
	public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
		Cliente salvarCliente = service.addCliente(cliente);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cliente/{id}").buildAndExpand(salvarCliente.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping("categoria")
	public ResponseEntity<Void> addCategoria(@RequestBody CategoriaProduto categoria, UriComponentsBuilder builder) {
		CategoriaProduto salvarCategoria = service.addCategoria(categoria);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/categoria/{id}").buildAndExpand(salvarCategoria.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping("/pedido")
	public ResponseEntity<Void> addPedido(@RequestBody Pedido pedido, UriComponentsBuilder builder) {
		pedido.getItem().stream().forEach(i -> i.setPedido(pedido));
		Pedido salvarPedido = service.addPedido(pedido);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pedido/{id}").buildAndExpand(salvarPedido.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Delete

	@DeleteMapping("produto/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable("id") Long id) {
		service.deleteProduto(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("cliente/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
		service.deleteCliente(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// Update

	@PutMapping("produto")
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
		service.updateProduto(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PutMapping("cliente")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		service.updateCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@PutMapping("categoria")
	public ResponseEntity<CategoriaProduto> updateCategoria(@RequestBody CategoriaProduto categoria) {
		service.updateCategoria(categoria);
		return new ResponseEntity<CategoriaProduto>(categoria, HttpStatus.OK);
	}
}
