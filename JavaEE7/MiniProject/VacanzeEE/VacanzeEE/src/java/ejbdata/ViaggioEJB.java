/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 *
 * @NamedQuery(name = "findByID", query = "select v from Viaggio where v.ID =
 * :id"),
 * @NamedQuery(name = "findByCategory", query = "select c from Viaggio where
 * c.categoria = :categoria"),
 *
 *
 *
 *
 * @author pasmimmo
 */
@Stateless
@LocalBean
@Loggable
public class ViaggioEJB implements ViaggioEJBRemote {

    @Inject
    EntityManager entityManager;
    
    public void creaViaggio(Viaggio viaggio) {
        entityManager.persist(viaggio);
    }
    
    public void aggiornaViaggio(Viaggio viaggio){
        entityManager.merge(viaggio);
    }

    @Override
    public void rimuoviViaggio(Viaggio viaggio) {
        entityManager.remove(viaggio);
    }

    @Override
    @Interceptors(TuttiIViaggiInterceptor.class)
    public List<ejbdata.Viaggio> stampaTuttiIViaggi() {
        TypedQuery<Viaggio> query = entityManager.createNamedQuery("trovaTutti", Viaggio.class);
        List<Viaggio> risultati = query.getResultList();
        return risultati;
    }

    @Override
    public List<Viaggio> ricercaPerDestinazione(String destinazione) {
        TypedQuery<Viaggio> query = entityManager.createNamedQuery("ricercaDestinazione", Viaggio.class);
        query.setParameter("destinazione", destinazione);
        List<Viaggio> risultati = query.getResultList();
        return risultati;
    }

    @Override
    public List<Viaggio> ricercaPerCategoria(String category) {
        TypedQuery<Viaggio> query = entityManager.createNamedQuery("ricercaCategoria", Viaggio.class);
        query.setParameter("categoria", category);
        List<Viaggio> risultati = query.getResultList();
        return risultati;
    }

    @Override
    public Viaggio aggiungiViaggio(Viaggio viaggio) {
        entityManager.persist(viaggio);
        return viaggio;
    }

    @Override
    public List<Viaggio> ricercaPrezzoMax(Integer prezzoMax) {
        TypedQuery<Viaggio> query = entityManager.createNamedQuery("ricercaPrezzo", Viaggio.class);
        query.setParameter("maxp", prezzoMax);
        List<Viaggio> risultati = query.getResultList();
        return risultati;
    }
}
