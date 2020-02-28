/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Pais;
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
public class PaisFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    public List<Pais> findAll() {
        TypedQuery<Pais> query;
        query = em.createQuery("SELECT c FROM Pais c", Pais.class);
        return query.getResultList();
    }

    public List<Pais> findAll2() {
        Query query;
        query = em.createNamedQuery("findPais");
        return query.getResultList();
    }

    public Pais findID(Long idParameter) {
        TypedQuery<Pais> query;
        query = em.createQuery("SELECT c FROM Pais c WHERE c.id=:id", Pais.class);
        query.setParameter("id", idParameter);
        return query.getSingleResult();
    }

    public Pais findID2(Long idParameter) {
        Query query;
        query = em.createNamedQuery("findIDNQP");
        query.setParameter("id", idParameter);
        return (Pais) query.getSingleResult();
    }

    public Pais findNombre(String Nombre) {
        Query query;
        query = em.createNamedQuery("findNombre");
        query.setParameter("nom", Nombre);
        return (Pais) query.getSingleResult();
    }

    public Pais find(Long id) {
        return em.find(Pais.class, id);
    }

    public void insert(Pais p) {
        em.persist(p);
    }

    public void update(Pais p) {
        em.merge(p);
    }

    public void delete(Pais p) {
        em.remove(em.merge(p));
    }
}
