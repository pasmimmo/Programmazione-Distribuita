/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
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
@DataSourceDefinition(name = "java:global/jdbc/MolecoleDS",
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        user = "app", password = "app", databaseName = "MolecoleDB"
        )
public class DBPopulator {
    @Inject
    MolecolaEJB molecolaEJB;
    Molecola m1, m2;
    
    @PostConstruct
    private void populate(){
        m1= new Molecola("caffeina", "vegetale");
        m2= new Molecola("teina", "animale");
        molecolaEJB.createMolecola(m1);
        molecolaEJB.createMolecola(m2);
    }
    
}
