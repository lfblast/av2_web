package br.edu.infnet.av2.controller;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {

    private static final long serialVersionUID = 1L;

    public String showPage() {
        Logger.getAnonymousLogger().log(Level.INFO, "PASSOU SHOW PAGE");
        return "index";        
    }
}
