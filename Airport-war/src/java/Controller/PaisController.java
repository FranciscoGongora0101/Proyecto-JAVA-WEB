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

}
