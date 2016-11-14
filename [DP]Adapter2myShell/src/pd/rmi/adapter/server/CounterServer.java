package pd.rmi.adapter.server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import domenico.utilita.UserInteraction;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Logger;

/**
 *
 * @author Pasmimmo
 */
public class CounterServer {

    static final Logger logger = Logger.getLogger("global");
    static final String comands[] = {"valore", "valore(remoto)", "nome", "movimenti", "quit"};

    public static void main(String args[]) {
        String cmd;
        UserInteraction userI = new UserInteraction();
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            userI.copyRight("CounterServer");
            RemoteCounter cont = new RemoteCounter("Contatore", 0);
            Boolean alive = true;
            while (alive) {
                switch (userI.commandList(comands).toLowerCase()) {
                    case "valore":
                        System.out.println("localGetValue " + cont.localGetValue());
                        break;
                    case "valore(remoto)":
                        System.out.println("getValue " + cont.getValue("Server"));
                        break;
                    case "nome":
                        System.out.println("getNome " + cont.getName());
                        break;
                    case "movimenti":
                        Vector<String> v = cont.getAccesses();
                        synchronized (v) {
                            for (Enumeration<String> e = v.elements(); e.hasMoreElements();) {
                                System.out.println(e.nextElement());
                            }
                        }
                        break;
                    case "quit":
                        alive = false;
                        break;
                }
            }
        } catch (RemoteException e) {
            logger.severe("Problemi con oggetti remoti: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("esiste qualche altro problema" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Arrivederci!\n");
        userI.newLine();
        System.exit(0);
    }
}
