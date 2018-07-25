package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Produto;
import br.edu.infnet.av2.repository.ProdutoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepo produtoRepo;
    
    public Produto findById(Long id) {
        Optional<Produto> produtoOpt = produtoRepo.findById(id);
        return produtoOpt.get();
    }

    public List<Produto> findAll() {
        return produtoRepo.findAll();
    }

    public void save(Produto produto) {
        produtoRepo.save(produto);
    }

    public void delete(Produto produto) {
        produtoRepo.delete(produto);
    }

    public ProdutoRepo getProdutoRepo() {
        return produtoRepo;
    }

    public void setProdutoRepo(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }
}