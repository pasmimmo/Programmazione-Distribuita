/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author amori
 */
@Startup
@Singleton
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/StoreDS",
        user = "app", password = "app",
        databaseName = "StoreDB",
        properties = {"connectionAttributes=; create=true"}
)
public class DBPopulator {
    @Inject
    StoreEJB storeEJB;
   
    private Store store1, store2, store3;
    @PostConstruct
    public void populate(    
){
        
        
        store1 = new Store(11, 15, "Napoli", "Napoli", "Italia", "Peppe", "daPeppe");
        store2 = new Store(13, 25, "Milano", "Milano", "Italia", "Gigi", "daGigi");
        store3 = new Store(10, 3, "Moiano", "Caudino", "NoWhere", "Nicola", "NickStore");
        
        storeEJB.addStore(store1);
        storeEJB.addStore(store2);
        storeEJB.addStore(store3);
    }
    
    @PreDestroy
    public void clearDB() {
        storeEJB.deleteStore(store1);
        storeEJB.deleteStore(store2);
        storeEJB.deleteStore(store3);
    }
}
