package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Atendente;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.repository.AtendenteRepo;
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
public class AtendenteBean implements Serializable {    
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private AtendenteRepo atendenteRepo;
    @Autowired
    private PapelRepo papelRepo;
    private List<Atendente> atendentes;
    private Atendente atendente = new Atendente();
    
    public String listar() {
        
        atendente = new Atendente();
        atendentes = atendenteRepo.findAll();        
        
        return "/atendente/ConsultaAtendentes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idAtend");
        
        Optional<Atendente> atendenteOpt = atendenteRepo.findById(new Long(id));
        atendente = atendenteOpt.get();
        
        return "/atendente/DetalhesAtendente?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelAtendente = papelRepo.findByNomePapel("ROLE_ATENDENTE");
        atendente.getPapeis().add(papelAtendente);
        atendenteRepo.save(atendente);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idAtend");
        
        Optional<Atendente> atendenteOpt = atendenteRepo.findById(new Long(id));
        Atendente ingr = atendenteOpt.get();
        
        atendenteRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }

    public AtendenteRepo getAtendenteRepo() {
        return atendenteRepo;
    }

    public void setAtendenteRepo(AtendenteRepo atendenteRepo) {
        this.atendenteRepo = atendenteRepo;
    }

    public PapelRepo getPapelRepo() {
        return papelRepo;
    }

    public void setPapelRepo(PapelRepo papelRepo) {
        this.papelRepo = papelRepo;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(List<Atendente> atendentes) {
        this.atendentes = atendentes;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
}