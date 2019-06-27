package pd.lab.rmi.es1.client;
/*
 * Scrivere un programma Server/Client con Java RMI che 
 * fornisce la somma di tutti gli interi passati dai client.
 * 
 * Il Server deve implementare: 
 * ->un metodo per aggiungere un intero, 
 * ->un metodo per poter leggere l�intero,
 * Il client deve implementare:
 * un metodo che prende un intero dalla linea di comando e lo passa al server, 
 * controllando a quanto � arrivato il valore.. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.rmi.registry.*;
import java.util.logging.Logger;
import pd.lab.rmi.es1.server.Add;

public class Client {
	static Logger logger = Logger.getLogger("global");
	static BufferedReader in = null;
	static String cmd;

	public static void main(String[] args) {
		try {
			logger.info("Cerco il server...");
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			logger.info("Cerco l'oggetto remoto");
			Add obj = (Add)reg.lookup("CountServer");
			logger.info("... Trovato!Ora invoco il metodo");
			System.out.println("Lista Comandi:\n\t-1:INSERT\n\t-2:READ\n\t-3:EXIT");
			while (!(cmd = ask("Comandi>")).toUpperCase().equals("EXIT")) 
			{
				if (cmd.toUpperCase().equals("INSERT")) {
					obj.aggiungi(Integer.parseInt(ask(":")));
					
				} else if (cmd.toUpperCase().equals("READ")) {
					System.out.println("Totale:" + obj.leggi());
				} else {
					System.out.println("Errore nei dati");
				}
			}
		} catch (Throwable t) {
			logger.severe("Lanciata Trowable: " + t.getMessage());
			t.printStackTrace();
		}
		System.out.println("a presto");
	}

	private static String ask(String prompt) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt + " ");
		return (in.readLine());
	}
}
