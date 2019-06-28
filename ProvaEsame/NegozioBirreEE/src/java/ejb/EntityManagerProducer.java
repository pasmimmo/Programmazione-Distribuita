/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Producer di EntityManger, che va a scrivere oggetti nel DB,
 *  per la gestione dell'unità di persistenza "EsamePU"

 * @author pasmimmo
 */
public class EntityManagerProducer {
    @PersistenceContext(unitName = "EsamePU")
    @Produces
    EntityManager entityManager;
}
