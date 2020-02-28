/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

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
public class VueloFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    public List<Vuelo> findAll() {
        TypedQuery<Vuelo> query;
        query = em.createQuery("SELECT c FROM Vuelo c", Vuelo.class);
        return query.getResultList();
    }

    public List<Vuelo> findAll2() {
        Query query;
        query = em.createNamedQuery("findVuelo");
        return query.getResultList();
    }

    public Vuelo findID(Long idParameter) {
        TypedQuery<Vuelo> query;
        query = em.createQuery("SELECT c FROM Vuelo c WHERE c.id=:id", Vuelo.class);
        query.setParameter("id", idParameter);
        return query.getSingleResult();
    }

    public Vuelo findID2(Long idParameter) {
        Query query;
        query = em.createNamedQuery("findIDNQV");
        query.setParameter("id", idParameter);
        return (Vuelo) query.getSingleResult();
    }

    public Vuelo findNumVuelo(String numero) {
        TypedQuery<Vuelo> query;
        query = em.createQuery("SELECT c FROM Vuelo c WHERE c.Numero_Vuelo=:num", Vuelo.class);
        query.setParameter("num", numero);
        return query.getSingleResult();
    }

    public void insert(Vuelo p) {
        em.persist(p);
    }

    public void update(Vuelo p) {
        em.merge(p);
    }

    public void delete(Vuelo p) {
        em.remove(em.merge(p));
    }
}
