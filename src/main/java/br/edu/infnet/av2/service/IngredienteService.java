package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.repository.IngredienteRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
    
    @Autowired
    private IngredienteRepo ingredienteRepo;
    
    public Ingrediente findById(Long id) {
        Optional<Ingrediente> ingredienteOpt = ingredienteRepo.findById(id);
        return ingredienteOpt.get();

    }

    public List<Ingrediente> findAll() {
        return ingredienteRepo.findAll();
    }

    public void save(Ingrediente ingrediente) {
        ingredienteRepo.save(ingrediente);
    }

    public void delete(Ingrediente ingrediente) {
        ingredienteRepo.delete(ingrediente);
    }

    public IngredienteRepo getIngredienteRepo() {
        return ingredienteRepo;
    }

    public void setIngredienteRepo(IngredienteRepo ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }
}