package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.repository.PapelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PapelService {
    
    @Autowired
    private PapelRepo papelRepo;
    
    public Papel findByNomePapel(String nomePapel) {
        return papelRepo.findByNomePapel(nomePapel);
    }
}