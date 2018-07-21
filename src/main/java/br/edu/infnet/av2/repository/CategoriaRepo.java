package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
}