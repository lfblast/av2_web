package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.repository.IngredienteRepo;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Ingrediente ingrediente;
    
    public void listar() {
        Logger.getAnonymousLogger().log(Level.INFO, "PASSOU LISTAR");
        this.ingredientes = ingredienteRepo.findAll();
    }
    
    public String remover() {
//        ingredienteRepo.delete(ingrediente);
        Logger.getAnonymousLogger().log(Level.SEVERE, "TESTANDO");
        return "ok";
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

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}