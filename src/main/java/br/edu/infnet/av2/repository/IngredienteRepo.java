package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepo extends JpaRepository<Ingrediente, Long> {    
}