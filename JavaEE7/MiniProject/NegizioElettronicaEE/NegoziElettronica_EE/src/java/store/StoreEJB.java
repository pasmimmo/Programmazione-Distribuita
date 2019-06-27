/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author amori
 */
@WebService(name = "StoreWS")
@Stateless
@LocalBean
public class StoreEJB implements StoreEJBRemote {
    
    @Inject
    private EntityManager entityManager;
    
    @WebMethod(exclude = true)
    public void addStore(Store store){
        entityManager.persist(store);
    }
    @WebMethod(exclude = true)
    public void deleteStore(Store store){
        entityManager.remove(store);
    }
    @WebMethod(exclude = true)
    public void updateStore(Store store){
        entityManager.merge(store);
    }
    
    @WebMethod(exclude = true)

    @Override
    public List<Store> PrintAll() {
        TypedQuery<Store> query = entityManager.createNamedQuery("printAll", Store.class);
        List<Store> lista = query.getResultList();
        return lista;
    }
    @WebMethod(exclude = true)

    @Override
    public List<Store> PrintByRegion(String region) {
        TypedQuery<Store> query = entityManager.createNamedQuery("printByRegion", Store.class);
        query.setParameter("distretto", region);
        List<Store> lista = query.getResultList();
        return lista;
    }

        @WebMethod(exclude = true)
    @Override
    public Store PrintById(Long id) {
        TypedQuery<Store> query = entityManager.createNamedQuery("printById", Store.class);
        query.setParameter("id", id);
        Store store = query.getSingleResult();
        return store;
    }

    @WebMethod(exclude = true)
    @Override
    public List<Store> PrintActiveShops() {
        TypedQuery<Store> query = entityManager.createNamedQuery("printActiveShop", Store.class);
        List<Store> lista = query.getResultList();
        return lista;
    }
    
    public String PrintCacca() {
        return "Cacca";
    }  

}