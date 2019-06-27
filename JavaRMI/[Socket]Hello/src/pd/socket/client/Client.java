package pd.socket.client;

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
			Socket socket=new Socket("localhost",connectionPort);
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			outStream.writeObject(nome);
			System.out.println(inStream.readObject());
			socket.close();
		}catch(ConnectException connectEx){
			System.out.println("Il server non era pronto\n\tConnessione Rifiutata!\n\n");
			connectEx.printStackTrace();
		}catch (Exception e){e.printStackTrace();}

	}

}
