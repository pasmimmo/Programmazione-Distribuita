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
public class TopicClient {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/javaee7/ConnectionFactory");
        Destination topic1 = (Destination) context.lookup("jms/javaee7/Topic1");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().setProperty("nomeNegozio", "BeviBene").send(topic1, 50d);
        }

    }

}
