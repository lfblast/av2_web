package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredienteRepo extends JpaRepository<Ingrediente, Long> {    
}