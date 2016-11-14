/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.dp.factory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pasmimmo
 */
public class FactoryLegacy extends UnicastRemoteObject implements Hello {

    static final long serialVersionUID = 1L;
    static String factOBJ = "FactoryRemoteHello", legacyOBJ = "HelloServer", factIP = "localhost", legacyIP = "localhost";

    static final Logger logger = Logger.getLogger("global");

    public FactoryLegacy(String factObj, String factIp, String legacyObj, String legacyIp) throws RemoteException {
        super();
        if (factObj != null && factIp != null && legacyIp != null && legacyObj != null) {
            factOBJ = factObj;
            legacyOBJ = legacyObj;
            factIP = factIp;
            legacyIP = legacyIp;
        }
        try {
            Naming.rebind("rmi://" + legacyIP + "/" + legacyOBJ, this);
        } catch (Exception e) {
            logger.severe("Problemi di rebind con la FactoryLegacy" + e.getMessage());
            e.printStackTrace();
            //Fix this
        }
    }

    @Override
    public String sayHello(String myName) throws RemoteException {
        Factory fact;
        Hello hello = null;
        try {
            fact = (Factory) Naming.lookup("rmi://" + factIP + "/" + factOBJ);
            hello = (Hello) fact.createHello("legacy");//Nazionalità
        } catch (NotBoundException | MalformedURLException ex) {
            logger.info("AdapterLegacyerror");
            Logger.getLogger(FactoryLegacy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ("you are in legacy mode:\n" + hello.sayHello(myName) + "\n\t We suggest to upgrade your client");
    }
}
