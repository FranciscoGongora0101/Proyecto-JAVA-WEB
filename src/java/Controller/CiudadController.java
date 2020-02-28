/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ciudad;
import Facade.CiudadFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author josefrancisco
 */
@Named(value = "ciudadController")
@SessionScoped
public class CiudadController implements Serializable {

    @EJB
    private CiudadFacade ciudadFacade;
    private Ciudad ciudad = new Ciudad();
    private boolean confirm = false;

    public List<Ciudad> findAll() {
        return ciudadFacade.findAll();
    }

    public List<Ciudad> findAll2() {
        return ciudadFacade.findAll2();
    }

    public Ciudad findID() {
        return ciudadFacade.findID(1L);
    }

    public Ciudad findID2() {
        return ciudadFacade.findID2(1L);
    }

    public Ciudad findPais() {
        return ciudadFacade.findPais("Mexico");
    }

    public Ciudad findEstado() {
        return ciudadFacade.findEstado("Nuevo Leon");
    }

    public String insert() {
        FacesMessage msj;
        try {
            ciudadFacade.insert(ciudad);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + ciudad.getNombre() + " fue añadido exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + ciudad.getNombre() + " no pudo ser añadido. Contacte a soporte.", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
        }
        return "ciudadesAlta";
    }

    public String prepareEdit(Ciudad a) {
        ciudad = a;
        return "ciudadesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            ciudadFacade.update(ciudad);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + ciudad.getNombre() + " fue actualizado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + ciudad.getNombre() + " no se pudo actualizar.", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        }
        return "";
    }

    public void clean() {
        ciudad = new Ciudad();
    }

    public String mainClean(String url) {
        ciudad = new Ciudad();
        setConfirm(false);
        return url;
    }

    public Ciudad find(Long id) {
        return ciudadFacade.find(id);
    }

    public String prepareDelete() {
        setConfirm(true);
        return "ciudadesList";
    }

    public void delete(Ciudad p) {
        FacesMessage msj;
        try {
            if (p.getDestinoList().isEmpty() && p.getOrigenList().isEmpty()) {
                ciudad = p;
                ciudadFacade.delete(ciudad);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + p.getNombre() + " fue eliminado exitosamente.", "");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " tiene vuelos programados.", "");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " no pudo ser eliminado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);

        }
        mainClean("ciudadesList");
    }

    /**
     * @return the ciudad
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the confirm
     */
    public boolean isConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

}
