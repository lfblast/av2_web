package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.model.Papeis;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.service.MotoboyService;
import br.edu.infnet.av2.service.PapelService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("session")
public class MotoboyBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private MotoboyService motoboyService;
    @Autowired
    private PapelService papelService;
    private List<Motoboy> motoboys;
    private Motoboy motoboy = new Motoboy();
    
    public String listar() {
        
        motoboy = new Motoboy();
        motoboys = motoboyService.findAll();        
        
        return "/motoboy/ConsultaMotoboys?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = ControllerUtil.recuperaParametro("idMoto");
        motoboy = motoboyService.findById(new Long(id));
        
        return "/motoboy/DetalhesMotoboy?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelMotoboy = papelService.findByNomePapel(Papeis.ROLE_USUARIO.toString());
        motoboy.getPapeis().add(papelMotoboy);
        motoboyService.save(motoboy);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idMoto");
        Motoboy ingr = motoboyService.findById(new Long(id));
        
        motoboyService.delete(ingr);
        
        return listar();
    }

    public MotoboyService getMotoboyService() {
        return motoboyService;
    }

    public void setMotoboyService(MotoboyService motoboyService) {
        this.motoboyService = motoboyService;
    }

    public PapelService getPapelService() {
        return papelService;
    }

    public void setPapelService(PapelService papelService) {
        this.papelService = papelService;
    }

    public List<Motoboy> getMotoboys() {
        return motoboys;
    }

    public void setMotoboys(List<Motoboy> motoboys) {
        this.motoboys = motoboys;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }
}