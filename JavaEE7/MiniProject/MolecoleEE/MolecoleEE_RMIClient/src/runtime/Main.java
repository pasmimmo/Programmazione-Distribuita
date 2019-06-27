/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import ejb.Molecola;
import ejb.MolecolaEJBRemote;
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
        Context context = new InitialContext();
        MolecolaEJBRemote mol = (MolecolaEJBRemote) context.lookup(""
                + "java:global/MolecoleEE/MolecolaEJB!ejb.MolecolaEJBRemote");
        List<Molecola> risultati=mol.getElencoCompleto();
        stampaArray(risultati);
        stampaArray(mol.cercaTipo("animale"));
        System.out.println(mol.cercaMolecola("teina"));     
        
    }
    public static void stampaArray(List<Molecola> lista){
        for (Molecola tmp:lista){
            System.out.println(tmp.toString());
        }
    }
}
