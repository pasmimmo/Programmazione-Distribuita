/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;

/**
 *
 * @author pasmimmo
 */
public class LoggerProducer {
    @Produces @LoggerInjectable
    Logger logger;

    public LoggerProducer() {
        this.logger = Logger.getLogger("BirreAdminLog----> ");
    }
}
