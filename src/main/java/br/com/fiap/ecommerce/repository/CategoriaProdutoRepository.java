package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.entity.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
}
