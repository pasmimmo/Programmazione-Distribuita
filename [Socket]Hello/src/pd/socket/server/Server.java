package pd.socket.server;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;


public class Server {
	//
	static Logger logger= Logger.getLogger("global");
	//
	private static int startPort=9000;
	
	public static void main(String args[]){
		try{
			ServerSocket serverSock = new ServerSocket(startPort);
			logger.info("Socket Instanziato, accetto connessioni sulla porta:"+startPort+" ... ... ...");
			Socket socket=serverSock.accept();
			logger.info("Connessione stabilita\n\tattendo comandi...");
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			String nome = (String)inStream.readObject();
			outStream.writeObject("Benvenuto "+nome);
			socket.close();
			serverSock.close();
			logger.info("ho salutato "+nome+" e adesso chiudo la connessione");
			
		}catch(ClassCastException castEX){
			System.out.println("Il client ha fornito dati non validi\n\tConnessione interrotta!\n\n");
			castEX.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
//