package pd.client.hashmap;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

import pd.server.hashmap.RecordRegistro;

public class ShellClient {
	static Logger logger = Logger.getLogger("global");
	static int port = 7000;

	public static void main(String args[]) {
		String host = "localhost"; 
		String cmd;
		in = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (!(cmd = ask("Comandi>")).equals("quit")) {
				if (cmd.equals("inserisci")) {
					System.out.println("Inserisci i dati:");
					String nome = ask("Nome: ");
					String indirizzo = ask("indirizzo: ");
					RecordRegistro r = new RecordRegistro(nome, indirizzo);
					Socket sock = new Socket(host, port);
					ObjectOutputStream sock_out = new ObjectOutputStream(sock.getOutputStream());
					sock_out.writeObject(r);
					sock_out.flush();
					sock.close();
				} else if (cmd.equals("Cerca")) {
					System.out.println("Inserire il nome per la ricerca:");
					String nome = ask("nome: ");
					RecordRegistro r = new RecordRegistro(nome, null);
					sock = new Socket(host, port);
					ObjectOutputStream sock_out = new ObjectOutputStream(sock.getOutputStream());
					sock_out.writeObject(r);
					sock_out.flush();
					ObjectInputStream sock_in = new ObjectInputStream(sock.getInputStream());
					RecordRegistro search = (RecordRegistro) sock_in.readObject();
					if (search != null) {
						System.out.println("Indirizzo: " + search.getIndirizzo());
					} else
						System.out.println("Record non presente !");
				} else
					System.out.println(ERRORMSG);
			}
		} catch (Throwable t) {
			logger.severe("Lanciata Trowable: "+t.getMessage());
			t.printStackTrace();
		}
		System.out.println("Bye Bye");
	}
	private static String ask(String prompt) throws IOException{
		System.out.println(prompt+" ");
		return (in.readLine());
	}
	static final String ERRORMSG="Cosa?";
	static BufferedReader in=null;
	private static Socket sock;
}