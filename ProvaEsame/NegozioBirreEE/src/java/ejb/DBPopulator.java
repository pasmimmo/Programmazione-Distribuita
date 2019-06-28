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
 * DataBase Populator che scrive 3 entità nel Database dopo il deploy (annotazione @Startup), 
 * si tratta di una classe singleton(@Singleton) di cui l'ApplicationContainer(payara) non deve creare
 * istanze multiple per evitare problemi di interferenza/consistenza dei dati.
 * @author pasmimmo
 */
@Singleton @Startup
@DataSourceDefinition(name = "jdbc/EsameDS", className = "org.apache.derby.jdbc.EmbeddeDataSource",
        databaseName = "EsameDB",user = "app", password = "app")
public class DBPopulator {
    /*Qua verrà iniettato, mediante CDI, un oggetto NegozioEJB, che tra i vari compiti,
    ha la gestione dei metodi CRUD mediante uso di EntityManager*/
    @Inject
    NegozioEJB ejb;
    //InjectionPoint di un logger custom di cui ho creato un qualificatore @LoggetInjectable
    @Inject @LoggerInjectable
    private Logger logger;
    //Metodo che viene eseguito dopo l'instanziazione del bean da parte dell'ApplicationContainer (Payara)
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
    }
}
