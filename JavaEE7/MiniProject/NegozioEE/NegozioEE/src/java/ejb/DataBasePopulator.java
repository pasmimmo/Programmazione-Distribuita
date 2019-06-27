/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author pasmimmo
 */
@Singleton @Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/NegozioDS",
        user = "app", password = "app",
        databaseName = "MouseDB",
        properties = {"connectionAttributes=; create=true"})
public class DataBasePopulator {
    
    @Inject
    NegozioEJB mouse;
    
    @PostConstruct
    private void populate(){
        Mouse m1 = new Mouse("razor", "ottico", 40f);
        Mouse m2 = new Mouse("logitech", "pallina", 4f);
        
        mouse.create(m1);
        mouse.create(m2);
    }
    
}
