package pd.lab.rmi.es2.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Server extends UnicastRemoteObject implements Hello2 {

	private static final long serialVersionUID = 1323656046778895439L;
	static Logger logger = Logger.getLogger("global");
	private static ArrayList<String> list;
	static AtomicInteger count;

	protected Server() throws RemoteException {
		super();
	}

	public static void main(String args[]) {

		try {
			count = new AtomicInteger(0);
			list = new ArrayList<String>();
			logger.info("ArrayList e Contatore inizializzati");
			Registry reg = LocateRegistry.createRegistry(1099);
			logger.info("Server Registrato");
			Server obj = new Server();
			reg.rebind("ServerLog", obj);
			logger.info("Oggetto creato e Registrato");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String dimmiQualcosa(String userId) {
		if (list.contains(userId)) {
			logger.info(userId+" si è riconnesso");
			return "Bentornato";
		} else {
			list.add(userId);
			logger.info("Aggiunto "+userId);
			return "sei stati inserito";
		}
	}

	@Override
	public ArrayList<String> stampaLog() {
		logger.info("invio logger");
		return list;
	}

	@Override
	public int leggi() throws RemoteException {
		
		return count.get();
	}

	@Override
	public void aggiungi(int i) throws RemoteException {
		count.addAndGet(i);
	}

}