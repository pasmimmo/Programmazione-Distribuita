package pd.rmi.helloserver;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;

public class RMIHelloServer extends UnicastRemoteObject implements Hello {

    private static final long serialVersionUID = 1L;
    // Seriale di versione
    static final Logger logger = Logger.getLogger("global");
    //Instanzio un Logger
    String welcome = "Ciao";
    //Messaggio di benvenuto

    public RMIHelloServer() throws RemoteException {
        // Il costruttore è indispensabile ma in questo calo lo lasceremo vuoto
    }

    //Implementazione dell'interfaccia
    @Override
    public String dimmiQualcosa(String name) throws RemoteException {
        logger.info("sto salutando " + name);
        return (welcome + " " + name);
    }

    public static void main(String args[]) throws RemoteException {

        System.setSecurityManager(new SecurityManager());
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            logger.info("Creo l'oggetto remoto...");
            RMIHelloServer hellos = new RMIHelloServer();
            logger.info("...ora ne eseguo il rebind");
            reg.rebind("HelloServer", hellos);
            logger.info("...Pronto");
        } catch (RemoteException e) {
            System.out.println("HelloImpl err: " + e.getMessage());
        }
    }

}
