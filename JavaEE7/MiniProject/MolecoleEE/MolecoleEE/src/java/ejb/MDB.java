/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
 * @author pasmimmo
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Molecole/Queue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
})
public class MDB implements MessageListener {
    @Inject
    MolecolaEJB mejb;
    
    public MDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            Molecola tmp = message.getBody(Molecola.class);
                    if(message.getStringProperty("operation").equals("create")){
                        mejb.createMolecola(tmp);
                        System.out.println("creo");
                    }else
                    {
                        mejb.updateMolecola(tmp);
                        System.out.println("aggiorno");
                    }

        } catch (JMSException ex) {
            Logger.getLogger(MDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
