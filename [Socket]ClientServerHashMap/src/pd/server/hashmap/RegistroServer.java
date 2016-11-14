package pd.server.hashmap;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

public class RegistroServer {
	static Logger logger = Logger.getLogger("global");

	public static void main(String args[]) {
		HashMap<String, RecordRegistro> hastMap = new HashMap<String, RecordRegistro>();
		Socket socket = null;
		System.out.println("in attesa di connessioni...");
		try {
			// creazione e accept su socket
			ServerSocket servSock = new ServerSocket(7000);
			while (true) {
				socket = servSock.accept();
				ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
				RecordRegistro record = (RecordRegistro) inStream.readObject();
				if (record
						.getIndirizzo() != null)/* si tratta di una scrittura */
				{
					logger.info("inserico: " + record.getNome() + " , " + record.getIndirizzo());
					hastMap.put(record.getNome(), record);
				} else/* Si tratta di una ricerca */
				{
					logger.info("Cerco " + record.getNome());
					RecordRegistro search = hastMap.get(record.getNome());
					ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
					outStream.writeObject(search);
					outStream.flush();
				}
				servSock.close();
				socket.close();
			}
		} catch (EOFException eof) {
			logger.severe("problemi con la connessione" + eof.getMessage());
			eof.printStackTrace();
			// TODO: handle exception
		} catch (Throwable t) {
			logger.severe("Lanciata Throwable " + t.getMessage());
			t.printStackTrace();
		} finally/* Chiusura sock e terminazione programma */ {
			try {
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(0);
			}
		}
	}
}
