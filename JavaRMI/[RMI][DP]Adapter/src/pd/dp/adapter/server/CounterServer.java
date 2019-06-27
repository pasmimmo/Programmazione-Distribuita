package pd.dp.adapter.server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Logger;

/**
 *
 * @author Pasmimmo
 */
public class CounterServer {

    static Logger logger = Logger.getLogger("global");
    private static BufferedReader con = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        String cmd;
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            RemoteCounter cont = new RemoteCounter("Contatore", 0);
            System.out.println("Pronto!");
            System.out.println("elenco comandi:\n\tvalore\n\tvalore(remoto)\n\tnome\n\tmovimenti\n\tquit");
            while (!(cmd = ask()).equals("quit")) {
                if (cmd.equals("valore")) {
                    System.out.println("localGetValue " + cont.localGetValue());
                } else if (cmd.equals("valore(remoto)")) {
                    System.out.println("getValue " + cont.getValue("Server"));
                } else if (cmd.equals("nome")) {
                    System.out.println("getNome " + cont.getName());
                } else if (cmd.equals("movimenti")) {
                    Vector<String> v = cont.getAccesses();
                    synchronized (v) {
                        for (Enumeration<String> e = v.elements(); e.hasMoreElements();) {
                            System.out.println(e.nextElement());
                        }
                    }//end Synchronized
                }//end if movimenti
                else {
                    System.out.println("Errore");
                }
            }//endwhile
        } catch (RemoteException e) {
            logger.severe("Problemi con oggetti remoti: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("esiste qualche altro problema" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Ciao!");
        System.exit(0);

    }

    private static String ask() throws IOException {
        System.out.print(">> ");
        return con.readLine();
    }
}
