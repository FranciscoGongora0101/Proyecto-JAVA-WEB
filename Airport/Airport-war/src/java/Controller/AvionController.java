/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Avion;
import Facade.AvionFacade;
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
@Named(value = "avionController")
@SessionScoped
public class AvionController implements Serializable {

    @EJB
    private AvionFacade avionFacade;
    private Avion avion = new Avion();
    private boolean confirm = false;

    public List<Avion> findAll() {
        return avionFacade.findAll();
    }

    public List<Avion> findAll2() {
        return avionFacade.findAll2();
    }

    public Avion findID() {
        return avionFacade.findID(1L);
    }

    public Avion findID2() {
        return avionFacade.findID2(1L);
    }

    public Avion findNumVuelo() {
        return avionFacade.findNumVuelo("2020");
    }

    public Avion findNumAvionyPasajeros() {
        return avionFacade.findNumAvionyPasajeros("20000", 100);
    }

    public String insert() {
        FacesMessage msj;
        try {
            avionFacade.insert(avion);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + avion.getNumero_Avion() + " fue añadido exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + avion.getNumero_Avion() + " no pudo ser añadido. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);

        }
        return "avionesAlta";
    }

    public String prepareEdit(Avion a) {
        avion = a;
        return "avionesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            avionFacade.update(avion);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + avion.getNumero_Avion() + " fue actualizado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + avion.getNumero_Avion() + " no pudo ser actualizado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);

        }
        return "";
    }

    public void clean() {
        avion = new Avion();
    }

    public String mainClean(String url) {
        avion = new Avion();
        setConfirm(false);
        return url;
    }

    public Avion find(Long id) {
        return avionFacade.find(id);
    }

    public String prepareDelete() {
        setConfirm(true);
        return "avionesList";
    }

    public void delete(Avion p) {
        FacesMessage msj;
        try {
            if (p.getAvionList().isEmpty()) {
                avion = p;
                avionFacade.delete(avion);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + p.getNumero_Avion() + " fue eliminado exitosamente.", "");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNumero_Avion() + " tiene vuelos programados.", "");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNumero_Avion() + " no pudo ser eliminado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("avionesList", msj);

        }
        mainClean("avionesList");
    }

    /**
     * @return the avion
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * @param avion the avion to set
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
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
