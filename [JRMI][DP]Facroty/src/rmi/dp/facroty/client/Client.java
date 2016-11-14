/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.dp.facroty.client;

import java.rmi.Naming;
import java.util.logging.Logger;
import rmi.dp.factory.Factory;
import rmi.dp.factory.Hello;

/**
 *
 * @author Pasmimmo
 */
public class Client {

    private static final Logger logger = Logger.getLogger("global");

    /**
     *
     * @param ARGS
     */
    public static void main(String ARGS[]) {
        String[] args = {"localhost", "Domenico", "italy"};
        try {
            Factory fact = (Factory) Naming.lookup("rmi://" + args[0] + "/FactoryRemoteHello");
            Hello hello = (Hello) fact.createHello(args[2]);//Nazionalità
            System.out.println(hello.sayHello(args[1]));//nome*/
        } catch (Exception e) {
            logger.severe("problemi con l'oggetto remoto" + e.getMessage());
            e.printStackTrace();
        }
    }

}
