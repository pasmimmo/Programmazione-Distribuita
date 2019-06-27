/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import ejb.HelloWorldRemote;
import javax.naming.*;

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
        Context ctx;
        ctx = new InitialContext();
        String nome = "Mimmo";
        System.out.println("Connessione al server in corso...");
        HelloWorldRemote hello = (HelloWorldRemote) ctx.lookup("java:global/HelloWorld_EJB/HelloWorld");
        System.out.println(hello.sayHello(nome));
    }

}
