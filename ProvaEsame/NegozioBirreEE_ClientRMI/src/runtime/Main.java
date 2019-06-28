/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import ejb.Negozio;
import ejb.NegozioEJBRemote;
import java.util.List;
import java.util.Scanner;
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
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        NegozioEJBRemote ejb = (NegozioEJBRemote) ctx.lookup("java:global/NegozioBirreEE/NegozioEJB!ejb.NegozioEJBRemote");
        System.out.println("Stampiamo tutti i negozi di una regione:\n\n");
        System.out.println("Inserisci una regione: ");
        Scanner input = new Scanner(System.in);
        String regione = input.nextLine();
        List<Negozio> risultati = ejb.printByRegion(regione);
        for (Negozio temp:risultati)
        {
            System.out.println(temp);
        }
        System.out.println("\n*******************************************************\n"
                + "invece adesso stampo l'elenco di tutti i negozi da ubriaconi:\n");
        risultati = ejb.printDrunkPeopleShops();
        for (Negozio temp:risultati)
        {
            System.out.println("\t"+temp+"\n*******");
        }
        
        
    }
    
}
