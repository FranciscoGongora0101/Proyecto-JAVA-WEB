/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author josefrancisco
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuarioActual;

    public UsuarioController() {
        usuarioActual = new Usuario();
    }

    public void create() {
        usuarioFacade.create(usuarioActual);
    }

    /**
     * @return the usuarioFacade
     */
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    /**
     * @param usuarioFacade the usuarioFacade to set
     */
    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    /**
     * @return the usuarioActual
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * @param usuarioActual the usuarioActual to set
     */
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

}
