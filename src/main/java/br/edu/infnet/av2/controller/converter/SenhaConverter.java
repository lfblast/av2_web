package br.edu.infnet.av2.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@FacesConverter("SenhaConverter")
public class SenhaConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        Object senha = null;
        if (value != null && !"".equals(value)) {

            senha = new BCryptPasswordEncoder().encode(value);
        }

        return senha;
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        String senha = "";
        if (value != null) {

            senha = new BCryptPasswordEncoder().encode(value.toString());
        }

        return senha;
    }
}