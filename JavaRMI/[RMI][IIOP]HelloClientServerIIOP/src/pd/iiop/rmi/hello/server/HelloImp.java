/*
 * 
 */
package pd.iiop.rmi.hello.server;

/**
 */

import javax.rmi.*;
import javax.naming.*;
import java.rmi.*;
import java.util.logging.Logger;
/**
 * The Class HelloImp over IIOP transmission rmi protocol.
 * if u have a iusses to build "rmic -iiop yourProject.class" use the guide in comments at thiss discuss on stackoverflow
 *  http://stackoverflow.com/questions/12336224/rmic-error-class-not-found
 */
public class HelloImp extends PortableRemoteObject implements Hello {

	/** The logger. */
	static Logger logger = Logger.getLogger("global");

	/**
	 * Instantiates a new hello imp.
	 *
	 * @throws RemoteException the remote exception
	 */
	protected HelloImp() throws RemoteException {
		super();
		// Vuoto
	}

	/* (non-Javadoc)
	 * @see pd.iiop.rmi.hello.server.Hello#dimmiQualcosa(java.lang.String)
	 */
	@Override
	public String dimmiQualcosa(String daChi) throws RemoteException {
		logger.info("Sto salutando " + daChi);
		return ("Accesso Consentito a:"+ daChi);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			logger.info("Creo l'oggetto remoto");
			HelloImp obj = new HelloImp();
			logger.info("Registro l'oggetto remoto");
			Context ic = new InitialContext();
			ic.rebind("HelloServer", obj);
			logger.info("...Pronto!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
