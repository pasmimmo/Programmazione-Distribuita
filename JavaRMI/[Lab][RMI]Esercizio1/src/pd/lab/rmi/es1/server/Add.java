package pd.lab.rmi.es1.server;
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
public interface Add extends java.rmi.Remote{
	int leggi() throws RemoteException;
	void aggiungi(int i) throws RemoteException;
}
