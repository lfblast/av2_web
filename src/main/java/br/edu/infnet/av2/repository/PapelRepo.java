package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepo extends JpaRepository<Papel, Long> {
    
    @Query("select r from Papel r where r.nomePapel = ?1")
    public Papel findByNomePapel(String nomePapel);
}