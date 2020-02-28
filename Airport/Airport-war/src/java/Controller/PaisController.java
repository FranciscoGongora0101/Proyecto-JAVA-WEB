/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Pais;
import Facade.PaisFacade;
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
@Named(value = "paisController")
@SessionScoped
public class PaisController implements Serializable {

    @EJB
    private PaisFacade paisFacade;
    private Pais pais = new Pais();
    private boolean confirm = false;

    public List<Pais> findAll() {
        return paisFacade.findAll();
    }

    public List<Pais> findAll2() {
        return paisFacade.findAll2();
    }

    public Pais findID() {
        return paisFacade.findID(1L);
    }

    public Pais findID2() {
        return paisFacade.findID2(1L);
    }

    public Pais findNombre() {
        return paisFacade.findNombre("Mexico");
    }

    public Pais find(Long id) {
        return paisFacade.find(id);
    }

    public String insert() {
        FacesMessage msj;
        try {
            paisFacade.insert(pais);

            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + pais.getNombre() + " fue añadido exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + pais.getNombre() + " no pudo ser añadido. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);

        }
        return "paisesAlta";

    }

    public String prepareEdit(Pais a) {
        pais = a;
        return "paisesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            paisFacade.update(pais);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + pais.getNombre() + " fue actualizado exitosamente.", "");
            FacesContext.getCurrentInstance().addMessage("paisesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + pais.getNombre() + " no pudo ser actualizado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("paisesEdit", msj);

        }
        return "";
    }

    public void clean() {
        pais = new Pais();
    }

    public String mainClean(String url) {
        pais = new Pais();
        setConfirm(false);
        return url;
    }

    public String prepareDelete() {
        setConfirm(true);
        return "paisesList";
    }

    public void delete(Pais p) {
        FacesMessage msj;
        try {
            if (p.getPaisList().isEmpty()) {
                pais = p;
                paisFacade.delete(pais);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de" + p.getNombre() + " fue eliminado exitosamente.", "");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " tiene estados registrados.", "");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de" + p.getNombre() + " no pudo ser eliminado. Contacte a soporte :) ", "");
            FacesContext.getCurrentInstance().addMessage("paisesList", msj);

        }
        mainClean("paisesList");
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
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
