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
}
