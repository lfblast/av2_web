package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Gerente;
import br.edu.infnet.av2.model.Papeis;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.service.GerenteService;
import br.edu.infnet.av2.service.PapelService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("session")
public class GerenteBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private GerenteService gerenteService;
    @Autowired
    private PapelService papelService;
    private List<Gerente> gerentes;
    private Gerente gerente = new Gerente();
    
    public String listar() {
        
        gerente = new Gerente();
        gerentes = gerenteService.findAll();        
        
        return "/gerente/ConsultaGerentes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = ControllerUtil.recuperaParametro("idGer");
        gerente = gerenteService.findById(new Long(id));
        
        return "/gerente/DetalhesGerente?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelGerente = papelService.findByNomePapel(Papeis.ROLE_GERENTE.toString());
        gerente.getPapeis().add(papelGerente);
        gerenteService.save(gerente);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idGer");
        Gerente ger = gerenteService.findById(new Long(id));
        
        gerenteService.delete(ger);
        
        return listar();
    }

    public GerenteService getGerenteService() {
        return gerenteService;
    }

    public void setGerenteService(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    public PapelService getPapelService() {
        return papelService;
    }

    public void setPapelService(PapelService papelService) {
        this.papelService = papelService;
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