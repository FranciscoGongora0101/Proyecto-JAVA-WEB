/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Usuario;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author josefrancisco
 */
@Stateless
@LocalBean
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario findByEmailAndPass(String Contrasena, String Nombre) {
        TypedQuery<Usuario> query;
        query = em.createQuery("SELECT u FROM Usuario u WHERE u.Contasena =:Contrasena AND u.Nombre=:Nombre", Usuario.class);
        query.setParameter("Nombre", Nombre);
        query.setParameter("Contrasena", Contrasena);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

