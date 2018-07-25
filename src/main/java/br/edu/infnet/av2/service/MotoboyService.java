package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.repository.MotoboyRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoboyService {
    
    @Autowired
    private MotoboyRepo motoboyRepo;
    
    public Motoboy findById(Long id) {
        Optional<Motoboy> motoboyOpt = motoboyRepo.findById(id);
        return motoboyOpt.get();
    }

    public List<Motoboy> findAll() {
        return motoboyRepo.findAll();
    }

    public void save(Motoboy motoboy) {
        motoboyRepo.save(motoboy);
    }

    public void delete(Motoboy motoboy) {
        motoboyRepo.delete(motoboy);
    }

    public MotoboyRepo getMotoboyRepo() {
        return motoboyRepo;
    }

    public void setMotoboyRepo(MotoboyRepo motoboyRepo) {
        this.motoboyRepo = motoboyRepo;
    }
}