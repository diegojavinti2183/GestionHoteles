package com.gestionhoteles.controladores;

import com.gestionhoteles.entidades.Tipohabitaciones;
import com.gestionhoteles.controladores.util.JsfUtil;
import com.gestionhoteles.controladores.util.JsfUtil.PersistAction;
import com.gestionhoteles.servicios.TipohabitacionesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tipohabitacionesController")
@SessionScoped
public class TipohabitacionesController implements Serializable {

    @EJB
    private com.gestionhoteles.servicios.TipohabitacionesFacade ejbFacade;
    private List<Tipohabitaciones> items = null;
    private Tipohabitaciones selected;

    public TipohabitacionesController() {
    }

    public Tipohabitaciones getSelected() {
        return selected;
    }

    public void setSelected(Tipohabitaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipohabitacionesFacade getFacade() {
        return ejbFacade;
    }

    public Tipohabitaciones prepareCreate() {
        selected = new Tipohabitaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TipohabitacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TipohabitacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TipohabitacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tipohabitaciones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Tipohabitaciones getTipohabitaciones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Tipohabitaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tipohabitaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tipohabitaciones.class)
    public static class TipohabitacionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipohabitacionesController controller = (TipohabitacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipohabitacionesController");
            return controller.getTipohabitaciones(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tipohabitaciones) {
                Tipohabitaciones o = (Tipohabitaciones) object;
                return getStringKey(o.getTipCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tipohabitaciones.class.getName()});
                return null;
            }
        }

    }

}
