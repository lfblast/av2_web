package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Categoria;
import br.edu.infnet.av2.service.CategoriaService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class CategoriaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private CategoriaService categoriaService;
    private List<Categoria> categorias;
    private Categoria categoria = new Categoria();
    
    public String listar() {
        
        categoria = new Categoria();
        categorias = categoriaService.findAll();        
        
        return "/categoria/ConsultaCategorias?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = ControllerUtil.recuperaParametro("idCat");
        categoria = categoriaService.findById(new Long(id));
        
        return "/categoria/DetalhesCategoria?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        categoriaService.save(categoria);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = ControllerUtil.recuperaParametro("idCat");        
        Categoria categoriaCadastrado = categoriaService.findById(new Long(id));
        
        categoriaCadastrado.setNome(categoria.getNome());
        categoriaService.save(categoriaCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idCat");
        
        Categoria cat = categoriaService.findById(new Long(id));                
        categoriaService.delete(cat);
        
        return listar();
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
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