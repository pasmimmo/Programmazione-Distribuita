/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pd.dp.adapter.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pasmimmo
 * interfaccia pubblica
 */
public interface Counter extends Remote {

    /**
     *
     * @param from
     * @return
     * @throws RemoteException
     */
    int getValue(String from) throws RemoteException;

    void sum(String from, int valore) throws RemoteException;
}
