package pd.lab.rmi.es2.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Hello2 extends Hello,Add{
	@Override
	String dimmiQualcosa(String userId)throws RemoteException;
	ArrayList<String> stampaLog() throws RemoteException;
	
}
