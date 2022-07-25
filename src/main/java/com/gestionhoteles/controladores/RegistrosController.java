package com.gestionhoteles.controladores;

import com.gestionhoteles.entidades.Registros;
import com.gestionhoteles.controladores.util.JsfUtil;
import com.gestionhoteles.controladores.util.JsfUtil.PersistAction;
import com.gestionhoteles.entidades.Detalleregistro;
import com.gestionhoteles.entidades.Habitaciones;
import com.gestionhoteles.servicios.DetalleregistroFacade;
import com.gestionhoteles.servicios.HabitacionesFacade;
import com.gestionhoteles.servicios.RegistrosFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

@Named("registrosController")
@SessionScoped
public class RegistrosController implements Serializable {

    @EJB
    private com.gestionhoteles.servicios.RegistrosFacade ejbFacade;
    @EJB
    private com.gestionhoteles.servicios.DetalleregistroFacade ejbFacade2;
    @EJB
    private com.gestionhoteles.servicios.HabitacionesFacade ejbFacade3;
    private List<Registros> items = null;
    private List<Detalleregistro> itemsDetalle = null;
    private List<Habitaciones> itemsHabitaciones = null;
    private Registros selected;
    private Detalleregistro selectedDetalle;

    public RegistrosController() {
    }

    public Registros getSelected() {
        return selected;
    }

    public void setSelected(Registros selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RegistrosFacade getFacade() {
        return ejbFacade;
    }

    private DetalleregistroFacade getFacade2() {
        return ejbFacade2;
    }

    private HabitacionesFacade getFacade3() {
        return ejbFacade3;
    }

    public Registros prepareCreate() {
        setSelected(new Registros());
        setSelectedDetalle(new Detalleregistro());
        itemsDetalle = new ArrayList<>();
        getSelected().setRegFecha(new Date());
        getSelected().setRegFechainicio(new Date());
        itemsHabitaciones = getFacade3().registroHabitaciones(new Date());
        initializeEmbeddableKey();
        return getSelected();
    }

    public void create() {
        selected.setRegUsuarioing("root");
        selected.setRegFechaing(new Date());
        selected.setRegUsuariomod("root");
        selected.setRegFechamod(new Date());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RegistrosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            for (Detalleregistro detalle : itemsDetalle) {
                getFacade2().create(detalle);
            }
            setItems(null);    // Invalidate list of items to trigger re-query.
        }
    }

    public void agregar() {
        System.out.println("selectedDetalle " + selectedDetalle.getDregObservacion());
        selectedDetalle.setDregRegistro(selected);
        itemsDetalle.add(selectedDetalle);
        setSelectedDetalle(new Detalleregistro());
        if (!JsfUtil.isValidationFailed()) {
            itemsHabitaciones = getFacade3().registroHabitaciones(new Date());
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RegistrosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RegistrosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            setSelected(null); // Remove selection
            setItems(null);    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Registros> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (getSelected() != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(getSelected());
                } else {
                    getFacade().remove(getSelected());
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

    public Registros getRegistros(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Registros> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Registros> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Registros.class)
    public static class RegistrosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RegistrosController controller = (RegistrosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "registrosController");
            return controller.getRegistros(getKey(value));
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
            if (object instanceof Registros) {
                Registros o = (Registros) object;
                return getStringKey(o.getRegNumero());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Registros.class.getName()});
                return null;
            }
        }

    }

    public void setItems(List<Registros> items) {
        this.items = items;
    }

    public List<Detalleregistro> getItemsDetalle() {
        return itemsDetalle;
    }

    public void setItemsDetalle(List<Detalleregistro> itemsDetalle) {
        this.itemsDetalle = itemsDetalle;
    }

    public Detalleregistro getSelectedDetalle() {
        return selectedDetalle;
    }

    public void setSelectedDetalle(Detalleregistro selectedDetalle) {
        this.selectedDetalle = selectedDetalle;
    }

    public List<Habitaciones> getItemsHabitaciones() {
        return itemsHabitaciones;
    }

    public void setItemsHabitaciones(List<Habitaciones> itemsHabitaciones) {
        this.itemsHabitaciones = itemsHabitaciones;
    }

}
