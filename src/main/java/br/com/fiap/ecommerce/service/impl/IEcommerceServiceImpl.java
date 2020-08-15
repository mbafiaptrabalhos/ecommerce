package br.com.fiap.ecommerce.service.impl;

import br.com.fiap.ecommerce.entity.*;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import br.com.fiap.ecommerce.service.IEcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEcommerceServiceImpl implements IEcommerceService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<CategoriaProduto> getAllCategorias() {
        return null;
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Endereco> getAllEndereco() {
        return null;
    }

    @Override
    public List<Entrega> getAllEntrega() {
        return null;
    }

    @Override
    public List<Pedido> getAllPedido() {
        return null;
    }

    @Override
    public List<Produto> getAllProduto() {
        return null;
    }

    @Override
    public List<Rastreamento> getAllRastreamento() {
        return null;
    }

    @Override
    public List<Status> getAllStatus() {
        return null;
    }

    @Override
    public List<TipoPagamento> getAllTipoPagamento() {
        return null;
    }

    @Override
    public Produto getProdutoById(long id) {
        return null;
    }

    @Override
    public Cliente getClienteById(long id) {
        return null;
    }
}
