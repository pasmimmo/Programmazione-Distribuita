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
        // TODO code application logic here
        
        Context ctx = new InitialContext();
        NegozioEJBRemote m;
        m = (NegozioEJBRemote) ctx.lookup("java:global/NegozioEE/NegozioEJB!ejb.NegozioEJBRemote");
        
        List<Mouse> listaMouse = m.getAll();
        for(Mouse mouse: listaMouse)
            System.out.println(mouse.toString());
        
        List<Mouse> listaMaxPrice = m.maxPrice(10f);
        for(Mouse mouse: listaMaxPrice)
            System.out.println(mouse.toString());
        
        
        System.out.println(m.findByName("razor"));
            
            }
    
    
    
}
