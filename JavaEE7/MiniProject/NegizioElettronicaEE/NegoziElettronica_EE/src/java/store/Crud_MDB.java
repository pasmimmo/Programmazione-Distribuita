/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author amori
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Store/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class Crud_MDB implements MessageListener {
    
    @Inject
    StoreEJB storeEJB;
    
    public Crud_MDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            Store store = message.getBody(Store.class);
            storeEJB.updateStore(store);
            System.out.println("ricevuto "+store);
            
        } catch (JMSException ex) {
            Logger.getLogger(Crud_MDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
