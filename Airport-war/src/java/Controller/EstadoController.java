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
}
