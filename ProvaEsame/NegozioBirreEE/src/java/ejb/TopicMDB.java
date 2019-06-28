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
 * Message Driven Bean che aspetta un messaggio sulla Topic1, e una volta letto invia un nuovo messaggio di avviso
 * sulla Topic 2.
 * 
 * Un MDB è un bean stateless che implementa un interfaccia MessageListener e ne sovrascrive il metodo onMessage()
 * 
 * in questo caso è stata implementata una Topic, che fornisce un implementazione del modello publish-subscriver
 * (Come un gruppo di Whatsapp)
 * esiste anche una coda che si occupa del modello point to point (uno a uno)
 * (Come un messaggio privato)
 * 
 * Ai fini di JavaMessaggingSystem (JMS) c'è bisogno di: 
 * un Poducer(il tipo che manda il pacco)
 * un Consumer(il tipo che lo riceve)
 * un Broker che fornisce servizi a mezzo di oggetti amministrati (l'ufficio postale)
 *
 * @author pasmimmo
 */
@MessageDriven(activationConfig = {
    /*parametri di attivazione, quali, 
    la destinazione da cui ottenere messaggi (destinationLookup)
    se il broker (AppContainer che fornisce i servizi di smistamento) deve memorizzare i messaggi (subscriptionDurability)
    e il tipo di struttura(destinationType) */
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic1"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic1"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic1"),
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
            /*Otteniamo dal messaggio la proprietà nomeNegozio e facciamo una ricerca in DB */
            Negozio n=ejb.printByName(message.getStringProperty("nomeNegozio"));
            logger.info(logger.getName()+"messaggio ricvuto sulla Topic1");
            /*aggiorniamo la quantita di birra venduta dewrappando l'oggetto nel corpo del messaggio */
            Double newValue = n.getBirra();
            newValue+=message.getBody(Double.class);
            n.setBirra(n.getBirra()+message.getBody(Double.class));
            ejb.updateNegozio(n);
            /*creiamo un nuovo messaggio per avvisate chi ascolta la topic2 che la birra venduta è stata aggiornata*/
            String messaggio=n.getNome()+" ha aggiunto "+message.getBody(Double.class);
            jmsContext.createProducer().send(topic2, messaggio);
            logger.info(logger.getName() + "Messaggio inviato sulla Topic 2");
            
        } catch (JMSException ex) {
            Logger.getLogger(TopicMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
