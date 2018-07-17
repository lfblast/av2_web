package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.repository.IngredienteRepo;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
	
@Component
@Scope("request")
public class IngredienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Autowired
    private IngredienteRepo ingredienteRepo;
    private List<Ingrediente> ingredientes;
    
    public void listar() {
        this.ingredientes = ingredienteRepo.findAll();
    }

    public IngredienteRepo getIngredienteRepo() {
        return ingredienteRepo;
    }

    public void setIngredienteRepo(IngredienteRepo ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}