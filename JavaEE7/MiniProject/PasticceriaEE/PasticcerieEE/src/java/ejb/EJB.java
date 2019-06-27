/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pasmimmo
 */
@Stateless
public class EJB implements EJBRemote, Saluti {
     @Inject
    private EntityManager em;

    @Override
    public List<String> getAll() {
        TypedQuery<Bakery> query = em.createNamedQuery("Bakery.getAll", Bakery.class);
        List<Bakery> bakeries = query.getResultList();
        return convertString(bakeries);
    }

    @Override
    public List<String> getOpen() {
        TypedQuery<Bakery> query = em.createNamedQuery("Bakery.getOpen", Bakery.class);
        List<Bakery> bakeryes = query.getResultList();
        return convertString(bakeryes);
    }

    @Override
    public String findByName(String bakeryName) {
        TypedQuery<Bakery> query = em.createNamedQuery("Bakery.findByName", Bakery.class);
        query.setParameter("nome", bakeryName);
        Bakery bakery= query.getSingleResult();
        System.out.println("sono nel find by name non decorato: "+bakery.toString());
        return bakery.toString();
        
    }

    private List<String> convertString(List<Bakery> fromList) {
        List<String> lista = new ArrayList<>();
        for (Bakery b : fromList) {
            lista.add(b.toString());
            System.out.println(b);
        }
        System.out.println("Monnezza di mimmo");
                    return lista;

    }

    @Override
    public String salutami(String tuoNome) {
        return "ciao"+tuoNome;
    }

    @Override
    public String ciao(String nome) {
        return salutami(nome);
    }

}
