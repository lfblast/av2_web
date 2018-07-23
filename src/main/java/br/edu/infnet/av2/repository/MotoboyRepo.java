package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Motoboy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoboyRepo extends JpaRepository<Motoboy, Long> {
    
}
