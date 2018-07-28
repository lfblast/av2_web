package br.edu.infnet.av2.controller.converter;

import br.edu.infnet.av2.model.Motoboy;
import br.edu.infnet.av2.service.MotoboyService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MotoboyConverter implements Converter {

    @Autowired
    MotoboyService motoboyService;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        return motoboyService.findById(new Long(value));
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        if (value != null) {
            return Long.toString(((Motoboy) value).getId());
        }
        return null;
    }
}