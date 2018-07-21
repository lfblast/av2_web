package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.repository.IngredienteRepo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
	
@Component
@Scope("session")
public class IngredienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private IngredienteRepo ingredienteRepo;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingrediente = new Ingrediente();
    
    public String listar() {
        
        ingrediente = new Ingrediente();
        ingredientes = ingredienteRepo.findAll();        
        
        return "ConsultaIngredientes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idIngr");
        
        Optional<Ingrediente> ingredienteOpt = ingredienteRepo.findById(new Long(id));
        ingrediente = ingredienteOpt.get();
        
        return "DetalhesIngrediente?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        ingredienteRepo.save(ingrediente);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = recuperaParametro("idIngr");
        
        Optional<Ingrediente> ingredienteOpt = ingredienteRepo.findById(new Long(id));
        Ingrediente ingredienteCadastrado = ingredienteOpt.get();
        
        ingredienteCadastrado.setNome(ingrediente.getNome());
        ingredienteRepo.save(ingredienteCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idIngr");
        
        Optional<Ingrediente> ingredienteOpt = ingredienteRepo.findById(new Long(id));
        Ingrediente ingr = ingredienteOpt.get();
        
        ingredienteRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
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