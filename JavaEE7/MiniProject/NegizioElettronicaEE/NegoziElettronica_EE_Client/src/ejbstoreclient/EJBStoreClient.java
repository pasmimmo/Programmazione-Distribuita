/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbstoreclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import store.Store;
import store.StoreEJBRemote;
import javax.jms.*;

/**
 *
 * @author amori
 */
public class EJBStoreClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context context;
        context = new InitialContext();
        StoreEJBRemote store = (StoreEJBRemote) context.lookup("java:global/EJBStore/StoreEJB!store.StoreEJBRemote");
        List<Store> lista1 = store.PrintAll();
        System.out.println("***STAMPO TUTTI***");
        for(Store s : lista1) {
            System.out.println(s);
        }
        
        List<Store> lista2 = store.PrintActiveShops();
        System.out.println("***STAMPO NEGOZI ATTIVI ***");
        for(Store s : lista2) {
            System.out.println(s);
        }
        
        List<Store> lista3 = store.PrintByRegion("Napoli");
        System.out.println("***STAMPO NEGOZI REGIONE Napoli***");
        for(Store s : lista3) {
            System.out.println(s);
        }
        
        List<Store> lista4 = store.PrintByRegion("Caudino");
        System.out.println("***STAMPO NEGOZI REGIONE Caudino***");
        for(Store s : lista4) {
            System.out.println(s);
        }
        
        List<Store> lista5 = store.PrintByRegion("Milano");
        System.out.println("***STAMPO NEGOZI REGIONE Milano***");
        for(Store s : lista5) {
            System.out.println(s);
        }
        
        System.out.println("***************");
        Store nicola = store.PrintById(3L);
        System.out.println(nicola);
        
        
        //Parte di MDB
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/StoreJMSFactory");
        Destination destination = (Destination) ctx.lookup("jms/Store/Queue");
        JMSContext jMSContext = cf.createContext();
        Store s = new Store(100, 500, "Modena", "Modena", "Italy", "Filippo", "RstoreModena");
        jMSContext.createProducer().send(destination, s);
    }
    
}
