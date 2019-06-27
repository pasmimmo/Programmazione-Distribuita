/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenico.utilita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 *
 * @author Pasmi
 */
public class UserInteraction {

    static final Logger logger = Logger.getLogger("global");
    private BufferedReader reBuff; 
    
    public UserInteraction(){
        reBuff= new BufferedReader(new InputStreamReader(System.in));
    }
    public String ask(String s) throws IOException {
        System.out.print(s + ":\n>>");
        return reBuff.readLine();
    }

    public void copyRight(String s) throws InterruptedException {
        newLine();
        System.out.println("");
        System.out.println("#\t\t\t\t\t\t\t\t#");
        System.out.println("#\t\t\t Copyright 2016 \t\t\t#");
        System.out.println("#\t\t\tDomenico Pascucci \t\t\t#");
        System.out.println("#\t\t\t\t\t\t\t\t#");
        newLine();
        System.out.println("\n\n");
        System.out.print(">>Caricamento del programma " + s.toUpperCase() + " in corso...");
        waitingLine(3);
    }

    /**
     * Stamp a line of #<hr> line is intended of 65 character
     */
    public void newLine() {
        for (int i = 0; i <= 64; i++) {
            System.out.print("#");
        }
    }

    /**
     * prints a series of characters " ..." to the 1000ms time intervals
     *
     * @param i series of character to stamp
     * @throws InterruptedException
     */
    public synchronized void waitingLine(int i) throws InterruptedException {
        for (int j = 0; j < i; j++) {
            this.wait(1000);
            System.out.print(" ...");
        }
        System.out.println("");
    }

    /**
     *
     * @param commands
     * @return
     * @throws IOException
     */
    public String commandList(String commands[]) throws IOException {
        newLine();
        System.out.println("\nElenco Comandi:");
        for (int i = 0; i < commands.length; i++) {
            System.out.println("-"+commands[i]);
        }
        return ask("effettuare una scelta");
    }
}
