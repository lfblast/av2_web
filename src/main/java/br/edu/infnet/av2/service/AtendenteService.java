package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Atendente;
import br.edu.infnet.av2.repository.AtendenteRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendenteService {
    
    @Autowired
    private AtendenteRepo atendenteRepo;

    
    public Atendente findById(Long id) {
        Optional<Atendente> atendenteOpt = atendenteRepo.findById(id);
        return atendenteOpt.get();

    }

    public List<Atendente> findAll() {
        return atendenteRepo.findAll();

    }

    public void save(Atendente atendente) {
        atendenteRepo.save(atendente);

    }

    public void delete(Atendente atendente) {
        atendenteRepo.delete(atendente);
    }
    
    public AtendenteRepo getAtendenteRepo() {
        return atendenteRepo;
    }

    public void setAtendenteRepo(AtendenteRepo atendenteRepo) {
        this.atendenteRepo = atendenteRepo;
    }
}