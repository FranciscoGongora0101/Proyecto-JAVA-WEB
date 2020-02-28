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
import javax.faces.context.FacesContext;

/**
 *
 * @author josefrancisco
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    private String nombre, contrasena;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String inicioSesion() {
        Usuario usuarioActual = getUsuarioFacade().
                findByEmailAndPass(getNombre(), getContrasena());

        if (usuarioActual == null) {
            System.out.println("Usuario o contraseña incorrecta");
            return null;
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesionUsuario", usuarioActual);
            return "index";
        }
    }

    public boolean usuarioLogeado() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sesionUsuario");

        return usuario != null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesionUsuario", null);
        return "/login";
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
