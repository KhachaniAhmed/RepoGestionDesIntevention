package com.intervention.jpaJSFClasses;

import com.intervention.jpa.Entity.Operateur;
import com.intervention.jpaJSFClasses.util.JsfUtil;
import com.intervention.jpaJSFClasses.util.JsfUtil.PersistAction;
import com.intervention.jpa.sessionBean.OperateurFacade;

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

@Named("operateurController")
@SessionScoped
public class OperateurController implements Serializable {

    @EJB
    private com.intervention.jpa.sessionBean.OperateurFacade ejbFacade;
    private List<Operateur> items = null;
    private Operateur selected;

    public OperateurController() {
    }

    public Operateur getSelected() {
        return selected;
    }

    public void setSelected(Operateur selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OperateurFacade getFacade() {
        return ejbFacade;
    }

    public Operateur prepareCreate() {
        selected = new Operateur();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Resources/Bundle").getString("OperateurCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Resources/Bundle").getString("OperateurUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Resources/Bundle").getString("OperateurDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Operateur> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Operateur getOperateur(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Operateur> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Operateur> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Operateur.class)
    public static class OperateurControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OperateurController controller = (OperateurController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "operateurController");
            return controller.getOperateur(getKey(value));
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
            if (object instanceof Operateur) {
                Operateur o = (Operateur) object;
                return getStringKey(o.getMatriculeoperateur());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Operateur.class.getName()});
                return null;
            }
        }

    }

}
