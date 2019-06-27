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
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pasmimmo
 */
@Stateless 
@LocalBean 
@Interceptors(MouseInterceptor.class) 
@WebService
public class NegozioEJB implements NegozioEJBRemote {
    
    public NegozioEJB(){
    }

    @Inject
    EntityManager em;
    
    @Override
    public List<Mouse> getAll(){
        TypedQuery<Mouse> query = em.createNamedQuery("Mouse.getAll", Mouse.class);
        List<Mouse> list = query.getResultList();
        return list;
    }

    @Override
    public List<Mouse> maxPrice(Float price) {
        TypedQuery<Mouse> query = em.createNamedQuery("Mouse.maxPrice", Mouse.class);
        query.setParameter("price", price);
        List<Mouse> list = query.getResultList();
        return list;
    }

    @Override
    public String findByName(String name) {
        TypedQuery<Mouse> query = em.createNamedQuery("Mouse.", Mouse.class);
        query.setParameter("name", name);
        Mouse m = query.getSingleResult();
        return m.toString();
        
    }
    
    public void create(Mouse m){
        em.persist(m);
    }
    
    public void delete(Mouse m){
        em.remove(m);
    }
    
    public void update(Mouse m){
        em.merge(m);
    }
    
    
}
