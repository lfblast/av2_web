package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import static br.edu.infnet.av2.controller.util.ControllerUtil.recuperaParametro;
import br.edu.infnet.av2.model.Categoria;
import br.edu.infnet.av2.model.Ingrediente;
import br.edu.infnet.av2.model.Produto;
import br.edu.infnet.av2.service.CategoriaService;
import br.edu.infnet.av2.service.IngredienteService;
import br.edu.infnet.av2.service.ProdutoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ProdutoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private IngredienteService ingredienteService;
    private List<Produto> produtos;
    private Produto produto = new Produto();
    private List<Categoria> categorias;
    private List <Ingrediente> ingredientes;
    private List<String> selectedIngr = new ArrayList<>();
    
    public String listar() {
        
        produto = new Produto();
        produto.setCategoria(new Categoria());
        produtos = produtoService.findAll();        
        
        return "/produto/ConsultaProdutos?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idProd");
        
        recuperaDadosCadastro();
        produto = produtoService.findById(new Long(id));
        
        selectedIngr = new ArrayList<>();
        for(Ingrediente ingr : produto.getIngredientes()) {
            Long idIngr = ingr.getId();            
            selectedIngr.add(idIngr.toString());
        }
        
        return "/produto/DetalhesProduto?faces-redirect=true";
    }
    
    public String preparaCadastro() {
        
        recuperaDadosCadastro();
        
        return "/produto/CadastroProduto?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        Categoria categoria = categoriaService.findById(produto.getCategoria().getId());
        produto.setCategoria(categoria);
        
        Optional<Ingrediente> ingredienteOpt;
        Ingrediente ingrediente;
        List<Ingrediente> ingr = new ArrayList<>();
        for(String id : selectedIngr) {
            ingrediente = ingredienteService.findById(new Long(id));
            ingr.add(ingrediente);
        }
        produto.setIngredientes(ingr);
        
        produtoService.save(produto);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = recuperaParametro("idProd");
        Produto produtoCadastrado = produtoService.findById(new Long(id));        
        Categoria categoria = categoriaService.findById(produto.getCategoria().getId());
        produto.setCategoria(categoria);
        
        Optional<Ingrediente> ingredienteOpt;
        Ingrediente ingrediente;
        List<Ingrediente> ingr = new ArrayList<>();
        for(String idIngr : selectedIngr) {            
            ingrediente = ingredienteService.findById(new Long(idIngr));
            ingr.add(ingrediente);
        }
        produto.setIngredientes(ingr);
        
        ingr = new ArrayList<>();
        for(Ingrediente ingrJaCadastrado : produtoCadastrado.getIngredientes()) {
            ingr.add(ingrJaCadastrado);
        }
        for(Ingrediente ingrRemover : ingr) {
            produtoCadastrado.getIngredientes().remove(ingrRemover);
        }        
        
        produtoCadastrado.setCodigo(produto.getCodigo());
        produtoCadastrado.setNome(produto.getNome());
        produtoCadastrado.setCategoria(produto.getCategoria());
        produtoCadastrado.setPreco(produto.getPreco());        
        for(Ingrediente ingrASerCadastrado : produto.getIngredientes()) {
            produtoCadastrado.getIngredientes().add(ingrASerCadastrado);
        }
        
        produtoService.save(produtoCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idProd");
        Produto ingr = produtoService.findById(new Long(id));
        
        produtoService.delete(ingr);
        
        return listar();
    }
    
    private void recuperaDadosCadastro() {
        
        categorias = categoriaService.findAll();
        ingredientes = ingredienteService.findAll();
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public IngredienteService getIngredienteService() {
        return ingredienteService;
    }

    public void setIngredienteService(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
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

    public List<String> getSelectedIngr() {
        return selectedIngr;
    }

    public void setSelectedIngr(List<String> selectedIngr) {
        this.selectedIngr = selectedIngr;
    }
}