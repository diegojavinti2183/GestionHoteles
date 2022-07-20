/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionhoteles.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Diego Ruiz
 */
@FacesConverter("objetoConverter")
public class ObjetosConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String nombreObjeto = "";
        if (value != null) {            
            nombreObjeto = "" + value;
        }
        return nombreObjeto;
    }

}
