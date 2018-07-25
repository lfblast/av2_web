package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Gerente;
import br.edu.infnet.av2.repository.GerenteRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenteService {
    
    @Autowired
    private GerenteRepo gerenteRepo;
    
    public Gerente findById(Long id) {
        Optional<Gerente> gerenteOpt = gerenteRepo.findById(id);
        return gerenteOpt.get();
    }

    public List<Gerente> findAll() {
        return gerenteRepo.findAll();
    }

    public void save(Gerente gerente) {
        gerenteRepo.save(gerente);
    }

    public void delete(Gerente gerente) {
        gerenteRepo.delete(gerente);
    }

    public GerenteRepo getGerenteRepo() {
        return gerenteRepo;
    }

    public void setGerenteRepo(GerenteRepo gerenteRepo) {
        this.gerenteRepo = gerenteRepo;
    }
}