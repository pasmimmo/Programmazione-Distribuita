/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd.rmi.helloclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;
import pd.rmi.helloserver.Hello;

/**
 * 
 * @author Pasmimmo
 */
public class RMIHelloClient {
    /**
     * Logger to get info
     */
    static final Logger logger = Logger.getLogger("global");
    /**
     * String passed to server to say hello
     */
    static String nome = "Domenico";

    /**
     * Test Client App, for RMI Hello Server
     */
    public static void main(String args[]) {

        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            logger.info("Sto cercando l'oggetto remoto...");
            Hello obj = (Hello) reg.lookup("HelloServer");
            logger.info("... Trovato!Ora invoco il metodo");
            String risultato = obj.dimmiQualcosa(nome);
            System.out.println("Ricevuto " + risultato);
        } catch (RemoteException re) {
            logger.severe("Problema nel cercare l'oggetto remoto" + re.getMessage());
            re.printStackTrace();
        } catch (Exception e) {
            logger.severe("e incorso qualche problema\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
