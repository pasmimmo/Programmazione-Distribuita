package pd.rmi.helloserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;

/**
 *
 * @author Domenico
 */
public interface Hello extends java.rmi.Remote {

    String dimmiQualcosa(String name) throws RemoteException;
}
