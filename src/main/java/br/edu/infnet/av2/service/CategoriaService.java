package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Categoria;
import br.edu.infnet.av2.repository.CategoriaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepo categoriaRepo;
    
    public Categoria findById(Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepo.findById(id);
        return categoriaOpt.get();
    }

    public List<Categoria> findAll() {
        return categoriaRepo.findAll();
    }

    public void save(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    public void delete(Categoria categoria) {
        categoriaRepo.delete(categoria);
    }

    public CategoriaRepo getCategoriaRepo() {
        return categoriaRepo;
    }

    public void setCategoriaRepo(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }
}