/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Estado;
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
public class EstadoFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    public List<Estado> findAll() {
        TypedQuery<Estado> query;
        query = em.createQuery("SELECT c FROM Estado c", Estado.class);
        return query.getResultList();
    }

    public List<Estado> findAll2() {
        Query query;
        query = em.createNamedQuery("findEstado");
        return query.getResultList();
    }

    public Estado findID(Long idParameter) {
        TypedQuery<Estado> query;
        query = em.createQuery("SELECT c FROM Ciudad c WHERE c.id=:id", Estado.class);
        query.setParameter("id", idParameter);
        return query.getSingleResult();
    }

    public Estado findID2(Long idParameter) {
        Query query;
        query = em.createNamedQuery("findIDNQE");
        query.setParameter("id", idParameter);
        return (Estado) query.getSingleResult();
    }

    public Estado find(Long id) {
        return em.find(Estado.class, id);
    }

    public void insert(Estado p) {
        em.persist(p);
    }

    public void update(Estado p) {
        em.merge(p);
    }

    public void delete(Estado p) {
        em.remove(em.merge(p));
    }

}
