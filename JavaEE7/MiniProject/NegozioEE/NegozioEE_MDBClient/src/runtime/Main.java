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
import javax.naming.NamingException;
import ejb.Mouse;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ctx = new InitialContext();
        
        Mouse m1 = new Mouse("razor", "ottico", 1f);
        
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/MouseFactory");
        Destination d = (Destination) ctx.lookup("jms/Queue");
        
        
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            // Sends an object message to the topic
            jmsContext.createProducer().send(d, m1);
            System.out.println("\nUpdate sent : " + m1.toString());
    }
    
}
    
}
    
