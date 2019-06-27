/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import javax.enterprise.inject.Produces;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
/**
 *
 * @author amori
 */
public class EntityManagerProducer {
    @Produces
    @PersistenceContext(unitName = "StorePU")
    private EntityManager entityManager;
}
