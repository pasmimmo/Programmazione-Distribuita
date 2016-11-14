/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.dp.factory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

/**
 *
 * @author Pasmimmo
 */
public class HelloImplAny extends UnicastRemoteObject implements Hello {

    private static final Logger logger = Logger.getLogger("global");
    private String myid;

    public HelloImplAny(String id) throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String myName) throws RemoteException {
        try {
            logger.info(myid + ": Ricevuto " + myName + "@" + getClientHost());
        } catch (Exception e) {
            logger.severe("problemi con la getCliebtHost" + e.getMessage());
            logger.info(myid + ": Ricevuto " + myName + "@unknown");
            e.printStackTrace();
        }
        return "Hello " + myName;
    }
}
