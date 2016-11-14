/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd.dp.adapter.server;

/**
 *
 * @author Pasmimmo
 */
public class LocalCounter {

    //Costruttore
    public LocalCounter(int v) {
        value = v;
    }

    /**
     * metodo thread-safe per la lettura del contatore
     * il volore attuale del contatore
     */
    public synchronized int localGetValue() {
        return value;
    }

    //incrementa il contatore
    /**
     * Incrementa di uno il contatore
     */
    protected synchronized void increment() {
        value++;
    }
    /**
     * Variabile d'istanza locale, di tipo intero che memorizza il contenuto del contatore<hr>
     * é possibile accedervi con i metodi:<br>localGetValue()<br>increment()
     */
    private int value;
}
