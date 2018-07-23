package br.edu.infnet.av2.repository;

import br.edu.infnet.av2.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {
    Funcionario findByLogin(String login);
}