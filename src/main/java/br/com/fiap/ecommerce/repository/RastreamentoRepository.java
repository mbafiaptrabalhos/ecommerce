package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.entity.Rastreamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
}
