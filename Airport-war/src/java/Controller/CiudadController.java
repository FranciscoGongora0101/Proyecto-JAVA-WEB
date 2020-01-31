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

}
