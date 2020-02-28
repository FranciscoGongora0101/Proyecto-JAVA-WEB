/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Estado;
import Facade.EstadoFacade;
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
@Named(value = "estadoController")
@SessionScoped
public class EstadoController implements Serializable {

    @EJB
    private EstadoFacade estadoFacade;
    private Estado estado = new Estado();
    private boolean confirm = false;

    public List<Estado> findAll() {
        return estadoFacade.findAll();
    }

    public List<Estado> findAll2() {
        return estadoFacade.findAll2();
    }

    public Estado findID() {
        return estadoFacade.findID(1L);
    }

    public Estado findID2() {
        return estadoFacade.findID2(1L);
    }

    public Estado find(Long id) {
        return estadoFacade.find(id);
    }

    public String insert() {
        FacesMessage msj;
        try {
            estadoFacade.insert(estado);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + estado.getNombre() + " fue añadido exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + estado.getNombre() + " no pudo ser añadido. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);

        }
        return "estadosAlta";
    }

    public String prepareEdit(Estado a) {
        estado = a;
        return "estadosEdit";
    }

    public String update() {
       FacesMessage msj;
        try {
            estadoFacade.update(estado);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + estado.getNombre() + " fue actualizado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + estado.getNombre() + " no pudo ser actualizado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);

        }
        return "";
    }

    public void clean() {
        estado = new Estado();
    }

    public String mainClean(String url) {
        estado = new Estado();
        setConfirm(false);
        return url;
    }

    public String prepareDelete() {
        setConfirm(true);
        return "estadosList";
    }

    public void delete(Estado p) {
        FacesMessage msj;
        try {
            if (p.getEstadoList().isEmpty()) {
                estado = p;
                estadoFacade.delete(estado);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + p.getNombre() + " fue eliminado exitosamente.", "");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " tiene ciudades registradas.", "");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " no pudo ser eliminado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("estadosList", msj);

        }
        mainClean("estadosList");
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
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
