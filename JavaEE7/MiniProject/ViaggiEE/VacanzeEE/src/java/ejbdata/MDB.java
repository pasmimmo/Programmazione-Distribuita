/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

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
@MessageDriven(mappedName = "jms/Viaggi/Queue", 
        activationConfig = {
            @ActivationConfigProperty(propertyName = "acknowlegeMode", propertyValue = "Auto-acknowlege")
})
public class MDB implements MessageListener {

    @Inject
    ViaggioEJB viaggioEJB;

    public MDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            Viaggio viaggio = message.getBody(Viaggio.class);
            System.out.println("messaggio ricevuto");
            viaggioEJB.aggiornaViaggio(viaggio);
        } catch (JMSException ex) {
            Logger.getLogger(MDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
