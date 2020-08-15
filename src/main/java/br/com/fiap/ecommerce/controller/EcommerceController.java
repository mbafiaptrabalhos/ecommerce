package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.entity.Cliente;
import br.com.fiap.ecommerce.service.IEcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EcommerceController {

    @Autowired
    IEcommerceService service;

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(service.getAllCliente());
    }
}
