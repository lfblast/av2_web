package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import static br.edu.infnet.av2.controller.util.ControllerUtil.recuperaParametro;
import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.service.IngredienteService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
	
@Component
@Scope("session")
public class IngredienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private IngredienteService Ingredienteservice;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingrediente = new Ingrediente();
    
    public String listar() {
        
        ingrediente = new Ingrediente();
        ingredientes = Ingredienteservice.findAll();        
        
        return "/ingrediente/ConsultaIngredientes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idIngr");
        ingrediente = Ingredienteservice.findById(new Long(id));
        
        return "/ingrediente/DetalhesIngrediente?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        Ingredienteservice.save(ingrediente);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = ControllerUtil.recuperaParametro("idIngr");
        Ingrediente ingredienteCadastrado = Ingredienteservice.findById(new Long(id));
        
        ingredienteCadastrado.setNome(ingrediente.getNome());
        Ingredienteservice.save(ingredienteCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idIngr");
        Ingrediente ingr = Ingredienteservice.findById(new Long(id));
        
        Ingredienteservice.delete(ingr);
        
        return listar();
    }
    
    public IngredienteService getIngredienteservice() {
        return Ingredienteservice;
    }

    public void setIngredienteservice(IngredienteService Ingredienteservice) {
        this.Ingredienteservice = Ingredienteservice;
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