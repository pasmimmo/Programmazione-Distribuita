/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {        
        Context ctx = new InitialContext();
        EJBRemote bejb = (EJBRemote) ctx.lookup("java:global/PasticcerieEE/EJB");
        System.out.println(bejb.ciao("mimmo"));
        System.out.println(bejb.findByName("daPeppe"));
        List<String> riultati=bejb.getAll();
        for ( String temp: riultati)
            System.out.println(temp);
        
        
    }
    
}
