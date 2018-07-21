package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepo extends JpaRepository<Produto, Long> {
}