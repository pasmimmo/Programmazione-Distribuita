/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;

/**
 * Producer di un Logger Custom, che può essere iniettato ovunque seguendo le regole del
 * Context and Dependecy Injection (CDI)
 * 
 * @author pasmimmo
 */
public class LoggerProducer {
    /*si può notare la qualificazione del logger 
    (il @LoggerInjectable, nome mio non di JavaEE) che va a collegare (binding), questa classe
    al qualificatore*/
    
    @Produces @LoggerInjectable
    Logger logger;

    public LoggerProducer() {
        this.logger = Logger.getLogger("BirreAdminLog----> ");
    }
}
