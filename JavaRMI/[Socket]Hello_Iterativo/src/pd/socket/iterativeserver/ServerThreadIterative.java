package pd.socket.iterativeserver;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class ServerThreadIterative implements Runnable {
	// Logger
	static Logger logger = Logger.getLogger("global");

	private static int startPort = 9000;
	private static int i = 1;

	public static void main(String args[]) {
		while (true) {
			logger.info("Avvio il server...");
			runServer();
		}
	}

	private static void runServer() {
		try {
			ServerSocket servSoc = new ServerSocket(startPort);
			logger.info("Server in attesa di client sulla porta:" + startPort);
			Socket sock = servSoc.accept();
			logger.info("Attendo Connessioni");
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
			outStream.writeObject((startPort + incrementPort()));
			outStream.flush();
			logger.info("Comunicazione porta dati avvenuta\n\t chiudo la connessione col client");
			outStream.close();
			sock.close();
			servSoc.close();
			logger.info("Connessioni chiuse");
			new Thread().start();
		} catch (IOException e) {
			logger.info("errore nel IO");
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			DataSocket dataSock = new DataSocket((startPort + incrementPort()) - 1);
			dataSock.writeObject("ciao " + ((String) dataSock.readObject()));
			dataSock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static synchronized int incrementPort() {
		i++;
		return i;
	}
}
