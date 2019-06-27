/*
 * 
 */
package pd.lab.rmi.es1.server;
/**
 * 
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.<br>
 * 
 * Scrivere un programma Server/Client con Java RMI che 
 * fornisce la somma di tutti gli interi passati dai client.
 * 
 * Il Server deve implementare: 
 * ->un metodo per aggiungere un intero, 
 * ->un metodo per poter leggere l�intero,
 * Il client deve implementare:
 * un metodo che prende un intero dalla linea di comando e lo passa al server, 
 * controllando a quanto e' arrivato il valore.. 
 */
public class Server extends UnicastRemoteObject implements Add {
	
	/** The count. */
	// Accumulatore
	private static AtomicInteger count= new AtomicInteger(0);
	
	/** The Constant serialVersionUID. */
	// Seriale di versione
	private static final long serialVersionUID = 1L;
	
	/** The logger. */
	// Creo un Logger
	static Logger logger = Logger.getLogger("global");
	
	/** The Constant serverNome. */
	// Server Nome
	private static final String serverNome = "CountServer";

	/**
	 * Instantiates a new server.
	 *
	 * @throws RemoteException the remote exception
	 */
	public Server() throws RemoteException {
		// Costrruttore Vuoto
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws RemoteException the remote exception
	 */
	public static void main(String args[]) throws RemoteException {
		// Creo il Security Manager
		System.setSecurityManager(new SecurityManager());
		try {
			// Avvio la registrazione di rmiregistry
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind(serverNome, new Server());

			logger.info("Creo l'oggetto remoto...");
			Server obj = new Server();
			logger.info("...ora ne eseguo il rebind");
			reg.rebind("server", obj);
			logger.info("...Pronto");

		} catch (Exception e) {
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see pd.lab.rmi.es1.server.Add#leggi()
	 */
	@Override
	public int leggi() {
		return count.get();
	}

	/* (non-Javadoc)
	 * @see pd.lab.rmi.es1.server.Add#aggiungi(int)
	 */
	@Override
	public void aggiungi(int i) {
		count.addAndGet(i);
	}

}
