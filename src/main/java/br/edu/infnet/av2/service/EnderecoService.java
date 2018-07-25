package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Endereco;
import br.edu.infnet.av2.repository.EnderecoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepo enderecoRepo;
    
    public Endereco findById(Long id) {
        Optional<Endereco> enderecoOpt = enderecoRepo.findById(id);
        return enderecoOpt.get();
    }

    public List<Endereco> findAll() {
        return enderecoRepo.findAll();
    }

    public void save(Endereco endereco) {
        enderecoRepo.save(endereco);
    }

    public void delete(Endereco endereco) {
        enderecoRepo.delete(endereco);
    }

    public EnderecoRepo getEnderecoRepo() {
        return enderecoRepo;
    }

    public void setEnderecoRepo(EnderecoRepo enderecoRepo) {
        this.enderecoRepo = enderecoRepo;
    }
}