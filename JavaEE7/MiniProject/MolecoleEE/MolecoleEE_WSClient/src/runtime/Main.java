/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.util.List;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<ejb.Molecola> ris = elencoCompleto();
        
        System.out.println(elencoCompleto().toString());
        for (ejb.Molecola temp: ris){
            System.out.println(temp.getNome());
        }

    }
        /*WS Method*/
        
    private static java.util.List<ejb.Molecola> elencoCompleto() {
        ejb.MolecolaEJBService service = new ejb.MolecolaEJBService();
        ejb.MolecolaEJB port = service.getMolecolaEJBPort();
        return port.elencoCompleto();
    }
    
}
