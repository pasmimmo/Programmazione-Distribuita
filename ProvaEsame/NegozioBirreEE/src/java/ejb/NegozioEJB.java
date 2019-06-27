/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import interceptors.LogMethod;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author pasmimmo
 */
@Stateless @LocalBean @WebService(name = "NegozioWS")
public class NegozioEJB implements NegozioEJBRemote{
    @Inject @LoggerInjectable
    Logger logger;
    @Inject
    EntityManager entityManager;
    @Inject
    Event<Negozio> evento;
    /* metodi CRUD*/
    public void createNegozio(Negozio negozio){
        entityManager.persist(negozio);
    }
    
    public void updateNegozio(Negozio negozio){
        entityManager.merge(dbReference(negozio));
    }
    
    public void removeNegozio(Negozio negozio){
        entityManager.remove(dbReference(negozio));
    }
    
    /**
     * Metodo di servizio, si occupa di ricercare il negozio nel database ed 
     * aggiornare i dati<br>
     * Questo metodo si occupa della consistenza dei dati in quanto il valore ID
     * dell'entità negizio viene autogenerato e non è modificabile 
     * (scelta implementativa)
     * @param negozio senza la id
     * @return bean negozio con la id settata
     */
    private Negozio dbReference(Negozio negozio){
        TypedQuery<Negozio> query = entityManager.createNamedQuery("Negozio.PrintByName",Negozio.class);
        query.setParameter("nome", negozio.getNome());
        Negozio tmp = query.getSingleResult();
        tmp.setBirra(negozio.getBirra());
        tmp.setBirraAnalcolica(negozio.getBirraAnalcolica());
        tmp.setCitta(negozio.getCitta());
        tmp.setProvincia(negozio.getProvincia());
        tmp.setRegione(negozio.getRegione());
        tmp.setNome(negozio.getNome());
        tmp.setDirettore(negozio.getDirettore());
        return tmp;
    }
    /**
     * Metodo Locale che effettua una ricerca in DB per Nome Negozio
     * @param nomeNegozio
     * @return Negozio corrispondente
     */
    public Negozio printByName(String nomeNegozio){
        TypedQuery<Negozio> query;
        query= entityManager.createQuery("SELECT n FROM Negozio n WHERE n.nome = :nome",Negozio.class);
        query.setParameter("nome", nomeNegozio);
        return query.getSingleResult();
    }
    /*Remote Method */
    /**
     * Metodo Remoto per la ricerca di negozi in una regione data in input
     * @param regione di ricerca
     * @return lista negozi
     */
    @Override @LogMethod
    public List<Negozio> printByRegion(String regione){
        TypedQuery<Negozio> query = entityManager.createNamedQuery("Negiozio.PrintByRegion",Negozio.class);
        query.setParameter("regione", regione);
        return query.getResultList();
    }
    /**
     * Metodo Remoto per la ricerca di un regozio dando in input la sua id
     * @param id chiave univoca che identifica il negozio nel DB    
     * @return 
     */
    @Override
    public List<Negozio> printById(Long id){
        TypedQuery<Negozio> query= entityManager.createNamedQuery("Negozio.PrintById",Negozio.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    /**
     * Metodo Remoto per la stampa di tutti i Negozi nel Database
     * @return 
     */
    @Override
    public List<Negozio> printAll() {
        TypedQuery<Negozio> query= entityManager.createNamedQuery("Negozio.PrintAll",Negozio.class);
        return query.getResultList();
    }
    /**
     * Metodo Remoto per la stampa di tutti i negozi che hanno un fatturato di
     * birre alcoliche maggiore delle birre analcoliche
     * @return 
     */

    @Override
    public List<Negozio> printDrunkPeopleShops() {
        TypedQuery<Negozio> query = entityManager.createNamedQuery("Negozio.PrintDrunkPeopleShops", Negozio.class);
        return query.getResultList();
    }
    
    /*WebServices Method*/
    /**
     * Servizio Web che permette di sostituire il none del direttore di un negozio
     * con uno nuovo
     * @param oldName
     * @param newName 
     */
    @WebMethod(operationName = "cambio_direttore")
    public String changeDirector(@WebParam(name = "old_director_name") String oldName, @WebParam(name = "new_director_name") String newName){
        TypedQuery<Negozio> query = entityManager.createNamedQuery("Negozio.PrintByDirector", Negozio.class);
        query.setParameter("direttore", oldName);
        try{
        Negozio n= query.getSingleResult();
        n.setDirettore(newName);
        entityManager.merge(n);
        evento.fire(n);
        } catch(NoResultException noResult){
            logger.warning(logger.getName()+"Nome non trovato durante la sostituzione del direttore");
            return "Nome vecchio direttore non trovato";
        }catch (NonUniqueResultException notunique){
            logger.warning(logger.getName()+" e successo un guaio grosso ci sono tanti nomi uguali in tabelle uniche");
            return "non puoi aggiornare questo direttore\n ci sono più referenze";
        }
        return "Direttore Aggiornato";
        //@updated aggiunta la gestione degli eventi e ovviamente rimosso il secondo interceptor e gli exclude per fisse mie
    }
    
    
}
