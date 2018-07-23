package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.model.Papel;
import br.edu.infnet.av2.repository.MotoboyRepo;
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
public class MotoboyBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private MotoboyRepo motoboyRepo;
    @Autowired
    private PapelRepo papelRepo;
    private List<Motoboy> motoboys;
    private Motoboy motoboy = new Motoboy();
    
    public String listar() {
        
        motoboy = new Motoboy();
        motoboys = motoboyRepo.findAll();        
        
        return "/motoboy/ConsultaMotoboys?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idMoto");
        
        Optional<Motoboy> motoboyOpt = motoboyRepo.findById(new Long(id));
        motoboy = motoboyOpt.get();
        
        return "/motoboy/DetalhesMotoboy?faces-redirect=true";
    }
    
    @Transactional(readOnly = false)
    public String cadastrar() {
        
        Papel papelMotoboy = papelRepo.findByNomePapel("ROLE_USUARIO");
        motoboy.getPapeis().add(papelMotoboy);
        motoboyRepo.save(motoboy);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idMoto");
        
        Optional<Motoboy> motoboyOpt = motoboyRepo.findById(new Long(id));
        Motoboy ingr = motoboyOpt.get();
        
        motoboyRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }

    public MotoboyRepo getMotoboyRepo() {
        return motoboyRepo;
    }

    public void setMotoboyRepo(MotoboyRepo motoboyRepo) {
        this.motoboyRepo = motoboyRepo;
    }

    public PapelRepo getPapelRepo() {
        return papelRepo;
    }

    public void setPapelRepo(PapelRepo papelRepo) {
        this.papelRepo = papelRepo;
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