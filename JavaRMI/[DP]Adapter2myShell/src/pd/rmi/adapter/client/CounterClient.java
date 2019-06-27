/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd.rmi.adapter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.logging.Logger;
import pd.rmi.adapter.server.Counter;

/**
 *
 * @author Pasmimmo
 */
public class CounterClient {

    static final Logger logger = Logger.getLogger("global");
    private static final BufferedReader con = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        String remoteObj = "Contatore", host = "localhost", nome;
        Counter count;
        int valore;
        //Creo un Security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            count = (Counter) Naming.lookup("rmi://" + host + "/" + remoteObj);
            logger.info("Oggetto remoto trovato");
            nome = ask("dammi il tuo nome");
            valore = Integer.parseInt(ask("dammi il valore da incrementare"));
            count.sum(nome, valore);
            System.out.println("Totale=" + count.getValue(nome));
        } catch (IOException | NotBoundException ex) {
            logger.info("Errore nei dati " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static String ask(String wrt) throws IOException {
        System.out.print(wrt + "\n>> ");
        return con.readLine();
    }
}
