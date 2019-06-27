/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import ejbdata.ViaggioEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author pasmimmo
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/ViaggiDS",
        user = "app", password = "app",
        databaseName = "ViaggiDB2",
        properties = {"connectionAttributes=;create=true"}
)
public class DataBasePopulator {
    
    @Inject
    private ViaggioEJB viaggioEJB;
    private Viaggio seychelles, corfu, cortina;
    
    @PostConstruct
    private void populateDB() {
        seychelles = new Viaggio("Seychelles", "mare", 500d, 10, 10);
        corfu = new Viaggio("Corfu", "mare", 200d, 20, 0);
        cortina = new Viaggio("Cortina", "montagna", 700d, 30, 20);
        viaggioEJB.creaViaggio(corfu);
        viaggioEJB.creaViaggio(cortina);
        viaggioEJB.creaViaggio(seychelles);
    }
    
    @PreDestroy
    private void clearDB() {
    }
}
