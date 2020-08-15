package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ecommerce.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
