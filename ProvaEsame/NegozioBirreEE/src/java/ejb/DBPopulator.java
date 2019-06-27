/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Enterprise Java Bean che aspetta un messaggio, anche chiamato MessageDriven Bean
 * quando un messaggio viene ricevuto su 
 * @author pasmimmo
 */
@Singleton @Startup
@DataSourceDefinition(name = "jdbc/EsameDS", className = "org.apache.derby.jdbc.EmbeddeDataSource",
        databaseName = "EsameDB",user = "app", password = "app")
// @updated Aggiunti i parametri del DataSource
public class DBPopulator {
    @Inject
    NegozioEJB ejb;
    @Inject @LoggerInjectable
    private Logger logger;
    
    @PostConstruct
    public void populate(){
        Negozio n1,n2,n3;
        n1 = new Negozio("BeviBene", "John Budweiser", 430015d, 132210d, "Napoli", "Napoli", "Campania");
        n2= new Negozio("BirraESaiCosaBevi", "Nanni Moretti", 640000d, 212133d, "Roma", "Roma", "Lazio");
        n3 = new Negozio("BirreOggi", "Pasquale Poretti", 345941d, 615231d, "Cernusco", "Milano", "Lombardia");
        ejb.createNegozio(n1);
        ejb.createNegozio(n2);
        ejb.createNegozio(n3);
        logger.info(logger.getName()+"DB Popolato");
        //@updated Aggiunta solo una stampa per informare della popolazione del DB
    }
}
