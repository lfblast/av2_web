package br.edu.infnet.av2.controller.converter;

import br.edu.infnet.av2.model.Endereco;
import br.edu.infnet.av2.service.EnderecoService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter implements Converter {

    @Autowired
    EnderecoService enderecoService;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return enderecoService.findById(new Long(value));
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        if (value != null) {
            return Long.toString(((Endereco) value).getId());
        }
        return null;
    }
}