package br.edu.infnet.av2.controller.converter;

import br.edu.infnet.av2.model.Cliente;
import br.edu.infnet.av2.service.ClienteService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClienteConverter implements Converter {

    @Autowired
    ClienteService clienteService;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
              
            return clienteService.findById(new Long(value));        
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        if (value != null) {
            return Long.toString(((Cliente) value).getId());
        }
        return null;
    }
}