package pd.rmi.adapter.server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pasmi
 */
public class RemoteCounter extends LocalCounter implements Counter {

    static Logger logger = Logger.getLogger("global");
    String name;
    Vector<String> accesses = new Vector<String>();

    public RemoteCounter(String n, int v) throws RemoteException {
        super(v);
        name = n;
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind(name, UnicastRemoteObject.exportObject(this, 1099));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Problemi di rebinding ", e.getMessage());
            e.printStackTrace();
        }
        String cr = "Nuovo Counter Creato il: " + new Date();
        accesses.add(cr);
        logger.info(cr);
    }

    @Override
    public int getValue(String from) throws RemoteException {
        int app = this.localGetValue();
        String cr = "getValue() da " + from + " (" + new Date() + "): " + app;
        accesses.add(cr);
        logger.info(cr);
        return app;
    }

    @Override
    public void sum(String from, int valore) throws RemoteException {
        for (int i = 1; i <= valore; i++) {
            this.increment();
        }
        String cr = "sum:" + valore + " da " + from.toUpperCase() + "\n\t(" + new Date() + "): nuovo " + this.localGetValue();
        accesses.add(cr);
        logger.info(cr);
    }

    public String getName() {
        return name.toUpperCase();
    }

    public Vector<String> getAccesses() {
        return accesses;
    }
}
