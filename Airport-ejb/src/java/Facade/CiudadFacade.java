/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Ciudad;
import Entity.Vuelo;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author josefrancisco
 */
@Stateless
@LocalBean
public class CiudadFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    public List<Ciudad> findAll() {
        TypedQuery<Ciudad> query;
        query = em.createQuery("SELECT c FROM Ciudad c", Ciudad.class);
        return query.getResultList();
    }

    public List<Ciudad> findAll2() {
        Query query;
        query = em.createNamedQuery("findCiudad");
        return query.getResultList();
    }

    public Ciudad findID(Long idParameter) {
        TypedQuery<Ciudad> query;
        query = em.createQuery("SELECT c FROM Ciudad c WHERE c.id=:id", Ciudad.class);
        query.setParameter("id", idParameter);
        return query.getSingleResult();
    }

    public Ciudad findID2(Long idParameter) {
        Query query;
        query = em.createNamedQuery("findIDNQC");
        query.setParameter("id", idParameter);
        return (Ciudad) query.getSingleResult();
    }

    public Ciudad findEstado(String Estado) {
        TypedQuery<Ciudad> query;
        query = em.createQuery("SELECT c FROM Ciudad c WHERE c.Estado.Nombre=:est", Ciudad.class);
        query.setParameter("est", Estado);
        return query.getSingleResult();
    }

    public Ciudad findPais(String Pais) {
        Query query;
        query = em.createNamedQuery("findPaisC");
        query.setParameter("pais", Pais);
        return (Ciudad) query.getSingleResult();
    }
}
