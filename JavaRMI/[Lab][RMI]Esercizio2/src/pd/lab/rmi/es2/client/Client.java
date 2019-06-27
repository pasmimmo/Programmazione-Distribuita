package pd.lab.rmi.es2.client;
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

import pd.lab.rmi.es2.server.Hello2;

public class Client {
	static Logger logger = Logger.getLogger("global");
	static BufferedReader in = null;
	static String cmd, func1="USERID",func2="LOG",func3="ADDVALUE",func4="READCOUNT",exit="EXIT";

	public static void main(String[] args) {
		try {
			logger.info("Cerco il server...");
			Registry reg = LocateRegistry.getRegistry("192.168.1.47", 1099);
			logger.info("Cerco l'oggetto remoto");
			Hello2 obj = (Hello2)reg.lookup("ServerLog");
			logger.info("... Trovato!Ora invoco il metodo");
			System.out.println("Lista Comandi:"+"\n\t"+func1
					+ "\n\t"+func2
					+ "\n\t"+func3
					+ "\n\t"+func4
					+ "\n\t"+exit);
			while (!(cmd = ask("Comandi>")).toUpperCase().equals(exit)) 
			{
				if (cmd.toUpperCase().equals(func3)) {
					obj.aggiungi(Integer.parseInt(ask(":")));
					
				} else if (cmd.toUpperCase().equals(func4)) {
					System.out.println("Totale:" + obj.leggi());
				}else if(cmd.toUpperCase().equals(func1)){
					System.out.println(obj.dimmiQualcosa(ask("insert userID:")));
				}else if(cmd.toUpperCase().equals(func2)){
					System.out.println(obj.stampaLog());
				}
				else {
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
