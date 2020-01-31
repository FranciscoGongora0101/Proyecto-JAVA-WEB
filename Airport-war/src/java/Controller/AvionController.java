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

}
