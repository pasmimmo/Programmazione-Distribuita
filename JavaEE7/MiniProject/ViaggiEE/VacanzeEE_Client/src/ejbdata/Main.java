/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import java.util.List;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * Client di comunicazione con GlassFish per il progetto "Viaggi Enterprise
     * App"
     *
     * @param args
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        //Ottengo un contesto
        Context ctx = new InitialContext();

        //Cerco l'oggetto remoto e lo casto alla giusta interfaccia, il metodo lookup restituisce sempre un tipo Object
        ViaggioEJBRemote viaggioEJB;
        viaggioEJB = (ViaggioEJBRemote) ctx.lookup("java:global/VacanzeEE/ViaggioEJB!ejbdata.ViaggioEJBRemote");

        System.out.println("*****Stampa Risultati in corso******");
        //Stampo la lista delle vacanze attuali, ottenute interrogando il server
        List<Viaggio> viaggi = viaggioEJB.stampaTuttiIViaggi();
        for (Viaggio unViaggio : viaggi) {
            System.out.println("---" + unViaggio);
        }//Creo un nuovo possibile viaggio e lo passo al server per farlo inserire in db
        Viaggio vTemp = new Viaggio("Lancusi", "montagna", 0d, 50, 130);
        viaggioEJB.aggiungiViaggio(vTemp);
        System.out.println("\n\n\t****************************\n\n" + vTemp + "\n\tAggiunto!\n\n");

        Integer prezzoMax = 500;
        // interrogo il server per la lista di viaggi da un determinato costo massimo
        viaggi = viaggioEJB.ricercaPrezzoMax(prezzoMax);
        System.out.println("ricerco viaggi con costo massimo: " + prezzoMax);
        System.out.println("*****Stampa Risultati in corso******");
        for (Viaggio unViaggio : viaggi) {
            System.out.println("---" + unViaggio);
            //mentre stampo la lista mi salvo "corfu" per aggiornarlo dopo
            if (unViaggio.getDestinazione().equals("Corfu")) {
                vTemp = unViaggio;
            }
        }
        System.out.println("Aggiorniamo "+vTemp.getDestinazione());
        //Aggiorno un viaggio
        vTemp.setCategoria("updated");

        //Invio un messaggio al server con JMS per aggiornare il viaggio
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/ViaggiConnectionFactory");
        Destination destinationQueue = (Destination) ctx.lookup("jms/Viaggi/Queue");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(destinationQueue, vTemp);
        }

        viaggi = viaggioEJB.stampaTuttiIViaggi();
        System.out.println("*****Stampa Risultati in corso******");

        for (Viaggio unViaggio : viaggi) {
            System.out.println("---" + unViaggio);
        }

    }
}
