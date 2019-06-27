package pd.iiop.rmi.hello.client;

import javax.rmi.*;
import javax.naming.*;
import java.util.logging.Logger;
import pd.iiop.rmi.hello.server.Hello;

public class HelloClient {

	static Logger logger = Logger.getLogger("global");
	static String userID = "Domenico";

	public static void main(String[] args) {
		Context ic;
		Object obj;
		Hello server;
		try {
			logger.info("Sto cercando l'oggetto remoto");
			ic = new InitialContext();
			obj = ic.lookup("rmi://localhost/HelloServer");
			server = (Hello) PortableRemoteObject.narrow(obj, Hello.class);
			logger.info("... Trovato!\n\tOra invoco il metodo...");
			String risultato = server.dimmiQualcosa(userID);
			System.out.println("Ricevuto: " + risultato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
