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

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination destination = (Destination)ctx.lookup("jms/javaee7/Topic2");
        System.out.println("Binding Effettuati\n Aspetto Nuovi Messaggi");
        try(JMSContext jmsContext = connectionFactory.createContext()){
            while(true){
                String messaggioTopic2= jmsContext.createConsumer(destination).receiveBody(String.class);
                System.out.println(messaggioTopic2);
            }
        }
    }
    
}
