package pd.socket.iterativeclient;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;



public class Client {
	
	//
	static Logger logger = Logger.getLogger("global");
	static int connectionPort=9000;
	static String nome="Domenico";

	public static void main(String[] args) {
		try{
			Socket socketC=new Socket("127.0.0.1",connectionPort);
			logger.info("Connessione al server...");
			ObjectInputStream inStreamC = new ObjectInputStream(socketC.getInputStream());
			logger.info("provo a leggere la porta dati");
			int dataPort=(int)inStreamC.readObject();
			logger.info("Data port is:"+dataPort);
			Socket socketD=new Socket("localhost",dataPort);
			ObjectOutputStream outStream = new ObjectOutputStream(socketD.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socketD.getInputStream());
			outStream.writeObject(nome);
			System.out.println(inStream.readObject());
			socketC.close();
			outStream.close();
			inStream.close();
			socketD.close();
			
		}catch(ConnectException connectEx){
			System.out.println("Il server non è pronto\n\tConnessione Rifiutata!\n\n");
			connectEx.printStackTrace();
		}catch(SocketException SocEX){logger.info("Tranquillo il server è praticamente un tostapane\n\t\tripremi il bottone verde");}catch (Exception e){e.printStackTrace();}

	}

}
