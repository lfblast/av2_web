package br.edu.infnet.av2.controller.util;

import java.util.Map;
import javax.faces.context.FacesContext;


public class ControllerUtil {
    
        public static String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }
}