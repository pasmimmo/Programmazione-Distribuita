/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.dp.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pasmi
 */
public interface Factory extends Remote{
    Hello createHello(String from) throws RemoteException;
}
