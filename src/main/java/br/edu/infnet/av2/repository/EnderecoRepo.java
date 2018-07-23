package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepo extends JpaRepository<Endereco, Long> {    
}