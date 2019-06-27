/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import ejb.Molecola;
import javax.naming.NamingException;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException{
        Context context = new InitialContext();
        ConnectionFactory jmsFactory = (ConnectionFactory) context.lookup("jms/Molecole/Factory");
        Destination destination = (Destination) context.lookup("jms/Molecole/Queue");
        try(JMSContext jmsContext = jmsFactory.createContext()){
            Molecola molecola;
            molecola = new Molecola("lilli", "animale");
            jmsContext.createProducer().setProperty("operation", "create").send(destination, molecola);
            System.out.println("inviata una nuova");
            molecola.setTipo("ibrido");
            jmsContext.createProducer().setProperty("operation", "update").send(destination,molecola);
            System.out.println("Aggiornata una molecola");
            
        }
    }
    
}
