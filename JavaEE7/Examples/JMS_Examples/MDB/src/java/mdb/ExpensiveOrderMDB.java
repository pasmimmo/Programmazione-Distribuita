/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Un esempio di Messages Driven Bean, che esegue della logica alla ricezione di 
 * un messaggio, appoggiandosi a JMS
 * ---------------------------------
 * N.B. requisiti deploy
 * - una JMS Connection Factories con i seguenti parametri:
 * JNDI Name: jms/examples
 * Logical JNDI Name:
 * Resource Type: javax.jms.ConnectionFactory
 * 
 * - una JMS Destination Resources con i seguenti parametri
 * JNDI Name: jms/jmsExample/Topic
 * Physical Destination Name: ExampleTopic
 * Resource Type: javax.jms.Topic
 * 
 * @author pasmimmo
 */
@MessageDriven(activationConfig = {
    //Eseguiamo il binding con glassfish
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/jmsExample/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    //settiamo il filtro per i messaggi su label orderAmount vedi riga 53 del producer
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000")
})
public class ExpensiveOrderMDB implements MessageListener {

    public ExpensiveOrderMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Expensive order received: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
