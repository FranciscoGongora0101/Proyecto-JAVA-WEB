/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Vuelo;
import Facade.VueloFacade;
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
@Named(value = "vueloController")
@SessionScoped
public class VueloController implements Serializable {

    @EJB
    private VueloFacade vueloFacade;
    private Vuelo vuelo = new Vuelo();
    private boolean confirm = false;

    public List<Vuelo> findAll() {
        return vueloFacade.findAll();
    }

    public List<Vuelo> findAll2() {
        return vueloFacade.findAll2();
    }

    public Vuelo findID() {
        return vueloFacade.findID(1L);
    }

    public Vuelo findID2() {
        return vueloFacade.findID2(1L);
    }

    public Vuelo findNumVuelo() {
        return vueloFacade.findNumVuelo("230");
    }

    public String insert() {
        FacesMessage msj;
        try {
            vueloFacade.insert(vuelo);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + vuelo.getNumero_Vuelo() + " fue añadido exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + vuelo.getNumero_Vuelo() + " no pudo ser añadido. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);

        }
        return "vuelosAlta";
    }

    public String prepareEdit(Vuelo a) {
        vuelo = a;
        return "vuelosEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            vueloFacade.update(vuelo);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + vuelo.getNumero_Vuelo() + " fue actualizado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + vuelo.getNumero_Vuelo() + " no pudo ser actualizado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);

        }
        return "";
    }

    public void clean() {
        vuelo = new Vuelo();
    }

    public String mainClean(String url) {
        vuelo = new Vuelo();
        setConfirm(false);
        return url;
    }

    public String prepareDelete() {
        setConfirm(true);
        return "vuelosList";
    }

    public void delete(Vuelo p) {
        FacesMessage msj;
        try {
            vuelo = p;
            vueloFacade.delete(vuelo);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + p.getNumero_Vuelo() + " fue eliminado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNumero_Vuelo() + " no pudo ser eliminado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);

        }
        mainClean("vuelosList");
    }

    /**
     * @return the vuelo
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * @param vuelo the vuelo to set
     */
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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
