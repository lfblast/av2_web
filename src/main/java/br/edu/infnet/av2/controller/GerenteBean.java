package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Gerente;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.repository.GerenteRepo;
import br.edu.infnet.av2.repository.PapelRepo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("session")
public class GerenteBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private GerenteRepo gerenteRepo;
    @Autowired
    private PapelRepo papelRepo;
    private List<Gerente> gerentes;
    private Gerente gerente = new Gerente();
    
    public String listar() {
        
        gerente = new Gerente();
        gerentes = gerenteRepo.findAll();        
        
        return "/gerente/ConsultaGerentes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idGer");
        
        Optional<Gerente> gerenteOpt = gerenteRepo.findById(new Long(id));
        gerente = gerenteOpt.get();
        
        return "/gerente/DetalhesGerente?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelGerente = papelRepo.findByNomePapel("ROLE_GERENTE");
        gerente.getPapeis().add(papelGerente);
        gerenteRepo.save(gerente);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idGer");
        
        Optional<Gerente> gerenteOpt = gerenteRepo.findById(new Long(id));
        Gerente ingr = gerenteOpt.get();
        
        gerenteRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }

    public GerenteRepo getGerenteRepo() {
        return gerenteRepo;
    }

    public void setGerenteRepo(GerenteRepo gerenteRepo) {
        this.gerenteRepo = gerenteRepo;
    }

    public PapelRepo getPapelRepo() {
        return papelRepo;
    }

    public void setPapelRepo(PapelRepo papelRepo) {
        this.papelRepo = papelRepo;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}