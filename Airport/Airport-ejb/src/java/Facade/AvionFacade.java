/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Avion;
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
public class AvionFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Airport-ejbPU")
    private EntityManager em;

    public List<Avion> findAll() {
        TypedQuery<Avion> query;
        query = em.createQuery("SELECT c FROM Avion c", Avion.class);
        return query.getResultList();
    }

    public List<Avion> findAll2() {
        Query query;
        query = em.createNamedQuery("findAvion");
        return query.getResultList();
    }

    public Avion findID(Long idParameter) {
        TypedQuery<Avion> query;
        query = em.createQuery("SELECT c FROM Avion c WHERE c.id=:id", Avion.class);
        query.setParameter("id", idParameter);
        return query.getSingleResult();
    }

    public Avion findID2(Long idParameter) {
        Query query;
        query = em.createNamedQuery("findIDnq");
        query.setParameter("id", idParameter);
        return (Avion) query.getSingleResult();
    }

    public Avion findNumVuelo(String numero_Vuelo) {
        TypedQuery<Avion> query;
        query = em.createQuery("SELECT c FROM Avion c WHERE c.avionList.Numero_Vuelo=:numVuelo", Avion.class);
        query.setParameter("numVuelo", numero_Vuelo);
        return query.getSingleResult();
    }

    public Avion findNumAvionyPasajeros(String num_Avion, int c_Pasajeros) {
        Query query;
        query = em.createNamedQuery("findAvionyPasajeros");
        query.setParameter("num", num_Avion);
        query.setParameter("pas", c_Pasajeros);
        return (Avion) query.getSingleResult();
    }

    public Avion find(Long id) {
        return em.find(Avion.class, id);
    }

    public void insert(Avion p) {
        em.persist(p);
    }

    public void update(Avion p) {
        em.merge(p);
    }
    
    public void delete(Avion p){
        em.remove(em.merge(p));
    }
}
