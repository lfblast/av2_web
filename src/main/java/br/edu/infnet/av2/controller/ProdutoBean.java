package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Categoria;
import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.model.Produto;
import br.edu.infnet.av2.repository.CategoriaRepo;
import br.edu.infnet.av2.repository.IngredienteRepo;
import br.edu.infnet.av2.repository.ProdutoRepo;
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
public class ProdutoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProdutoRepo produtoRepo;
    @Autowired
    private CategoriaRepo categoriaRepo;
    @Autowired
    private IngredienteRepo ingredienteRepo;
    private List<Produto> produtos;
    private Produto produto = new Produto();
    private List<Categoria> categorias;
    private List <Ingrediente> ingredientes;
    
    public String listar() {
        
        produto = new Produto();
        produtos = produtoRepo.findAll();        
        
        return "ConsultaProdutos?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idProd");
        
        Optional<Produto> produtoOpt = produtoRepo.findById(new Long(id));
        produto = produtoOpt.get();
        
        return "DetalhesProduto?faces-redirect=true";
    }
    
    public String preparaCadastro() {
        
        categorias = categoriaRepo.findAll();
        ingredientes = ingredienteRepo.findAll();
        
        return "CadastroProduto?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        produtoRepo.save(produto);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = recuperaParametro("idProd");
        
        Optional<Produto> produtoOpt = produtoRepo.findById(new Long(id));
        Produto produtoCadastrado = produtoOpt.get();
        
        produtoCadastrado.setNome(produto.getNome());
        produtoRepo.save(produtoCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idProd");
        
        Optional<Produto> produtoOpt = produtoRepo.findById(new Long(id));
        Produto ingr = produtoOpt.get();
        
        produtoRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }
    
    public ProdutoRepo getProdutoRepo() {
        return produtoRepo;
    }

    public void setProdutoRepo(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    public CategoriaRepo getCategoriaRepo() {
        return categoriaRepo;
    }

    public void setCategoriaRepo(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    public IngredienteRepo getIngredienteRepo() {
        return ingredienteRepo;
    }

    public void setIngredienteRepo(IngredienteRepo ingredienteRepo) {
        this.ingredienteRepo = ingredienteRepo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}