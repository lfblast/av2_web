package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Categoria;
import br.edu.infnet.av2.repository.CategoriaRepo;
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
public class CategoriaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private CategoriaRepo categoriaRepo;
    private List<Categoria> categorias;
    private Categoria categoria = new Categoria();
    
    public String listar() {
        
        categoria = new Categoria();
        categorias = categoriaRepo.findAll();        
        
        return "ConsultaCategorias?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idCat");
        
        Optional<Categoria> categoriaOpt = categoriaRepo.findById(new Long(id));
        categoria = categoriaOpt.get();
        
        return "DetalhesCategoria?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        categoriaRepo.save(categoria);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = recuperaParametro("idCat");
        
        Optional<Categoria> categoriaOpt = categoriaRepo.findById(new Long(id));
        Categoria categoriaCadastrado = categoriaOpt.get();
        
        categoriaCadastrado.setNome(categoria.getNome());
        categoriaRepo.save(categoriaCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idCat");
        
        Optional<Categoria> categoriaOpt = categoriaRepo.findById(new Long(id));
        Categoria ingr = categoriaOpt.get();
        
        categoriaRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }
    
    public CategoriaRepo getCategoriaRepo() {
        return categoriaRepo;
    }

    public void setCategoriaRepo(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}