/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

/**
 *
 * @author pasmimmo
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic1")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic1")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic1")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicMDB implements MessageListener {
    @Inject
    NegozioEJB ejb;
    
    @Inject @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
    private JMSContext jmsContext;
    
    @Resource(lookup = "jms/javaee7/Topic2")
    private Topic topic2;
    
    @Inject @LoggerInjectable
    Logger logger;
    
    public TopicMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            Negozio n=ejb.printByName(message.getStringProperty("nomeNegozio"));
            logger.info(logger.getName()+"messaggio ricvuto sulla Topic1");
            Double newValue = n.getBirra();
            newValue+=message.getBody(Double.class);
            n.setBirra(n.getBirra()+message.getBody(Double.class));
            ejb.updateNegozio(n);
            String messaggio=n.getNome()+" ha aggiunto "+message.getBody(Double.class);
            jmsContext.createProducer().send(topic2, messaggio);
            logger.info(logger.getName() + "Messaggio inviato sulla Topic 2");
            
        } catch (JMSException ex) {
            Logger.getLogger(TopicMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
