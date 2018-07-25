package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Atendente;
import br.edu.infnet.av2.model.Papeis;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.service.AtendenteService;
import br.edu.infnet.av2.service.PapelService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("session")
public class AtendenteBean implements Serializable {    
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private AtendenteService atendenteService;
    @Autowired
    private PapelService papelService;
    private List<Atendente> atendentes;
    private Atendente atendente = new Atendente();
    
    public String listar() {
        
        atendente = new Atendente();
        atendentes = atendenteService.findAll();        
        
        return "/atendente/ConsultaAtendentes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = ControllerUtil.recuperaParametro("idAtend");
        atendente = atendenteService.findById(new Long(id));
        
        return "/atendente/DetalhesAtendente?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelAtendente = papelService.findByNomePapel(Papeis.ROLE_ATENDENTE.toString());
        atendente.getPapeis().add(papelAtendente);
        atendenteService.save(atendente);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idAtend");
        
        Atendente atend = atendenteService.findById(new Long(id));
        
        atendenteService.delete(atend);
        
        return listar();
    }

    public AtendenteService getAtendenteService() {
        return atendenteService;
    }

    public void setAtendenteService(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    public PapelService getPapelService() {
        return papelService;
    }

    public void setPapelService(PapelService papelService) {
        this.papelService = papelService;
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