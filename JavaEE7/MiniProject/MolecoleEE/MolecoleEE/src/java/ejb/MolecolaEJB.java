/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pasmimmo
 */
@Stateless @LocalBean @Interceptors(logInterceptor.class) @WebService
public class MolecolaEJB implements MolecolaEJBRemote {
    @Inject
    EntityManager entityManager;

    public MolecolaEJB() {
    }
    
    /*Metodi CRUD*/
    @WebMethod(exclude = true)
    public void createMolecola(Molecola molecola){
        entityManager.persist(molecola);
    }
    @WebMethod(exclude = true)
    public void updateMolecola(Molecola molecola){
        entityManager.merge(getMolecolaFromDB(molecola));
    }
    @WebMethod(exclude = true)
    public void removeMolecola(Molecola molecola){
        entityManager.remove(molecola);
    }
    
    @Override @WebMethod(operationName = "elencoCompleto")
    public List<Molecola> getElencoCompleto() {
        TypedQuery<Molecola> query = entityManager.createNamedQuery("molecola.findAll",Molecola.class);
        return query.getResultList();
    }

    @Override @WebMethod(exclude = true)
    public Molecola cercaMolecola(String nomeMolecola) {
        TypedQuery<Molecola> query = entityManager.createNamedQuery("molecola.findByName",Molecola.class);
        query.setParameter("nome", nomeMolecola);
        return query.getSingleResult();
    }

    @Override @WebMethod(operationName = "cercaTipo")
    public List<Molecola> cercaTipo(String tipo) {
        TypedQuery<Molecola> query = entityManager.createNamedQuery("molecola.findByType",Molecola.class);
        return query.setParameter("tipo", tipo).getResultList();
    
    }
    
    private Molecola getMolecolaFromDB(Molecola molecola){
        
        TypedQuery<Molecola> query;
        query= entityManager.createNamedQuery("molecola.findByName",Molecola.class);
        
        query.setParameter("nome", molecola.getNome());
        
        Molecola tmp = query.getSingleResult();
        
        tmp.setNome(molecola.getNome());
        tmp.setTipo(molecola.getTipo());
        
        return tmp;
    }
}
