/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Controller.PaisController;
import Entity.Pais;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author josefrancisco
 */
@FacesConverter(forClass=Pais.class)
public class PaisConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        PaisController paisController = context.getApplication().evaluateExpressionGet(context, "#{paisController}", PaisController.class);
        return paisController.find(Long.parseLong(value));
                
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Pais pais = (Pais) value;
       return pais.getId().toString();
    }
}
