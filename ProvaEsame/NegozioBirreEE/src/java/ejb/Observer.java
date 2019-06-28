/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Classe che osserva un evento e quando accade effettua delle operazioni
 * come la stampa nel terminale dell'AppContainer della modifica
 * @author pasmimmo
 */
public class Observer{
    @Inject @LoggerInjectable
    private Logger logger;
    
    public void init(@Observes Negozio negozio){
        StringBuilder builder = new StringBuilder();
        builder.append(logger.getName()).append(" direttore di: ").append(negozio.getNome())
                .append(" cambiato in: ").append(negozio.getDirettore());
        logger.warning(builder.toString());
    }
}
