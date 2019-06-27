/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnable;

import java.util.Scanner;

/**
 *
 * @author pasmimmo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Benvenuto nel client per il cambio direttore\n"
                + "inserisci il nome del vecchio direttore: ");
        String oldName=in.nextLine();
        System.out.println("adesso, inserisci il nuovo direttore: ");
        String newName=in.nextLine();
        cambioDirettore(oldName, newName);
        System.out.println("Aggiornamento Effettuato");
    }

    private static void cambioDirettore(java.lang.String oldDirectorName, java.lang.String newDirectorName) {
        ejb.NegozioEJBService service = new ejb.NegozioEJBService();
        ejb.NegozioWS port = service.getNegozioWSPort();
        port.cambioDirettore(oldDirectorName, newDirectorName);
    }
    
}
