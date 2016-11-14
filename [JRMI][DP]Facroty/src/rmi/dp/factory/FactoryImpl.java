/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.dp.factory;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

/**
 *
 * @author Pasmimmo
 */
public class FactoryImpl extends UnicastRemoteObject implements Factory {

    private static final Logger logger = Logger.getLogger("global");
    private static final long serialVersionUID = 1L;
    private String host;
    private int italian = 1, france = 1, any = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setSecurityManager(new SecurityManager());
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            new FactoryImpl("FactoryRemoteHello", "localhost");
            new FactoryLegacy(null, null, null, null);
        } catch (Exception e) {
            logger.severe("problemi con la creazione della factory" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Factory Pronta!");
    }

    public FactoryImpl(String nomeObj, String ip) throws RemoteException {
        super();
        host = ip;
        try {
            Naming.rebind("rmi://" + host + "/" + nomeObj, this);
        } catch (Exception e) {
            logger.severe("Problemi di rebind" + e.getMessage());
            e.printStackTrace();
            //Fix this
        }
    }

    @Override
    public Hello createHello(String from) throws RemoteException {
        from = from.toLowerCase();
        if (null == from) {
            return new HelloImplAny("Any" + any++);
        } else {
            switch (from) {
                case "italia":
                case "italy":
                    return new HelloImplItaly("Italy" + italian++);
                case "france":
                    return new HelloImplFrance("France" + france++);
                default:
                    return new HelloImplAny("Any" + any++);
            }
        }
    }
}
